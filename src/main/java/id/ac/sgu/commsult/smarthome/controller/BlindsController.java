package id.ac.sgu.commsult.smarthome.controller;

import id.ac.sgu.commsult.smarthome.model.Blinds;

public class BlindsController extends DeviceController{

	private Blinds b;

	public BlindsController() {

		// creating instance AC and off
		b = new Blinds(false);

	}

	public void giveUpdate(double tempInside, double tempOutside, double windSpeed, int time){
		
		if(isWindy(windSpeed) ||  isNight(time) || isHot(tempOutside)){
			b.setOpen(false);
		}else{
			b.setOpen(true);
		}
		
	}
	
	public boolean blindsIsOpen(){
		return b.isOpen();
	}


	
}
