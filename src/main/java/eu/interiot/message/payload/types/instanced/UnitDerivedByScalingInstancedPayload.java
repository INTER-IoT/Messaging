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
 * Payload for class UnitDerivedByScaling with URI http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByScaling
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit, http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit, http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 */
public class UnitDerivedByScalingInstancedPayload extends InstancedPayload {

   /*
Properties:

*/

    public UnitDerivedByScalingInstancedPayload(EntityID UnitDerivedByScalingID) {
        this(UnitDerivedByScalingID, false);
    }

    public UnitDerivedByScalingInstancedPayload(EntityID UnitDerivedByScalingID, boolean useRDFSInferencer) {
        super(UnitDerivedByScalingID, new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByScaling"), useRDFSInferencer);
    }

    public UnitDerivedByScalingInstancedPayload(EntityID UnitDerivedByScalingID, Model jenaModel) {
        this(UnitDerivedByScalingID, jenaModel, false);
    }

    public UnitDerivedByScalingInstancedPayload(EntityID UnitDerivedByScalingID, Model jenaModel, boolean useRDFSInferencer) {
        super(UnitDerivedByScalingID, new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByScaling"), jenaModel, useRDFSInferencer);
    }

    public EntityID getUnitDerivedByScalingInstanceID() {
        return getEntityInstanceID();
    }

    public void setUnitDerivedByScalingInstanceID(EntityID UnitDerivedByScalingID) {
        setEntityInstanceID(UnitDerivedByScalingID);
    }


}