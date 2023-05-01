// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AirSubsystem;

public class CompressorControl extends CommandBase {
  private final AirSubsystem m_airSubsystem;
  /** Creates a new CompressorControl. */
  public CompressorControl(AirSubsystem airSubsystem) {
    m_airSubsystem = airSubsystem; 
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (m_airSubsystem.isCompressorOn()){
      m_airSubsystem.turnCompressorOff(); 
    }
    else{
      m_airSubsystem.turnCompressorOn();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
