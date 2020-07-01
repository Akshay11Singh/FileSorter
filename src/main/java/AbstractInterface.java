
public class AbstractInterface {

}

interface car {

	void carName();

	void carCountry();
}

abstract class CarAbstract implements car {

	public void MyCarAbstract() {
		System.out.println("In MyCarAbstract ");
	}

	@Override
	public void carName() {
		// TODO Auto-generated method stub

	}
}

class CarAbstractImpl extends CarAbstract {

	@Override
	public void carCountry() {
		// TODO Auto-generated method stub

	}

}