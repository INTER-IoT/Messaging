package eu.interiot.message.payload;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.ID.PropertyID;
import eu.interiot.message.MessagePayload;
import eu.interiot.message.exceptions.payload.IdentifierException;
import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.vocabulary.RDF;

import java.util.Map;
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

public class MessagePayloadFunctions {

    /**
     * Adds a triple to a payload asserting that an entity is of a given type
     *
     * @param payload
     * @param entityID
     * @param entityType
     */
    public static void addTypeToEntity(MessagePayload payload, EntityID entityID, EntityID entityType) {
        addObjectPropertyAssertionToEntity(payload, entityID, new PropertyID(RDF.type), entityType);
    }

    /**
     * Removes (if present) a triple from a payload asserting that an entity is of a given type
     *
     * @param payload
     * @param entityID
     * @param entityType
     */
    public static void removeTypeFromEntity(MessagePayload payload, EntityID entityID, EntityID entityType) {
        removeObjectPropertyAssertionFromEntity(payload, entityID, new PropertyID(RDF.type), entityType);
    }

    public static void addObjectPropertyAssertionToEntity(MessagePayload payload, EntityID entityID,
                                                          PropertyID propertyID, EntityID propertyValue) {
        payload.getJenaModel().add(
                entityID.getJenaResource(),
                propertyID.getJenaProperty(),
                propertyValue.getJenaResource());
    }

    public static void setObjectPropertyAssertionForEntity(MessagePayload payload, EntityID entityID,
                                                           PropertyID propertyID, EntityID propertyValue) {
        removeAllObjectPropertyAssertionsFromEntity(payload, entityID, propertyID);
        addObjectPropertyAssertionToEntity(payload, entityID, propertyID, propertyValue);
    }

    public static void removeObjectPropertyAssertionFromEntity(MessagePayload payload, EntityID entityID,
                                                               PropertyID propertyID, EntityID propertyValue) {
        payload.getJenaModel().remove(
                entityID.getJenaResource(),
                propertyID.getJenaProperty(),
                propertyValue.getJenaResource());
    }

    public static void removeAllObjectPropertyAssertionsFromEntity(MessagePayload payload, EntityID entityID,
                                                                   PropertyID propertyID) {
        payload.getJenaModel().removeAll(
                entityID.getJenaResource(),
                propertyID.getJenaProperty(),
                null);
    }

    public static Set<EntityID> getAllObjectPropertyAssertionsForEntity(MessagePayload payload, EntityID entityID,
                                                                        PropertyID propertyID) {
        Set<EntityID> entities = payload.getJenaModel().listObjectsOfProperty(entityID.getJenaResource(), propertyID.getJenaProperty())
                .toSet()
                .stream()
                .map(x -> {
                    try {
                        return new EntityID(x.asResource());
                    } catch (IdentifierException e) {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);

        return entities;
    }

    public static Map<PropertyID, EntityID> getAllObjectPropertyAssertionsForEntity(MessagePayload payload, EntityID entityID) {
        Map<PropertyID, EntityID> entities = payload.getJenaModel().listStatements(new SimpleSelector(entityID.getJenaResource(), null, (Resource) null))
                .toSet()
                .stream()
                .filter(x -> x.getObject().isResource())
                .collect(Collectors.toMap(
                        x -> new PropertyID(x.getPredicate()),
                        y -> {
                            try {
                                return new EntityID(y.getObject().asResource());
                            } catch (IdentifierException e) {
                                return null;
                            }
                        }
                ));
        return entities;
    }

    public static Map<PropertyID, String> getAllObjectPropertyAssertionsForEntityAsStrings(MessagePayload payload, EntityID entityID) {
        Map<PropertyID, String> entities = payload.getJenaModel().listStatements(new SimpleSelector(entityID.getJenaResource(), null, (Resource) null))
                .toSet()
                .stream()
                .filter(x -> x.getObject().isResource())
                .collect(Collectors.toMap(
                        x -> new PropertyID(x.getPredicate()),
                        y -> y.getObject().asResource().toString()));
        return entities;
    }

    public static void addDataPropertyAssertionToEntity(MessagePayload payload, EntityID entityID,
                                                        PropertyID propertyID, Object propertyValue) {
        payload.getJenaModel().add(
                payload.getJenaModel().createLiteralStatement(
                        entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue)
        );
    }

    public static void addDataPropertyAssertionToEntity(MessagePayload payload, EntityID entityID,
                                                        PropertyID propertyID, String propertyValue) {
        addDataPropertyAssertionToEntity(payload, entityID, propertyID, propertyValue, null);
    }

    public static void addDataPropertyAssertionToEntity(MessagePayload payload, EntityID entityID,
                                                        PropertyID propertyID, String propertyValue, RDFDatatype datatype) {
        if (null == datatype) {
            payload.getJenaModel().add(entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue);
        } else {
            payload.getJenaModel().add(entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue, datatype);
        }
    }

    public static void addDataPropertyAssertionToEntity(MessagePayload payload, EntityID entityID,
                                                        PropertyID propertyID, int propertyValue) {
        payload.getJenaModel().addLiteral(entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue);
    }

    public static void addDataPropertyAssertionToEntity(MessagePayload payload, EntityID entityID,
                                                        PropertyID propertyID, char propertyValue) {
        payload.getJenaModel().addLiteral(entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue);
    }

    public static void addDataPropertyAssertionToEntity(MessagePayload payload, EntityID entityID,
                                                        PropertyID propertyID, boolean propertyValue) {
        payload.getJenaModel().addLiteral(entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue);
    }

    public static void addDataPropertyAssertionToEntity(MessagePayload payload, EntityID entityID,
                                                        PropertyID propertyID, float propertyValue) {
        payload.getJenaModel().addLiteral(entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue);
    }

    public static void addDataPropertyAssertionToEntity(MessagePayload payload, EntityID entityID,
                                                        PropertyID propertyID, double propertyValue) {
        payload.getJenaModel().addLiteral(entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue);
    }

    public static void addDataPropertyAssertionToEntity(MessagePayload payload, EntityID entityID,
                                                        PropertyID propertyID, long propertyValue) {
        payload.getJenaModel().addLiteral(entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue);
    }

    public static void setDataPropertyAssertionForEntity(MessagePayload payload, EntityID entityID,
                                                         PropertyID propertyID, Object propertyValue) {
        removeAllDataPropertyAssertionsFromEntity(payload, entityID, propertyID);
        addDataPropertyAssertionToEntity(payload, entityID, propertyID, propertyValue);
    }

    public static void setDataPropertyAssertionForEntity(MessagePayload payload, EntityID entityID,
                                                         PropertyID propertyID, String propertyValue) {
        removeAllDataPropertyAssertionsFromEntity(payload, entityID, propertyID);
        addDataPropertyAssertionToEntity(payload, entityID, propertyID, propertyValue);
    }

    public static void setDataPropertyAssertionForEntity(MessagePayload payload, EntityID entityID,
                                                         PropertyID propertyID, int propertyValue) {
        removeAllDataPropertyAssertionsFromEntity(payload, entityID, propertyID);
        addDataPropertyAssertionToEntity(payload, entityID, propertyID, propertyValue);
    }

    public static void setDataPropertyAssertionForEntity(MessagePayload payload, EntityID entityID,
                                                         PropertyID propertyID, char propertyValue) {
        removeAllDataPropertyAssertionsFromEntity(payload, entityID, propertyID);
        addDataPropertyAssertionToEntity(payload, entityID, propertyID, propertyValue);
    }

    public static void setDataPropertyAssertionForEntity(MessagePayload payload, EntityID entityID,
                                                         PropertyID propertyID, boolean propertyValue) {
        removeAllDataPropertyAssertionsFromEntity(payload, entityID, propertyID);
        addDataPropertyAssertionToEntity(payload, entityID, propertyID, propertyValue);
    }

    public static void setDataPropertyAssertionForEntity(MessagePayload payload, EntityID entityID,
                                                         PropertyID propertyID, float propertyValue) {
        removeAllDataPropertyAssertionsFromEntity(payload, entityID, propertyID);
        addDataPropertyAssertionToEntity(payload, entityID, propertyID, propertyValue);
    }

    public static void setDataPropertyAssertionForEntity(MessagePayload payload, EntityID entityID,
                                                         PropertyID propertyID, double propertyValue) {
        removeAllDataPropertyAssertionsFromEntity(payload, entityID, propertyID);
        addDataPropertyAssertionToEntity(payload, entityID, propertyID, propertyValue);
    }

    public static void setDataPropertyAssertionForEntity(MessagePayload payload, EntityID entityID,
                                                         PropertyID propertyID, long propertyValue) {
        removeAllDataPropertyAssertionsFromEntity(payload, entityID, propertyID);
        addDataPropertyAssertionToEntity(payload, entityID, propertyID, propertyValue);
    }

    public static void removeDataPropertyAssertionFromEntity(MessagePayload payload, EntityID entityID,
                                                             PropertyID propertyID, String propertyValue) {
        payload.getJenaModel().remove(
                payload.getJenaModel().createLiteralStatement(
                        entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue)
        );
    }

    public static void removeDataPropertyAssertionFromEntity(MessagePayload payload, EntityID entityID,
                                                             PropertyID propertyID, int propertyValue) {
        payload.getJenaModel().remove(
                payload.getJenaModel().createLiteralStatement(
                        entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue)
        );
    }

    public static void removeDataPropertyAssertionFromEntity(MessagePayload payload, EntityID entityID,
                                                             PropertyID propertyID, char propertyValue) {
        payload.getJenaModel().remove(
                payload.getJenaModel().createLiteralStatement(
                        entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue)
        );
    }

    public static void removeDataPropertyAssertionFromEntity(MessagePayload payload, EntityID entityID,
                                                             PropertyID propertyID, boolean propertyValue) {
        payload.getJenaModel().remove(
                payload.getJenaModel().createLiteralStatement(
                        entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue)
        );
    }

    public static void removeDataPropertyAssertionFromEntity(MessagePayload payload, EntityID entityID,
                                                             PropertyID propertyID, float propertyValue) {
        payload.getJenaModel().remove(
                payload.getJenaModel().createLiteralStatement(
                        entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue)
        );
    }

    public static void removeDataPropertyAssertionFromEntity(MessagePayload payload, EntityID entityID,
                                                             PropertyID propertyID, double propertyValue) {
        payload.getJenaModel().remove(
                payload.getJenaModel().createLiteralStatement(
                        entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue)
        );
    }

    public static void removeDataPropertyAssertionFromEntity(MessagePayload payload, EntityID entityID,
                                                             PropertyID propertyID, long propertyValue) {
        payload.getJenaModel().remove(
                payload.getJenaModel().createLiteralStatement(
                        entityID.getJenaResource(), propertyID.getJenaProperty(), propertyValue)
        );
    }

    public static void removeAllDataPropertyAssertionsFromEntity(MessagePayload payload, EntityID entityID,
                                                                 PropertyID propertyID) {
        payload.getJenaModel().removeAll(
                entityID.getJenaResource(),
                propertyID.getJenaProperty(),
                null);
    }

    public static Set<Object> getAllDataPropertyAssertionsForEntity(MessagePayload payload, EntityID entityID,
                                                                    PropertyID propertyID) {
        Set<Object> entities = payload.getJenaModel().listObjectsOfProperty(entityID.getJenaResource(), propertyID.getJenaProperty())
                .toSet()
                .stream()
                .map(x -> {
                    if (x.isLiteral()) {
                        return x.asLiteral().getValue();
                    } else {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);

        return entities;
    }

    public static Map<PropertyID, Object> getAllDataPropertyAssertionsForEntity(MessagePayload payload, EntityID entityID) {
        Map<PropertyID, Object> entities = payload.getJenaModel().listStatements(new SimpleSelector(entityID.getJenaResource(), null, (Object) null))
                .toSet()
                .stream()
                .filter(x -> x.getObject().isLiteral())
                .collect(Collectors.toMap(x -> new PropertyID(x.getPredicate()), y -> y.getObject().asLiteral().getValue()));
        return entities;
    }

    public static Map<PropertyID, String> getAllDataPropertyAssertionsForEntityAsStrings(MessagePayload payload, EntityID entityID) {
        Map<PropertyID, String> entities = payload.getJenaModel().listStatements(new SimpleSelector(entityID.getJenaResource(), null, (Object) null))
                .toSet()
                .stream()
                .filter(x -> x.getObject().isLiteral())
                .collect(Collectors.toMap(x -> new PropertyID(x.getPredicate()), y -> y.getObject().asLiteral().getString()));
        return entities;
    }

    public static Set<String> getAllDataPropertyAssertionsForEntityAsStrings(MessagePayload payload, EntityID entityID,
                                                                             PropertyID propertyID) {
        Set<String> entities = payload.getJenaModel().listObjectsOfProperty(entityID.getJenaResource(), propertyID.getJenaProperty())
                .toSet()
                .stream()
                .map(x -> {
                    if (x.isLiteral()) {
                        return x.asLiteral().getString();
                    } else {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);

        return entities;
    }

    public static Set<Character> getAllDataPropertyAssertionsForEntityAsChars(MessagePayload payload, EntityID entityID,
                                                                              PropertyID propertyID) {
        Set<Character> entities = payload.getJenaModel().listObjectsOfProperty(entityID.getJenaResource(), propertyID.getJenaProperty())
                .toSet()
                .stream()
                .map(x -> {
                    if (x.isLiteral()) {
                        return x.asLiteral().getChar();
                    } else {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);

        return entities;
    }

    public static Set<Boolean> getAllDataPropertyAssertionsForEntityAsBooleans(MessagePayload payload, EntityID entityID,
                                                                               PropertyID propertyID) {
        Set<Boolean> entities = payload.getJenaModel().listObjectsOfProperty(entityID.getJenaResource(), propertyID.getJenaProperty())
                .toSet()
                .stream()
                .map(x -> {
                    if (x.isLiteral()) {
                        return x.asLiteral().getBoolean();
                    } else {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);

        return entities;
    }

    public static Set<Integer> getAllDataPropertyAssertionsForEntityAsIntegers(MessagePayload payload, EntityID entityID,
                                                                               PropertyID propertyID) {
        Set<Integer> entities = payload.getJenaModel().listObjectsOfProperty(entityID.getJenaResource(), propertyID.getJenaProperty())
                .toSet()
                .stream()
                .map(x -> {
                    if (x.isLiteral()) {
                        return x.asLiteral().getInt();
                    } else {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);

        return entities;
    }

    public static Set<Float> getAllDataPropertyAssertionsForEntityAsFloats(MessagePayload payload, EntityID entityID,
                                                                           PropertyID propertyID) {
        Set<Float> entities = payload.getJenaModel().listObjectsOfProperty(entityID.getJenaResource(), propertyID.getJenaProperty())
                .toSet()
                .stream()
                .map(x -> {
                    if (x.isLiteral()) {
                        return x.asLiteral().getFloat();
                    } else {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);

        return entities;
    }

    public static Set<Double> getAllDataPropertyAssertionsForEntityAsDoubles(MessagePayload payload, EntityID entityID,
                                                                             PropertyID propertyID) {
        Set<Double> entities = payload.getJenaModel().listObjectsOfProperty(entityID.getJenaResource(), propertyID.getJenaProperty())
                .toSet()
                .stream()
                .map(x -> {
                    if (x.isLiteral()) {
                        return x.asLiteral().getDouble();
                    } else {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);

        return entities;
    }

    public static Set<Long> getAllDataPropertyAssertionsForEntityAsLongs(MessagePayload payload, EntityID entityID,
                                                                         PropertyID propertyID) {
        Set<Long> entities = payload.getJenaModel().listObjectsOfProperty(entityID.getJenaResource(), propertyID.getJenaProperty())
                .toSet()
                .stream()
                .map(x -> {
                    if (x.isLiteral()) {
                        return x.asLiteral().getLong();
                    } else {
                        return null;
                    }
                })
                .collect(Collectors.toSet());

        if (entities.contains(null))
            entities.remove(null);

        return entities;
    }


}
