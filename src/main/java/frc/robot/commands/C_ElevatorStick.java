// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SS_Elevator;

public class C_ElevatorStick extends CommandBase {
  private final SS_Elevator ss_Elevator;
  private final double m_speed;
  
  public C_ElevatorStick(SS_Elevator ss_Elevator, double speed) {
    this.ss_Elevator = ss_Elevator;
    this.m_speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ss_Elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("C_ElevatorStick.java Started.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ss_Elevator.setMotor(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ss_Elevator.setMotor(0);
    System.out.println("C_ElevatorStick.java ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
