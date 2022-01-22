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
    public final static class ControlerConstants {
        public static final int PORT_ID_OPERATOR_CONTROLER = 1;
        public static final int PORT_ID_DRIVER_CONTROLLER = 0;

        public static final int FORWARD_AXIS_ID = 1;
        public static final int TURN_AXIS_ID = 5;
        public static final int FORWARD_THROTTLE_AXIS_ID = 2;
        public static final int TURN_THROTTLE_AXIS_ID = 6;
    }

}
