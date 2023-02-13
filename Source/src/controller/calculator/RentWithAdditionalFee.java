package controller.calculator;

import controller.calculator.time.Time;
import controller.calculator.time.TimeBuilder;
import entity.bike.*;

public class RentWithAdditionalFee implements CalculatorStrategy {

	@Override
	public int calculateRentBike(Bike bike, Time time) {
		return 200000 + (time.getHour() * 60 + time.getMinute()) / 15 * 2000;
	}

}
