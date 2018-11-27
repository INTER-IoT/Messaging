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
import eu.interiot.message.payload.InstancedPayload;
import org.apache.jena.rdf.model.Model;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class Location with URI http://inter-iot.eu/GOIoTP#Location
 * <p>
 * Attributes:
 * AsWKT
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class LocationInstancedPayload extends InstancedPayload {

   /*
Properties:
AsWKT
*/

    public LocationInstancedPayload(EntityID LocationID) {
        this(LocationID, false);
    }

    public LocationInstancedPayload(EntityID LocationID, boolean useRDFSInferencer) {
        super(LocationID, new EntityID("http://inter-iot.eu/GOIoTP#Location"), useRDFSInferencer);
    }

    public LocationInstancedPayload(EntityID LocationID, Model jenaModel) {
        this(LocationID, jenaModel, false);
    }

    public LocationInstancedPayload(EntityID LocationID, Model jenaModel, boolean useRDFSInferencer) {
        super(LocationID, new EntityID("http://inter-iot.eu/GOIoTP#Location"), jenaModel, useRDFSInferencer);
    }

    public EntityID getLocationInstanceID() {
        return getEntityInstanceID();
    }

    public void setLocationInstanceID(EntityID LocationID) {
        setEntityInstanceID(LocationID);
    }


    /**
     * Getter for http://www.opengis.net/ont/geosparql#asWKT data property assertion
     */
    public Optional<String> getAsWKT() {
        EntityID LocationID = getEntityInstanceID();

        Set<Object> s = getJenaModel().listObjectsOfProperty(
                LocationID.getJenaResource(),
                getJenaModel().createProperty("http://www.opengis.net/ont/geosparql#asWKT"))
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
     * Setter for http://www.opengis.net/ont/geosparql#asWKT data property assertion
     */
    public void setAsWKT(String propertyValue) {
        EntityID LocationID = getEntityInstanceID();

        removeAsWKT();
        getJenaModel().add(
                getJenaModel().createLiteralStatement(LocationID.getJenaResource(),
                        getJenaModel().createProperty("http://www.opengis.net/ont/geosparql#asWKT"),
                        propertyValue
                ));
    }

    /**
     * Remover for http://www.opengis.net/ont/geosparql#asWKT data property assertion
     */
    public void removeAsWKT() {
        EntityID LocationID = getEntityInstanceID();

        getJenaModel().removeAll(LocationID.getJenaResource(),
                getJenaModel().createProperty("http://www.opengis.net/ont/geosparql#asWKT"),
                null);
    }

}