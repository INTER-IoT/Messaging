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
import eu.interiot.message.ID.PropertyID;
import eu.interiot.message.exceptions.payload.IdentifierException;
import eu.interiot.message.payload.GOIoTPPayload;
import eu.interiot.message.payload.MessagePayloadFunctions;
import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.RDF;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A container for Inter-IoT {@code Message Message} payload.
 */
public class MessagePayload {

    /**
     * This model should contain any RDFS inferencing information required for proper payload parsing and operation
     */
    public static final Model rdfsSchema;

    static {
        rdfsSchema = ModelFactory.createDefaultModel();
    }

    private Model jenaModel;
    private boolean useRDFSInferencer;

    /**
     * Creates a new empty payload
     */
    public MessagePayload() {
        this(false);
    }

    /**
     * Creates a new empty payload
     *
     * @param useRDFSInferencer If true, the underlying model will use RDFS Inferencer to reason about taxonomy of payload types.
     *                          Using an inferencer is a bit slower, but it can have noticable impact if you use (or measure) thousands of messages at once.
     */
    public MessagePayload(boolean useRDFSInferencer) {
        this.useRDFSInferencer = useRDFSInferencer;
        if (useRDFSInferencer) {
            jenaModel = ModelFactory.createRDFSModel(rdfsSchema, ModelFactory.createDefaultModel());
        } else {
            jenaModel = ModelFactory.createDefaultModel();
        }
    }

    /**
     * Makes a new payload from an existing payload model
     *
     * @param jenaModel A Jena model
     */
    public MessagePayload(Model jenaModel) {
        this(jenaModel, false);
    }

    /**
     * Makes a new payload from an existing metadata model
     *
     * @param jenaModel         A Jena model
     * @param useRDFSInferencer If true, the underlying model will use RDFS Inferencer to reason about taxonomy.
     *                          Using an inferencer is a bit slower, but it can have noticable impact if you use (or measure) thousands of messages at once.
     */
    public MessagePayload(Model jenaModel, boolean useRDFSInferencer) {
        this.useRDFSInferencer = useRDFSInferencer;
        if (useRDFSInferencer) {
            this.jenaModel = ModelFactory.createRDFSModel(rdfsSchema, jenaModel);
        } else {
            this.jenaModel = jenaModel;
        }
    }

    //TODO: Implement clone here and in subclasses of Payload

    /**
     * Returns the Jena model used internally to store metadata.
     * Use only if you know what you are doing, and how to use Jena models.
     *
     * @return
     */
    public Model getJenaModel() {
        return jenaModel;
    }

    public boolean usesInferencer() {
        return useRDFSInferencer;
    }

    public GOIoTPPayload asGOIoTPPayload() {
        return new GOIoTPPayload(getJenaModel(), usesInferencer());
    }

    /**
     * Returns a set of all entities that have a type (i.e. all typed individuals) in this payload
     *
     * @return
     */
    public Set<EntityID> getAllTypedEntities() {
        Set<EntityID> entities = getJenaModel().listSubjectsWithProperty(RDF.type)
                .toSet()
                .stream()
                .map(x -> {
                    try {
                        return new EntityID(x);
                    } catch (IdentifierException e) {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);

        return entities;
    }

    /**
     * Returns a set of all entities that are of given type (i.e. all typed individuals) in this payload
     *
     * @param entityType An entity type
     * @return A set of entities of type {@code entityType} in this payload
     */
    public Set<EntityID> getAllTypedEntities(EntityID entityType) {
        Set<EntityID> entities = getJenaModel().listSubjectsWithProperty(RDF.type,
                entityType.getJenaResource())
                .toSet()
                .stream()
                .map(x -> {
                    try {
                        return new EntityID(x);
                    } catch (IdentifierException e) {
                        return null;
                    }
                }).collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);
        return entities;
    }

    /**
     * Returns a set of EntityIDs that identify types of an entity (individual) in this payload
     *
     * @param entityID An identifier of an entity that is a typed individual
     * @return
     */
    public Set<EntityID> getEntityTypes(EntityID entityID) {
        return MessagePayloadFunctions.getAllObjectPropertyAssertionsForEntity(this, entityID, new PropertyID(RDF.type));
    }

    /**
     * Returns true if an entity is asserted in this payload to be of a given type
     *
     * @param entityID
     * @param typeID
     * @return
     */
    public boolean isEntityOfType(EntityID entityID, EntityID typeID) {
        return getEntityTypes(entityID).contains(typeID);
    }

    /**
     * Adds a triple to a payload asserting that an entity is of a given type
     *
     * @param entityID
     * @param entityType
     */
    public void addTypeToEntity(EntityID entityID, EntityID entityType) {
        MessagePayloadFunctions.addTypeToEntity(this, entityID, entityType);
    }

    /**
     * Removes (if present) a triple from this payload asserting that an entity is of a given type
     *
     * @param entityID
     * @param entityType
     */
    public void removeTypeFromEntity(EntityID entityID, EntityID entityType) {
        MessagePayloadFunctions.removeTypeFromEntity(this, entityID, entityType);
    }

    public void addObjectPropertyAssertionToEntity(EntityID entityID, PropertyID propertyID, EntityID propertyValue) {
        MessagePayloadFunctions.addObjectPropertyAssertionToEntity(this, entityID, propertyID, propertyValue);
    }

    public void removeObjectPropertyAssertionFromEntity(EntityID entityID, PropertyID propertyID, EntityID propertyValue) {
        MessagePayloadFunctions.removeObjectPropertyAssertionFromEntity(this, entityID, propertyID, propertyValue);
    }

    public void removeAllObjectPropertyAssertionsFromEntity(EntityID entityID, PropertyID propertyID) {
        MessagePayloadFunctions.removeAllObjectPropertyAssertionsFromEntity(this, entityID, propertyID);
    }

    public void setObjectPropertyAssertionForEntity(EntityID entityID, PropertyID propertyID, EntityID propertyValue) {
        MessagePayloadFunctions.setObjectPropertyAssertionForEntity(this, entityID, propertyID, propertyValue);
    }

    //TODO: Add generic functions to get/add/remove/removeAll triples, but with EntityID and PropertyID parameter types

    public Set<EntityID> getAllObjectPropertyAssertionsForEntity(EntityID entityID, PropertyID propertyID) {
        return MessagePayloadFunctions.getAllObjectPropertyAssertionsForEntity(this, entityID, propertyID);
    }

    public void addDataPropertyAssertionToEntity(EntityID entityID, PropertyID propertyID, Object propertyValue) {
        MessagePayloadFunctions.addDataPropertyAssertionToEntity(this, entityID, propertyID, propertyValue);
    }

    public void addDataPropertyAssertionToEntity(EntityID entityID,
                                                 PropertyID propertyID, String propertyValue) {
        MessagePayloadFunctions.addDataPropertyAssertionToEntity(this, entityID, propertyID, propertyValue);
    }

    public void addDataPropertyAssertionToEntity(EntityID entityID, PropertyID propertyID, String propertyValue, RDFDatatype datatype) {
        MessagePayloadFunctions.addDataPropertyAssertionToEntity(this, entityID, propertyID, propertyValue, datatype);
    }

    public void addDataPropertyAssertionToEntity(EntityID entityID, PropertyID propertyID, int propertyValue) {
        MessagePayloadFunctions.addDataPropertyAssertionToEntity(this, entityID, propertyID, propertyValue);
    }

    public void addDataPropertyAssertionToEntity(EntityID entityID, PropertyID propertyID, char propertyValue) {
        MessagePayloadFunctions.addDataPropertyAssertionToEntity(this, entityID, propertyID, propertyValue);
    }

    public void addDataPropertyAssertionToEntity(EntityID entityID, PropertyID propertyID, boolean propertyValue) {
        MessagePayloadFunctions.addDataPropertyAssertionToEntity(this, entityID, propertyID, propertyValue);
    }

    public void addDataPropertyAssertionToEntity(EntityID entityID,
                                                 PropertyID propertyID, float propertyValue) {
        MessagePayloadFunctions.addDataPropertyAssertionToEntity(this, entityID, propertyID, propertyValue);
    }

    public void addDataPropertyAssertionToEntity(EntityID entityID,
                                                 PropertyID propertyID, double propertyValue) {
        MessagePayloadFunctions.addDataPropertyAssertionToEntity(this, entityID, propertyID, propertyValue);
    }

    public void addDataPropertyAssertionToEntity(EntityID entityID,
                                                 PropertyID propertyID, long propertyValue) {
        MessagePayloadFunctions.addDataPropertyAssertionToEntity(this, entityID, propertyID, propertyValue);
    }

    public void setDataPropertyAssertionForEntity(EntityID entityID, PropertyID propertyID, Object propertyValue) {
        MessagePayloadFunctions.setDataPropertyAssertionForEntity(this, entityID, propertyID, propertyValue);
    }

    public void setDataPropertyAssertionForEntity(EntityID entityID, PropertyID propertyID, String propertyValue) {
        MessagePayloadFunctions.setDataPropertyAssertionForEntity(this, entityID, propertyID, propertyValue);
    }

    public void setDataPropertyAssertionForEntity(EntityID entityID, PropertyID propertyID, int propertyValue) {
        MessagePayloadFunctions.setDataPropertyAssertionForEntity(this, entityID, propertyID, propertyValue);
    }

    public void setDataPropertyAssertionForEntity(EntityID entityID, PropertyID propertyID, char propertyValue) {
        MessagePayloadFunctions.setDataPropertyAssertionForEntity(this, entityID, propertyID, propertyValue);
    }

    public void setDataPropertyAssertionForEntity(EntityID entityID, PropertyID propertyID, boolean propertyValue) {
        MessagePayloadFunctions.setDataPropertyAssertionForEntity(this, entityID, propertyID, propertyValue);
    }

    public void setDataPropertyAssertionForEntity(EntityID entityID, PropertyID propertyID, float propertyValue) {
        MessagePayloadFunctions.setDataPropertyAssertionForEntity(this, entityID, propertyID, propertyValue);
    }

    public void setDataPropertyAssertionForEntity(EntityID entityID, PropertyID propertyID, double propertyValue) {
        MessagePayloadFunctions.setDataPropertyAssertionForEntity(this, entityID, propertyID, propertyValue);
    }

    public void setDataPropertyAssertionForEntity(EntityID entityID, PropertyID propertyID, long propertyValue) {
        MessagePayloadFunctions.setDataPropertyAssertionForEntity(this, entityID, propertyID, propertyValue);
    }

    public void removeDataPropertyAssertionFromEntity(EntityID entityID, PropertyID propertyID, String propertyValue) {
        MessagePayloadFunctions.removeDataPropertyAssertionFromEntity(this, entityID, propertyID, propertyValue);
    }

    public void removeDataPropertyAssertionFromEntity(EntityID entityID, PropertyID propertyID, int propertyValue) {
        MessagePayloadFunctions.removeDataPropertyAssertionFromEntity(this, entityID, propertyID, propertyValue);
    }

    public void removeDataPropertyAssertionFromEntity(EntityID entityID, PropertyID propertyID, char propertyValue) {
        MessagePayloadFunctions.removeDataPropertyAssertionFromEntity(this, entityID, propertyID, propertyValue);
    }

    public void removeDataPropertyAssertionFromEntity(EntityID entityID, PropertyID propertyID, boolean propertyValue) {
        MessagePayloadFunctions.removeDataPropertyAssertionFromEntity(this, entityID, propertyID, propertyValue);
    }

    public void removeDataPropertyAssertionFromEntity(EntityID entityID, PropertyID propertyID, float propertyValue) {
        MessagePayloadFunctions.removeDataPropertyAssertionFromEntity(this, entityID, propertyID, propertyValue);
    }

    public void removeDataPropertyAssertionFromEntity(EntityID entityID, PropertyID propertyID, double propertyValue) {
        MessagePayloadFunctions.removeDataPropertyAssertionFromEntity(this, entityID, propertyID, propertyValue);
    }

    public void removeDataPropertyAssertionFromEntity(EntityID entityID, PropertyID propertyID, long propertyValue) {
        MessagePayloadFunctions.removeDataPropertyAssertionFromEntity(this, entityID, propertyID, propertyValue);
    }

    public void removeAllDataPropertyAssertionsFromEntity(EntityID entityID, PropertyID propertyID) {
        MessagePayloadFunctions.removeAllDataPropertyAssertionsFromEntity(this, entityID, propertyID);
    }

    public Set<Object> getAllDataPropertyAssertionsForEntity(EntityID entityID, PropertyID propertyID) {
        return MessagePayloadFunctions.getAllDataPropertyAssertionsForEntity(this, entityID, propertyID);
    }

    public Set<String> getAllDataPropertyAssertionsForEntityAsStrings(EntityID entityID, PropertyID propertyID) {
        return MessagePayloadFunctions.getAllDataPropertyAssertionsForEntityAsStrings(this, entityID, propertyID);
    }

    public Set<Character> getAllDataPropertyAssertionsForEntityAsChars(EntityID entityID, PropertyID propertyID) {
        return MessagePayloadFunctions.getAllDataPropertyAssertionsForEntityAsChars(this, entityID, propertyID);
    }

    public Set<Boolean> getAllDataPropertyAssertionsForEntityAsBooleans(EntityID entityID, PropertyID propertyID) {
        return MessagePayloadFunctions.getAllDataPropertyAssertionsForEntityAsBooleans(this, entityID, propertyID);
    }

    public Set<Integer> getAllDataPropertyAssertionsForEntityAsIntegers(EntityID entityID, PropertyID propertyID) {
        return MessagePayloadFunctions.getAllDataPropertyAssertionsForEntityAsIntegers(this, entityID, propertyID);
    }

    public Set<Float> getAllDataPropertyAssertionsForEntityAsFloats(EntityID entityID, PropertyID propertyID) {
        return MessagePayloadFunctions.getAllDataPropertyAssertionsForEntityAsFloats(this, entityID, propertyID);
    }

    public Set<Double> getAllDataPropertyAssertionsForEntityAsDoubles(EntityID entityID, PropertyID propertyID) {
        return MessagePayloadFunctions.getAllDataPropertyAssertionsForEntityAsDoubles(this, entityID, propertyID);
    }

    public Set<Long> getAllDataPropertyAssertionsForEntityAsLongs(EntityID entityID, PropertyID propertyID) {
        return MessagePayloadFunctions.getAllDataPropertyAssertionsForEntityAsLongs(this, entityID, propertyID);
    }

    public Map<PropertyID, Object> getAllDataPropertyAssertionsForEntity(EntityID entityID) {
        return MessagePayloadFunctions.getAllDataPropertyAssertionsForEntity(this, entityID);
    }

    public Map<PropertyID, String> getAllDataPropertyAssertionsForEntityAsStrings(EntityID entityID) {
        return MessagePayloadFunctions.getAllDataPropertyAssertionsForEntityAsStrings(this, entityID);
    }

    public Map<PropertyID, EntityID> getAllObjectPropertyAssertionsForEntity(EntityID entityID) {
        return MessagePayloadFunctions.getAllObjectPropertyAssertionsForEntity(this, entityID);
    }

    public Map<PropertyID, String> getAllObjectPropertyAssertionsForEntityAsStrings(EntityID entityID) {
        return MessagePayloadFunctions.getAllObjectPropertyAssertionsForEntityAsStrings(this, entityID);
    }
}