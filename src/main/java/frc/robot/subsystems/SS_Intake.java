// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class SS_Intake extends SubsystemBase {

  private final TalonSRX m_intakeLeftMotor = new TalonSRX(CANConstants.INTAKE_L_MOTOR_CAN_ID);
  private final TalonSRX m_intakeRightMotor = new TalonSRX(CANConstants.INTAKE_R_MOTOR_CAN_ID);
  
  public SS_Intake() {}

  public void setPosition(boolean open) {
    if(open) {
      // grab cube (open intake jaws)
      m_intakeLeftMotor.set(ControlMode.PercentOutput, IntakeConstants.kOpenSpeed);
      m_intakeRightMotor.set(ControlMode.PercentOutput, IntakeConstants.kOpenSpeed);
    } else {
      // let go cube (close intake jaws)
      m_intakeLeftMotor.set(ControlMode.PercentOutput, IntakeConstants.kCloseSpeed);
      m_intakeRightMotor.set(ControlMode.PercentOutput, IntakeConstants.kCloseSpeed);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
