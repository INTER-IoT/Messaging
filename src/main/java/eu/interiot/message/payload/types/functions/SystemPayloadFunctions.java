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
 * Payload for class System with URI http://www.w3.org/ns/ssn/System
 * <p>
 * Attributes:
 * IsHostedBy, HasDeployment, Implements, HasSubSystem
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class SystemPayloadFunctions extends MessagePayloadFunctions {

    /*
 Properties:
 IsHostedBy, HasDeployment, Implements, HasSubSystem
 */
    private static EntityID entityType = new EntityID("http://www.w3.org/ns/ssn/System");

    public static EntityID getEntityType() {
        return entityType;
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static Set<EntityID> getIsHostedBy(MessagePayload payload, EntityID SystemID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SystemID.getJenaResource(),
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

        return s;
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void setIsHostedBy(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        removeAllIsHostedBy(payload, SystemID);
        payload.getJenaModel().add(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void setIsHostedBy(MessagePayload payload, EntityID SystemID, Set<EntityID> propertyValues) {
        removeAllIsHostedBy(payload, SystemID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(SystemID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void removeIsHostedBy(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void removeAllIsHostedBy(MessagePayload payload, EntityID SystemID) {
        payload.getJenaModel().removeAll(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void addIsHostedBy(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        payload.getJenaModel().add(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static Set<EntityID> getHasDeployment(MessagePayload payload, EntityID SystemID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"))
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
     * Setter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static void setHasDeployment(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        removeAllHasDeployment(payload, SystemID);
        payload.getJenaModel().add(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static void setHasDeployment(MessagePayload payload, EntityID SystemID, Set<EntityID> propertyValues) {
        removeAllHasDeployment(payload, SystemID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(SystemID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static void removeHasDeployment(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static void removeAllHasDeployment(MessagePayload payload, EntityID SystemID) {
        payload.getJenaModel().removeAll(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static void addHasDeployment(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        payload.getJenaModel().add(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static Set<EntityID> getImplements(MessagePayload payload, EntityID SystemID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"))
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
     * Setter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static void setImplements(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        removeAllImplements(payload, SystemID);
        payload.getJenaModel().add(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static void setImplements(MessagePayload payload, EntityID SystemID, Set<EntityID> propertyValues) {
        removeAllImplements(payload, SystemID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(SystemID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static void removeImplements(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static void removeAllImplements(MessagePayload payload, EntityID SystemID) {
        payload.getJenaModel().removeAll(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static void addImplements(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        payload.getJenaModel().add(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static Set<EntityID> getHasSubSystem(MessagePayload payload, EntityID SystemID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"))
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
     * Setter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static void setHasSubSystem(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        removeAllHasSubSystem(payload, SystemID);
        payload.getJenaModel().add(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static void setHasSubSystem(MessagePayload payload, EntityID SystemID, Set<EntityID> propertyValues) {
        removeAllHasSubSystem(payload, SystemID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(SystemID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static void removeHasSubSystem(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static void removeAllHasSubSystem(MessagePayload payload, EntityID SystemID) {
        payload.getJenaModel().removeAll(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static void addHasSubSystem(MessagePayload payload, EntityID SystemID, EntityID propertyValue) {
        payload.getJenaModel().add(SystemID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    public void createSystem(MessagePayload payload, EntityID SystemID) {
        payload.getJenaModel().add(SystemID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    public Set<EntityID> getSystems(MessagePayload payload) {
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