package id.ac.sgu.commsult.smarthome.controller;

public abstract class DeviceController implements Controller{

	public boolean isHot(double temp){
		return temp > 30;
	}
	
	public boolean isWarm(double temp){
		return temp > 20 && temp <= 30;
	}
	
	public boolean isCold(double temp){
		return temp <= 20;
	}
	
	public boolean isWindy(double windSpeed){
		return windSpeed > 100;
	}
	
	public boolean isNight(int time){
		return time >= 1900 || time < 400;
	}
	
}
