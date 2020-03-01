package frc.robot;

import frc.robot.actions.Action;
import frc.robot.subsystems.Subsystem;
import frc.robot.triggers.Trigger;

public class Scheduler {
    private Subsystem[] subsystems;

    private Action[] robotInitActions;
    private Action[] autonomousInitActions;
    private Action[] teleopInitActions;

    private Action[] robotPeriodicActions;
    private Action[] autonomousPeriodicActions;
    private Action[] teleopPeriodicActions;

    private Trigger[] robotTriggers;
    private Trigger[] autonomousTriggers;
    private Trigger[] teleopTriggers;

    private static Scheduler instance;

    public Scheduler() {
        subsystems = new Subsystem[] {
            //List subsystem instances here
        };

        
    }

    public void loop() {

    }

    public static Scheduler getInstance() {
        return instance;
    }
}