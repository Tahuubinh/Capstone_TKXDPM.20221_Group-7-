package controller.calculator.time;

public class Time {
	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	private int tic = 0;
	public Time(int hour, int minute, int second, int tic) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.tic = tic;
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	public int getTic() {
		return tic;
	}
	
	
}
