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

import java.util.*;

/**
 * Subclass structure:
 * <p>
 * http://inter-iot.eu/GOIoTPex#CurrentDensity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#LuminousIntensity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#HeatFluxDensity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#SpecificHeatCapacity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#SolidAngle
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#DynamicViscosity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Kerma
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit
 * http://www.w3.org/2002/07/owl#Thing
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * <p>
 * http://inter-iot.eu/GOIoTPex#EnergyDensity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDefinedByProduct
 * http://www.w3.org/2002/07/owl#Thing
 * http://sweet.jpl.nasa.gov/2.3/reprMathOperation.owl#Product
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * <p>
 * http://inter-iot.eu/GOIoTPex#OpenIoT
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#Middleware
 * <p>
 * http://inter-iot.eu/GOIoTPex#Electricconductance
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Area
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#MolarEnergy
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Capacitance
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Volume
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#HeatCapacity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#AngularVelocity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Luminance
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#ElectricResistance
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#ElectricChargeDensity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#MagneticFieldStrength
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#DoseEquivalent
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Length
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#Distance
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#MomentOfForce
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#WaveNumber
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Inductance
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Mass
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Force
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#CatalyticActivityConcentration
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Permittivity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTP#Middleware
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTPex#Velocity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Width
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#Distance
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#SpecificEnergy
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#WSO2
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#Middleware
 * <p>
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Permeability
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Energy
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#OneM2M
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#Middleware
 * <p>
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTPex#ElectricPotentialDifference
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Illuminance
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#PlaneAngle
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#ElectricCharge
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#ThermalConductivity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#AbsorbedDoseRate
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#ElectricCurrent
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#MassFraction
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#SurfaceTension
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#BaseUnit
 * http://www.w3.org/2002/07/owl#Thing
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#LogarithmicScale
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTPex#UniversAAL
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#Middleware
 * <p>
 * http://inter-iot.eu/GOIoTPex#RayExposure
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://xmlns.com/foaf/0.1/Person
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTPex#MolarEntropy
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#LogarithmicUnit
 * http://www.w3.org/2002/07/owl#Thing
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * <p>
 * http://inter-iot.eu/GOIoTPex#AngularAcceleration
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#EclipseOM2M
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#Middleware
 * <p>
 * http://inter-iot.eu/GOIoTPex#ElectricFieldStrength
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#LuminousFlux
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTP#User
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTPex#AuthenticationData
 * http://www.w3.org/2002/07/owl#Thing
 * http://www.w3.org/ns/ssn/Property
 * <p>
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Prefix
 * http://www.w3.org/2002/07/owl#Thing
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * <p>
 * http://inter-iot.eu/GOIoTPex#CatalyticActivity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Acceleration
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#SpecificVolume
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#ElectricFluxDensity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Power
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Height
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#Distance
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#MassDensity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTP#IoTDevice
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://inter-iot.eu/GOIoTPex#RadiantIntensity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprMathOperation.owl#Product
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit
 * http://www.w3.org/2002/07/owl#Thing
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * <p>
 * http://inter-iot.eu/GOIoTPex#Temperature
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#AmountOfSubstanceConcentration
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#FIWARE
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#Middleware
 * <p>
 * http://inter-iot.eu/GOIoTPex#Distance
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Azure
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTP#Middleware
 * <p>
 * http://inter-iot.eu/GOIoTPex#MagneticFlux
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Pressure
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#ActivityOfRadionuclide
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByShifting
 * http://www.w3.org/2002/07/owl#Thing
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * <p>
 * http://inter-iot.eu/GOIoTPex#Time
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://www.w3.org/ns/ssn/Property
 * http://www.w3.org/2002/07/owl#Thing
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByRaisingToPower
 * http://www.w3.org/2002/07/owl#Thing
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * <p>
 * http://inter-iot.eu/GOIoTPex#Depth
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#Distance
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#AmountOfSubstance
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIBaseMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByScaling
 * http://www.w3.org/2002/07/owl#Thing
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit
 * http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit
 * http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement
 * <p>
 * http://inter-iot.eu/GOIoTPex#Frequency
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#Radiance
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 * <p>
 * http://inter-iot.eu/GOIoTPex#MagneticFluxDensity
 * http://www.w3.org/2002/07/owl#Thing
 * http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK
 * http://inter-iot.eu/GOIoTP#MeasurementKind
 */
public class TypeManagerGOIoTPex {

    static Map<EntityID, Set<EntityID>> supertypeMap = new HashMap<>();

    static {

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#CurrentDensity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#LuminousIntensity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#HeatFluxDensity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#SpecificHeatCapacity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#SolidAngle"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#DynamicViscosity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Kerma"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#EnergyDensity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDefinedByProduct"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprMathOperation.owl#Product"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#OpenIoT"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Electricconductance"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Area"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#MolarEnergy"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Capacitance"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Volume"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#HeatCapacity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#AngularVelocity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Luminance"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#ElectricResistance"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#ElectricChargeDensity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#MagneticFieldStrength"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#DoseEquivalent"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Length"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#Distance"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#MomentOfForce"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#WaveNumber"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Inductance"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Mass"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Force"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#CatalyticActivityConcentration"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Permittivity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#Middleware"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Velocity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Width"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#Distance"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#SpecificEnergy"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#WSO2"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Permeability"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Energy"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#OneM2M"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#ElectricPotentialDifference"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Illuminance"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#PlaneAngle"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#ElectricCharge"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#ThermalConductivity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#AbsorbedDoseRate"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#ElectricCurrent"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#MassFraction"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#SurfaceTension"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#BaseUnit"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#LogarithmicScale"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#UniversAAL"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#RayExposure"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://xmlns.com/foaf/0.1/Person"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#MolarEntropy"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#LogarithmicUnit"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#AngularAcceleration"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#EclipseOM2M"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#ElectricFieldStrength"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#LuminousFlux"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#User"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#AuthenticationData"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://www.w3.org/ns/ssn/Property")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Prefix"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#CatalyticActivity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Acceleration"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#SpecificVolume"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#ElectricFluxDensity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Power"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Height"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#Distance"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#MassDensity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTP#IoTDevice"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#RadiantIntensity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprMathOperation.owl#Product"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Temperature"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#AmountOfSubstanceConcentration"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#FIWARE"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Distance"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Azure"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTP#Middleware")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#MagneticFlux"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Pressure"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#ActivityOfRadionuclide"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByShifting"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Time"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://www.w3.org/ns/ssn/Property"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByRaisingToPower"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Depth"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#Distance"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#AmountOfSubstance"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByScaling"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit"),
                        new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Frequency"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#Radiance"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
                )));

        supertypeMap.put(new EntityID("http://inter-iot.eu/GOIoTPex#MagneticFluxDensity"),
                new HashSet<EntityID>(Arrays.asList(
                        new EntityID("http://www.w3.org/2002/07/owl#Thing"),
                        new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK"),
                        new EntityID("http://inter-iot.eu/GOIoTP#MeasurementKind")
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