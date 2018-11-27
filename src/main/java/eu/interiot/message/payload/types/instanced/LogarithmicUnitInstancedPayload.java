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
 * Payload for class LogarithmicUnit with URI http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#LogarithmicUnit
 * <p>
 * Attributes:
 * HasScale
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit, http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 */
public class LogarithmicUnitInstancedPayload extends InstancedPayload {

   /*
Properties:
HasScale
*/

    public LogarithmicUnitInstancedPayload(EntityID LogarithmicUnitID) {
        this(LogarithmicUnitID, false);
    }

    public LogarithmicUnitInstancedPayload(EntityID LogarithmicUnitID, boolean useRDFSInferencer) {
        super(LogarithmicUnitID, new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#LogarithmicUnit"), useRDFSInferencer);
    }

    public LogarithmicUnitInstancedPayload(EntityID LogarithmicUnitID, Model jenaModel) {
        this(LogarithmicUnitID, jenaModel, false);
    }

    public LogarithmicUnitInstancedPayload(EntityID LogarithmicUnitID, Model jenaModel, boolean useRDFSInferencer) {
        super(LogarithmicUnitID, new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#LogarithmicUnit"), jenaModel, useRDFSInferencer);
    }

    public EntityID getLogarithmicUnitInstanceID() {
        return getEntityInstanceID();
    }

    public void setLogarithmicUnitInstanceID(EntityID LogarithmicUnitID) {
        setEntityInstanceID(LogarithmicUnitID);
    }


    /**
     * Getter for http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale object property assertion
     */
    public Set<EntityID> getHasScale() {
        EntityID LogarithmicUnitID = getEntityInstanceID();

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
    public void setHasScale(EntityID propertyValue) {
        EntityID LogarithmicUnitID = getEntityInstanceID();

        removeAllHasScale();
        getJenaModel().add(LogarithmicUnitID.getJenaResource(),
                getJenaModel().createProperty("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale"),
                propertyValue.getJenaResource());
    }

    /**
     * Setter for http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale object property assertion
     */
    public void setHasScale(Set<EntityID> propertyValues) {
        EntityID LogarithmicUnitID = getEntityInstanceID();

        removeAllHasScale();
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
    public void removeHasScale(EntityID propertyValue) {
        EntityID LogarithmicUnitID = getEntityInstanceID();
        getJenaModel().removeAll(LogarithmicUnitID.getJenaResource(),
                getJenaModel().createProperty("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale object property assertion
     */
    public void removeAllHasScale() {
        EntityID LogarithmicUnitID = getEntityInstanceID();

        getJenaModel().removeAll(LogarithmicUnitID.getJenaResource(),
                getJenaModel().createProperty("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale"),
                null);
    }

    /**
     * Adder for http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale object property assertion
     */
    public void addHasScale(EntityID propertyValue) {
        EntityID LogarithmicUnitID = getEntityInstanceID();

        getJenaModel().add(LogarithmicUnitID.getJenaResource(),
                getJenaModel().createProperty("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale"),
                propertyValue.getJenaResource());
    }

}