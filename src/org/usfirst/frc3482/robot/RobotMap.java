package org.usfirst.frc3482.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

public class RobotMap {
	public static CANTalon frontLeft;
	public static CANTalon backLeft;
	public static CANTalon frontRight;
	public static CANTalon backRight;
	public static RobotDrive driveRobot;
	public static Relay feedShooter;
	public static CANTalon intakeBall;
	public static DigitalInput limitSwitch;
	public static CANTalon shootBall;
	public static CANTalon raiseIntake;
	public static CANTalon intake;
	public static Timer timer;
	public static AnalogInput leftRF;
//	public static AnalogInput rightRF;
	
	
	public static void init() {
		
		timer = new Timer();
		
		frontLeft = new CANTalon(0);
		backLeft = new CANTalon(8);
		frontRight = new CANTalon(2);
		backRight = new CANTalon(3);
		driveRobot = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		
		feedShooter = new Relay(0);
		
		intakeBall = new CANTalon(7);
		raiseIntake = new CANTalon(5);
		
		limitSwitch = new DigitalInput(2);
		
		shootBall = new CANTalon(4);
		
		leftRF = new AnalogInput(0);
//		rightRF = new AnalogInput(1);
	}
}