// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AirSubsystem extends SubsystemBase {
  private final PneumaticsControlModule pcm = new PneumaticsControlModule(Constants.PNEUMATIC_CONTROL_MODULE);
  private final Solenoid cannon1 = pcm.makeSolenoid(Constants.CANNON_1);
  private final Solenoid cannon2 = pcm.makeSolenoid(Constants.CANNON_2);
  private final Solenoid cannon3 = pcm.makeSolenoid(Constants.CANNON_3);
  private final Solenoid cannon4 = pcm.makeSolenoid(Constants.CANNON_4);
  private final Solenoid cannon5 = pcm.makeSolenoid(Constants.CANNON_5);
  private final Solenoid cannon6 = pcm.makeSolenoid(Constants.CANNON_6);
  private boolean compressorIsOn= false;

  public AirSubsystem() {}
  @Override
  public void periodic() {
  }
    public void fireCannon1(){
      cannon1.set(true);
    }

    public void fireCannon2(){
      cannon2.set(true);
    }

    public void fireCannon3(){
      cannon3.set(true);
    }

    public void fireCannon4(){
      cannon4.set(true);
    }

    public void fireCannon5(){
      cannon5.set(true);
    }

    public void fireCannon6(){
      cannon6.set(true);
    }

    public void disableCannon(){
      cannon1.set(false);
      cannon2.set(false);
      cannon3.set(false);
      cannon4.set(false);
      cannon5.set(false);
      cannon6.set(false);
    }

    public void fireAllCannons(){
      cannon1.set(true);
      cannon2.set(true);
      cannon3.set(true);
      cannon4.set(true);
      cannon5.set(true);
      cannon6.set(true);
    }

    public boolean isCompressorOn(){
      return compressorIsOn; 
    }

    public void turnCompressorOff(){
      compressorIsOn = false; 
      pcm.disableCompressor();
    }
  
    public void turnCompressorOn(){
      compressorIsOn = true; 
      pcm.enableCompressorDigital();
    }
}