package telran.measure;

public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), M(1_000), KM(1_000_000);

	float value;

	LengthUnit(float value) {
		this.value = value;
	}

	// returns Length object as length between l1 and l2 in "this" units
	// Example: LengthUnit.M.between (new Length(200, LengthUnit.CM), new Length(1,
	// LengthUnit.M))
	// returns Length(1, LengthUnit.M)

	public Length between(Length l1, Length l2) {
		l1 = l1.convert(this);
		l2 = l2.convert(this);

		return new Length(Math.abs(l1.getAmount() - l2.getAmount()), this);
	}

	public float getValue() {
		return value;
	}
}
