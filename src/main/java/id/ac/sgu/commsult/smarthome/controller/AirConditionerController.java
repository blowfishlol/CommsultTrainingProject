package id.ac.sgu.commsult.smarthome.controller;
import id.ac.sgu.commsult.smarthome.model.*;

public class AirConditionerController extends DeviceController{

	AirConditioner ac;
	
	public AirConditionerController(){
		
		//creating instance AC and off
		ac = new AirConditioner(false);
		
	}
	
	public void giveUpdate(double tempInside, double tempOutside, double windSpeed, int time){
		
		double temp = (tempInside+tempOutside)/2;
		
		if(isHot(temp)){
			// gets the distance from 30 degree, then divide it to 20 (range of 30 - 50, the range of temperature that the AC will turn on)
			//times 5 
			//if temp = 31, then AC temperature is 20 + ((31-30)/20)*5 = 20 + (1/20) * 5
			double acTempOffset = ( (temp-30.0) / 20.0 ) * 5;
			ac.setAirConditionerTemperature(20 + acTempOffset);
			ac.setOn(true);
		}else{
			ac.setAirConditionerTemperature(0);
			ac.setOn(false);
		}
		
	}


	public boolean airConditionerIsOn(){
		return ac.isOn();
	}
	
	public double getAirConditionerTemperature(){
		return ac.getAirConditionerTemperature();
	}
}
