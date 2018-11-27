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


package eu.interiot.message.payload.types.instanced;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.exceptions.payload.IdentifierException;
import eu.interiot.message.payload.InstancedPayload;
import org.apache.jena.rdf.model.Model;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Payload for class IoTDevice with URI http://inter-iot.eu/GOIoTP#IoTDevice
 * <p>
 * Attributes:
 * HasLocation, HasName, IsHostedBy
 * <p>
 * <p>
 * <p>
 * Supertypes:
 * http://www.w3.org/ns/sosa/System
 */
public class IoTDeviceInstancedPayload extends InstancedPayload {

   /*
Properties:
HasLocation, HasName, IsHostedBy
*/

    public IoTDeviceInstancedPayload(EntityID IoTDeviceID) {
        this(IoTDeviceID, false);
    }

    public IoTDeviceInstancedPayload(EntityID IoTDeviceID, boolean useRDFSInferencer) {
        super(IoTDeviceID, new EntityID("http://inter-iot.eu/GOIoTP#IoTDevice"), useRDFSInferencer);
    }

    public IoTDeviceInstancedPayload(EntityID IoTDeviceID, Model jenaModel) {
        this(IoTDeviceID, jenaModel, false);
    }

    public IoTDeviceInstancedPayload(EntityID IoTDeviceID, Model jenaModel, boolean useRDFSInferencer) {
        super(IoTDeviceID, new EntityID("http://inter-iot.eu/GOIoTP#IoTDevice"), jenaModel, useRDFSInferencer);
    }

    public EntityID getIoTDeviceInstanceID() {
        return getEntityInstanceID();
    }

    public void setIoTDeviceInstanceID(EntityID IoTDeviceID) {
        setEntityInstanceID(IoTDeviceID);
    }


    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public Optional<EntityID> getHasLocation() {
        EntityID IoTDeviceID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                IoTDeviceID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"))
                .toSet()
                .stream()
                .map(x -> {
                    try {
                        return new EntityID(x.asResource());
                    } catch (IdentifierException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (s.contains(null))
            s.remove(null);

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void setHasLocation(EntityID propertyValue) {
        EntityID IoTDeviceID = getEntityInstanceID();

        removeHasLocation();
        getJenaModel().add(IoTDeviceID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasLocation object property assertion
     */
    public void removeHasLocation() {
        EntityID IoTDeviceID = getEntityInstanceID();

        getJenaModel().removeAll(IoTDeviceID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasLocation"),
                null);
    }

    /**
     * Getter for http://inter-iot.eu/GOIoTP#hasName data property assertion
     */
    public Optional<String> getHasName() {
        EntityID IoTDeviceID = getEntityInstanceID();

        Set<Object> s = getJenaModel().listObjectsOfProperty(
                IoTDeviceID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasName"))
                .toSet()
                .stream()
                .map(x -> x.asLiteral().getValue())
                .collect(Collectors.toSet());

        Set<String> ss = s.stream().map(y -> {
                    if (y instanceof String) {
                        return (String) y;
                    } else {
                        return null;
                    }
                }
        ).collect(Collectors.toSet());

        if (ss.contains(null))
            ss.remove(null);
        if (ss.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(ss.iterator().next());
        }
    }

    /**
     * Setter for http://inter-iot.eu/GOIoTP#hasName data property assertion
     */
    public void setHasName(String propertyValue) {
        EntityID IoTDeviceID = getEntityInstanceID();

        removeHasName();
        getJenaModel().add(
                getJenaModel().createLiteralStatement(IoTDeviceID.getJenaResource(),
                        getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasName"),
                        propertyValue
                ));
    }

    /**
     * Remover for http://inter-iot.eu/GOIoTP#hasName data property assertion
     */
    public void removeHasName() {
        EntityID IoTDeviceID = getEntityInstanceID();

        getJenaModel().removeAll(IoTDeviceID.getJenaResource(),
                getJenaModel().createProperty("http://inter-iot.eu/GOIoTP#hasName"),
                null);
    }

    /**
     * Getter for http://www.w3.org/ns/sosa/IsHostedBy object property assertion
     */
    public Optional<EntityID> getIsHostedBy() {
        EntityID IoTDeviceID = getEntityInstanceID();

        Set<EntityID> s = getJenaModel().listObjectsOfProperty(
                IoTDeviceID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/IsHostedBy"))
                .toSet()
                .stream()
                .map(x -> {
                    try {
                        return new EntityID(x.asResource());
                    } catch (IdentifierException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (s.contains(null))
            s.remove(null);

        if (s.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(s.iterator().next());
        }
    }

    /**
     * Setter for http://www.w3.org/ns/sosa/IsHostedBy object property assertion
     */
    public void setIsHostedBy(EntityID propertyValue) {
        EntityID IoTDeviceID = getEntityInstanceID();

        removeIsHostedBy();
        getJenaModel().add(IoTDeviceID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/IsHostedBy"),
                propertyValue.getJenaResource());
    }

    /**
     * Remover for http://www.w3.org/ns/sosa/IsHostedBy object property assertion
     */
    public void removeIsHostedBy() {
        EntityID IoTDeviceID = getEntityInstanceID();

        getJenaModel().removeAll(IoTDeviceID.getJenaResource(),
                getJenaModel().createProperty("http://www.w3.org/ns/sosa/IsHostedBy"),
                null);
    }

}