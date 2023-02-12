package controller;


public class DHBG implements Runnable{
	
	private static int tic = 0;
	private static int sec = 0;
	private static int min = 0;
	private static int hour = 0;
	private static boolean runtime = false;
	private Thread runTimer;
	
	
	@Override
	public void run() {
		try {
			while(runtime) {
				tic ++;
				if (tic == 100) {
					sec ++;
					tic = 0;
				}
				if (sec == 60) {
					min ++;
					sec = 0;
				}
				if (min == 60) {
					hour ++;
					min = 0;
				}
				Thread.sleep(8);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void Start() {
		runtime = true;
		runTimer = new Thread(this);
		runTimer.start();
	}
	
	public void Stop() {
		runtime = false;
	}
	
	public void Reset() {
		tic = 0;
		sec = 0;
		min = 0; 
		hour = 0;
	}
	
	public String show() {
		return hour + ":" + min + ":" + sec;
	}
	
	public int money() {
		return min * 5000;
	}
	
}

