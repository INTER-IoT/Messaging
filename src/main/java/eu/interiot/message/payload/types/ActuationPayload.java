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
import org.apache.jena.rdf.model.ResourceFactory;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class Actuation with URI http://www.w3.org/ns/sosa/Actuation
 * <p>
 * Attributes:
 * ActsOnProperty, HasFeatureOfInterest, HasResult, UsedProcedure, MadeByActuator, ResultTime
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class ActuationPayload extends TypedPayload {

    public ActuationPayload() {
        this(false);
    }

    public ActuationPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Actuation"), useRDFSInferencer);
    }

    public ActuationPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public ActuationPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Actuation"), jenaModel, useRDFSInferencer);
    }

    public void createActuation(EntityID ActuationID) {
        createTypedEntity(ActuationID);
    }

    public Set<EntityID> getActuations() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public Set<EntityID> getActsOnProperty(EntityID ActuationID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"))
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

        return s;
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public void setActsOnProperty(EntityID ActuationID, EntityID propertyValue) {
        removeAllActsOnProperty(ActuationID);
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public void setActsOnProperty(EntityID ActuationID, Set<EntityID> propertyValues) {
        removeAllActsOnProperty(ActuationID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public void removeActsOnProperty(EntityID ActuationID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public void removeAllActsOnProperty(EntityID ActuationID) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public void addActsOnProperty(EntityID ActuationID, EntityID propertyValue) {
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public Set<EntityID> getHasFeatureOfInterest(EntityID ActuationID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"))
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

        return s;
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void setHasFeatureOfInterest(EntityID ActuationID, EntityID propertyValue) {
        removeAllHasFeatureOfInterest(ActuationID);
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void setHasFeatureOfInterest(EntityID ActuationID, Set<EntityID> propertyValues) {
        removeAllHasFeatureOfInterest(ActuationID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void removeHasFeatureOfInterest(EntityID ActuationID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void removeAllHasFeatureOfInterest(EntityID ActuationID) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void addHasFeatureOfInterest(EntityID ActuationID, EntityID propertyValue) {
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public Set<EntityID> getHasResult(EntityID ActuationID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"))
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

        return s;
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void setHasResult(EntityID ActuationID, EntityID propertyValue) {
        removeAllHasResult(ActuationID);
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void setHasResult(EntityID ActuationID, Set<EntityID> propertyValues) {
        removeAllHasResult(ActuationID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void removeHasResult(EntityID ActuationID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void removeAllHasResult(EntityID ActuationID) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void addHasResult(EntityID ActuationID, EntityID propertyValue) {
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public Set<EntityID> getUsedProcedure(EntityID ActuationID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"))
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

        return s;
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void setUsedProcedure(EntityID ActuationID, EntityID propertyValue) {
        removeAllUsedProcedure(ActuationID);
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void setUsedProcedure(EntityID ActuationID, Set<EntityID> propertyValues) {
        removeAllUsedProcedure(ActuationID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void removeUsedProcedure(EntityID ActuationID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void removeAllUsedProcedure(EntityID ActuationID) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void addUsedProcedure(EntityID ActuationID, EntityID propertyValue) {
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public Set<EntityID> getMadeByActuator(EntityID ActuationID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"))
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

        return s;
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public void setMadeByActuator(EntityID ActuationID, EntityID propertyValue) {
        removeAllMadeByActuator(ActuationID);
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public void setMadeByActuator(EntityID ActuationID, Set<EntityID> propertyValues) {
        removeAllMadeByActuator(ActuationID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public void removeMadeByActuator(EntityID ActuationID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public void removeAllMadeByActuator(EntityID ActuationID) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public void addMadeByActuator(EntityID ActuationID, EntityID propertyValue) {
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public Set<String> getResultTime(EntityID ActuationID) {
        Set<Object> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"))
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
        return ss;
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public void setResultTime(EntityID ActuationID, String propertyValue) {
        removeAllResultTime(ActuationID);
        getJenaModel().add(
                getJenaModel().createLiteralStatement(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                        propertyValue
                ));
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/resultTime object property assertion
     */
    public void setResultTime(EntityID ActuationID, Set<String> propertyValues) {
        removeAllResultTime(ActuationID);
        for (String e : propertyValues) {
            if (e != null) {
                getJenaModel().add(
                        getJenaModel().createLiteralStatement(ActuationID.getJenaResource(),
                                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                                e
                        ));
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public void removeResultTime(EntityID ActuationID, String propertyValue) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                ResourceFactory.createTypedLiteral(propertyValue));
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/resultTime object property assertion
     */
    public void removeAllResultTime(EntityID ActuationID) {
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public void addResultTime(EntityID ActuationID, String propertyValue) {
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                propertyValue);
    }

}