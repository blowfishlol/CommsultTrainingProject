package id.ac.sgu.commsult.smarthome.sensor;

import java.util.Observable;
import java.util.Random;

import id.ac.sgu.commsult.smarthome.properties.Properties;

public class Temperature extends Observable implements Runnable {

	private double temp = 0;
	private char location;

	Temperature(double temp, char location) {
		super();
		this.temp = temp;
		this.location = location;
	}

	public void run() {

		Thread thread = new Thread();
		thread.start();
		try {
			while (true) {

				if (!Properties.testingMode) {
					refresh();
				}
				thread.sleep(Properties.SLEEP_TIME);
			}
		} catch (Exception e) {
		}
	}

	public void refresh() {
		Random rand = new Random();
		setTemp(rand.nextInt(40) + 0);
		// System.out.println("Temperature: " + getTemp());
		setChanged();
		notifyObservers(temp);
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public char getLocation() {
		return location;
	}

	public void setLocation(char location) {
		this.location = location;
		setChanged();
		notifyObservers();
	}

}
