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


package eu.interiot.message.payload.types;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.exceptions.payload.IdentifierException;
import eu.interiot.message.payload.TypedPayload;
import org.apache.jena.rdf.model.Model;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class Result with URI http://www.w3.org/ns/sosa/Result
 * <p>
 * Attributes:
 * HasLocation, HasResultValue, HasUnit
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class ResultPayload extends TypedPayload {

    public ResultPayload() {
        this(false);
    }

    public ResultPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Result"), useRDFSInferencer);
    }

    public ResultPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public ResultPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Result"), jenaModel, useRDFSInferencer);
    }

    public void createResult(EntityID ResultID) {
        createTypedEntity(ResultID);
    }

    public Set<EntityID> getResults() {
        return getTypedEntities();
    }


    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public Optional<EntityID> getHasLocation(EntityID ResultID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ResultID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"))
                .toSet()
                .stream()
                .map(x -> {
                    try {
                        return new EntityID(x.asResource());
                    } catch (IdentifierException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (s.contains(null))
            s.remove(null);

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void setHasLocation(EntityID ResultID, EntityID propertyValue) {
        removeHasLocation(ResultID);
        getJenaModel().add(ResultID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void removeHasLocation(EntityID ResultID) {
        getJenaModel().removeAll(ResultID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                null);
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasResultValue data property assertion
     */
    public Optional<String> getHasResultValue(EntityID ResultID) {
        Set<Object> s = getJenaModel().listObjectsOfProperty(
                ResultID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasResultValue"))
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
     * Setter for http://inter-iot.eu/GOIoTP#hasResultValue data property assertion
     */
    public void setHasResultValue(EntityID ResultID, String propertyValue) {
        removeHasResultValue(ResultID);
        getJenaModel().add(
                getJenaModel().createLiteralStatement(ResultID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasResultValue"),
                        propertyValue
                ));
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasResultValue data property assertion
     */
    public void removeHasResultValue(EntityID ResultID) {
        getJenaModel().removeAll(ResultID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasResultValue"),
                null);
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasUnit object property assertion
     */
    public Optional<EntityID> getHasUnit(EntityID ResultID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ResultID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasUnit"))
                .toSet()
                .stream()
                .map(x -> {
                    try {
                        return new EntityID(x.asResource());
                    } catch (IdentifierException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (s.contains(null))
            s.remove(null);

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasUnit object property assertion
     */
    public void setHasUnit(EntityID ResultID, EntityID propertyValue) {
        removeHasUnit(ResultID);
        getJenaModel().add(ResultID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasUnit"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasUnit object property assertion
     */
    public void removeHasUnit(EntityID ResultID) {
        getJenaModel().removeAll(ResultID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasUnit"),
                null);
    }

}