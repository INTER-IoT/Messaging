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
 * Payload for class Procedure with URI http://www.w3.org/ns/sosa/Procedure
 * <p>
 * Attributes:
 * ImplementedBy, HasOutput, HasInput
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class ProcedurePayloadFunctions extends MessagePayloadFunctions {

    /*
 Properties:
 ImplementedBy, HasOutput, HasInput
 */
    private static EntityID entityType = new EntityID("http://www.w3.org/ns/sosa/Procedure");

    public static EntityID getEntityType() {
        return entityType;
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public static Set<EntityID> getImplementedBy(MessagePayload payload, EntityID ProcedureID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"))
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
     * Setter for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public static void setImplementedBy(MessagePayload payload, EntityID ProcedureID, EntityID propertyValue) {
        removeAllImplementedBy(payload, ProcedureID);
        payload.getJenaModel().add(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public static void setImplementedBy(MessagePayload payload, EntityID ProcedureID, Set<EntityID> propertyValues) {
        removeAllImplementedBy(payload, ProcedureID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(ProcedureID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public static void removeImplementedBy(MessagePayload payload, EntityID ProcedureID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public static void removeAllImplementedBy(MessagePayload payload, EntityID ProcedureID) {
        payload.getJenaModel().removeAll(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public static void addImplementedBy(MessagePayload payload, EntityID ProcedureID, EntityID propertyValue) {
        payload.getJenaModel().add(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public static Set<EntityID> getHasOutput(MessagePayload payload, EntityID ProcedureID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"))
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
     * Setter for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public static void setHasOutput(MessagePayload payload, EntityID ProcedureID, EntityID propertyValue) {
        removeAllHasOutput(payload, ProcedureID);
        payload.getJenaModel().add(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public static void setHasOutput(MessagePayload payload, EntityID ProcedureID, Set<EntityID> propertyValues) {
        removeAllHasOutput(payload, ProcedureID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(ProcedureID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public static void removeHasOutput(MessagePayload payload, EntityID ProcedureID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public static void removeAllHasOutput(MessagePayload payload, EntityID ProcedureID) {
        payload.getJenaModel().removeAll(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public static void addHasOutput(MessagePayload payload, EntityID ProcedureID, EntityID propertyValue) {
        payload.getJenaModel().add(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public static Set<EntityID> getHasInput(MessagePayload payload, EntityID ProcedureID) {
        Set<EntityID> s = payload.getJenaModel().listObjectsOfProperty(
                ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"))
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
     * Setter for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public static void setHasInput(MessagePayload payload, EntityID ProcedureID, EntityID propertyValue) {
        removeAllHasInput(payload, ProcedureID);
        payload.getJenaModel().add(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public static void setHasInput(MessagePayload payload, EntityID ProcedureID, Set<EntityID> propertyValues) {
        removeAllHasInput(payload, ProcedureID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                payload.getJenaModel().add(ProcedureID.getJenaResource(),
                        payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public static void removeHasInput(MessagePayload payload, EntityID ProcedureID, EntityID propertyValue) {
        payload.getJenaModel().removeAll(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public static void removeAllHasInput(MessagePayload payload, EntityID ProcedureID) {
        payload.getJenaModel().removeAll(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public static void addHasInput(MessagePayload payload, EntityID ProcedureID, EntityID propertyValue) {
        payload.getJenaModel().add(ProcedureID.getJenaResource(),
                payload.getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"),
                propertyValue.getJenaResource());
    }

    public void createProcedure(MessagePayload payload, EntityID ProcedureID) {
        payload.getJenaModel().add(ProcedureID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    public Set<EntityID> getProcedures(MessagePayload payload) {
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