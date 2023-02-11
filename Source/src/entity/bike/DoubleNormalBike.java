package entity.bike;

import java.util.ArrayList;

public class DoubleNormalBike extends Bike {

	/**
	 * constructor
	 * 
	 * @param _bike: as Array List String
	 */
	public DoubleNormalBike(ArrayList<String> _bike) {
		super(_bike);
		this.setBikeType(type.valueOf(_bike.get(1)));
	}

	/**
	 * Function to calculate rent cost
	 * 
	 * @param _duration: rent time duration (caculated in minutes)
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
