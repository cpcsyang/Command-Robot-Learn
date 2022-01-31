// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.*;
import frc.robot.subsystems.SS_Elevator;

public class C_ElevatorPID extends CommandBase {
  private final SS_Elevator ss_Elevator;
  private final PIDController m_PIDController;
  
  public C_ElevatorPID(SS_Elevator ss_Elevator, double setpoint) {
    this.ss_Elevator = ss_Elevator;
    this.m_PIDController = new PIDController(ElevatorConstants.kP, ElevatorConstants.kI, ElevatorConstants.kD);
    this.m_PIDController.setSetpoint(setpoint);;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ss_Elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_PIDController.reset();
    System.out.println("C_ElevatorPID.java started.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = m_PIDController.calculate(ss_Elevator.getEncoderMeters());
    ss_Elevator.setMotor(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ss_Elevator.setMotor(0);
    System.out.println("C_ElevatorPID ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
