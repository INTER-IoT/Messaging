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
 * Payload for class PlatformComponent with URI http://inter-iot.eu/GOIoTP#PlatformComponent
 * <p>
 * Attributes:
 * Implements, IsHostedBy, HasSubSystem, HasLocation, HasDeployment
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://www.w3.org/ns/ssn/System
 */
public class PlatformComponentPayload extends TypedPayload {

    public PlatformComponentPayload() {
        this(false);
    }

    public PlatformComponentPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://inter-iot.eu/GOIoTP#PlatformComponent"), useRDFSInferencer);
    }

    public PlatformComponentPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public PlatformComponentPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://inter-iot.eu/GOIoTP#PlatformComponent"), jenaModel, useRDFSInferencer);
    }

    public void createPlatformComponent(EntityID PlatformComponentID) {
        createTypedEntity(PlatformComponentID);
    }

    public Set<EntityID> getPlatformComponents() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public Set<EntityID> getImplements(EntityID PlatformComponentID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                PlatformComponentID.getJenaResource(),
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
    public void setImplements(EntityID PlatformComponentID, EntityID propertyValue) {
        removeAllImplements(PlatformComponentID);
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void setImplements(EntityID PlatformComponentID, Set<EntityID> propertyValues) {
        removeAllImplements(PlatformComponentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(PlatformComponentID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void removeImplements(EntityID PlatformComponentID, EntityID propertyValue) {
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void removeAllImplements(EntityID PlatformComponentID) {
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void addImplements(EntityID PlatformComponentID, EntityID propertyValue) {
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public Set<EntityID> getIsHostedBy(EntityID PlatformComponentID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                PlatformComponentID.getJenaResource(),
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
    public void setIsHostedBy(EntityID PlatformComponentID, EntityID propertyValue) {
        removeAllIsHostedBy(PlatformComponentID);
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void setIsHostedBy(EntityID PlatformComponentID, Set<EntityID> propertyValues) {
        removeAllIsHostedBy(PlatformComponentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(PlatformComponentID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void removeIsHostedBy(EntityID PlatformComponentID, EntityID propertyValue) {
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void removeAllIsHostedBy(EntityID PlatformComponentID) {
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void addIsHostedBy(EntityID PlatformComponentID, EntityID propertyValue) {
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public Set<EntityID> getHasSubSystem(EntityID PlatformComponentID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                PlatformComponentID.getJenaResource(),
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
    public void setHasSubSystem(EntityID PlatformComponentID, EntityID propertyValue) {
        removeAllHasSubSystem(PlatformComponentID);
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void setHasSubSystem(EntityID PlatformComponentID, Set<EntityID> propertyValues) {
        removeAllHasSubSystem(PlatformComponentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(PlatformComponentID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void removeHasSubSystem(EntityID PlatformComponentID, EntityID propertyValue) {
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void removeAllHasSubSystem(EntityID PlatformComponentID) {
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void addHasSubSystem(EntityID PlatformComponentID, EntityID propertyValue) {
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public Set<EntityID> getHasLocation(EntityID PlatformComponentID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"))
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
    public void setHasLocation(EntityID PlatformComponentID, EntityID propertyValue) {
        removeAllHasLocation(PlatformComponentID);
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void setHasLocation(EntityID PlatformComponentID, Set<EntityID> propertyValues) {
        removeAllHasLocation(PlatformComponentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(PlatformComponentID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void removeHasLocation(EntityID PlatformComponentID, EntityID propertyValue) {
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void removeAllHasLocation(EntityID PlatformComponentID) {
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                null);
    }

    /**
     * Adder for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void addHasLocation(EntityID PlatformComponentID, EntityID propertyValue) {
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public Set<EntityID> getHasDeployment(EntityID PlatformComponentID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                PlatformComponentID.getJenaResource(),
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
    public void setHasDeployment(EntityID PlatformComponentID, EntityID propertyValue) {
        removeAllHasDeployment(PlatformComponentID);
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void setHasDeployment(EntityID PlatformComponentID, Set<EntityID> propertyValues) {
        removeAllHasDeployment(PlatformComponentID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(PlatformComponentID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void removeHasDeployment(EntityID PlatformComponentID, EntityID propertyValue) {
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void removeAllHasDeployment(EntityID PlatformComponentID) {
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void addHasDeployment(EntityID PlatformComponentID, EntityID propertyValue) {
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

}