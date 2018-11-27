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
 * Payload for class ElectricPotentialDifference with URI http://inter-iot.eu/GOIoTPex#ElectricPotentialDifference
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/2002/07/owl#Thing, http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK, http://inter-iot.eu/GOIoTP#MeasurementKind
 */
public class ElectricPotentialDifferenceInstancedPayload extends InstancedPayload {

   /*
Properties:

*/

    public ElectricPotentialDifferenceInstancedPayload(EntityID ElectricPotentialDifferenceID) {
        this(ElectricPotentialDifferenceID, false);
    }

    public ElectricPotentialDifferenceInstancedPayload(EntityID ElectricPotentialDifferenceID, boolean useRDFSInferencer) {
        super(ElectricPotentialDifferenceID, new EntityID("http://inter-iot.eu/GOIoTPex#ElectricPotentialDifference"), useRDFSInferencer);
    }

    public ElectricPotentialDifferenceInstancedPayload(EntityID ElectricPotentialDifferenceID, Model jenaModel) {
        this(ElectricPotentialDifferenceID, jenaModel, false);
    }

    public ElectricPotentialDifferenceInstancedPayload(EntityID ElectricPotentialDifferenceID, Model jenaModel, boolean useRDFSInferencer) {
        super(ElectricPotentialDifferenceID, new EntityID("http://inter-iot.eu/GOIoTPex#ElectricPotentialDifference"), jenaModel, useRDFSInferencer);
    }

    public EntityID getElectricPotentialDifferenceInstanceID() {
        return getEntityInstanceID();
    }

    public void setElectricPotentialDifferenceInstanceID(EntityID ElectricPotentialDifferenceID) {
        setEntityInstanceID(ElectricPotentialDifferenceID);
    }


}