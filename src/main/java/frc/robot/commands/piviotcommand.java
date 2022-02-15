package frc.robot.commands;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.ClimberSubsytem;
import frc.robot.subsystems.TurretSubsystem;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants.ControlerConstants;

public class piviotcommand extends CommandBase {
    private ClimberSubsytem climberSubsytem = new ClimberSubsytem();
    private Joystick operatorController = new Joystick(1);
    private double turn = 1;


    public void PiviotTurn(Joystick operatorController, ClimberSubsytem climberSubsytem){
    this.climberSubsytem = climberSubsytem;
    this.operatorController = operatorController;
    

    addRequirements(climberSubsytem);
    }

    @Override 
    public void initialize() {
        super.execute();
    }

        @Override
        public void execute() {
            super.execute();
           double rotate = operatorController.getRawAxis(ControlerConstants.Climber_Axis_5_ID);
            if(Math.abs(rotate) < .1){rotate = 0;}

            climberSubsytem.piviotforward(rotate/4);
            if(rotate > 0 ){
            climberSubsytem.piviotforward(rotate/4);
            }
            else if(rotate < 0 ){
                climberSubsytem.piviotdown(rotate/4);
            }
            else {
                climberSubsytem.Stoppiviot();
            }
        }
         @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        climberSubsytem.Stoppiviot();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    
}
