package eu.interiot.message;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.exceptions.MessageException;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

class TestResources {

    TestResources() {
    }

    String entityIDBase = "http://test.org/entity";
    EntityID entityID_1 = new EntityID(entityIDBase + "1");
    EntityID entityID_2 = new EntityID(entityIDBase + "2");
    EntityID entityID_3 = new EntityID(entityIDBase + "3");
    EntityID entityID_4 = new EntityID(entityIDBase + "4");
    EntityID entityID_5 = new EntityID(entityIDBase + "5");

    Set<EntityID> genericEntityIDs = new HashSet<EntityID>(Arrays.asList(
            entityID_1, entityID_2, entityID_3, entityID_4, entityID_5
    ));

    String platformIDBase = "http://test.org/platform";
    EntityID platformID_1 = new EntityID(platformIDBase + "1");
    EntityID platformID_2 = new EntityID(platformIDBase + "2");
    EntityID platformID_3 = new EntityID(platformIDBase + "3");
    EntityID platformID_4 = new EntityID(platformIDBase + "4");
    EntityID platformID_5 = new EntityID(platformIDBase + "5");

    Set<EntityID> genericPlatformIDs = new HashSet<EntityID>(Arrays.asList(
            platformID_1, platformID_2, platformID_3, platformID_4, platformID_5
    ));

    String typeIDBase = "http://test.org/type";
    EntityID typeID_1 = new EntityID(typeIDBase + "1");
    EntityID typeID_2 = new EntityID(typeIDBase + "2");
    EntityID typeID_3 = new EntityID(typeIDBase + "3");
    EntityID typeID_4 = new EntityID(typeIDBase + "4");
    EntityID typeID_5 = new EntityID(typeIDBase + "5");

    Set<EntityID> genericTypeIDs = new HashSet<EntityID>(Arrays.asList(
            typeID_1, typeID_2, typeID_3, typeID_4, typeID_5
    ));

    EntityID om2mPlatformID = new EntityID("http://om2m.org/myPlatform");

    Set<EntityID> namedPlatformIDs = new HashSet<EntityID>(Arrays.asList(
            om2mPlatformID
    ));

    Set<EntityID> allTypeIDs = genericTypeIDs;
    Set<EntityID> allEntityIDs = genericEntityIDs;
    Set<EntityID> allPlatformIDs = Stream.of(genericPlatformIDs, namedPlatformIDs)
            .flatMap(s -> s.stream()).collect(Collectors.toSet());


    public MessagesContainer MESSAGES = new MessagesContainer();

    public class MessagesContainer {
        private String messagesResourcesBase = "messages/";

        public String emptyPayloadMessageString;
        public Message emptyPayloadMessage;

        public String platformRegisterMessageString;
        public Message platformRegisterMessage;

        public void test(){

        }

        MessagesContainer() {
            emptyPayloadMessageString = loadStringFromResource(messagesResourcesBase + "emptyPayloadMessage.json");
            platformRegisterMessageString = loadStringFromResource(messagesResourcesBase + "platformRegister1.1.json");
            try {
                emptyPayloadMessage = new Message(emptyPayloadMessageString);
                platformRegisterMessage = new Message(platformRegisterMessageString);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MessageException e) {
                e.printStackTrace();
            }
        }

        private String loadStringFromResource(String resourcePath) {
            ClassLoader classLoader = this.getClass().getClassLoader();
            File file = new File(classLoader.getResource(resourcePath).getFile());
            String content = null;
            try {
                content = new String(Files.readAllBytes(Paths.get(classLoader.getResource(resourcePath).toURI())));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            return content;
        }
    }

//    private String readFromInputStream(InputStream inputStream)
//            throws IOException {
//        StringBuilder resultStringBuilder = new StringBuilder();
//        try (BufferedReader br
//                     = new BufferedReader(new InputStreamReader(inputStream))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                resultStringBuilder.append(line).append("\n");
//            }
//        }
//        return resultStringBuilder.toString();
//    }
}
