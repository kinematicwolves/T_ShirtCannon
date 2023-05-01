// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.CompressorControl;
import frc.robot.commands.DriveRobotOpenLoop;
import frc.robot.commands.SlowModeToggle;
import frc.robot.commands.Cannons.FirstCannon;
import frc.robot.commands.Cannons.SecondCannon;
import frc.robot.commands.Cannons.ThirdCannon;
import frc.robot.subsystems.AirSubsystem;
import frc.robot.subsystems.DifferentialDrivetrain; 
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final AirSubsystem m_airSubsystem = new AirSubsystem();
  private final DifferentialDrivetrain m_montySubsystem = new DifferentialDrivetrain();


  // Controllers
  private final XboxController m_driverController = new XboxController(Constants.DRIVER_CONTROLLER);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    setDefaultCommands();
  }

  public void setDefaultCommands(){
    m_montySubsystem.setDefaultCommand(new DriveRobotOpenLoop(m_montySubsystem, m_driverController));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton dc_aButton = new JoystickButton(m_driverController, XboxController.Button.kA.value);
    JoystickButton dc_bButton = new JoystickButton(m_driverController, XboxController.Button.kB.value);
    JoystickButton dc_xButton = new JoystickButton(m_driverController, XboxController.Button.kX.value);
    JoystickButton dc_yButton = new JoystickButton(m_driverController, XboxController.Button.kY.value);
    JoystickButton dc_rBumper = new JoystickButton(m_driverController, XboxController.Button.kRightBumper.value);

    dc_aButton.whileTrue(new FirstCannon(m_airSubsystem)); 
    dc_bButton.whileTrue(new SecondCannon(m_airSubsystem));
    dc_xButton.whileTrue(new ThirdCannon(m_airSubsystem));

    dc_yButton.whileTrue(new CompressorControl(m_airSubsystem));

    dc_rBumper.whileTrue(new SlowModeToggle(m_montySubsystem)); 
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
