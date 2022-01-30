// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SS_TankDrive;

public class C_DriveForwardDistance extends CommandBase {
  private final SS_TankDrive ss_TankDrive;
  private final double m_distance;
  private double m_encoderSetpoint;
  
  public C_DriveForwardDistance(SS_TankDrive ss_TankDrive, double distance) {
    this.ss_TankDrive = ss_TankDrive;
    this.m_distance = distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ss_TankDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_encoderSetpoint = ss_TankDrive.getEncoderMeters() + m_distance;
    System.out.println("C_DriveForwardDistance.java started.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ss_TankDrive.setMotors(Constants.Drive.kAutoDriveForwardSpeed, Constants.Drive.kAutoDriveForwardSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ss_TankDrive.setMotors(0, 0);
    System.out.println("C_DriveForwardDistance.java ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(ss_TankDrive.getEncoderMeters() > m_encoderSetpoint) {
      return true;
    } else {
      return false;
    }
  }
}
