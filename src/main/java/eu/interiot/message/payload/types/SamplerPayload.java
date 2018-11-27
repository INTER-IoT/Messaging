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
 * Payload for class Sampler with URI http://www.w3.org/ns/sosa/Sampler
 * <p>
 * Attributes:
 * Implements, MadeSampling, IsHostedBy, HasSubSystem, HasDeployment
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://www.w3.org/ns/ssn/System
 */
public class SamplerPayload extends TypedPayload {

    public SamplerPayload() {
        this(false);
    }

    public SamplerPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Sampler"), useRDFSInferencer);
    }

    public SamplerPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public SamplerPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Sampler"), jenaModel, useRDFSInferencer);
    }

    public void createSampler(EntityID SamplerID) {
        createTypedEntity(SamplerID);
    }

    public Set<EntityID> getSamplers() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public Set<EntityID> getImplements(EntityID SamplerID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SamplerID.getJenaResource(),
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
    public void setImplements(EntityID SamplerID, EntityID propertyValue) {
        removeAllImplements(SamplerID);
        getJenaModel().add(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void setImplements(EntityID SamplerID, Set<EntityID> propertyValues) {
        removeAllImplements(SamplerID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SamplerID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void removeImplements(EntityID SamplerID, EntityID propertyValue) {
        getJenaModel().removeAll(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void removeAllImplements(EntityID SamplerID) {
        getJenaModel().removeAll(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void addImplements(EntityID SamplerID, EntityID propertyValue) {
        getJenaModel().add(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeSampling object property assertion
     */
    public Set<EntityID> getMadeSampling(EntityID SamplerID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeSampling"))
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
     * Setter for http://www.w3.org/ns/sosa/madeSampling object property assertion
     */
    public void setMadeSampling(EntityID SamplerID, EntityID propertyValue) {
        removeAllMadeSampling(SamplerID);
        getJenaModel().add(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeSampling"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/madeSampling object property assertion
     */
    public void setMadeSampling(EntityID SamplerID, Set<EntityID> propertyValues) {
        removeAllMadeSampling(SamplerID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SamplerID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeSampling"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeSampling object property assertion
     */
    public void removeMadeSampling(EntityID SamplerID, EntityID propertyValue) {
        getJenaModel().removeAll(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeSampling"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeSampling object property assertion
     */
    public void removeAllMadeSampling(EntityID SamplerID) {
        getJenaModel().removeAll(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeSampling"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/madeSampling object property assertion
     */
    public void addMadeSampling(EntityID SamplerID, EntityID propertyValue) {
        getJenaModel().add(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeSampling"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public Set<EntityID> getIsHostedBy(EntityID SamplerID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SamplerID.getJenaResource(),
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
    public void setIsHostedBy(EntityID SamplerID, EntityID propertyValue) {
        removeAllIsHostedBy(SamplerID);
        getJenaModel().add(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void setIsHostedBy(EntityID SamplerID, Set<EntityID> propertyValues) {
        removeAllIsHostedBy(SamplerID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SamplerID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void removeIsHostedBy(EntityID SamplerID, EntityID propertyValue) {
        getJenaModel().removeAll(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void removeAllIsHostedBy(EntityID SamplerID) {
        getJenaModel().removeAll(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void addIsHostedBy(EntityID SamplerID, EntityID propertyValue) {
        getJenaModel().add(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public Set<EntityID> getHasSubSystem(EntityID SamplerID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SamplerID.getJenaResource(),
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
    public void setHasSubSystem(EntityID SamplerID, EntityID propertyValue) {
        removeAllHasSubSystem(SamplerID);
        getJenaModel().add(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void setHasSubSystem(EntityID SamplerID, Set<EntityID> propertyValues) {
        removeAllHasSubSystem(SamplerID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SamplerID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void removeHasSubSystem(EntityID SamplerID, EntityID propertyValue) {
        getJenaModel().removeAll(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void removeAllHasSubSystem(EntityID SamplerID) {
        getJenaModel().removeAll(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void addHasSubSystem(EntityID SamplerID, EntityID propertyValue) {
        getJenaModel().add(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public Set<EntityID> getHasDeployment(EntityID SamplerID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SamplerID.getJenaResource(),
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
    public void setHasDeployment(EntityID SamplerID, EntityID propertyValue) {
        removeAllHasDeployment(SamplerID);
        getJenaModel().add(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void setHasDeployment(EntityID SamplerID, Set<EntityID> propertyValues) {
        removeAllHasDeployment(SamplerID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SamplerID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void removeHasDeployment(EntityID SamplerID, EntityID propertyValue) {
        getJenaModel().removeAll(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void removeAllHasDeployment(EntityID SamplerID) {
        getJenaModel().removeAll(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void addHasDeployment(EntityID SamplerID, EntityID propertyValue) {
        getJenaModel().add(SamplerID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

}