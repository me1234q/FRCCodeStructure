package frc.robot.controllers;

// import edu.wpi.first.wpilibj.Encoder;
import frc.robot.util.Context;
import frc.robot.util.PID;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
 
import com.revrobotics.*;

public class NMFController {
    TalonSRX NMFTalon;
    Encoder NMFEncoder;
    CANSparkMax omniSpark;
    CANEncoder omniEncoder;


    public double NMFidleSpeed = 0;
    public double NMFintakeSpeed = 0;
    public double NMFshootingSpeed = 0;
    public double NMFreverseSpeed = 0;
    public double omniForwardsSpeed = 0;
    public double omniReverseSpeed = 0;

    public double NMFcurrentSpeed; //Encoder-read speed
    public double NMFsetSpeed; //The speed to set based on PID
    public double NMFtargetSpeed; //The current desired speed;
    public PID NMFPID = new PID(0, 0, 0); //Need to tune

    public double omniCurrentSpeed; //Encoder-read speed
    public double omniSetSpeed; //The speed to set based on PID
    public double omniTargetSpeed; //The current desired speed;
    public PID omniPID = new PID(0, 0, 0); //Need to tune

    private double startTime;
    private double lastTime;
    private double currentTime;
    private double deltaTime;
    

    public NMFController(TalonSRX nmfTalon, Encoder nmfEncoder, CANSparkMax OmniSpark){
        NMFTalon = nmfTalon;
        NMFEncoder = nmfEncoder;
        omniSpark = OmniSpark;
        omniEncoder = omniSpark.getEncoder();
    }

    public void spinNMFIntaking(){
        NMFsetSpeed = NMFintakeSpeed;
    }

    public void spinNMFIdle(){
        NMFsetSpeed = NMFidleSpeed;
    }

    public void spinNMFShooting(){
        NMFsetSpeed = NMFshootingSpeed;
    }

    public void spinNMFReverse(){
        NMFsetSpeed = NMFreverseSpeed;
    }

    public void stopNMF(){
        NMFsetSpeed = 0;
    }

    public void spinOmni(){
        omniSetSpeed = omniForwardsSpeed;
    }

    public void spinOmniReverse(){
        omniSetSpeed = omniReverseSpeed;
    }

    public void stopOmni(){
        omniSetSpeed = 0;
    }
    
    
    
    public void loop(){
        lastTime = currentTime;
        currentTime = Context.getRelativeTimeSeconds(startTime/1000)*1000;
        deltaTime = currentTime - lastTime;

        NMFcurrentSpeed = NMFEncoder.getRate();
        NMFsetSpeed = NMFPID.update(NMFtargetSpeed, NMFcurrentSpeed, deltaTime);
        NMFTalon.set(ControlMode.PercentOutput, NMFsetSpeed);


        omniCurrentSpeed = omniEncoder.getVelocity();
        omniSetSpeed = omniPID.update(omniTargetSpeed, omniCurrentSpeed, deltaTime);
        omniSpark.set(omniSetSpeed);

    }
}