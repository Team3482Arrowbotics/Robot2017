package org.usfirst.frc3482.robot.subsystems;

import java.util.ArrayList;
import java.util.Collections;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RangeFinder extends Subsystem {
	
	double inches;
	private double scaleFactor; //Volts for 1 inch
	private static AnalogInput rangeFinder; //Actual rangefinder
	public RangeFinder(AnalogInput sensor, double scaleFactor) {
		
		rangeFinder = sensor;
		this.scaleFactor = scaleFactor;
		
	}
	
	public double voltsToInches(){
		double voltage = rangeFinder.getAverageVoltage();
		double voltagePerInch = this.scaleFactor;
		inches = (voltage / voltagePerInch);
		return inches;
		
	}
	
	public double medianInches() {
		double median = 0;
		ArrayList<Double> inchesMed = new ArrayList<Double>();
		for ( int i = 0; i < 27; i ++ ) {
			inchesMed.add(this.voltsToInches());
		}
		Collections.sort(inchesMed, Collections.reverseOrder());
		median = inchesMed.get(13);
		return median;
	}
	protected void initDefaultCommand() {
		
	}

}
