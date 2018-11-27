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
 * Payload for class System with URI http://www.w3.org/ns/ssn/System
 * <p>
 * Attributes:
 * IsHostedBy, HasDeployment, Implements, HasSubSystem
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class SystemPayload extends TypedPayload {

    public SystemPayload() {
        this(false);
    }

    public SystemPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/ssn/System"), useRDFSInferencer);
    }

    public SystemPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public SystemPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/ssn/System"), jenaModel, useRDFSInferencer);
    }

    public void createSystem(EntityID SystemID) {
        createTypedEntity(SystemID);
    }

    public Set<EntityID> getSystems() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public Set<EntityID> getIsHostedBy(EntityID SystemID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"))
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
    public void setIsHostedBy(EntityID SystemID, EntityID propertyValue) {
        removeAllIsHostedBy(SystemID);
        getJenaModel().add(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void setIsHostedBy(EntityID SystemID, Set<EntityID> propertyValues) {
        removeAllIsHostedBy(SystemID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SystemID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void removeIsHostedBy(EntityID SystemID, EntityID propertyValue) {
        getJenaModel().removeAll(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void removeAllIsHostedBy(EntityID SystemID) {
        getJenaModel().removeAll(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void addIsHostedBy(EntityID SystemID, EntityID propertyValue) {
        getJenaModel().add(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public Set<EntityID> getHasDeployment(EntityID SystemID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"))
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
    public void setHasDeployment(EntityID SystemID, EntityID propertyValue) {
        removeAllHasDeployment(SystemID);
        getJenaModel().add(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void setHasDeployment(EntityID SystemID, Set<EntityID> propertyValues) {
        removeAllHasDeployment(SystemID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SystemID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void removeHasDeployment(EntityID SystemID, EntityID propertyValue) {
        getJenaModel().removeAll(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void removeAllHasDeployment(EntityID SystemID) {
        getJenaModel().removeAll(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void addHasDeployment(EntityID SystemID, EntityID propertyValue) {
        getJenaModel().add(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public Set<EntityID> getImplements(EntityID SystemID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"))
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
    public void setImplements(EntityID SystemID, EntityID propertyValue) {
        removeAllImplements(SystemID);
        getJenaModel().add(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void setImplements(EntityID SystemID, Set<EntityID> propertyValues) {
        removeAllImplements(SystemID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SystemID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void removeImplements(EntityID SystemID, EntityID propertyValue) {
        getJenaModel().removeAll(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void removeAllImplements(EntityID SystemID) {
        getJenaModel().removeAll(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void addImplements(EntityID SystemID, EntityID propertyValue) {
        getJenaModel().add(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public Set<EntityID> getHasSubSystem(EntityID SystemID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"))
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
    public void setHasSubSystem(EntityID SystemID, EntityID propertyValue) {
        removeAllHasSubSystem(SystemID);
        getJenaModel().add(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void setHasSubSystem(EntityID SystemID, Set<EntityID> propertyValues) {
        removeAllHasSubSystem(SystemID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SystemID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void removeHasSubSystem(EntityID SystemID, EntityID propertyValue) {
        getJenaModel().removeAll(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void removeAllHasSubSystem(EntityID SystemID) {
        getJenaModel().removeAll(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void addHasSubSystem(EntityID SystemID, EntityID propertyValue) {
        getJenaModel().add(SystemID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

}