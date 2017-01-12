
package org.usfirst.frc3482.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc3482.robot.commands.*;
import org.usfirst.frc3482.robot.subsystems.*;
import edu.wpi.first.wpilibj.DigitalInput;
public class OI {

	public Joystick xboxController;
	public JoystickButton startFeedButton;
	public JoystickButton reverseFeedButton;
	public Joystick joystick;
	public JoystickButton spinIntakeButton;
	public JoystickButton spinOuttakeButton;
	public JoystickButton startShooterButton;
	public JoystickButton raiseIntakeButton;
	public JoystickButton lowerIntakeButton;
	public JoystickButton straightenButton;
	public JoystickButton getRFVoltage;
	public JoystickButton portCullis;
	public JoystickButton downAndSpin;
	public JoystickButton test;
	public JoystickButton manualIntake;
	public JoystickButton test1;
	
	public OI() {
		xboxController = new Joystick(2);
		joystick = new Joystick(1);
		
		//straightenButton = new JoystickButton(joystick, 4);
		//straightenButton.whenPressed(new Straighten());
		
		//test = new JoystickButton(joystick, 12);
		//test.whenPressed(new AutonomousLowBar());
		
		test1 = new JoystickButton(joystick, 11);
	    test1.whileHeld(new TimedFeed(100));
	    
		startFeedButton = new JoystickButton(joystick, 1);
		startFeedButton.whileHeld(new FeedShooter(true));
		
		reverseFeedButton = new JoystickButton(joystick, 12);
		reverseFeedButton.whileHeld(new FeedShooter(false));
		
		//spinOuttakeButton = new JoystickButton(joystick, 5);
		//spinOuttakeButton.whileHeld(new SpinIntake(true));
		
		//spinIntakeButton = new JoystickButton(joystick, 6);
		//spinIntakeButton.whenPressed(new SpinIntake(false));
		
		startShooterButton = new JoystickButton(joystick, 2);
		startShooterButton.whileHeld(new Shoot());
		
		//raiseIntakeButton = new JoystickButton(joystick, 10);
		//raiseIntakeButton.whileHeld(new MoveIntake(0));
		
		//downAndSpin = new JoystickButton(joystick, 7);
		//downAndSpin.whileHeld(new DownAndSpin());
		
		//lowerIntakeButton = new JoystickButton(joystick, 9);
		//lowerIntakeButton.whileHeld(new MoveIntake(1));
		
		getRFVoltage = new JoystickButton(joystick, 4);
		getRFVoltage.whenPressed(new RangeRetrieve());
		
		//portCullis = new JoystickButton(joystick, 8);
		//portCullis.whileHeld(new Portcullis()); 
		
		//manualIntake = new JoystickButton(joystick, 3);
		//manualIntake.whileHeld(new ManualIntake());
		
	}
	public Joystick getxboxController() {
		return xboxController;
	}
	
	public Joystick getJoystick() {
		return joystick;
	}
}