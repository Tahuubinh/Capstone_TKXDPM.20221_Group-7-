package controller.calculator;

import entity.bike.*;

public class RentNoRefund implements Calculator {

	@Override
	public int calculateRentBike(Bike bike, int time) {
		return 200000;
	}

}
