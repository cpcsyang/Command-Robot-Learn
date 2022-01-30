// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.SS_TankDrive;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class C_Drive extends CommandBase {
  // DO NOT create a new ss_TankDrive, one will be passed in via constructor
  // Another words, do NOT assignment the subsystem to a new Subsystem();
  // the subsystem object will be passed to you as a parameter in the constructor
  private final SS_TankDrive ss_TankDrive;
  
  private Supplier<Double> m_speedFunction;
  private Supplier<Double> m_rotateFunction;
  
  public C_Drive(SS_TankDrive ss_TankDrive,
                  Supplier<Double> leftYAxisSpeedSupplier,
                  Supplier<Double> rightZAxisRotateSupplier) {

    // assign the subsystem object being passed in 
    this.ss_TankDrive = ss_TankDrive;
    this.m_speedFunction = leftYAxisSpeedSupplier;
    this.m_rotateFunction = rightZAxisRotateSupplier;
    // Use addRequirements() here to declare subsystem dependencies. 
    // "Which is subsystem does this command require exclusively?"
    // This way, if the command is called, the subsystem will be interrupted if it is running.
    addRequirements(ss_TankDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("C_Drive.java started.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // alternative #1
    // double realTimeSpeed = m_speedFunction.get();
    // double realTimeRotation = m_rotateFunction.get();
    // double left = realTimeSpeed + realTimeRotation;
    // double right = realTimeSpeed - realTimeRotation;
    // ss_TankDrive.setMotors(left, right);

    // alternative #2
    ss_TankDrive.arcadeDrive(m_speedFunction.get(), m_rotateFunction.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("C_Drive.java ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
