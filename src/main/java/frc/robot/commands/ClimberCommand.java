package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller.Axis;
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
      double climbaxis = -operatorController.getRawAxis(5);
      double pivotaxis = -operatorController.getRawAxis(4);
      
      if(Math.abs(climbaxis) < .1 && Math.abs(pivotaxis) < -1){
      //dont do anything not enought movement   
      } 
      else if(Math.abs(climbaxis) > Math.abs(pivotaxis)){
        climberSubsytem.ClimbUp(climbaxis);
      } 
      else if(Math.abs(climbaxis) < Math.abs(pivotaxis)){
        climberSubsytem.Pivotforward(pivotaxis);
    
      }
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
