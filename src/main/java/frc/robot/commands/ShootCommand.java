// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControlerConstants;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends CommandBase {

  private final ShooterSubsystem shooterSubsystem;
  private final Joystick operatorController;
  private double HighShoot;
  private boolean LowShoot;
  /** Creates a new ShootCommand. */
  public ShootCommand(Joystick operatorController, ShooterSubsystem shooterSubsystem) {
      this.shooterSubsystem = shooterSubsystem;
      this.operatorController = operatorController;
  
    addRequirements(shooterSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize(){
    super.initialize();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    super.execute();
    HighShoot = operatorController.getRawAxis(ControlerConstants.SHOOT_AXIS_2_ID);
    LowShoot = operatorController.getRawButton(ControlerConstants.SHOOT_BUTTON_RB_ID);
    if(HighShoot>0.1){
    shooterSubsystem.ShootHigh();
    }
    else if(LowShoot){
      shooterSubsystem.Shootlow();
    }
    else{
      shooterSubsystem.StopShoot();
    }
  }
  
    
   
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);
    shooterSubsystem.StopShoot();
  }

  // Returns true when the command should end.
 
  public boolean isFinished() {
    return false;
  }
}
