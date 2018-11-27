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


package eu.interiot.message.payload.types.functions;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.MessagePayload;
import eu.interiot.message.exceptions.payload.IdentifierException;
import eu.interiot.message.payload.MessagePayloadFunctions;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class Actuation with URI http://www.w3.org/ns/sosa/Actuation
 * <p>
 * Attributes:
 * ActsOnProperty, HasFeatureOfInterest, HasResult, UsedProcedure, MadeByActuator, ResultTime
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class ActuationPayloadFunctions extends MessagePayloadFunctions {

    /*
 Properties:
 ActsOnProperty, HasFeatureOfInterest, HasResult, UsedProcedure, MadeByActuator, ResultTime
 */
    private static EntityID entityType = new EntityID("http://www.w3.org/ns/sosa/Actuation");

    public static EntityID getEntityType() {
        return entityType;
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public static Set<EntityID> getActsOnProperty(MessagePayload payload, EntityID ActuationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"))
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
    public static void setActsOnProperty(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        removeAllActsOnProperty(payload, ActuationID);
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public static void setActsOnProperty(MessagePayload payload, EntityID ActuationID, Set<EntityID> propertyValues) {
        removeAllActsOnProperty(payload, ActuationID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(ActuationID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public static void removeActsOnProperty(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public static void removeAllActsOnProperty(MessagePayload payload, EntityID ActuationID) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public static void addActsOnProperty(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public static Set<EntityID> getHasFeatureOfInterest(MessagePayload payload, EntityID ActuationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"))
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
    public static void setHasFeatureOfInterest(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        removeAllHasFeatureOfInterest(payload, ActuationID);
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public static void setHasFeatureOfInterest(MessagePayload payload, EntityID ActuationID, Set<EntityID> propertyValues) {
        removeAllHasFeatureOfInterest(payload, ActuationID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(ActuationID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public static void removeHasFeatureOfInterest(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public static void removeAllHasFeatureOfInterest(MessagePayload payload, EntityID ActuationID) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public static void addHasFeatureOfInterest(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public static Set<EntityID> getHasResult(MessagePayload payload, EntityID ActuationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"))
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
    public static void setHasResult(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        removeAllHasResult(payload, ActuationID);
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public static void setHasResult(MessagePayload payload, EntityID ActuationID, Set<EntityID> propertyValues) {
        removeAllHasResult(payload, ActuationID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(ActuationID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public static void removeHasResult(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public static void removeAllHasResult(MessagePayload payload, EntityID ActuationID) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public static void addHasResult(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public static Set<EntityID> getUsedProcedure(MessagePayload payload, EntityID ActuationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"))
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
    public static void setUsedProcedure(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        removeAllUsedProcedure(payload, ActuationID);
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public static void setUsedProcedure(MessagePayload payload, EntityID ActuationID, Set<EntityID> propertyValues) {
        removeAllUsedProcedure(payload, ActuationID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(ActuationID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public static void removeUsedProcedure(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public static void removeAllUsedProcedure(MessagePayload payload, EntityID ActuationID) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public static void addUsedProcedure(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public static Set<EntityID> getMadeByActuator(MessagePayload payload, EntityID ActuationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"))
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
    public static void setMadeByActuator(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        removeAllMadeByActuator(payload, ActuationID);
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public static void setMadeByActuator(MessagePayload payload, EntityID ActuationID, Set<EntityID> propertyValues) {
        removeAllMadeByActuator(payload, ActuationID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(ActuationID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public static void removeMadeByActuator(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public static void removeAllMadeByActuator(MessagePayload payload, EntityID ActuationID) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public static void addMadeByActuator(MessagePayload payload, EntityID ActuationID, EntityID propertyValue) {
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public static Set<String> getResultTime(MessagePayload payload, EntityID ActuationID) {
        Set<Object> s = payload.getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"))
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
    public static void setResultTime(MessagePayload payload, EntityID ActuationID, String propertyValue) {
        removeAllResultTime(payload, ActuationID);
        payload.getJenaModel().add(
                payload.getJenaModel().createLiteralStatement(ActuationID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                        propertyValue
                ));
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/resultTime object property assertion
     */
    public static void setResultTime(MessagePayload payload, EntityID ActuationID, Set<String> propertyValues) {
        removeAllResultTime(payload, ActuationID);
        for (String e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(
                        payload.getJenaModel().createLiteralStatement(ActuationID.getJenaResource(),
                                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                                e
                        ));
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public static void removeResultTime(MessagePayload payload, EntityID ActuationID, String propertyValue) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                ResourceFactory.createTypedLiteral(propertyValue));
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/resultTime object property assertion
     */
    public static void removeAllResultTime(MessagePayload payload, EntityID ActuationID) {
        payload.getJenaModel().removeAll(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public static void addResultTime(MessagePayload payload, EntityID ActuationID, String propertyValue) {
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                propertyValue);
    }

    public void createActuation(MessagePayload payload, EntityID ActuationID) {
        payload.getJenaModel().add(ActuationID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    public Set<EntityID> getActuations(MessagePayload payload) {
        Set<EntityID> entities = payload.getJenaModel().listSubjectsWithProperty(RDF.type,
                entityType.getJenaResource())
                .toSet()
                .stream()
                .map(x -> {
                    try {
                        return new EntityID(x);
                    } catch (IdentifierException e) {
                        return null;
                    }
                }).collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);
        return entities;
    }

}