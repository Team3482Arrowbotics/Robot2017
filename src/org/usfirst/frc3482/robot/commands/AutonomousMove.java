package org.usfirst.frc3482.robot.commands;

import org.usfirst.frc3482.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousMove extends Command{
	
	boolean direction;
	double speed;
	
	public AutonomousMove(boolean direction, double speed){
		this.direction = direction;
		this.speed = speed;
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		if(direction){ //intake first
			RobotMap.frontLeft.set(-speed); 
			RobotMap.frontRight.set(speed);
			RobotMap.backLeft.set(-speed);
			RobotMap.backRight.set(speed);
		} else{
			RobotMap.frontLeft.set(speed); 
			RobotMap.frontRight.set(-speed);
			RobotMap.backLeft.set(speed);
			RobotMap.backRight.set(-speed);
		}
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		RobotMap.frontLeft.set(0); 
		RobotMap.frontRight.set(0);
		RobotMap.backLeft.set(0);
		RobotMap.backRight.set(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
