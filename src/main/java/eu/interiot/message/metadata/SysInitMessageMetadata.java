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


package eu.interiot.message.metadata;

import eu.interiot.message.MessageMetadata;
import eu.interiot.message.exceptions.metadata.MetadataException;
import eu.interiot.message.managers.URI.URIManagerMessageMetadata;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.NodeIterator;

import java.util.Optional;

public class SysInitMessageMetadata extends MessageMetadata {
    /**
     * Creates a new {@code SysInitMessageMetadata} SysInitMessageMetadata from {@code MessageMetadata} MessageMetadata.
     * The metadata is not cloned.
     *
     * @param msgMetadata a metadata instance
     */
    public SysInitMessageMetadata(MessageMetadata msgMetadata) {
        jenaModel = msgMetadata.getJenaModel();
        metadataInstance = msgMetadata.getMetadataInstance();
    }

    public SysInitMessageMetadata() {
        super();
        addMessageType(URIManagerMessageMetadata.MessageTypesEnum.SYS_INIT);
    }

    public SysInitMessageMetadata(boolean useRDFSInferencer) {
        super(useRDFSInferencer);
        addMessageType(URIManagerMessageMetadata.MessageTypesEnum.SYS_INIT);
    }

    public SysInitMessageMetadata(Model jenaModel) throws MetadataException {
        super(jenaModel);
        addMessageType(URIManagerMessageMetadata.MessageTypesEnum.SYS_INIT);
    }

    public SysInitMessageMetadata(Model jenaModel, boolean useRDFSInferencer) throws MetadataException {
        super(jenaModel, useRDFSInferencer);
        addMessageType(URIManagerMessageMetadata.MessageTypesEnum.SYS_INIT);
    }

    public Optional<String> getPreviousConversationId() {
        NodeIterator it = jenaModel.listObjectsOfProperty(
                metadataInstance,
                jenaModel.createProperty(URIManagerMessageMetadata.MESSAGEMETADATA.PreviousConversationId));
        if (it.hasNext()) {
            return Optional.ofNullable(it.next().asLiteral().getValue().toString());
        } else {
            return Optional.empty();
        }
    }

    public void setPreviousConversationId(String conversationId) {
        removeConversationId();
        jenaModel.add(
                metadataInstance,
                jenaModel.createProperty(URIManagerMessageMetadata.MESSAGEMETADATA.PreviousConversationId),
                jenaModel.createTypedLiteral(conversationId));
    }
}