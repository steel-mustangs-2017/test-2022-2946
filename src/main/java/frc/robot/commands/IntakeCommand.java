package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControlerConstants;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase{
    private final Intake intakeSubsystem;
    private final Joystick operatorController;
    private final boolean succ = false;

    public IntakeCommand(Joystick operatorController, Intake intakeSubsystem){
       this.operatorController = operatorController;
       this.intakeSubsystem = intakeSubsystem;
       
       addRequirements(intakeSubsystem);

    }

    @Override
    public void initialize() {
      intakeSubsystem.succnt();
    }
    @Override
    public void execute() {
        

    } 
}
