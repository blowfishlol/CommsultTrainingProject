package id.ac.sgu.commsult.smarthome.sensor;

import java.util.Observable;
import java.util.Random;

import id.ac.sgu.commsult.smartphone.properties.Properties;

public class Time extends Observable implements Runnable {
	private int time = 0;

	Time(int time) {
		super();
		this.time = time;
	}

	public void run() {
		Thread thread = new Thread();
		thread.start();
		try {
			setTime(0);
			while (true) {
				if (!Properties.testingMode) {
					refresh();
				}
				thread.sleep(Properties.SLEEP_TIME);
			}
		} catch (Exception e) {
		}
	}

	// get a new value for time and notifying observer
	public void refresh() {
		// System.out.println("Time: " + getTime());
		if (time == 2400) {
			setTime(0);
		} else {
			setTime(time + 100);
		}
		setChanged();
		notifyObservers(time);
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
		setChanged();
		notifyObservers(time);
	}

}
