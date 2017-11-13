package ac.id.sgu.commsult.smarthome.sensor;

import java.util.Observable;
import java.util.Random;

public class Temperature extends Observable implements Runnable {
	private double temp = 0;

	Temperature(double temp) {
		super();
		this.temp = temp;
	}

	public void run() {

		Thread thread = new Thread();
		thread.start();
		try {
			while (true) {

				refresh();
				thread.sleep(5000);
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

}
