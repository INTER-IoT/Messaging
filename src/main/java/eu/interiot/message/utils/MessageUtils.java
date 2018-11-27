    /*
     * Copyright 2016-2018 Universitat Politècnica de València
     * Copyright 2016-2018 Università della Calabria
     * Copyright 2016-2018 Prodevelop, SL
     * Copyright 2016-2018 Technische Universiteit Eindhoven
     * Copyright 2016-2018 Fundación de la Comunidad Valenciana para la
     * Investigación, Promoción y Estudios Comerciales de Valenciaport
     * Copyright 2016-2018 Rinicom Ltd
     * Copyright 2016-2018 Association pour le développement de la formation
     * professionnelle dans le transport
     * Copyright 2016-2018 Noatum Ports Valenciana, S.A.U.
     * Copyright 2016-2018 XLAB razvoj programske opreme in svetovanje d.o.o.
     * Copyright 2016-2018 Systems Research Institute Polish Academy of Sciences
     * Copyright 2016-2018 Azienda Sanitaria Locale TO5
     * Copyright 2016-2018 Alessandro Bassi Consulting SARL
     * Copyright 2016-2018 Neways Technologies B.V.
     *
     * See the NOTICE file distributed with this work for additional information
     * regarding copyright ownership.
     *
     * Licensed under the Apache License, Version 2.0 (the "License");
     * you may not use this file except in compliance with the License.
     * You may obtain a copy of the License at
     *
     *     http://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     *
     */


    package eu.interiot.message.utils;

    import eu.interiot.message.EntityID;
    import eu.interiot.message.MessagePayload;
    import eu.interiot.message.URI.URIManagerGOIoTPex;
    import eu.interiot.message.URI.URIManagerMessageMetadata;
    import eu.interiot.message.exceptions.payload.IdentifierException;
    import org.apache.jena.atlas.lib.EscapeStr;
    import org.apache.jena.rdf.model.Model;
    import org.apache.jena.rdf.model.ModelFactory;
    import org.apache.jena.rdf.model.Resource;
    import org.apache.jena.vocabulary.RDF;

    import java.util.Set;
    import java.util.UUID;
    import java.util.stream.Collectors;

    /**
     * Utilities for any message
     */
    public class MessageUtils {

        //    private static String prefixDevice = "dev";
//    private static String prefixMetadata = "meta";
        private static String prefixMessage = "msg";
        private static String prefixConversation = "conv";
//    private static String prefixPlatform = "plat";
//    private static String prefixObservation = "obs";

        private static String getUUID() {
            return UUID.randomUUID().toString();
        }

        private static String getPrefixedUUID(String prefix) {
            return prefix + getUUID();
        }

        /**
         * Creates a new Model with a copy of all triples from parameter models
         *
         * @param models
         * @return
         */
        public static Model mergeModels(Model... models) {
            Model myModel = ModelFactory.createDefaultModel();
            for (Model m : models) {
                if (null != m)
                    myModel.add(m.listStatements().toList());
            }
            return myModel;
        }

        /**
         * Creates a new MessagePayload with the underlying Model containing a copy of all triples from parameter payloads
         *
         * @param payloads
         * @return
         */
        public static MessagePayload mergePayloads(MessagePayload... payloads) {
            Model myModel = ModelFactory.createDefaultModel();
            for (MessagePayload p : payloads) {
                if (null != p)
                    myModel.add(p.getJenaModel().listStatements().toList());
            }
            return new MessagePayload(myModel);
        }

        /**
         * Creates a new EntityID for a metadata instance.
         *
         * @return
         */
        public static EntityID generateMetadataID() {
            return new EntityID(URIManagerMessageMetadata.BASE.INSTANCE.Metadata + getUUID());
        }

        /**
         * * Creates a new EntityID for a device instance.
         *
         * @return
         */
        public static EntityID generateDeviceID() {
            return new EntityID(URIManagerMessageMetadata.BASE.INSTANCE.Device + getUUID());
        }

        /**
         * * Creates a new EntityID for an observation instance.
         *
         * @return
         */
        public static EntityID generateObservationID() {
            return new EntityID(URIManagerMessageMetadata.BASE.INSTANCE.Observation + getUUID());
        }

        /**
         * * Creates a new EntityID for a platform.
         *
         * @return
         */
        public static EntityID generatePlatformID() {
            return new EntityID(URIManagerMessageMetadata.BASE.INSTANCE.Platform + getUUID());
        }

        /**
         * * Creates a new String ID for a message.  The ID DOES NOT contain the URI base.
         *
         * @return
         */
        public static String generateMessageID() {
            return getPrefixedUUID(prefixMessage);
        }

        /**
         * * Creates a new ID for a conversation. The ID DOES NOT contain the URI base.
         *
         * @return
         */
        public static String generateConversationID() {
            return getPrefixedUUID(prefixConversation);
        }

        /**
         * Creates a new oldssn:Device resource in a MessagePayload with a generated ID.
         *
         * @param payload
         * @return The ID of the created Device resource with URI base
         */
        public static EntityID createDevice(MessagePayload payload) {
            return createDevice(payload, generateDeviceID());
        }

        /**
         * Creates a new oldssn:Device resource in a MessagePayload with a given EntityID.
         *
         * @param payload
         * @param deviceId The ID of the device. It should be a valid URI (e.g. http://example.com/device1)
         * @return
         */
        public static EntityID createDevice(MessagePayload payload, EntityID deviceId) {
            Model jenaModel = payload.getJenaModel();
            jenaModel.add(
                    deviceId.getJenaResource(),
                    RDF.type,
                    jenaModel.createResource(URIManagerGOIoTPex.TYPES.IoTDevice));
            return deviceId;
        }

        public static Set<EntityID> getDeviceIds(MessagePayload payload) {
            return payload.getJenaModel().listSubjectsWithProperty(RDF.type,
                    payload.getJenaModel().createResource(URIManagerGOIoTPex.TYPES.IoTDevice)
            ).toSet().stream().map(MessageUtils::unsafelyGetEntityIDFromResource).collect(Collectors.toSet());
        }

        /**
         * Creates an EntityID from a Resource and assumes that the Resource is NOT a Literal
         *
         * @param x
         * @return
         */
        private static EntityID unsafelyGetEntityIDFromResource(Resource x) {
            try {
                return new EntityID(x);
            } catch (IdentifierException e) {
                return new EntityID("");
            }
        }

//    public static Set<EntityID> getSensorIds(MessagePayload payload) {
//        return payload.getJenaModel().listSubjectsWithProperty(RDF.type,
//                payload.getJenaModel().createResource(DevicePayload.uriMap.get("typeSensor"))
//        ).toSet().stream().map(MessageUtils::unsafelyGetEntityIDFromResource).collect(Collectors.toSet());

//        return MessageModelUtils.getStringSubjectsFromStatements(
//                MessageModelUtils.getResourceStatements(
//                        payload.getJenaModel(),
//                        null,
//                        RDF.type.toString(),
//                        DevicePayload.uriMap.get("typeSensor"))
//                        .toSet());

        /**
         * Removes the default JSON-LD escaping from a string.
         * Also see {@link EscapeStr}
         *
         * @param str
         * @return
         */
        public static String unescapeJSONLDString(String str) {
            return EscapeStr.unescapeStr(str);
        }

//    public static boolean isDeviceRegistrationMessage(Message msg) {
//        //Put conditions for device registration message content here
//        return !MessageUtils.getDeviceIds(msg).isEmpty();
//    }
    }
