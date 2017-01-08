package org.usfirst.frc3482.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3482.robot.Robot;

public class Drive extends Command {
	public Drive() {
		
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		System.out.println("Driving Bitch");
		Robot.chassis.drive(Robot.oi.getxboxController());
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		Robot.chassis.stop();
	}
	
	protected void interrupted() {
		
	}
}