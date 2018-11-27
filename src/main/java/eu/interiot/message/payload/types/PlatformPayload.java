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
 * Payload for class Platform with URI http://www.w3.org/ns/sosa/Platform
 * <p>
 * Attributes:
 * InDeployment, Hosts
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class PlatformPayload extends TypedPayload {

    public PlatformPayload() {
        this(false);
    }

    public PlatformPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Platform"), useRDFSInferencer);
    }

    public PlatformPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public PlatformPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Platform"), jenaModel, useRDFSInferencer);
    }

    public void createPlatform(EntityID PlatformID) {
        createTypedEntity(PlatformID);
    }

    public Set<EntityID> getPlatforms() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public Set<EntityID> getInDeployment(EntityID PlatformID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                PlatformID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"))
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
    public void setInDeployment(EntityID PlatformID, EntityID propertyValue) {
        removeAllInDeployment(PlatformID);
        getJenaModel().add(PlatformID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public void setInDeployment(EntityID PlatformID, Set<EntityID> propertyValues) {
        removeAllInDeployment(PlatformID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(PlatformID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public void removeInDeployment(EntityID PlatformID, EntityID propertyValue) {
        getJenaModel().removeAll(PlatformID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public void removeAllInDeployment(EntityID PlatformID) {
        getJenaModel().removeAll(PlatformID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/inDeployment object property assertion
     */
    public void addInDeployment(EntityID PlatformID, EntityID propertyValue) {
        getJenaModel().add(PlatformID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/inDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public Set<EntityID> getHosts(EntityID PlatformID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                PlatformID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"))
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
    public void setHosts(EntityID PlatformID, EntityID propertyValue) {
        removeAllHosts(PlatformID);
        getJenaModel().add(PlatformID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public void setHosts(EntityID PlatformID, Set<EntityID> propertyValues) {
        removeAllHosts(PlatformID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(PlatformID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public void removeHosts(EntityID PlatformID, EntityID propertyValue) {
        getJenaModel().removeAll(PlatformID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public void removeAllHosts(EntityID PlatformID) {
        getJenaModel().removeAll(PlatformID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hosts object property assertion
     */
    public void addHosts(EntityID PlatformID, EntityID propertyValue) {
        getJenaModel().add(PlatformID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hosts"),
                propertyValue.getJenaResource());
    }

}