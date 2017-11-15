package com.tw.rover.environment;

public class Floor {

	Coordinate leftBottomCoordinate = new Coordinate(0,0);
	Coordinate rightTopCoordinate = new Coordinate(0,0);
	
	public Floor(Coordinate leftBottomCoordinate, Coordinate rightTopCoordinate) {
		this.leftBottomCoordinate = leftBottomCoordinate;
		this.rightTopCoordinate = rightTopCoordinate;
	}
	public Coordinate getLeftBottomCoordinate() {
		return leftBottomCoordinate;
	}
	public void setLeftBottomCoordinate(Coordinate leftBottomCoordinate) {
		this.leftBottomCoordinate = leftBottomCoordinate;
	}
	public Coordinate getRightTopCoordinate() {
		return rightTopCoordinate;
	}
	public void setRightTopCoordinate(Coordinate rightTopCoordinate) {
		this.rightTopCoordinate = rightTopCoordinate;
	}
	
	public boolean isXYCoordinateWithinBoundary(Coordinate newCoordinate){
		return isXCoordinateWithinBoundary(newCoordinate.getX()) && isYCoordinateWithinBoundary(newCoordinate.getY());
	}
	
	private boolean isXCoordinateWithinBoundary(int x){
		return x<=rightTopCoordinate.getX() && x>=leftBottomCoordinate.getX();
	}
	
	private boolean isYCoordinateWithinBoundary(int y){
		return y<=rightTopCoordinate.getY() && y>=leftBottomCoordinate.getY();
	}
	
}
