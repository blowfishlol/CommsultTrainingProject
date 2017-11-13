package id.ac.sgu.commsult.smarthome.sensor;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.*;

public class SensorReader implements Observer {

	private Temperature temperatureOutsideSensor;
	private Temperature temperatureInsideSensor;
	private WindSpeed windSpeedSensor;
	private Time timeSensor;

	private double temperatureOutside;
	private double temperatureInside;
	private double windSpeed;
	private int time;

	public SensorReader() {

		temperatureOutsideSensor = new Temperature(0,'o');
		temperatureOutsideSensor.addObserver(this);
		
		temperatureInsideSensor = new Temperature(0,'i');
		temperatureInsideSensor.addObserver(this);

		windSpeedSensor = new WindSpeed(0);
		windSpeedSensor.addObserver(this);

		timeSensor = new Time(0);
		timeSensor.addObserver(this);

		ExecutorService service = Executors.newFixedThreadPool(4);

		service.execute(new Runnable() {
			public void run() {
				temperatureInsideSensor.run();
			}
		});
		service.execute(new Runnable() {
			public void run() {
				temperatureOutsideSensor.run();
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

	public double getTemperatureOutside() {
		return temperatureOutside;
	}

	public void setTemperatureOutside(double temperatureOutside) {
		this.temperatureOutside = temperatureOutside;
	}

	public double getTemperatureInside() {
		return temperatureInside;
	}

	public void setTemperatureInside(double temperatureInside) {
		this.temperatureInside = temperatureInside;
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
			Temperature temp = (Temperature)o;
			if(temp.getLocation() == 'i'){
				System.out.println("Inside temp update " + arg);
				this.temperatureInside = (Double)arg;
			}else{
				System.out.println("Outside temp update" + arg);
				this.temperatureOutside = (Double)arg;
			}
		}

	}

}
