package id.ac.sgu.commsult.smarthome.model;

public class AirConditioner {

	private boolean isOn;
	private double acTemperature;
	
	public double getAirConditionerTemperature() {
		return acTemperature;
	}
	public void setAirConditionerTemperature(double acTemperature) {
		this.acTemperature = acTemperature;
	}
	public AirConditioner(boolean isOn) {
		this.isOn = isOn;
	}
	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	
	
	
	
}
