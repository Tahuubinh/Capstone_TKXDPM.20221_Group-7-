package entity.bike;

import java.util.ArrayList;

public class SingleNormalBike extends Bike {

	/**
	 * constructor
	 * 
	 * @param bike information as Array List String
	 */
	public SingleNormalBike(ArrayList<String> _bike) {
		super(_bike);
		this.setBikeType(type.valueOf(_bike.get(7)));
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
		return cost;
	}
}
