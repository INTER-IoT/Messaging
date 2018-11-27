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
import org.apache.jena.rdf.model.ResourceFactory;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class Sampling with URI http://www.w3.org/ns/sosa/Sampling
 * <p>
 * Attributes:
 * HasFeatureOfInterest, HasResult, UsedProcedure, MadeBySampler, ResultTime
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class SamplingPayload extends TypedPayload {

    public SamplingPayload() {
        this(false);
    }

    public SamplingPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Sampling"), useRDFSInferencer);
    }

    public SamplingPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public SamplingPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Sampling"), jenaModel, useRDFSInferencer);
    }

    public void createSampling(EntityID SamplingID) {
        createTypedEntity(SamplingID);
    }

    public Set<EntityID> getSamplings() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public Set<EntityID> getHasFeatureOfInterest(EntityID SamplingID) {
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
    public void setHasFeatureOfInterest(EntityID SamplingID, EntityID propertyValue) {
        removeAllHasFeatureOfInterest(SamplingID);
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void setHasFeatureOfInterest(EntityID SamplingID, Set<EntityID> propertyValues) {
        removeAllHasFeatureOfInterest(SamplingID);
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
    public void removeHasFeatureOfInterest(EntityID SamplingID, EntityID propertyValue) {
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void removeAllHasFeatureOfInterest(EntityID SamplingID) {
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void addHasFeatureOfInterest(EntityID SamplingID, EntityID propertyValue) {
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public Set<EntityID> getHasResult(EntityID SamplingID) {
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
    public void setHasResult(EntityID SamplingID, EntityID propertyValue) {
        removeAllHasResult(SamplingID);
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void setHasResult(EntityID SamplingID, Set<EntityID> propertyValues) {
        removeAllHasResult(SamplingID);
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
    public void removeHasResult(EntityID SamplingID, EntityID propertyValue) {
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void removeAllHasResult(EntityID SamplingID) {
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void addHasResult(EntityID SamplingID, EntityID propertyValue) {
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public Set<EntityID> getUsedProcedure(EntityID SamplingID) {
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
    public void setUsedProcedure(EntityID SamplingID, EntityID propertyValue) {
        removeAllUsedProcedure(SamplingID);
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void setUsedProcedure(EntityID SamplingID, Set<EntityID> propertyValues) {
        removeAllUsedProcedure(SamplingID);
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
    public void removeUsedProcedure(EntityID SamplingID, EntityID propertyValue) {
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void removeAllUsedProcedure(EntityID SamplingID) {
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/usedProcedure object property assertion
     */
    public void addUsedProcedure(EntityID SamplingID, EntityID propertyValue) {
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/usedProcedure"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeBySampler object property assertion
     */
    public Set<EntityID> getMadeBySampler(EntityID SamplingID) {
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
    public void setMadeBySampler(EntityID SamplingID, EntityID propertyValue) {
        removeAllMadeBySampler(SamplingID);
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySampler"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/madeBySampler object property assertion
     */
    public void setMadeBySampler(EntityID SamplingID, Set<EntityID> propertyValues) {
        removeAllMadeBySampler(SamplingID);
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
    public void removeMadeBySampler(EntityID SamplingID, EntityID propertyValue) {
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySampler"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeBySampler object property assertion
     */
    public void removeAllMadeBySampler(EntityID SamplingID) {
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySampler"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/madeBySampler object property assertion
     */
    public void addMadeBySampler(EntityID SamplingID, EntityID propertyValue) {
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySampler"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public Set<String> getResultTime(EntityID SamplingID) {
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
    public void setResultTime(EntityID SamplingID, String propertyValue) {
        removeAllResultTime(SamplingID);
        getJenaModel().add(
                getJenaModel().createLiteralStatement(SamplingID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                        propertyValue
                ));
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/resultTime object property assertion
     */
    public void setResultTime(EntityID SamplingID, Set<String> propertyValues) {
        removeAllResultTime(SamplingID);
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
    public void removeResultTime(EntityID SamplingID, String propertyValue) {
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                ResourceFactory.createTypedLiteral(propertyValue));
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/resultTime object property assertion
     */
    public void removeAllResultTime(EntityID SamplingID) {
        getJenaModel().removeAll(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public void addResultTime(EntityID SamplingID, String propertyValue) {
        getJenaModel().add(SamplingID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                propertyValue);
    }

}