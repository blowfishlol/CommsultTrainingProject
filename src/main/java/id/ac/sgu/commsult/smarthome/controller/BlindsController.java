package id.ac.sgu.commsult.smarthome.controller;

import id.ac.sgu.commsult.smarthome.model.Blinds;

public class BlindsController extends DeviceController{

	private Blinds b;

	public BlindsController() {

		// creating instance AC and off
		b = new Blinds(false);

	}

	public void giveUpdate(double tempInside, double tempOutside, double windSpeed, int time){
		
		double tempAverage = (tempInside+tempOutside)/2;
		
		if(isWindy(windSpeed) ||  isNight(time) || isHot(tempAverage)){
			b.setOpen(false);
		}else{
			b.setOpen(true);
		}
		
	}
	
	public boolean blindsIsOpen(){
		return b.isOpen();
	}


	
}
