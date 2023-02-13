package controller.calculator.time;

public class TimeConcreteBuilder implements TimeBuilder {
	
	private int hour;
	private int minute;
	private int second;
	private int tic;

	@Override
	public TimeBuilder setHour(int hour) {
		this.hour = hour;
		return this;
	}

	@Override
	public TimeBuilder setMinute(int minute) {
		this.minute = minute;
		return this;
	}

	@Override
	public TimeBuilder setSecond(int second) {
		this.second = second;
		return this;
	}

	@Override
	public TimeBuilder setTic(int tic) {
		this.tic = tic;
		return this;
	}

	@Override
	public Time build() {
		return new Time(hour, minute, second, tic);
	}

}
