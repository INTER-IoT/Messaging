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


package eu.interiot.message.managers.URI;


/**
 * /**
 * * A container for any ID used in Inter-IoT {@Link Message Message} metadata or payload.
 */
public interface URIManagerGOIoTPex {


    interface PREFIX {

        String rdf = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
        String sweet_oper = "http://sweet.jpl.nasa.gov/2.3/reprMathOperation.owl#";
        String geosparqlr = "http://www.opengis.net/def/rule/geosparql/";
        String geosparqlf = "http://www.opengis.net/def/function/geosparql/";
        String dc = "http://purl.org/dc/elements/1.1/";
        String sweet_screla = "http://sweet.jpl.nasa.gov/2.3/relaSci.owl#";
        String dcterms = "http://purl.org/dc/terms/";
        String voaf = "http://purl.org/vocommons/voaf#";
        String sf = "http://www.opengis.net/ont/sf#";
        String gml = "http://www.opengis.net/ont/gml#";
        String owl = "http://www.w3.org/2002/07/owl#";
        String skos = "http://www.w3.org/2004/02/skos/core#";
        String vs = "http://www.w3.org/2003/06/sw-vocab-status/ns#";
        String foaf = "http://xmlns.com/foaf/0.1/";
        String schema = "http://schema.org/";
        String rdfs = "http://www.w3.org/2000/01/rdf-schema#";
        String vann = "http://purl.org/vocab/vann/";
        String iiot = "http://inter-iot.eu/GOIoTP#";
        String iiotex = "http://inter-iot.eu/GOIoTPex#";
        String oldssn = "http://purl.oclc.org/NET/ssnx/ssn#";
        String sweet_repr = "http://sweet.jpl.nasa.gov/2.3/repr.owl#";
        String xsd = "http://www.w3.org/2001/XMLSchema#";
        String sweet_mrela = "http://sweet.jpl.nasa.gov/2.3/relaMath.owl#";
        String ogc = "http://www.opengis.net/";
        String geosparql = "http://www.opengis.net/ont/geosparql#";
        String sweet_units = "http://sweet.jpl.nasa.gov/2.3/reprSciUnits.owl#";
    }

    interface BASE {
    }

    interface TYPES {

        String Length = PREFIX.iiotex + "Length";
        String OpenIoT = PREFIX.iiotex + "OpenIoT";
        String Energy = PREFIX.iiotex + "Energy";
        String DynamicViscosity = PREFIX.iiotex + "DynamicViscosity";
        String SolidAngle = PREFIX.iiotex + "SolidAngle";
        String ElectricCurrent = PREFIX.iiotex + "ElectricCurrent";
        String WaveNumber = PREFIX.iiotex + "WaveNumber";
        String Mass = PREFIX.iiotex + "Mass";
        String SIDerivedMK = PREFIX.iiotex + "SIDerivedMK";
        String FIWARE = PREFIX.iiotex + "FIWARE";
        String Product = PREFIX.sweet_oper + "Product";
        String Person = PREFIX.foaf + "Person";
        String ElectricPotentialDifference = PREFIX.iiotex + "ElectricPotentialDifference";
        String HeatFluxDensity = PREFIX.iiotex + "HeatFluxDensity";
        String Frequency = PREFIX.iiotex + "Frequency";
        String SpecificEnergy = PREFIX.iiotex + "SpecificEnergy";
        String RayExposure = PREFIX.iiotex + "RayExposure";
        String ActivityOfRadionuclide = PREFIX.iiotex + "ActivityOfRadionuclide";
        String SIDerivedSpecialInclusiveMK = PREFIX.iiotex + "SIDerivedSpecialInclusiveMK";
        String Area = PREFIX.iiotex + "Area";
        String Temperature = PREFIX.iiotex + "Temperature";
        String MomentOfForce = PREFIX.iiotex + "MomentOfForce";
        String Kerma = PREFIX.iiotex + "Kerma";
        String Measurement = PREFIX.sweet_repr + "Measurement";
        String ElectricChargeDensity = PREFIX.iiotex + "ElectricChargeDensity";
        String ElectricFluxDensity = PREFIX.iiotex + "ElectricFluxDensity";
        String LogarithmicUnit = PREFIX.sweet_units + "LogarithmicUnit";
        String UnitDerivedByRaisingToPower = PREFIX.sweet_units + "UnitDerivedByRaisingToPower";
        String CatalyticActivity = PREFIX.iiotex + "CatalyticActivity";
        String Unit = PREFIX.sweet_units + "Unit";
        String MolarEnergy = PREFIX.iiotex + "MolarEnergy";
        String WSO2 = PREFIX.iiotex + "WSO2";
        String EclipseOM2M = PREFIX.iiotex + "EclipseOM2M";
        String ComplexUnit = PREFIX.sweet_units + "ComplexUnit";
        String Illuminance = PREFIX.iiotex + "Illuminance";
        String ElectricFieldStrength = PREFIX.iiotex + "ElectricFieldStrength";
        String ElectricCharge = PREFIX.iiotex + "ElectricCharge";
        String MagneticFlux = PREFIX.iiotex + "MagneticFlux";
        String UnitDerivedByScaling = PREFIX.sweet_units + "UnitDerivedByScaling";
        String AbsorbedDoseRate = PREFIX.iiotex + "AbsorbedDoseRate";
        String Inductance = PREFIX.iiotex + "Inductance";
        String OneM2M = PREFIX.iiotex + "OneM2M";
        String Force = PREFIX.iiotex + "Force";
        String Acceleration = PREFIX.iiotex + "Acceleration";
        String Permittivity = PREFIX.iiotex + "Permittivity";
        String Azure = PREFIX.iiotex + "Azure";
        String Prefix = PREFIX.sweet_units + "Prefix";
        String Capacitance = PREFIX.iiotex + "Capacitance";
        String ThermalConductivity = PREFIX.iiotex + "ThermalConductivity";
        String LuminousFlux = PREFIX.iiotex + "LuminousFlux";
        String UniversAAL = PREFIX.iiotex + "UniversAAL";
        String Velocity = PREFIX.iiotex + "Velocity";
        String Width = PREFIX.iiotex + "Width";
        String Permeability = PREFIX.iiotex + "Permeability";
        String Luminance = PREFIX.iiotex + "Luminance";
        String AngularVelocity = PREFIX.iiotex + "AngularVelocity";
        String Pressure = PREFIX.iiotex + "Pressure";
        String SpecificVolume = PREFIX.iiotex + "SpecificVolume";
        String AmountOfSubstanceConcentration = PREFIX.iiotex + "AmountOfSubstanceConcentration";
        String RadiantIntensity = PREFIX.iiotex + "RadiantIntensity";
        String BaseUnit = PREFIX.sweet_units + "BaseUnit";
        String MassFraction = PREFIX.iiotex + "MassFraction";
        String LuminousIntensity = PREFIX.iiotex + "LuminousIntensity";
        String ElectricResistance = PREFIX.iiotex + "ElectricResistance";
        String CurrentDensity = PREFIX.iiotex + "CurrentDensity";
        String AngularAcceleration = PREFIX.iiotex + "AngularAcceleration";
        String AuthenticationData = PREFIX.iiotex + "AuthenticationData";
        String Radiance = PREFIX.iiotex + "Radiance";
        String LogarithmicScale = PREFIX.sweet_repr + "LogarithmicScale";
        String CatalyticActivityConcentration = PREFIX.iiotex + "CatalyticActivityConcentration";
        String HeatCapacity = PREFIX.iiotex + "HeatCapacity";
        String MagneticFieldStrength = PREFIX.iiotex + "MagneticFieldStrength";
        String Depth = PREFIX.iiotex + "Depth";
        String SpecificHeatCapacity = PREFIX.iiotex + "SpecificHeatCapacity";
        String Distance = PREFIX.iiotex + "Distance";
        String UnitDerivedByShifting = PREFIX.sweet_units + "UnitDerivedByShifting";
        String DoseEquivalent = PREFIX.iiotex + "DoseEquivalent";
        String Power = PREFIX.iiotex + "Power";
        String Electricconductance = PREFIX.iiotex + "Electricconductance";
        String Volume = PREFIX.iiotex + "Volume";
        String MolarEntropy = PREFIX.iiotex + "MolarEntropy";
        String Height = PREFIX.iiotex + "Height";
        String MassDensity = PREFIX.iiotex + "MassDensity";
        String SIBaseMK = PREFIX.iiotex + "SIBaseMK";
        String SIDerivedSpecialMK = PREFIX.iiotex + "SIDerivedSpecialMK";
        String PlaneAngle = PREFIX.iiotex + "PlaneAngle";
        String AmountOfSubstance = PREFIX.iiotex + "AmountOfSubstance";
        String SurfaceTension = PREFIX.iiotex + "SurfaceTension";
        String Time = PREFIX.iiotex + "Time";
        String Middleware = PREFIX.iiot + "Middleware";
        String EnergyDensity = PREFIX.iiotex + "EnergyDensity";
        String MagneticFluxDensity = PREFIX.iiotex + "MagneticFluxDensity";
        String UnitDefinedByProduct = PREFIX.sweet_units + "UnitDefinedByProduct";
    }

    interface INSTANCES {

        String millimeter = PREFIX.sweet_units + "millimeter";
        String century = PREFIX.sweet_units + "century";
        String FTU = PREFIX.sweet_units + "FTU";
        String pascalSecond = PREFIX.sweet_units + "pascalSecond";
        String million_km2 = PREFIX.sweet_units + "million_km2";
        String hecto = PREFIX.sweet_units + "hecto";
        String candela = PREFIX.sweet_units + "candela";
        String megahertz = PREFIX.sweet_units + "megahertz";
        String perRadian = PREFIX.sweet_units + "perRadian";
        String MHz = PREFIX.sweet_units + "MHz";
        String meterPerKelvin = PREFIX.sweet_units + "meterPerKelvin";
        String arcsecond = PREFIX.sweet_units + "arcsecond";
        String joulePerKelvin = PREFIX.sweet_units + "joulePerKelvin";
        String ampereSquared = PREFIX.sweet_units + "ampereSquared";
        String kilogram = PREFIX.sweet_units + "kilogram";
        String kelvinPerMeter = PREFIX.sweet_units + "kelvinPerMeter";
        String gigahertz = PREFIX.sweet_units + "gigahertz";
        String metre = PREFIX.sweet_units + "metre";
        String amperePerMeter = PREFIX.sweet_units + "amperePerMeter";
        String joulePerTesla = PREFIX.sweet_units + "joulePerTesla";
        String meterSquaredPerKilogram = PREFIX.sweet_units + "meterSquaredPerKilogram";
        String micro = PREFIX.sweet_units + "micro";
        String coulombPerMeterSquared = PREFIX.sweet_units + "coulombPerMeterSquared";
        String pptv = PREFIX.sweet_units + "pptv";
        String kilohertz = PREFIX.sweet_units + "kilohertz";
        String second = PREFIX.sweet_units + "second";
        String kilogramMeterPerSecond = PREFIX.sweet_units + "kilogramMeterPerSecond";
        String radianPerSecond = PREFIX.sweet_units + "radianPerSecond";
        String giga = PREFIX.sweet_units + "giga";
        String MYA = PREFIX.sweet_units + "MYA";
        String micron = PREFIX.sweet_units + "micron";
        String steradian = PREFIX.sweet_units + "steradian";
        String pascalPerSecond = PREFIX.sweet_units + "pascalPerSecond";
        String wattPerMeterSquared = PREFIX.sweet_units + "wattPerMeterSquared";
        String tera = PREFIX.sweet_units + "tera";
        String joulePerMolePerKelvin = PREFIX.sweet_units + "joulePerMolePerKelvin";
        String perKilogramMeterSquaredPerSecondKelvin = PREFIX.sweet_units + "perKilogramMeterSquaredPerSecondKelvin";
        String secondSquared = PREFIX.sweet_units + "secondSquared";
        String month = PREFIX.sweet_units + "month";
        String nanometer = PREFIX.sweet_units + "nanometer";
        String season = PREFIX.sweet_units + "season";
        String kilometerPerHour = PREFIX.sweet_units + "kilometerPerHour";
        String decade = PREFIX.sweet_units + "decade";
        String centi = PREFIX.sweet_units + "centi";
        String perAmpereSquared = PREFIX.sweet_units + "perAmpereSquared";
        String joule = PREFIX.sweet_units + "joule";
        String perKelvin = PREFIX.sweet_units + "perKelvin";
        String permil = PREFIX.sweet_units + "permil";
        String volt = PREFIX.sweet_units + "volt";
        String degreeF = PREFIX.sweet_units + "degreeF";
        String nano = PREFIX.sweet_units + "nano";
        String voltPerMeter = PREFIX.sweet_units + "voltPerMeter";
        String perKilogramMole = PREFIX.sweet_units + "perKilogramMole";
        String ohmMeter = PREFIX.sweet_units + "ohmMeter";
        String perKilogram = PREFIX.sweet_units + "perKilogram";
        String weber = PREFIX.sweet_units + "weber";
        String milli = PREFIX.sweet_units + "milli";
        String ppmv = PREFIX.sweet_units + "ppmv";
        String mole = PREFIX.sweet_units + "mole";
        String radianPerSecondSquared = PREFIX.sweet_units + "radianPerSecondSquared";
        String coulomb = PREFIX.sweet_units + "coulomb";
        String million_km3 = PREFIX.sweet_units + "million_km3";
        String mega = PREFIX.sweet_units + "mega";
        String perPascal = PREFIX.sweet_units + "perPascal";
        String radian = PREFIX.sweet_units + "radian";
        String lumen = PREFIX.sweet_units + "lumen";
        String newtonMeter = PREFIX.sweet_units + "newtonMeter";
        String perSteradian = PREFIX.sweet_units + "perSteradian";
        String newtonPerMeter = PREFIX.sweet_units + "newtonPerMeter";
        String deca = PREFIX.sweet_units + "deca";
        String ppm = PREFIX.sweet_units + "ppm";
        String meterSquaredPerSecondSquared = PREFIX.sweet_units + "meterSquaredPerSecondSquared";
        String newton = PREFIX.sweet_units + "newton";
        String volumeRatio = PREFIX.sweet_units + "volumeRatio";
        String perMil = PREFIX.sweet_units + "perMil";
        String watt = PREFIX.sweet_units + "watt";
        String siemensPerKilogram = PREFIX.sweet_units + "siemensPerKilogram";
        String centimeter = PREFIX.sweet_units + "centimeter";
        String minute = PREFIX.sweet_units + "minute";
        String perSecond = PREFIX.sweet_units + "perSecond";
        String FormazinTurbidityUnit = PREFIX.sweet_units + "FormazinTurbidityUnit";
        String FNU = PREFIX.sweet_units + "FNU";
        String perMeterSquared = PREFIX.sweet_units + "perMeterSquared";
        String kilo = PREFIX.sweet_units + "kilo";
        String micrometer = PREFIX.sweet_units + "micrometer";
        String jouleSecond = PREFIX.sweet_units + "jouleSecond";
        String joulePerKilogram = PREFIX.sweet_units + "joulePerKilogram";
        String week = PREFIX.sweet_units + "week";
        String joulePerMeterCubedPerKelvin = PREFIX.sweet_units + "joulePerMeterCubedPerKelvin";
        String dimensionlessUnit = PREFIX.sweet_units + "dimensionlessUnit";
        String hour = PREFIX.sweet_units + "hour";
        String coulombPerMeterCubed = PREFIX.sweet_units + "coulombPerMeterCubed";
        String kelvin = PREFIX.sweet_units + "kelvin";
        String ppbv = PREFIX.sweet_units + "ppbv";
        String ppt = PREFIX.sweet_units + "ppt";
        String pascal = PREFIX.sweet_units + "pascal";
        String meterSquaredPerSecond = PREFIX.sweet_units + "meterSquaredPerSecond";
        String ampere = PREFIX.sweet_units + "ampere";
        String perMeter = PREFIX.sweet_units + "perMeter";
        String perTesla = PREFIX.sweet_units + "perTesla";
        String perSecondSquared = PREFIX.sweet_units + "perSecondSquared";
        String terahertz = PREFIX.sweet_units + "terahertz";
        String year = PREFIX.sweet_units + "year";
        String joulePerKilogramPerKelvin = PREFIX.sweet_units + "joulePerKilogramPerKelvin";
        String joulePerMeterSquared = PREFIX.sweet_units + "joulePerMeterSquared";
        String faradPerMeter = PREFIX.sweet_units + "faradPerMeter";
        String meterPerSecondSquared = PREFIX.sweet_units + "meterPerSecondSquared";
        String wattPerMeterSquaredPerKelvin = PREFIX.sweet_units + "wattPerMeterSquaredPerKelvin";
        String henry = PREFIX.sweet_units + "henry";
        String degrees = PREFIX.sweet_units + "degrees";
        String day = PREFIX.sweet_units + "day";
        String siemens = PREFIX.sweet_units + "siemens";
        String siemensPerMeter = PREFIX.sweet_units + "siemensPerMeter";
        String perSecondCubed = PREFIX.sweet_units + "perSecondCubed";
        String meterPerSecond = PREFIX.sweet_units + "meterPerSecond";
        String wattPerMeterSquaredPerSteradianPerWavelength = PREFIX.sweet_units + "wattPerMeterSquaredPerSteradianPerWavelength";
        String normalizedUnit = PREFIX.sweet_units + "normalizedUnit";
        String ppb = PREFIX.sweet_units + "ppb";
        String perMeterCubed = PREFIX.sweet_units + "perMeterCubed";
        String perVolt = PREFIX.sweet_units + "perVolt";
        String meterCubed = PREFIX.sweet_units + "meterCubed";
        String meterCubedPerSecond = PREFIX.sweet_units + "meterCubedPerSecond";
        String kilometer = PREFIX.sweet_units + "kilometer";
        String meterSquared = PREFIX.sweet_units + "meterSquared";
        String lux = PREFIX.sweet_units + "lux";
        String hertz = PREFIX.sweet_units + "hertz";
        String henryPerMeter = PREFIX.sweet_units + "henryPerMeter";
        String perAmpere = PREFIX.sweet_units + "perAmpere";
        String amperePerMeterSquared = PREFIX.sweet_units + "amperePerMeterSquared";
        String ohm = PREFIX.sweet_units + "ohm";
        String coulombMeter = PREFIX.sweet_units + "coulombMeter";
        String wattPerMeterPerKelvin = PREFIX.sweet_units + "wattPerMeterPerKelvin";
        String perMole = PREFIX.sweet_units + "perMole";
        String percent = PREFIX.sweet_units + "percent";
        String tesla = PREFIX.sweet_units + "tesla";
        String meter = PREFIX.sweet_units + "meter";
        String millenium = PREFIX.sweet_units + "millenium";
        String wattPerMeterSquaredPerSteradian = PREFIX.sweet_units + "wattPerMeterSquaredPerSteradian";
        String db = PREFIX.sweet_units + "db";
        String degreeC = PREFIX.sweet_units + "degreeC";
        String arcminute = PREFIX.sweet_units + "arcminute";
        String perCandela = PREFIX.sweet_units + "perCandela";
        String kilogramPerMeterSquared = PREFIX.sweet_units + "kilogramPerMeterSquared";
        String peta = PREFIX.sweet_units + "peta";
        String ratio = PREFIX.sweet_units + "ratio";
        String meterCubedPerKilogram = PREFIX.sweet_units + "meterCubedPerKilogram";
        String farad = PREFIX.sweet_units + "farad";
        String kilogramRadianPerSecond = PREFIX.sweet_units + "kilogramRadianPerSecond";
        String kilogramPerMeterCubed = PREFIX.sweet_units + "kilogramPerMeterCubed";
        String candelaPerMeterSquared = PREFIX.sweet_units + "candelaPerMeterSquared";
        String exa = PREFIX.sweet_units + "exa";
        String meterCubedPerKelvin = PREFIX.sweet_units + "meterCubedPerKelvin";
    }

    interface PROPERTIES {

        interface DATA {

            String hasLocalID = PREFIX.iiotex + "hasLocalID";
        }


        interface OBJECT {

            String hasScale = PREFIX.sweet_mrela + "hasScale";
            String hasAuthenticationData = PREFIX.iiotex + "hasAuthenticationData";
        }


        interface ANNOTATION {

            String hasSymbol = PREFIX.sweet_screla + "hasSymbol";
            String name = PREFIX.foaf + "name";
            String hasScalingNumber = PREFIX.sweet_mrela + "hasScalingNumber";
            String toThePower = PREFIX.sweet_mrela + "toThePower";
            String hasNumericValue = PREFIX.sweet_screla + "hasNumericValue";
            String hasBaseUnit = PREFIX.sweet_screla + "hasBaseUnit";
            String hasShiftingNumber = PREFIX.sweet_mrela + "hasShiftingNumber";
            String ontologyModule = PREFIX.iiot + "ontologyModule";
            String hasOperand = PREFIX.sweet_mrela + "hasOperand";
            String hasPrefix = PREFIX.sweet_screla + "hasPrefix";
        }

    }

}