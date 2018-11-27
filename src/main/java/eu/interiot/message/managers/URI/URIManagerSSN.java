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
 * /**
 * * A container for any ID used in Inter-IoT {@Link Message Message} metadata or payload.
 */
public interface URIManagerSSN {


    interface PREFIX {

        String rdf = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
        String dcterms = "http://purl.org/dc/terms/";
        String voaf = "http://purl.org/vocommons/voaf#";
        String sosa = "http://www.w3.org/ns/sosa/";
        String owl = "http://www.w3.org/2002/07/owl#";
        String skos = "http://www.w3.org/2004/02/skos/core#";
        String foaf = "http://xmlns.com/foaf/0.1/";
        String schema = "http://schema.org/";
        String rdfs = "http://www.w3.org/2000/01/rdf-schema#";
        String vann = "http://purl.org/vocab/vann/";
        String xsd = "http://www.w3.org/2001/XMLSchema#";
        String time = "http://www.w3.org/2006/time#";
        String ssn = "http://www.w3.org/ns/ssn/";
    }

    interface BASE {
    }

    interface TYPES {

        String Observation = PREFIX.sosa + "Observation";
        String ActuatableProperty = PREFIX.sosa + "ActuatableProperty";
        String Property = PREFIX.ssn + "Property";
        String Procedure = PREFIX.sosa + "Procedure";
        String System = PREFIX.ssn + "System";
        String TemporalEntity = PREFIX.time + "TemporalEntity";
        String Platform = PREFIX.sosa + "Platform";
        String Stimulus = PREFIX.ssn + "Stimulus";
        String Input = PREFIX.ssn + "Input";
        String Sampling = PREFIX.sosa + "Sampling";
        String Actuator = PREFIX.sosa + "Actuator";
        String ObservableProperty = PREFIX.sosa + "ObservableProperty";
        String Result = PREFIX.sosa + "Result";
        String Sample = PREFIX.sosa + "Sample";
        String Vocabulary = PREFIX.voaf + "Vocabulary";
        String Sampler = PREFIX.sosa + "Sampler";
        String FeatureOfInterest = PREFIX.sosa + "FeatureOfInterest";
        String Output = PREFIX.ssn + "Output";
        String Deployment = PREFIX.ssn + "Deployment";
        String Sensor = PREFIX.sosa + "Sensor";
        String Agent = PREFIX.foaf + "Agent";
        String Actuation = PREFIX.sosa + "Actuation";
    }

    interface INSTANCES {

        String ssn = PREFIX.ssn + "";
        String sosa = PREFIX.sosa + "";
    }

    interface PROPERTIES {

        interface DATA {

            String resultTime = PREFIX.sosa + "resultTime";
            String hasSimpleResult = PREFIX.sosa + "hasSimpleResult";
        }


        interface OBJECT {

            String hasDeployment = PREFIX.ssn + "hasDeployment";
            String isProxyFor = PREFIX.ssn + "isProxyFor";
            String deployedSystem = PREFIX.ssn + "deployedSystem";
            String forProperty = PREFIX.ssn + "forProperty";
            String hasSample = PREFIX.sosa + "hasSample";
            String hasOutput = PREFIX.ssn + "hasOutput";
            String hasProperty = PREFIX.ssn + "hasProperty";
            String inDeployment = PREFIX.ssn + "inDeployment";
            String isPropertyOf = PREFIX.ssn + "isPropertyOf";
            String detects = PREFIX.ssn + "detects";
            String implementsX = PREFIX.ssn + "implements";
            String implementedBy = PREFIX.ssn + "implementedBy";
            String hasInput = PREFIX.ssn + "hasInput";
            String hasSubSystem = PREFIX.ssn + "hasSubSystem";
            String deployedOnPlatform = PREFIX.ssn + "deployedOnPlatform";
            String wasOriginatedBy = PREFIX.ssn + "wasOriginatedBy";
            String phenomenonTime = PREFIX.sosa + "phenomenonTime";
            String madeBySampler = PREFIX.sosa + "madeBySampler";
            String hasResult = PREFIX.sosa + "hasResult";
            String madeObservation = PREFIX.sosa + "madeObservation";
            String observedProperty = PREFIX.sosa + "observedProperty";
            String usedProcedure = PREFIX.sosa + "usedProcedure";
            String observes = PREFIX.sosa + "observes";
            String isActedOnBy = PREFIX.sosa + "isActedOnBy";
            String hosts = PREFIX.sosa + "hosts";
            String isFeatureOfInterestOf = PREFIX.sosa + "isFeatureOfInterestOf";
            String isSampleOf = PREFIX.sosa + "isSampleOf";
            String madeActuation = PREFIX.sosa + "madeActuation";
            String madeByActuator = PREFIX.sosa + "madeByActuator";
            String isObservedBy = PREFIX.sosa + "isObservedBy";
            String madeSampling = PREFIX.sosa + "madeSampling";
            String madeBySensor = PREFIX.sosa + "madeBySensor";
            String actsOnProperty = PREFIX.sosa + "actsOnProperty";
            String isHostedBy = PREFIX.sosa + "isHostedBy";
            String hasFeatureOfInterest = PREFIX.sosa + "hasFeatureOfInterest";
            String isResultOf = PREFIX.sosa + "isResultOf";
        }


        interface ANNOTATION {

            String description = PREFIX.dcterms + "description";
            String name = PREFIX.foaf + "name";
            String rights = PREFIX.dcterms + "rights";
            String created = PREFIX.dcterms + "created";
            String title = PREFIX.dcterms + "title";
            String example = PREFIX.skos + "example";
            String preferredNamespacePrefix = PREFIX.vann + "preferredNamespacePrefix";
            String definition = PREFIX.skos + "definition";
            String creator = PREFIX.dcterms + "creator";
            String preferredNamespaceUri = PREFIX.vann + "preferredNamespaceUri";
            String license = PREFIX.dcterms + "license";
            String domainIncludes = PREFIX.schema + "domainIncludes";
            String note = PREFIX.skos + "note";
            String rangeIncludes = PREFIX.schema + "rangeIncludes";
        }

    }

}