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

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class Observation with URI http://www.w3.org/ns/sosa/Observation
 * <p>
 * Attributes:
 * HasLocation, HasFeatureOfInterest, ObservedProperty, HasResult, MadeBySensor, ResultTime, PhenomenonTime
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class ObservationInstancedPayload extends InstancedPayload {

   /*
Properties:
HasLocation, HasFeatureOfInterest, ObservedProperty, HasResult, MadeBySensor, ResultTime, PhenomenonTime
*/

    public ObservationInstancedPayload(EntityID ObservationID) {
        this(ObservationID, false);
    }

    public ObservationInstancedPayload(EntityID ObservationID, boolean useRDFSInferencer) {
        super(ObservationID, new EntityID("http://www.w3.org/ns/sosa/Observation"), useRDFSInferencer);
    }

    public ObservationInstancedPayload(EntityID ObservationID, Model jenaModel) {
        this(ObservationID, jenaModel, false);
    }

    public ObservationInstancedPayload(EntityID ObservationID, Model jenaModel, boolean useRDFSInferencer) {
        super(ObservationID, new EntityID("http://www.w3.org/ns/sosa/Observation"), jenaModel, useRDFSInferencer);
    }

    public EntityID getObservationInstanceID() {
        return getEntityInstanceID();
    }

    public void setObservationInstanceID(EntityID ObservationID) {
        setEntityInstanceID(ObservationID);
    }


    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public Optional<EntityID> getHasLocation() {
        EntityID ObservationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
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

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void setHasLocation(EntityID propertyValue) {
        EntityID ObservationID = getEntityInstanceID();

        removeHasLocation();
        getJenaModel().add(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void removeHasLocation() {
        EntityID ObservationID = getEntityInstanceID();

        getJenaModel().removeAll(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public Optional<EntityID> getHasFeatureOfInterest() {
        EntityID ObservationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
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

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void setHasFeatureOfInterest(EntityID propertyValue) {
        EntityID ObservationID = getEntityInstanceID();

        removeHasFeatureOfInterest();
        getJenaModel().add(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasFeatureOfInterest object property assertion
     */
    public void removeHasFeatureOfInterest() {
        EntityID ObservationID = getEntityInstanceID();

        getJenaModel().removeAll(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasFeatureOfInterest"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/observedProperty object property assertion
     */
    public Optional<EntityID> getObservedProperty() {
        EntityID ObservationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/observedProperty"))
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

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/observedProperty object property assertion
     */
    public void setObservedProperty(EntityID propertyValue) {
        EntityID ObservationID = getEntityInstanceID();

        removeObservedProperty();
        getJenaModel().add(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/observedProperty"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/observedProperty object property assertion
     */
    public void removeObservedProperty() {
        EntityID ObservationID = getEntityInstanceID();

        getJenaModel().removeAll(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/observedProperty"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public Optional<EntityID> getHasResult() {
        EntityID ObservationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
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

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void setHasResult(EntityID propertyValue) {
        EntityID ObservationID = getEntityInstanceID();

        removeHasResult();
        getJenaModel().add(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/hasResult object property assertion
     */
    public void removeHasResult() {
        EntityID ObservationID = getEntityInstanceID();

        getJenaModel().removeAll(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/hasResult"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/madeBySensor object property assertion
     */
    public Optional<EntityID> getMadeBySensor() {
        EntityID ObservationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySensor"))
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

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/madeBySensor object property assertion
     */
    public void setMadeBySensor(EntityID propertyValue) {
        EntityID ObservationID = getEntityInstanceID();

        removeMadeBySensor();
        getJenaModel().add(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySensor"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/madeBySensor object property assertion
     */
    public void removeMadeBySensor() {
        EntityID ObservationID = getEntityInstanceID();

        getJenaModel().removeAll(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/madeBySensor"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public Optional<String> getResultTime() {
        EntityID ObservationID = getEntityInstanceID();

        Set<Object> s = getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
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
        if (ss.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(ss.iterator().next());
        }
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public void setResultTime(String propertyValue) {
        EntityID ObservationID = getEntityInstanceID();

        removeResultTime();
        getJenaModel().add(
                getJenaModel().createLiteralStatement(ObservationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                        propertyValue
                ));
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/resultTime data property assertion
     */
    public void removeResultTime() {
        EntityID ObservationID = getEntityInstanceID();

        getJenaModel().removeAll(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/resultTime"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/phenomenonTime object property assertion
     */
    public Optional<EntityID> getPhenomenonTime() {
        EntityID ObservationID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/phenomenonTime"))
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

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/phenomenonTime object property assertion
     */
    public void setPhenomenonTime(EntityID propertyValue) {
        EntityID ObservationID = getEntityInstanceID();

        removePhenomenonTime();
        getJenaModel().add(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/phenomenonTime"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/phenomenonTime object property assertion
     */
    public void removePhenomenonTime() {
        EntityID ObservationID = getEntityInstanceID();

        getJenaModel().removeAll(ObservationID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/phenomenonTime"),
                null);
    }

}