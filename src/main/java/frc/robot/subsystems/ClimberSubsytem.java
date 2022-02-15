package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants.ClimberConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ClimberSubsytem extends SubsystemBase{

    static WPI_TalonFX climberright = new WPI_TalonFX(ClimberConstants.ClimberArmRight);
    static WPI_TalonFX climberleft = new WPI_TalonFX(ClimberConstants.ClimberArmLeft);
    WPI_TalonFX piviotRight = new WPI_TalonFX(ClimberConstants.PiviotArmRight);
    WPI_TalonFX piviotLeft = new WPI_TalonFX(ClimberConstants.PiviotArmLeft);

    public ClimberSubsytem() {
        climberright.setInverted(false);
        climberleft.setInverted(false);
        
        piviotRight.setInverted(false);
        piviotLeft.setInverted(false);

        climberright.setNeutralMode(NeutralMode.Brake);
        climberleft.setNeutralMode(NeutralMode.Brake);

        piviotLeft.setNeutralMode(NeutralMode.Brake);
        piviotRight.setNeutralMode(NeutralMode.Brake);

    }

    @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public static void StopClimb() {
    climberleft.set(0);
    climberright.set(0);
  }
  public void ClimbUp(double speed) {
    climberleft.set(speed);
    climberright.set(speed);
  }
  public void ClimbDown(double speed) {
    climberleft.set(-speed);
    climberright.set(-speed);
  }

    public void Stoppiviot() {
        climberleft.set(0);
        climberright.set(0);
      }
      public void piviotforward(double speed) {
        climberleft.set(speed);
        climberright.set(speed);
      }
      public void piviotdown(double speed) {
        climberleft.set(-speed);
        climberright.set(-speed);

    
  }
}

