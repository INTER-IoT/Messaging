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

/**
 * Payload for class Measurement with URI http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing
 */
public class MeasurementInstancedPayload extends InstancedPayload {

   /*
Properties:

*/

    public MeasurementInstancedPayload(EntityID MeasurementID) {
        this(MeasurementID, false);
    }

    public MeasurementInstancedPayload(EntityID MeasurementID, boolean useRDFSInferencer) {
        super(MeasurementID, new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement"), useRDFSInferencer);
    }

    public MeasurementInstancedPayload(EntityID MeasurementID, Model jenaModel) {
        this(MeasurementID, jenaModel, false);
    }

    public MeasurementInstancedPayload(EntityID MeasurementID, Model jenaModel, boolean useRDFSInferencer) {
        super(MeasurementID, new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement"), jenaModel, useRDFSInferencer);
    }

    public EntityID getMeasurementInstanceID() {
        return getEntityInstanceID();
    }

    public void setMeasurementInstanceID(EntityID MeasurementID) {
        setEntityInstanceID(MeasurementID);
    }


}