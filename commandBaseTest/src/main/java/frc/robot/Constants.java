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
    //CHANGE/CHECK ALL OF THESE CONSTNATS BEFORE DRIVING OR ANYTHING!!!


    //drivetrain subsystem constants
    public static final class driveConstants {
        //CAN IDs
        public static final int rightBackID = 1;
        public static final int rightFrontID = 2;
        public static final int leftBackID = 3;
        public static final int leftFrontID = 4;
    }

    //intake subsystem constants
    public static final class intakeConstants {
        //CAN IDs
        public static final int intakeID = 8; //intaking balls in/out
        public static final int intakeMoveID = 9; //moving up/down -- still needed?? or just nice to have?

        //speeds
        public static final Double intakeSpeed = 0.5; //in/out speed
        public static final Double intakeMoveSpeed = 0.5; //up/down speed
    }

    //indexing subsystem constants
    public static final class indexConstants {
        //CAN IDs
        public static final int beltID = 7;

        //speeds
        public static final Double beltSpeed = 0.5;
    }

    //shooter subsystem constants
    public static final class shooterConstants {
        //CAN IDs
        public static final int topShooterID = 5;
        public static final int bottomShoorterID = 6;

        //speeds
        public static final Double topShooterSpeed = -0.5;
        public static final Double bottomShooterSpeed = 0.5;
        public static final Double topShooterFastSpeed = -0.75;
        public static final Double bottomShooterFastSpeed = 0.75;

    }

    //autonomous constants
    public static final class autoConstants {

    }
    
    //joysicks constants
    public static final class oiConstants {
        public static final int leftJoyID = 2;
        public static final int rightJoyID = 1;
        public static final int videogameID = 0;

        //add button constants later???? ex: public static final int buttonY = 4;
    }
}
