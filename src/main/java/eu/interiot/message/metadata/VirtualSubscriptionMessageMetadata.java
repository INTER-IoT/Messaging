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


package eu.interiot.message.metadata;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.MessageMetadata;
import eu.interiot.message.exceptions.payload.IdentifierException;
import eu.interiot.message.managers.URI.URIManagerMessageMetadata;
import org.apache.jena.rdf.model.NodeIterator;
import org.apache.jena.rdf.model.RDFNode;

import java.util.Optional;

/**
 *
 */
public class VirtualSubscriptionMessageMetadata extends PlatformMessageMetadata {

    /**
     * Creates a new {@code VirtualSubscriptionMessageMetadata} VirtualSubscriptionMessageMetadata from {@code MessageMetadata} MessageMetadata
     * The metadata is not cloned.
     *
     * @param msgMetadata a metadata instance
     */
    public VirtualSubscriptionMessageMetadata(MessageMetadata msgMetadata) {
        super(msgMetadata);
    }

    /**
     * VirtualDeviceId is an IoTDevice identifier used in virtual subscription.
     * The virtual subscription allows for one device (called virtual device) to act as a platform
     * and subscribe to data from a set of other devices. The data is then routed by INTER-MW to the virtual device,
     * as if there was a platform subscription.
     *
     * @return
     */
    public Optional<EntityID> getVirtualDeviceId() {
        NodeIterator it = jenaModel.listObjectsOfProperty(metadataInstance, jenaModel.createProperty(URIManagerMessageMetadata.MESSAGEMETADATA.VirtualDeviceId));
        if (it.hasNext()) {
            RDFNode n = it.next();
            if (n.isResource()) {
                try {
                    return Optional.ofNullable(new EntityID(n.asResource()));
                } catch (IdentifierException e) {
//                    e.printStackTrace();
                }
            }
        }
        return Optional.empty();
    }

    /**
     * VirtualDeviceId is an IoTDevice identifier used in virtual subscription.
     * The virtual subscription allows for one device (called virtual device) to act as a platform
     * and subscribe to data from a set of other devices. The data is then routed by INTER-MW to the virtual device,
     * as if there was a platform subscription.
     *
     * @param virtualDeviceId
     */
    public void setVirtualDeviceId(EntityID virtualDeviceId) {
        removeVirtualDeviceId();
        jenaModel.add(metadataInstance, jenaModel.createProperty(URIManagerMessageMetadata.MESSAGEMETADATA.VirtualDeviceId), virtualDeviceId.getJenaResource());
    }

    /**
     * Returns a string with VirtualDeviceId or an empty string.
     *
     * @return
     */
    public String printVirtualDeviceId() {
        return getVirtualDeviceId().map(x -> x.toString()).orElse("");
    }

    /**
     * Removes any VirtualDeviceId information from this metadata.
     */
    public void removeVirtualDeviceId() {
        jenaModel.removeAll(metadataInstance, jenaModel.createProperty(URIManagerMessageMetadata.MESSAGEMETADATA.VirtualDeviceId), null);
    }
}
