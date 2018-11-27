package eu.interiot.message.payload;

import eu.interiot.message.ID.EntityID;
import eu.interiot.message.MessagePayload;
import eu.interiot.message.managers.type.TypeManagerGOIoTP;
import eu.interiot.message.payload.types.*;
import org.apache.jena.rdf.model.Model;

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


public class GOIoTPPayload extends MessagePayload {

    public GOIoTPPayload() {
        this(false);
    }

    public GOIoTPPayload(boolean useRDFSInferencer) {
        super(useRDFSInferencer);
    }

    public GOIoTPPayload(Model jenaModel) {
        this(jenaModel, false);
    }

    public GOIoTPPayload(Model jenaModel, boolean useRDFSInferencer) {
        super(jenaModel, useRDFSInferencer);
    }


    public GOIoTPPayload(MessagePayload payload) {
        super(payload.getJenaModel(), payload.usesInferencer());
    }

    /**
     * Returns true if an entity is asserted in this payload to be of a given type, or any of its supertypes
     *
     * @param entityID ID of an entity
     * @param typeID   type of an entity
     * @return true if {@code entityID} is of type {@code typeID}
     */
    public boolean isEntityOfTypeInferred(EntityID entityID, EntityID typeID) {
        for (EntityID entityTypeID : getEntityTypes(entityID)) {
            if (TypeManagerGOIoTP.getAllTypes(entityTypeID).contains(typeID))
                return true;
        }

        return false;
    }

    /**
     * Returns a set of EntityIDs that identify types of an entity (individual) in this payload.
     * The return set includes supertypes of explicitly asserted types.
     *
     * @param entityID An identifier of an entity that is a typed individual
     * @return set of types of entity with {@code entityID} that are asserted in this payload
     */
    public Set<EntityID> getEntityTypesInferred(EntityID entityID) {
        Set<EntityID> allTypes = getEntityTypes(entityID);
        for (EntityID explicitType : getEntityTypes(entityID)) {
            allTypes.addAll(TypeManagerGOIoTP.getSupertypeSet(explicitType));
        }

        return allTypes;
    }

    //*****     GOIoTP     *****

    public OntologyPayload asOntologyPayload() {
        return new OntologyPayload(getJenaModel(), usesInferencer());
    }

    public LocationPayload asLocationPayload() {
        return new LocationPayload(getJenaModel(), usesInferencer());
    }

    public DomainOfInterestPayload asDomainOfInterestPayload() {
        return new DomainOfInterestPayload(getJenaModel(), usesInferencer());
    }

    public GeometryPayload asGeometryPayload() {
        return new GeometryPayload(getJenaModel(), usesInferencer());
    }

    public PlatformPayload asPlatformPayload() {
        return new PlatformPayload(getJenaModel(), usesInferencer());
    }

    public PlatformComponentPayload asPlatformComponentPayload() {
        return new PlatformComponentPayload(getJenaModel(), usesInferencer());
    }

    public MiddlewarePayload asMiddlewarePayload() {
        return new MiddlewarePayload(getJenaModel(), usesInferencer());
    }

    public SpatialObjectPayload asSpatialObjectPayload() {
        return new SpatialObjectPayload(getJenaModel(), usesInferencer());
    }

    public SemanticsPayload asSemanticsPayload() {
        return new SemanticsPayload(getJenaModel(), usesInferencer());
    }

    public MeasurementKindPayload asMeasurementKindPayload() {
        return new MeasurementKindPayload(getJenaModel(), usesInferencer());
    }

    public ObservationPayload asObservationPayload() {
        return new ObservationPayload(getJenaModel(), usesInferencer());
    }

    public SoftwarePlatformPayload asSoftwarePlatformPayload() {
        return new SoftwarePlatformPayload(getJenaModel(), usesInferencer());
    }

    public ServicePayload asServicePayload() {
        return new ServicePayload(getJenaModel(), usesInferencer());
    }

    public VocabularyPayload asVocabularyPayload() {
        return new VocabularyPayload(getJenaModel(), usesInferencer());
    }

    public SystemPayload asSystemPayload() {
        return new SystemPayload(getJenaModel(), usesInferencer());
    }

    public PersonPayload asPersonPayload() {
        return new PersonPayload(getJenaModel(), usesInferencer());
    }

    public SensorPayload asSensorPayload() {
        return new SensorPayload(getJenaModel(), usesInferencer());
    }

    public UserPayload asUserPayload() {
        return new UserPayload(getJenaModel(), usesInferencer());
    }

    public IoTDevicePayload asIoTDevicePayload() {
        return new IoTDevicePayload(getJenaModel(), usesInferencer());
    }

    public UnitPayload asUnitPayload() {
        return new UnitPayload(getJenaModel(), usesInferencer());
    }

    public ResultPayload asResultPayload() {
        return new ResultPayload(getJenaModel(), usesInferencer());
    }

    public PropertyPayload asPropertyPayload() {
        return new PropertyPayload(getJenaModel(), usesInferencer());
    }

    public FeatureOfInterestPayload asFeatureOfInterestPayload() {
        return new FeatureOfInterestPayload(getJenaModel(), usesInferencer());
    }

    //*****     GOIoTP     *****


    public CurrentDensityPayload asCurrentDensityPayload() {
        return new CurrentDensityPayload(getJenaModel(), usesInferencer());
    }

    public LuminousIntensityPayload asLuminousIntensityPayload() {
        return new LuminousIntensityPayload(getJenaModel(), usesInferencer());
    }

    public HeatFluxDensityPayload asHeatFluxDensityPayload() {
        return new HeatFluxDensityPayload(getJenaModel(), usesInferencer());
    }

    public SpecificHeatCapacityPayload asSpecificHeatCapacityPayload() {
        return new SpecificHeatCapacityPayload(getJenaModel(), usesInferencer());
    }

    public SolidAnglePayload asSolidAnglePayload() {
        return new SolidAnglePayload(getJenaModel(), usesInferencer());
    }

    public DynamicViscosityPayload asDynamicViscosityPayload() {
        return new DynamicViscosityPayload(getJenaModel(), usesInferencer());
    }

    public KermaPayload asKermaPayload() {
        return new KermaPayload(getJenaModel(), usesInferencer());
    }

    public ComplexUnitPayload asComplexUnitPayload() {
        return new ComplexUnitPayload(getJenaModel(), usesInferencer());
    }

    public EnergyDensityPayload asEnergyDensityPayload() {
        return new EnergyDensityPayload(getJenaModel(), usesInferencer());
    }

    public UnitDefinedByProductPayload asUnitDefinedByProductPayload() {
        return new UnitDefinedByProductPayload(getJenaModel(), usesInferencer());
    }

    public OpenIoTPayload asOpenIoTPayload() {
        return new OpenIoTPayload(getJenaModel(), usesInferencer());
    }

    public ElectricconductancePayload asElectricconductancePayload() {
        return new ElectricconductancePayload(getJenaModel(), usesInferencer());
    }

    public AreaPayload asAreaPayload() {
        return new AreaPayload(getJenaModel(), usesInferencer());
    }

    public MolarEnergyPayload asMolarEnergyPayload() {
        return new MolarEnergyPayload(getJenaModel(), usesInferencer());
    }

    public CapacitancePayload asCapacitancePayload() {
        return new CapacitancePayload(getJenaModel(), usesInferencer());
    }

    public VolumePayload asVolumePayload() {
        return new VolumePayload(getJenaModel(), usesInferencer());
    }

    public HeatCapacityPayload asHeatCapacityPayload() {
        return new HeatCapacityPayload(getJenaModel(), usesInferencer());
    }

    public AngularVelocityPayload asAngularVelocityPayload() {
        return new AngularVelocityPayload(getJenaModel(), usesInferencer());
    }

    public LuminancePayload asLuminancePayload() {
        return new LuminancePayload(getJenaModel(), usesInferencer());
    }

    public ElectricResistancePayload asElectricResistancePayload() {
        return new ElectricResistancePayload(getJenaModel(), usesInferencer());
    }

    public ElectricChargeDensityPayload asElectricChargeDensityPayload() {
        return new ElectricChargeDensityPayload(getJenaModel(), usesInferencer());
    }

    public MagneticFieldStrengthPayload asMagneticFieldStrengthPayload() {
        return new MagneticFieldStrengthPayload(getJenaModel(), usesInferencer());
    }

    public DoseEquivalentPayload asDoseEquivalentPayload() {
        return new DoseEquivalentPayload(getJenaModel(), usesInferencer());
    }

    public LengthPayload asLengthPayload() {
        return new LengthPayload(getJenaModel(), usesInferencer());
    }

    public MomentOfForcePayload asMomentOfForcePayload() {
        return new MomentOfForcePayload(getJenaModel(), usesInferencer());
    }

    public WaveNumberPayload asWaveNumberPayload() {
        return new WaveNumberPayload(getJenaModel(), usesInferencer());
    }

    public InductancePayload asInductancePayload() {
        return new InductancePayload(getJenaModel(), usesInferencer());
    }

    public MassPayload asMassPayload() {
        return new MassPayload(getJenaModel(), usesInferencer());
    }

    public ForcePayload asForcePayload() {
        return new ForcePayload(getJenaModel(), usesInferencer());
    }

    public CatalyticActivityConcentrationPayload asCatalyticActivityConcentrationPayload() {
        return new CatalyticActivityConcentrationPayload(getJenaModel(), usesInferencer());
    }

    public PermittivityPayload asPermittivityPayload() {
        return new PermittivityPayload(getJenaModel(), usesInferencer());
    }

    public VelocityPayload asVelocityPayload() {
        return new VelocityPayload(getJenaModel(), usesInferencer());
    }

    public WidthPayload asWidthPayload() {
        return new WidthPayload(getJenaModel(), usesInferencer());
    }

    public SIBaseMKPayload asSIBaseMKPayload() {
        return new SIBaseMKPayload(getJenaModel(), usesInferencer());
    }

    public SpecificEnergyPayload asSpecificEnergyPayload() {
        return new SpecificEnergyPayload(getJenaModel(), usesInferencer());
    }

    public WSO2Payload asWSO2Payload() {
        return new WSO2Payload(getJenaModel(), usesInferencer());
    }

    public SIDerivedMKPayload asSIDerivedMKPayload() {
        return new SIDerivedMKPayload(getJenaModel(), usesInferencer());
    }

    public PermeabilityPayload asPermeabilityPayload() {
        return new PermeabilityPayload(getJenaModel(), usesInferencer());
    }

    public EnergyPayload asEnergyPayload() {
        return new EnergyPayload(getJenaModel(), usesInferencer());
    }

    public OneM2MPayload asOneM2MPayload() {
        return new OneM2MPayload(getJenaModel(), usesInferencer());
    }

    public SIDerivedSpecialMKPayload asSIDerivedSpecialMKPayload() {
        return new SIDerivedSpecialMKPayload(getJenaModel(), usesInferencer());
    }

    public ElectricPotentialDifferencePayload asElectricPotentialDifferencePayload() {
        return new ElectricPotentialDifferencePayload(getJenaModel(), usesInferencer());
    }

    public IlluminancePayload asIlluminancePayload() {
        return new IlluminancePayload(getJenaModel(), usesInferencer());
    }

    public PlaneAnglePayload asPlaneAnglePayload() {
        return new PlaneAnglePayload(getJenaModel(), usesInferencer());
    }

    public ElectricChargePayload asElectricChargePayload() {
        return new ElectricChargePayload(getJenaModel(), usesInferencer());
    }

    public ThermalConductivityPayload asThermalConductivityPayload() {
        return new ThermalConductivityPayload(getJenaModel(), usesInferencer());
    }

    public AbsorbedDoseRatePayload asAbsorbedDoseRatePayload() {
        return new AbsorbedDoseRatePayload(getJenaModel(), usesInferencer());
    }

    public ElectricCurrentPayload asElectricCurrentPayload() {
        return new ElectricCurrentPayload(getJenaModel(), usesInferencer());
    }

    public MassFractionPayload asMassFractionPayload() {
        return new MassFractionPayload(getJenaModel(), usesInferencer());
    }

    public SurfaceTensionPayload asSurfaceTensionPayload() {
        return new SurfaceTensionPayload(getJenaModel(), usesInferencer());
    }

    public BaseUnitPayload asBaseUnitPayload() {
        return new BaseUnitPayload(getJenaModel(), usesInferencer());
    }

    public LogarithmicScalePayload asLogarithmicScalePayload() {
        return new LogarithmicScalePayload(getJenaModel(), usesInferencer());
    }

    public UniversAALPayload asUniversAALPayload() {
        return new UniversAALPayload(getJenaModel(), usesInferencer());
    }

    public RayExposurePayload asRayExposurePayload() {
        return new RayExposurePayload(getJenaModel(), usesInferencer());
    }

    public MolarEntropyPayload asMolarEntropyPayload() {
        return new MolarEntropyPayload(getJenaModel(), usesInferencer());
    }

    public LogarithmicUnitPayload asLogarithmicUnitPayload() {
        return new LogarithmicUnitPayload(getJenaModel(), usesInferencer());
    }

    public AngularAccelerationPayload asAngularAccelerationPayload() {
        return new AngularAccelerationPayload(getJenaModel(), usesInferencer());
    }

    public EclipseOM2MPayload asEclipseOM2MPayload() {
        return new EclipseOM2MPayload(getJenaModel(), usesInferencer());
    }

    public ElectricFieldStrengthPayload asElectricFieldStrengthPayload() {
        return new ElectricFieldStrengthPayload(getJenaModel(), usesInferencer());
    }

    public LuminousFluxPayload asLuminousFluxPayload() {
        return new LuminousFluxPayload(getJenaModel(), usesInferencer());
    }

    public AuthenticationDataPayload asAuthenticationDataPayload() {
        return new AuthenticationDataPayload(getJenaModel(), usesInferencer());
    }

    public SIDerivedSpecialInclusiveMKPayload asSIDerivedSpecialInclusiveMKPayload() {
        return new SIDerivedSpecialInclusiveMKPayload(getJenaModel(), usesInferencer());
    }

    public PrefixPayload asPrefixPayload() {
        return new PrefixPayload(getJenaModel(), usesInferencer());
    }

    public CatalyticActivityPayload asCatalyticActivityPayload() {
        return new CatalyticActivityPayload(getJenaModel(), usesInferencer());
    }

    public AccelerationPayload asAccelerationPayload() {
        return new AccelerationPayload(getJenaModel(), usesInferencer());
    }

    public SpecificVolumePayload asSpecificVolumePayload() {
        return new SpecificVolumePayload(getJenaModel(), usesInferencer());
    }

    public ElectricFluxDensityPayload asElectricFluxDensityPayload() {
        return new ElectricFluxDensityPayload(getJenaModel(), usesInferencer());
    }

    public PowerPayload asPowerPayload() {
        return new PowerPayload(getJenaModel(), usesInferencer());
    }

    public HeightPayload asHeightPayload() {
        return new HeightPayload(getJenaModel(), usesInferencer());
    }

    public MassDensityPayload asMassDensityPayload() {
        return new MassDensityPayload(getJenaModel(), usesInferencer());
    }

    public MeasurementPayload asMeasurementPayload() {
        return new MeasurementPayload(getJenaModel(), usesInferencer());
    }

    public RadiantIntensityPayload asRadiantIntensityPayload() {
        return new RadiantIntensityPayload(getJenaModel(), usesInferencer());
    }

    public ProductPayload asProductPayload() {
        return new ProductPayload(getJenaModel(), usesInferencer());
    }

    public TemperaturePayload asTemperaturePayload() {
        return new TemperaturePayload(getJenaModel(), usesInferencer());
    }

    public AmountOfSubstanceConcentrationPayload asAmountOfSubstanceConcentrationPayload() {
        return new AmountOfSubstanceConcentrationPayload(getJenaModel(), usesInferencer());
    }

    public FIWAREPayload asFIWAREPayload() {
        return new FIWAREPayload(getJenaModel(), usesInferencer());
    }

    public DistancePayload asDistancePayload() {
        return new DistancePayload(getJenaModel(), usesInferencer());
    }

    public AzurePayload asAzurePayload() {
        return new AzurePayload(getJenaModel(), usesInferencer());
    }

    public MagneticFluxPayload asMagneticFluxPayload() {
        return new MagneticFluxPayload(getJenaModel(), usesInferencer());
    }

    public PressurePayload asPressurePayload() {
        return new PressurePayload(getJenaModel(), usesInferencer());
    }

    public ActivityOfRadionuclidePayload asActivityOfRadionuclidePayload() {
        return new ActivityOfRadionuclidePayload(getJenaModel(), usesInferencer());
    }

    public UnitDerivedByShiftingPayload asUnitDerivedByShiftingPayload() {
        return new UnitDerivedByShiftingPayload(getJenaModel(), usesInferencer());
    }

    public TimePayload asTimePayload() {
        return new TimePayload(getJenaModel(), usesInferencer());
    }

    public UnitDerivedByRaisingToPowerPayload asUnitDerivedByRaisingToPowerPayload() {
        return new UnitDerivedByRaisingToPowerPayload(getJenaModel(), usesInferencer());
    }

    public DepthPayload asDepthPayload() {
        return new DepthPayload(getJenaModel(), usesInferencer());
    }

    public AmountOfSubstancePayload asAmountOfSubstancePayload() {
        return new AmountOfSubstancePayload(getJenaModel(), usesInferencer());
    }

    public UnitDerivedByScalingPayload asUnitDerivedByScalingPayload() {
        return new UnitDerivedByScalingPayload(getJenaModel(), usesInferencer());
    }

    public FrequencyPayload asFrequencyPayload() {
        return new FrequencyPayload(getJenaModel(), usesInferencer());
    }

    public RadiancePayload asRadiancePayload() {
        return new RadiancePayload(getJenaModel(), usesInferencer());
    }

    public MagneticFluxDensityPayload asMagneticFluxDensityPayload() {
        return new MagneticFluxDensityPayload(getJenaModel(), usesInferencer());
    }

    //*****     SOSA     *****

    public ActuatorPayload asActuatorPayload() {
        return new ActuatorPayload(getJenaModel(), usesInferencer());
    }

    public ActuatablePropertyPayload asActuatablePropertyPayload() {
        return new ActuatablePropertyPayload(getJenaModel(), usesInferencer());
    }

    public ProcedurePayload asProcedurePayload() {
        return new ProcedurePayload(getJenaModel(), usesInferencer());
    }

    public SamplePayload asSamplePayload() {
        return new SamplePayload(getJenaModel(), usesInferencer());
    }

    public SamplerPayload asSamplerPayload() {
        return new SamplerPayload(getJenaModel(), usesInferencer());
    }

    public ObservablePropertyPayload asObservablePropertyPayload() {
        return new ObservablePropertyPayload(getJenaModel(), usesInferencer());
    }

    public TemporalEntityPayload asTemporalEntityPayload() {
        return new TemporalEntityPayload(getJenaModel(), usesInferencer());
    }

    public AgentPayload asAgentPayload() {
        return new AgentPayload(getJenaModel(), usesInferencer());
    }

    public ActuationPayload asActuationPayload() {
        return new ActuationPayload(getJenaModel(), usesInferencer());
    }

    public SamplingPayload asSamplingPayload() {
        return new SamplingPayload(getJenaModel(), usesInferencer());
    }

    //*****     SSN     *****


    public ThingPayload asThingPayload() {
        return new ThingPayload(getJenaModel(), usesInferencer());
    }

    public DeploymentPayload asDeploymentPayload() {
        return new DeploymentPayload(getJenaModel(), usesInferencer());
    }

    public InputPayload asInputPayload() {
        return new InputPayload(getJenaModel(), usesInferencer());
    }

    public OutputPayload asOutputPayload() {
        return new OutputPayload(getJenaModel(), usesInferencer());
    }

    public StimulusPayload asStimulusPayload() {
        return new StimulusPayload(getJenaModel(), usesInferencer());
    }

}