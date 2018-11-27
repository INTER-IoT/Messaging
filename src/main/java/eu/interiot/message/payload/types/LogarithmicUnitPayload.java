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
 * Payload for class LogarithmicUnit with URI http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#LogarithmicUnit
 * <p>
 * Attributes:
 * HasScale
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit, http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 */
public class LogarithmicUnitPayload extends TypedPayload {

    public LogarithmicUnitPayload() {
        this(false);
    }

    public LogarithmicUnitPayload(boolean useRDFSInferencer) {
        super(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#LogarithmicUnit"), useRDFSInferencer);
    }

    public LogarithmicUnitPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public LogarithmicUnitPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#LogarithmicUnit"), jenaModel, useRDFSInferencer);
    }

    public void createLogarithmicUnit(EntityID LogarithmicUnitID) {
        createTypedEntity(LogarithmicUnitID);
    }

    public Set<EntityID> getLogarithmicUnits() {
        return getTypedEntities();
    }


    /**
     * Getter for http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale object property assertion
     */
    public Set<EntityID> getHasScale(EntityID LogarithmicUnitID) {
        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                LogarithmicUnitID.getJenaResource(),
                getJenaModel().createProperty("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale"))
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
     * Setter for http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale object property assertion
     */
    public void setHasScale(EntityID LogarithmicUnitID, EntityID propertyValue) {
        removeAllHasScale(LogarithmicUnitID);
        getJenaModel().add(LogarithmicUnitID.getJenaResource(),
                getJenaModel().createProperty("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale object property assertion
     */
    public void setHasScale(EntityID LogarithmicUnitID, Set<EntityID> propertyValues) {
        removeAllHasScale(LogarithmicUnitID);
        for (EntityID e : propertyValues) {
            if (e != null) {
                getJenaModel().add(LogarithmicUnitID.getJenaResource(),
                        getJenaModel().createProperty("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale"),
                        e.getJenaResource());
            }
        }
    }

    /**
     * Remover for http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale object property assertion
     */
    public void removeHasScale(EntityID LogarithmicUnitID, EntityID propertyValue) {
        getJenaModel().removeAll(LogarithmicUnitID.getJenaResource(),
                getJenaModel().createProperty("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale object property assertion
     */
    public void removeAllHasScale(EntityID LogarithmicUnitID) {
        getJenaModel().removeAll(LogarithmicUnitID.getJenaResource(),
                getJenaModel().createProperty("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale"),
                null);
    }

    /**
     * Adder for http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale object property assertion
     */
    public void addHasScale(EntityID LogarithmicUnitID, EntityID propertyValue) {
        getJenaModel().add(LogarithmicUnitID.getJenaResource(),
                getJenaModel().createProperty("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale"),
                propertyValue.getJenaResource());
    }

}