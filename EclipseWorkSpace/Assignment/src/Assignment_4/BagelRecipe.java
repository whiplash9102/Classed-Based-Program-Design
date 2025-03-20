package Assignment_4;

public class BagelRecipe {
	public double flour;
	public double water;
	public double yeast;
	public double salt;
	public double malt;

	private void validateRecipe() {
		if (flour != water) {
			throw new IllegalArgumentException("Flour and water must be in equal weight");
		}
		if (yeast != malt) {
			throw new IllegalArgumentException("Yeast and malt must be in equal weight");
		}
		if (Math.abs((salt + yeast) - (flour / 20.0)) > 0.0001) {
			throw new IllegalArgumentException("The combination must be equal 1/20 flour ");
		}
	}

	BagelRecipe(double flour, double water, double yeast, double salt, double malt) {
		this.flour = flour;
		this.water = water;
		this.yeast = yeast;
		this.salt = salt;
		this.malt = malt;
		validateRecipe();
	}

	// Constructor using only flour and yeast
	BagelRecipe(double flour, double yeast) {
		this(flour, flour, yeast, (flour / 20) - yeast, flour);
		validateRecipe();
	}

	BagelRecipe(double flourCups, double teaSpoons, double saltSpoons) {
		double flour = flourCups * 4.25;
		double water = flour;
		double yeast = (teaSpoons / 48.0) * 5.0;
		double salt = (saltSpoons / 48.0) * 10.0;
		double malt = yeast;

		if (Math.abs((salt + yeast) - (flour / 20.0)) > 0.0001) {
			throw new IllegalArgumentException("The combination must be equal 1/20 flour");
		}
		this.flour = flour;
		this.water = water;
		this.yeast = yeast;
		this.salt = salt;
		this.malt = malt;
	}

	public boolean sameRecipe(BagelRecipe other) {
		return Math.abs(this.flour - other.flour) <= 0.0001 &&
				Math.abs(this.water - other.water) <= 0.0001 &&
				Math.abs(this.yeast - other.yeast) <= 0.0001 &&
				Math.abs(this.salt - other.salt) <= 0.0001 && 
				Math.abs(this.malt - other.malt) <= 0.0001;
	}
}
