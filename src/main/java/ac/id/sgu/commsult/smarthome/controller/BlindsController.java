package ac.id.sgu.commsult.smarthome.controller;

import ac.id.sgu.commsult.smarthome.model.Blinds;

public class BlindsController extends DeviceController{

	private Blinds b;

	public BlindsController() {

		// creating instance AC and off
		b = new Blinds(false);

	}

	public void giveUpdate(double temp, double windSpeed, int time){
		
		if(isWindy(windSpeed) ||  isNight(time) || isHot(temp)){
			b.setOpen(false);
		}
		
	}


	
}
