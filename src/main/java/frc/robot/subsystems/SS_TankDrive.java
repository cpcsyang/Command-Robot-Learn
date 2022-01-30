// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.utils.TalonSRXController;

public class SS_TankDrive extends SubsystemBase {
  private final TalonSRXController m_leftDriveMotor = new TalonSRXController(Constants.CAN.L_MOTOR_CONTROLLER_CAN_ID);
  private final TalonSRXController m_rightDriveMotor = new TalonSRXController(Constants.CAN.R_MOTOR_CONTROLLER_CAN_ID);
  // alternative (without using TalonSRXController class)
  // private final TalonSRX leftMotor = new TalonSRX(Constants.L_MOTOR_CONTROLLER_CAN_ID);
  // private final TalonSRX rightMotor = new TalonSRX(Constants.R_MOTOR_CONTROLLER_CAN_ID);
  
  // Set up the differential drive controller
  private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftDriveMotor, m_rightDriveMotor);

  private final Encoder m_leftEncoder = new Encoder(Constants.Drive.kLeftEncoderChannelA, Constants.Drive.kLeftEncoderChannelB);
  private final Encoder m_rightEncoder = new Encoder(Constants.Drive.kRightEncoderChannelA, Constants.Drive.kRightEncoderChannelB);

  /** Creates a new ExampleSubsystem. */
  public SS_TankDrive() {
    m_leftDriveMotor.setInverted(false);
    m_rightDriveMotor.setInverted(true);
    m_leftEncoder.setReverseDirection(false);
    m_rightEncoder.setReverseDirection(true);
  }

  public double getEncoderMeters() {
    return (m_leftEncoder.get() + -m_rightEncoder.get()) / 2 * Constants.Drive.kEncoderTick2Meter;
  }

  public void setMotors(double leftSpeed, double rightSpeed) {
    m_leftDriveMotor.set(leftSpeed);
    m_rightDriveMotor.set(rightSpeed);
  }

  public void arcadeDrive(double speed, double rotate) {
    m_diffDrive.arcadeDrive(speed, -rotate);
  }

  public void setSpeed(double leftSpeed, double rightSpeed) {
    m_leftDriveMotor.set(leftSpeed);
    m_rightDriveMotor.set(rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Motor Set Speed: ", m_leftEncoder.getRate());
    SmartDashboard.putNumber("Right Motor Set Speed: ", m_rightEncoder.getRate());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    SmartDashboard.putNumber("Left Motor Set Speed: ", m_leftEncoder.getRate());
    SmartDashboard.putNumber("Right Motor Set Speed: ", m_rightEncoder.getRate());
  }
}
