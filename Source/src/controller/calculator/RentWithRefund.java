package controller.calculator;

import controller.calculator.time.Time;
import controller.calculator.time.TimeBuilder;
import entity.bike.*;

public class RentWithRefund implements CalculatorStrategy {

	@Override
	public int calculateRentBike(Bike bike, Time time) {
		return 200000 - (12 - time.getHour()) * 10000;
	}

}
