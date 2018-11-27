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


package eu.interiot.message.payload.types.instanced;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.exceptions.payload.IdentifierException;
import eu.interiot.message.payload.InstancedPayload;
import org.apache.jena.rdf.model.Model;

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
public class PlatformComponentInstancedPayload extends InstancedPayload {

   /*
Properties:
Implements, IsHostedBy, HasSubSystem, HasLocation, HasDeployment
*/

    public PlatformComponentInstancedPayload(EntityID PlatformComponentID) {
        this(PlatformComponentID, false);
    }

    public PlatformComponentInstancedPayload(EntityID PlatformComponentID, boolean useRDFSInferencer) {
        super(PlatformComponentID, new EntityID("http://inter-iot.eu/GOIoTP#PlatformComponent"), useRDFSInferencer);
    }

    public PlatformComponentInstancedPayload(EntityID PlatformComponentID, Model jenaModel) {
        this(PlatformComponentID, jenaModel, false);
    }

    public PlatformComponentInstancedPayload(EntityID PlatformComponentID, Model jenaModel, boolean useRDFSInferencer) {
        super(PlatformComponentID, new EntityID("http://inter-iot.eu/GOIoTP#PlatformComponent"), jenaModel, useRDFSInferencer);
    }

    public EntityID getPlatformComponentInstanceID() {
        return getEntityInstanceID();
    }

    public void setPlatformComponentInstanceID(EntityID PlatformComponentID) {
        setEntityInstanceID(PlatformComponentID);
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public Set<EntityID> getImplements() {
        EntityID PlatformComponentID = getEntityInstanceID();

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
    public void setImplements(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();

        removeAllImplements();
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void setImplements(Set<EntityID> propertyValues) {
        EntityID PlatformComponentID = getEntityInstanceID();

        removeAllImplements();
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
    public void removeImplements(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void removeAllImplements() {
        EntityID PlatformComponentID = getEntityInstanceID();

        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void addImplements(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();

        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public Set<EntityID> getIsHostedBy() {
        EntityID PlatformComponentID = getEntityInstanceID();

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
    public void setIsHostedBy(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();

        removeAllIsHostedBy();
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void setIsHostedBy(Set<EntityID> propertyValues) {
        EntityID PlatformComponentID = getEntityInstanceID();

        removeAllIsHostedBy();
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
    public void removeIsHostedBy(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void removeAllIsHostedBy() {
        EntityID PlatformComponentID = getEntityInstanceID();

        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void addIsHostedBy(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();

        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public Set<EntityID> getHasSubSystem() {
        EntityID PlatformComponentID = getEntityInstanceID();

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
    public void setHasSubSystem(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();

        removeAllHasSubSystem();
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void setHasSubSystem(Set<EntityID> propertyValues) {
        EntityID PlatformComponentID = getEntityInstanceID();

        removeAllHasSubSystem();
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
    public void removeHasSubSystem(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void removeAllHasSubSystem() {
        EntityID PlatformComponentID = getEntityInstanceID();

        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void addHasSubSystem(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();

        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public Set<EntityID> getHasLocation() {
        EntityID PlatformComponentID = getEntityInstanceID();

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
    public void setHasLocation(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();

        removeAllHasLocation();
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void setHasLocation(Set<EntityID> propertyValues) {
        EntityID PlatformComponentID = getEntityInstanceID();

        removeAllHasLocation();
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
    public void removeHasLocation(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void removeAllHasLocation() {
        EntityID PlatformComponentID = getEntityInstanceID();

        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                null);
    }

    /**
     * Adder for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void addHasLocation(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();

        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public Set<EntityID> getHasDeployment() {
        EntityID PlatformComponentID = getEntityInstanceID();

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
    public void setHasDeployment(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();

        removeAllHasDeployment();
        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void setHasDeployment(Set<EntityID> propertyValues) {
        EntityID PlatformComponentID = getEntityInstanceID();

        removeAllHasDeployment();
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
    public void removeHasDeployment(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();
        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void removeAllHasDeployment() {
        EntityID PlatformComponentID = getEntityInstanceID();

        getJenaModel().removeAll(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void addHasDeployment(EntityID propertyValue) {
        EntityID PlatformComponentID = getEntityInstanceID();

        getJenaModel().add(PlatformComponentID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

}