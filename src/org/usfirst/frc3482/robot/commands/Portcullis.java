package org.usfirst.frc3482.robot.commands;

import org.usfirst.frc3482.robot.Robot;
import org.usfirst.frc3482.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Portcullis extends Command {
	
	boolean finito = false;
	public Portcullis() {
		
	}
	
	protected void initialize() {
//		Robot.intake.stopPID();
	}

	protected void execute() {		
		Robot.intake.lowerIntake();
	}

	protected boolean isFinished() {
		return finito;
	}

	protected void end() {
		Robot.intake.raiseIntake();
		finito = true;
		
	}

	protected void interrupted() {
		end();
	}

}
