package org.usfirst.frc3482.robot.commands;

import org.usfirst.frc3482.robot.Robot;
import org.usfirst.frc3482.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Straighten extends Command{

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		if(Robot.rangeFinderLeft.medianInches() > Robot.rangeFinderRight.medianInches()){
			RobotMap.frontLeft.set(0.5);
			RobotMap.backLeft.set(0.5);
			RobotMap.frontRight.set(0.5);
			RobotMap.backRight.set(0.5);
		} else if(Robot.rangeFinderRight.medianInches() > Robot.rangeFinderLeft.medianInches()){
			RobotMap.frontLeft.set(-0.5);
			RobotMap.backLeft.set(-0.5);
			RobotMap.frontRight.set(-0.5);
			RobotMap.backRight.set(-0.5);
		}
		while(!(Math.abs(Robot.rangeFinderLeft.medianInches()-4) <= Robot.rangeFinderRight.medianInches())){
		
		}
		RobotMap.frontLeft.set(0.0);
		RobotMap.backLeft.set(0.0);
		RobotMap.frontRight.set(0.0);
		RobotMap.backRight.set(0.0);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
