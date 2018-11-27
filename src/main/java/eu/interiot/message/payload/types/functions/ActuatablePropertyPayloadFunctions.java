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

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class ActuatableProperty with URI http://www.w3.org/ns/sosa/ActuatableProperty
 * <p>
 * Attributes:
 * IsActedOnBy, IsPropertyOf
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://www.w3.org/ns/ssn/Property
 */
public class ActuatablePropertyPayloadFunctions extends MessagePayloadFunctions {

    /*
 Properties:
 IsActedOnBy, IsPropertyOf
 */
    private static EntityID entityType = new EntityID("http://www.w3.org/ns/sosa/ActuatableProperty");

    public static EntityID getEntityType() {
        return entityType;
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isActedOnBy object property assertion
     */
    public static Set<EntityID> getIsActedOnBy(MessagePayload payload, EntityID ActuatablePropertyID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ActuatablePropertyID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isActedOnBy"))
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
     * Setter for http://www.w3.org/ns/sosa/isActedOnBy object property assertion
     */
    public static void setIsActedOnBy(MessagePayload payload, EntityID ActuatablePropertyID, EntityID propertyValue) {
        removeAllIsActedOnBy(payload, ActuatablePropertyID);
        payload.getJenaModel().add(ActuatablePropertyID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isActedOnBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isActedOnBy object property assertion
     */
    public static void setIsActedOnBy(MessagePayload payload, EntityID ActuatablePropertyID, Set<EntityID> propertyValues) {
        removeAllIsActedOnBy(payload, ActuatablePropertyID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(ActuatablePropertyID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isActedOnBy"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isActedOnBy object property assertion
     */
    public static void removeIsActedOnBy(MessagePayload payload, EntityID ActuatablePropertyID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(ActuatablePropertyID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isActedOnBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isActedOnBy object property assertion
     */
    public static void removeAllIsActedOnBy(MessagePayload payload, EntityID ActuatablePropertyID) {
        payload.getJenaModel().removeAll(ActuatablePropertyID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isActedOnBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isActedOnBy object property assertion
     */
    public static void addIsActedOnBy(MessagePayload payload, EntityID ActuatablePropertyID, EntityID propertyValue) {
        payload.getJenaModel().add(ActuatablePropertyID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isActedOnBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public static Set<EntityID> getIsPropertyOf(MessagePayload payload, EntityID ActuatablePropertyID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ActuatablePropertyID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"))
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
     * Setter for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public static void setIsPropertyOf(MessagePayload payload, EntityID ActuatablePropertyID, EntityID propertyValue) {
        removeAllIsPropertyOf(payload, ActuatablePropertyID);
        payload.getJenaModel().add(ActuatablePropertyID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public static void setIsPropertyOf(MessagePayload payload, EntityID ActuatablePropertyID, Set<EntityID> propertyValues) {
        removeAllIsPropertyOf(payload, ActuatablePropertyID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(ActuatablePropertyID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public static void removeIsPropertyOf(MessagePayload payload, EntityID ActuatablePropertyID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(ActuatablePropertyID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public static void removeAllIsPropertyOf(MessagePayload payload, EntityID ActuatablePropertyID) {
        payload.getJenaModel().removeAll(ActuatablePropertyID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public static void addIsPropertyOf(MessagePayload payload, EntityID ActuatablePropertyID, EntityID propertyValue) {
        payload.getJenaModel().add(ActuatablePropertyID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                propertyValue.getJenaResource());
    }

    public void createActuatableProperty(MessagePayload payload, EntityID ActuatablePropertyID) {
        payload.getJenaModel().add(ActuatablePropertyID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    public Set<EntityID> getActuatablePropertys(MessagePayload payload) {
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