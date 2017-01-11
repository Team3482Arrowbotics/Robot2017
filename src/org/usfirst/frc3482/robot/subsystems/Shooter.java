package org.usfirst.frc3482.robot.subsystems;

import org.usfirst.frc3482.robot.Robot;
import org.usfirst.frc3482.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private final CANTalon shoot = RobotMap.shootBall;
	
	public void startShooter() {
		shoot.set(1.0);
	}
	
	public void startShooterSlow(){
		shoot.set(0.1);
	}
	
	public void stopShooter() {
		shoot.set(0.0);
	}
	
	public void rumbleController() {
		Robot.oi.xboxController.setRumble(RumbleType.kLeftRumble, 1);
	}
	
	public void stopRumble() {
		Robot.oi.xboxController.setRumble(RumbleType.kLeftRumble, 0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
