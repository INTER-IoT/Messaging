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


package eu.interiot.message;

import eu.interiot.message.payloadTypes.DevicePayload;
import eu.interiot.message.utils.MessageModelUtils;
import org.apache.jena.rdf.model.*;

/**
 * A container for Inter-IoT {@Link Message Message} payload.
 */
public class MessagePayload {


    /**
     * This model should contain any RDFS inferencing information required for proper payload parsing and operation
     */
    public static final Model rdfsSchema;

    static {
        rdfsSchema = ModelFactory.createDefaultModel();
    }

    private Model jenaModel;
    private boolean useRDFSInferencer;

    /**
     * Creates a new empty payload
     */
    public MessagePayload() {
        this(false);
    }

    /**
     * Creates a new empty payload
     *
     * @param useRDFSInferencer If true, the underlying model will use RDFS Inferencer to reason about taxonomy of payload types.
     *                          Using an inferencer is a bit slower, but it can have noticable impact if you use (or measure) thousands of messages at once.
     */
    public MessagePayload(boolean useRDFSInferencer) {
        this.useRDFSInferencer = useRDFSInferencer;
        if (useRDFSInferencer) {
            jenaModel = ModelFactory.createRDFSModel(rdfsSchema, ModelFactory.createDefaultModel());
        } else {
            jenaModel = ModelFactory.createDefaultModel();
        }
    }

    /**
     * Makes a new payload from an existing payload model
     *
     * @param jenaModel A Jena model
     */
    public MessagePayload(Model jenaModel) {
        this(jenaModel, false);
    }

    /**
     * Makes a new payload from an existing metadata model
     *
     * @param jenaModel         A Jena model
     * @param useRDFSInferencer If true, the underlying model will use RDFS Inferencer to reason about taxonomy.
     *                          Using an inferencer is a bit slower, but it can have noticable impact if you use (or measure) thousands of messages at once.
     */
    public MessagePayload(Model jenaModel, boolean useRDFSInferencer) {
        this.useRDFSInferencer = useRDFSInferencer;
        if (useRDFSInferencer) {
            this.jenaModel = ModelFactory.createRDFSModel(rdfsSchema, jenaModel);
        } else {
            this.jenaModel = jenaModel;
        }
    }

    //TODO: Implement clone here and in subclasses of Payload

    /**
     * Returns the Jena model used internally to store metadata.
     * Use only if you know what you are doing, and how to use Jena models.
     *
     * @return
     */
    public Model getJenaModel() {
        return jenaModel;
    }

    //    public void getStatementsFromURIs(String Subject, String Predicate, String Object){
    //        //TODO: Convert parameter Strings to URIs with default URI base, or with a "matched" URI base?
    //        //This would require a list of default URI bases (namespaces) for URI fragments
    // extractStatementsFromURIs((URI) null, (URI) null, (URI) null);
    //    }

    @Deprecated
    public StmtIterator getResourceStatements(String subject, String predicate, String object) {
        return MessageModelUtils.getResourceStatements(jenaModel, subject, predicate, object);
    }

    @Deprecated
    public StmtIterator getLiteralStatements(String subject, String predicate, String literalValue) {
        return MessageModelUtils.getLiteralStatements(jenaModel, subject, predicate, literalValue);
    }

    @Deprecated
    public void addResourceStatement(String subject, String predicate, String object) {
        MessageModelUtils.addResourceStatement(jenaModel, subject, predicate, object);
    }

    @Deprecated
    public void addLiteralStatement(String subject, String predicate, String literalValue) {
        MessageModelUtils.addLLiteralStatement(jenaModel, subject, predicate, literalValue);
    }

    /**
     * Creates a Jena Resource from a String
     *
     * @param resourceUri A string with valid URI of a resource
     * @return
     */
    @Deprecated
    public Resource stringToResource(String resourceUri) {
        return jenaModel.createResource(resourceUri);
    }

    /**
     * Creates a Jena Property from a String
     *
     * @param propertyUri A string with valid URI of a property
     * @return
     */
    @Deprecated
    public Property stringtoProperty(String propertyUri) {
        return jenaModel.createProperty(propertyUri);
    }

    public boolean usesInferencer() {
        return useRDFSInferencer;
    }

    @Deprecated
    public DevicePayload asDevicePayload(String deviceId) {
        //TODO: Add overload of this that tries to guess the device ID
        //TODO: The useRDFSInferencer here may not be needed, but otherwise the value of the boolean field useRDFSInferencer is not updated correctly
        return new DevicePayload(new EntityID(deviceId), jenaModel, useRDFSInferencer);
    }

    public DevicePayload asDevicePayload(EntityID deviceId) {
        //TODO: Add overload of this that tries to guess the device ID
        //TODO: The useRDFSInferencer here may not be needed, but otherwise the value of the boolean field useRDFSInferencer is not updated correctly
        return new DevicePayload(deviceId, jenaModel, useRDFSInferencer);
    }
}