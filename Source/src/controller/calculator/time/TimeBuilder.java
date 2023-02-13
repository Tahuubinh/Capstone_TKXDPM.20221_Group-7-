package controller.calculator.time;

public interface TimeBuilder {
	TimeBuilder setHour(int hour);

	TimeBuilder setMinute(int minute);

	TimeBuilder setSecond(int second);

	TimeBuilder setTic(int tic);

    Time build();
}
