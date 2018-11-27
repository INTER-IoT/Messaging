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


    package eu.interiot.message.utils;

    import org.apache.jena.rdf.model.*;

    import java.util.Set;
    import java.util.stream.Collectors;

    /**
     * Utilities for any class that uses a Jena model
     */
    public final class MessageModelUtils {

        public static boolean startsWithHttp(String identifier) {
            return identifier.startsWith("http://");
        }

        public static StmtIterator getResourceStatements(Model jenaModel, String subject, String predicate, String object) {
            Resource s = null;
            Property p = null;
            Resource o = null;

            if (subject != null) {
                if (startsWithHttp(subject)) {
                    s = jenaModel.createResource(subject.toString());
                } else {
                    s = jenaModel.createResource(new AnonId(subject));
                }
            }
            if (predicate != null) {
                p = jenaModel.createProperty(predicate.toString());
            }
            if (object != null) {
                if (startsWithHttp(subject)) {
                    o = jenaModel.createResource(object.toString());
                } else {
                    o = jenaModel.createResource(new AnonId(object));
                }
            }
            return jenaModel.listStatements(new SimpleSelector(s, p, o));
        }

        public static StmtIterator getLiteralStatements(Model jenaModel, String subject, String predicate, String object) {
            Resource s = null;
            Property p = null;
            Literal o = null;

            if (subject != null) {
                if (startsWithHttp(subject)) {
                    s = jenaModel.createResource(subject.toString());
                } else {
                    s = jenaModel.createResource(new AnonId(subject));
                }
            }
            if (predicate != null) {
                p = jenaModel.createProperty(predicate.toString());
            }
            if (object != null) {
                o = jenaModel.createLiteral(object);
            }
            return jenaModel.listStatements(new SimpleSelector(s, p, o));
        }

        public static void addResourceStatement(Model jenaModel, String subject, String predicate, String object) {
            jenaModel.add(
                    jenaModel.createResource(subject),
                    jenaModel.createProperty(predicate),
                    jenaModel.createResource(object));
        }

        public static void addLLiteralStatement(Model jenaModel, String subject, String predicate, Object literalValue) {
            jenaModel.add(
                    jenaModel.createLiteralStatement(
                            jenaModel.createResource(subject),
                            jenaModel.createProperty(predicate),
                            literalValue));
        }

        public static Set<Resource> getSubjectsFromStatements(Set<Statement> statements) {
            return statements.stream().map(x -> x.getSubject()).collect(Collectors.toSet());
        }

        public static Set<String> getStringSubjectsFromStatements(Set<Statement> statements) {
            return statements.stream().map(x -> x.getSubject().toString()).collect(Collectors.toSet());
        }

        public static Set<Property> getPredicatesFromStatements(Set<Statement> statements) {
            return statements.stream().map(x -> x.getPredicate()).collect(Collectors.toSet());
        }

        public static Set<String> getStringPredicatesFromStatements(Set<Statement> statements) {
            return statements.stream().map(x -> x.getPredicate().toString()).collect(Collectors.toSet());
        }

        public static Set<RDFNode> getObjectsFromStatements(Set<Statement> statements) {
            return statements.stream().map(x -> x.getObject()).collect(Collectors.toSet());
        }

        public static Set<String> getStringObjectsFromStatements(Set<Statement> statements) {
            return statements.stream().map(x -> x.getObject().toString()).collect(Collectors.toSet());
        }

        //TODO: Add remove property object and remove all property objects

        //    default StmtIterator extractStatements(Model jenaModel, URI subject, URI predicate, URI object) {
//        Resource s = null;
//        Property p = null;
//        Resource o = null;
//        if (subject != null) {
//            s = jenaModel.createResource(subject.toString());
//        }
//        if (predicate != null) {
//            p = jenaModel.createProperty(predicate.toString());
//        }
//        if (object != null) {
//            o = jenaModel.createResource(object.toString());
//        }
//        return extractStatements(jenaModel, s, p, o);
//    }
//
//    default StmtIterator extractStatements(Model jenaModel, Resource subject, Property predicate, Resource object) {
//        return jenaModel.listStatements(new SimpleSelector(subject, predicate, object));
//    }
//
//    default NodeIterator extractObjectsOfProperty(Model jenaModel, Property predicate) {
//        return jenaModel.listObjectsOfProperty(predicate);
//    }
    }
