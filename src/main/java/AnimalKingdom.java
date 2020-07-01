
public class AnimalKingdom {
	HumanBeing being;
	Fish fish;
	String landOrWaterAnimal;

	AnimalKingdom(HumanBeing being, Fish fish) {
		this.being = being;
		this.fish = fish;
	}

	public String get(String landOrWaterAnimal) {
		this.landOrWaterAnimal = landOrWaterAnimal;
		System.out.println("Animal of " + landOrWaterAnimal);
		phyiscalContext();
		return landOrWaterAnimal;
	}

	public void phyiscalContext() {

		if (landOrWaterAnimal.equals("land")) {
			this.being.classAnimal();
			this.being.hasEars();
			this.being.hasNose();
			this.being.isMamal();
			this.being.hasEars();
		} else if (landOrWaterAnimal.equals("water")) {
			this.fish.classAnimal();
			this.fish.hasEars();
			this.fish.hasFins();
			this.fish.hasEyes();
			this.fish.isMamal();
		}
	}

	public static void main(String[] args) {
		AnimalKingdom animalKingdom = new AnimalKingdom(new HumanBeing(), new Fish());
		animalKingdom.get("water");

	}
}

class HumanBeing {

	public void classAnimal() {
		System.out.println("Human Being");

	}

	public void isMamal() {
		System.out.println("land mamal..");
	}

	public void hasEyes() {
		System.out.println("has two eyes..");
	}

	public void hasNose() {
		System.out.println("has 1 noes..");
	}

	public void hasEars() {
		System.out.println("has two ears..");
	}
}

class Fish {
	public void classAnimal() {
		System.out.println("Fish::");

	}

	public void isMamal() {
		System.out.println("Water mamal..");
	}

	public void hasEyes() {
		System.out.println("has two eyes..");
	}

	public void hasFins() {
		System.out.println("has fins");
	}

	public void hasEars() {
		System.out.println("has No ears..");
	}
}
