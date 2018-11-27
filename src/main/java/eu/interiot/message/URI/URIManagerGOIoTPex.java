package eu.interiot.message.URI;

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

public interface URIManagerGOIoTPex extends URIManager {

    interface PREFIX extends URIManager.PREFIX {
        String iiot = BASE.GOIoTP;
        String iiotex = BASE.GOIoTPex;

        String ssn = "http://www.w3.org/ns/ssn/";
        String sosa = "http://www.w3.org/ns/sosa/";

        String DUL = "http://www.loa-cnr.it/ontologies/DUL.owl#";
        String oldssn = "http://purl.oclc.org/NET/ssnx/ssn#";

        String aws = "http://purl.oclc.org/NET/ssnx/meteo/aws#";
        String cffeature = "http://purl.oclc.org/NET/ssnx/cf/cf-feature#";
        String cfproperty = "http://purl.oclc.org/NET/ssnx/cf/cf-property#";
        String prov = "http://purl.org/net/provenance/ns#";
        String qu = "http://purl.oclc.org/NET/ssnx/qu/qu#";
        String rr = "http://www.w3.org/ns/r2rml#";
        String unit = "http://purl.oclc.org/NET/ssnx/qu/unit#";
        String wgs84 = "http://www.w3.org/2003/01/geo/wgs84_pos#";
        String uo = "http://purl.obolibrary.org/obo/uo.owl/";
        String time = "http://www.w3.org/2006/time#";
        String sweet_units = "http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#";
    }


    interface BASE extends URIManager.BASE {
        String GOIoTP = "http://inter-iot.eu/GOIoTP#";
        String GOIoTPex = "http://inter-iot.eu/GOIoTPex#";
    }

    interface TYPES extends URIManager.TYPES {
        String Platform = PREFIX.sosa + "Platform";
        String SoftwarePlatform = BASE.GOIoTP + "SoftwarePlatform";
        String IoTDevice = BASE.GOIoTP + "IoTDevice";
        String Sensor = PREFIX.sosa + "Sensor";
        String Observation = PREFIX.sosa + "Observation";
        String Middleware = BASE.GOIoTP + "Middleware";

        String Mass = BASE.GOIoTPex + "Mass";
        String Result = PREFIX.sosa + "Result";
        String ObservableProperty = PREFIX.sosa + "ObservableProperty";

        String Instant = PREFIX.time + "Instant";

        String UniversAAL = BASE.GOIoTPex + "UniversAAL";
        String FIWARE = BASE.GOIoTPex + "FIWARE";
    }

    interface PROPERTIES extends URIManager.PROPERTIES {
        interface DATA extends URIManager.PROPERTIES.DATA {

            String hasName = BASE.GOIoTP + "hasName";
            String hasURI = BASE.GOIoTP + "hasURI";
            String hasBaseEndpoint = BASE.GOIoTP + "hasBaseEndpoint";
            String hasResultValue = BASE.GOIoTP + "hasResultValue";
            String resultTime = PREFIX.sosa + "resultTime";

            String inXSDDateTimeStamp = PREFIX.time + "inXSDDateTimeStamp";
        }

        interface OBJECT extends URIManager.PROPERTIES.OBJECT {

            String isHostedBy = PREFIX.sosa + "isHostedBy";
            String hasSemantics = PREFIX.iiot + "hasSemantics";
            String hasComponent = PREFIX.iiot + "hasComponent";

            String madeBySensor = PREFIX.sosa + "madeBySensor";
            String observedProperty = PREFIX.sosa + "observedProperty";
            String phenomenonTime = PREFIX.sosa + "phenomenonTime";
            String hasResult = PREFIX.sosa + "hasResult";

            String hasUnit = PREFIX.iiot + "hasUnit";
        }

        interface ANNOTATION extends URIManager.PROPERTIES.ANNOTATION {

        }
    }

    interface INSTANCES extends URIManager.INSTANCES {
        String instKilogramURI = PREFIX.sweet_units + "kilogram";
    }
}
