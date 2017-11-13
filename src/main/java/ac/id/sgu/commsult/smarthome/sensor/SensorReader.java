package ac.id.sgu.commsult.smarthome.sensor;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.*;

public class SensorReader implements Observer {

	private Temperature temperatureSensor;
	private WindSpeed windSpeedSensor;
	private Time timeSensor;

	private double temperature;
	private double windSpeed;
	private int time;

	public SensorReader() {

		temperatureSensor = new Temperature(0);
		temperatureSensor.addObserver(this);

		windSpeedSensor = new WindSpeed(0);
		windSpeedSensor.addObserver(this);

		timeSensor = new Time(0);
		timeSensor.addObserver(this);

		ExecutorService service = Executors.newFixedThreadPool(4);

		service.execute(new Runnable() {
			public void run() {
				temperatureSensor.run();
			}
		});
		service.execute(new Runnable() {
			public void run() {
				windSpeedSensor.run();
			}
		});
		service.execute(new Runnable() {
			public void run() {
				timeSensor.run();
			}
		});

		// System.out.println("AAA"+temperature.getTemp());

	}

	/*
	 * Setter and getters for private variables
	 */
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	

	// receives update from sensors, then assigning value
	public void update(Observable o, Object arg) {
		// System.out.print("Update!");
		if (o instanceof Time) {
			System.out.println("Time update " + arg);
			this.time = (Integer) arg;
		} else if (o instanceof WindSpeed) {
			System.out.println("Wind update " + arg);
			this.windSpeed = (Double) arg;
		} else if (o instanceof Temperature) {
			System.out.println("Temp update " + arg);
			this.temperature = (Double) arg;
		}

	}

}
