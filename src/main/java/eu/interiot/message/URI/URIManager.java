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


    package eu.interiot.message.URI;

    /**
     * A container for any URI used in Inter-IoT {@Link Message Message} metadata or payload.
     */
    public interface URIManager {
        interface PREFIX {
            String rdf = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
            String rdfs = "http://www.w3.org/2000/01/rdf-schema#";
            String xsd = "http://www.w3.org/2001/XMLSchema#";

            String InterIoT = BASE.INTERIoT;
        }

        interface BASE {
            /**
             * The base for all INTER-IoT URIs
             */
            String INTERIoT = "http://inter-iot.eu/";

            /**
             * A class that stores URI bases for individuals.
             * For instance, a new Device URI can be created by getting the Device Instance URI base and attaching a string at the end.
             * (String device_1_URI = URIManager.Base.Instance.Device + "Device_1")
             */
            interface INSTANCE {
                String Instance = INTERIoT + "inst/";

                String Platform = Instance + "platform/";
                String Device = Instance + "dev/";
                String User = Instance + "user/";
                String Observation = Instance + "obs/";
                String Result = Instance + "result/";
            }
        }

        interface TYPES {

        }

        interface PROPERTIES {

            interface DATA {

            }

            interface OBJECT {

            }

            interface ANNOTATION {

            }
        }

        interface INSTANCES {

        }
    }
