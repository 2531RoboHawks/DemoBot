package org.usfirst.frc.team2531.robot.subsystems;

import org.usfirst.frc.team2531.robot.commands.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	CANTalon motorFL = new CANTalon(2);
	CANTalon motorFR = new CANTalon(1);
	CANTalon motorBL = new CANTalon(4);
	CANTalon motorBR = new CANTalon(3);

	public Drive() {

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

		setDefaultCommand(new TankDrive());
	}

	public void tankDrive(Joystick joystick) {
		double x = joystick.getRawAxis(0);
		double y = joystick.getRawAxis(1);
		double z = joystick.getRawAxis(2);
		double left = (y + x) * z;
		double right = (y - x) * z;
		motorFL.set(left);
		motorBL.set(left);
		motorFR.set(right);
		motorBR.set(right);
	}
}
