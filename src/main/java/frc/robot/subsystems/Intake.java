package frc.robot.subsystems;

import java.lang.reflect.Constructor;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.IntakeConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    
    private static final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(IntakeConstants.intakeMotor_ID);
    
    public Intake(){

        intakeMotor.configFactoryDefault();

        intakeMotor.setInverted(true);




    }
    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }
    public void RunIntake(){
        intakeMotor.set(1);
        System.out.println("Intake In ON");
    }

    public void StopIntake(){
        intakeMotor.set(0);
        System.out.println("Intake Out ON");
    }

    public void ReverseIntake(){
        intakeMotor.set(-5);
        System.out.println("Intake Out ON");
    }

}
