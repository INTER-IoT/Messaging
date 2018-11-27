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

    import com.google.common.base.Throwables;
    import eu.interiot.message.Message;
    import eu.interiot.message.MessageMetadata;
    import eu.interiot.message.URI.URIManagerMessageMetadata.MESSAGEMETADATA;
    import eu.interiot.message.URI.URIManagerMessageMetadata.MessageTypesEnum;
    import eu.interiot.message.exceptions.MessageException;
    import eu.interiot.message.exceptions.metadata.MetadataException;
    import eu.interiot.message.utils.MessageUtils;
    import org.apache.jena.rdf.model.Model;
    import org.apache.jena.rdf.model.NodeIterator;

    import java.io.IOException;
    import java.util.Optional;
    import java.util.Set;

    public class ErrorMessageMetadata extends MessageMetadata {

        /**
         * Creates a new {@Link ErrorMessageMetadata} PlatformMessageMetadata from {@Link MessageMetadata} MessageMetadata
         *
         * @param msgMetadata
         */
        public ErrorMessageMetadata(MessageMetadata msgMetadata) {
            jenaModel = msgMetadata.getJenaModel();
            metadataInstance = msgMetadata.getMetadataInstance();
        }

        public ErrorMessageMetadata() {
            super();
            addMessageType(MessageTypesEnum.ERROR);
        }

        public ErrorMessageMetadata(boolean useRDFSInferencer) {
            super(useRDFSInferencer);
            addMessageType(MessageTypesEnum.ERROR);
        }

        public ErrorMessageMetadata(Model jenaModel) throws MetadataException {
            super(jenaModel);
            addMessageType(MessageTypesEnum.ERROR);
        }

        public ErrorMessageMetadata(Model jenaModel, boolean useRDFSInferencer) throws MetadataException {
            super(jenaModel, useRDFSInferencer);
            addMessageType(MessageTypesEnum.ERROR);
        }

        /**
         * Initializes the error code and description from a {@link MessageException MessageException}
         * See also {@link ErrorMessageMetadata#setErrorFromException(MessageException)} setErrorFromException}
         *
         * @param messageException
         */
        public ErrorMessageMetadata(MessageException messageException) {
            super();
            addMessageType(MessageTypesEnum.ERROR);
            setErrorFromException(messageException);
        }

        /**
         * Initializes the error code and description from a {@link MessageException MessageException}
         * See also {@link ErrorMessageMetadata#setErrorFromException(MessageException)} setErrorFromException}
         *
         * @param useRDFSInferencer
         * @param messageException
         */
        public ErrorMessageMetadata(boolean useRDFSInferencer, MessageException messageException) {
            super(useRDFSInferencer);
            addMessageType(MessageTypesEnum.ERROR);
            setErrorFromException(messageException);
        }

        /**
         * Initializes the error code and description from a {@link MessageException MessageException}
         * See also {@link ErrorMessageMetadata#setErrorFromException(MessageException)} setErrorFromException}
         *
         * @param jenaModel
         * @param messageException
         * @throws MetadataException
         */
        public ErrorMessageMetadata(Model jenaModel, MessageException messageException) throws MetadataException {
            super(jenaModel);
            addMessageType(MessageTypesEnum.ERROR);
            setErrorFromException(messageException);
        }

        /**
         * Initializes the error code and description from a {@link MessageException MessageException}
         * See also {@link ErrorMessageMetadata#setErrorFromException(MessageException)} setErrorFromException}
         *
         * @param jenaModel
         * @param useRDFSInferencer
         * @param messageException
         * @throws MetadataException
         */
        public ErrorMessageMetadata(Model jenaModel, boolean useRDFSInferencer, MessageException messageException) throws MetadataException {
            super(jenaModel, useRDFSInferencer);
            addMessageType(MessageTypesEnum.ERROR);
            setErrorFromException(messageException);
        }

        @Override
        public void setMessageTypes(Set<MessageTypesEnum> messageTypes) {
            super.setMessageTypes(messageTypes);
            addMessageType(MessageTypesEnum.ERROR);
        }

        @Override
        public void setMessageType(MessageTypesEnum messageType) {
            super.setMessageType(messageType);
            addMessageType(MessageTypesEnum.ERROR);
        }

        @Override
        public void removeMessageType(MessageTypesEnum messageType) {
            super.removeMessageType(messageType);
            addMessageType(MessageTypesEnum.ERROR);
        }

        @Override
        public void removeMessageType(String messageType) {
            super.removeMessageType(messageType);
            addMessageType(MessageTypesEnum.ERROR);
        }

        @Override
        public void removeMessageTypes() {
            super.removeMessageTypes();
            addMessageType(MessageTypesEnum.ERROR);
        }

        public Optional<String> getErrorCategory() {
            NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorCategory));
            if (it.hasNext()) {
                return Optional.ofNullable(it.next().toString());
            } else {
                return Optional.empty();
            }
        }

        public void setErrorCategory(String errorCategory) throws IllegalArgumentException {
            removeErrorCategory();
            jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorCategory), jenaModel.createTypedLiteral(errorCategory));
        }

        public Optional<String> getErrorIdentifier() {
            NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorIdentifier));
            if (it.hasNext()) {
                return Optional.ofNullable(it.next().toString());
            } else {
                return Optional.empty();
            }
        }

        public void setErrorIdentifier(String errorIdentifier) throws IllegalArgumentException {
            removeErrorIdentifier();
            jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorIdentifier), jenaModel.createTypedLiteral(errorIdentifier));
        }

        /**
         * Returns a string with error category or an empty string.
         *
         * @return
         */
        public String printErrorCategory() {
            Optional<String> s = getErrorCategory();
            return s.orElse("");
        }

        /**
         * Returns a string with error identifier or an empty string.
         *
         * @return
         */
        public String printErrorIdentifier() {
            Optional<String> s = getErrorIdentifier();
            return s.orElse("");
        }

        /**
         * Removes any error category information from this metadata.
         */
        public void removeErrorCategory() {
            jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorCategory), null);
        }

        /**
         * Removes any error identifier information from this metadata.
         */
        public void removeErrorIdentifier() {
            jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorCategory), null);
        }

        public Optional<String> getErrorDescription() {
            NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorDescription));
            if (it.hasNext()) {
                return Optional.ofNullable(it.next().toString());
            } else {
                return Optional.empty();
            }
        }

        public void setErrorDescription(String errorDescription) throws IllegalArgumentException {
            removeErrorDescription();
            jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorDescription), jenaModel.createTypedLiteral(errorDescription));
        }

        /**
         * Returns a string with error description or an empty string.
         *
         * @return
         */
        public String printErrorDescription() {
            Optional<String> s = getErrorDescription();
            return s.orElse("");
        }

        /**
         * Removes any error description information from this metadata.
         */
        public void removeErrorDescription() {
            jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorDescription), null);
        }

        /**
         * Sets the code, description, and stack trace of the error from a {@link MessageException MessageException}
         *
         * @param messageException messageException Exception Code -> Error identifier
         *                         messageException Exception Message -> Error Description
         *                         messageException Stack Trace -> Error Stack Trace
         */
        public void setErrorFromException(MessageException messageException) {
            setErrorIdentifier(messageException.getCode());
            setErrorDescription(messageException.getMessage());
            setExceptionStackTrace(messageException);
        }

        /**
         * Returns the original message that caused the error. If the message cannot be parsed, or for whatever other reason
         * cannot be put into a {@link Message Message} object, an empty {@link Optional Optional} is returned.
         * See also {@link ErrorMessageMetadata#getOriginalMessageAsString() getOriginalMessageAsString}
         *
         * @return
         */
        public Optional<Message> getOriginalMessage() {
            Optional<String> msg = getOriginalMessageAsString();
            if (msg.isPresent()) {
                try {
                    return Optional.of(new Message(msg.get()));
                } catch (Exception e) {
                    return Optional.empty();
                }
            } else {
                return Optional.empty();
            }
        }

        /**
         * Sets the original {@link Message Message} that caused the error.
         * See also {@link ErrorMessageMetadata#setOriginalMessage(Message) setOriginalMessage}
         *
         * @param originalMessage This string parameter should contain the original JSON-LD message.
         */
        public void setOriginalMessage(String originalMessage) {
            removeOriginalMessage();
            jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorOriginalMessage), jenaModel.createTypedLiteral(originalMessage));
        }

        /**
         * Sets the original {@link Message Message} that caused the error.
         * If the original message cannot be serialized to JSON-LD, use the {@link ErrorMessageMetadata#setOriginalMessage(String) setOriginalMessage} method.
         *
         * @param originalMessage
         * @throws IOException
         */
        public void setOriginalMessage(Message originalMessage) throws IOException {
            setOriginalMessage(originalMessage.serializeToJSONLD());
        }

        /**
         * Returns the original message that caused the error as a JSON-LD string.
         *
         * @return
         */
        public Optional<String> getOriginalMessageAsString() {
            NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorOriginalMessage));
            if (it.hasNext()) {
                String s = it.next().toString();
                if (null != s)
                    s = MessageUtils.unescapeJSONLDString(s);
                return Optional.ofNullable(s);
            } else {
                return Optional.empty();
            }
        }

        /**
         * Returns a string with the original message that caused the error or an empty string.
         *
         * @return
         */
        public String printOriginalMessage() {
            Optional<String> s = getOriginalMessageAsString();
            return s.orElse("");
        }

        /**
         * Removes any original message that caused the error information from this metadata.
         */
        public void removeOriginalMessage() {
            jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorOriginalMessage), null);
        }

        /**
         * Returns a string representation of a stack trace.
         * The stack trace exists if there was an exception that caused the original error.
         * See also {@link ErrorMessageMetadata#setExceptionStackTrace(String) setExceptionStackTrace} and {@link ErrorMessageMetadata#setErrorFromException(MessageException) setErrorFromException}
         *
         * @return
         */
        public Optional<String> getExceptionStackTrace() {
            NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorStackTrace));
            if (it.hasNext()) {
                String s = it.next().toString();
                if (null != s)
                    s = MessageUtils.unescapeJSONLDString(s);
                return Optional.ofNullable(s);
            } else {
                return Optional.empty();
            }
        }

        /**
         * Sets the value of a string representation of a stack trace.
         *
         * @param exception The exception from which the stack trace is extracted and serialized into a String
         */
        public void setExceptionStackTrace(Exception exception) {
            removeExceptionStackTrace();
            jenaModel.add(metadataInstance,
                    jenaModel.createProperty(MESSAGEMETADATA.ErrorStackTrace),
                    jenaModel.createTypedLiteral(
                            Throwables.getStackTraceAsString(exception)
                    ));
        }

        /**
         * Sets the value of a string representation of a stack trace.
         * See also {@link ErrorMessageMetadata#setExceptionStackTrace(Exception) setExceptionStackTrace}
         *
         * @param exceptionStackTrace
         */
        public void setExceptionStackTrace(String exceptionStackTrace) {
            removeExceptionStackTrace();
            jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorStackTrace), jenaModel.createTypedLiteral(exceptionStackTrace));
        }

        /**
         * Returns a string with String representation of an exception stack trace or an empty string.
         * The stack trace exists if there was an exception that caused the original error.
         * See also {@link ErrorMessageMetadata#setExceptionStackTrace(String) setExceptionStackTrace} and {@link ErrorMessageMetadata#setErrorFromException(MessageException) setErrorFromException}
         *
         * @return
         */
        public String printExceptionStackTrace() {
            Optional<String> s = getExceptionStackTrace();
            return s.orElse("");
        }

        /**
         * Removes any exception stack trace information from this metadata.
         */
        public void removeExceptionStackTrace() {
            jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.ErrorStackTrace), null);
        }
    }