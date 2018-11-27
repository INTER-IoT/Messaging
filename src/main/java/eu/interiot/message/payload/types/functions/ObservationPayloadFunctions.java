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
import org.apache.jena.vocabulary.RDF;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class Observation with URI http://www.w3.org/ns/sosa/Observation
 * <p>
 * Attributes:
 * HasLocation, HasFeatureOfInterest, ObservedProperty, HasResult, MadeBySensor, ResultTime, PhenomenonTime
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class ObservationPayloadFunctions extends MessagePayloadFunctions {

    /*
 Properties:
 HasLocation, HasFeatureOfInterest, ObservedProperty, HasResult, MadeBySensor, ResultTime, PhenomenonTime
 */
    private static EntityID entityType = new EntityID("http://www.w3.org/ns/sosa/Observation");

    public static EntityID getEntityType() {
        return entityType;
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public static Optional<EntityID> getHasLocation(MessagePayload payload, EntityID ObservationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"))
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
    public static void setHasLocation(MessagePayload payload, EntityID ObservationID, EntityID propertyValue) {
        removeHasLocation(payload, ObservationID);
        payload.getJenaModel().add(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public static void removeHasLocation(MessagePayload payload, EntityID ObservationID) {
        payload.getJenaModel().removeAll(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public static Optional<EntityID> getHasFeatureOfInterest(MessagePayload payload, EntityID ObservationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
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

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public static void setHasFeatureOfInterest(MessagePayload payload, EntityID ObservationID, EntityID propertyValue) {
        removeHasFeatureOfInterest(payload, ObservationID);
        payload.getJenaModel().add(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public static void removeHasFeatureOfInterest(MessagePayload payload, EntityID ObservationID) {
        payload.getJenaModel().removeAll(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/observedProperty object property assertion
     */
    public static Optional<EntityID> getObservedProperty(MessagePayload payload, EntityID ObservationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/observedProperty"))
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
     * Setter for http://www.w3.org/ns/sosa/observedProperty object property assertion
     */
    public static void setObservedProperty(MessagePayload payload, EntityID ObservationID, EntityID propertyValue) {
        removeObservedProperty(payload, ObservationID);
        payload.getJenaModel().add(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/observedProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/observedProperty object property assertion
     */
    public static void removeObservedProperty(MessagePayload payload, EntityID ObservationID) {
        payload.getJenaModel().removeAll(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/observedProperty"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public static Optional<EntityID> getHasResult(MessagePayload payload, EntityID ObservationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
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

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public static void setHasResult(MessagePayload payload, EntityID ObservationID, EntityID propertyValue) {
        removeHasResult(payload, ObservationID);
        payload.getJenaModel().add(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public static void removeHasResult(MessagePayload payload, EntityID ObservationID) {
        payload.getJenaModel().removeAll(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeBySensor object property assertion
     */
    public static Optional<EntityID> getMadeBySensor(MessagePayload payload, EntityID ObservationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySensor"))
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
     * Setter for http://www.w3.org/ns/sosa/madeBySensor object property assertion
     */
    public static void setMadeBySensor(MessagePayload payload, EntityID ObservationID, EntityID propertyValue) {
        removeMadeBySensor(payload, ObservationID);
        payload.getJenaModel().add(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySensor"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeBySensor object property assertion
     */
    public static void removeMadeBySensor(MessagePayload payload, EntityID ObservationID) {
        payload.getJenaModel().removeAll(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySensor"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public static Optional<String> getResultTime(MessagePayload payload, EntityID ObservationID) {
        Set<Object> s = payload.getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
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
        if (ss.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(ss.iterator().next());
        }
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public static void setResultTime(MessagePayload payload, EntityID ObservationID, String propertyValue) {
        removeResultTime(payload, ObservationID);
        payload.getJenaModel().add(
                payload.getJenaModel().createLiteralStatement(ObservationID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                        propertyValue
                ));
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public static void removeResultTime(MessagePayload payload, EntityID ObservationID) {
        payload.getJenaModel().removeAll(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/phenomenonTime object property assertion
     */
    public static Optional<EntityID> getPhenomenonTime(MessagePayload payload, EntityID ObservationID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/phenomenonTime"))
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
     * Setter for http://www.w3.org/ns/sosa/phenomenonTime object property assertion
     */
    public static void setPhenomenonTime(MessagePayload payload, EntityID ObservationID, EntityID propertyValue) {
        removePhenomenonTime(payload, ObservationID);
        payload.getJenaModel().add(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/phenomenonTime"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/phenomenonTime object property assertion
     */
    public static void removePhenomenonTime(MessagePayload payload, EntityID ObservationID) {
        payload.getJenaModel().removeAll(ObservationID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/phenomenonTime"),
                null);
    }

    public void createObservation(MessagePayload payload, EntityID ObservationID) {
        payload.getJenaModel().add(ObservationID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    public Set<EntityID> getObservations(MessagePayload payload) {
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