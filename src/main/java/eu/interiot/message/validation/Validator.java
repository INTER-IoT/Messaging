package eu.interiot.message.validation;

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


import eu.interiot.message.Message;
import eu.interiot.message.MessageMetadata;
import eu.interiot.message.MessagePayload;
import eu.interiot.message.managers.URI.URIManagerMessageMetadata.MessageTypesEnum;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileUtils;
import org.topbraid.jenax.util.JenaUtil;
import org.topbraid.shacl.util.ModelPrinter;
import org.topbraid.shacl.validation.ValidationUtil;

//import fr.inria.lille.shexjava.graph.JenaGraph;
//import fr.inria.lille.shexjava.graph.RDFGraph;
//import fr.inria.lille.shexjava.schema.Label;
//import fr.inria.lille.shexjava.schema.ShexSchema;
//import fr.inria.lille.shexjava.schema.parsing.GenParser;
//import fr.inria.lille.shexjava.validation.RecursiveValidation;
//import fr.inria.lille.shexjava.validation.RefineValidation;
//import fr.inria.lille.shexjava.validation.ValidationAlgorithm;
//import org.eclipse.rdf4j.model.IRI;
//import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

/**
 * A class with utility methods that check if a Message is proper i.e. it has valid message types, the payload contains required entities and attributes and so on.
 */
public class Validator {

    public static String validateMessage(Message message) {
        return "";
    }

    //TODO: Two validation exception types - INTER-MW assumptions (e.g. at least one IoTDevice in DEVICE_XXX message, Observations made ONLY by at least one named Sensor)
    //Platform without a base URI
    //GOIoTP model validation exception - e.g. IoTDevice with more than one location
    public static String validateMessageMetadata(MessageMetadata metadata) {
        metadata.getMessageTypes();

        //TODO: Check basic metadata - message ID, conversation, etc. (should be at most one)

        //TODO: Check, based on message types - error props, platform sender/receiver props


        //TODO: Check single sender


        //TODO: For the sake of Parliament discovery - disallow objects of some type in some payloads
        //e.g. observation in device register messages


        return "";
    }

    public static String validateMessagePayload(MessagePayload payload, MessageTypesEnum messageType) {

        Model dataModel = payload.getJenaModel();
        Model shapesModel = JenaUtil.createMemoryModel();
        shapesModel.read(Validator.class.getResourceAsStream("/shacl/test.ttl"), "urn:dummy", FileUtils.langTurtle);

        // Perform the validation of everything, using the data model
        // also as the shapes model - you may have them separated
        Resource report = ValidationUtil.validateModel(dataModel, shapesModel, true);

        // Print violations
        System.out.println(ModelPrinter.get().print(report.getModel()));


//        ClassLoader classLoader = Validator.class.getClassLoader();
//
//        try {
//            Path schemaFile = Paths.get(classLoader.getResource("shapes/datatypes.json").toURI());
//            Path dataFile = Paths.get("src", "main", "resources", "datatypes-data.ttl"); //to change with what you want
//            List<Path> importDirectories = Collections.emptyList();
//
//            // load and create the shex schema
//            System.out.println("Reading schema");
//            ShexSchema schema = GenParser.parseSchema(schemaFile, importDirectories);
//            for (Label label : schema.getRules().keySet())
//                System.out.println(label + ": " + schema.getRules().get(label));
//
//
//            System.out.println("Reading data");
//
//
//            // create the RDF graph
//            RDFGraph dataGraph = new JenaGraph(payload.getJenaModel());
//
//
//            // choose focus node and shapelabel
//            IRI focusNode = SimpleValueFactory.getInstance().createIRI("http://a.example/boolean-true"); //to change with what you want
//            Label shapeLabel = new Label(SimpleValueFactory.getInstance().createIRI("http://a.example/S-boolean")); //to change with what you want
//
//            System.out.println();
//            System.out.println("Refine validation:");
//            // create the validation algorithm
//            ValidationAlgorithm validation = new RefineValidation(schema, dataGraph);
//            //validate
//            validation.validate(focusNode, shapeLabel);
//            //check the result
//            System.out.println("Does " + focusNode + " has shape " + shapeLabel + "? " + validation.getTyping().contains(focusNode, shapeLabel));
//            // print all the typing
//            //for (Pair<Value,Label> pair:validation.getTyping().asSet())
//            //	System.out.println(pair.one+":"+pair.two);
//
//            System.out.println();
//            System.out.println("Recursive validation:");
//            validation = new RecursiveValidation(schema, dataGraph);
//            validation.validate(focusNode, shapeLabel);
//            //check the result
//            System.out.println("Does " + focusNode + " has shape " + shapeLabel + "? " + validation.getTyping().contains(focusNode, shapeLabel));
//            // print all the typing
//            //for (Pair<Value,Label> pair:validation.getTyping().asSet())
////	System.out.println(pair.two);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        return "";
    }


    public static boolean isMessageValid(Message message) {
        //TODO: Verify all individuals against the ontology with a reasoner?
        return isMessageMetadataValid(message.getMetadata()) && isMessagePayloadValid(message.getPayload());
    }

    public static boolean isMessageMetadataValid(MessageMetadata metadata) {
        return false;
    }

    public static boolean isMessagePayloadValid(MessagePayload payload) {
        return false;
    }
}
