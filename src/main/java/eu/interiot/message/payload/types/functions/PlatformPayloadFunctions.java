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
 * Payload for class Platform with URI http://www.w3.org/ns/sosa/Platform
 * <p>
 * Attributes:
 * InDeployment, Hosts
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class PlatformPayloadFunctions extends MessagePayloadFunctions {

    /*
 Properties:
 InDeployment, Hosts
 */
    private static EntityID entityType = new EntityID("http://www.w3.org/ns/sosa/Platform");

    public static EntityID getEntityType() {
        return entityType;
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public static Set<EntityID> getInDeployment(MessagePayload payload, EntityID PlatformID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                PlatformID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"))
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
     * Setter for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public static void setInDeployment(MessagePayload payload, EntityID PlatformID, EntityID propertyValue) {
        removeAllInDeployment(payload, PlatformID);
        payload.getJenaModel().add(PlatformID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public static void setInDeployment(MessagePayload payload, EntityID PlatformID, Set<EntityID> propertyValues) {
        removeAllInDeployment(payload, PlatformID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(PlatformID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public static void removeInDeployment(MessagePayload payload, EntityID PlatformID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(PlatformID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public static void removeAllInDeployment(MessagePayload payload, EntityID PlatformID) {
        payload.getJenaModel().removeAll(PlatformID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public static void addInDeployment(MessagePayload payload, EntityID PlatformID, EntityID propertyValue) {
        payload.getJenaModel().add(PlatformID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public static Set<EntityID> getHosts(MessagePayload payload, EntityID PlatformID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                PlatformID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"))
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
     * Setter for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public static void setHosts(MessagePayload payload, EntityID PlatformID, EntityID propertyValue) {
        removeAllHosts(payload, PlatformID);
        payload.getJenaModel().add(PlatformID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public static void setHosts(MessagePayload payload, EntityID PlatformID, Set<EntityID> propertyValues) {
        removeAllHosts(payload, PlatformID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(PlatformID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public static void removeHosts(MessagePayload payload, EntityID PlatformID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(PlatformID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public static void removeAllHosts(MessagePayload payload, EntityID PlatformID) {
        payload.getJenaModel().removeAll(PlatformID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public static void addHosts(MessagePayload payload, EntityID PlatformID, EntityID propertyValue) {
        payload.getJenaModel().add(PlatformID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"),
                propertyValue.getJenaResource());
    }

    public void createPlatform(MessagePayload payload, EntityID PlatformID) {
        payload.getJenaModel().add(PlatformID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    public Set<EntityID> getPlatforms(MessagePayload payload) {
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