package controller.calculator;

import controller.calculator.time.Time;
import controller.calculator.time.TimeBuilder;
import controller.calculator.time.TimeConcreteBuilder;
import entity.bike.*;

public class HourBasedStrategy implements CalculatorStrategy {

	@Override
	public int calculateRentBike(Bike bike, Time time) {
		return 10000 * time.getHour();
	}

}
