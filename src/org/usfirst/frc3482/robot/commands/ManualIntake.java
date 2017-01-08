	package org.usfirst.frc3482.robot.commands;

import org.usfirst.frc3482.robot.Robot;
import org.usfirst.frc3482.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManualIntake extends Command {

	boolean finished = false;
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Robot.intake.stopPID();
		double rawAxis = (Robot.oi.joystick.getRawAxis(1));
		double sliderAxis = Robot.oi.joystick.getRawAxis(3);
		double adjustIntakeSpeed;
		if ( sliderAxis >= 0.5 ) {
			adjustIntakeSpeed = 0.8;
		} else {
			adjustIntakeSpeed = 0.4;
		}
		RobotMap.raiseIntake.changeControlMode(TalonControlMode.PercentVbus);
		RobotMap.raiseIntake.set(rawAxis * adjustIntakeSpeed);
		SmartDashboard.putNumber("JAxis", rawAxis);
		SmartDashboard.putNumber("PID : ", RobotMap.raiseIntake.pidGet());	
		// DO THIS
		// RobotMap.raiseIntake.get
	} 

	@Override
	protected boolean isFinished() {
		return finished;
	}

	@Override
	protected void end() {
		/*if(RobotMap.raiseIntake.getPosition() <= Robot.intake.getStartPosition()){
			Robot.intake.raiseIntake();
		} else{
			Robot.intake.stopMovingIntake();
		}*/
	}

	@Override
	protected void interrupted() {
		Robot.intake.setRestPosition(RobotMap.raiseIntake.getPosition());
		Robot.intake.startPID();
		
		finished = true;
	}

}
