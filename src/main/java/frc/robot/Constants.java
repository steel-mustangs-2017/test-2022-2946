// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class ChassisConstants{
        public final static int FrontRight_ID = 0;
        public final static int BackRight_ID = 1;
        public final static int FrontLeft_ID = 2;
        public final static int BackLeft_ID = 3;
    }
    public final class IntakeConstants{
        public final static int intakeMotor_ID = 13;
    }
public final static class ShooterConstants {
    public static final int DEVICE_ID_SHOOTER_MASTER = 4;
    public static final int DEVICE_ID_SHOOTER_SLAVE = 5;
    public static final int DEVICE_ID_TURRET = 9;

    public static final double TURRET_KP = .00001;
    public static final double TURRET_KI = 0;
    public static final double TURRET_KD = 0.0000001;
}
    public final static class IndexerConstants {
        public final static int IndexerTop = 6;
        public final static int IndexerBot = 7;
        public final static int IndexerFeeder = 8;
    }

    public final static class ControlerConstants {
        public static final int PORT_ID_OPERATOR_CONTROLER = 1;
        public static final int PORT_ID_DRIVER_CONTROLLER = 0;
        

        public static final int SHOOT_AXIS_2_ID = 3;
        public static final int SHOOT_BUTTON_RB_ID = 6;
    

        public static final int FORWARD_AXIS_ID = 1;
        public static final int TURN_AXIS_ID = 5;
        public static final int FORWARD_THROTTLE_AXIS_ID = 2;
        public static final int TURN_THROTTLE_AXIS_ID = 6;

        public static final int CONTROLLER_BUTTON_A_ID = 1;
        public static final int CONTROLLER_BUTTON_B_ID = 2;
        public static final int CONTROLLER_BUTTON_X_ID = 3;
        public static final int CONTROLLER_BUTTON_Y_ID = 4;
        

    }

}
