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

    package eu.interiot.message.metaTypes;

    import eu.interiot.message.EntityID;
    import eu.interiot.message.MessageMetadata;
    import eu.interiot.message.URI.URIManagerMessageMetadata.MESSAGEMETADATA;
    import eu.interiot.message.exceptions.payload.IdentifierException;
    import org.apache.jena.rdf.model.NodeIterator;
    import org.apache.jena.rdf.model.RDFNode;

    import java.util.*;
    import java.util.stream.Collectors;

    public class PlatformMessageMetadata extends MessageMetadata {

        /**
         * Creates a new {@Link PlatformMessageMetadata} PlatformMessageMetadata from {@Link MessageMetadata} MessageMetadata
         *
         * @param msgMetadata
         */
        public PlatformMessageMetadata(MessageMetadata msgMetadata) {
            jenaModel = msgMetadata.getJenaModel();
            metadataInstance = msgMetadata.getMetadataInstance();
        }

        public Optional<EntityID> getSenderPlatformId() {
            NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.SenderPlatformId));
            if (it.hasNext()) {
                RDFNode n = it.next();
                if (n.isResource()) {
                    try {
                        return Optional.ofNullable(new EntityID(n.asResource()));
                    } catch (IdentifierException e) {
//                    e.printStackTrace();
                    }
                }
            }
            return Optional.empty();
        }

        /**
         * Set the sender PlatformId
         * Even though any URIs are allowed, by convention they should start with a scheme identifier (e.g. http://).
         *
         * @param platformId
         */
        public void setSenderPlatformId(EntityID platformId) throws IllegalArgumentException {
            removeSenderPlatformId();
            jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.SenderPlatformId), platformId.getJenaResource());
        }

        /**
         * Returns a string with sender platformId or an empty string.
         *
         * @return
         */
        public String printSenderPlatformId() {
            Optional<EntityID> s = getSenderPlatformId();
            return s.map(x -> x.toString()).orElse("");
        }

        /**
         * Removes any sender PlatformId information from this metadata.
         */
        public void removeSenderPlatformId() {
            jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.SenderPlatformId), null);
        }

        /**
         * Returns all IDs of receiving platforms.
         *
         * @return
         */
        public Set<EntityID> getReceivingPlatformIDs() {
            NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ReceiverPlatformId));

            return it.toSet().stream().map(
                    x -> {
                        try {
                            return new EntityID(x.asResource());
                        } catch (IdentifierException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
            ).collect(Collectors.toSet());
        }

        /**
         * Substitutes the set of IDs of receiving platforms with a new set.
         *
         * @param receivingPlatformsIDs
         */
        public void setReceivingPlatformIDs(Set<EntityID> receivingPlatformsIDs) {
            jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ReceiverPlatformId), null);
            receivingPlatformsIDs.forEach(x -> addReceivingPlatformID(x));
        }

        /**
         * Returns all IDs of receiving platforms.
         *
         * @return
         */
        public Set<String> getReceivingPlatformIDsAsStrings() {
            return getReceivingPlatformIDs().stream().map(
                    x -> x.toString()
            ).collect(Collectors.toSet());
        }

        /**
         * Sets the receiving platform IDs to a single ID
         *
         * @param platformID
         */
        public void setReceivingPlatformID(EntityID platformID) {
            setReceivingPlatformIDs(new HashSet<EntityID>(Arrays.asList(platformID)));
        }

        /**
         * Adds a new platform ID to the receiving platforms IDs
         *
         * @param platformID
         */
        public void addReceivingPlatformID(EntityID platformID) {
            jenaModel.add(metadataInstance,
                    jenaModel.createProperty(MESSAGEMETADATA.ReceiverPlatformId),
                    jenaModel.createResource(platformID.toString()));
        }

        public void removeReceivingPlatformID(EntityID platformID) {
            jenaModel.removeAll(metadataInstance,
                    jenaModel.createProperty(MESSAGEMETADATA.ReceiverPlatformId),
                    jenaModel.createResource(platformID.toString()));
        }

        /**
         * Removes ALL receiving platform ID information from this metadata.
         */
        public void removeAllReceivingPlatformIDs() {
            jenaModel.removeAll(metadataInstance,
                    jenaModel.createProperty(MESSAGEMETADATA.ReceiverPlatformId),
                    null);
        }

        /**
         * Checks whether a given platform ID is on the list of receivers
         *
         * @param platformID
         * @return
         */
        public boolean hasReceivingPlatformID(EntityID platformID) {
            return getReceivingPlatformIDs().contains(platformID);
        }

        /**
         * Returns a formatted one-line string with all message types.
         *
         * @return
         */
        public String printReceivingPlatformIDs() {
            String result = "";
            Set<EntityID> s = getReceivingPlatformIDs();
            Iterator it = s.iterator();
            for (int i = 0; i < s.size(); i++) {
                if (i > 0) result += ", ";
                result += "<" + it.next().toString() + ">";
            }
            return result;
        }
    }
