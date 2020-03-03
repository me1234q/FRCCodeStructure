package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  public RobotManager manager;
  
  @Override
  public void robotInit() {
    manager = new RobotManager();
  }

  @Override
  public void robotPeriodic() {
    
  }

  @Override
  public void autonomousInit() {
    manager.autonomousInit();
  }

  @Override
  public void autonomousPeriodic() {
    manager.autonomousPeriodic();
  }

  @Override
  public void teleopInit() {
    manager.teleopInit();
  }

  @Override
  public void teleopPeriodic() {
    manager.teleopPeriodic();
  }
}
