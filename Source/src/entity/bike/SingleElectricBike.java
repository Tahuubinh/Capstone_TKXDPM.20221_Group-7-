package entity.bike;

import java.util.ArrayList;

public class SingleElectricBike extends Bike {

	// remain battery
	private Double remainBattery;

	// maximum time
	private Double maxTime;

	/**
	 * constructor
	 * 
	 * @param _bike info as Array List String
	 */
	public SingleElectricBike(ArrayList<String> _bike) {
		super(_bike);
		this.setBikeType(type.valueOf(_bike.get(1)));
		this.setMaxTime(Double.parseDouble(_bike.get(6)));
		this.setRemainBattery(Double.parseDouble(_bike.get(5)));
	}

	public Double getRemainBattery() {
		return remainBattery;
	}

	public void setRemainBattery(Double _remainBattery) {
		this.remainBattery = _remainBattery;
	}

	public Double getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(Double _maxTime) {
		this.maxTime = _maxTime;
	}

	@Override
	public ArrayList<String> getBikeInfo() {
		ArrayList<String> result = super.getBikeInfo();
		result.add(String.valueOf(maxTime));
		result.add(String.valueOf(remainBattery));
		return result;
	}

	/**
	 * Function to calculate rent cost
	 * 
	 * @param duration: rent time duration (caculated in minutes)
	 * @return rent cost
	 */
	@Override
	public int caculateRentCost(int _duration) {
		int cost = 10000;
		if (_duration > 30) {
			cost += (int) Math.ceil((float) (_duration - 30) / 15) * 3000;
		}
		cost = cost * 3 / 2;
		return cost;
	}
}
