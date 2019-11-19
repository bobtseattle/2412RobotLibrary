package com.robototes.units;

public class UnitTypes {

	/**
	 * 
	 * @author OroArmor
	 *
	 * @param <T> The Unit type
	 */
	public interface IUnitType<T extends IUnitType<?>> {
		/**
		 * 
		 * @return The label of the unit
		 */
		String getUnit();

		/**
		 * 
		 * @return the ratio from this unit to the main unit of the enum
		 */
		UnitRatio<?> getRatio();

		/**
		 * 
		 * @param other The other unit
		 * @return Finds the ratio between two unitss
		 */
		UnitRatio<?> getRatio(T other);

		/**
		 * 
		 * @return The main unit of the unit type
		 */
		T getMainUnit();
	}

	/**
	 * List of different distance units
	 * 
	 * @author OroArmor
	 *
	 */
	public static enum DistanceUnits implements IUnitType<DistanceUnits> {
		METER(1, "m"), CENTIMETER(1d / 100d, METER, "cm"), INCH(2.54d, CENTIMETER, "in"), FEET(12d, INCH, "ft");

		private double conversionValue;
		private String unitName;

		DistanceUnits(double conversionValue, String unitName) {
			this.conversionValue = conversionValue;
			this.unitName = unitName;
		}

		DistanceUnits(double conversionValue, DistanceUnits extendRatio, String unitName) {
			this.conversionValue = conversionValue * extendRatio.conversionValue;
			this.unitName = unitName;
		}

		public double getConversionValue() {
			return conversionValue;
		}

		@Override
		public String getUnit() {
			return unitName;
		}

		@Override
		public UnitRatio<Distance> getRatio() {
			return new UnitRatio<Distance>(conversionValue, getUnit(), "m");
		}

		@Override
		public UnitRatio<Distance> getRatio(DistanceUnits other) {
			return new UnitRatio<Distance>(getRatio(), (UnitRatio<Distance>) other.getRatio().getInverseRatio());
		}

		@Override
		public DistanceUnits getMainUnit() {
			return METER;
		}

	}

	/**
	 * List of different time units
	 * 
	 * @author OroArmor
	 *
	 */
	public static enum TimeUnits implements IUnitType<TimeUnits> {
		SECOND(1, "s"), MILLISECOND(1d / 1000d, SECOND, "ms"), MINUTE(60, SECOND, "min");

		private double conversionValue;
		private String unitName;

		TimeUnits(double conversionValue, String unitName) {
			this.conversionValue = conversionValue;
			this.unitName = unitName;
		}

		TimeUnits(double conversionValue, TimeUnits extendRatio, String unitName) {
			this.conversionValue = conversionValue * extendRatio.conversionValue;
			this.unitName = unitName;
		}

		public double getConversionValue() {
			return conversionValue;
		}

		@Override
		public String getUnit() {
			return unitName;
		}

		@Override
		public UnitRatio<Time> getRatio() {
			return new UnitRatio<Time>(conversionValue, getUnit(), "s");
		}

		@Override
		public UnitRatio<Time> getRatio(TimeUnits other) {
			return new UnitRatio<Time>(getRatio(), (UnitRatio<Time>) other.getRatio().getInverseRatio());
		}

		@Override
		public TimeUnits getMainUnit() {
			return SECOND;
		}

	}

	/**
	 * List of different rotation/angle units
	 * 
	 * @author OroArmor
	 *
	 */
	public static enum RotationUnits implements IUnitType<RotationUnits> {
		ROTATIONS(1, "rot"), DEGREE(1d / 360d, ROTATIONS, "deg"), RADIAN(2d * Math.PI, ROTATIONS, "rad");

		private double conversionValue;
		private String unitName;

		RotationUnits(double conversionValue, String unitName) {
			this.conversionValue = conversionValue;
			this.unitName = unitName;
		}

		RotationUnits(double conversionValue, RotationUnits extendRatio, String unitName) {
			this.conversionValue = conversionValue * extendRatio.conversionValue;
			this.unitName = unitName;
		}

		public double getConversionValue() {
			return conversionValue;
		}

		@Override
		public String getUnit() {
			return unitName;
		}

		@Override
		public UnitRatio<Rotations> getRatio() {
			return new UnitRatio<Rotations>(conversionValue, getUnit(), "rot");
		}

		@Override
		public UnitRatio<Rotations> getRatio(RotationUnits other) {
			return new UnitRatio<Rotations>(getRatio(), (UnitRatio<Rotations>) (other.getRatio()).getInverseRatio());
		}

		@Override
		public RotationUnits getMainUnit() {
			return ROTATIONS;
		}

	}

}