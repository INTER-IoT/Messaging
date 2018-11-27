package eu.interiot.message.metaTypes;

import eu.interiot.message.MessageMetadata;
import eu.interiot.message.URI.URIManagerMessageMetadata.MESSAGEMETADATA;
import eu.interiot.message.URI.URIManagerMessageMetadata.MessageTypesEnum;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.NodeIterator;
import org.apache.jena.rdf.model.RDFNode;

import java.util.Optional;

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

public class QueryMetadata extends MessageMetadata {

    public QueryMetadata() {
        super();
        addMessageType(MessageTypesEnum.QUERY);
    }

    /**
     * Creates a new {@Link QueryMetadata} QueryMetadata from {@Link MessageMetadata} MessageMetadata
     *
     * @param msgMetadata
     */
    public QueryMetadata(MessageMetadata msgMetadata) {
        jenaModel = msgMetadata.getJenaModel();
        metadataInstance = msgMetadata.getMetadataInstance();
    }

    /**
     * Returns the registry query String in this message, if it exists
     *
     * @return
     */
    public Optional<String> getQueryString() {
        //        MessageUtils.unescapeJSONLDString
        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.Query));
        if (it.hasNext()) {
            RDFNode n = it.next();
            if (n.isLiteral()) {
                return Optional.ofNullable(n.asLiteral().getValue().toString());
            }
        }
        return Optional.empty();
    }

    /**
     * Sets the registry query String for this message
     * In INTER-MW the query string should be a valid SPARQL query to the Devices & Platforms registry
     *
     * @param query
     */
    public void setQueryString(String query) throws IllegalArgumentException {
        removeQueryString();
        jenaModel.add(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.Query), query);
    }

    /**
     * Returns a string with registry query or an empty string.
     *
     * @return
     */
    public String printQueryString() {
        Optional<String> s = getQueryString();
        return s.map(x -> x.toString()).orElse("");
    }

    /**
     * Removes any registry query string information from this metadata.
     */
    public void removeQueryString() {
        jenaModel.removeAll(metadataInstance, jenaModel.createProperty(MESSAGEMETADATA.Query), null);
    }

    public boolean validateQueryString() throws QueryParseException {
        Optional<String> s = getQueryString();
        if (s.isPresent()) {
            return validateQueryString(s.get());
        } else {
            return false;
        }
    }

    /**
     * TODO: Throw exception, if something goes wrong with the query
     *
     * @param queryString
     * @return
     */
    public boolean validateQueryString(String queryString) throws QueryParseException {
        Model emptyModel = ModelFactory.createDefaultModel();

        Query testQuery = QueryFactory.create(queryString);
        QueryExecution testQueryExec = QueryExecutionFactory.create(testQuery, emptyModel);
//        testQueryExec.execSelect();
        return true;
    }
}
