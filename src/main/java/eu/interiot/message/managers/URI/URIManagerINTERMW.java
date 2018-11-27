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


package eu.interiot.message.managers.URI;

/**
 * This URI Manager manages entities (mostly types) that are very specific to INTER-MW development and pilots
 */
public interface URIManagerINTERMW extends URIManager {
    interface PREFIX extends URIManager.PREFIX {
        String intermw = "http://inter-iot.eu/INTERMW#";
    }

    interface TYPES extends URIManager.TYPES {

        String FIWARE = URIManagerGOIoTPex.TYPES.FIWARE;
        String UniversAAL = URIManagerGOIoTPex.TYPES.UniversAAL;
        String Azure = URIManagerGOIoTPex.TYPES.Azure;
        String OneM2M = URIManagerGOIoTPex.TYPES.OneM2M;
        String WSO2 = URIManagerGOIoTPex.TYPES.WSO2;

        //Matevž, Damjan and Aleš - add new types below.
        //Also be aware that this comment (with your names) will probably stay in this open code forever.
        //(We will all forget to delete it)
        String BodyCloud = PREFIX.intermw + "BodyCloud";
        String BodyCloudEmulated = PREFIX.intermw + "BodyCloudEmulated";
        String UniversAALEmulated = PREFIX.intermw + "UniversAALEmulated";
        String Emulator = PREFIX.intermw + "Emulator";

        //IPSM Bridge config
        String IPSMBridgeSemantics = PREFIX.intermw + "IPSMBridgeSemantics";
        String IPSMChannelConfig = PREFIX.intermw + "IPSMChannelConfig";
        String IPSMAlignment = PREFIX.intermw + "IPSMAlignment";
    }

    interface PROPERTIES extends URIManager.PROPERTIES {

        interface OBJECT extends URIManager.PROPERTIES.OBJECT {
            String hasDownstreamChannelConfig = PREFIX.intermw + "hasDownstreamChannelConfig";
            String hasUpstreamChannelConfig = PREFIX.intermw + "hasUpstreamChannelConfig";
            String hasInputAlignment = PREFIX.intermw + "hasInputAlignment";
            String hasOutputAlignment = PREFIX.intermw + "hasOutputAlignment";
        }
    }
}
