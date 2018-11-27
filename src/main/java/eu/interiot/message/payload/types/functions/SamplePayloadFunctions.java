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


package eu.interiot.message.payload.types.functions;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.MessagePayload;
import eu.interiot.message.exceptions.payload.IdentifierException;
import eu.interiot.message.payload.MessagePayloadFunctions;
import org.apache.jena.vocabulary.RDF;

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
public class SamplePayloadFunctions extends MessagePayloadFunctions {

    /*
 Properties:
 IsSampleOf, IsResultOf, HasProperty, HasSample
 */
    private static EntityID entityType = new EntityID("http://www.w3.org/ns/sosa/Sample");

    public static EntityID getEntityType() {
        return entityType;
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public static Set<EntityID> getIsSampleOf(MessagePayload payload, EntityID SampleID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"))
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
    public static void setIsSampleOf(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        removeAllIsSampleOf(payload, SampleID);
        payload.getJenaModel().add(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public static void setIsSampleOf(MessagePayload payload, EntityID SampleID, Set<EntityID> propertyValues) {
        removeAllIsSampleOf(payload, SampleID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(SampleID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public static void removeIsSampleOf(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public static void removeAllIsSampleOf(MessagePayload payload, EntityID SampleID) {
        payload.getJenaModel().removeAll(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isSampleOf object property assertion
     */
    public static void addIsSampleOf(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        payload.getJenaModel().add(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isSampleOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public static Set<EntityID> getIsResultOf(MessagePayload payload, EntityID SampleID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"))
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
    public static void setIsResultOf(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        removeAllIsResultOf(payload, SampleID);
        payload.getJenaModel().add(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public static void setIsResultOf(MessagePayload payload, EntityID SampleID, Set<EntityID> propertyValues) {
        removeAllIsResultOf(payload, SampleID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(SampleID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public static void removeIsResultOf(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public static void removeAllIsResultOf(MessagePayload payload, EntityID SampleID) {
        payload.getJenaModel().removeAll(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isResultOf object property assertion
     */
    public static void addIsResultOf(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        payload.getJenaModel().add(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/isResultOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public static Set<EntityID> getHasProperty(MessagePayload payload, EntityID SampleID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"))
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
    public static void setHasProperty(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        removeAllHasProperty(payload, SampleID);
        payload.getJenaModel().add(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public static void setHasProperty(MessagePayload payload, EntityID SampleID, Set<EntityID> propertyValues) {
        removeAllHasProperty(payload, SampleID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(SampleID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public static void removeHasProperty(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public static void removeAllHasProperty(MessagePayload payload, EntityID SampleID) {
        payload.getJenaModel().removeAll(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasProperty object property assertion
     */
    public static void addHasProperty(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        payload.getJenaModel().add(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public static Set<EntityID> getHasSample(MessagePayload payload, EntityID SampleID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"))
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
    public static void setHasSample(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        removeAllHasSample(payload, SampleID);
        payload.getJenaModel().add(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public static void setHasSample(MessagePayload payload, EntityID SampleID, Set<EntityID> propertyValues) {
        removeAllHasSample(payload, SampleID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(SampleID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public static void removeHasSample(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public static void removeAllHasSample(MessagePayload payload, EntityID SampleID) {
        payload.getJenaModel().removeAll(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/hasSample object property assertion
     */
    public static void addHasSample(MessagePayload payload, EntityID SampleID, EntityID propertyValue) {
        payload.getJenaModel().add(SampleID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasSample"),
                propertyValue.getJenaResource());
    }

    public void createSample(MessagePayload payload, EntityID SampleID) {
        payload.getJenaModel().add(SampleID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    public Set<EntityID> getSamples(MessagePayload payload) {
        Set<EntityID> entities = payload.getJenaModel().listSubjectsWithProperty(RDF.type,
                entityType.getJenaResource())
                .toSet()
                .stream()
                .map(x -> {
                    try {
                        return new EntityID(x);
                    } catch (IdentifierException e) {
                        return null;
                    }
                }).collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);
        return entities;
    }

}