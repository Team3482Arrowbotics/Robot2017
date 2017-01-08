package org.usfirst.frc3482.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {

	private CameraServer server;
	public Camera() {
		server = CameraServer.getInstance();
		server.setQuality(100);
//		server.startAutomaticCapture();
	}
	
	public void drawImageToDashboard(){
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
