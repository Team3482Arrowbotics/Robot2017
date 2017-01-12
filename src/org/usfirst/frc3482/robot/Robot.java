package org.usfirst.frc3482.robot;

import java.awt.Image;

import org.usfirst.frc3482.robot.commands.AutonomousCharge;
import org.usfirst.frc3482.robot.commands.AutonomousLowBar;
import org.usfirst.frc3482.robot.commands.Drive;
import org.usfirst.frc3482.robot.subsystems.Camera;
import org.usfirst.frc3482.robot.subsystems.Chassis;
import org.usfirst.frc3482.robot.subsystems.Intake;
import org.usfirst.frc3482.robot.subsystems.RangeFinder;
import org.usfirst.frc3482.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
		
	Command teleopCommand;
	Command autonomousCommand;
	
	int autoLoop = 0;
	
	public static OI oi;
	public static Chassis chassis;
	public static Intake intake;
	public static Shooter shooter;
	public static RangeFinder rangeFinderLeft;
	public static RangeFinder rangeFinderRight;
	public static Camera camera;
	public static Image frame;
	public static int session;
	
	public static SendableChooser autoChooser;	
		
	public void robotInit() {
		RobotMap.init();
		chassis = new Chassis();
		intake = new Intake();
		shooter = new Shooter();
		camera = new Camera();
		
		rangeFinderLeft = new RangeFinder(RobotMap.leftRF, .0098);
//		rangeFinderRight = new RangeFinder(RobotMap.rightRF, .0098);
		
		oi = new OI();
		
		autoChooser = new SendableChooser();
		teleopCommand = new Drive();
		
		//set range finder average and oversample bits
		RobotMap.leftRF.setAverageBits(6);
		RobotMap.leftRF.setOversampleBits(4);
//		RobotMap.rightRF.setAverageBits(6);
//		RobotMap.rightRF.setOversampleBits(4);
		
		
		autoChooser.addObject("CHARGE", new AutonomousCharge());
		autoChooser.addObject("Low Bar", new AutonomousLowBar());
		SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);

//		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_HSL, 0);
//
//        // the camera name (ex "cam0") can be found through the roborio web interface
//        session = NIVision.IMAQdxOpenCamera("cam0",
//                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
//        NIVision.IMAQdxConfigureGrab(session);
		
		
		
	}
	
	public void disabledInit() {
		
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		//NIVision.IMAQdxStartAcquisition(session);
		autonomousCommand = (CommandGroup) autoChooser.getSelected();
		System.out.println("AUTO INIT");
    	
        if (autonomousCommand != null) autonomousCommand.start();
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		Robot.intake.maintainPosition();    
		/*autoLoop ++;
		SmartDashboard.putNumber("AutoLoop: ", autoLoop);
		//Robot.intake.middleIntake();
		if (autoLoop < 500) {
			
			RobotMap.frontLeft.set(-0.5); 
			RobotMap.frontRight.set(0.5);
			RobotMap.backLeft.set(-0.5);
			RobotMap.backRight.set(0.5);
		}
		else if (autoLoop >= 500){
			RobotMap.frontLeft.set(0.0);
			RobotMap.frontRight.set(0.0);
			RobotMap.backLeft.set(0.0);
			RobotMap.backRight.set(0.0);
		}*/
	}
	
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		System.out.println("Teleop initialized");
		Robot.intake.stopPID();
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//Robot.oi.xboxController.setRumble(RumbleType.kLeftRumble, 1);
		Robot.chassis.drive(Robot.oi.getxboxController());
		SmartDashboard.putNumber("Distance (left)", rangeFinderLeft.medianInches());
		//SmartDashboard.putNumber("Distance (right)", rangeFinderRight.medianInches());
		Robot.intake.maintainPosition();
	}
	
	public void testPeriodic() {
		
	}
}