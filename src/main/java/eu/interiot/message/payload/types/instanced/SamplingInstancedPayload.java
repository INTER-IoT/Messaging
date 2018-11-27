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
 * Payload for class Sampling with URI http://www.w3.org/ns/sosa/Sampling
 * <p>
 * Attributes:
 * HasFeatureOfInterest, HasResult, UsedProcedure, MadeBySampler, ResultTime
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class SamplingInstancedPayload extends InstancedPayload {

   /*
Properties:
HasFeatureOfInterest, HasResult, UsedProcedure, MadeBySampler, ResultTime
*/

    public SamplingInstancedPayload(EntityID SamplingID) {
        this(SamplingID, false);
    }

    public SamplingInstancedPayload(EntityID SamplingID, boolean useRDFSInferencer) {
        super(SamplingID, new EntityID("http://www.w3.org/ns/sosa/Sampling"), useRDFSInferencer);
    }

    public SamplingInstancedPayload(EntityID SamplingID, Model jenaModel) {
        this(SamplingID, jenaModel, false);
    }

    public SamplingInstancedPayload(EntityID SamplingID, Model jenaModel, boolean useRDFSInferencer) {
        super(SamplingID, new EntityID("http://www.w3.org/ns/sosa/Sampling"), jenaModel, useRDFSInferencer);
    }

    public EntityID getSamplingInstanceID() {
        return getEntityInstanceID();
    }

    public void setSamplingInstanceID(EntityID SamplingID) {
        setEntityInstanceID(SamplingID);
    }


    /**
     * Getter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public Set<EntityID> getHasFeatureOfInterest() {
        EntityID SamplingID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SamplingID.getJenaResource(),
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
        EntityID SamplingID = getEntityInstanceID();

        removeAllHasFeatureOfInterest();
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void setHasFeatureOfInterest(Set<EntityID> propertyValues) {
        EntityID SamplingID = getEntityInstanceID();

        removeAllHasFeatureOfInterest();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SamplingID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void removeHasFeatureOfInterest(EntityID propertyValue) {
        EntityID SamplingID = getEntityInstanceID();
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void removeAllHasFeatureOfInterest() {
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void addHasFeatureOfInterest(EntityID propertyValue) {
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public Set<EntityID> getHasResult() {
        EntityID SamplingID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SamplingID.getJenaResource(),
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
        EntityID SamplingID = getEntityInstanceID();

        removeAllHasResult();
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void setHasResult(Set<EntityID> propertyValues) {
        EntityID SamplingID = getEntityInstanceID();

        removeAllHasResult();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SamplingID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void removeHasResult(EntityID propertyValue) {
        EntityID SamplingID = getEntityInstanceID();
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void removeAllHasResult() {
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void addHasResult(EntityID propertyValue) {
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public Set<EntityID> getUsedProcedure() {
        EntityID SamplingID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SamplingID.getJenaResource(),
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
        EntityID SamplingID = getEntityInstanceID();

        removeAllUsedProcedure();
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void setUsedProcedure(Set<EntityID> propertyValues) {
        EntityID SamplingID = getEntityInstanceID();

        removeAllUsedProcedure();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SamplingID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void removeUsedProcedure(EntityID propertyValue) {
        EntityID SamplingID = getEntityInstanceID();
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void removeAllUsedProcedure() {
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void addUsedProcedure(EntityID propertyValue) {
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeBySampler object property assertion
     */
    public Set<EntityID> getMadeBySampler() {
        EntityID SamplingID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySampler"))
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
     * Setter for http://www.w3.org/ns/sosa/madeBySampler object property assertion
     */
    public void setMadeBySampler(EntityID propertyValue) {
        EntityID SamplingID = getEntityInstanceID();

        removeAllMadeBySampler();
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySampler"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/madeBySampler object property assertion
     */
    public void setMadeBySampler(Set<EntityID> propertyValues) {
        EntityID SamplingID = getEntityInstanceID();

        removeAllMadeBySampler();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SamplingID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySampler"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeBySampler object property assertion
     */
    public void removeMadeBySampler(EntityID propertyValue) {
        EntityID SamplingID = getEntityInstanceID();
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySampler"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeBySampler object property assertion
     */
    public void removeAllMadeBySampler() {
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySampler"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/madeBySampler object property assertion
     */
    public void addMadeBySampler(EntityID propertyValue) {
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySampler"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public Set<String> getResultTime() {
        EntityID SamplingID = getEntityInstanceID();

        Set<Object> s = getJenaModel().listObjectsOfProperty(
                SamplingID.getJenaResource(),
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
        EntityID SamplingID = getEntityInstanceID();

        removeAllResultTime();
        getJenaModel().add(
                getJenaModel().createLiteralStatement(SamplingID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                        propertyValue
                ));
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/resultTime object property assertion
     */
    public void setResultTime(Set<String> propertyValues) {
        EntityID SamplingID = getEntityInstanceID();

        removeAllResultTime();
        for (String e : propertyValues) {
            if (e != null) {
                getJenaModel().add(
                        getJenaModel().createLiteralStatement(SamplingID.getJenaResource(),
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
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                ResourceFactory.createTypedLiteral(propertyValue));
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/resultTime object property assertion
     */
    public void removeAllResultTime() {
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public void addResultTime(String propertyValue) {
        EntityID SamplingID = getEntityInstanceID();

        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                propertyValue);
    }

}