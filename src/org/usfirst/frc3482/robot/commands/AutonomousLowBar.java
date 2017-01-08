package org.usfirst.frc3482.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousLowBar extends CommandGroup{
	public AutonomousLowBar(){
		addSequential(new MoveIntake(1));
		addSequential(new AutonomousMove(false, 0.5), 3);
		//addSequential(new WaitCommand(2));
		addSequential(new AutonomousMove(false, 0.0), 3);
		
	}
}