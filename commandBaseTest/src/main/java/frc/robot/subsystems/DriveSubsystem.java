// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.driveConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends SubsystemBase {
    //motor controllers
    CANSparkMax leftBack = new CANSparkMax(driveConstants.leftBackID, MotorType.kBrushless);
    CANSparkMax leftFront = new CANSparkMax(driveConstants.leftFrontID, MotorType.kBrushless);
    CANSparkMax rightBack = new CANSparkMax(driveConstants.rightBackID, MotorType.kBrushless);
    CANSparkMax rightFront = new CANSparkMax(driveConstants.rightFrontID, MotorType.kBrushless);


    //drivetrain
    private final DifferentialDrive drive;

    /** Creates a new ExampleSubsystem. */
    public DriveSubsystem() {
        //encoder initialization in here later... 

        //sets leader/follower motors
        this.leftBack.follow(leftFront);
        this.rightBack.follow(rightFront);

        //creates a new drive object an initializes w/the four motors (only the fron ones are included since the back motors follow the front motors)
        drive = new DifferentialDrive(leftFront, rightFront);
        this.drive.setRightSideInverted(true);//CHECK THIS!!!

        //sets to break mode not coast mode => blue light = break; pink light = coast
        this.leftFront.setIdleMode(IdleMode.kBrake);
        this.rightBack.setIdleMode(IdleMode.kBrake);
        this.leftBack.setIdleMode(IdleMode.kBrake);
        this.leftFront.setIdleMode(IdleMode.kBrake);

        /* so this could be helpful later...
        // Reset encoders
        resetEncoders(); */
    }

    /**
     * tank drive for robot
     * 
     * @param leftSpeed left speed, will be decreased
     * @param rightSpeed right speed, will be decreased
     */
    public void tankDrive(Double leftSpeed, Double rightSpeed) {
        //speed^2 ÷ 1.3 => absolute value is used to maintain the direction (positive/negative) b/c squaring always returns positive
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