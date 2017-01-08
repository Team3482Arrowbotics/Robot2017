package org.usfirst.frc3482.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3482.robot.subsystems.*;
import org.usfirst.frc3482.robot.*;

public class DownAndSpin extends Command {
	
	int loop;
	boolean finished;
	public DownAndSpin() {
		
	}
	

	protected void initialize() {
		Robot.intake.initializeCounter();
		loop = 0;
	}

	protected void execute() {
		loop ++;
		if (loop < 60) {
			Robot.intake.outtakeBall(); 
			Robot.intake.middleIntake();
			finished = false;
		} else {
			finished = true;
		}
		if (Robot.intake.isSwitchSet()) {
			finished = true;
		}
	}

	protected boolean isFinished() {
		return finished;
	}

	protected void end() {
		Robot.intake.stopIntaking();
		Robot.intake.stopMovingIntake();
		Robot.intake.startPID();
		
	}

	protected void interrupted() {
		end();
	}

}
