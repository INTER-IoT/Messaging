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


package eu.interiot.message.managers.ID;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.ID.PropertyID;

/**
 * * A container for any ID used in Inter-IoT {@Link Message Message} metadata or payload.
 */
public interface IDManagerGOIoTP {

    interface TYPES {

        EntityID Observation = new EntityID("http://www.w3.org/ns/sosa/Observation");
        EntityID Procedure = new EntityID("http://www.w3.org/ns/sosa/Procedure");
        EntityID System = new EntityID("http://www.w3.org/ns/ssn/System");
        EntityID TemporalEntity = new EntityID("http://www.w3.org/2006/time#TemporalEntity");
        EntityID Person = new EntityID("http://xmlns.com/foaf/0.1/Person");
        EntityID Geometry = new EntityID("http://www.opengis.net/ont/geosparql#Geometry");
        EntityID PlatformComponent = new EntityID("http://inter-iot.eu/GOIoTP#PlatformComponent");
        EntityID Stimulus = new EntityID("http://www.w3.org/ns/ssn/Stimulus");
        EntityID Input = new EntityID("http://www.w3.org/ns/ssn/Input");
        EntityID Ontology = new EntityID("http://inter-iot.eu/GOIoTP#Ontology");
        EntityID Location = new EntityID("http://inter-iot.eu/GOIoTP#Location");
        EntityID Unit = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit");
        EntityID Sample = new EntityID("http://www.w3.org/ns/sosa/Sample");
        EntityID User = new EntityID("http://inter-iot.eu/GOIoTP#User");
        EntityID Vocabulary = new EntityID("http://purl.org/vocommons/voaf#Vocabulary");
        EntityID Deployment = new EntityID("http://www.w3.org/ns/ssn/Deployment");
        EntityID Sensor = new EntityID("http://www.w3.org/ns/sosa/Sensor");
        EntityID Agent = new EntityID("http://xmlns.com/foaf/0.1/Agent");
        EntityID Actuation = new EntityID("http://www.w3.org/ns/sosa/Actuation");
        EntityID ActuatableProperty = new EntityID("http://www.w3.org/ns/sosa/ActuatableProperty");
        EntityID Property = new EntityID("http://www.w3.org/ns/ssn/Property");
        EntityID SpatialObject = new EntityID("http://www.opengis.net/ont/geosparql#SpatialObject");
        EntityID Platform = new EntityID("http://www.w3.org/ns/sosa/Platform");
        EntityID MeasurementKind = new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind");
        EntityID Sampling = new EntityID("http://www.w3.org/ns/sosa/Sampling");
        EntityID Actuator = new EntityID("http://www.w3.org/ns/sosa/Actuator");
        EntityID DomainOfInterest = new EntityID("http://inter-iot.eu/GOIoTP#DomainOfInterest");
        EntityID IoTDevice = new EntityID("http://inter-iot.eu/GOIoTP#IoTDevice");
        EntityID SoftwarePlatform = new EntityID("http://inter-iot.eu/GOIoTP#SoftwarePlatform");
        EntityID ObservableProperty = new EntityID("http://www.w3.org/ns/sosa/ObservableProperty");
        EntityID Result = new EntityID("http://www.w3.org/ns/sosa/Result");
        EntityID Sampler = new EntityID("http://www.w3.org/ns/sosa/Sampler");
        EntityID FeatureOfInterest = new EntityID("http://www.w3.org/ns/sosa/FeatureOfInterest");
        EntityID Output = new EntityID("http://www.w3.org/ns/ssn/Output");
        EntityID Semantics = new EntityID("http://inter-iot.eu/GOIoTP#Semantics");
        EntityID Middleware = new EntityID("http://inter-iot.eu/GOIoTP#Middleware");
        EntityID Service = new EntityID("http://inter-iot.eu/GOIoTP#Service");
    }

    interface INSTANCES {

        EntityID ssn = new EntityID("http://www.w3.org/ns/ssn/");
        EntityID GOIoTP = new EntityID("http://inter-iot.eu/GOIoTP#");
        EntityID sosa = new EntityID("http://www.w3.org/ns/sosa/");
    }

    interface PROPERTIES {

        interface DATA {

            PropertyID asWKT = new PropertyID("http://www.opengis.net/ont/geosparql#asWKT");
            PropertyID hasVersion = new PropertyID("http://inter-iot.eu/GOIoTP#hasVersion");
            PropertyID hasURI = new PropertyID("http://inter-iot.eu/GOIoTP#hasURI");
            PropertyID hasResultValue = new PropertyID("http://inter-iot.eu/GOIoTP#hasResultValue");
            PropertyID hasName = new PropertyID("http://inter-iot.eu/GOIoTP#hasName");
            PropertyID hasBaseEndpoint = new PropertyID("http://inter-iot.eu/GOIoTP#hasBaseEndpoint");
            PropertyID resultTime = new PropertyID("http://www.w3.org/ns/sosa/resultTime");
            PropertyID hasSimpleResult = new PropertyID("http://www.w3.org/ns/sosa/hasSimpleResult");
        }


        interface OBJECT {

            PropertyID isOwnerOf = new PropertyID("http://inter-iot.eu/GOIoTP#isOwnerOf");
            PropertyID hasUnit = new PropertyID("http://inter-iot.eu/GOIoTP#hasUnit");
            PropertyID hasDomainOfInterest = new PropertyID("http://inter-iot.eu/GOIoTP#hasDomainOfInterest");
            PropertyID hasLocation = new PropertyID("http://inter-iot.eu/GOIoTP#hasLocation");
            PropertyID hasOwner = new PropertyID("http://inter-iot.eu/GOIoTP#hasOwner");
            PropertyID hasUser = new PropertyID("http://inter-iot.eu/GOIoTP#hasUser");
            PropertyID hasMeasurementKind = new PropertyID("http://inter-iot.eu/GOIoTP#hasMeasurementKind");
            PropertyID hasComponent = new PropertyID("http://inter-iot.eu/GOIoTP#hasComponent");
            PropertyID hasSemantics = new PropertyID("http://inter-iot.eu/GOIoTP#hasSemantics");
            PropertyID isUserOf = new PropertyID("http://inter-iot.eu/GOIoTP#isUserOf");
            PropertyID hasDeployment = new PropertyID("http://www.w3.org/ns/ssn/hasDeployment");
            PropertyID isProxyFor = new PropertyID("http://www.w3.org/ns/ssn/isProxyFor");
            PropertyID deployedSystem = new PropertyID("http://www.w3.org/ns/ssn/deployedSystem");
            PropertyID forProperty = new PropertyID("http://www.w3.org/ns/ssn/forProperty");
            PropertyID hasOutput = new PropertyID("http://www.w3.org/ns/ssn/hasOutput");
            PropertyID hasProperty = new PropertyID("http://www.w3.org/ns/ssn/hasProperty");
            PropertyID inDeployment = new PropertyID("http://www.w3.org/ns/ssn/inDeployment");
            PropertyID isPropertyOf = new PropertyID("http://www.w3.org/ns/ssn/isPropertyOf");
            PropertyID detects = new PropertyID("http://www.w3.org/ns/ssn/detects");
            PropertyID implementsX = new PropertyID("http://www.w3.org/ns/ssn/implements");
            PropertyID implementedBy = new PropertyID("http://www.w3.org/ns/ssn/implementedBy");
            PropertyID hasInput = new PropertyID("http://www.w3.org/ns/ssn/hasInput");
            PropertyID hasSubSystem = new PropertyID("http://www.w3.org/ns/ssn/hasSubSystem");
            PropertyID deployedOnPlatform = new PropertyID("http://www.w3.org/ns/ssn/deployedOnPlatform");
            PropertyID wasOriginatedBy = new PropertyID("http://www.w3.org/ns/ssn/wasOriginatedBy");
            PropertyID phenomenonTime = new PropertyID("http://www.w3.org/ns/sosa/phenomenonTime");
            PropertyID madeBySampler = new PropertyID("http://www.w3.org/ns/sosa/madeBySampler");
            PropertyID hasResult = new PropertyID("http://www.w3.org/ns/sosa/hasResult");
            PropertyID madeObservation = new PropertyID("http://www.w3.org/ns/sosa/madeObservation");
            PropertyID observedProperty = new PropertyID("http://www.w3.org/ns/sosa/observedProperty");
            PropertyID hasSample = new PropertyID("http://www.w3.org/ns/sosa/hasSample");
            PropertyID usedProcedure = new PropertyID("http://www.w3.org/ns/sosa/usedProcedure");
            PropertyID observes = new PropertyID("http://www.w3.org/ns/sosa/observes");
            PropertyID isActedOnBy = new PropertyID("http://www.w3.org/ns/sosa/isActedOnBy");
            PropertyID hosts = new PropertyID("http://www.w3.org/ns/sosa/hosts");
            PropertyID isFeatureOfInterestOf = new PropertyID("http://www.w3.org/ns/sosa/isFeatureOfInterestOf");
            PropertyID isSampleOf = new PropertyID("http://www.w3.org/ns/sosa/isSampleOf");
            PropertyID madeActuation = new PropertyID("http://www.w3.org/ns/sosa/madeActuation");
            PropertyID madeByActuator = new PropertyID("http://www.w3.org/ns/sosa/madeByActuator");
            PropertyID isObservedBy = new PropertyID("http://www.w3.org/ns/sosa/isObservedBy");
            PropertyID madeSampling = new PropertyID("http://www.w3.org/ns/sosa/madeSampling");
            PropertyID madeBySensor = new PropertyID("http://www.w3.org/ns/sosa/madeBySensor");
            PropertyID actsOnProperty = new PropertyID("http://www.w3.org/ns/sosa/actsOnProperty");
            PropertyID isHostedBy = new PropertyID("http://www.w3.org/ns/sosa/isHostedBy");
            PropertyID hasFeatureOfInterest = new PropertyID("http://www.w3.org/ns/sosa/hasFeatureOfInterest");
            PropertyID isResultOf = new PropertyID("http://www.w3.org/ns/sosa/isResultOf");
        }


        interface ANNOTATION {

            PropertyID prefLabel = new PropertyID("http://www.w3.org/2004/02/skos/core#prefLabel");
            PropertyID descriptionDC = new PropertyID("http://purl.org/dc/elements/1.1/description");
            PropertyID date = new PropertyID("http://purl.org/dc/elements/1.1/date");
            PropertyID creatorDC = new PropertyID("http://purl.org/dc/elements/1.1/creator");
            PropertyID contributor = new PropertyID("http://purl.org/dc/elements/1.1/contributor");
            PropertyID ontologyModule = new PropertyID("http://inter-iot.eu/GOIoTP#ontologyModule");
            PropertyID description = new PropertyID("http://purl.org/dc/terms/description");
            PropertyID name = new PropertyID("http://xmlns.com/foaf/0.1/name");
            PropertyID rights = new PropertyID("http://purl.org/dc/terms/rights");
            PropertyID created = new PropertyID("http://purl.org/dc/terms/created");
            PropertyID title = new PropertyID("http://purl.org/dc/terms/title");
            PropertyID example = new PropertyID("http://www.w3.org/2004/02/skos/core#example");
            PropertyID preferredNamespacePrefix = new PropertyID("http://purl.org/vocab/vann/preferredNamespacePrefix");
            PropertyID definition = new PropertyID("http://www.w3.org/2004/02/skos/core#definition");
            PropertyID preferredNamespaceUri = new PropertyID("http://purl.org/vocab/vann/preferredNamespaceUri");
            PropertyID creator = new PropertyID("http://purl.org/dc/terms/creator");
            PropertyID license = new PropertyID("http://purl.org/dc/terms/license");
            PropertyID domainIncludes = new PropertyID("http://schema.org/domainIncludes");
            PropertyID note = new PropertyID("http://www.w3.org/2004/02/skos/core#note");
            PropertyID rangeIncludes = new PropertyID("http://schema.org/rangeIncludes");
        }

    }

}