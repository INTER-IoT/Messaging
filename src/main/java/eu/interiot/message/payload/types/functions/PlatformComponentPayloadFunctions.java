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
 * Payload for class PlatformComponent with URI http://inter-iot.eu/GOIoTP#PlatformComponent
 * <p>
 * Attributes:
 * Implements, IsHostedBy, HasSubSystem, HasLocation, HasDeployment
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://www.w3.org/ns/ssn/System
 */
public class PlatformComponentPayloadFunctions extends MessagePayloadFunctions {

    /*
 Properties:
 Implements, IsHostedBy, HasSubSystem, HasLocation, HasDeployment
 */
    private static EntityID entityType = new EntityID("http://inter-iot.eu/GOIoTP#PlatformComponent");

    public static EntityID getEntityType() {
        return entityType;
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static Set<EntityID> getImplements(MessagePayload payload, EntityID PlatformComponentID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                PlatformComponentID.getJenaResource(),
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
    public static void setImplements(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        removeAllImplements(payload, PlatformComponentID);
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static void setImplements(MessagePayload payload, EntityID PlatformComponentID, Set<EntityID> propertyValues) {
        removeAllImplements(payload, PlatformComponentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static void removeImplements(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static void removeAllImplements(MessagePayload payload, EntityID PlatformComponentID) {
        payload.getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public static void addImplements(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static Set<EntityID> getIsHostedBy(MessagePayload payload, EntityID PlatformComponentID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                PlatformComponentID.getJenaResource(),
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
    public static void setIsHostedBy(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        removeAllIsHostedBy(payload, PlatformComponentID);
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void setIsHostedBy(MessagePayload payload, EntityID PlatformComponentID, Set<EntityID> propertyValues) {
        removeAllIsHostedBy(payload, PlatformComponentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void removeIsHostedBy(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void removeAllIsHostedBy(MessagePayload payload, EntityID PlatformComponentID) {
        payload.getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public static void addIsHostedBy(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static Set<EntityID> getHasSubSystem(MessagePayload payload, EntityID PlatformComponentID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                PlatformComponentID.getJenaResource(),
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
    public static void setHasSubSystem(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        removeAllHasSubSystem(payload, PlatformComponentID);
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static void setHasSubSystem(MessagePayload payload, EntityID PlatformComponentID, Set<EntityID> propertyValues) {
        removeAllHasSubSystem(payload, PlatformComponentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static void removeHasSubSystem(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static void removeAllHasSubSystem(MessagePayload payload, EntityID PlatformComponentID) {
        payload.getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public static void addHasSubSystem(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public static Set<EntityID> getHasLocation(MessagePayload payload, EntityID PlatformComponentID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                PlatformComponentID.getJenaResource(),
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

        return s;
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public static void setHasLocation(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        removeAllHasLocation(payload, PlatformComponentID);
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public static void setHasLocation(MessagePayload payload, EntityID PlatformComponentID, Set<EntityID> propertyValues) {
        removeAllHasLocation(payload, PlatformComponentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public static void removeHasLocation(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public static void removeAllHasLocation(MessagePayload payload, EntityID PlatformComponentID) {
        payload.getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                null);
    }

    /**
     * Adder for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public static void addHasLocation(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static Set<EntityID> getHasDeployment(MessagePayload payload, EntityID PlatformComponentID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                PlatformComponentID.getJenaResource(),
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
    public static void setHasDeployment(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        removeAllHasDeployment(payload, PlatformComponentID);
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static void setHasDeployment(MessagePayload payload, EntityID PlatformComponentID, Set<EntityID> propertyValues) {
        removeAllHasDeployment(payload, PlatformComponentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static void removeHasDeployment(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static void removeAllHasDeployment(MessagePayload payload, EntityID PlatformComponentID) {
        payload.getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public static void addHasDeployment(MessagePayload payload, EntityID PlatformComponentID, EntityID propertyValue) {
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    public void createPlatformComponent(MessagePayload payload, EntityID PlatformComponentID) {
        payload.getJenaModel().add(PlatformComponentID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    public Set<EntityID> getPlatformComponents(MessagePayload payload) {
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