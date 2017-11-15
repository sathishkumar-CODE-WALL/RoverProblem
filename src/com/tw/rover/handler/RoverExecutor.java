package com.tw.rover.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.tw.rover.command.ICommand;
import com.tw.rover.command.MoveCommand;
import com.tw.rover.command.TurnLeftCommand;
import com.tw.rover.command.TurnRightCommand;
import com.tw.rover.environment.Coordinate;
import com.tw.rover.environment.Direction;
import com.tw.rover.environment.Floor;
import com.tw.rover.robot.Rover;

public class RoverExecutor {
			
	public static final String SPACE = " ";
	public static final Map<String, ICommand> commandMap;
	
	static
    {
		commandMap = new HashMap<String, ICommand>();
		commandMap.put("L", new TurnLeftCommand());
		commandMap.put("R", new TurnRightCommand());
		commandMap.put("M", new MoveCommand());
    }
	
	public static void main(String args[]){
		
		Scanner sc=new Scanner(System.in);
		String topCoordinates = sc.nextLine();
		String[] topXY = topCoordinates.split(SPACE);
		
		int XCoordinate = Integer.parseInt(topXY[0]);
		int YCoordinate = Integer.parseInt(topXY[1]);
						
		Floor floor = new Floor(new Coordinate(0,0), new Coordinate(XCoordinate, YCoordinate));
		
		
		String positionInp = sc.nextLine();
		String[] position = positionInp.split(SPACE);
		
		int XPosition = Integer.parseInt(position[0]);
		int YPosition = Integer.parseInt(position[1]);
		String direction = position[2];
		Coordinate coordinate = new Coordinate(XPosition,YPosition);
		Rover rover = new Rover(floor, coordinate,Direction.findByCode(direction));
		
		String commandsInp = sc.nextLine();
		char[] commandCharArray = commandsInp.toCharArray();
		
		List<ICommand> commandList = new ArrayList<ICommand>();
		
		for(int counter=0; counter < commandCharArray.length ; counter++){
			commandList.add(commandMap.get(String.valueOf(commandCharArray[counter])));
		}
		
		rover.executeCommands(commandList);
		
		System.out.println(rover.getCoordinate().getX() + SPACE +rover.getCoordinate().getY() + SPACE + rover.getDirection().getDirCode());
		
	}

}
