package com.tw.rover.environment;

public class Coordinate {

	int x;
	int y;
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void incrementX(){
		this.x++;
	}
	
	public void incrementY(){
		this.y++;
	}
	
	public Coordinate move(Direction direction) {

		switch (direction) {
		case NORTH:
			return new Coordinate(this.getX(), this.getY() + 1);
		case SOUTH:
			return new Coordinate(this.getX(), this.getY() - 1);
		case EAST:
			return new Coordinate(this.getX() + 1, this.getY());
		case WEST:
			return new Coordinate(this.getX() - 1, this.getY());
		}
		return new Coordinate(this.getX(), this.getY() + 1);
	}
}
