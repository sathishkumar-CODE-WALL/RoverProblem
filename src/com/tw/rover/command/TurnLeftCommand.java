package com.tw.rover.command;

import com.tw.rover.robot.Rover;

public class TurnLeftCommand implements ICommand{
	@Override
	public void execute(Rover rover) {
		rover.turnLeft();
		
	}
}
