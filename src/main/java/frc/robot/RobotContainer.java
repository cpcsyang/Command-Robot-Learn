// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.C_Drive;
import frc.robot.commands.C_DriveForwardDistance;
import frc.robot.commands.C_ElevatorPID;
import frc.robot.commands.C_ElevatorStick;
import frc.robot.commands.C_IntakeSet;
import frc.robot.Constants.*;
import frc.robot.subsystems.SS_Elevator;
import frc.robot.subsystems.SS_Intake;
import frc.robot.subsystems.SS_TankDrive;
import frc.robot.utils.XboxGamepad;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /** The container for the robot. Contains subsystems and OI devices */
  // Setup Controllers
  private final XboxGamepad m_driverController = new XboxGamepad(
                  OIConstants.XBOX_DRIVER_CONTROLLER_ID, OIConstants.deadbandDriver);
  // private final XboxGamepad m_operatorController = new XboxGamepad(
  //                 Constants.XboxGamePad.XBOX_DRIVER_CONTROLLER_ID, Constants.XboxGamePad.deadbandOperator);
  
  // The robot's subsystems and commands are defined here...
  private final SS_TankDrive ss_TankDrive = new SS_TankDrive();
  private final SS_Intake ss_Intake = new SS_Intake();
  private final SS_Elevator ss_Elevator = new SS_Elevator();

  public RobotContainer() {
    // set default commands for subsystems
    ss_Elevator.setDefaultCommand(new C_ElevatorStick(ss_Elevator, 0));

    ss_Intake.setDefaultCommand(new C_IntakeSet(ss_Intake, true));
    Command cmd = new C_Drive(ss_TankDrive, 
                        () -> m_driverController.getRawAxis(OIConstants.L_Y_AXIS), 
                        () -> m_driverController.getRawAxis(OIConstants.R_X_AXIS));
    ss_TankDrive.setDefaultCommand(cmd);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this configureButtonBindings() method to define your button->command mappings. 
   * Buttons can be created by instantiating a {@link GenericHID} or one of its subclasses 
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a 
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // raise elevator
    new JoystickButton(m_driverController, OIConstants.A_BUTTON)
            .whileActiveOnce(new C_ElevatorStick(ss_Elevator, ElevatorConstants.kMaxSpeed));
    // lower elevator
    new JoystickButton(m_driverController, OIConstants.B_BUTTON)
            .whileActiveOnce(new C_ElevatorStick(ss_Elevator, -ElevatorConstants.kMaxSpeed));
    // set elevator to raised position (1.2 meter)
    new JoystickButton(m_driverController, OIConstants.X_BUTTON)
            .whileActiveOnce(new C_ElevatorStick(ss_Elevator, ElevatorConstants.kRaisedPosition));
    // set elevator to lowered position (0 meter)
    new JoystickButton(m_driverController, OIConstants.Y_BUTTON)
            .whileActiveOnce(new C_ElevatorStick(ss_Elevator, ElevatorConstants.kLoweredPosition));
    // intake not open
    new JoystickButton(m_driverController, OIConstants.L_BUMPER_BUTTON)
            .whileActiveOnce(new C_IntakeSet(ss_Intake, false));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new C_DriveForwardDistance(ss_TankDrive, DriveConstants.kAutoDriveForwardDistance),  // drive forward
      new ParallelCommandGroup(
        new C_IntakeSet(ss_Intake, false),    // set intake and 'open' the intake jaws
        new C_ElevatorPID(ss_Elevator, ElevatorConstants.kRaisedPosition)   // set elevator to raised position
      )
    );
  }
}
