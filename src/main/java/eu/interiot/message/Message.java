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

import eu.interiot.message.exceptions.MessageException;
import eu.interiot.message.exceptions.metadata.EmptyMetadataException;
import eu.interiot.message.exceptions.payload.EmptyPayloadException;
import eu.interiot.message.managers.URI.URIManager;
import eu.interiot.message.managers.URI.URIManagerGOIoTP;
import eu.interiot.message.managers.URI.URIManagerGOIoTPex;
import eu.interiot.message.managers.URI.URIManagerMessageMetadata;
import eu.interiot.message.payload.GOIoTPPayload;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.WriterDatasetRIOT;
import org.apache.jena.riot.system.RiotLib;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * A wrapper for any JSON-LD message.
 */
public class Message {
    //This rdfsSchema is for testing purposes only
//    private static final Model rdfsSchema;

//    static {
//        rdfsSchema = ModelFactory.createDefaultModel();
//        rdfsSchema.add(
//                rdfsSchema.createResource(uriPrefixMap.get("ssn") + "Sensor"),
//                RDFS.subClassOf,
//                rdfsSchema.createResource(uriPrefixMap.get("ssn") + "Device"));
//    }

//    /**
//     * A model to store any extra information that allows to treat the message as a typped message.
//     * For instance: in order to make a message a DeviceMessage, this model should contain
//     * the attribute with the device identifier. This identifier will be used by the methods
//     * of the DeviceMessage class.
//     */
//    Model jenaTypeModel = ModelFactory.createDefaultModel();
    /**
     * The main dataset with all the Message graphs, in particular the payload and metadata graphs
     */
    private Dataset jenaDataset = DatasetFactory.create();
    //    private Model payloadModel;
    private MessagePayload payload;
    private MessageMetadata metadata;

    private MessageConfig messageConfig;

    public Message() {
        this(new MessageConfig());
    }

    public Message(MessageConfig messageConfig) {
        this.messageConfig = messageConfig;
        setDefaultJenaPrefixes();
        metadata = new MessageMetadata();
        payload = new MessagePayload();

        if (messageConfig.isInitializeNewMessage())
            metadata.initializeMetadata();

        jenaDataset.addNamedModel(messageConfig.getURImessageMetadataGraph(), metadata.getJenaModel());
        jenaDataset.addNamedModel(messageConfig.getURImessagePayloadGraph(), payload.getJenaModel());
    }

    public Message(String messageStr) throws IOException, MessageException {
        this(messageStr, new MessageConfig());
    }

    public Message(String messageStr, MessageConfig messageConfig) throws IOException, MessageException {
        this.messageConfig = messageConfig;
        //Set prefixes as declared in the static prefix map
        setDefaultJenaPrefixes();

        //Read multigraph from json-ld into dataset
        readDatasetFromJSONLD(messageStr);
        //TODO: Should we accept messages with no metadata graph?
        //Read metadata from message
        if (jenaDataset.containsNamedModel(messageConfig.getURImessageMetadataGraph())) {
            metadata = new MessageMetadata(jenaDataset.getNamedModel(messageConfig.getURImessageMetadataGraph()));
        } else if (messageConfig.isRequireMetadataGraph()) {
            throw new EmptyMetadataException("The message has no metadata graph i.e. a graph with id " + messageConfig.getURImessageMetadataGraph());
        } else {
            metadata = new MessageMetadata();
            jenaDataset.addNamedModel(messageConfig.getURImessageMetadataGraph(), metadata.getJenaModel());
        }

        //Read payload from message
        if (jenaDataset.containsNamedModel(messageConfig.getURImessagePayloadGraph())) {
            payload = new MessagePayload(jenaDataset.getNamedModel(messageConfig.getURImessagePayloadGraph()));
//        payloadModel = jenaDataset.getNamedModel(URImessagePayloadGraph);
        } else if (messageConfig.isRequirePayloadGraph()) {
            throw new EmptyPayloadException("The message has no payload graph i.e. a graph with id " + messageConfig.getURImessagePayloadGraph());
        } else {
            payload = new MessagePayload();
            jenaDataset.addNamedModel(messageConfig.getURImessagePayloadGraph(), payload.getJenaModel());
        }
    }

    private void readDatasetFromJSONLD(String jsonLdString) {
        InputStream inStream = new ByteArrayInputStream(jsonLdString.getBytes());
        RDFDataMgr.read(jenaDataset, inStream, Lang.JSONLD);
        //TODO: RDFManager read with org.apache.jena.sparql.util.Context to manage JSON-LD context
    }

    private String writeDatasetToJSONLD() {
        //The checks for graph existence here are necessary, because if any of them were empty during loading,
        //they were not created in the dataset. Consequently, if the metadata or payload were modified after loading,
        //this change would not be propagated to the dataset. This is important, because we allow empty payloads.
//        if (!jenaDataset.containsNamedModel(messageConfig.getURImessagePayloadGraph()))
//            jenaDataset.addNamedModel(messageConfig.getURImessagePayloadGraph(), payload.getJenaModel());
//        if (!jenaDataset.containsNamedModel(messageConfig.getURImessageMetadataGraph()))
//            jenaDataset.addNamedModel(messageConfig.getURImessageMetadataGraph(), metadata.getJenaModel());
        setMetadata(metadata);
        setPayload(payload);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        WriterDatasetRIOT datasetWriter = RDFDataMgr.createDatasetWriter(getMessageConfig().getRdfDatasetSerializationFormat());

        datasetWriter.write(outStream,
                jenaDataset.asDatasetGraph(),
                RiotLib.prefixMap(jenaDataset.asDatasetGraph()),
                null,
                getMessageConfig().getJsonLDWriteContext()
        );
//
//        RDFDataMgr.write(outStream, jenaDataset, Lang.JSONLD);

        return outStream.toString();
    }

    private void setDefaultJenaPrefixes() {
//        URIManager.uriPrefixMap.forEach((k, v) -> jenaDataset.getDefaultModel().setNsPrefix(k, v));
//        jenaDataset.getDefaultModel().setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        setPrefix("msg", URIManagerMessageMetadata.PREFIX.InterIoTMsg);
        setPrefix("InterIoT", URIManager.PREFIX.InterIoT);

        setPrefix("ssn", URIManagerGOIoTP.PREFIX.ssn);
        setPrefix("sosa", URIManagerGOIoTP.PREFIX.sosa);
        setPrefix("iiot", URIManagerGOIoTP.PREFIX.iiot);
        setPrefix("iiotex", URIManagerGOIoTPex.PREFIX.iiotex);
        setPrefix("geosparql", URIManagerGOIoTP.PREFIX.geosparql);
    }

    /**
     * Sets a prefix used in JSON-LD serialization.
     * This has no bearing on the meaning of the message, only on readibility of serialization.
     *
     * @param prefix    A namespace prefix, e.g. "iiot"
     * @param namespace A URI namespace e.g. "http://inter-iot.eu/GOIoTP#"
     */
    public void setPrefix(String prefix, String namespace) {
        jenaDataset.getDefaultModel().setNsPrefix(prefix, namespace);
    }

    /**
     * Returns prefixes used in JSON-LD serialization.
     *
     * @return
     */
    public Map<String, String> getPrefixes() {
        return jenaDataset.getDefaultModel().getNsPrefixMap();
    }

    /**
     * Removes a prefix used in JSON-LD serialization.
     *
     * @param prefix
     * @return True, if the prefix was present in the prefix map
     */
    public boolean removePrefix(String prefix) {
        boolean hasPrefix = getPrefixes().containsKey(prefix);
        jenaDataset.getDefaultModel().removeNsPrefix(prefix);
        return hasPrefix;
    }

    /**
     * Returns the Jena model for payload. Use only, if you know what to do with it.
     *
     * @return
     */
    Model getPayloadModel() {
        return payload.getJenaModel();
    }

    /**
     * Returns the Jena model for metadata. Use only, if you know what to do with it.
     *
     * @return
     */
    Model getMetadataModel() {
        return metadata.getJenaModel();
    }


    public MessageMetadata getMetadata() {
        return metadata;
    }

//    public PlatformMessageMetadata getMetadataAsPlatformMessageMetadata() {
//        PlatformMessageMetadata newMeta = new PlatformMessageMetadata(metadata);
//        setMetadata(newMeta);
//        return newMeta;
//    }

    public void setMetadata(MessageMetadata metadata) {
        //TODO: Test linking metadata models to the dataset
        this.metadata = metadata;
        Model jenaModel = ModelFactory.createDefaultModel().add(metadata.getJenaModel());
//        Model oldModel = jenaDataset.getNamedModel(messageConfig.getURImessageMetadataGraph());
        //Possible Jena bug: replaceNamedModel clears the model, if the contents of old and new models are the same
        jenaDataset.replaceNamedModel(messageConfig.getURImessageMetadataGraph(), jenaModel);
    }

    public MessagePayload getPayload() {
        return payload;
    }

    public void setPayload(MessagePayload payload) {
        this.payload = payload;
        Model jenaModel = ModelFactory.createDefaultModel().add(payload.getJenaModel());
        //Possible Jena bug: replaceNamedModel clears the model, if the contents of old and new models are the same
        jenaDataset.replaceNamedModel(messageConfig.getURImessagePayloadGraph(), jenaModel);
        jenaDataset.commit();
    }

    public GOIoTPPayload getPayloadAsGOIoTPPayload() {
        return new GOIoTPPayload(getPayload());
    }

    /**
     * Creates a string with message in JSON-LD format
     *
     * @return
     * @throws IOException
     */
    public String serializeToJSONLD() throws IOException {
        return writeDatasetToJSONLD();
    }

    /**
     * @return Instance of a MessageConfig assigned to this Message. MessageConfig can be assigned when creating a message.
     * (A MessageConfig is  passed as an argument in some Message constructor overloads).
     */
    public MessageConfig getMessageConfig() {
        return messageConfig;
    }
}
