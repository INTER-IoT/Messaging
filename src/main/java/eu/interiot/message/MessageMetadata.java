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

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.exceptions.metadata.MetadataException;
import eu.interiot.message.exceptions.payload.IdentifierException;
import eu.interiot.message.managers.URI.URIManagerMessageMetadata.MESSAGEMETADATA;
import eu.interiot.message.managers.URI.URIManagerMessageMetadata.MessageTypesEnum;
import eu.interiot.message.metadata.*;
import eu.interiot.message.utils.MessageUtils;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import javax.xml.bind.DatatypeConverter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A container for Inter-IoT {@Link Message Message} metadata.
 */
public class MessageMetadata {

    /**
     * This model should contain any RDFS inferencing information required for proper metadata parsing and operation
     */
    public static final Model rdfsSchema;

    static {
        rdfsSchema = ModelFactory.createDefaultModel();
        /**
         * Add taxonomy for metadata message types
         */
        for (MessageTypesEnum types : MessageTypesEnum.values()) {
            rdfsSchema.add(
                    rdfsSchema.createResource(types.toString()),
                    RDFS.subClassOf,
                    rdfsSchema.createResource(MESSAGEMETADATA.MetadataType));
        }
    }

    protected Model jenaModel;
    protected Resource metadataInstance;

    /**
     * Creates a new empty metadata object
     */
    public MessageMetadata() {
        this(false);
    }

    /**
     * Creates a new empty metadata object
     *
     * @param useRDFSInferencer If true, the underlying model will use RDFS Inferencer to reason about taxonomy of metadata types.
     *                          Using an inferencer is a bit slower, but it can have noticable impact if you use (or measure) thousands of messages at once.
     */
    public MessageMetadata(boolean useRDFSInferencer) {
        if (useRDFSInferencer) {
            jenaModel = ModelFactory.createRDFSModel(rdfsSchema, ModelFactory.createDefaultModel());
        } else {
            jenaModel = ModelFactory.createDefaultModel();
        }
        metadataInstance = addMetadataInstanceToModel(MessageUtils.generateMetadataID()).getJenaResource();
    }

    /**
     * Makes a new metadata object from an existing metadata model
     *
     * @param jenaModel This model should contain exactly one instance of type meta.
     *                  See the {@see #URIMetadataType} variable for exact URI (at time of writing it is "http://inter-iot.eu/message/meta").
     */
    public MessageMetadata(Model jenaModel) throws MetadataException {
        this(jenaModel, false);
    }

    /**
     * Makes a new metadata object from an existing metadata model
     *
     * @param jenaModel         This model should contain exactly one instance of type meta.
     *                          See the {@see #URIMetadataType} variable for exact URI (at time of writing it is "http://inter-iot.eu/message/meta").
     * @param useRDFSInferencer If true, the underlying model will use RDFS Inferencer to reason about taxonomy of metadata types.
     *                          Using an inferencer is a bit slower, but it can have noticable impact if you use (or measure) thousands of messages at once.
     */
    public MessageMetadata(Model jenaModel, boolean useRDFSInferencer) throws MetadataException {
        if (useRDFSInferencer) {
            this.jenaModel = ModelFactory.createRDFSModel(rdfsSchema, jenaModel);
        } else {
            this.jenaModel = jenaModel;
        }

        ResIterator it = jenaModel.listSubjectsWithProperty(RDF.type, jenaModel.createResource(MESSAGEMETADATA.MetadataType));
        if (it.hasNext()) {
            metadataInstance = it.next();
            if (it.hasNext()) {
                throw new MetadataException("The model in the argument contains more than one instance of type " + MESSAGEMETADATA.MetadataType + " (only one allowed)");
            }
        } else {
            throw new MetadataException("The model in the argument does not contain any instances of type " + MESSAGEMETADATA.MetadataType);
        }
    }

    private EntityID addMetadataInstanceToModel(EntityID metadataInstanceId) {
        jenaModel.add(metadataInstanceId.getJenaResource(), RDF.type, jenaModel.createResource(MESSAGEMETADATA.MetadataType));

        return metadataInstanceId;
    }

    /**
     * Sets the message ID, timestamp (with current time), and conversation ID for this metadata.
     * The IDs are pseudo-randomly generated.
     */
    public void initializeMetadata() {
        setDateTimeStamp(Calendar.getInstance());
        setMessageID(MessageUtils.generateMessageID());
        setConversationId(MessageUtils.generateConversationID());
    }

    //TODO: Implement clone(). Remember about Jena model type (RDFS inferencer, or not)

    /**
     * Returns the Jena model used internally to store metadata.
     * Use only if you know what you are doing, and how to use Jena models.
     *
     * @return
     */
    public Model getJenaModel() {
        return jenaModel;
    }

    public Resource getMetadataInstance() {
        return metadataInstance;
    }

    /**
     * @return The URI of the metadata individual contained in this MessageMetadata. This is not the same as MessageID
     */
    public EntityID getMetadataID() {
        try {
            return new EntityID(metadataInstance);
        } catch (IdentifierException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Deprecated
//    public StmtIterator getResourceStatements(String subject, String predicate, String object) {
//        return MessageModelUtils.getResourceStatements(jenaModel, subject, predicate, object);
//    }
//
//    @Deprecated
//    public StmtIterator getLiteralStatements(String subject, String predicate, String literalValue) {
//        return MessageModelUtils.getLiteralStatements(jenaModel, subject, predicate, literalValue);
//    }
//
//    @Deprecated
//    public void addResourceStatement(String subject, String predicate, String object) {
//        MessageModelUtils.addResourceStatement(jenaModel, subject, predicate, object);
//    }
//
//    @Deprecated
//    public void addLiteralStatement(String subject, String predicate, String literalValue) {
//        MessageModelUtils.addLLiteralStatement(jenaModel, subject, predicate, literalValue);
//    }

//    /**
//     * Returns statements about the metadata instance in this MessageMetadata
//     *
//     * @param predicate
//     * @param object
//     * @return
//     */
//    @Deprecated
//    public StmtIterator getResourceStatements(String predicate, String object) {
//        return getResourceStatements(getMetadataID().toString(), predicate, object);
//    }

//    /**
//     * Returns statements about the metadata instance in this MessageMetadata
//     *
//     * @param predicate
//     * @param literalValue
//     * @return
//     */
//    @Deprecated
//    public StmtIterator getLiteralStatements(String predicate, String literalValue) {
//        return getLiteralStatements(getMetadataID().toString(), predicate, literalValue);
//    }
//
//    /**
//     * Adds a statement about the metadata instance in this MessageMetadata
//     *
//     * @param predicate
//     * @param object
//     */
//    @Deprecated
//    public void addResourceStatement(String predicate, String object) {
//        addResourceStatement(getMetadataID().toString(), predicate, object);
//    }
//
//    /**
//     * Adds a statement about the metadata instance in this MessageMetadata
//     *
//     * @param predicate
//     * @param literalValue
//     */
//    @Deprecated
//    public void addLiteralStatement(String predicate, String literalValue) {
//        addLiteralStatement(getMetadataID().toString(), predicate, literalValue);
//    }

    public Optional<Calendar> getDateTimeStamp() {
        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.DateTimeStamp));
        if (it.hasNext()) {
            return Optional.ofNullable(DatatypeConverter.parseDateTime(it.next().asLiteral().getValue().toString()));
        } else {
            return Optional.empty();
        }
//        Calendar Cal = DatatypeConverter.parseDateTime("2011-07-12T16:20:02+02:00");
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        df.setTimeZone(TimeZone.getTimeZone("GMT"));
//        System.out.println(df.format(Cal.getTime()));
    }

    public void setDateTimeStamp(Calendar dateTimeStamp) {
        removeDateTimeStamp();

        jenaModel.addLiteral(getMetadataID().getJenaResource(),
                jenaModel.createProperty(MESSAGEMETADATA.DateTimeStamp),
                ResourceFactory.createTypedLiteral(DatatypeConverter.printDateTime(dateTimeStamp)));

//        MessageModelUtils.addLLiteralStatement(jenaModel,
//                getMetadataID().toString(),
//                MESSAGEMETADATA.DateTimeStamp,
//                DatatypeConverter.printDateTime(dateTimeStamp));
//        jenaModel.add(metadataInstance, jenaModel.createProperty(URIManager.URIMETAdateTimeStamp), jenaModel.createTypedLiteral(DatatypeConverter.printDateTime(dateTimeStamp)));
    }

    /**
     * Clears this metadata of all dateTimeStamp information.
     */
    public void removeDateTimeStamp() {
        jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.DateTimeStamp), null);
    }

    /**
     * @return A string with dateTimeStamp, or an empty string
     */
    public String printDateTimeStamp() {
        Optional<Calendar> calOp = getDateTimeStamp();
        if (calOp.isPresent()) {
            return calOp.get().getTime().toString();
        } else {
            return "";
        }
    }

    public Optional<String> getMessageID() {
        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.MessageID));
        if (it.hasNext()) {
            return Optional.ofNullable(it.next().asLiteral().getValue().toString());
        } else {
            return Optional.empty();
        }
    }

    /**
     * Sets the ID attribute (property) of this Message. This is NOT the same as setting the metadata individual EntityID.
     * The messageID can be any String, while metadata EntityID is an URI that is used internally in a MessageMetadata.
     * If unsure, use messageID, and not metadata EntityID.
     *
     * @param messageID
     */
    public void setMessageID(String messageID) {
        removeMessageID();
        jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.MessageID), jenaModel.createTypedLiteral(messageID));
    }

    /**
     * Clears this metadata of all message ID information.
     */
    public void removeMessageID() {
        jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.MessageID), null);
    }

    /**
     * @return A string with dateTimeStamp, or an empty string
     */
    public String printMessageID() {
        Optional<String> messageIDOp = getMessageID();
        if (messageIDOp.isPresent()) {
            return messageIDOp.get();
        } else {
            return "";
        }
    }

    /**
     * Returns all metadata message types.
     * Note that any message metadata is ALWAYS at least of type "meta".
     *
     * @return
     */
    public Set<MessageTypesEnum> getMessageTypes() {
        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, RDF.type);
        Set<MessageTypesEnum> s = it.toSet().stream().map(
                x -> MessageTypesEnum.fromString(x.toString())
        ).collect(Collectors.toSet());
        s.remove(MessageTypesEnum.META);
        return s;
    }

    /**
     * Substitutes the message types for the ones in the messageTypes parameter.
     *
     * @param messageTypes
     */
    public void setMessageTypes(Set<MessageTypesEnum> messageTypes) {
        jenaModel.removeAll(metadataInstance, RDF.type, null);
        addMessageType(MessageTypesEnum.META);
        messageTypes.forEach(x -> addMessageType(x));
    }

    /**
     * Returns all metadata message types.
     * Note that any message metadata is ALWAYS at least of type "meta".
     *
     * @return
     */
    public Set<String> getMessageTypesAsStrings() {
        return getMessageTypes().stream().map(
                x -> x.toString()
        ).collect(Collectors.toSet());
    }

    /**
     * Substitutes the message types for the one in the messageType parameter.
     *
     * @param messageType
     */
    public void setMessageType(MessageTypesEnum messageType) {
        setMessageTypes(new HashSet<MessageTypesEnum>(Arrays.asList(messageType)));
    }

    public void addMessageType(MessageTypesEnum messageType) {
        jenaModel.add(metadataInstance,
                RDF.type,
                jenaModel.createResource(messageType.toString()));
    }

    /**
     * @param messageType A proper URI describing a message type
     */
    public void addMessageType(String messageType) {
        jenaModel.add(metadataInstance,
                RDF.type,
                jenaModel.createResource(messageType));
    }

    public void removeMessageType(MessageTypesEnum messageType) {
        jenaModel.removeAll(metadataInstance,
                RDF.type,
                jenaModel.createResource(messageType.toString()));
        addMessageType(MessageTypesEnum.META);
    }

    public void removeMessageType(String messageType) {
        jenaModel.removeAll(metadataInstance,
                RDF.type,
                jenaModel.createResource(messageType));
        addMessageType(MessageTypesEnum.META);
    }

    /**
     * Removes ALL message type information from this metadata.
     * Note that any message metadata is ALWAYS at least of type "meta". - this information cannot be removed.
     */
    public void removeMessageTypes() {
        jenaModel.removeAll(metadataInstance,
                RDF.type,
                null);
        addMessageType(MessageTypesEnum.META);
    }

    public boolean isOfMessageType(MessageTypesEnum messageType) {
        return getMessageTypes().contains(messageType);
    }

    /**
     * Returns a formatted one-line string with all message types.
     * Note that any message metadata is ALWAYS at least of type "meta".
     *
     * @return
     */
    public String printMessageTypes() {
        String result = "";
        Set<MessageTypesEnum> s = getMessageTypes();
        Iterator it = s.iterator();
        for (int i = 0; i < s.size(); i++) {
            if (i > 0) result += ", ";
            result += "<" + it.next().toString() + ">";
        }
        return result;
    }

//    public Optional<String> getChannelId() {
//        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ChannelId));
//        if (it.hasNext()) {
//            return Optional.ofNullable(it.next().asLiteral().getValue().toString());
//        } else {
//            return Optional.empty();
//        }
//    }
//
//    public void setChannelId(String channelId) {
//        removeChannelId();
//        jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ChannelId), jenaModel.createTypedLiteral(channelId));
//    }
//
//    /**
//     * Returns a string with channelId or an empty string.
//     *
//     * @return
//     */
//    public String printChannelId() {
//        Optional<String> s = getChannelId();
//        return s.orElse("");
//    }
//
//    /**
//     * Removes any channelId information from this metadata.
//     */
//    public void removeChannelId() {
//        jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ChannelId), null);
//    }

    public Optional<String> getStatus() {
        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.Status));
        if (it.hasNext()) {
            return Optional.ofNullable(it.next().asLiteral().getValue().toString());
        } else {
            return Optional.empty();
        }
    }

    public void setStatus(String status) {
        removeStatus();
        jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.Status), jenaModel.createTypedLiteral(status));
    }

    /**
     * Returns a string with channelId or an empty string.
     *
     * @return
     */
    public String printStatus() {
        Optional<String> s = getStatus();
        return s.orElse("");
    }

    /**
     * Removes any channelId information from this metadata.
     */
    public void removeStatus() {
        jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.Status), null);
    }

    public Optional<String> getConversationId() {
        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ConversationId));
        if (it.hasNext()) {
            return Optional.ofNullable(it.next().asLiteral().getValue().toString());
        } else {
            return Optional.empty();
        }
    }

    public void setConversationId(String conversationId) {
        removeConversationId();
        jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ConversationId), jenaModel.createTypedLiteral(conversationId));
    }

    /**
     * Returns a string with conversationId or an empty string.
     *
     * @return
     */
    public String printConversationId() {
        Optional<String> s = getConversationId();
        return s.orElse("");
    }

    /**
     * Removes any conversationId information from this metadata.
     */
    public void removeConversationId() {
        jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ConversationId), null);
    }

    /**
     * ClientId represents an identifier of the client (user) which is calling INTER-MW REST API.
     *
     * @return ID of the client
     */
    public Optional<String> getClientId() {
        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ClientId));
        if (it.hasNext()) {
            return Optional.ofNullable(it.next().asLiteral().getValue().toString());
        } else {
            return Optional.empty();
        }
    }

    /**
     * ClientId represents an identifier of the client (user) which is calling INTER-MW REST API.
     *
     * @param clientId ID of the client
     */
    public void setClientId(String clientId) {
        removeClientId();
        jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ClientId), jenaModel.createTypedLiteral(clientId));
    }

    /**
     * Returns a string with clientId or an empty string.
     *
     * @return
     */
    public String printClientId() {
        Optional<String> s = getClientId();
        return s.orElse("");
    }

    /**
     * Removes any clientId information from this metadata.
     */
    public void removeClientId() {
        jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ClientId), null);
    }

    /**
     * ClientCallbackURL is the API callback address for an API client.
     *
     * @return Clients Callback URL
     */
    public Optional<String> getClientCallbackURL() {
        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ClientCallbackURL));
        if (it.hasNext()) {
            return Optional.ofNullable(it.next().asLiteral().getValue().toString());
        } else {
            return Optional.empty();
        }
    }

    /**
     * ClientCallbackURL is the API callback address for an API client.
     *
     * @param clientCallbackURL Callback URL
     */
    public void setClientCallbackURL(String clientCallbackURL) {
        removeClientCallbackURL();
        jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ClientCallbackURL), jenaModel.createTypedLiteral(clientCallbackURL));
    }

    /**
     * Returns a string with ClientCallbackURL or an empty string.
     *
     * @return
     */
    public String printClientCallbackURL() {
        Optional<String> s = getClientCallbackURL();
        return s.orElse("");
    }

    /**
     * Removes any ClientCallbackURL information from this metadata.
     */
    public void removeClientCallbackURL() {
        jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ClientCallbackURL), null);
    }

//    public Optional<URI> getSenderPlatformId() {
//        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(URIManager.URIMETAplatformId));
//        if (it.hasNext()) {
//            return Optional.ofNullable(URI.create(it.next().toString()));
//        } else {
//            return Optional.empty();
//        }
//    }
//
//    /**
//     * Even though any URIs are allowed, by convention they should start with a scheme identifier (e.g. http://).
//     *
//     * @param platformId
//     */
//    public void setSenderPlatformId(URI platformId) throws IllegalArgumentException {
//        removeSenderPlatformId();
//        jenaModel.add(metadataInstance, jenaModel.createProperty(URIManager.URIMETAplatformId), jenaModel.createResource(platformId.toString()));
//    }
//
//    /**
//     * Returns a string with platformId or an empty string.
//     *
//     * @return
//     */
//    public String printSenderPlatformId() {
//        Optional<URI> s = getSenderPlatformId();
//        return s.map(x -> x.toString()).orElse("");
//    }
//
//    /**
//     * Removes any PlatformId information from this metadata.
//     */
//    public void removeSenderPlatformId() {
//        jenaModel.removeAll(metadataInstance, jenaModel.createProperty(URIManager.URIMETAplatformId), null);
//    }

    /**
     * @return A multiline string with a list of metadata.
     */
    public String prettyPrint() {
        return "dateTimeStamp: " + printDateTimeStamp() + "\n" +
                "messageType: " + printMessageTypes() + "\n" +
                "messageID: " + printMessageID() + "\n" +
//                "channelId: " + printChannelId() + "\n" +
                "conversationID: " + printConversationId() + "\n" +
                "status:" + printStatus() + "\n";
//                "platformId: " + printPlatformId() + "\n";
    }

    public PlatformMessageMetadata asPlatformMessageMetadata() {
        return new PlatformMessageMetadata(this);
    }

    public ErrorMessageMetadata asErrorMessageMetadata() {
        return new ErrorMessageMetadata(this);
    }

    public QueryMessageMetadata asQueryMetadata() {
        return new QueryMessageMetadata(this);
    }

    public SysInitMessageMetadata asSysInitMetadata() {
        return new SysInitMessageMetadata(this);
    }

    public VirtualSubscriptionMessageMetadata asVirtualSubscriptionMetadata() {
        return new VirtualSubscriptionMessageMetadata(this);
    }

}
