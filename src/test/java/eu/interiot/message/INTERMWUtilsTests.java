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

package eu.interiot.message;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.managers.ID.IDManagerGOIoTP;
import eu.interiot.message.utils.intermw.INTERMWUtils;
import eu.interiot.message.utils.intermw.IPSMBridgeConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class INTERMWUtilsTests extends TestResources {

    @Test
    @DisplayName("INTER-MW Util Aggregated types ╯°□°）╯")
    public void INTERMWUtils() {
        Message m = new Message();

//            System.out.println(m.serializeToJSONLD());
//
//            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//
//            RDFDataMgr.write(outStream, m.getPayload().getJenaModel(), Lang.N3);
//
//            String payloadString = outStream.toString();
//
//            System.out.println(payloadString);

        m.getPayloadAsGOIoTPPayload().asPlatformPayload().createPlatform(platformID_1);
        m.getPayloadAsGOIoTPPayload().asPlatformPayload().createPlatform(platformID_2);
        m.getPayloadAsGOIoTPPayload().asPlatformPayload().createPlatform(platformID_3);
        m.getPayloadAsGOIoTPPayload().asPlatformPayload().createPlatform(platformID_4);

        m.getPayloadAsGOIoTPPayload().addTypeToEntity(platformID_1, typeID_1);
        m.getPayloadAsGOIoTPPayload().addTypeToEntity(platformID_2, typeID_1);
        m.getPayloadAsGOIoTPPayload().addTypeToEntity(platformID_2, typeID_2);
        m.getPayloadAsGOIoTPPayload().addTypeToEntity(platformID_3, typeID_3);
        m.getPayloadAsGOIoTPPayload().addTypeToEntity(platformID_3, IDManagerGOIoTP.TYPES.SoftwarePlatform);
        m.getPayloadAsGOIoTPPayload().addTypeToEntity(platformID_3, IDManagerGOIoTP.TYPES.Platform);

        Set<EntityID> resultSet = INTERMWUtils.getAggregatedPlatformTypesFromPayload(m);

        for (EntityID e : resultSet) {

        }

        assertAll("Aggregated types should be unique and not include sosa:Platform",
                () -> assertTrue(resultSet.contains(typeID_1)),
                () -> assertTrue(resultSet.contains(typeID_2)),
                () -> assertTrue(resultSet.contains(typeID_3)),
                () -> assertTrue(resultSet.contains(IDManagerGOIoTP.TYPES.SoftwarePlatform)),
                () -> assertFalse(resultSet.contains(IDManagerGOIoTP.TYPES.Platform)),
                () -> assertEquals(4, resultSet.size())
        );

//        System.out.println(INTERMWUtils.getAggregatedPlatformTypesFromPayload(m));
//
//        Message m2 = new Message();
//        try {
//            System.out.println(m2.serializeToJSONLD());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    @Test
    @DisplayName("INTER-MW Utils - reading IPSM Channels Bridge config from test message")
    public void readingINTERMWIPSMChannelConfig() {

        Message m = MESSAGES.platformRegisterMessage;
//        try {
//            System.out.println(m.serializeToJSONLD());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Optional<IPSMBridgeConfig> config = INTERMWUtils.getIPSMBridgeConfigFromPlatform(om2mPlatformID, m.getPayload());
        assertAll("Reading from test platform register message. Config should equal to:"
                + "\n    Downstream channel {Input alignment: {Optional[IDENTITY], Optional.empty} Output alignment: {Optional[CO-OM2M_BO], Optional[1.2partial]}}\n" +
                        "    Upstream channel {Input alignment: {Optional[OM2M_BO-CO], Optional[1.2]} Output alignment: {Optional[IDENTITY], Optional.empty}}",
                () -> assertTrue(config.get().downstreamInputAlignmentName.get().equals(IPSMBridgeConfig.IDENTITYAlignmentName)),
                () -> assertFalse(config.get().downstreamInputAlignmentVersion.isPresent()),
                () -> assertTrue(config.get().downstreamOutputAlignmentName.get().equals("CO-OM2M_BO")),
                () -> assertTrue(config.get().downstreamOutputAlignmentVersion.get().equals("1.2partial"))
        );
//        System.out.println(config);
    }

    @Test
    @DisplayName("INTER-MW Utils - setting and getting IPSM Channels Bridge config")
    public void INTERMWIPSMChannelConfig() throws IOException {
        Message m = new Message();

        Optional<IPSMBridgeConfig> config = Optional.of(new IPSMBridgeConfig(null, null, "toPlatform", "1.0",
        "fromPlatform", "2.0", "toMW", "2.0"));

        INTERMWUtils.addIPSMBridgeConfigToPlatform(platformID_1, config.get(), m.getPayload());
//        System.out.println(m.serializeToJSONLD());

        Optional<IPSMBridgeConfig> config2 = INTERMWUtils.getIPSMBridgeConfigFromPlatform(platformID_1, m.getPayload());
        assertAll("Setting and reading should return the same IPSMBridgeConfig, with the exception of null alignment name being equivalent to IDENTITY",
                () ->assertTrue(config.equals(config2))
        );
    }


}
