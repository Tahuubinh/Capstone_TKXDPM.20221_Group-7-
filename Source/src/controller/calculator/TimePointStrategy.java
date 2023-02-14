package controller.calculator;

import controller.calculator.time.Time;
import controller.calculator.time.TimeBuilder;
import controller.calculator.time.TimeConcreteBuilder;
import entity.bike.*;

public class TimePointStrategy implements CalculatorStrategy {

	@Override
	public int calculateRentBike(Bike bike, Time time) {
		if (time.getHour() < 12) {
			return 200000 - (12 - time.getHour()) * 10000;
		}
		if (time.getHour() > 24) {
			return 200000 + ((time.getHour() - 24) * 60 + time.getMinute()) / 15 * 2000;
		}
		return 200000;
	}

}
