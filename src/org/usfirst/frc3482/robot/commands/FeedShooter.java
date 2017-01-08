package org.usfirst.frc3482.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3482.robot.subsystems.*;
import org.usfirst.frc3482.robot.*;

import edu.wpi.first.wpilibj.DigitalInput;

public class FeedShooter extends Command {

	boolean direction;
	public FeedShooter() {
		//requires(Robot.chassis);
		//requires(Robot.shooter);
		direction = true;
	}
	
	public FeedShooter(boolean direction) {
		this.direction = direction;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		
		if (direction)
		{
			Robot.intake.startFeed();
		} else {
			Robot.intake.reverseFeed();
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.intake.stopFeed();
	}

	protected void interrupted() {
		end();
	}

}
