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

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class SoftwarePlatform with URI http://inter-iot.eu/GOIoTP#SoftwarePlatform
 * <p>
 * Attributes:
 * HasSemantics, HasName, HasBaseEndpoint, HasLocation
 * <p>
 * Supertypes:
 * http://www.w3.org/ns/sosa/Platform
 */
public class SoftwarePlatformPayload extends TypedPayload {

    public SoftwarePlatformPayload() {
        this(false);
    }

    public SoftwarePlatformPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://inter-iot.eu/GOIoTP#SoftwarePlatform"), useRDFSInferencer);
    }

    public SoftwarePlatformPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public SoftwarePlatformPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://inter-iot.eu/GOIoTP#SoftwarePlatform"), jenaModel, useRDFSInferencer);
    }

    public void createSoftwarePlatform(EntityID SoftwarePlatformID) {
        createTypedEntity(SoftwarePlatformID);
    }

    public Set<EntityID> getSoftwarePlatforms() {
        return getTypedEntities();
    }


    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasSemantics object property assertion
     */
    public Set<EntityID> getHasSemantics(EntityID SoftwarePlatformID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasSemantics"))
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
     * Setter for http://inter-iot.eu/GOIoTP#hasSemantics object property assertion
     */
    public void setHasSemantics(EntityID SoftwarePlatformID, EntityID propertyValue) {
        removeAllHasSemantics(SoftwarePlatformID);
        getJenaModel().add(SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasSemantics"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasSemantics object property assertion
     */
    public void setHasSemantics(EntityID SoftwarePlatformID, Set<EntityID> propertyValues) {
        removeAllHasSemantics(SoftwarePlatformID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(SoftwarePlatformID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasSemantics"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasSemantics object property assertion
     */
    public void removeHasSemantics(EntityID SoftwarePlatformID, EntityID propertyValue) {
        getJenaModel().removeAll(SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasSemantics"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasSemantics object property assertion
     */
    public void removeAllHasSemantics(EntityID SoftwarePlatformID) {
        getJenaModel().removeAll(SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasSemantics"),
                null);
    }

    /**
     * Adder for http://inter-iot.eu/GOIoTP#hasSemantics object property assertion
     */
    public void addHasSemantics(EntityID SoftwarePlatformID, EntityID propertyValue) {
        getJenaModel().add(SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasSemantics"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasName data property assertion
     */
    public Optional<String> getHasName(EntityID SoftwarePlatformID) {
        Set<Object> s = getJenaModel().listObjectsOfProperty(
                SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasName"))
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
     * Setter for http://inter-iot.eu/GOIoTP#hasName data property assertion
     */
    public void setHasName(EntityID SoftwarePlatformID, String propertyValue) {
        removeHasName(SoftwarePlatformID);
        getJenaModel().add(
                getJenaModel().createLiteralStatement(SoftwarePlatformID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasName"),
                        propertyValue
                ));
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasName data property assertion
     */
    public void removeHasName(EntityID SoftwarePlatformID) {
        getJenaModel().removeAll(SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasName"),
                null);
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasBaseEndpoint data property assertion
     */
    public Optional<String> getHasBaseEndpoint(EntityID SoftwarePlatformID) {
        Set<Object> s = getJenaModel().listObjectsOfProperty(
                SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasBaseEndpoint"))
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
     * Setter for http://inter-iot.eu/GOIoTP#hasBaseEndpoint data property assertion
     */
    public void setHasBaseEndpoint(EntityID SoftwarePlatformID, String propertyValue) {
        removeHasBaseEndpoint(SoftwarePlatformID);
        getJenaModel().add(
                getJenaModel().createLiteralStatement(SoftwarePlatformID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasBaseEndpoint"),
                        propertyValue
                ));
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasBaseEndpoint data property assertion
     */
    public void removeHasBaseEndpoint(EntityID SoftwarePlatformID) {
        getJenaModel().removeAll(SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasBaseEndpoint"),
                null);
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public Optional<EntityID> getHasLocation(EntityID SoftwarePlatformID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                SoftwarePlatformID.getJenaResource(),
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
    public void setHasLocation(EntityID SoftwarePlatformID, EntityID propertyValue) {
        removeHasLocation(SoftwarePlatformID);
        getJenaModel().add(SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void removeHasLocation(EntityID SoftwarePlatformID) {
        getJenaModel().removeAll(SoftwarePlatformID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                null);
    }

}