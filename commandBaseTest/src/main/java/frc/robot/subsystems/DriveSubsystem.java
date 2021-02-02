// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.driveConstants;

public class DriveSubsystem extends SubsystemBase {
    //left & right motor groups
    private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(new CANSparkMax(driveConstants.leftBackID, MotorType.kBrushless), new CANSparkMax(driveConstants.leftFrontID, MotorType.kBrushless));
    private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(new CANSparkMax(driveConstants.rightBackID, MotorType.kBrushless), new CANSparkMax(driveConstants.rightFrontID, MotorType.kBrushless));
    //drivetrain
    private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

    /** Creates a new ExampleSubsystem. */
    public DriveSubsystem() {
        //encoder initialization in here later... 
    }

    /**
     * tank drive for robot
     * 
     * @param leftSpeed left speed, will be decreased
     * @param rightSpeed right speed, will be decreased
     */
    public void tankDrive(Double leftSpeed, Double rightSpeed) {
        leftSpeed = (leftSpeed * Math.abs(leftSpeed))/1.3;
        rightSpeed = (rightSpeed * Math.abs(rightSpeed))/1.3;
        
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}