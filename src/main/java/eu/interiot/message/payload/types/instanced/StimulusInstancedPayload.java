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
 * Payload for class Stimulus with URI http://www.w3.org/ns/ssn/Stimulus
 * <p>
 * Attributes:
 * IsProxyFor
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class StimulusInstancedPayload extends InstancedPayload {

   /*
Properties:
IsProxyFor
*/

    public StimulusInstancedPayload(EntityID StimulusID) {
        this(StimulusID, false);
    }

    public StimulusInstancedPayload(EntityID StimulusID, boolean useRDFSInferencer) {
        super(StimulusID, new EntityID("http://www.w3.org/ns/ssn/Stimulus"), useRDFSInferencer);
    }

    public StimulusInstancedPayload(EntityID StimulusID, Model jenaModel) {
        this(StimulusID, jenaModel, false);
    }

    public StimulusInstancedPayload(EntityID StimulusID, Model jenaModel, boolean useRDFSInferencer) {
        super(StimulusID, new EntityID("http://www.w3.org/ns/ssn/Stimulus"), jenaModel, useRDFSInferencer);
    }

    public EntityID getStimulusInstanceID() {
        return getEntityInstanceID();
    }

    public void setStimulusInstanceID(EntityID StimulusID) {
        setEntityInstanceID(StimulusID);
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/isProxyFor object property assertion
     */
    public Set<EntityID> getIsProxyFor() {
        EntityID StimulusID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                StimulusID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isProxyFor"))
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
     * Setter for http://www.w3.org/ns/ssn/isProxyFor object property assertion
     */
    public void setIsProxyFor(EntityID propertyValue) {
        EntityID StimulusID = getEntityInstanceID();

        removeAllIsProxyFor();
        getJenaModel().add(StimulusID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isProxyFor"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/isProxyFor object property assertion
     */
    public void setIsProxyFor(Set<EntityID> propertyValues) {
        EntityID StimulusID = getEntityInstanceID();

        removeAllIsProxyFor();
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(StimulusID.getJenaResource(),
                        getJenaModel().createProperty("http://www.w3.org/ns/ssn/isProxyFor"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/isProxyFor object property assertion
     */
    public void removeIsProxyFor(EntityID propertyValue) {
        EntityID StimulusID = getEntityInstanceID();
        getJenaModel().removeAll(StimulusID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isProxyFor"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/isProxyFor object property assertion
     */
    public void removeAllIsProxyFor() {
        EntityID StimulusID = getEntityInstanceID();

        getJenaModel().removeAll(StimulusID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isProxyFor"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/isProxyFor object property assertion
     */
    public void addIsProxyFor(EntityID propertyValue) {
        EntityID StimulusID = getEntityInstanceID();

        getJenaModel().add(StimulusID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isProxyFor"),
                propertyValue.getJenaResource());
    }

}