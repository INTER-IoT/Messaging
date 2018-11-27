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


package eu.interiot.message.payload.types.instanced;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.payload.InstancedPayload;
import org.apache.jena.rdf.model.Model;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class Ontology with URI http://inter-iot.eu/GOIoTP#Ontology
 * <p>
 * Attributes:
 * HasURI, HasVersion
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class OntologyInstancedPayload extends InstancedPayload {

   /*
Properties:
HasURI, HasVersion
*/

    public OntologyInstancedPayload(EntityID OntologyID) {
        this(OntologyID, false);
    }

    public OntologyInstancedPayload(EntityID OntologyID, boolean useRDFSInferencer) {
        super(OntologyID, new EntityID("http://inter-iot.eu/GOIoTP#Ontology"), useRDFSInferencer);
    }

    public OntologyInstancedPayload(EntityID OntologyID, Model jenaModel) {
        this(OntologyID, jenaModel, false);
    }

    public OntologyInstancedPayload(EntityID OntologyID, Model jenaModel, boolean useRDFSInferencer) {
        super(OntologyID, new EntityID("http://inter-iot.eu/GOIoTP#Ontology"), jenaModel, useRDFSInferencer);
    }

    public EntityID getOntologyInstanceID() {
        return getEntityInstanceID();
    }

    public void setOntologyInstanceID(EntityID OntologyID) {
        setEntityInstanceID(OntologyID);
    }


    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasURI data property assertion
     */
    public Optional<String> getHasURI() {
        EntityID OntologyID = getEntityInstanceID();

        Set<Object> s = getJenaModel().listObjectsOfProperty(
                OntologyID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasURI"))
                .toSet()
                .stream()
                .map(x -> x.asLiteral().getValue())
                .collect(Collectors.toSet());

        Set<String> ss = s.stream().map(y -> {
                    if (y instanceof String) {
                        return (String) y;
                    } else {
                        return null;
                    }
                }
        ).collect(Collectors.toSet());

        if (ss.contains(null))
            ss.remove(null);
        if (ss.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(ss.iterator().next());
        }
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasURI data property assertion
     */
    public void setHasURI(String propertyValue) {
        EntityID OntologyID = getEntityInstanceID();

        removeHasURI();
        getJenaModel().add(
                getJenaModel().createLiteralStatement(OntologyID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasURI"),
                        propertyValue
                ));
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasURI data property assertion
     */
    public void removeHasURI() {
        EntityID OntologyID = getEntityInstanceID();

        getJenaModel().removeAll(OntologyID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasURI"),
                null);
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasVersion data property assertion
     */
    public Optional<String> getHasVersion() {
        EntityID OntologyID = getEntityInstanceID();

        Set<Object> s = getJenaModel().listObjectsOfProperty(
                OntologyID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasVersion"))
                .toSet()
                .stream()
                .map(x -> x.asLiteral().getValue())
                .collect(Collectors.toSet());

        Set<String> ss = s.stream().map(y -> {
                    if (y instanceof String) {
                        return (String) y;
                    } else {
                        return null;
                    }
                }
        ).collect(Collectors.toSet());

        if (ss.contains(null))
            ss.remove(null);
        if (ss.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(ss.iterator().next());
        }
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasVersion data property assertion
     */
    public void setHasVersion(String propertyValue) {
        EntityID OntologyID = getEntityInstanceID();

        removeHasVersion();
        getJenaModel().add(
                getJenaModel().createLiteralStatement(OntologyID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasVersion"),
                        propertyValue
                ));
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasVersion data property assertion
     */
    public void removeHasVersion() {
        EntityID OntologyID = getEntityInstanceID();

        getJenaModel().removeAll(OntologyID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasVersion"),
                null);
    }

}