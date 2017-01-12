package org.usfirst.frc3482.robot.commands;

import org.usfirst.frc3482.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class TimedFeed extends TimedCommand{

	public TimedFeed(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(){
		Robot.intake.startFeed();
	}
	
	public void end(){
		Robot.intake.stopFeed();
	}

}
