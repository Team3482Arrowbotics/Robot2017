package org.usfirst.frc3482.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousCharge extends CommandGroup{
	public AutonomousCharge(){
		addSequential(new AutonomousMove(true, 1.0), 2);
		//addSequential(new WaitCommand(2000));
		addSequential(new AutonomousMove(true, 0.0), 10);
	}
}

