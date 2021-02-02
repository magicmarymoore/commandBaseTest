// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.intakeConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class IntakeSubsystem extends SubsystemBase {
    //motor controllers
    WPI_VictorSPX intakeIn = new WPI_VictorSPX(intakeConstants.intakeID);
    WPI_VictorSPX intakeMove = new WPI_VictorSPX(intakeConstants.intakeMoveID);

    //whether or not this subsystem is currently being used
    private boolean running = false;

    /** Creates a new IntakeSubsystem. */
    public IntakeSubsystem() {

    }
    /**
     * moves the intake in/out
     */
    public void intakeRun() {
        intakeIn.set(intakeConstants.intakeSpeed);
        running = true;
    }

    /**
     * stops the intake
     */
    public void stop() {
        intakeIn.set(0);
        running = false;
    }

    /**
     * whether the intake is running or not
     * @return running
     */
    public boolean isRunning() {
        return running;
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
