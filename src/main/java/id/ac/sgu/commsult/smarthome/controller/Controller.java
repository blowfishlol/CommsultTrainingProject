package id.ac.sgu.commsult.smarthome.controller;

public interface Controller {

	public void giveUpdate(double tempInside, double tempOutside, double windSpeed, int time);
	
}
