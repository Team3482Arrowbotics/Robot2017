
package org.usfirst.frc3482.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3482.robot.subsystems.*;
import org.usfirst.frc3482.robot.*;

public class SpinIntake extends Command {
	
	int loop;
	boolean finished;
	boolean direction;
	public SpinIntake() {
		direction = true;
	}
	
	public SpinIntake(boolean direction){
		this.direction = direction;
	}
	
	protected void initialize() {
		Robot.intake.initializeCounter();
		loop = 0;
	}

	protected void execute() {
		loop ++;
		if (loop < 80) {
			if (direction) {
				Robot.intake.startIntake();
				Robot.intake.reverseFeed();
			} else {
				Robot.intake.outtakeBall();
				//Robot.intake.startFeed();
				if (Robot.intake.isSwitchSet()) {
					finished = true;
				}
			}
			finished = false;
		} else {
			finished = true;
		}
		
	}

	protected boolean isFinished() {
		return finished;
	}

	protected void end() {
		Robot.intake.stopIntaking();
		Robot.intake.stopFeed();
		
	}

	protected void interrupted() {
		end();
	}

}
