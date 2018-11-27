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
 * Payload for class Property with URI http://www.w3.org/ns/ssn/Property
 * <p>
 * Attributes:
 * IsPropertyOf
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class PropertyInstancedPayload extends InstancedPayload {

   /*
Properties:
IsPropertyOf
*/

    public PropertyInstancedPayload(EntityID PropertyID) {
        this(PropertyID, false);
    }

    public PropertyInstancedPayload(EntityID PropertyID, boolean useRDFSInferencer) {
        super(PropertyID, new EntityID("http://www.w3.org/ns/ssn/Property"), useRDFSInferencer);
    }

    public PropertyInstancedPayload(EntityID PropertyID, Model jenaModel) {
        this(PropertyID, jenaModel, false);
    }

    public PropertyInstancedPayload(EntityID PropertyID, Model jenaModel, boolean useRDFSInferencer) {
        super(PropertyID, new EntityID("http://www.w3.org/ns/ssn/Property"), jenaModel, useRDFSInferencer);
    }

    public EntityID getPropertyInstanceID() {
        return getEntityInstanceID();
    }

    public void setPropertyInstanceID(EntityID PropertyID) {
        setEntityInstanceID(PropertyID);
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public Set<EntityID> getIsPropertyOf() {
        EntityID PropertyID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                PropertyID.getJenaResource(),
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
    public void setIsPropertyOf(EntityID propertyValue) {
        EntityID PropertyID = getEntityInstanceID();

        removeAllIsPropertyOf();
        getJenaModel().add(PropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public void setIsPropertyOf(Set<EntityID> propertyValues) {
        EntityID PropertyID = getEntityInstanceID();

        removeAllIsPropertyOf();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(PropertyID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public void removeIsPropertyOf(EntityID propertyValue) {
        EntityID PropertyID = getEntityInstanceID();
        getJenaModel().removeAll(PropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public void removeAllIsPropertyOf() {
        EntityID PropertyID = getEntityInstanceID();

        getJenaModel().removeAll(PropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/isPropertyOf object property assertion
     */
    public void addIsPropertyOf(EntityID propertyValue) {
        EntityID PropertyID = getEntityInstanceID();

        getJenaModel().add(PropertyID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isPropertyOf"),
                propertyValue.getJenaResource());
    }

}