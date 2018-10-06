package org.firstinspires.ftc.teamcode.Year_2018_19.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Year_2018_19.Robot.BeltDriveRobot;

@TeleOp(name="BeltDriveTeleOp", group="TeleOpMode")
//@Disabled

public class BeltDriveTeleOp extends OpMode
{
    //Creates robot hardware.
    private BeltDriveRobot robot = new BeltDriveRobot();

    //Robot initiates hardware and components.
    public void init()
    {
        robot.init(hardwareMap);
        robot.playR2D2Sound(this.hardwareMap.appContext);
        telemetry.addData("Status", "Robot has initiated!");
        telemetry.update();
    }

    //Robot starts.
    public void start()
    {
        robot.playBB8Sound(this.hardwareMap.appContext);
        telemetry.addData("Status", "Robot has started!");
        telemetry.update();
    }

    //Called repeatedly after robot starts.
    public void loop()
    {
        robot.frontLeftDrive.setPower(-gamepad1.left_stick_y); //Controls top left motor
        robot.backLeftDrive.setPower(-gamepad1.left_stick_y); //Controls bottom left motor
        robot.frontRightDrive.setPower(-gamepad1.right_stick_y); //Controls top right motor
        robot.backRightDrive.setPower(-gamepad1.right_stick_y); //Controls bottom right motor

        if (this.gamepad1.x) {
            robot.playMusic(this.hardwareMap.appContext);
        }
        else if (gamepad1.y) {
            robot.stopMusic();
        }

        telemetry.addData("Front Left Drive", robot.frontLeftDrive.getPower());
        telemetry.addData("Front Right Drive", robot.frontRightDrive.getPower());
        telemetry.addData("Back Left Drive", robot.backLeftDrive.getPower());
        telemetry.addData("Back Right Drive", robot.backRightDrive.getPower());

        telemetry.update();
    }

    //Robot ends.
    public void stop()
    {
        robot.safetyStop();
        telemetry.addData("Status", "Robot has stopped!");
        telemetry.update();
    }
}