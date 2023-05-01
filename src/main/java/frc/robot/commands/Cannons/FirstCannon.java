// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Cannons;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AirSubsystem;

public class FirstCannon extends CommandBase {
  /** Creates a new fireCannon. */
  private final AirSubsystem m_airSubsystem; 

  public FirstCannon(AirSubsystem airSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_airSubsystem = airSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_airSubsystem.fireCannon1();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_airSubsystem.disableCannon();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
