package org.usfirst.frc3482.robot.commands;

import org.usfirst.frc3482.robot.Robot;
import org.usfirst.frc3482.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3482.robot.subsystems.*;

public class RangeRetrieve extends Command {
	
	protected void initialize() {
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		//double inches = Robot.rangeFinder.voltsToInches();
		double inches = Robot.rangeFinderLeft.medianInches();
		System.out.println("Distance: " + inches);
		//if ( inches > )
		return true;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		//Robot.intake.stopFeed();
	}

}
