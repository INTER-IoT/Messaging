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
 * Payload for class Actuator with URI http://www.w3.org/ns/sosa/Actuator
 * <p>
 * Attributes:
 * Implements, IsHostedBy, HasSubSystem, MadeActuation, ForProperty, HasDeployment
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://www.w3.org/ns/ssn/System
 */
public class ActuatorInstancedPayload extends InstancedPayload {

   /*
Properties:
Implements, IsHostedBy, HasSubSystem, MadeActuation, ForProperty, HasDeployment
*/

    public ActuatorInstancedPayload(EntityID ActuatorID) {
        this(ActuatorID, false);
    }

    public ActuatorInstancedPayload(EntityID ActuatorID, boolean useRDFSInferencer) {
        super(ActuatorID, new EntityID("http://www.w3.org/ns/sosa/Actuator"), useRDFSInferencer);
    }

    public ActuatorInstancedPayload(EntityID ActuatorID, Model jenaModel) {
        this(ActuatorID, jenaModel, false);
    }

    public ActuatorInstancedPayload(EntityID ActuatorID, Model jenaModel, boolean useRDFSInferencer) {
        super(ActuatorID, new EntityID("http://www.w3.org/ns/sosa/Actuator"), jenaModel, useRDFSInferencer);
    }

    public EntityID getActuatorInstanceID() {
        return getEntityInstanceID();
    }

    public void setActuatorInstanceID(EntityID ActuatorID) {
        setEntityInstanceID(ActuatorID);
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public Set<EntityID> getImplements() {
        EntityID ActuatorID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuatorID.getJenaResource(),
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
        EntityID ActuatorID = getEntityInstanceID();

        removeAllImplements();
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void setImplements(Set<EntityID> propertyValues) {
        EntityID ActuatorID = getEntityInstanceID();

        removeAllImplements();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuatorID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void removeImplements(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void removeAllImplements() {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void addImplements(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public Set<EntityID> getIsHostedBy() {
        EntityID ActuatorID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuatorID.getJenaResource(),
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
        EntityID ActuatorID = getEntityInstanceID();

        removeAllIsHostedBy();
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void setIsHostedBy(Set<EntityID> propertyValues) {
        EntityID ActuatorID = getEntityInstanceID();

        removeAllIsHostedBy();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuatorID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void removeIsHostedBy(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void removeAllIsHostedBy() {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void addIsHostedBy(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public Set<EntityID> getHasSubSystem() {
        EntityID ActuatorID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuatorID.getJenaResource(),
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
        EntityID ActuatorID = getEntityInstanceID();

        removeAllHasSubSystem();
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void setHasSubSystem(Set<EntityID> propertyValues) {
        EntityID ActuatorID = getEntityInstanceID();

        removeAllHasSubSystem();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuatorID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void removeHasSubSystem(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void removeAllHasSubSystem() {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void addHasSubSystem(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeActuation object property assertion
     */
    public Set<EntityID> getMadeActuation() {
        EntityID ActuatorID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeActuation"))
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
     * Setter for http://www.w3.org/ns/sosa/madeActuation object property assertion
     */
    public void setMadeActuation(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();

        removeAllMadeActuation();
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeActuation"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/madeActuation object property assertion
     */
    public void setMadeActuation(Set<EntityID> propertyValues) {
        EntityID ActuatorID = getEntityInstanceID();

        removeAllMadeActuation();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuatorID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeActuation"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeActuation object property assertion
     */
    public void removeMadeActuation(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeActuation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeActuation object property assertion
     */
    public void removeAllMadeActuation() {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeActuation"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/madeActuation object property assertion
     */
    public void addMadeActuation(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeActuation"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public Set<EntityID> getForProperty() {
        EntityID ActuatorID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuatorID.getJenaResource(),
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
    public void setForProperty(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();

        removeAllForProperty();
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void setForProperty(Set<EntityID> propertyValues) {
        EntityID ActuatorID = getEntityInstanceID();

        removeAllForProperty();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuatorID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void removeForProperty(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void removeAllForProperty() {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void addForProperty(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public Set<EntityID> getHasDeployment() {
        EntityID ActuatorID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuatorID.getJenaResource(),
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
        EntityID ActuatorID = getEntityInstanceID();

        removeAllHasDeployment();
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void setHasDeployment(Set<EntityID> propertyValues) {
        EntityID ActuatorID = getEntityInstanceID();

        removeAllHasDeployment();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuatorID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void removeHasDeployment(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void removeAllHasDeployment() {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void addHasDeployment(EntityID propertyValue) {
        EntityID ActuatorID = getEntityInstanceID();

        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

}