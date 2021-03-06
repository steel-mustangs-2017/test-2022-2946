// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.ControlerConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.ClimberSubsytem;
import frc.robot.subsystems.LimelightSubsystem;
//import frc.robot.subsystems.LimelightSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  
  private final Joystick operatorController = new Joystick(ControlerConstants.PORT_ID_OPERATOR_CONTROLER);
  private final Joystick driverController = new Joystick(ControlerConstants.PORT_ID_DRIVER_CONTROLLER);
  // The robot's subsystems and commands are defined here...
  private final Chassis chassisSubsystem = new Chassis();
  private final Intake intakeSubsystem = new Intake();
  private final DriveCommand driveCommand = new DriveCommand(driverController, chassisSubsystem);
  private final IntakeCommand IntakeCommand = new IntakeCommand(operatorController,intakeSubsystem);
  private final Indexer IndexerSubsystem = new Indexer();
  private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();
  //private final MotorTest motorTest = new MotorTest(chassisSubsystem, operatorController);
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ShootCommand shootCommand = new ShootCommand(operatorController, shooterSubsystem, IndexerSubsystem);
  private final TurretSubsystem turretSubsystem = new TurretSubsystem();
  private final ManualAim manualAim= new ManualAim(operatorController, turretSubsystem);
  private final ClimberSubsytem climberSubsytem = new ClimberSubsytem();
  private final ClimberCommand ClimberCommand = new ClimberCommand(climberSubsytem, operatorController);
 
  //private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();
 // private final TurretInitCommand turretInitCommand = new TurretInitCommand(turretSubsystem,limelightSubsystem);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    configureDefaultCommands();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

   

    
    

  }

  private void configureDefaultCommands() {

    chassisSubsystem.setDefaultCommand(driveCommand);
    intakeSubsystem.setDefaultCommand(IntakeCommand);
    shooterSubsystem.setDefaultCommand(shootCommand);
    turretSubsystem.setDefaultCommand(manualAim);
    climberSubsytem.setDefaultCommand(ClimberCommand);
    //climberSubsytem.setDefaultCommand(pivotCommand);
    //limelightSubsystem.setDefaultCommand(turretInitCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
