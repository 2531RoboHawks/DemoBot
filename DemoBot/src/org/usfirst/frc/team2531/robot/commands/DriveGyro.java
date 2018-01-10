package org.usfirst.frc.team2531.robot.commands;

import org.usfirst.frc.team2531.robot.Robot;
import org.usfirst.frc.team2531.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import frclib.pid.PID;

/**
 *
 */
public class DriveGyro extends Command {
	private double pow, angle;
	private PID pid = new PID(0.05, 0, 0, 0);

	public DriveGyro(double p) {
		requires(Robot.drive);
		pow = p;
		pid.setOutputLimits(-0.5, 0.5);
	}

	protected void initialize() {
		System.out.println("-> TimeDrive");
		angle = RobotMap.imu.getAngleZ();
		pid.setSetpoint(angle);
	}

	protected void execute() {
		double t = pid.compute(RobotMap.imu.getAngleZ());
		Robot.drive.arcadeDrive(0, -pow);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drive.arcadeDrive(0, 0);
		System.out.println("-! TimeDrive");
	}

	protected void interrupted() {
		end();
	}
}
