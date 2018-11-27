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

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class Deployment with URI http://www.w3.org/ns/ssn/Deployment
 * <p>
 * Attributes:
 * DeployedOnPlatform, ForProperty, DeployedSystem
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class DeploymentPayload extends TypedPayload {

    public DeploymentPayload() {
        this(false);
    }

    public DeploymentPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/ssn/Deployment"), useRDFSInferencer);
    }

    public DeploymentPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public DeploymentPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/ssn/Deployment"), jenaModel, useRDFSInferencer);
    }

    public void createDeployment(EntityID DeploymentID) {
        createTypedEntity(DeploymentID);
    }

    public Set<EntityID> getDeployments() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public Set<EntityID> getDeployedOnPlatform(EntityID DeploymentID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"))
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
    public void setDeployedOnPlatform(EntityID DeploymentID, EntityID propertyValue) {
        removeAllDeployedOnPlatform(DeploymentID);
        getJenaModel().add(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public void setDeployedOnPlatform(EntityID DeploymentID, Set<EntityID> propertyValues) {
        removeAllDeployedOnPlatform(DeploymentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(DeploymentID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public void removeDeployedOnPlatform(EntityID DeploymentID, EntityID propertyValue) {
        getJenaModel().removeAll(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public void removeAllDeployedOnPlatform(EntityID DeploymentID) {
        getJenaModel().removeAll(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/deployedOnPlatform object property assertion
     */
    public void addDeployedOnPlatform(EntityID DeploymentID, EntityID propertyValue) {
        getJenaModel().add(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedOnPlatform"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public Set<EntityID> getForProperty(EntityID DeploymentID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"))
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
    public void setForProperty(EntityID DeploymentID, EntityID propertyValue) {
        removeAllForProperty(DeploymentID);
        getJenaModel().add(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void setForProperty(EntityID DeploymentID, Set<EntityID> propertyValues) {
        removeAllForProperty(DeploymentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(DeploymentID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void removeForProperty(EntityID DeploymentID, EntityID propertyValue) {
        getJenaModel().removeAll(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void removeAllForProperty(EntityID DeploymentID) {
        getJenaModel().removeAll(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void addForProperty(EntityID DeploymentID, EntityID propertyValue) {
        getJenaModel().add(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public Set<EntityID> getDeployedSystem(EntityID DeploymentID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"))
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
    public void setDeployedSystem(EntityID DeploymentID, EntityID propertyValue) {
        removeAllDeployedSystem(DeploymentID);
        getJenaModel().add(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public void setDeployedSystem(EntityID DeploymentID, Set<EntityID> propertyValues) {
        removeAllDeployedSystem(DeploymentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(DeploymentID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public void removeDeployedSystem(EntityID DeploymentID, EntityID propertyValue) {
        getJenaModel().removeAll(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public void removeAllDeployedSystem(EntityID DeploymentID) {
        getJenaModel().removeAll(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/deployedSystem object property assertion
     */
    public void addDeployedSystem(EntityID DeploymentID, EntityID propertyValue) {
        getJenaModel().add(DeploymentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/deployedSystem"),
                propertyValue.getJenaResource());
    }

}