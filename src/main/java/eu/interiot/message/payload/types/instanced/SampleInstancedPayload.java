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
 * Payload for class Sample with URI http://www.w3.org/ns/sosa/Sample
 * <p>
 * Attributes:
 * IsSampleOf, IsResultOf, HasProperty, HasSample
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://www.w3.org/ns/sosa/FeatureOfInterest, http://www.w3.org/ns/sosa/Result
 */
public class SampleInstancedPayload extends InstancedPayload {

   /*
Properties:
IsSampleOf, IsResultOf, HasProperty, HasSample
*/

    public SampleInstancedPayload(EntityID SampleID) {
        this(SampleID, false);
    }

    public SampleInstancedPayload(EntityID SampleID, boolean useRDFSInferencer) {
        super(SampleID, new EntityID("http://www.w3.org/ns/sosa/Sample"), useRDFSInferencer);
    }

    public SampleInstancedPayload(EntityID SampleID, Model jenaModel) {
        this(SampleID, jenaModel, false);
    }

    public SampleInstancedPayload(EntityID SampleID, Model jenaModel, boolean useRDFSInferencer) {
        super(SampleID, new EntityID("http://www.w3.org/ns/sosa/Sample"), jenaModel, useRDFSInferencer);
    }

    public EntityID getSampleInstanceID() {
        return getEntityInstanceID();
    }

    public void setSampleInstanceID(EntityID SampleID) {
        setEntityInstanceID(SampleID);
    }


    /**
     * Getter for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public Set<EntityID> getIsSampleOf() {
        EntityID SampleID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"))
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
     * Setter for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public void setIsSampleOf(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();

        removeAllIsSampleOf();
        getJenaModel().add(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public void setIsSampleOf(Set<EntityID> propertyValues) {
        EntityID SampleID = getEntityInstanceID();

        removeAllIsSampleOf();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SampleID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public void removeIsSampleOf(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();
        getJenaModel().removeAll(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public void removeAllIsSampleOf() {
        EntityID SampleID = getEntityInstanceID();

        getJenaModel().removeAll(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public void addIsSampleOf(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();

        getJenaModel().add(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public Set<EntityID> getIsResultOf() {
        EntityID SampleID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"))
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
     * Setter for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public void setIsResultOf(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();

        removeAllIsResultOf();
        getJenaModel().add(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public void setIsResultOf(Set<EntityID> propertyValues) {
        EntityID SampleID = getEntityInstanceID();

        removeAllIsResultOf();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SampleID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public void removeIsResultOf(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();
        getJenaModel().removeAll(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public void removeAllIsResultOf() {
        EntityID SampleID = getEntityInstanceID();

        getJenaModel().removeAll(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public void addIsResultOf(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();

        getJenaModel().add(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public Set<EntityID> getHasProperty() {
        EntityID SampleID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"))
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
     * Setter for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public void setHasProperty(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();

        removeAllHasProperty();
        getJenaModel().add(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public void setHasProperty(Set<EntityID> propertyValues) {
        EntityID SampleID = getEntityInstanceID();

        removeAllHasProperty();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SampleID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public void removeHasProperty(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();
        getJenaModel().removeAll(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public void removeAllHasProperty() {
        EntityID SampleID = getEntityInstanceID();

        getJenaModel().removeAll(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public void addHasProperty(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();

        getJenaModel().add(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public Set<EntityID> getHasSample() {
        EntityID SampleID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"))
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
     * Setter for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public void setHasSample(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();

        removeAllHasSample();
        getJenaModel().add(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public void setHasSample(Set<EntityID> propertyValues) {
        EntityID SampleID = getEntityInstanceID();

        removeAllHasSample();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SampleID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public void removeHasSample(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();
        getJenaModel().removeAll(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public void removeAllHasSample() {
        EntityID SampleID = getEntityInstanceID();

        getJenaModel().removeAll(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public void addHasSample(EntityID propertyValue) {
        EntityID SampleID = getEntityInstanceID();

        getJenaModel().add(SampleID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"),
                propertyValue.getJenaResource());
    }

}