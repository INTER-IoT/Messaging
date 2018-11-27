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


package eu.interiot.message.managers.ID;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.ID.PropertyID;

/**
 * * A container for any ID used in Inter-IoT {@Link Message Message} metadata or payload.
 */
public interface IDManagerGOIoTPex {

    interface TYPES {

        EntityID Width = new EntityID("http://inter-iot.eu/GOIoTPex#Width");
        EntityID Length = new EntityID("http://inter-iot.eu/GOIoTPex#Length");
        EntityID Permeability = new EntityID("http://inter-iot.eu/GOIoTPex#Permeability");
        EntityID Luminance = new EntityID("http://inter-iot.eu/GOIoTPex#Luminance");
        EntityID OpenIoT = new EntityID("http://inter-iot.eu/GOIoTPex#OpenIoT");
        EntityID Energy = new EntityID("http://inter-iot.eu/GOIoTPex#Energy");
        EntityID DynamicViscosity = new EntityID("http://inter-iot.eu/GOIoTPex#DynamicViscosity");
        EntityID AngularVelocity = new EntityID("http://inter-iot.eu/GOIoTPex#AngularVelocity");
        EntityID SolidAngle = new EntityID("http://inter-iot.eu/GOIoTPex#SolidAngle");
        EntityID ElectricCurrent = new EntityID("http://inter-iot.eu/GOIoTPex#ElectricCurrent");
        EntityID WaveNumber = new EntityID("http://inter-iot.eu/GOIoTPex#WaveNumber");
        EntityID Mass = new EntityID("http://inter-iot.eu/GOIoTPex#Mass");
        EntityID SIDerivedMK = new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedMK");
        EntityID FIWARE = new EntityID("http://inter-iot.eu/GOIoTPex#FIWARE");
        EntityID Pressure = new EntityID("http://inter-iot.eu/GOIoTPex#Pressure");
        EntityID SpecificVolume = new EntityID("http://inter-iot.eu/GOIoTPex#SpecificVolume");
        EntityID AmountOfSubstanceConcentration = new EntityID("http://inter-iot.eu/GOIoTPex#AmountOfSubstanceConcentration");
        EntityID Product = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprMathOperation.owl#Product");
        EntityID RadiantIntensity = new EntityID("http://inter-iot.eu/GOIoTPex#RadiantIntensity");
        EntityID BaseUnit = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#BaseUnit");
        EntityID Person = new EntityID("http://xmlns.com/foaf/0.1/Person");
        EntityID MassFraction = new EntityID("http://inter-iot.eu/GOIoTPex#MassFraction");
        EntityID LuminousIntensity = new EntityID("http://inter-iot.eu/GOIoTPex#LuminousIntensity");
        EntityID ElectricResistance = new EntityID("http://inter-iot.eu/GOIoTPex#ElectricResistance");
        EntityID ElectricPotentialDifference = new EntityID("http://inter-iot.eu/GOIoTPex#ElectricPotentialDifference");
        EntityID CurrentDensity = new EntityID("http://inter-iot.eu/GOIoTPex#CurrentDensity");
        EntityID HeatFluxDensity = new EntityID("http://inter-iot.eu/GOIoTPex#HeatFluxDensity");
        EntityID AngularAcceleration = new EntityID("http://inter-iot.eu/GOIoTPex#AngularAcceleration");
        EntityID AuthenticationData = new EntityID("http://inter-iot.eu/GOIoTPex#AuthenticationData");
        EntityID Frequency = new EntityID("http://inter-iot.eu/GOIoTPex#Frequency");
        EntityID SpecificEnergy = new EntityID("http://inter-iot.eu/GOIoTPex#SpecificEnergy");
        EntityID RayExposure = new EntityID("http://inter-iot.eu/GOIoTPex#RayExposure");
        EntityID ActivityOfRadionuclide = new EntityID("http://inter-iot.eu/GOIoTPex#ActivityOfRadionuclide");
        EntityID Radiance = new EntityID("http://inter-iot.eu/GOIoTPex#Radiance");
        EntityID SIDerivedSpecialInclusiveMK = new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialInclusiveMK");
        EntityID Area = new EntityID("http://inter-iot.eu/GOIoTPex#Area");
        EntityID Temperature = new EntityID("http://inter-iot.eu/GOIoTPex#Temperature");
        EntityID LogarithmicScale = new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#LogarithmicScale");
        EntityID CatalyticActivityConcentration = new EntityID("http://inter-iot.eu/GOIoTPex#CatalyticActivityConcentration");
        EntityID HeatCapacity = new EntityID("http://inter-iot.eu/GOIoTPex#HeatCapacity");
        EntityID MagneticFieldStrength = new EntityID("http://inter-iot.eu/GOIoTPex#MagneticFieldStrength");
        EntityID MomentOfForce = new EntityID("http://inter-iot.eu/GOIoTPex#MomentOfForce");
        EntityID Depth = new EntityID("http://inter-iot.eu/GOIoTPex#Depth");
        EntityID Kerma = new EntityID("http://inter-iot.eu/GOIoTPex#Kerma");
        EntityID Measurement = new EntityID("http://sweet.jpl.nasa.gov/2.3/repr.owl#Measurement");
        EntityID ElectricChargeDensity = new EntityID("http://inter-iot.eu/GOIoTPex#ElectricChargeDensity");
        EntityID ElectricFluxDensity = new EntityID("http://inter-iot.eu/GOIoTPex#ElectricFluxDensity");
        EntityID LogarithmicUnit = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#LogarithmicUnit");
        EntityID SpecificHeatCapacity = new EntityID("http://inter-iot.eu/GOIoTPex#SpecificHeatCapacity");
        EntityID UnitDerivedByRaisingToPower = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByRaisingToPower");
        EntityID CatalyticActivity = new EntityID("http://inter-iot.eu/GOIoTPex#CatalyticActivity");
        EntityID Unit = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Unit");
        EntityID MolarEnergy = new EntityID("http://inter-iot.eu/GOIoTPex#MolarEnergy");
        EntityID WSO2 = new EntityID("http://inter-iot.eu/GOIoTPex#WSO2");
        EntityID Distance = new EntityID("http://inter-iot.eu/GOIoTPex#Distance");
        EntityID UnitDerivedByShifting = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByShifting");
        EntityID DoseEquivalent = new EntityID("http://inter-iot.eu/GOIoTPex#DoseEquivalent");
        EntityID Power = new EntityID("http://inter-iot.eu/GOIoTPex#Power");
        EntityID EclipseOM2M = new EntityID("http://inter-iot.eu/GOIoTPex#EclipseOM2M");
        EntityID Electricconductance = new EntityID("http://inter-iot.eu/GOIoTPex#Electricconductance");
        EntityID Volume = new EntityID("http://inter-iot.eu/GOIoTPex#Volume");
        EntityID ComplexUnit = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ComplexUnit");
        EntityID Illuminance = new EntityID("http://inter-iot.eu/GOIoTPex#Illuminance");
        EntityID ElectricFieldStrength = new EntityID("http://inter-iot.eu/GOIoTPex#ElectricFieldStrength");
        EntityID MolarEntropy = new EntityID("http://inter-iot.eu/GOIoTPex#MolarEntropy");
        EntityID ElectricCharge = new EntityID("http://inter-iot.eu/GOIoTPex#ElectricCharge");
        EntityID Height = new EntityID("http://inter-iot.eu/GOIoTPex#Height");
        EntityID MassDensity = new EntityID("http://inter-iot.eu/GOIoTPex#MassDensity");
        EntityID SIBaseMK = new EntityID("http://inter-iot.eu/GOIoTPex#SIBaseMK");
        EntityID MagneticFlux = new EntityID("http://inter-iot.eu/GOIoTPex#MagneticFlux");
        EntityID UnitDerivedByScaling = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDerivedByScaling");
        EntityID AbsorbedDoseRate = new EntityID("http://inter-iot.eu/GOIoTPex#AbsorbedDoseRate");
        EntityID Inductance = new EntityID("http://inter-iot.eu/GOIoTPex#Inductance");
        EntityID OneM2M = new EntityID("http://inter-iot.eu/GOIoTPex#OneM2M");
        EntityID Force = new EntityID("http://inter-iot.eu/GOIoTPex#Force");
        EntityID Acceleration = new EntityID("http://inter-iot.eu/GOIoTPex#Acceleration");
        EntityID SIDerivedSpecialMK = new EntityID("http://inter-iot.eu/GOIoTPex#SIDerivedSpecialMK");
        EntityID Permittivity = new EntityID("http://inter-iot.eu/GOIoTPex#Permittivity");
        EntityID Azure = new EntityID("http://inter-iot.eu/GOIoTPex#Azure");
        EntityID PlaneAngle = new EntityID("http://inter-iot.eu/GOIoTPex#PlaneAngle");
        EntityID AmountOfSubstance = new EntityID("http://inter-iot.eu/GOIoTPex#AmountOfSubstance");
        EntityID Prefix = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#Prefix");
        EntityID SurfaceTension = new EntityID("http://inter-iot.eu/GOIoTPex#SurfaceTension");
        EntityID Time = new EntityID("http://inter-iot.eu/GOIoTPex#Time");
        EntityID Capacitance = new EntityID("http://inter-iot.eu/GOIoTPex#Capacitance");
        EntityID Middleware = new EntityID("http://inter-iot.eu/GOIoTP#Middleware");
        EntityID EnergyDensity = new EntityID("http://inter-iot.eu/GOIoTPex#EnergyDensity");
        EntityID ThermalConductivity = new EntityID("http://inter-iot.eu/GOIoTPex#ThermalConductivity");
        EntityID LuminousFlux = new EntityID("http://inter-iot.eu/GOIoTPex#LuminousFlux");
        EntityID UniversAAL = new EntityID("http://inter-iot.eu/GOIoTPex#UniversAAL");
        EntityID MagneticFluxDensity = new EntityID("http://inter-iot.eu/GOIoTPex#MagneticFluxDensity");
        EntityID Velocity = new EntityID("http://inter-iot.eu/GOIoTPex#Velocity");
        EntityID UnitDefinedByProduct = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#UnitDefinedByProduct");
    }

    interface INSTANCES {

        EntityID millimeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#millimeter");
        EntityID century = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#century");
        EntityID FTU = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#FTU");
        EntityID pascalSecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#pascalSecond");
        EntityID million_km2 = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#million_km2");
        EntityID hecto = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#hecto");
        EntityID candela = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#candela");
        EntityID megahertz = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#megahertz");
        EntityID perRadian = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perRadian");
        EntityID MHz = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#MHz");
        EntityID meterPerKelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterPerKelvin");
        EntityID arcsecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#arcsecond");
        EntityID joulePerKelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#joulePerKelvin");
        EntityID ampereSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ampereSquared");
        EntityID kilogram = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kilogram");
        EntityID kelvinPerMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kelvinPerMeter");
        EntityID gigahertz = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#gigahertz");
        EntityID metre = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#metre");
        EntityID amperePerMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#amperePerMeter");
        EntityID joulePerTesla = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#joulePerTesla");
        EntityID meterSquaredPerKilogram = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterSquaredPerKilogram");
        EntityID micro = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#micro");
        EntityID coulombPerMeterSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#coulombPerMeterSquared");
        EntityID pptv = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#pptv");
        EntityID kilohertz = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kilohertz");
        EntityID second = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#second");
        EntityID kilogramMeterPerSecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kilogramMeterPerSecond");
        EntityID radianPerSecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#radianPerSecond");
        EntityID giga = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#giga");
        EntityID MYA = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#MYA");
        EntityID micron = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#micron");
        EntityID steradian = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#steradian");
        EntityID pascalPerSecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#pascalPerSecond");
        EntityID wattPerMeterSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#wattPerMeterSquared");
        EntityID tera = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#tera");
        EntityID joulePerMolePerKelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#joulePerMolePerKelvin");
        EntityID perKilogramMeterSquaredPerSecondKelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perKilogramMeterSquaredPerSecondKelvin");
        EntityID secondSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#secondSquared");
        EntityID month = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#month");
        EntityID nanometer = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#nanometer");
        EntityID season = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#season");
        EntityID kilometerPerHour = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kilometerPerHour");
        EntityID decade = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#decade");
        EntityID centi = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#centi");
        EntityID perAmpereSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perAmpereSquared");
        EntityID joule = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#joule");
        EntityID perKelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perKelvin");
        EntityID permil = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#permil");
        EntityID volt = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#volt");
        EntityID degreeF = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#degreeF");
        EntityID nano = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#nano");
        EntityID voltPerMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#voltPerMeter");
        EntityID perKilogramMole = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perKilogramMole");
        EntityID ohmMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ohmMeter");
        EntityID perKilogram = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perKilogram");
        EntityID weber = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#weber");
        EntityID milli = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#milli");
        EntityID ppmv = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ppmv");
        EntityID mole = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#mole");
        EntityID radianPerSecondSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#radianPerSecondSquared");
        EntityID coulomb = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#coulomb");
        EntityID million_km3 = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#million_km3");
        EntityID mega = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#mega");
        EntityID perPascal = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perPascal");
        EntityID radian = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#radian");
        EntityID lumen = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#lumen");
        EntityID newtonMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#newtonMeter");
        EntityID perSteradian = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perSteradian");
        EntityID newtonPerMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#newtonPerMeter");
        EntityID deca = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#deca");
        EntityID ppm = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ppm");
        EntityID meterSquaredPerSecondSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterSquaredPerSecondSquared");
        EntityID newton = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#newton");
        EntityID volumeRatio = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#volumeRatio");
        EntityID perMil = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perMil");
        EntityID watt = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#watt");
        EntityID siemensPerKilogram = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#siemensPerKilogram");
        EntityID centimeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#centimeter");
        EntityID minute = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#minute");
        EntityID perSecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perSecond");
        EntityID FormazinTurbidityUnit = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#FormazinTurbidityUnit");
        EntityID FNU = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#FNU");
        EntityID perMeterSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perMeterSquared");
        EntityID kilo = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kilo");
        EntityID micrometer = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#micrometer");
        EntityID jouleSecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#jouleSecond");
        EntityID joulePerKilogram = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#joulePerKilogram");
        EntityID week = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#week");
        EntityID joulePerMeterCubedPerKelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#joulePerMeterCubedPerKelvin");
        EntityID dimensionlessUnit = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#dimensionlessUnit");
        EntityID hour = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#hour");
        EntityID coulombPerMeterCubed = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#coulombPerMeterCubed");
        EntityID kelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kelvin");
        EntityID ppbv = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ppbv");
        EntityID ppt = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ppt");
        EntityID pascal = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#pascal");
        EntityID meterSquaredPerSecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterSquaredPerSecond");
        EntityID ampere = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ampere");
        EntityID perMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perMeter");
        EntityID perTesla = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perTesla");
        EntityID perSecondSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perSecondSquared");
        EntityID terahertz = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#terahertz");
        EntityID year = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#year");
        EntityID joulePerKilogramPerKelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#joulePerKilogramPerKelvin");
        EntityID joulePerMeterSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#joulePerMeterSquared");
        EntityID faradPerMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#faradPerMeter");
        EntityID meterPerSecondSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterPerSecondSquared");
        EntityID wattPerMeterSquaredPerKelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#wattPerMeterSquaredPerKelvin");
        EntityID henry = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#henry");
        EntityID degrees = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#degrees");
        EntityID day = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#day");
        EntityID siemens = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#siemens");
        EntityID siemensPerMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#siemensPerMeter");
        EntityID perSecondCubed = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perSecondCubed");
        EntityID meterPerSecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterPerSecond");
        EntityID wattPerMeterSquaredPerSteradianPerWavelength = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#wattPerMeterSquaredPerSteradianPerWavelength");
        EntityID normalizedUnit = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#normalizedUnit");
        EntityID ppb = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ppb");
        EntityID perMeterCubed = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perMeterCubed");
        EntityID perVolt = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perVolt");
        EntityID meterCubed = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterCubed");
        EntityID meterCubedPerSecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterCubedPerSecond");
        EntityID kilometer = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kilometer");
        EntityID meterSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterSquared");
        EntityID lux = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#lux");
        EntityID hertz = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#hertz");
        EntityID henryPerMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#henryPerMeter");
        EntityID perAmpere = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perAmpere");
        EntityID amperePerMeterSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#amperePerMeterSquared");
        EntityID ohm = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ohm");
        EntityID coulombMeter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#coulombMeter");
        EntityID wattPerMeterPerKelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#wattPerMeterPerKelvin");
        EntityID perMole = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perMole");
        EntityID percent = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#percent");
        EntityID tesla = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#tesla");
        EntityID meter = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meter");
        EntityID millenium = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#millenium");
        EntityID wattPerMeterSquaredPerSteradian = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#wattPerMeterSquaredPerSteradian");
        EntityID db = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#db");
        EntityID degreeC = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#degreeC");
        EntityID arcminute = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#arcminute");
        EntityID perCandela = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#perCandela");
        EntityID kilogramPerMeterSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kilogramPerMeterSquared");
        EntityID peta = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#peta");
        EntityID ratio = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#ratio");
        EntityID meterCubedPerKilogram = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterCubedPerKilogram");
        EntityID farad = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#farad");
        EntityID kilogramRadianPerSecond = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kilogramRadianPerSecond");
        EntityID kilogramPerMeterCubed = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#kilogramPerMeterCubed");
        EntityID candelaPerMeterSquared = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#candelaPerMeterSquared");
        EntityID exa = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#exa");
        EntityID meterCubedPerKelvin = new EntityID("http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#meterCubedPerKelvin");
    }

    interface PROPERTIES {

        interface DATA {
            PropertyID hasLocalID = new PropertyID("http://inter-iot.eu/GOIoTPex#hasLocalID");
        }


        interface OBJECT {

            PropertyID hasScale = new PropertyID("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScale");
            PropertyID hasAuthenticationData = new PropertyID("http://inter-iot.eu/GOIoTPex#hasAuthenticationData");
        }


        interface ANNOTATION {

            PropertyID hasSymbol = new PropertyID("http://sweet.jpl.nasa.gov/2.3/relaSci.owl#hasSymbol");
            PropertyID name = new PropertyID("http://xmlns.com/foaf/0.1/name");
            PropertyID hasScalingNumber = new PropertyID("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasScalingNumber");
            PropertyID toThePower = new PropertyID("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#toThePower");
            PropertyID hasNumericValue = new PropertyID("http://sweet.jpl.nasa.gov/2.3/relaSci.owl#hasNumericValue");
            PropertyID hasBaseUnit = new PropertyID("http://sweet.jpl.nasa.gov/2.3/relaSci.owl#hasBaseUnit");
            PropertyID hasShiftingNumber = new PropertyID("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasShiftingNumber");
            PropertyID ontologyModule = new PropertyID("http://inter-iot.eu/GOIoTP#ontologyModule");
            PropertyID hasOperand = new PropertyID("http://sweet.jpl.nasa.gov/2.3/relaMath.owl#hasOperand");
            PropertyID hasPrefix = new PropertyID("http://sweet.jpl.nasa.gov/2.3/relaSci.owl#hasPrefix");
        }

    }

}