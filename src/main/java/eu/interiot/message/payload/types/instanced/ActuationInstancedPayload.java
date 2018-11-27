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
import org.apache.jena.rdf.model.ResourceFactory;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class Actuation with URI http://www.w3.org/ns/sosa/Actuation
 * <p>
 * Attributes:
 * ActsOnProperty, HasFeatureOfInterest, HasResult, UsedProcedure, MadeByActuator, ResultTime
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class ActuationInstancedPayload extends InstancedPayload {

   /*
Properties:
ActsOnProperty, HasFeatureOfInterest, HasResult, UsedProcedure, MadeByActuator, ResultTime
*/

    public ActuationInstancedPayload(EntityID ActuationID) {
        this(ActuationID, false);
    }

    public ActuationInstancedPayload(EntityID ActuationID, boolean useRDFSInferencer) {
        super(ActuationID, new EntityID("http://www.w3.org/ns/sosa/Actuation"), useRDFSInferencer);
    }

    public ActuationInstancedPayload(EntityID ActuationID, Model jenaModel) {
        this(ActuationID, jenaModel, false);
    }

    public ActuationInstancedPayload(EntityID ActuationID, Model jenaModel, boolean useRDFSInferencer) {
        super(ActuationID, new EntityID("http://www.w3.org/ns/sosa/Actuation"), jenaModel, useRDFSInferencer);
    }

    public EntityID getActuationInstanceID() {
        return getEntityInstanceID();
    }

    public void setActuationInstanceID(EntityID ActuationID) {
        setEntityInstanceID(ActuationID);
    }


    /**
     * Getter for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public Set<EntityID> getActsOnProperty() {
        EntityID ActuationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"))
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
     * Setter for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public void setActsOnProperty(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllActsOnProperty();
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public void setActsOnProperty(Set<EntityID> propertyValues) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllActsOnProperty();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public void removeActsOnProperty(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public void removeAllActsOnProperty() {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/actsOnProperty object property assertion
     */
    public void addActsOnProperty(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/actsOnProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public Set<EntityID> getHasFeatureOfInterest() {
        EntityID ActuationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"))
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
     * Setter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void setHasFeatureOfInterest(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllHasFeatureOfInterest();
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void setHasFeatureOfInterest(Set<EntityID> propertyValues) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllHasFeatureOfInterest();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void removeHasFeatureOfInterest(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void removeAllHasFeatureOfInterest() {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void addHasFeatureOfInterest(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public Set<EntityID> getHasResult() {
        EntityID ActuationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"))
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
     * Setter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void setHasResult(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllHasResult();
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void setHasResult(Set<EntityID> propertyValues) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllHasResult();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void removeHasResult(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void removeAllHasResult() {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void addHasResult(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public Set<EntityID> getUsedProcedure() {
        EntityID ActuationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"))
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
     * Setter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void setUsedProcedure(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllUsedProcedure();
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void setUsedProcedure(Set<EntityID> propertyValues) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllUsedProcedure();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void removeUsedProcedure(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void removeAllUsedProcedure() {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void addUsedProcedure(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public Set<EntityID> getMadeByActuator() {
        EntityID ActuationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"))
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
     * Setter for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public void setMadeByActuator(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllMadeByActuator();
        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public void setMadeByActuator(Set<EntityID> propertyValues) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllMadeByActuator();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public void removeMadeByActuator(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();
        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public void removeAllMadeByActuator() {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/madeByActuator object property assertion
     */
    public void addMadeByActuator(EntityID propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeByActuator"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public Set<String> getResultTime() {
        EntityID ActuationID = getEntityInstanceID();

        Set<Object> s = getJenaModel().listObjectsOfProperty(
                ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"))
                .toSet()
                .stream()
                .map(x -> x.asLiteral().getValue())
                .collect(Collectors.toSet());

        Set<String> ss = s.stream().map(y -> {
                    if (y instanceof String) {
                        return (String) y;
                    } else {
                        return null;
                    }
                }
        ).collect(Collectors.toSet());

        if (ss.contains(null))
            ss.remove(null);
        return ss;
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public void setResultTime(String propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllResultTime();
        getJenaModel().add(
                getJenaModel().createLiteralStatement(ActuationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                        propertyValue
                ));
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/resultTime object property assertion
     */
    public void setResultTime(Set<String> propertyValues) {
        EntityID ActuationID = getEntityInstanceID();

        removeAllResultTime();
        for (String e : propertyValues) {
            if (e != null) {
                getJenaModel().add(
                        getJenaModel().createLiteralStatement(ActuationID.getJenaResource(),
                                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                                e
                        ));
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public void removeResultTime(String propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                ResourceFactory.createTypedLiteral(propertyValue));
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/resultTime object property assertion
     */
    public void removeAllResultTime() {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().removeAll(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public void addResultTime(String propertyValue) {
        EntityID ActuationID = getEntityInstanceID();

        getJenaModel().add(ActuationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                propertyValue);
    }

}