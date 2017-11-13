package id.ac.sgu.commsult.smarthome.controller;

import id.ac.sgu.commsult.smarthome.ui.Display;

public class DisplayController {

	Display disp;
	
	public DisplayController(){
		disp = new Display();
		//initNimbus();
		disp.setVisible(true);
	}
	
	public void updateInfo(double insideTemp, double outsideTemp, double acTemp,double windSpeed, int time, boolean acIsOn, boolean blindsIsOpen){
		
		disp.updateInfo(insideTemp,outsideTemp, acTemp, windSpeed, time, acIsOn, blindsIsOpen);
		
	}
	
	public double getTempInsideSliderValue(){
		return disp.getTempInsideSliderValue();
	}
	
	public double getTempOutsideSliderValue(){
		return disp.getTempOutsideSliderValue();
	}
	
	public double getWindSpeedSliderValue(){
		return disp.getWindSpeedSliderValue();
	}
	
	public int getTimeSliderValue(){
		return disp.getTimeSliderValue();
	}
	
	public void initNimbus(){
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}
	
}
