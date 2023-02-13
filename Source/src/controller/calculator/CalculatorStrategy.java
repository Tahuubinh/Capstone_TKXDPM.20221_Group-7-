package controller.calculator;

import controller.calculator.time.Time;
import controller.calculator.time.TimeBuilder;
import entity.bike.*;

public interface CalculatorStrategy {
	public int calculateRentBike(Bike bike, Time time);
}
