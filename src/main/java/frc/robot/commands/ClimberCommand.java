package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.ClimberSubsytem;



import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimberCommand extends CommandBase {
    
    private final ClimberSubsytem climberSubsytem;
    private Joystick operatorController;

    private double hi = 0;
    private double speed = 0;

    public ClimberCommand(ClimberSubsytem climberSubsytem, Joystick operatorController) {
        
        this.climberSubsytem = climberSubsytem;
        this.operatorController  = operatorController;
    
        addRequirements(climberSubsytem);

    }

    @Override 
    public void execute() {
         hi = -operatorController.getRawAxis(5);
        if(Math.abs(hi) < .1){hi = 0;}
        climberSubsytem.ClimbUp(hi);     
        speed = -operatorController.getRawAxis(0);
        if(Math.abs(speed) < .1){speed = 0;}
        climberSubsytem.Pivotforward(speed);     
        
    }

    @Override
  public void initialize() {
    climberSubsytem.StopClimb();
    climberSubsytem.StopPivot();
  }
  @Override
  public boolean isFinished() {
    return false;
  }


    

    


    
}
