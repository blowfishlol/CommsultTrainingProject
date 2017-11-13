package id.ac.sgu.commsult.smarthome.controller;

import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.commsult.smarthome.sensor.SensorReader;
import id.ac.sgu.commsult.smarthome.ui.Display;
import id.ac.sgu.commsult.smartphone.properties.Properties;

public class MainController implements Controller {

	private AirConditionerController acc;
	private BlindsController bc;
	private SensorReader sr;
	private Display disp;
	// flag to check if the controller should update or not
	private boolean flag = true;

	public MainController() {

		acc = new AirConditionerController();
		bc = new BlindsController();
		sr = new SensorReader();
		disp = new Display();
		disp.setVisible(true);
		// gets the sensor reader values and send to air conditioner and blinds
		// controller
		try {
			Thread.sleep(20);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (flag) {
			try {
				Thread.sleep(Properties.SLEEP_TIME);
				giveUpdate(sr.getTemperatureInside(), sr.getTemperatureOutside(), sr.getWindSpeed(), sr.getTime());

				System.out.print("\nAC status: ");
				if (acc.airConditionerIsOn()) {
					System.out.print("On -- Temperature: " + acc.getAirConditionerTemperature());
				} else {
					System.out.print("Off");
				}

				System.out.print("\nBlinds status: ");
				if (bc.blindsIsOpen()) {
					System.out.print("Open");
				} else {
					System.out.print("Closed");
				}
				double averageTemperature =(sr.getTemperatureInside()+ sr.getTemperatureOutside())/2.0;
				disp.updateInfo(averageTemperature, sr.getWindSpeed(), sr.getTime(), acc.airConditionerIsOn(), bc.blindsIsOpen());
				
				System.out.println("\n-----------------------");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void giveUpdate(double tempInside, double tempOutside, double windSpeed, int time) {

		acc.giveUpdate(tempInside, tempOutside, windSpeed, time);
		bc.giveUpdate(tempInside, tempOutside, windSpeed, time);

	}

}
