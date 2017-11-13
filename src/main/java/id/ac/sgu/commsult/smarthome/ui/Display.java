/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nico
 */

package id.ac.sgu.commsult.smarthome.ui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import id.ac.sgu.commsult.smarthome.properties.Properties;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class Display extends javax.swing.JFrame implements ChangeListener {

	private double tempInsideSliderValue;
	private double tempOutsideSliderValue;
	private double windSpeedSliderValue;
	private int timeSliderValue;
	
	public double getTempOutsideSliderValue() {
		return tempOutsideSliderValue;
	}

	public double getTempInsideSliderValue() {
		return tempInsideSliderValue;
	}


	public double getWindSpeedSliderValue() {
		return windSpeedSliderValue;
	}


	public int getTimeSliderValue() {
		return timeSliderValue;
	}

	/**
	 * Creates new form Display
	 */
	public Display() {
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
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		windSpeedLabel = new javax.swing.JLabel();
		tempInsideLabel = new javax.swing.JLabel();
		tempOutsideLabel = new JLabel("0");
		timeLabel = new javax.swing.JLabel();
		acStatusLabel = new javax.swing.JLabel();
		blindsStatusLabel = new javax.swing.JLabel();

		timeSlider = new javax.swing.JSlider(0, 2400, 1200);
		timeSlider.addChangeListener(this);

		tempInsideSlider = new javax.swing.JSlider(0, 50, 25);
		tempInsideSlider.addChangeListener(this);

		tempOutsideSlider = new JSlider(0, 50, 25);
		tempOutsideSlider.addChangeListener(this);
		
		
		
		windSpeedSlider = new javax.swing.JSlider(0, 200, 50);
		windSpeedSlider.addChangeListener(this);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/thermometer.png"))); // NOI18N
		jLabel1.setText("Temperature: ");

		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wind.png"))); // NOI18N
		jLabel2.setText("Wind Speed:");

		jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock.png"))); // NOI18N
		jLabel3.setText("Time:");

		windSpeedLabel.setText("0");

		tempInsideLabel.setText("0");

		timeLabel.setText("00:00");

		acStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AC.png"))); // NOI18N
		acStatusLabel.setText("ON");

		blindsStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blinds.png"))); // NOI18N
		blindsStatusLabel.setText("OPEN");
		
		JLabel lblNewLabel = new JLabel("Inside");
		
		lblOutside = new JLabel("Outside");
		
		
		lblAcTemp = new JLabel("AC TEMP:");
		
		acTempLabel = new JLabel("0");
		
		JCheckBox chckbxLiveMode = new JCheckBox("Live Mode");
		chckbxLiveMode.setSelected(true);
		chckbxLiveMode.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		            Properties.testingMode = false;
		        } else {//checkbox has been deselected
		            Properties.testingMode = true;
		        };
		    }
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGap(18)
					.addComponent(acStatusLabel)
					.addGap(50)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel3)
							.addGap(18)
							.addComponent(timeLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timeSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(tempInsideLabel))
								.addGroup(layout.createSequentialGroup()
									.addComponent(lblOutside)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tempOutsideLabel)))
							.addGap(18)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(tempOutsideSlider, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(tempInsideSlider, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(chckbxLiveMode)
								.addGroup(layout.createSequentialGroup()
									.addComponent(jLabel2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(windSpeedLabel)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(windSpeedSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
					.addGap(122)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(blindsStatusLabel)
						.addGroup(layout.createSequentialGroup()
							.addComponent(lblAcTemp)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(acTempLabel)))
					.addGap(498))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
					.addGap(45)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(11)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
									.addComponent(jLabel3)
									.addComponent(timeLabel))
								.addGroup(layout.createSequentialGroup()
									.addGap(11)
									.addComponent(timeSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(33)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(lblNewLabel)
										.addComponent(tempInsideLabel))
									.addGap(18)
									.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblOutside)
										.addComponent(tempOutsideLabel)))
								.addGroup(layout.createSequentialGroup()
									.addComponent(tempInsideSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(tempOutsideSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addGap(18)
									.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(windSpeedLabel)))
								.addGroup(layout.createSequentialGroup()
									.addGap(29)
									.addComponent(windSpeedSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxLiveMode)
							.addContainerGap())
						.addGroup(layout.createSequentialGroup()
							.addComponent(acStatusLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(acTempLabel)
								.addComponent(lblAcTemp))
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(blindsStatusLabel)
							.addGap(43))))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
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
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Display().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel windSpeedLabel;
	private javax.swing.JLabel tempInsideLabel;
	private javax.swing.JLabel timeLabel;
	private javax.swing.JLabel acStatusLabel;
	private javax.swing.JLabel blindsStatusLabel;
	private javax.swing.JSlider timeSlider;
	private javax.swing.JSlider tempInsideSlider;
	private javax.swing.JSlider windSpeedSlider;
	private JLabel lblOutside;
	private JLabel tempOutsideLabel;
	private JSlider tempOutsideSlider;
	private JLabel lblAcTemp;
	private JLabel acTempLabel;
	// End of variables declaration//GEN-END:variables

	/** Listen to the slider. */
	public void stateChanged(ChangeEvent e) {
		this.timeSliderValue = timeSlider.getValue();
		this.tempInsideSliderValue = tempInsideSlider.getValue();
		this.tempOutsideSliderValue = tempOutsideSlider.getValue();
		this.windSpeedSliderValue = windSpeedSlider.getValue();
		System.out.println("Values: " + timeSliderValue + "," + tempInsideSliderValue + "," + tempOutsideSliderValue + "," + windSpeedSliderValue);
	}

	public void updateInfo(double tempInside, double tempOutside, double acTemp, double windSpeed, int time, boolean acIsOn, boolean blindsIsOpen) {

		tempInsideLabel.setText("" + tempInside);
		tempOutsideLabel.setText("" + tempOutside);
		if(acTemp!=0){			
			acTempLabel.setText("" + acTemp);
		}else{
			acTempLabel.setText("OFF");
		}
		windSpeedLabel.setText("" + windSpeed);
		String timeString = "" + time;
		if (timeString.length() < 3) {
			timeString = "0000";
		} else if (timeString.length() < 4) {
			timeString = "0" + timeString;
		}
		System.out.println(timeString);

		int minute = Integer.parseInt(timeString.substring(2, 4));
		minute = minute * 6 / 10;
		String minuteString = ""+minute;
		if(minuteString.length() < 2){
			minuteString = "0"+minuteString;
		}
		
		String hour = timeString.substring(0, 2);
		timeLabel.setText(hour + ":" + minuteString);

		if (acIsOn) {
			acStatusLabel.setText("ON");
		} else {
			acStatusLabel.setText("OFF");
		}

		if (blindsIsOpen) {
			blindsStatusLabel.setText("OPEN");
		} else {
			blindsStatusLabel.setText("CLOSED");
		}
	}
}
