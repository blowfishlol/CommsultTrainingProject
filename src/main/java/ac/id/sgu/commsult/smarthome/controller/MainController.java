package ac.id.sgu.commsult.smarthome.controller;

import java.util.Observable;
import java.util.Observer;

import ac.id.sgu.commsult.smarthome.sensor.SensorReader;

public class MainController implements Controller{
	
	private AirConditionerController acc;
	private BlindsController bc;
	private SensorReader sr;
	//flag to check if the controller should update or not
	private boolean flag = true;
	
	public MainController(){
		
		acc = new AirConditionerController();
		bc = new BlindsController();
		sr = new SensorReader();
		
		//gets the sensor reader values and send to air conditioner and blinds controller
		try {
			Thread.sleep(20);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(flag){
			try {
				Thread.sleep(5000);
				giveUpdate(sr.getTemperature(),sr.getWindSpeed(), sr.getTime());

				if(acc.airConditionerIsOn()){
					System.out.println("AC is On");
				}else{
					System.out.println("AC is Off");
				}
				
				if(bc.blindsIsOpen()){
					System.out.println("Blinds is open");
				}else{
					System.out.println("Blinds is closed");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void giveUpdate(double temp, double windSpeed, int time){
		
		acc.giveUpdate(temp, windSpeed, time);
		bc.giveUpdate(temp, windSpeed, time);
		
	}

	
}
