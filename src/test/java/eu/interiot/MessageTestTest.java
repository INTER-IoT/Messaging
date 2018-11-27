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

package eu.interiot;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.Message;
import eu.interiot.message.exceptions.MessageException;
import eu.interiot.message.managers.ID.IDManagerGOIoTP;
import eu.interiot.message.utils.intermw.INTERMWUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Unit test for simple MessageDemo.
 */
class MessageTestTest {

    /**
     * Create the test case
     *
     */
    @Test
    public void MessageTest() {
//        Message message = new Message();
//        message.getPayload().addTypeToEntity(new EntityID(), IDManagerGOIoTP.TYPES.IoTDevice);
//        message.getPayload().getAllTypedEntities(IDManagerGOIoTP.TYPES.IoTDevice);
//        try {
//            System.out.println(message.serializeToJSONLD());
//            System.out.println(message);
//
//
//
//            Message m2 = new Message();
//            m2.getMetadata().setMessageType(URIManagerMessageMetadata.MessageTypesEnum.LIST_DEVICES);
//            m2.getMetadata().asPlatformMessageMetadata().setReceivingPlatformID(new EntityID("http://example.platform.org"));
//            System.out.println(m2.serializeToJSONLD());
//
//
//
//            URIManagerGOIoTP.PROPERTIES.OBJECT.observes
//
//            m2.getPayload().asGOIoTPPayload().asObservationPayload().addDataPropertyAssertionToEntity(new EntityID(), new PropertyID(), "value", XSDDatatype.XSDdateTimeStamp);
//
//
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        String s = "{\n" +
                "  \"@graph\": [\n" +
                "    {\n" +
                "      \"@graph\": [\n" +
                "        {\n" +
                "          \"@id\": \"InterIoTMsg:meta308c3987-b69e-4672-890b-3f3d6229596d\",\n" +
                "          \"@type\": [\n" +
                "            \"InterIoTMsg:meta\"\n" +
                "          ],\n" +
                "          \"InterIoTMsg:conversationID\": \"conv85e0f5d2-cf65-4d23-84b1-ff1381ae01fb\",\n" +
                "          \"InterIoTMsg:dateTimeStamp\": \"2018-07-03T10:18:19.428+01:00\",\n" +
                "          \"InterIoTMsg:messageID\": \"msg204d0405-a6da-4054-a6db-96d20c413747\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"@id\": \"InterIoTMsg:metadata\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"@graph\": [\n" +
                "        {\n" +
                "          \"@id\": \"_:b0\",\n" +
                "          \"http://hl7.org/fhir-rdf/code\": {\n" +
                "            \"@id\": \"http://snomed.info/sct/Blood_Pressure\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"@id\": \"_:b1\",\n" +
                "          \"http://hl7.org/fhir-rdf/target\": {\n" +
                "            \"@id\": \"_:b3\"\n" +
                "          },\n" +
                "          \"http://hl7.org/fhir-rdf/type\": \"has-component\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"@id\": \"_:b2\",\n" +
                "          \"http://hl7.org/fhir-rdf/target\": {\n" +
                "            \"@id\": \"_:b4\"\n" +
                "          },\n" +
                "          \"http://hl7.org/fhir-rdf/type\": \"has-component\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"@id\": \"_:b3\",\n" +
                "          \"@type\": \"http://hl7.org/fhir-rdf/Observation\",\n" +
                "          \"http://hl7.org/fhir-rdf/coding\": {\n" +
                "            \"@id\": \"_:b5\"\n" +
                "          },\n" +
                "          \"http://hl7.org/fhir-rdf/valueQuantity\": {\n" +
                "            \"@id\": \"_:b6\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"@id\": \"_:b4\",\n" +
                "          \"@type\": \"http://hl7.org/fhir-rdf/Observation\",\n" +
                "          \"http://hl7.org/fhir-rdf/coding\": {\n" +
                "            \"@id\": \"_:b7\"\n" +
                "          },\n" +
                "          \"http://hl7.org/fhir-rdf/valueQuantity\": {\n" +
                "            \"@id\": \"_:b8\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"@id\": \"_:b5\",\n" +
                "          \"http://hl7.org/fhir-rdf/code\": {\n" +
                "            \"@id\": \"http://snomed.info/sct/Systolic_Blood_Pressure\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"@id\": \"_:b6\",\n" +
                "          \"@type\": \"http://hl7.org/fhir-rdf/Quantity\",\n" +
                "          \"http://hl7.org/fhir-rdf/units\": \"mmHg\",\n" +
                "          \"http://hl7.org/fhir-rdf/value\": {\n" +
                "            \"@type\": \"http://www.w3.org/2001/XMLSchema#float\",\n" +
                "            \"@value\": \"110\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"@id\": \"_:b7\",\n" +
                "          \"http://hl7.org/fhir-rdf/code\": {\n" +
                "            \"@id\": \"http://snomed.info/sct/Diastolic_Blood_Pressure\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"@id\": \"_:b8\",\n" +
                "          \"@type\": \"http://hl7.org/fhir-rdf/Quantity\",\n" +
                "          \"http://hl7.org/fhir-rdf/units\": \"mmHg\",\n" +
                "          \"http://hl7.org/fhir-rdf/value\": {\n" +
                "            \"@type\": \"http://www.w3.org/2001/XMLSchema#float\",\n" +
                "            \"@value\": \"70\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"@id\": \"tag:BPfhir123\",\n" +
                "          \"@type\": \"http://hl7.org/fhir-rdf/Observation\",\n" +
                "          \"http://hl7.org/fhir-rdf/coding\": {\n" +
                "            \"@id\": \"_:b0\"\n" +
                "          },\n" +
                "          \"http://hl7.org/fhir-rdf/related\": [\n" +
                "            {\n" +
                "              \"@id\": \"_:b1\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"@id\": \"_:b2\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ],\n" +
                "      \"@id\": \"InterIoTMsg:payload\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"@context\": {\n" +
                "    \"InterIoTMsg\": \"http://inter-iot.eu/message/\",\n" +
                "    \"InterIoT\": \"http://inter-iot.eu/\",\n" +
                "    \"owl\": \"http://www.w3.org/2002/07/owl#\",\n" +
                "    \"rdf\": \"http://www.w3.org/1999/02/22-rdf-syntax-ns#\",\n" +
                "    \"rdfs\": \"http://www.w3.org/2000/01/rdf-schema#\",\n" +
                "    \"xsd\": \"http://www.w3.org/2001/XMLSchema#\",\n" +
                "    \"sripas\": \"http://www.inter-iot.eu/sripas#\",\n" +
                "    \"fhir\": \"http://hl7.org/fhir-rdf/\",\n" +
                "    \"sct\": \"http://snomed.info/sct/\",\n" +
                "    \"damMed\": \"http://dam.example/med#\"\n" +
                "  }\n" +
                "}";

        try {
            Message m = new Message(s);

//            System.out.println(m.serializeToJSONLD());
//
//            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//
//            RDFDataMgr.write(outStream, m.getPayload().getJenaModel(), Lang.N3);
//
//            String payloadString = outStream.toString();
//
//            System.out.println(payloadString);

            EntityID pl1 = new EntityID("http://test.org/platform1");
            EntityID pl2 = new EntityID("http://test.org/platform1");
            EntityID pl3 = new EntityID("http://test.org/platform1");
            EntityID pl4 = new EntityID("http://test.org/platform1");

            m.getPayloadAsGOIoTPPayload().asPlatformPayload().createPlatform(pl1);
            m.getPayloadAsGOIoTPPayload().asPlatformPayload().createPlatform(pl2);
            m.getPayloadAsGOIoTPPayload().asPlatformPayload().createPlatform(pl3);
            m.getPayloadAsGOIoTPPayload().asPlatformPayload().createPlatform(pl4);

            m.getPayloadAsGOIoTPPayload().addTypeToEntity(pl1, new EntityID("http://test.org/type1"));
            m.getPayloadAsGOIoTPPayload().addTypeToEntity(pl2, new EntityID("http://test.org/type1"));
            m.getPayloadAsGOIoTPPayload().addTypeToEntity(pl2, new EntityID("http://test.org/type2"));
            m.getPayloadAsGOIoTPPayload().addTypeToEntity(pl3, new EntityID("http://test.org/type3"));
            m.getPayloadAsGOIoTPPayload().addTypeToEntity(pl3, IDManagerGOIoTP.TYPES.SoftwarePlatform);
            m.getPayloadAsGOIoTPPayload().addTypeToEntity(pl3, IDManagerGOIoTP.TYPES.Platform);

//            System.out.println(INTERMWUtils.getAggregatedPlatformTypesFromPayload(m));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessageException e) {
            e.printStackTrace();
        }


    }
}
