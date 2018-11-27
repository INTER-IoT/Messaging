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
 * Payload for class Deployment with URI http://www.w3.org/ns/ssn/Deployment
 * <p>
 * Attributes:
 * DeployedOnPlatform, ForProperty, DeployedSystem
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class DeploymentPayloadFunctions extends MessagePayloadFunctions {

    /*
 Properties:
 DeployedOnPlatform, ForProperty, DeployedSystem
 */
    private static EntityID entityType = new EntityID("http://www.w3.org/ns/ssn/Deployment");

    public static EntityID getEntityType() {
        return entityType;
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public static Set<EntityID> getDeployedOnPlatform(MessagePayload payload, EntityID DeploymentID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"))
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
     * Setter for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public static void setDeployedOnPlatform(MessagePayload payload, EntityID DeploymentID, EntityID propertyValue) {
        removeAllDeployedOnPlatform(payload, DeploymentID);
        payload.getJenaModel().add(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public static void setDeployedOnPlatform(MessagePayload payload, EntityID DeploymentID, Set<EntityID> propertyValues) {
        removeAllDeployedOnPlatform(payload, DeploymentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(DeploymentID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public static void removeDeployedOnPlatform(MessagePayload payload, EntityID DeploymentID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public static void removeAllDeployedOnPlatform(MessagePayload payload, EntityID DeploymentID) {
        payload.getJenaModel().removeAll(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public static void addDeployedOnPlatform(MessagePayload payload, EntityID DeploymentID, EntityID propertyValue) {
        payload.getJenaModel().add(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public static Set<EntityID> getForProperty(MessagePayload payload, EntityID DeploymentID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"))
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
     * Setter for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public static void setForProperty(MessagePayload payload, EntityID DeploymentID, EntityID propertyValue) {
        removeAllForProperty(payload, DeploymentID);
        payload.getJenaModel().add(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public static void setForProperty(MessagePayload payload, EntityID DeploymentID, Set<EntityID> propertyValues) {
        removeAllForProperty(payload, DeploymentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(DeploymentID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public static void removeForProperty(MessagePayload payload, EntityID DeploymentID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public static void removeAllForProperty(MessagePayload payload, EntityID DeploymentID) {
        payload.getJenaModel().removeAll(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public static void addForProperty(MessagePayload payload, EntityID DeploymentID, EntityID propertyValue) {
        payload.getJenaModel().add(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public static Set<EntityID> getDeployedSystem(MessagePayload payload, EntityID DeploymentID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"))
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
     * Setter for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public static void setDeployedSystem(MessagePayload payload, EntityID DeploymentID, EntityID propertyValue) {
        removeAllDeployedSystem(payload, DeploymentID);
        payload.getJenaModel().add(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public static void setDeployedSystem(MessagePayload payload, EntityID DeploymentID, Set<EntityID> propertyValues) {
        removeAllDeployedSystem(payload, DeploymentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(DeploymentID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public static void removeDeployedSystem(MessagePayload payload, EntityID DeploymentID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public static void removeAllDeployedSystem(MessagePayload payload, EntityID DeploymentID) {
        payload.getJenaModel().removeAll(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public static void addDeployedSystem(MessagePayload payload, EntityID DeploymentID, EntityID propertyValue) {
        payload.getJenaModel().add(DeploymentID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"),
                propertyValue.getJenaResource());
    }

    public void createDeployment(MessagePayload payload, EntityID DeploymentID) {
        payload.getJenaModel().add(DeploymentID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    public Set<EntityID> getDeployments(MessagePayload payload) {
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