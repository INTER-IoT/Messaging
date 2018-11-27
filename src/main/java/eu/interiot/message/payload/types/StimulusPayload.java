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
 * Payload for class Stimulus with URI http://www.w3.org/ns/ssn/Stimulus
 * <p>
 * Attributes:
 * IsProxyFor
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class StimulusPayload extends TypedPayload {

    public StimulusPayload() {
        this(false);
    }

    public StimulusPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/ssn/Stimulus"), useRDFSInferencer);
    }

    public StimulusPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public StimulusPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://www.w3.org/ns/ssn/Stimulus"), jenaModel, useRDFSInferencer);
    }

    public void createStimulus(EntityID StimulusID) {
        createTypedEntity(StimulusID);
    }

    public Set<EntityID> getStimuluss() {
        return getTypedEntities();
    }


    /**
     * Getter for http://www.w3.org/ns/ssn/isProxyFor object property assertion
     */
    public Set<EntityID> getIsProxyFor(EntityID StimulusID) {
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
    public void setIsProxyFor(EntityID StimulusID, EntityID propertyValue) {
        removeAllIsProxyFor(StimulusID);
        getJenaModel().add(StimulusID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isProxyFor"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://www.w3.org/ns/ssn/isProxyFor object property assertion
     */
    public void setIsProxyFor(EntityID StimulusID, Set<EntityID> propertyValues) {
        removeAllIsProxyFor(StimulusID);
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
    public void removeIsProxyFor(EntityID StimulusID, EntityID propertyValue) {
        getJenaModel().removeAll(StimulusID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isProxyFor"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/ssn/isProxyFor object property assertion
     */
    public void removeAllIsProxyFor(EntityID StimulusID) {
        getJenaModel().removeAll(StimulusID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isProxyFor"),
                null);
    }

    /**
     * Adder for http://www.w3.org/ns/ssn/isProxyFor object property assertion
     */
    public void addIsProxyFor(EntityID StimulusID, EntityID propertyValue) {
        getJenaModel().add(StimulusID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/ssn/isProxyFor"),
                propertyValue.getJenaResource());
    }

}