package eu.interiot.message.utils.intermw;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.Message;
import eu.interiot.message.MessagePayload;
import eu.interiot.message.managers.ID.IDManagerGOIoTP;
import eu.interiot.message.managers.ID.IDManagerINTERMW;

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

public class INTERMWUtils {

    /**
     * Extracts a set of types for any entity, that is also at least of type <code>originalType</code> (given in the parameter).
     * <p>
     * E.g. Given an <code>originalType</code> A and entities 1) a of types A, B; 2) entity b of type C; 3) entity c of type A,D; This method
     * will return the set [A, B, D].
     *
     * @param m                   A <code>Message</code> with the relevant <code>Payload</code> from which any information will be extracted
     * @param originalType        A type of entity
     * @param includeOriginalType If true, the return set will include the <code>originalType</code> parameter (default false)
     * @return The aggregated set of all types of entities of type <code>originalType</code>.
     */
    public static Set<EntityID> getAggregatedTypesFromPayload(Message m, EntityID originalType, boolean includeOriginalType) {
        return getAggregatedTypesFromPayload(m.getPayload(), originalType, includeOriginalType);
    }

    /**
     * Extracts a set of types for any entity, that is also at least of type <code>originalType</code> (given in the parameter).
     * <p>
     * E.g. Given an <code>originalType</code> A and entities 1) a of types A, B; 2) entity b of type C; 3) entity c of type A,D; This method
     * will return the set [B, D].
     *
     * @param m            A <code>Message</code> with the relevant <code>Payload</code> from which any information will be extracted
     * @param originalType A type of entity
     * @return The aggregated set of all types of entities of type <code>originalType</code>, without <code>originalType</code> itself.
     */
    public static Set<EntityID> getAggregatedTypesFromPayload(Message m, EntityID originalType) {
        return getAggregatedTypesFromPayload(m, originalType, false);
    }

    /**
     * Extracts a set of types for any entity, that is also at least of type <code>originalType</code> (given in the parameter).
     * <p>
     * E.g. Given an <code>originalType</code> A and entities 1) a of types A, B; 2) entity b of type C; 3) entity c of type A,D; This method
     * will return the set [B, D].
     *
     * @param payload      A relevant <code>MessagePayload</code> from which any information will be extracted
     * @param originalType A type of entity
     * @return The aggregated set of all types of entities of type <code>originalType</code>, without <code>originalType</code> itself.
     */
    public static Set<EntityID> getAggregatedTypesFromPayload(MessagePayload payload, EntityID originalType) {
        return getAggregatedTypesFromPayload(payload, originalType, false);
    }

    /**
     * Extracts a set of types for any entity, that is also at least of type <code>originalType</code> (given in the parameter).
     * <p>
     * E.g. Given an <code>originalType</code> A and entities 1) a of types A, B; 2) entity b of type C; 3) entity c of type A,D; This method
     * will return the set [A, B, D].
     *
     * @param payload             A relevant <code>MessagePayload</code> from which any information will be extracted
     * @param originalType        A type of entity
     * @param includeOriginalType If true, the return set will include the <code>originalType</code> parameter (default false)
     * @return The aggregated set of all types of entities of type <code>originalType</code>.
     */
    public static Set<EntityID> getAggregatedTypesFromPayload(MessagePayload payload, EntityID originalType, boolean includeOriginalType) {
        Set<EntityID> result = payload.getAllTypedEntities(originalType).stream()
                .flatMap(platformID -> payload.getEntityTypes(platformID).stream())
                .collect(Collectors.toSet());

        if (!includeOriginalType) result.remove(originalType);

        return result;
    }

    /**
     * Extracts aggregated types for original type <code>IDManagerGOIoTP.TYPES.Platform</code>
     * See {@link #getAggregatedTypesFromPayload(MessagePayload, EntityID)}
     *
     * @param m A <code>Message</code> with the relevant <code>Payload</code> from which any information will be extracted
     * @return The aggregated set of all types of entities of type <code>IDManagerGOIoTP.TYPES.Platform</code>, without <code>IDManagerGOIoTP.TYPES.Platform</code> itself.
     */
    public static Set<EntityID> getAggregatedPlatformTypesFromPayload(Message m) {
        return getAggregatedPlatformTypesFromPayload(m.getPayload());
    }

    /**
     * Extracts aggregated types for original type <code>IDManagerGOIoTP.TYPES.Platform</code>
     * See {@link #getAggregatedTypesFromPayload(MessagePayload, EntityID)}
     *
     * @param payload A relevant <code>MessagePayload</code> from which any information will be extracted
     * @return The aggregated set of all types of entities of type <code>IDManagerGOIoTP.TYPES.Platform</code>, without <code>IDManagerGOIoTP.TYPES.Platform</code> itself.
     */
    public static Set<EntityID> getAggregatedPlatformTypesFromPayload(MessagePayload payload) {
        return getAggregatedTypesFromPayload(payload, IDManagerGOIoTP.TYPES.Platform);
    }

    /**
     * Assigns an IPSM configuration for a bridge to a platform
     *
     * @param platformID
     * @param config
     * @param payload
     * @return ID of the IPSMBridgeSemantics entity to which the {@code config} information is attached
     */
    public static EntityID addIPSMBridgeConfigToPlatform(EntityID platformID, IPSMBridgeConfig config, MessagePayload payload) {
        EntityID IPSMBridgeSemanticsEntityID = config.putIntoPayload(payload);
        payload.addObjectPropertyAssertionToEntity(platformID, IDManagerGOIoTP.PROPERTIES.OBJECT.hasSemantics, IPSMBridgeSemanticsEntityID);
        return IPSMBridgeSemanticsEntityID;
    }

    /**
     * Extracts an IPSM Channel config for a bridge, assigned to a platform
     *
     * @param platformID
     * @param payload
     * @return IPSM Bridge config, or {@code Optional.empty}, if the {@code platformID} has no iiot:hasSemantics
     * property attached to an individual of type mw:IPSMBridgeSemantics
     */
    public static Optional<IPSMBridgeConfig> getIPSMBridgeConfigFromPlatform(EntityID platformID, MessagePayload payload) {
        Optional<EntityID> IPSMBridgeSemanticsEntityID = payload.getAllObjectPropertyAssertionsForEntity(platformID, IDManagerGOIoTP.PROPERTIES.OBJECT.hasSemantics).stream()
                .filter(
                        e -> {
                            return payload.getEntityTypes(e).contains(IDManagerINTERMW.TYPES.IPSMBridgeSemantics);
                        }
                ).findFirst();

        if (IPSMBridgeSemanticsEntityID.isPresent()) {
            return Optional.of(IPSMBridgeConfig.getFromPayload(IPSMBridgeSemanticsEntityID.get(), payload));
        } else {
            return Optional.empty();
        }
    }
}
