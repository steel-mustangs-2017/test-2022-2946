package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControlerConstants;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase{
    private final Intake intakeSubsystem;
    private final Joystick operatorController;
    private  boolean intakeinBTN = false;
    private  boolean intakeoutBTN = false;

    public IntakeCommand(Joystick operatorController, Intake intakeSubsystem){
       this.operatorController = operatorController;
       this.intakeSubsystem = intakeSubsystem;
       
       addRequirements(intakeSubsystem);

    }

    @Override
    public void initialize() {
      //intakeSubsystem.intakeoutBTN(); 
      //succnt is intake out
    }
    @Override
    public void execute() {
    System.out.println("Intake On");
    intakeinBTN = operatorController.getRawButton(ControlerConstants.CONTROLLER_BUTTON_A_ID);
    intakeoutBTN = operatorController.getRawButton(ControlerConstants.CONTROLLER_BUTTON_Y_ID);

    

    } 
}
