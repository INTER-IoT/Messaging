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


package eu.interiot.message.managers.type;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.managers.ID.IDManagerINTERMW;

import java.util.*;

/**
 * This Type Manager manages entities (mostly types) that are very specific to INTER-MW development and pilots
 */
public class TypeManagerINTERMW {

    /*
 Class hierarchy:

 */
    static Map<EntityID, Set<EntityID>> supertypeMap = new HashMap<>();

    static {
        //TODO: Fill the supertype map with INTERMW subtypes of Middleware
        supertypeMap.put(IDManagerINTERMW.TYPES.FIWARE,
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(IDManagerINTERMW.TYPES.UniversAAL,
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(IDManagerINTERMW.TYPES.Azure,
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(IDManagerINTERMW.TYPES.OneM2M,
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(IDManagerINTERMW.TYPES.WSO2,
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(IDManagerINTERMW.TYPES.BodyCloud,
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(IDManagerINTERMW.TYPES.BodyCloudEmulated,
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(IDManagerINTERMW.TYPES.UniversAALEmulated,
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(IDManagerINTERMW.TYPES.Emulator,
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));
    }

    /**
     * Returns a possibly empty set of all explicit superclasses (supertypes) for a given type.
     *
     * @param typeID
     * @return
     */
    public static Set<EntityID> getSupertypeSet(EntityID typeID) {
        return supertypeMap.getOrDefault(typeID, new HashSet<EntityID>());
    }

    /**
     * Returns a possibly empty set of all explicit superclasses (supertypes) for a given type, including the type in the argument.
     *
     * @param typeID
     * @return
     */
    public static Set<EntityID> getAllTypes(EntityID typeID) {
        Set<EntityID> s = getSupertypeSet(typeID);
        s.add(typeID);
        return s;
    }


}