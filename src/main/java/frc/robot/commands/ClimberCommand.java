package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.ClimberSubsytem;



import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimberCommand extends CommandBase {
    
    private final ClimberSubsytem climberSubsytem;
    private Joystick operatorController;

    public ClimberCommand(ClimberSubsytem climberSubsytem, Joystick operatorController) {
        
        this.climberSubsytem = climberSubsytem;
        this.operatorController  = operatorController;
    
        addRequirements(climberSubsytem);

    }

    @Override 
    public void execute() {
        double speed = -operatorController.getRawAxis(5);
        climberSubsytem.ClimbUp(speed);     
        
    }

    @Override
  public void initialize() {
    ClimberSubsytem.StopClimb();
  }
  @Override
  public boolean isFinished() {
    return false;
  }


    

    


    
}