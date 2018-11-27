package eu.interiot.message.utils.intermw;

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


import eu.interiot.message.ID.EntityID;
import eu.interiot.message.ID.PropertyID;
import eu.interiot.message.MessagePayload;
import eu.interiot.message.managers.ID.IDManagerGOIoTP;
import eu.interiot.message.managers.ID.IDManagerINTERMW;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Set;

/**
 * A data class for two-channel configuration of IPSM used by INTER-MW bridges
 */
public final class IPSMBridgeConfig {
    public static String IDENTITYAlignmentName = "IDENTITY";

    public final Optional<String> downstreamInputAlignmentName;
    public final Optional<String> downstreamInputAlignmentVersion;
    public final Optional<String> downstreamOutputAlignmentName;
    public final Optional<String> downstreamOutputAlignmentVersion;

    public final Optional<String> upstreamInputAlignmentName;
    public final Optional<String> upstreamInputAlignmentVersion;
    public final Optional<String> upstreamOutputAlignmentName;
    public final Optional<String> upstreamOutputAlignmentVersion;

    public IPSMBridgeConfig(@Nullable String downstreamInputAlignmentName, @Nullable String downstreamInputAlignmentVersion,
                            @Nullable String downstreamOutputAlignmentName, @Nullable String downstreamOutputAlignmentVersion,
                            @Nullable String upstreamInputAlignmentName, @Nullable String upstreamInputAlignmentVersion,
                            @Nullable String upstreamOutputAlignmentName, @Nullable String upstreamOutputAlignmentVersion
    ) {
        this.downstreamInputAlignmentName = Optional.ofNullable(downstreamInputAlignmentName);
        this.downstreamInputAlignmentVersion = Optional.ofNullable(downstreamInputAlignmentVersion);
        this.downstreamOutputAlignmentName = Optional.ofNullable(downstreamOutputAlignmentName);
        this.downstreamOutputAlignmentVersion = Optional.ofNullable(downstreamOutputAlignmentVersion);

        this.upstreamInputAlignmentName = Optional.ofNullable(upstreamInputAlignmentName);
        this.upstreamInputAlignmentVersion = Optional.ofNullable(upstreamInputAlignmentVersion);
        this.upstreamOutputAlignmentName = Optional.ofNullable(upstreamOutputAlignmentName);
        this.upstreamOutputAlignmentVersion = Optional.ofNullable(upstreamOutputAlignmentVersion);

    }

    /**
     * Attempts to construct an instance of {@code IPSMBridgeConfig} from a property-class chain in a payload.
     * The alignment names are set to "IDENTITY", if they are not present in the payload
     *
     * @param IPSMBridgeSemanticsEntityID ID of an entity of type mw:IPSMBridgeSemantics that has IPSM channels info attached to it
     * @param payload
     * @return
     */
    public static IPSMBridgeConfig getFromPayload(EntityID IPSMBridgeSemanticsEntityID, MessagePayload payload) {
        String downstreamInputAlignmentName = IDENTITYAlignmentName;
        String downstreamInputAlignmentVersion = null;
        String downstreamOutputAlignmentName = IDENTITYAlignmentName;
        String downstreamOutputAlignmentVersion = null;
        String upstreamInputAlignmentName = IDENTITYAlignmentName;
        String upstreamInputAlignmentVersion = null;
        String upstreamOutputAlignmentName = IDENTITYAlignmentName;
        String upstreamOutputAlignmentVersion = null;

        //Downstream input
        Optional<EntityID> downInputAlignment = getAlignmentEntityFromIPSMChannelConfigPropertyChain(
                IPSMBridgeSemanticsEntityID,
                IDManagerINTERMW.PROPERTIES.OBJECT.hasDownstreamChannelConfig,
                IDManagerINTERMW.PROPERTIES.OBJECT.hasInputAlignment,
                payload);

        if (downInputAlignment.isPresent()) {
            downstreamInputAlignmentName = getAlignmentName(downInputAlignment.get(), payload);
            downstreamInputAlignmentVersion = getAlignmentVersion(downInputAlignment.get(), payload);
        }

        //Downstream output
        Optional<EntityID> downOutputAlignment = getAlignmentEntityFromIPSMChannelConfigPropertyChain(
                IPSMBridgeSemanticsEntityID,
                IDManagerINTERMW.PROPERTIES.OBJECT.hasDownstreamChannelConfig,
                IDManagerINTERMW.PROPERTIES.OBJECT.hasOutputAlignment,
                payload);

        if (downOutputAlignment.isPresent()) {
            downstreamOutputAlignmentName = getAlignmentName(downOutputAlignment.get(), payload);
            downstreamOutputAlignmentVersion = getAlignmentVersion(downOutputAlignment.get(), payload);
        }

        //Upstream input
        Optional<EntityID> upInputAlignment = getAlignmentEntityFromIPSMChannelConfigPropertyChain(
                IPSMBridgeSemanticsEntityID,
                IDManagerINTERMW.PROPERTIES.OBJECT.hasUpstreamChannelConfig,
                IDManagerINTERMW.PROPERTIES.OBJECT.hasInputAlignment,
                payload);

        if (upInputAlignment.isPresent()) {
            upstreamInputAlignmentName = getAlignmentName(upInputAlignment.get(), payload);
            upstreamInputAlignmentVersion = getAlignmentVersion(upInputAlignment.get(), payload);
        }

        //Upstream output
        Optional<EntityID> upOutputAlignment = getAlignmentEntityFromIPSMChannelConfigPropertyChain(
                IPSMBridgeSemanticsEntityID,
                IDManagerINTERMW.PROPERTIES.OBJECT.hasUpstreamChannelConfig,
                IDManagerINTERMW.PROPERTIES.OBJECT.hasOutputAlignment,
                payload);

        if (upOutputAlignment.isPresent()) {
            upstreamOutputAlignmentName = getAlignmentName(upOutputAlignment.get(), payload);
            upstreamOutputAlignmentVersion = getAlignmentVersion(upOutputAlignment.get(), payload);
        }

        return new IPSMBridgeConfig(downstreamInputAlignmentName, downstreamInputAlignmentVersion,
                downstreamOutputAlignmentName, downstreamOutputAlignmentVersion,
                upstreamInputAlignmentName, upstreamInputAlignmentVersion,
                upstreamOutputAlignmentName, upstreamOutputAlignmentVersion);
    }

    private static String getAlignmentName(EntityID alignmentEntityID, MessagePayload payload) {
        Set<String> tempSetStrings = payload.getAllDataPropertyAssertionsForEntityAsStrings(alignmentEntityID, IDManagerGOIoTP.PROPERTIES.DATA.hasName);
        if (!tempSetStrings.isEmpty()) {
            return tempSetStrings.iterator().next();
        } else {
            return IDENTITYAlignmentName;
        }
    }

    private static String getAlignmentVersion(EntityID alignmentEntityID, MessagePayload payload) {
        Set<String> tempSetStrings = payload.getAllDataPropertyAssertionsForEntityAsStrings(alignmentEntityID, IDManagerGOIoTP.PROPERTIES.DATA.hasVersion);
        if (!tempSetStrings.isEmpty()) {
            return tempSetStrings.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * @param IPSMBridgeSemanticsEntityID
     * @param updownChannelProperty
     * @param inoutputAlignmentProperty
     * @param payload
     * @return
     */
    private static Optional<EntityID> getAlignmentEntityFromIPSMChannelConfigPropertyChain(
            EntityID IPSMBridgeSemanticsEntityID,
            PropertyID updownChannelProperty,
            PropertyID inoutputAlignmentProperty,
            MessagePayload payload) {

        Set<EntityID> tempSet = payload.getAllObjectPropertyAssertionsForEntity(
                IPSMBridgeSemanticsEntityID,
                updownChannelProperty);
        if (!tempSet.isEmpty()) {
            EntityID channelConfigID = tempSet.iterator().next();
            tempSet = payload.getAllObjectPropertyAssertionsForEntity(channelConfigID,
                    inoutputAlignmentProperty);
            if (!tempSet.isEmpty()) {
                return Optional.of(tempSet.iterator().next());
            }
        }
        return Optional.empty();
    }

    /**
     * Puts IPSM bridge config into RDF entities in a payload.
     *
     * @param payload Payload to put information into
     * @return ID of an instance of mw:IPSMBridgeSemantics, to which information from this {@code IPSMBridgeConfig} is attached
     */
    public EntityID putIntoPayload(MessagePayload payload) {
        return putIntoPayload(new EntityID(), payload);
    }

    /**
     * Puts IPSM bridge config into RDF entities in a payload.
     *
     * @param IPSMBridgeSemanticsEntityID EntityID that will become of type mw:IPSMBridgeSemantics, and to which all information will be attached
     * @param payload                     Payload to put information into
     * @return The same as parameter {@code IPSMBridgeSemanticsEntityID }
     */
    public EntityID putIntoPayload(EntityID IPSMBridgeSemanticsEntityID, MessagePayload payload) {
        EntityID downAlignInput = new EntityID();
        EntityID downAlignOutput = new EntityID();
        EntityID upAlignInput = new EntityID();
        EntityID upAlignOutput = new EntityID();

        payload.addTypeToEntity(downAlignInput, IDManagerINTERMW.TYPES.IPSMAlignment);
        payload.addTypeToEntity(downAlignOutput, IDManagerINTERMW.TYPES.IPSMAlignment);
        payload.addTypeToEntity(upAlignInput, IDManagerINTERMW.TYPES.IPSMAlignment);
        payload.addTypeToEntity(upAlignOutput, IDManagerINTERMW.TYPES.IPSMAlignment);

        setAlignmentInfo(payload, downAlignInput, downstreamInputAlignmentName, downstreamInputAlignmentVersion);
        setAlignmentInfo(payload, downAlignOutput, downstreamOutputAlignmentName, downstreamOutputAlignmentVersion);
        setAlignmentInfo(payload, upAlignInput, upstreamInputAlignmentName, upstreamInputAlignmentVersion);
        setAlignmentInfo(payload, upAlignOutput, upstreamOutputAlignmentName, upstreamOutputAlignmentVersion);

        EntityID downChannelConfig = new EntityID();
        EntityID upChannelConfig = new EntityID();

        payload.addTypeToEntity(downChannelConfig, IDManagerINTERMW.TYPES.IPSMChannelConfig);
        payload.addTypeToEntity(upChannelConfig, IDManagerINTERMW.TYPES.IPSMChannelConfig);

        payload.addObjectPropertyAssertionToEntity(downChannelConfig, IDManagerINTERMW.PROPERTIES.OBJECT.hasInputAlignment, downAlignInput);
        payload.addObjectPropertyAssertionToEntity(downChannelConfig, IDManagerINTERMW.PROPERTIES.OBJECT.hasOutputAlignment, downAlignOutput);

        payload.addObjectPropertyAssertionToEntity(upChannelConfig, IDManagerINTERMW.PROPERTIES.OBJECT.hasInputAlignment, upAlignInput);
        payload.addObjectPropertyAssertionToEntity(upChannelConfig, IDManagerINTERMW.PROPERTIES.OBJECT.hasOutputAlignment, upAlignOutput);

        payload.addTypeToEntity(IPSMBridgeSemanticsEntityID, IDManagerGOIoTP.TYPES.Semantics);
        payload.addTypeToEntity(IPSMBridgeSemanticsEntityID, IDManagerINTERMW.TYPES.IPSMBridgeSemantics);

        payload.addObjectPropertyAssertionToEntity(IPSMBridgeSemanticsEntityID, IDManagerINTERMW.PROPERTIES.OBJECT.hasDownstreamChannelConfig, downChannelConfig);
        payload.addObjectPropertyAssertionToEntity(IPSMBridgeSemanticsEntityID, IDManagerINTERMW.PROPERTIES.OBJECT.hasUpstreamChannelConfig, upChannelConfig);

        return IPSMBridgeSemanticsEntityID;
    }

    /**
     * Adds version and ID information to an mw:IPSMAlignment entity
     *
     * @param payload
     * @param alignEntityID
     * @param name          Alignment name - if empty, "IDENTITY" is used
     * @param version       Alignment version - if empty, then the version property is not set
     */
    private void setAlignmentInfo(MessagePayload payload, EntityID alignEntityID, Optional<String> name, Optional<String> version) {
        payload.addDataPropertyAssertionToEntity(alignEntityID,
                IDManagerGOIoTP.PROPERTIES.DATA.hasName,
                name.orElse(IDENTITYAlignmentName));
        if (version.isPresent()) {
            payload.addDataPropertyAssertionToEntity(alignEntityID,
                    IDManagerGOIoTP.PROPERTIES.DATA.hasVersion,
                    version.get());
        }
    }

    @Override
    public String toString() {
        return "Downstream channel {Input alignment: {" + downstreamInputAlignmentName + ", " + downstreamInputAlignmentVersion + "}" +
                " Output alignment: {" + downstreamOutputAlignmentName + ", " + downstreamOutputAlignmentVersion + "}}" +
                "\nUpstream channel {Input alignment: {" + upstreamInputAlignmentName + ", " + upstreamInputAlignmentVersion + "}" +
                " Output alignment: {" + upstreamOutputAlignmentName + ", " + upstreamOutputAlignmentVersion + "}}";
    }

    /**
     * Compares two instances of IPSMBridgeConfig with respect to alignment names and versions
     * WARNING: an empty alignment name is considered equivalent to the identity alignment name
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IPSMBridgeConfig) {
            IPSMBridgeConfig that = (IPSMBridgeConfig) obj;
            return (
                    compareAlignmentNames(downstreamInputAlignmentName, that.downstreamInputAlignmentName) &&
                            compareAlignmentNames(downstreamOutputAlignmentName, that.downstreamOutputAlignmentName) &&
                            compareAlignmentNames(upstreamOutputAlignmentName, that.upstreamOutputAlignmentName) &&
                            compareAlignmentNames(upstreamInputAlignmentName, that.upstreamInputAlignmentName) &&
                            downstreamInputAlignmentVersion.equals(that.downstreamInputAlignmentVersion) &&
                            downstreamOutputAlignmentVersion.equals(that.downstreamOutputAlignmentVersion) &&
                            upstreamInputAlignmentVersion.equals(that.upstreamInputAlignmentVersion) &&
                            upstreamOutputAlignmentVersion.equals(that.upstreamOutputAlignmentVersion)
            );
        }
        return false;
    }

    private boolean compareAlignmentNames(Optional<String> first, Optional<String> second) {
        if (first.equals(second)) return true;
        if (!first.isPresent()) return second.equals(Optional.of(IDENTITYAlignmentName));
        if (!second.isPresent()) return first.equals(Optional.of(IDENTITYAlignmentName));
        return false;
    }
}

