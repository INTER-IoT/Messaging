package eu.interiot.message.payload;

import eu.interiot.message.ID.EntityID;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.vocabulary.RDF;

import java.util.Set;

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


/**
 * A class for Payloads that are specific for one type of entities e.g. Devices, Platforms, etc.
 */
public class TypedPayload extends GOIoTPPayload {

    private EntityID entityType;

    public TypedPayload(EntityID entityType) {
        this(entityType, false);
    }

    public TypedPayload(EntityID entityType, boolean useRDFSInferencer) {
        super(useRDFSInferencer);
        setEntityType(entityType);
    }

    public TypedPayload(EntityID entityType, Model jenaModel) {
        this(entityType, jenaModel, false);
    }

    public TypedPayload(EntityID entityType, Model jenaModel, boolean useRDFSInferencer) {
        super(jenaModel, useRDFSInferencer);
        setEntityType(entityType);
    }

    /**
     * @return The type of the entities for this TypedPayload (e.g. IoTDevice, Platform, etc.)
     */
    public EntityID getEntityType() {
        return entityType;
    }

    private void setEntityType(EntityID entityType) {
        this.entityType = entityType;
    }

    /**
     * @param entityID Creates an instance of an entity inside this Payload, of type particular to this TypedPayload (e.g. IoTDevice, Platform, etc.)
     */
    public void createTypedEntity(EntityID entityID) {
        getJenaModel().add(entityID.getJenaResource(),
                RDF.type,
                entityType.getJenaResource());
    }

    /**
     * @return A set of all entities inside this payload that are of type particular to this TypedPayload (e.g. IoTDevice, Platform, etc.)
     */
    public Set<EntityID> getTypedEntities() {
        return getAllTypedEntities(entityType);
//        Set<EntityID> entities = getJenaModel().listSubjectsWithProperty(RDF.type,
//                entityType.getJenaResource())
//                .toSet()
//                .stream()
//                .map(x -> {
//                    try {
//                        return new EntityID(x);
//                    } catch (IdentifierException e) {
//                        return null;
//                    }
//                }).collect(Collectors.toSet());
//
//        if (entities.contains(null))
//            entities.remove(null);
//        return entities;
    }
}
