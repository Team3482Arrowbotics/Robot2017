package org.usfirst.frc3482.robot.commands;
import org.usfirst.frc3482.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinFeedIn extends Command
{
	protected void initialize()
	{
		
	}
	
	protected void execute()
	{
		Robot.intake.startFeed();
	}
	

	@Override
	protected boolean isFinished() {
		
		return false;
	}
	
	protected void end()
	{
		Robot.intake.stopFeed();
	}
}
