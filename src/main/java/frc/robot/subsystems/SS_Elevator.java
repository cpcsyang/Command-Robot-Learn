// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class SS_Elevator extends SubsystemBase {
  private final TalonSRX m_elevatorMotor = new TalonSRX(CANConstants.ELEVATOR_MOTOR_CAN_ID);
  // set up the encoders for the drive motor controllers  
  private final Encoder m_elevatorEncoder = new Encoder(CANConstants.kEncoderChannel1A, CANConstants.kEncoderChannel1B); 
  
  /** Creates a new SS_Elevator. */
  public SS_Elevator() {}

  public double getEncoderMeters() {
    return m_elevatorEncoder.get() * ElevatorConstants.kEncoderTick2Meter;
  }

  public void setMotor(double speed) {
    m_elevatorMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Elevator Encoder Value", getEncoderMeters());
  }
}
