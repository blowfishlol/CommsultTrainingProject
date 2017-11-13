package id.ac.sgu.commsult.smarthome.sensor;

import java.util.Observable;
import java.util.Random;

import id.ac.sgu.commsult.smarthome.properties.Properties;

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
				if(!Properties.testingMode){
					refresh();					
				}
				thread.sleep(Properties.SLEEP_TIME);
			}
		} catch (Exception e) {
		}
	}

	//get new wind speed and notifying observer
	public void refresh(){
		Random rand = new Random();
		setWind(rand.nextInt(200) + 0);
		//System.out.println("Wind Speed: " + getWind());
	}
	
	public double getWind() {
		return windSpeed;
	}

	public void setWind(double windSpeed) {
		this.windSpeed = windSpeed;
		setChanged();
		notifyObservers(windSpeed);
	}

}
