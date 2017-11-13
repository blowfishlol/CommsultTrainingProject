package ac.id.sgu.commsult.smarthome.sensor;

import java.util.Observable;
import java.util.Random;

public class WindSpeed extends Observable implements Runnable {
	private double windSpeed = 0;

	WindSpeed(double windSpeed) {
		super();
		this.windSpeed = windSpeed;
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

	//get new wind speed and notifying observer
	public void refresh(){
		Random rand = new Random();
		setWind(rand.nextInt(40) + 0);
		//System.out.println("Wind Speed: " + getWind());
		setChanged();
		notifyObservers(windSpeed);
	}
	
	public double getWind() {
		return windSpeed;
	}

	public void setWind(double windSpeed) {
		this.windSpeed = windSpeed;
	}

}
