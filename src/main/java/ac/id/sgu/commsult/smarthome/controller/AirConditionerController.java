package ac.id.sgu.commsult.smarthome.controller;
import ac.id.sgu.commsult.smarthome.model.*;

public class AirConditionerController extends DeviceController{

	AirConditioner ac;
	
	public AirConditionerController(){
		
		//creating instance AC and off
		ac = new AirConditioner(false);
		
	}
	
	public void giveUpdate(double temp, double windSpeed, int time){
		
		if(isHot(temp)){
			ac.setOn(true);
		}else{
			ac.setOn(false);
		}
		
	}


}
