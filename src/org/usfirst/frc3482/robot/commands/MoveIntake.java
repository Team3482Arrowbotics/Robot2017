package org.usfirst.frc3482.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3482.robot.subsystems.*;
import org.usfirst.frc3482.robot.*;

public class MoveIntake extends Command {
	boolean finish;
	int direction;
	public MoveIntake() {
		finish = false;
		direction = 0;
	}
	
	public MoveIntake(int direction) {
		this.direction = direction;
	}

	protected void initialize() {
		Robot.intake.stopPID();
	}

	protected void execute() {
		System.out.println("Before Position: " + Robot.intake.getRestPosition());
		if (direction == 0) {
			Robot.intake.raiseIntake();
		} else if (direction == 1)  {
			Robot.intake.middleIntake();
		} else {
			Robot.intake.lowerIntake();
		}
		finish = true;
	}

	protected boolean isFinished() {
		return finish;
	}

	protected void end() {
		Robot.intake.stopMovingIntake();
		System.out.println("After Position: " + Robot.intake.getRestPosition());
		Robot.intake.startPID();
	}

	protected void interrupted() {
		end();
	}

}
