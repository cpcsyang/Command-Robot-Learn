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

    public static final class CANConstants {
        // private static final double WHEEL_DIAMETER = 4.0;   // unit: inch
        public static final int L_MOTOR_CONTROLLER_CAN_ID = 3;
        public static final int R_MOTOR_CONTROLLER_CAN_ID = 4;
        public static final int kEncoderChannel1A = 5;
        public static final int kEncoderChannel1B = 6;
        public static final int ELEVATOR_MOTOR_CAN_ID = 10;
        public static final int INTAKE_L_MOTOR_CAN_ID = 12;
        public static final int INTAKE_R_MOTOR_CAN_ID = 13;

    }

    public static final class DriveConstants {
        public static final int kLeftEncoderChannelA = 0;  // FIXME: need actual encoder channels
        public static final int kLeftEncoderChannelB = 1;
        public static final int kRightEncoderChannelA = 2;
        public static final int kRightEncoderChannelB = 3;
        public static final double kEncoderTick2Meter = 1.0 / 4096.0 * 0.128 * Math.PI;  // FIXME: need actual convesion values
        public static final double kAutoDriveForwardSpeed = 0.5;
        public static final double kAutoDriveForwardDistance = 1.5;
    }

    public static final class ElevatorConstants {
        public static final double kRaisedPosition = 1.2;
        public static final double kLoweredPosition = 0;
        public static final double kMaxSpeed = 0.5;

        public static final double kEncoderTick2Meter = 1.0 / 4096.0 * 0.1 * Math.PI;  // FIXME: need actual convesion values
        public static final double kP = 3.0;   // FIXME: need to tune kP, kI, kD
        public static final double kI = 0.0;  
        public static final double kD = 0.8;

    }

    public static final class IntakeConstants {
        public static final double kOpenSpeed = -1;
        public static final double kCloseSpeed = 1;
    }

    public static final class OIConstants {
        public static final int XBOX_DRIVER_CONTROLLER_ID = 0;
        public static final double deadbandDriver = 0.1;
        public static final int XBOX_OPERATER_CONTROLLER_ID = 1;
        public static final double deadbandOperator = 0.1;

        public static final int L_X_AXIS = 0;
        public static final int L_Y_AXIS = 1;
        public static final int L_TRIGGER = 2;
        public static final int R_TRIGGER = 3;
        public static final int R_X_AXIS = 4;
        public static final int R_Y_AXIS = 5;
    
        public static final int A_BUTTON = 1;
        public static final int B_BUTTON = 2;
        public static final int X_BUTTON = 3;
        public static final int Y_BUTTON = 4;
        public static final int L_BUMPER_BUTTON = 5;
        public static final int R_BUMPER_BUTTON = 6;
        public static final int BACK_BUTTON = 7;
        public static final int START_BUTTON = 8;
        public static final int L_STICK_BUTTON = 9;
        public static final int R_STICK_BUTTON = 10;    
    }
}
