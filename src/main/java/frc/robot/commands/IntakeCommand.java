package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControlerConstants;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.DirectionalButton;

public class IntakeCommand extends CommandBase
{
    private final Intake intakeSubsystem;
    private final Joystick operatorController;
    private  boolean intakeinBTN = false;
    private  boolean intakeoutBTN = false;
    private int IntakeUp = -1;
    private int IntakeDown = -1;


    public IntakeCommand(Joystick operatorController, Intake intakeSubsystem){
       this.operatorController = operatorController;
       this.intakeSubsystem = intakeSubsystem;
       
       addRequirements(intakeSubsystem);

    }

    @Override
    public void initialize() {
      //intakeSubsystem.intakeoutBTN(); 
      //succ    
    }
    @Override
    public void execute() {
   // System.out.println("Intake On");
    intakeinBTN = operatorController.getRawButton(ControlerConstants.CONTROLLER_BUTTON_A_ID);
    intakeoutBTN = operatorController.getRawButton(ControlerConstants.CONTROLLER_BUTTON_Y_ID);
    IntakeUp = operatorController.getPOV();
    if(operatorController.getPOV() == 180) {
      intakeSubsystem.IntakeDown();
    }
    else if(operatorController.getPOV() == 0) {
      intakeSubsystem.Intakeup();
    }
    else{
      intakeSubsystem.IntakeStop();
    }

    if(operatorController.getRawButton(1)){
      intakeSubsystem.RunIntake();
    }
    else{intakeSubsystem.StopIntake();}


    }
    

    
    
}
