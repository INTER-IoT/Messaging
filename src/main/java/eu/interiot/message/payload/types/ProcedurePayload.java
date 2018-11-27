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
 * Payload for class Procedure with URI http://www.w3.org/ns/sosa/Procedure
 * <p>
 * Attributes:
 * ImplementedBy, HasOutput, HasInput
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class ProcedurePayload extends TypedPayload {

    public ProcedurePayload() {
        this(false);
    }

    public ProcedurePayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Procedure"), useRDFSInferencer);
    }

    public ProcedurePayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public ProcedurePayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/sosa/Procedure"), jenaModel, useRDFSInferencer);
    }

    public void createProcedure(EntityID ProcedureID) {
        createTypedEntity(ProcedureID);
    }

    public Set<EntityID> getProcedures() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public Set<EntityID> getImplementedBy(EntityID ProcedureID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"))
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
    public void setImplementedBy(EntityID ProcedureID, EntityID propertyValue) {
        removeAllImplementedBy(ProcedureID);
        getJenaModel().add(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public void setImplementedBy(EntityID ProcedureID, Set<EntityID> propertyValues) {
        removeAllImplementedBy(ProcedureID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ProcedureID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public void removeImplementedBy(EntityID ProcedureID, EntityID propertyValue) {
        getJenaModel().removeAll(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public void removeAllImplementedBy(EntityID ProcedureID) {
        getJenaModel().removeAll(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/implementedBy object property assertion
     */
    public void addImplementedBy(EntityID ProcedureID, EntityID propertyValue) {
        getJenaModel().add(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/implementedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public Set<EntityID> getHasOutput(EntityID ProcedureID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"))
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
    public void setHasOutput(EntityID ProcedureID, EntityID propertyValue) {
        removeAllHasOutput(ProcedureID);
        getJenaModel().add(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public void setHasOutput(EntityID ProcedureID, Set<EntityID> propertyValues) {
        removeAllHasOutput(ProcedureID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ProcedureID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public void removeHasOutput(EntityID ProcedureID, EntityID propertyValue) {
        getJenaModel().removeAll(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public void removeAllHasOutput(EntityID ProcedureID) {
        getJenaModel().removeAll(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasOutput object property assertion
     */
    public void addHasOutput(EntityID ProcedureID, EntityID propertyValue) {
        getJenaModel().add(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasOutput"),
                propertyValue.getJenaResource());
    }

    /**
     * Getter for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public Set<EntityID> getHasInput(EntityID ProcedureID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"))
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
    public void setHasInput(EntityID ProcedureID, EntityID propertyValue) {
        removeAllHasInput(ProcedureID);
        getJenaModel().add(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public void setHasInput(EntityID ProcedureID, Set<EntityID> propertyValues) {
        removeAllHasInput(ProcedureID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(ProcedureID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public void removeHasInput(EntityID ProcedureID, EntityID propertyValue) {
        getJenaModel().removeAll(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public void removeAllHasInput(EntityID ProcedureID) {
        getJenaModel().removeAll(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/hasInput object property assertion
     */
    public void addHasInput(EntityID ProcedureID, EntityID propertyValue) {
        getJenaModel().add(ProcedureID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/hasInput"),
                propertyValue.getJenaResource());
    }

}