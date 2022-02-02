// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.ControlerConstants;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Intake;

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
  //private final MotorTest motorTest = new MotorTest(chassisSubsystem, operatorController);
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ShootCommand shootCommand = new ShootCommand(operatorController, shooterSubsystem);


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

    new JoystickButton(operatorController, ControlerConstants.CONTROLLER_BUTTON_A_ID)
    .whenActive(new RunCommand(intakeSubsystem::RunIntake, intakeSubsystem))
    .whenInactive(new RunCommand(intakeSubsystem::StopIntake, intakeSubsystem));

    new JoystickButton(operatorController, ControlerConstants.CONTROLLER_BUTTON_Y_ID)
    .whenActive(new RunCommand(intakeSubsystem::ReverseIntake, intakeSubsystem))
    .whenInactive(new RunCommand(intakeSubsystem::StopIntake, intakeSubsystem));
    

  }

  private void configureDefaultCommands() {

    chassisSubsystem.setDefaultCommand(driveCommand);
    intakeSubsystem.setDefaultCommand(IntakeCommand);
    shooterSubsystem.setDefaultCommand(shootCommand);
  
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
