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
    import eu.interiot.message.MessagePayload;
    import eu.interiot.message.PropertyID;
    import eu.interiot.message.utils.MessageModelUtils;
    import org.apache.jena.rdf.model.Model;
    import org.apache.jena.rdf.model.Resource;

    import java.util.Set;

    /**
     * A Payload that is centered around some single instance e.g. a Device, a Platform, an Observation, etc.
     * The instance can be of any type.
     */
    public class InstancePayload extends MessagePayload {

        private EntityID instanceID;

        /**
         * * Creates a new empty payload
         *
         * @param instanceId Identifier of an instance of a resource
         */
        public InstancePayload(EntityID instanceId) {
            this(instanceId, false);
        }

        /**
         * * Creates a new empty payload
         *
         * @param instanceId        Identifier of an instance of a resource
         * @param useRDFSInferencer If true, the underlying model will use RDFS Inferencer to reason about taxonomy of payload types.
         *                          Using an inferencer is a bit slower, but it can have noticable impact if you use (or measure) thousands of messages at once.
         */
        public InstancePayload(EntityID instanceId, boolean useRDFSInferencer) {
            super(useRDFSInferencer);
            setInstanceId(instanceId);
        }

        /**
         * Makes a new instance payload from an existing payload model.
         * WARNING: The model does not need to contain the instance with instanceID. Make sure that the instanceId is correct.
         * If the instance with given Id does not exist in the model, it will not have any property assertions, and the getters will (initially, before using setters) return null.
         *
         * @param instanceId Identifier of an instance of a resource
         * @param jenaModel  A Jena model
         */
        public InstancePayload(EntityID instanceId, Model jenaModel) {
            this(instanceId, jenaModel, false);
        }

        /**
         * Makes a new instance payload from an existing payload model.
         * WARNING: The model does not need to contain the instance with instanceID. Make sure that the instanceId is correct.
         * If the instance with given Id does not exist in the model, it will not have any property assertions, and the getters will (initially, before using setters) return null.
         *
         * @param instanceId        Identifier of an instance of a resource
         * @param jenaModel         A Jena model
         * @param useRDFSInferencer If true, the underlying model will use RDFS Inferencer to reason about taxonomy of payload types.
         *                          Using an inferencer is a bit slower, but it can have noticable impact if you use (or measure) thousands of messages at once.
         */
        public InstancePayload(EntityID instanceId, Model jenaModel, boolean useRDFSInferencer) {
            super(jenaModel, useRDFSInferencer);
            setInstanceId(instanceId);
        }

        public void setInstanceId(EntityID instanceId) {
            this.instanceID = instanceId;
        }

        public Resource getInstance() {
            return instanceID.getJenaResource();
        }

        public EntityID getInstanceID() {
            return instanceID;
        }

        @Deprecated
        public Set<String> getObjectsForProperty(PropertyID property) {
            return MessageModelUtils.getStringObjectsFromStatements(
                    MessageModelUtils.getResourceStatements(
                            getJenaModel(),
                            instanceID.toString(),
                            property.toString(),
                            null).toSet());
        }

        //TODO: Safely remove this method
        @Deprecated
        public Set<String> getProperties() {
            return MessageModelUtils.getStringPredicatesFromStatements(
                    MessageModelUtils.getResourceStatements(
                            getJenaModel(),
                            instanceID.toString(),
                            null,
                            null).toSet());
        }

        public boolean hasProperty(PropertyID property) {
            return !getObjectsForProperty(property).isEmpty();
        }

        public void addResourceProperty(PropertyID property, EntityID resourceId) {
            MessageModelUtils.addResourceStatement(
                    getJenaModel(),
                    instanceID.toString(),
                    property.toString(),
                    resourceId.toString());
        }

        public void addLiteralProperty(PropertyID property, String literalValue) {
            MessageModelUtils.addLLiteralStatement(
                    getJenaModel(),
                    instanceID.toString(),
                    property.toString(),
                    literalValue);
        }

        //TODO: Add remove property object and remove all property objects

//    public Set<String> getPropertyValues(String propString) {
//        return extractStatements(
//                URI.create(instanceId),
//                URI.create(propString),
//                null)
//                .toList()
//                .stream()
//                .map(x -> x.getObject().toString())
//                .collect(Collectors.toSet());
//    }
//
//    public Set<String> getInstanceTypes() {
//        return getPropertyValues(propertiesUriMap.get("type"));
//    }
//
//    public boolean isOfInstanceType(String type) {
//        return getPropertyValues(propertiesUriMap.get("type")).contains(type);
//    }
//
//    public String getInstanceId() {
//        return instanceId;
//    }
//
//    public void setInstanceId(String instanceId) {
//        this.instanceId = instanceId;
//    }


    }
