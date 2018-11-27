package eu.interiot.message.utils;

import eu.interiot.message.EntityID;
import eu.interiot.message.Message;
import eu.interiot.message.MessagePayload;
import eu.interiot.message.URI.URIManagerAthensCO;
import eu.interiot.message.URI.URIManagerMessageMetadata;
import eu.interiot.message.exceptions.MessageException;
import eu.interiot.message.exceptions.payload.PayloadException;
import org.apache.jena.atlas.lib.EscapeStr;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

public class INTERMWDemoUtils {

    //TODO: use URIs from the new URI manager interfaces

    public static final String URIiiot = URIManagerAthensCO.BASE.GOIoTP;
    public static final String URIiiotex = URIManagerAthensCO.BASE.GOIoTPex;

    public static final String URIuo = "http://purl.obolibrary.org/obo/uo.owl/";
    public static final String URIssn = "http://www.w3.org/ns/ssn/";
    public static final String URIsosa = "http://www.w3.org/ns/sosa/";
    public static final String URIoldssn = "http://purl.oclc.org/NET/ssnx/ssn#";
    public static final String URItime = "http://www.w3.org/2006/time#";
    public static final String URImedex = "http://inter-iot.eu/medex#";
    public static final String URIuAALPersonalHealthDevice = "http://ontology.universaal.org/PersonalHealthDevice.owl#";

    public static final String URIBaseUniversAAL = "http://ontology.universaal.org/";

    public static final String PlatformTypeUniversAAL = URIiiotex + "UniversAAL";
    public static final String PlatformTypeFIWARE = URIiiotex + "FIWARE";
    public static final String EntityTypePlatform = URIsosa + "Platform";
    public static final String EntityTypeSoftwarePlatform = URIiiot + "SoftwarePlatform";
    public static final String EntityTypeDevice = URIoldssn + "Device";
    public static final String EntityTypeSensor = URIsosa + "Sensor";
    public static final String EntityTypeObservation = URIssn + "Observation";
    private static final String propHasNameURI = URIiiot + "hasName";
    private static final String propIsHostedByURI = URIsosa + "isHostedBy";
    private static final String propHasURIURI = URIiiot + "hasURI";
    private static final String propHasSemanticsURI = URIiiot + "hasSemantics";
    private static final String classMiddlewareURI = URIiiot + "Middleware";
    private static final String propHasBaseEndpointURI = URIiiot + "hasBaseEndpoint";
    private static final String propHasMiddlewareURI = URIiiot + "hasMiddleware";
    private static final String propResultTimeURI = URIsosa + "resultTime";
    private static final String propMadeBySensorURI = URIsosa + "madeBySensor";
    private static final String propObservedPropertyURI = URIsosa + "observedProperty";
    private static final String propPhenomenonTimeURI = URIsosa + "phenomenonTime";
    private static final String propHasResultURI = URIsosa + "hasResult";
    private static final String propInXSDDateTimeURI = URItime + "inXSDDateTimeStamp";
    private static final String propHasUnitURI = URIiiot + "hasUnit";
    private static final String propHasValueURI = URIiiot + "hasValue";
    private static final String classObservablePropertyURI = URIsosa + "ObservableProperty";
    private static final String classMassURI = URIiiotex + "Mass";
    private static final String classInstantURI = URItime + "Instant";
    private static final String classResultURI = URIsosa + "Result";
    private static final String instKilogramURI = URIiiotex + "kilogram";

//    @prefix ns: <http://ontology.universaal.org/PhThing.owl#> .
//    @prefix ns1: <http://ontology.universAAL.org/SimpleHealthclient.owl#> .
//    @prefix ns2: <http://ontology.universaal.org/Measurement.owl#> .
//    @prefix ns3: <http://ontology.universaal.org/HealthMeasurement.owl#> .
//    @prefix ns4: <http://ontology.universAAL.org/Device.owl#> .
//    @prefix ns5: <http://ontology.universAAL.org/PersonalHealthDevice.owl#> .
//    @prefix xsd: <http://www.w3.org/2001/XMLSchema#> .
//    @prefix owl: <http://www.w3.org/2002/07/owl#> .
//    @prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
//    @prefix UniversAAL_Context: <http://ontology.universAAL.org/Context.owl#> .
//    @prefix UniversAAL: <http://ontology.universaal.org/> .

    private static Message prepareMessage(Model model) {
        Message m = new Message();
        m.setPayload(new MessagePayload(model));
        return m;
    }

    /**
     * @param platformURIIdentifier URI identifier of RDF platform entity e.g. http:inter-iot.eu/plat/Platform_1
     * @param platformName          Human readable platform name e.g. "UniversAAL weighing station"
     * @param platformType          PlatformTypeFIWARE or PlatformTypeUniversAAL (static string from {@link INTERMWDemoUtils} class)
     * @param platformBaseURI       URL of the demo bridge e.g. http://localhost:8081/ngsi/
     * @return
     */
    public static MessagePayload createRegisterPlatformPayload(String platformURIIdentifier, String platformName, String platformType, String platformBaseURI) {
        Model payloadModel = createRegisterPlatformModel(platformURIIdentifier, platformName, platformType, platformBaseURI);

        return new MessagePayload(payloadModel);
    }

    public static MessagePayload createRegisterPlatformPayload(EntityID platformID, String platformName, EntityID platformType, String platformBaseURI) {
        Model payloadModel = createRegisterPlatformModel(platformID, platformName, platformType, platformBaseURI);

        return new MessagePayload(payloadModel);
    }

    public static Model createRegisterPlatformModel(EntityID platformID, String platformName, EntityID platformType, String platformBaseURI) {
        Model payloadModel = ModelFactory.createDefaultModel();

        Property hasSemantics = payloadModel.createProperty(propHasSemanticsURI);
        Property hasURI = payloadModel.createProperty(propHasURIURI);
        Property hasName = payloadModel.createProperty(propHasNameURI);

        Resource platform = platformID.getJenaResource();

        payloadModel.add(platform, RDF.type, payloadModel.createResource(EntityTypePlatform));
        payloadModel.add(platform, RDF.type, payloadModel.createResource(EntityTypeSoftwarePlatform));
        payloadModel.add(platform, hasName, platformName);

        if (platformType.getJenaResource().getURI() == PlatformTypeUniversAAL) {
            payloadModel.add(platform, hasSemantics,
                    payloadModel.createResource()
                            .addProperty(RDF.type,
                                    payloadModel.createResource(URIiiot + "Ontology"))
                            .addProperty(hasURI, URIBaseUniversAAL));
        }

        Resource middleware = payloadModel
                .createResource()
                .addProperty(RDF.type,
                        payloadModel.createResource(classMiddlewareURI))
                .addProperty(RDF.type,
                        platformType.getJenaResource())
                .addProperty(payloadModel.createProperty(propHasBaseEndpointURI),
                        platformBaseURI);

        payloadModel.add(platform,
                payloadModel.createProperty(propHasMiddlewareURI),
                middleware);

        return payloadModel;
    }

    public static Model createRegisterPlatformModel(String platformURIIdentifier, String platformName, String platformType, String platformBaseURI) {
//        Model payloadModel = ModelFactory.createDefaultModel();
//
//        Property hasSemantics = payloadModel.createProperty(propHasSemanticsURI);
//        Property hasURI = payloadModel.createProperty(propHasURIURI);
//        Property hasName = payloadModel.createProperty(propHasNameURI);
//
//        Resource platform = payloadModel.createResource(platformURIIdentifier)
//                .addProperty(RDF.type,
//                        payloadModel.createResource(EntityTypePlatform))
//                .addProperty(RDF.type,
//                        payloadModel.createResource(EntityTypeSoftwarePlatform))
//                .addProperty(hasName,
//                        platformName);
//
//        if (platformType == PlatformTypeUniversAAL) {
//            platform.addProperty(hasSemantics,
//                    payloadModel.createResource()
//                            .addProperty(RDF.type,
//                                    payloadModel.createResource(URIiiot + "Ontology"))
//                            .addProperty(hasURI, URIBaseUniversAAL));
//        }
//
//        Resource middleware = payloadModel
//                .createResource()
//                .addProperty(RDF.type,
//                        payloadModel.createResource(classMiddlewareURI))
//                .addProperty(RDF.type,
//                        payloadModel.createResource(platformType))
//                .addProperty(payloadModel.createProperty(propHasBaseEndpointURI),
//                        platformBaseURI);
//
//        payloadModel.add(platform,
//                payloadModel.createProperty(propHasMiddlewareURI),
//                middleware);
//        return payloadModel;
        return createRegisterPlatformModel(new EntityID(platformURIIdentifier), platformName, new EntityID(platformType), platformBaseURI);
    }

    /**
     * @param observationURIIdentifier URI identifier of RDF observation entity e.g. http:inter-iot.eu/obs/Observation_1
     * @param observationTime
     * @param sensorURIIdentifier      URI identifier of the RDF sensor entity that made the observation e.g. http://inter-iot.eu/dev/WeighingScale_1
     * @param observationValue         Weight value
     * @return
     */
    public static MessagePayload createWeightObservationPayload(String observationURIIdentifier, Calendar observationTime, String sensorURIIdentifier, float observationValue) {
        Model payloadModel = ModelFactory.createDefaultModel();

        Property resultTime = payloadModel.createProperty(propResultTimeURI);
        Property madeBySensor = payloadModel.createProperty(propMadeBySensorURI);
        Property observedProperty = payloadModel.createProperty(propObservedPropertyURI);
        Property phenomenonTime = payloadModel.createProperty(propPhenomenonTimeURI);
        Property hasResult = payloadModel.createProperty(propHasResultURI);
        Property inXSDDateTimeStamp = payloadModel.createProperty(propInXSDDateTimeURI);

        Property hasUnit = payloadModel.createProperty(propHasUnitURI);
        Property hasValue = payloadModel.createProperty(propHasValueURI);

        Resource observableWeight = payloadModel.createResource()
                .addProperty(RDF.type,
                        payloadModel.createResource(classObservablePropertyURI))
                .addProperty(RDF.type,
                        payloadModel.createResource(classMassURI));

        Resource timeInstant = payloadModel.createResource()
                .addProperty(RDF.type,
                        payloadModel.createResource(classInstantURI))
                .addProperty(inXSDDateTimeStamp,
                        DatatypeConverter.printDateTime(observationTime));

        Resource result = payloadModel.createResource()
                .addProperty(RDF.type,
                        payloadModel.createResource(classResultURI))
                .addProperty(hasUnit,
                        payloadModel.createResource(instKilogramURI))
                .addProperty(hasValue,
                        String.valueOf(observationValue));

        Resource device = payloadModel.createResource(sensorURIIdentifier)
                .addProperty(RDF.type,
                        payloadModel.createResource(EntityTypeDevice))
                .addProperty(RDF.type,
                        payloadModel.createResource(EntityTypeSensor))
                .addProperty(RDF.type,
                        payloadModel.createResource(URIBaseUniversAAL + "PersonalHealthDevice.owl#WeighingScale"));

        Resource observation = payloadModel.createResource(observationURIIdentifier)
                .addProperty(RDF.type,
                        payloadModel.createResource(EntityTypeObservation))
                .addProperty(resultTime,
                        DatatypeConverter.printDateTime(observationTime))
                .addProperty(madeBySensor,
                        device)
                .addProperty(observedProperty,
                        observableWeight)
                .addProperty(phenomenonTime,
                        timeInstant)
                .addProperty(hasResult,
                        result);

        return new MessagePayload(payloadModel);
    }

    public static MessagePayload createSimpleWeighingScaleDevicePayload(String deviceURIIdentifier) {
        Model payloadModel = ModelFactory.createDefaultModel();

        payloadModel.createResource(deviceURIIdentifier)
                .addProperty(RDF.type,
                        payloadModel.createResource(EntityTypeDevice))
                .addProperty(RDF.type,
                        payloadModel.createResource(URIsosa + "Sensor"))
                .addProperty(RDF.type,
                        payloadModel.createResource(URIBaseUniversAAL + "PersonalHealthDevice.owl#WeighingScale"));

        return new MessagePayload(payloadModel);
    }

    public static void addDeviceToPayload(MessagePayload payload, String deviceURIIdentifier) {
        Model payloadModel = payload.getJenaModel();

        payloadModel.createResource(deviceURIIdentifier)
                .addProperty(RDF.type,
                        payloadModel.createResource(EntityTypeDevice));
//                .addProperty(RDF.type,
//                        payloadModel.createResource(URIsosa + "Sensor"))
//                .addProperty(RDF.type,
//                        payloadModel.createResource(URIBaseUniversAAL + "PersonalHealthDevice.owl#WeighingScale"));
    }

    public static void addDeviceToPayload(MessagePayload payload, String deviceURIIdentifier, String name, String[] measuring, String platformURIIdentifier) {
        Model payloadModel = payload.getJenaModel();

        Property hasName = payloadModel.createProperty(propHasNameURI);
        Property isHostedBy = payloadModel.createProperty(propIsHostedByURI);

        Resource device = payloadModel.createResource(deviceURIIdentifier);

        device.addProperty(RDF.type, payloadModel.createResource(EntityTypeDevice));
        device.addProperty(hasName, name);
        device.addProperty(isHostedBy, payloadModel.createResource(platformURIIdentifier));

        MessagePayload p = new MessagePayload();

        for (String meas : measuring) {
            if (meas.equals("Position")) {
                device.addProperty(RDF.type, payloadModel.createResource(URImedex + "GPS"));
            } else if (meas.equals("Temperature")) {
                device.addProperty(RDF.type, payloadModel.createResource(URImedex + "Thermometer"));
            } else if (meas.equals("Humidity")) {
                device.addProperty(RDF.type, payloadModel.createResource(URImedex + "Hygrometer"));
            } else if (meas.equals("Weight")) {
                device.addProperty(RDF.type, payloadModel.createResource(URIuAALPersonalHealthDevice + "WeighingScale"));
            } else if (meas.equals("Blood Pressure")) {
                device.addProperty(RDF.type, payloadModel.createResource(URIuAALPersonalHealthDevice + "BloodPressureSensor"));
            } else if (meas.equals("Heart Rate")) {
                device.addProperty(RDF.type, payloadModel.createResource(URIuAALPersonalHealthDevice + "HeartRateSensor"));
            }
        }
    }

    public static Set<String> getDevicePlatformFromPayload(EntityID deviceID, MessagePayload payload) {
        Model payloadModel = payload.getJenaModel();
        Set<String> platforms = new HashSet<>();
        Property isHostedBy = payloadModel.createProperty(propIsHostedByURI);
        StmtIterator stmtIt = payloadModel.listStatements(new SimpleSelector(deviceID.getJenaResource(), isHostedBy, (RDFNode) null));
        while (stmtIt.hasNext()) {
            RDFNode node = stmtIt.next().getObject();
            if (node.isResource()) {
                platforms.add(node.asResource().getURI());
            }
        }
        return platforms;
    }

    public static Set<String> getDeviceNameFromPayload(EntityID deviceID, MessagePayload payload) {
        Model payloadModel = payload.getJenaModel();
        Set<String> names = new HashSet<>();
        Property hasName = payloadModel.createProperty(propHasNameURI);
        StmtIterator stmtIt = payloadModel.listStatements(new SimpleSelector(deviceID.getJenaResource(), hasName, (RDFNode) null));
        while (stmtIt.hasNext()) {
            RDFNode node = stmtIt.next().getObject();
            if (node.isLiteral()) {
                names.add(node.asLiteral().getValue().toString());
            } else {
                names.add(node.toString());
            }
        }
        return names;
    }

    public static Optional<String> getDeviceIdFromPayload(EntityID deviceID, MessagePayload payload) {
        if (deviceID.getJenaResource().isResource()) {
            if (deviceID.getJenaResource().isAnon()) {
                return Optional.of(deviceID.toString());
            }
            String id = deviceID.toString();

            if (id.contains("#")) {
                return Optional.of(id.substring(id.lastIndexOf('#') + 1));
            }

            if (id.contains("/")) {
                return Optional.of(id.substring(id.lastIndexOf('/') + 1));
            }

            return Optional.of(id);
        }
        return Optional.empty();
    }

    public static Set<String> getDeviceMeasuringFromPayload(EntityID deviceID, MessagePayload payload) {
        Model payloadModel = payload.getJenaModel();
        Set<String> measuring = new HashSet<>();
        NodeIterator nodeIt = payloadModel.listObjectsOfProperty(deviceID.getJenaResource(), RDF.type);

        if (payloadModel.contains(deviceID.getJenaResource(), RDF.type, payloadModel.createResource(URImedex + "GPS"))) {
            measuring.add("Position");
        } else if (payloadModel.contains(deviceID.getJenaResource(), RDF.type, payloadModel.createResource(URImedex + "Thermometer"))) {
            measuring.add("Temperature");
        } else if (payloadModel.contains(deviceID.getJenaResource(), RDF.type, payloadModel.createResource(URImedex + "Hygrometer"))) {
            measuring.add("Hygrometer");
        } else if (payloadModel.contains(deviceID.getJenaResource(), RDF.type, payloadModel.createResource(URIuAALPersonalHealthDevice + "WeighingScale"))) {
            measuring.add("Weight");
        } else if (payloadModel.contains(deviceID.getJenaResource(), RDF.type, payloadModel.createResource(URIuAALPersonalHealthDevice + "BloodPressureSensor"))) {
            measuring.add("Blood Pressure");
        } else if (payloadModel.contains(deviceID.getJenaResource(), RDF.type, payloadModel.createResource(URIuAALPersonalHealthDevice + "HeartRateSensor"))) {
            measuring.add("Heart Rate");
        }
        return measuring;
    }


    public static void addPlatformToPayload(MessagePayload payload, String platformURIIdentifier) {
        Model payloadModel = payload.getJenaModel();

        payloadModel.createResource(platformURIIdentifier)
                .addProperty(RDF.type,
                        payloadModel.createResource(EntityTypePlatform));
    }

    /**
     * @param payload
     * @param entityType EntityTypeDevice, EntityTypePlatform or EntityTypeObservation (static string from {@link INTERMWDemoUtils} class)
     * @return
     */
    public static Set<String> getEntityIDsFromPayload(MessagePayload payload, String entityType) {
        Model model = payload.getJenaModel();
        return model.listStatements(
                new SimpleSelector(null,
                        RDF.type,
                        model.createResource(entityType)))
                .toSet()
                .stream()
                .map(x -> x.getSubject().toString())
                .collect(Collectors.toSet());
    }

    /**
     * @param payload
     * @param entityType EntityTypeDevice, EntityTypePlatform or EntityTypeObservation (static string from {@link INTERMWDemoUtils} class)
     * @return
     */
    public static Set<EntityID> getEntityIDsFromPayloadAsEntityIDSet(MessagePayload payload, String entityType) {
        Model model = payload.getJenaModel();
        return model.listStatements(
                new SimpleSelector(null,
                        RDF.type,
                        model.createResource(entityType)))
                .toSet()
                .stream()
                .map(x -> new EntityID(x.getSubject().toString()))
                .collect(Collectors.toSet());
    }

    /**
     * @param payload
     * @param platformID Platform RDF entity ID
     * @return
     */
    public static Set<String> getPlatformNameFromPayload(MessagePayload payload, String platformID) {
        Model model = payload.getJenaModel();
        return model.listStatements(
                new SimpleSelector(model.createResource(platformID),
                        model.createProperty(propHasNameURI),
                        (Literal) null))
                .toSet()
                .stream()
                .map(x -> x.getObject().asLiteral().getValue().toString())
                .collect(Collectors.toSet());
    }

    public static Set<String> getPlatformBaseURIFromPayload(MessagePayload payload, String platformID) {
        Model model = payload.getJenaModel();

        return model.listObjectsOfProperty(
                model.createResource(platformID),
                model.createProperty(propHasMiddlewareURI))
                .toSet().stream().flatMap(x -> model.listObjectsOfProperty(
                        x.asResource(),
                        model.createProperty(propHasBaseEndpointURI)).toSet().stream()
                ).map(x -> x.toString()).collect(Collectors.toSet());
    }

    public static Set<String> getMiddlewareTypesFromPayload(MessagePayload payload, String platformID) {
        Model model = payload.getJenaModel();
        return model.listObjectsOfProperty(
                model.createResource(platformID),
                model.createProperty(propHasMiddlewareURI))
                .toSet().stream().flatMap(x -> model.listObjectsOfProperty(
                        x.asResource(),
                        RDF.type).toSet().stream()
                ).map(x -> x.toString()).collect(Collectors.toSet());
    }

    /**
     * Does the same as getMiddlewareTypesFromPayload, but removes some types from the resulting set.
     * Those types are GOIoTP#Middleware, GOIoTP#Platform
     *
     * @param payload
     * @param platformID
     * @return
     */
    public static Set<String> getMiddlewareTypesFromPayloadStripped(MessagePayload payload, String platformID) {
        Model model = payload.getJenaModel();
        Set<String> sset = model.listObjectsOfProperty(
                model.createResource(platformID),
                model.createProperty(propHasMiddlewareURI))
                .toSet().stream().flatMap(x -> model.listObjectsOfProperty(
                        x.asResource(),
                        RDF.type).toSet().stream()
                ).map(x -> x.toString()).collect(Collectors.toSet());
        sset.remove(URIiiot + "Platform");
        sset.remove(URIiiot + "Middleware");
        return sset;
    }

    public static Set<Calendar> getObservationTimeFromPayload(MessagePayload payload, String observationID) {
        Model model = payload.getJenaModel();
        return model.listObjectsOfProperty(
                model.createResource(observationID),
                model.createProperty(propResultTimeURI))
                .toSet().stream().map(
                        x ->
                                DatatypeConverter.parseDateTime(x.asLiteral().getValue().toString()))
                .collect(Collectors.toSet());
    }

    public static Set<String> getObservablePropertyTypeFromPayload(MessagePayload payload, String observationID) {
        Model model = payload.getJenaModel();
        return model.listObjectsOfProperty(
                model.createResource(observationID),
                model.createProperty(propObservedPropertyURI))
                .toSet().stream().flatMap(
                        x -> model.listObjectsOfProperty(
                                x.asResource(),
                                RDF.type
                        ).toSet().stream().map(y -> y.toString())
                ).collect(Collectors.toSet());
    }

    public static Set<String> getObservationResultValueFromPayload(MessagePayload payload, String observationID) {
        Model model = payload.getJenaModel();
        return model.listObjectsOfProperty(
                model.createResource(observationID),
                model.createProperty(propHasResultURI))
                .toSet().stream().flatMap(
                        x -> model.listObjectsOfProperty(
                                x.asResource(),
                                model.createProperty(propHasValueURI)
                        ).toSet().stream().map(y -> y.toString())
                ).collect(Collectors.toSet());
    }

    public static Set<String> getObservationResultUnitFromPayload(MessagePayload payload, String observationID) {
        Model model = payload.getJenaModel();
        return model.listObjectsOfProperty(
                model.createResource(observationID),
                model.createProperty(propHasResultURI))
                .toSet().stream().flatMap(
                        x -> model.listObjectsOfProperty(
                                x.asResource(),
                                model.createProperty(propHasUnitURI)
                        ).toSet().stream().map(y -> y.toString())
                ).collect(Collectors.toSet());
    }

    /**
     * Returns IDs of the Devices that made the observation
     *
     * @param payload
     * @param observationID
     * @return
     */
    public static Set<String> getObservationDeviceFromPayload(MessagePayload payload, String observationID) {
        Model model = payload.getJenaModel();
        return model.listObjectsOfProperty(
                model.createResource(observationID),
                model.createProperty(propMadeBySensorURI))
                .toSet().stream().map(x -> x.toString())
                .collect(Collectors.toSet());
    }

    public static Set<String> getEntityTypesFromPayload(MessagePayload payload, String entityID) {
        Model model = payload.getJenaModel();
        return model.listObjectsOfProperty(
                model.createResource(entityID),
                RDF.type)
                .toSet().stream().map(x -> x.toString())
                .collect(Collectors.toSet());
    }

    /**
     * {
     * "id": "Scale1",
     * "type": "WeightScale",      <-------- Arbitrary
     * "weight": {                 <-------- Attribute to represent is configurable on the widget, so it could be changed to “mass”, for instance
     * "value": 68.1,            <-------- Value to be represented on the panel widget
     * "type": "Float",          <-------- Not processed
     * "metadata": {
     * "unit": {
     * "value": “ºC”,        <-------- Will be appended on the panel as plain text
     * "type": "Text"
     * },
     * "irrelevantAttribute2": {  <------- This will be disregarded
     * "value": 3.141,           <------- This will be disregarded
     * "type": "Float",          <------- This will be disregarded
     * "metadata": {}            <------- Metadata can be empty
     * }
     * }
     * }
     *
     * @param observationPayload
     * @return
     */
    public static String getFIWAREJSON(MessagePayload observationPayload) throws MessageException {
        Set<String> entities = getEntityIDsFromPayload(observationPayload, EntityTypeObservation);
        if (entities.isEmpty())
            throw new PayloadException("No entities of type observation found in the Payload");
        String observationId = entities.iterator().next();

        String deviceId = "";
        Set<String> devices = getObservationDeviceFromPayload(observationPayload, observationId);
        if (!devices.isEmpty()) deviceId = devices.iterator().next();

        String deviceType = "WeightScale";
        if (deviceId != "") {
            Set<String> devTypes = getEntityTypesFromPayload(observationPayload, deviceId);
            devTypes.remove(EntityTypeDevice);
            devTypes.remove(EntityTypeSensor);
            if (!devTypes.isEmpty())
                deviceType = devTypes.iterator().next();
        }

        String obsType = "";
        Set<String> obsTypes = getObservablePropertyTypeFromPayload(observationPayload, observationId);
        obsTypes.remove(classObservablePropertyURI);
        if (obsTypes.isEmpty()) {
            obsType = classObservablePropertyURI;
        } else {
            obsType = obsTypes.iterator().next();
        }

        //Change from Inter-IoT model to the model used in JSON
        if (obsType == classMassURI) {
            obsType = "weight";
        } else {
            obsType = "unknownAttribute";
        }

        String obsValue = "";
        String obsValueType = "Text";
        String obsValueEscaped = "";
        Set<String> obsValues = getObservationResultValueFromPayload(observationPayload, observationId);
        if (!obsValues.isEmpty()) {
            obsValue = obsValues.iterator().next();
            try {
                Float.parseFloat(obsValue);
                obsValueType = "Float";
//                obsValueEscaped = "\"" + obsValue + "\"";
                obsValueEscaped = obsValue;
            } catch (NumberFormatException e) {
                //not a float
                obsValueEscaped = "\"" + EscapeStr.stringEsc(obsValue) + "\"";
            }
        }

        String obsUnit = "unknown";
        Set<String> obsUnits = getObservationResultUnitFromPayload(observationPayload, observationId);
        if (!obsUnits.isEmpty()) {
            obsUnit = obsUnits.iterator().next();
        }

        return String.join("\n"
                , "{"
                , "\"id\": " + "\"" + EscapeStr.stringEsc(deviceId) + "\"" + ","
                , "\"type\": " + "\"" + EscapeStr.stringEsc(deviceType) + "\"" + ","
                , "\"" + EscapeStr.stringEsc(obsType) + "\": " + "{"
                , "     \"value\": " + obsValueEscaped + ","
                , "     \"type\":" + "\"" + EscapeStr.stringEsc(obsValueType) + "\"" + ","
                , "     \"metadata\": " + "{"
                , "         \"unit\": " + "{"
                , "              \"value\": " + "\"" + EscapeStr.stringEsc(obsUnit) + "\"" + ","
                , "              \"type\": " + "\"Text\""
                , "               },"
                , "     \"irrelevantAttribute2\": " + "{"
                , "              \"value\": " + "3.141" + ","
                , "              \"type\": " + "\"Float\"" + ","
                , "               \"metadata\": " + "{}"
                , "               }"
                , "      }"
                , "}"
        );
    }

    /**
     * Returns the first element of a set, if it exists
     *
     * @param strings
     * @return
     */
    public static Optional<String> getFirstString(Set<String> strings) {
        return Optional.of(strings.iterator().next());
    }

    /**
     * Returns the first element of a set, if it exists
     *
     * @param calendars
     * @return
     */
    public static Optional<Calendar> getFirstCalendar(Set<Calendar> calendars) {
        return Optional.of(calendars.iterator().next());
    }

    /**
     * Workaround to get an old Thing object from a payload.
     * TODO Improve Thing to support devicetype
     * TODO Improve this to support miltiple observation
     *
     * @param observationPayload
     * @return
     * @throws MessageException
     */
    public static String getAttrTypeToUpdateFromPayload(MessagePayload observationPayload) throws MessageException {

        //Forgive me
        return "Text";

    }

    public static String getAttrValueToUpdateFromPayload(MessagePayload observationPayload) throws MessageException {

        Set<String> entities = getEntityIDsFromPayload(observationPayload, EntityTypeObservation);
        if (entities.isEmpty())
            throw new PayloadException("No entities of type observation found in the Payload");
        String observationId = entities.iterator().next();

        String obsValue = "";
        Set<String> obsValues = getObservationResultValueFromPayload(observationPayload, observationId);
        if (!obsValues.isEmpty()) {
            obsValue = obsValues.iterator().next();
        }


        return obsValue;
    }

    public static String getAttrKeyToUpdateFromPayload(MessagePayload observationPayload) throws MessageException {

        Set<String> entities = getEntityIDsFromPayload(observationPayload, EntityTypeObservation);
        if (entities.isEmpty())
            throw new PayloadException("No entities of type observation found in the Payload");
        String observationId = entities.iterator().next();

        String obsType = "";
        Set<String> obsTypes = getObservablePropertyTypeFromPayload(observationPayload, observationId);
        obsTypes.remove(classObservablePropertyURI);
        if (obsTypes.isEmpty()) {
            obsType = classObservablePropertyURI;
        } else {
            obsType = obsTypes.iterator().next();
        }

        //Change from Inter-IoT model to the model used in JSON
        if (obsType == classMassURI) {
            obsType = "weight";
        }

        return obsType;
    }


    public static Message createNewQueryMessage(String queryString) {
        Message m = new Message();
        m.getMetadata().setMessageType(URIManagerMessageMetadata.MessageTypesEnum.QUERY);
        m.getMetadata().asQueryMetadata().setQueryString(queryString);
        return m;
    }


//	
//    Resource observation = payloadModel.createResource(observationURIIdentifier)
//            .addProperty(RDF.type,
//                    payloadModel.createResource(classObservationURI))
//            .addProperty(resultTime,
//                    DatatypeConverter.printDateTime(observationTime))
//            .addProperty(madeBySensor,
//                    payloadModel.createResource(sensorURIIdentifier))
//            .addProperty(observedProperty,
//                    observableWeight)
//            .addProperty(phenomenonTime,
//                    timeInstant);
}
