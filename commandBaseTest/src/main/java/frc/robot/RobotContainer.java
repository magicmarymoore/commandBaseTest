// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.oiConstants;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveSubsystem robotDrive = new DriveSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  //Joysticsks
  Joystick leftJoy = new Joystick(oiConstants.leftJoyID);
  Joystick rightJoy = new Joystick(oiConstants.rightJoyID);
  Joystick videogame = new Joystick(oiConstants.videogameID);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //drive!!
    robotDrive.setDefaultCommand(new RunCommand(() -> robotDrive.tankDrive(leftJoy.getY(), rightJoy.getY())));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /* EXAMPLE!!

    // Grab the hatch when the 'A' button is pressed.
    new JoystickButton(m_driverController, Button.kA.value).whenPressed(new InstantCommand(m_hatchSubsystem::grabHatch, m_hatchSubsystem));
    
    // Release the hatch when the 'B' button is pressed.
    new JoystickButton(m_driverController, Button.kB.value).whenPressed(new InstantCommand(m_hatchSubsystem::releaseHatch, m_hatchSubsystem));
    
    // While holding the shoulder button, drive at half speed
    new JoystickButton(m_driverController, Button.kBumperRight.value).whenPressed(() -> m_robotDrive.setMaxOutput(0.5)).whenReleased(() -> m_robotDrive.setMaxOutput(1));*/
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
