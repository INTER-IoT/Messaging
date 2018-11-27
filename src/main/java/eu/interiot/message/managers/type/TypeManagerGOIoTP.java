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


package eu.interiot.message.managers.type;

import eu.interiot.message.ID.EntityID;

import java.util.*;

/**
 * Subclass structure:
 * <p>
 * http://inter-iot.eu/GOIoTP#Ontology
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#Semantics
 * <p>
 * http://inter-iot.eu/GOIoTP#Location
 * http://www.w3.org/2002/07/owl#Thing
 * http://www.opengis.net/ont/geosparql#SpatialObject
 * <p>
 * http://inter-iot.eu/GOIoTP#DomainOfInterest
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://www.opengis.net/ont/geosparql#Geometry
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://www.w3.org/ns/sosa/Platform
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTP#PlatformComponent
 * http://www.w3.org/2002/07/owl#Thing
 * http://www.w3.org/ns/ssn/System
 * <p>
 * http://inter-iot.eu/GOIoTP#Middleware
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#PlatformComponent
 * http://www.w3.org/ns/ssn/System
 * <p>
 * http://www.opengis.net/ont/geosparql#SpatialObject
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTP#Semantics
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * http://www.w3.org/2002/07/owl#Thing
 * http://www.w3.org/ns/ssn/Property
 * <p>
 * http://www.w3.org/ns/sosa/Observation
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTP#SoftwarePlatform
 * http://www.w3.org/2002/07/owl#Thing
 * http://www.w3.org/ns/sosa/Platform
 * <p>
 * http://inter-iot.eu/GOIoTP#Service
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://purl.org/vocommons/voaf#Vocabulary
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://www.w3.org/ns/ssn/System
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://xmlns.com/foaf/0.1/Person
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://www.w3.org/ns/sosa/Sensor
 * http://www.w3.org/2002/07/owl#Thing
 * http://www.w3.org/ns/ssn/System
 * <p>
 * http://inter-iot.eu/GOIoTP#User
 * http://www.w3.org/2002/07/owl#Thing
 * http://www.w3.org/ns/sosa/FeatureOfInterest
 * <p>
 * http://inter-iot.eu/GOIoTP#IoTDevice
 * http://www.w3.org/2002/07/owl#Thing
 * http://www.w3.org/ns/sosa/Platform
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://www.w3.org/ns/sosa/Result
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://www.w3.org/ns/ssn/Property
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://www.w3.org/ns/sosa/FeatureOfInterest
 * http://www.w3.org/2002/07/owl#Thing
 */
public class TypeManagerGOIoTP {

    static Map<EntityID, Set<EntityID>> supertypeMap = new HashMap<>();

    static {

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#Ontology"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#Semantics")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#Location"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://www.opengis.net/ont/geosparql#SpatialObject")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#DomainOfInterest"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://www.opengis.net/ont/geosparql#Geometry"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://www.w3.org/ns/sosa/Platform"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#PlatformComponent"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://www.w3.org/ns/ssn/System")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#PlatformComponent"),
                        new EntityID("http://www.w3.org/ns/ssn/System")
                )));

        supertypeMap.put(new EntityID("http://www.opengis.net/ont/geosparql#SpatialObject"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#Semantics"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://www.w3.org/ns/ssn/Property")
                )));

        supertypeMap.put(new EntityID("http://www.w3.org/ns/sosa/Observation"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#SoftwarePlatform"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://www.w3.org/ns/sosa/Platform")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#Service"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://purl.org/vocommons/voaf#Vocabulary"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://www.w3.org/ns/ssn/System"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://xmlns.com/foaf/0.1/Person"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://www.w3.org/ns/sosa/Sensor"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://www.w3.org/ns/ssn/System")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#User"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://www.w3.org/ns/sosa/FeatureOfInterest")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#IoTDevice"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://www.w3.org/ns/sosa/Platform")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://www.w3.org/ns/sosa/Result"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://www.w3.org/ns/ssn/Property"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://www.w3.org/ns/sosa/FeatureOfInterest"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

    }

    /**
     * Returns a possibly empty set of all explicit superclasses (supertypes) for a given type.
     *
     * @param typeID
     * @return
     */
    public static Set<EntityID> getSupertypeSet(EntityID typeID) {
        return supertypeMap.getOrDefault(typeID, new HashSet<EntityID>());
    }

    /**
     * Returns a possibly empty set of all explicit superclasses (supertypes) for a given type, including the type in the argument.
     *
     * @param typeID
     * @return
     */
    public static Set<EntityID> getAllTypes(EntityID typeID) {
        Set<EntityID> s = getSupertypeSet(typeID);
        s.add(typeID);
        return s;
    }


}