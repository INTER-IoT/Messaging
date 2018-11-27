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
 * Payload for class ObservableProperty with URI http://www.w3.org/ns/sosa/ObservableProperty
 * <p>
 * Attributes:
 * IsObservedBy, IsPropertyOf
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://www.w3.org/ns/ssn/Property
 */
public class ObservablePropertyPayload extends TypedPayload {

    public ObservablePropertyPayload() {
        this(false);
    }

    public ObservablePropertyPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/ObservableProperty"), useRDFSInferencer);
    }

    public ObservablePropertyPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public ObservablePropertyPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/ObservableProperty"), jenaModel, useRDFSInferencer);
    }

    public void createObservableProperty(EntityID ObservablePropertyID) {
        createTypedEntity(ObservablePropertyID);
    }

    public Set<EntityID> getObservablePropertys() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/sosa/isObservedBy object property assertion
     */
    public Set<EntityID> getIsObservedBy(EntityID ObservablePropertyID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ObservablePropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isObservedBy"))
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
     * Setter for http://www.w3.org/ns/sosa/isObservedBy object property assertion
     */
    public void setIsObservedBy(EntityID ObservablePropertyID, EntityID propertyValue) {
        removeAllIsObservedBy(ObservablePropertyID);
        getJenaModel().add(ObservablePropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isObservedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/isObservedBy object property assertion
     */
    public void setIsObservedBy(EntityID ObservablePropertyID, Set<EntityID> propertyValues) {
        removeAllIsObservedBy(ObservablePropertyID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ObservablePropertyID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/isObservedBy"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isObservedBy object property assertion
     */
    public void removeIsObservedBy(EntityID ObservablePropertyID, EntityID propertyValue) {
        getJenaModel().removeAll(ObservablePropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isObservedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/isObservedBy object property assertion
     */
    public void removeAllIsObservedBy(EntityID ObservablePropertyID) {
        getJenaModel().removeAll(ObservablePropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isObservedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/sosa/isObservedBy object property assertion
     */
    public void addIsObservedBy(EntityID ObservablePropertyID, EntityID propertyValue) {
        getJenaModel().add(ObservablePropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/isObservedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public Set<EntityID> getIsPropertyOf(EntityID ObservablePropertyID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ObservablePropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"))
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
     * Setter for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public void setIsPropertyOf(EntityID ObservablePropertyID, EntityID propertyValue) {
        removeAllIsPropertyOf(ObservablePropertyID);
        getJenaModel().add(ObservablePropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public void setIsPropertyOf(EntityID ObservablePropertyID, Set<EntityID> propertyValues) {
        removeAllIsPropertyOf(ObservablePropertyID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ObservablePropertyID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public void removeIsPropertyOf(EntityID ObservablePropertyID, EntityID propertyValue) {
        getJenaModel().removeAll(ObservablePropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public void removeAllIsPropertyOf(EntityID ObservablePropertyID) {
        getJenaModel().removeAll(ObservablePropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public void addIsPropertyOf(EntityID ObservablePropertyID, EntityID propertyValue) {
        getJenaModel().add(ObservablePropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                propertyValue.getJenaResource());
    }

}