package telran.measure;

public class Length implements Comparable<Length> {
	private float amount;
	private LengthUnit lenghtUnit;

	public Length(float amount, LengthUnit lenghtUnit) {
		this.amount = amount;
		this.lenghtUnit = lenghtUnit;
	}

	/**
	 * equals two Length objects according to LengthUnit 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		return compareTo((Length) obj) == 0;
	}

	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit convert(LengthUnit.M)
	 *         returns Length in meters
	 */
	public Length convert(LengthUnit unit) {
		return new Length(this.getUnit().getValue() * getAmount() / unit.getValue(), unit);
	}

	public float getAmount() {
		return amount;
	}

	public String toString() {
		return Float.toString(getAmount()) + this.getUnit().toString();
	}

	public LengthUnit getUnit() {
		return lenghtUnit;
	}

	@Override
	public int compareTo(Length o) {
		return Float.compare(getAmount(), o.convert(getUnit()).getAmount());
	}
}
