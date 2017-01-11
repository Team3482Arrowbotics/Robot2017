package org.usfirst.frc3482.robot.commands;

import org.usfirst.frc3482.robot.Robot;
import org.usfirst.frc3482.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shoot extends Command {
	
	public Shoot() {
	}

	protected void initialize() { 
	}

	protected void execute() {
		if ( RobotMap.raiseIntake.getPosition() != Robot.intake.getLowerPosition() ) {
			Robot.intake.middleIntake();
		}
		Robot.shooter.startShooter();
		double velocity = RobotMap.shootBall.getSpeed();
		SmartDashboard.putNumber("Shooter speed:  ", velocity);
		if (velocity > 80000) {
			Robot.shooter.rumbleController();
		} 
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.shooter.stopShooter();
		//Robot.shooter.stopRumble();
		
	}

	protected void interrupted() {
		end();
		Robot.shooter.stopRumble();
	}
	
}
