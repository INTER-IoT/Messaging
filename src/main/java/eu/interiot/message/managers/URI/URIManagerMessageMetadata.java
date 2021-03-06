package eu.interiot.message.managers.URI;

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

public interface URIManagerMessageMetadata extends URIManager {

    enum MessageTypesEnum {
        //General types

        META("meta"),

        /**
         * The UNRECOGNIZED type is used by the Java enum, when an RDF message type is encountered,
         * in the message metadata, that is not in this Java enum. This means that there is no enum element
         * that corresponds to that RDF type.
         * <p>
         * In other words, it is used by the messaging library to say that the message type is not any of the predefined ones.
         */
        UNRECOGNIZED("Unrecognized"),
        RESPONSE("Response"),

        //Old types
//    DEVICE_REGISTRATION("DeviceRegistration"),
//    PLATFORM_REGISTRATION("PlatformRegistration"),
//
//    DEVICE_OBSERVATION("DeviceObservation"),
//    DEVICE_ACTUATION("DeviceActuation"),
//
//    DEVICE_INFORMATION("DeviceInformation"),
//    PLATFORM_INFORMATION("PlatformInformation"),
//
//    SUBSCRUPTION_REQUEST("SubscriptionRequest"),
//    OBSERVATION_QUERY("ObservationQuery"),

        //New types
        SYS_INIT("Sys_init"),

        CLIENT_REGISTER("Client_register"),
        CLIENT_UNREGISTER("Client_unregister"),

        SUBSCRIBE("Subscribe"),
        UNSUBSCRIBE("Unsubscribe"),

        VIRTUAL_SUBSCRIBE("Virtual_subscribe"),
        VIRTUAL_UNSUBSCRIBE("Virtual_unsubscribe"),

        //Device registry methods
        LIST_DEVICES("Discovery_List"),
        //Add device to registry
        DEVICE_ADD_OR_UPDATE("Device_Add"),
        //Remove device from registry
        DEVICE_REMOVE("Device_Remove"),
        //Delete all information about devices from a platform and add new list of deices from the payload
        //IMPORTANT Need to verify if the sender actually owns the devices that are to be added or removed
        DEVICE_REGISTRY_INITIALIZE("Device_Init"),

        //Query is a message querying a platform about a specific device
        QUERY("Query"),
        //Discovery contains SPARQL queries about Devices to Parliament
        DEVICE_DISCOVERY_QUERY("Device_discovery_query"),

        //A message to a bridge instructing it to create a new device on its platform
        PLATFORM_CREATE_DEVICE("Platform_create_Device"),
        PLATFORM_UPDATE_DEVICE("Platform_update_Device"),
        PLATFORM_DELETE_DEVICE("Platform_delete_Device"),

        //TODO: The meaning of message types below is not clear. Make good documentation, or remove these types.
//        THING_REGISTER("Thing_register"),
//        THING_UNREGISTER("Thing_unregister"),
//        THING_UPDATE("Thing_update"),

        PLATFORM_REGISTER("Platform_register"),
        PLATFORM_UNREGISTER("Platform_unregister"),
        PLATFORM_UPDATE("Platform_update"),
        PLATFORM_DISCOVERY_QUERY("Platform_discovery_query"),

        //A request to INTER-MW to get a message with supported platform types
        LIST_SUPPORTED_PLATFORM_TYPES("List_supported_platform_types"),

        OBSERVATION("Observation"),
        ACTUATION("Actuation"),

        ERROR("Error");

        private static final String URI_BASE = MESSAGEMETADATA.MessageBase;

        private final String name;

        MessageTypesEnum(String name) {
            this.name = name;
        }

        public static MessageTypesEnum fromString(String s) {
            for (MessageTypesEnum types : MessageTypesEnum.values()) {
                if (types.toString().equals(s)) {
                    return types;
                }
            }
            return UNRECOGNIZED;
        }

        @Override
        public String toString() {
            return URI_BASE + name;
        }
    }

    interface PREFIX extends URIManager.PREFIX {
        String InterIoTMsg = BASE.Message;
    }

    interface BASE extends URIManager.BASE {
        String Message = INTERIoT + "message/";

        interface INSTANCE extends URIManager.BASE.INSTANCE {
            String Metadata = BASE.Message + "meta/";
        }
    }

    interface TYPES {
        String Metadata = BASE.Message + "meta";
    }

    interface MESSAGEMETADATA {
        /*
        Action, conversationID, Timestamp, messageID
        +   originating platform, status
        +   list of target platforms
        +   originating platform, status
        +   target platform
        +   status
        +   error code, error description, copy of original message
        */

        String MessageBase = BASE.Message;

        String MetadataType = TYPES.Metadata;
//        String ChannelId = BASE.Message + "channelId";
        //public static final String PplatformId = Message + "platformId";

        String Query = BASE.Message + "query";

        String ConversationId = BASE.Message + "conversationID";
        String PreviousConversationId = BASE.Message + "previousConversationID";

        String DateTimeStamp = BASE.Message + "dateTimeStamp";

        //Action is called "type" now
//    public static final String Action = Message + "action";
        String MessageID = BASE.Message + "messageID";

        String Status = BASE.Message + "status";
        String ClientId = BASE.Message + "clientID";
        String ClientCallbackURL = BASE.Message + "clientCallbackURL";

        String SenderPlatformId = BASE.Message + "SenderPlatformId";
        String ReceiverPlatformId = BASE.Message + "ReceiverPlatformId";

        String ErrorCategory = BASE.Message + "errCategory";
        String ErrorIdentifier = BASE.Message + "errID";
        String ErrorDescription = BASE.Message + "errDesc";
        String ErrorOriginalMessage = BASE.Message + "errOriginalMsg";
        String ErrorStackTrace = BASE.Message + "errStackTrace";

        String SubscriptionId = BASE.Message + "subscriptionID";

        String VirtualDeviceId = BASE.Message + "virtualDeviceID";
    }
}