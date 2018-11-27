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


    package eu.interiot.message.payloadTypes;

    import eu.interiot.message.EntityID;
    import org.apache.jena.rdf.model.Model;

    public class DevicePayload extends InstancePayload {

        //TODO: Makre prefix management consistent
//    public static final Map<String, String> uriMap = ImmutableMap.<String, String>builder()
//            .put("typeDevice", URIManager.uriPrefixMap.get("ssn") + "Device")
//            .put("typeSensor", URIManager.uriPrefixMap.get("ssn") + "Sensor")
//            .put("platform", URIManager.uriPrefixMap.get("ssn") + "onPlatform")
//            .put("hasSubSystem", URIManager.uriPrefixMap.get("ssn") + "hasSubSystem")
//            .put("location", URIManager.uriPrefixMap.get("DUL") + "hasLocation")
////            .put("typeSensor", Message.uriPrefixMap.get("sensor") + "Sensor")
//            .build();

        /**
         * Creates a new payload with a device
         *
         * @param deviceId Identifier of an instance of a device
         */
        public DevicePayload(EntityID deviceId) {
            this(deviceId, false);
        }

        /**
         * Creates a new payload with a device
         *
         * @param deviceId          Identifier of an instance of a device
         * @param useRDFSInferencer If true, the underlying model will use RDFS Inferencer to reason about taxonomy of payload types.
         *                          Using an inferencer is a bit slower, but it can have noticable impact if you use (or measure) thousands of messages at once.
         */
        public DevicePayload(EntityID deviceId, boolean useRDFSInferencer) {
            super(deviceId, useRDFSInferencer);
        }

        /**
         * Makes a new device payload from an existing payload model.
         * WARNING: The model does not need to contain the instance with deviceId. Make sure that the deviceId is correct.
         * If the device with given Id does not exist in the model, it will not have any property assertions, and the getters will (initially, before using setters) return null.
         *
         * @param deviceId  Identifier of an instance of a device
         * @param jenaModel A Jena model
         */
        public DevicePayload(EntityID deviceId, Model jenaModel) {
            this(deviceId, jenaModel, false);
        }

        /**
         * Makes a new device payload from an existing payload model.
         * WARNING: The model does not need to contain the instance with deviceId. Make sure that the deviceId is correct.
         * If the device with given Id does not exist in the model, it will not have any property assertions, and the getters will (initially, before using setters) return null.
         *
         * @param deviceId          Identifier of an instance of a device
         * @param jenaModel         A Jena model
         * @param useRDFSInferencer If true, the underlying model will use RDFS Inferencer to reason about taxonomy of payload types.
         *                          Using an inferencer is a bit slower, but it can have noticable impact if you use (or measure) thousands of messages at once.
         */
        public DevicePayload(EntityID deviceId, Model jenaModel, boolean useRDFSInferencer) {
            super(deviceId, jenaModel, useRDFSInferencer);
        }

        //    public Set<String> getDevicePlatforms() {
//        return getPropertyValues(propertiesUriMap.get("platform"));
//    }
//
//    public boolean isASensor() {
//        return isOfInstanceType(propertiesUriMap.get("typeSensor"));
//    }

    }
