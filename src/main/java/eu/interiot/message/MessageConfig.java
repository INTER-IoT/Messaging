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

import com.github.jsonldjava.core.JsonLdOptions;
import eu.interiot.message.managers.URI.URIManagerMessageMetadata;
import org.apache.jena.riot.JsonLDWriteContext;
import org.apache.jena.riot.RDFFormat;

/**
 * A container for any setting relevant to creation or operation of a {@Link Message Message}
 * The initialized values are used by default in {@link Message} constructor.
 */
//TODO: Improve class description - indicate strongly what the default values are
public class MessageConfig {

    private String URImessagePayloadGraph = URIManagerMessageMetadata.BASE.Message + "payload";
    private String URImessageMetadataGraph = URIManagerMessageMetadata.BASE.Message + "metadata";

    private boolean requireMetadataGraph = true;
    private boolean requirePayloadGraph = false;

    /**
     * Sets basic information about a new message in the message metadata (timestamp, etc.)
     * See the {@link MessageMetadata#initializeMetadata() MessageMetadata.initializeMetadata} method.
     */
    private boolean initializeNewMessage = true;

    private JsonLDWriteContext jsonLDWriteContext;

    private RDFFormat rdfDatasetSerializationFormat = RDFFormat.JSONLD_COMPACT_PRETTY;

    public MessageConfig() {
        jsonLDWriteContext = new JsonLDWriteContext();
        JsonLdOptions opts = new JsonLdOptions();
        //      opts.setEmbed(false);
        //      opts.setExplicit(true);
        //      opts.setOmitDefault(false);
        opts.setUseRdfType(true);
        jsonLDWriteContext.setOptions(opts);
    }

    public boolean isInitializeNewMessage() {
        return initializeNewMessage;
    }

    public MessageConfig setInitializeNewMessage(boolean initializeNewMessage) {
        this.initializeNewMessage = initializeNewMessage;
        return this;
    }

    public String getURImessagePayloadGraph() {
        return URImessagePayloadGraph;
    }

    public MessageConfig setURImessagePayloadGraph(String URImessagePayloadGraph) {
        this.URImessagePayloadGraph = URImessagePayloadGraph;
        return this;
    }

    public String getURImessageMetadataGraph() {
        return URImessageMetadataGraph;
    }

    public MessageConfig setURImessageMetadataGraph(String URImessageMetadataGraph) {
        this.URImessageMetadataGraph = URImessageMetadataGraph;
        return this;
    }

    public boolean isRequireMetadataGraph() {
        return requireMetadataGraph;
    }

    public MessageConfig setRequireMetadataGraph(boolean requireMetadataGraph) {
        this.requireMetadataGraph = requireMetadataGraph;
        return this;
    }

    public boolean isRequirePayloadGraph() {
        return requirePayloadGraph;
    }

    public MessageConfig setRequirePayloadGraph(boolean requirePayloadGraph) {
        this.requirePayloadGraph = requirePayloadGraph;
        return this;
    }

    public JsonLDWriteContext getJsonLDWriteContext() {
        return jsonLDWriteContext;
    }

    public void setJsonLDWriteContext(JsonLDWriteContext jsonLDWriteContext) {
        this.jsonLDWriteContext = jsonLDWriteContext;
    }

    public RDFFormat getRdfDatasetSerializationFormat() {
        return rdfDatasetSerializationFormat;
    }

    public void setRdfDatasetSerializationFormat(RDFFormat rdfDatasetSerializationFormat) {
        this.rdfDatasetSerializationFormat = rdfDatasetSerializationFormat;
    }
}