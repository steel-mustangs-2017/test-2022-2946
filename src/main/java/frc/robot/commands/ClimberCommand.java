package frc.robot.commands;

import com.fasterxml.jackson.databind.node.DoubleNode;

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
        climberSubsytem.StopClimb();
        climberSubsytem.StopPivot();

    }

    @Override 
    public void execute() {
      double climbaxis = -operatorController.getRawAxis(5);
      double pivotaxis = -operatorController.getRawAxis(1);
      
     
       if(Math.abs(climbaxis) > .15){
        climberSubsytem.ClimbUp(climbaxis);
        System.out.println("climberSubsytem.ClimbUp("+climbaxis);
      } 
      else{
        climberSubsytem.StopClimb();
      }
       if(Math.abs(pivotaxis) > .15){
        climberSubsytem.Pivotforward(pivotaxis);
        //System.out.println("climberSubsytem.Pivotforward("+pivotaxis);
    
      }
      else{
        climberSubsytem.StopPivot();
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
