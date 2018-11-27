package eu.interiot.message.ID;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.ResourceFactory;

import java.net.URI;

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
 * Objects of this class store a single identifier for a property (hasName, hosts, hasLocation etc).
 * <p>
 * The identifier must be globally unique and have a form of an URI (e.g. http://inter-iot.eu/GOIoTP#hasLocation).
 */
public class PropertyID {
    private Property property;

    /**
     * Makes a new instance of an PropertyID.
     *
     * @param uri Only URIs that start with "http://" are accepted as parameters.
     */
    public PropertyID(String uri) {
        if (uri.startsWith("http://") && uri.length() > 7) {
            property = ResourceFactory.createProperty(uri);
        } else {
            throw new IllegalArgumentException("Only URIs that start with \"http://\" are accepted as arguments");
        }
    }

    /**
     * Makes a new instance of a PropertyID.
     *
     * @param uri Only URIs that start with "http://" are accepted as parameters.
     */
    public PropertyID(URI uri) {
        this(uri.toString());
    }

    public PropertyID(Property jenaProperty) {
        this.property = jenaProperty;
    }

    public Property getJenaProperty() {
        return property;
    }

    @Override
    public String toString() {
        return property.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyID propertyID = (PropertyID) o;

        if (propertyID.toString() == this.toString())
            return true;

        return property.equals(propertyID.property);
    }

    @Override
    public int hashCode() {
        return property.hashCode();
    }
}
