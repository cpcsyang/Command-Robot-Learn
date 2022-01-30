// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SS_Intake;

public class C_IntakeSet extends CommandBase {
  private final SS_Intake ss_Intake;
  private final boolean m_open;

  public C_IntakeSet(SS_Intake ss_Intake, boolean open) {
    this.ss_Intake = ss_Intake;
    this.m_open = open;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ss_Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("C_IntakeSet.java started.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ss_Intake.setPosition(m_open);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("C_IntakeSet.java ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
