package org.usfirst.frc3482.robot.subsystems;

import org.usfirst.frc3482.robot.Robot;
import org.usfirst.frc3482.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem implements PIDOutput {

	private final CANTalon frontLeft = RobotMap.frontLeft;
	private final CANTalon backLeft = RobotMap.backLeft;
	private final CANTalon frontRight = RobotMap.frontRight;
	private final CANTalon backRight = RobotMap.backRight;
	private final RobotDrive robotDrive = RobotMap.driveRobot;

	double turnSpeed = -0.75;
	// private double drivePercent;

	public void invertMotors() {
		// robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		// robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		// robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		// robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	}

	public void drive(Joystick s) {
		double deadZone = 0.1;
		double leftY = s.getRawAxis(1);
		double rightX = s.getRawAxis(4);

		if (leftY < deadZone && leftY > -deadZone) {
			leftY = 0;
		}
		if (rightX < deadZone && rightX > -deadZone) {
			rightX = 0;
		}
		if (leftY == 0 && rightX == 0) {
			return;
		}
		if (Robot.oi.xboxController.getRawAxis(2) != 0) {
			robotDrive.arcadeDrive(-(leftY * 0.5), rightX * turnSpeed * 0.75);
		} else {
			robotDrive.arcadeDrive(-(leftY), rightX * turnSpeed);
		}
		// robotDrive.arcadeDrive(-(leftY*getDrivePercent()), rightX*turnSpeed);
	}

	public void stop() {
		robotDrive.stopMotor();
	}

	protected void initDefaultCommand() {

	}

	@Override
	public void pidWrite(double output) {

	}
}