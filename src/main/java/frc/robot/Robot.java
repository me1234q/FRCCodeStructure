package frc.robot;

import edu.wpi.first.wpilibj.*;
import frc.robot.controllers.RobotController;
import frc.robot.util.*;
import frc.robot.controllers.*;
import frc.robot.shuffleboard.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
  // public RobotController robotController;

  // public double origTime;
  // public double robotStartTime;

  public TalonFX left1, left2, right1, right2;

  Joystick joy;

  Compressor c;

  DoubleSolenoid ds;

  public boolean shiftState;

  @Override
  public void robotInit() {
    // Context.robotController = new RobotController();
    // robotStartTime = System.currentTimeMillis()/1000.0;
  }

  @Override
  public void robotPeriodic() {
    
  }

  @Override
  public void autonomousInit() {
    // origTime = System.currentTimeMillis();
    // Context.robotController.autoDrive.startSpline();
  }

  @Override
  public void autonomousPeriodic() {
    //Context.robotController.autoDrive.loop((System.currentTimeMillis() - origTime)/1000);
  }

  @Override
  public void teleopInit() {
    // Context.robotController.drivetrain.resetEncoders();
    Dashboard.init();
  }
  
  @Override
  public void teleopPeriodic()
  {

    Dashboard.update();
  //   double driverThrottle = -Context.robotController.driverJoystick.getThrottle();
  //   double driverYaw = -Context.robotController.driverJoystick.getYaw();

  //   if(Context.robotController.driverJoystick.getJoystick().getRawButtonPressed(4))
  //   {
  //     if(Context.robotController.visionAllignment.isActive()){
  //       Context.robotController.visionAllignment.stopTrack();
  //     } else {
  //       Context.robotController.visionAllignment.startTrack();
  //     }
  //   }

  //   if(Context.robotController.driverJoystick.isInUse() || !Context.robotController.visionAllignment.isActive())
  //   {
  //     Context.robotController.visionAllignment.stopTrack();
  //     Context.robotController.drivetrain.arcadeDrive(driverYaw, driverThrottle);
  //   }
   }
}
