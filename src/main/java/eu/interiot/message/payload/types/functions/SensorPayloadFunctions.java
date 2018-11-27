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
 * Payload for class Sensor with URI http://www.w3.org/ns/sosa/Sensor
 * <p>
 * Attributes:
 * HasLocation, HasName, IsHostedBy, MadeObservation
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class SensorPayloadFunctions extends MessagePayloadFunctions {

    /*
 Properties:
 HasLocation, HasName, IsHostedBy, MadeObservation
 */
    private static EntityID entityType = new EntityID("http://www.w3.org/ns/sosa/Sensor");

    public static EntityID getEntityType() {
        return entityType;
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public static Optional<EntityID> getHasLocation(MessagePayload payload, EntityID SensorID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SensorID.getJenaResource(),
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
    public static void setHasLocation(MessagePayload payload, EntityID SensorID, EntityID propertyValue) {
        removeHasLocation(payload, SensorID);
        payload.getJenaModel().add(SensorID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public static void removeHasLocation(MessagePayload payload, EntityID SensorID) {
        payload.getJenaModel().removeAll(SensorID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                null);
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasName data property assertion
     */
    public static Optional<String> getHasName(MessagePayload payload, EntityID SensorID) {
        Set<Object> s = payload.getJenaModel().listObjectsOfProperty(
                SensorID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasName"))
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
     * Setter for http://inter-iot.eu/GOIoTP#hasName data property assertion
     */
    public static void setHasName(MessagePayload payload, EntityID SensorID, String propertyValue) {
        removeHasName(payload, SensorID);
        payload.getJenaModel().add(
                payload.getJenaModel().createLiteralStatement(SensorID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasName"),
                        propertyValue
                ));
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasName data property assertion
     */
    public static void removeHasName(MessagePayload payload, EntityID SensorID) {
        payload.getJenaModel().removeAll(SensorID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasName"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static Optional<EntityID> getIsHostedBy(MessagePayload payload, EntityID SensorID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SensorID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"))
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
     * Setter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void setIsHostedBy(MessagePayload payload, EntityID SensorID, EntityID propertyValue) {
        removeIsHostedBy(payload, SensorID);
        payload.getJenaModel().add(SensorID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void removeIsHostedBy(MessagePayload payload, EntityID SensorID) {
        payload.getJenaModel().removeAll(SensorID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeObservation object property assertion
     */
    public static Optional<EntityID> getMadeObservation(MessagePayload payload, EntityID SensorID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SensorID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeObservation"))
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
     * Setter for http://www.w3.org/ns/sosa/madeObservation object property assertion
     */
    public static void setMadeObservation(MessagePayload payload, EntityID SensorID, EntityID propertyValue) {
        removeMadeObservation(payload, SensorID);
        payload.getJenaModel().add(SensorID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeObservation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeObservation object property assertion
     */
    public static void removeMadeObservation(MessagePayload payload, EntityID SensorID) {
        payload.getJenaModel().removeAll(SensorID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeObservation"),
                null);
    }

    public void createSensor(MessagePayload payload, EntityID SensorID) {
        payload.getJenaModel().add(SensorID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    public Set<EntityID> getSensors(MessagePayload payload) {
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