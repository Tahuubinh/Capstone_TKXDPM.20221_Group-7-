package controller.calculator;

import controller.calculator.time.Time;
import entity.bike.Bike;

public class RentFee {
	private CalculatorStrategy calculatorStrategy;
	
	public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }
	
	public int calculateFee(Bike bike, Time time) {
		return calculatorStrategy.calculateRentBike(bike, time);
	}
	
}
