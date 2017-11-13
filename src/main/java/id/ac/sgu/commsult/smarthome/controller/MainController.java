package id.ac.sgu.commsult.smarthome.controller;

import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.commsult.smarthome.properties.Properties;
import id.ac.sgu.commsult.smarthome.sensor.SensorReader;
import id.ac.sgu.commsult.smarthome.ui.Display;

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
				if(!Properties.testingMode){	
					
					//updates to controllers with value from sensor
					giveUpdate(sr.getTemperatureInside(), 
							sr.getTemperatureOutside(), 
							sr.getWindSpeed(), 
							sr.getTime());
					
					double averageTemperature = (sr.getTemperatureInside() + sr.getTemperatureOutside()) / 2.0;
					
					//updates to display with values from sensor
					disp.updateInfo(averageTemperature, 
							sr.getWindSpeed(), 
							sr.getTime(), 
							acc.airConditionerIsOn(),
							bc.blindsIsOpen());
				}else{
					
					//Updates to controller with value from slider
					giveUpdate(disp.getTempSliderValue(), 
							disp.getTempSliderValue(), 
							disp.getWindSpeedSliderValue(), 
							disp.getTimeSliderValue());
					
					//updates to display with value from slider
					disp.updateInfo(disp.getTempSliderValue(), 
							disp.getWindSpeedSliderValue(), 
							disp.getTimeSliderValue(), 
							acc.airConditionerIsOn(),
							bc.blindsIsOpen());
				}
				//PRINT TO CONSOLE
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
