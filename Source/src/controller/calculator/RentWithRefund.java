package controller.calculator;

import entity.bike.*;

public class RentWithRefund implements Calculator {

	@Override
	public int calculateRentBike(Bike bike, int time) {
		return 200000 - (12 - time) * 10000;
	}

}
