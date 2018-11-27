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
 * Payload for class User with URI http://inter-iot.eu/GOIoTP#User
 * <p>
 * Attributes:
 * HasLocalID, HasAuthenticationData
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class UserPayload extends TypedPayload {

    public UserPayload() {
        this(false);
    }

    public UserPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://inter-iot.eu/GOIoTP#User"), useRDFSInferencer);
    }

    public UserPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public UserPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://inter-iot.eu/GOIoTP#User"), jenaModel, useRDFSInferencer);
    }

    public void createUser(EntityID UserID) {
        createTypedEntity(UserID);
    }

    public Set<EntityID> getUsers() {
        return getTypedEntities();
    }


    /**
     * Getter for http://inter-iot.eu/GOIoTPex#hasLocalID data property assertion
     */
    public Set<String> getHasLocalID(EntityID UserID) {
        Set<Object> s = getJenaModel().listObjectsOfProperty(
                UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasLocalID"))
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
     * Setter for http://inter-iot.eu/GOIoTPex#hasLocalID data property assertion
     */
    public void setHasLocalID(EntityID UserID, String propertyValue) {
        removeAllHasLocalID(UserID);
        getJenaModel().add(
                getJenaModel().createLiteralStatement(UserID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasLocalID"),
                        propertyValue
                ));
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTPex#hasLocalID object property assertion
     */
    public void setHasLocalID(EntityID UserID, Set<String> propertyValues) {
        removeAllHasLocalID(UserID);
        for (String e : propertyValues) {
            if (e != null) {
                getJenaModel().add(
                        getJenaModel().createLiteralStatement(UserID.getJenaResource(),
                                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasLocalID"),
                                e
                        ));
            }
        }
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTPex#hasLocalID data property assertion
     */
    public void removeHasLocalID(EntityID UserID, String propertyValue) {
        getJenaModel().removeAll(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasLocalID"),
                ResourceFactory.createTypedLiteral(propertyValue));
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTPex#hasLocalID object property assertion
     */
    public void removeAllHasLocalID(EntityID UserID) {
        getJenaModel().removeAll(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasLocalID"),
                null);
    }

    /**
     * Adder for http://inter-iot.eu/GOIoTPex#hasLocalID data property assertion
     */
    public void addHasLocalID(EntityID UserID, String propertyValue) {
        getJenaModel().add(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasLocalID"),
                propertyValue);
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTPex#hasAuthenticationData object property assertion
     */
    public Set<EntityID> getHasAuthenticationData(EntityID UserID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasAuthenticationData"))
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
     * Setter for http://inter-iot.eu/GOIoTPex#hasAuthenticationData object property assertion
     */
    public void setHasAuthenticationData(EntityID UserID, EntityID propertyValue) {
        removeAllHasAuthenticationData(UserID);
        getJenaModel().add(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasAuthenticationData"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTPex#hasAuthenticationData object property assertion
     */
    public void setHasAuthenticationData(EntityID UserID, Set<EntityID> propertyValues) {
        removeAllHasAuthenticationData(UserID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(UserID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasAuthenticationData"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTPex#hasAuthenticationData object property assertion
     */
    public void removeHasAuthenticationData(EntityID UserID, EntityID propertyValue) {
        getJenaModel().removeAll(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasAuthenticationData"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTPex#hasAuthenticationData object property assertion
     */
    public void removeAllHasAuthenticationData(EntityID UserID) {
        getJenaModel().removeAll(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasAuthenticationData"),
                null);
    }

    /**
     * Adder for http://inter-iot.eu/GOIoTPex#hasAuthenticationData object property assertion
     */
    public void addHasAuthenticationData(EntityID UserID, EntityID propertyValue) {
        getJenaModel().add(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasAuthenticationData"),
                propertyValue.getJenaResource());
    }

}