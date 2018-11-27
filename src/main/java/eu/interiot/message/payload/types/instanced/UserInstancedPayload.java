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
 * Payload for class User with URI http://inter-iot.eu/GOIoTP#User
 * <p>
 * Attributes:
 * HasLocalID, HasAuthenticationData
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class UserInstancedPayload extends InstancedPayload {

   /*
Properties:
HasLocalID, HasAuthenticationData
*/

    public UserInstancedPayload(EntityID UserID) {
        this(UserID, false);
    }

    public UserInstancedPayload(EntityID UserID, boolean useRDFSInferencer) {
        super(UserID, new EntityID("http://inter-iot.eu/GOIoTP#User"), useRDFSInferencer);
    }

    public UserInstancedPayload(EntityID UserID, Model jenaModel) {
        this(UserID, jenaModel, false);
    }

    public UserInstancedPayload(EntityID UserID, Model jenaModel, boolean useRDFSInferencer) {
        super(UserID, new EntityID("http://inter-iot.eu/GOIoTP#User"), jenaModel, useRDFSInferencer);
    }

    public EntityID getUserInstanceID() {
        return getEntityInstanceID();
    }

    public void setUserInstanceID(EntityID UserID) {
        setEntityInstanceID(UserID);
    }


    /**
     * Getter for http://inter-iot.eu/GOIoTPex#hasLocalID data property assertion
     */
    public Set<String> getHasLocalID() {
        EntityID UserID = getEntityInstanceID();

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
    public void setHasLocalID(String propertyValue) {
        EntityID UserID = getEntityInstanceID();

        removeAllHasLocalID();
        getJenaModel().add(
                getJenaModel().createLiteralStatement(UserID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasLocalID"),
                        propertyValue
                ));
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTPex#hasLocalID object property assertion
     */
    public void setHasLocalID(Set<String> propertyValues) {
        EntityID UserID = getEntityInstanceID();

        removeAllHasLocalID();
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
    public void removeHasLocalID(String propertyValue) {
        EntityID UserID = getEntityInstanceID();

        getJenaModel().removeAll(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasLocalID"),
                ResourceFactory.createTypedLiteral(propertyValue));
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTPex#hasLocalID object property assertion
     */
    public void removeAllHasLocalID() {
        EntityID UserID = getEntityInstanceID();

        getJenaModel().removeAll(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasLocalID"),
                null);
    }

    /**
     * Adder for http://inter-iot.eu/GOIoTPex#hasLocalID data property assertion
     */
    public void addHasLocalID(String propertyValue) {
        EntityID UserID = getEntityInstanceID();

        getJenaModel().add(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasLocalID"),
                propertyValue);
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTPex#hasAuthenticationData object property assertion
     */
    public Set<EntityID> getHasAuthenticationData() {
        EntityID UserID = getEntityInstanceID();

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
    public void setHasAuthenticationData(EntityID propertyValue) {
        EntityID UserID = getEntityInstanceID();

        removeAllHasAuthenticationData();
        getJenaModel().add(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasAuthenticationData"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTPex#hasAuthenticationData object property assertion
     */
    public void setHasAuthenticationData(Set<EntityID> propertyValues) {
        EntityID UserID = getEntityInstanceID();

        removeAllHasAuthenticationData();
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
    public void removeHasAuthenticationData(EntityID propertyValue) {
        EntityID UserID = getEntityInstanceID();
        getJenaModel().removeAll(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasAuthenticationData"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTPex#hasAuthenticationData object property assertion
     */
    public void removeAllHasAuthenticationData() {
        EntityID UserID = getEntityInstanceID();

        getJenaModel().removeAll(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasAuthenticationData"),
                null);
    }

    /**
     * Adder for http://inter-iot.eu/GOIoTPex#hasAuthenticationData object property assertion
     */
    public void addHasAuthenticationData(EntityID propertyValue) {
        EntityID UserID = getEntityInstanceID();

        getJenaModel().add(UserID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTPex#hasAuthenticationData"),
                propertyValue.getJenaResource());
    }

}