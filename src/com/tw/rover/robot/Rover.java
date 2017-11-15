package com.tw.rover.robot;

import java.util.List;

import com.tw.rover.command.ICommand;
import com.tw.rover.environment.Coordinate;
import com.tw.rover.environment.Direction;
import com.tw.rover.environment.Floor;

public class Rover {
	
	Coordinate coordinate;
	Direction direction;
	Floor floor;
	
	public Rover(Floor floor,Coordinate coordinate, Direction direction) {
		this.coordinate = coordinate;
		this.direction = direction;
		this.floor = floor;
	}

	public void turnLeft(){
		this.direction = this.direction.turnLeft(direction);
	}
	
	public void turnRight(){
		this.direction = this.direction.turnRight(direction);
	}
	
	public void move(){
		Coordinate newCoordinate = this.coordinate.move(this.direction);
		if(floor.isXYCoordinateWithinBoundary(newCoordinate)){
			this.coordinate = newCoordinate;
		}
	}
	
	
	
	public void executeCommands(List<ICommand> cmdList){
		for(ICommand command : cmdList){
			command.execute(this);
		}
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
