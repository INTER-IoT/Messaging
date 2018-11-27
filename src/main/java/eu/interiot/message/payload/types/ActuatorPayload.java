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
 * Payload for class Actuator with URI http://www.w3.org/ns/sosa/Actuator
 * <p>
 * Attributes:
 * Implements, IsHostedBy, HasSubSystem, MadeActuation, ForProperty, HasDeployment
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://www.w3.org/ns/ssn/System
 */
public class ActuatorPayload extends TypedPayload {

    public ActuatorPayload() {
        this(false);
    }

    public ActuatorPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Actuator"), useRDFSInferencer);
    }

    public ActuatorPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public ActuatorPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Actuator"), jenaModel, useRDFSInferencer);
    }

    public void createActuator(EntityID ActuatorID) {
        createTypedEntity(ActuatorID);
    }

    public Set<EntityID> getActuators() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public Set<EntityID> getImplements(EntityID ActuatorID) {
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
    public void setImplements(EntityID ActuatorID, EntityID propertyValue) {
        removeAllImplements(ActuatorID);
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void setImplements(EntityID ActuatorID, Set<EntityID> propertyValues) {
        removeAllImplements(ActuatorID);
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
    public void removeImplements(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void removeAllImplements(EntityID ActuatorID) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/implements object property assertion
     */
    public void addImplements(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implements"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public Set<EntityID> getIsHostedBy(EntityID ActuatorID) {
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
    public void setIsHostedBy(EntityID ActuatorID, EntityID propertyValue) {
        removeAllIsHostedBy(ActuatorID);
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void setIsHostedBy(EntityID ActuatorID, Set<EntityID> propertyValues) {
        removeAllIsHostedBy(ActuatorID);
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
    public void removeIsHostedBy(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void removeAllIsHostedBy(EntityID ActuatorID) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isHostedBy object property assertion
     */
    public void addIsHostedBy(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public Set<EntityID> getHasSubSystem(EntityID ActuatorID) {
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
    public void setHasSubSystem(EntityID ActuatorID, EntityID propertyValue) {
        removeAllHasSubSystem(ActuatorID);
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void setHasSubSystem(EntityID ActuatorID, Set<EntityID> propertyValues) {
        removeAllHasSubSystem(ActuatorID);
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
    public void removeHasSubSystem(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void removeAllHasSubSystem(EntityID ActuatorID) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasSubSystem object property assertion
     */
    public void addHasSubSystem(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasSubSystem"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeActuation object property assertion
     */
    public Set<EntityID> getMadeActuation(EntityID ActuatorID) {
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
    public void setMadeActuation(EntityID ActuatorID, EntityID propertyValue) {
        removeAllMadeActuation(ActuatorID);
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeActuation"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/madeActuation object property assertion
     */
    public void setMadeActuation(EntityID ActuatorID, Set<EntityID> propertyValues) {
        removeAllMadeActuation(ActuatorID);
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
    public void removeMadeActuation(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeActuation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeActuation object property assertion
     */
    public void removeAllMadeActuation(EntityID ActuatorID) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeActuation"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/madeActuation object property assertion
     */
    public void addMadeActuation(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeActuation"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public Set<EntityID> getForProperty(EntityID ActuatorID) {
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
    public void setForProperty(EntityID ActuatorID, EntityID propertyValue) {
        removeAllForProperty(ActuatorID);
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void setForProperty(EntityID ActuatorID, Set<EntityID> propertyValues) {
        removeAllForProperty(ActuatorID);
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
    public void removeForProperty(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void removeAllForProperty(EntityID ActuatorID) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/forProperty object property assertion
     */
    public void addForProperty(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/forProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public Set<EntityID> getHasDeployment(EntityID ActuatorID) {
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
    public void setHasDeployment(EntityID ActuatorID, EntityID propertyValue) {
        removeAllHasDeployment(ActuatorID);
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void setHasDeployment(EntityID ActuatorID, Set<EntityID> propertyValues) {
        removeAllHasDeployment(ActuatorID);
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
    public void removeHasDeployment(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void removeAllHasDeployment(EntityID ActuatorID) {
        getJenaModel().removeAll(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasDeployment object property assertion
     */
    public void addHasDeployment(EntityID ActuatorID, EntityID propertyValue) {
        getJenaModel().add(ActuatorID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasDeployment"),
                propertyValue.getJenaResource());
    }

}