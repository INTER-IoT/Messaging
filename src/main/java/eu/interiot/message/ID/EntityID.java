package eu.interiot.message.ID;

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


import eu.interiot.message.exceptions.payload.IdentifierException;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

import java.net.URI;

/**
 * Objects of this class store a single identifier for an entity (a Device, a Platform etc), or a class.
 * <p>
 * The identifiers may be either globally unique and have a form of an URI (e.g. http://inter-iot.eu/inst#device_1), or automatically generated (e.g. b123).
 * In the latter case the identifier SHOULD NOT be used outside of a Message from which it was gotten. This is because the same identifier may be generated independently in different messages and point to different entities.
 */
public class EntityID {

    private Resource resource;

    /**
     * Makes a new anonymous instance of an EntityID.
     */
    public EntityID() {
        resource = ResourceFactory.createResource();
    }

    /**
     * Makes a new instance of an EntityID.
     *
     * @param uri Only URIs that start with "http://" are accepted as parameters.
     */
    public EntityID(String uri) {
        if (uri.startsWith("http://") && uri.length() > 7) {
            resource = ResourceFactory.createResource(uri);
        } else {
            throw new IllegalArgumentException("Only proper URIs that start with \"http://\" are accepted as arguments");
        }
    }

    /**
     * Makes a new instance of an EntityID.
     *
     * @param uri Only URIs that start with "http://" are accepted as parameters.
     */
    public EntityID(URI uri) {
        this(uri.toString());
    }

    public EntityID(Resource jenaResource) throws IdentifierException {
        if (jenaResource.isURIResource() || jenaResource.isAnon()) {
            this.resource = jenaResource;
        } else {
            throw new IdentifierException("Only URI Resources or Anonymous Resources are accepted for an EntityID");
        }
    }

    public Resource getJenaResource() {
        return resource;
    }

    /**
     * Returns true if this EntityID is a globally unique URI.
     */
    public boolean isUnique() {
        return !resource.isAnon();
    }

    @Override
    public String toString() {
        if (resource.isAnon()) {
            return resource.getId().toString();
        } else {
            return resource.getURI();
        }
    }

    /**
     * Returns the URI fragment (string after last occurence of '#'), if this EntityID is an URI,
     * or an anonymous resource ID, if this EntityID is anonymous.
     *
     * @return
     */
    public String getURIFragment() {
        if (resource.isAnon()) {
            return resource.getId().toString();
        } else {
            return resource.getURI().substring(resource.getURI().lastIndexOf('#') + 1);
        }
    }

    /**
     * Returns the URI ending (string after last occurence of '#' or '/'), if this EntityID is an URI,
     * or an anonymous resource ID, if this EntityID is anonymous.
     *
     * @return
     */
    public String getURIEnding() {
        if (resource.isAnon()) {
            return resource.getId().toString();
        } else {
            if (resource.getURI().contains("#")) {
                return resource.getURI().substring(resource.getURI().lastIndexOf('#') + 1);
            } else if (resource.getURI().contains("/")) {
                return resource.getURI().substring(resource.getURI().lastIndexOf('/') + 1);
            } else {
                return resource.getURI();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityID entityID = (EntityID) o;

        if (resource.isURIResource() != entityID.resource.isURIResource())
            return false;

        if (resource.isAnon() != entityID.resource.isAnon())
            return false;

        if (resource.isLiteral() != entityID.resource.isLiteral())
            return false;

        if (resource.isURIResource() && entityID.resource.isURIResource()) {
            return this.toString().equals(entityID.toString());
        }

        return resource.equals(entityID.resource);
    }

    @Override
    public int hashCode() {
        return resource.hashCode();
    }
}
