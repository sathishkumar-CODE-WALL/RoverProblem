package com.tw.rover.environment;

public enum Direction {

	NORTH("N"),
	SOUTH("S"),
	EAST("E"),
	WEST("W");
	
	private String dirCode;
	
	Direction(String dirCode){
		this.dirCode = dirCode;
	}
	
	public String getDirCode(){
		return dirCode;
	}
	
	
	public static Direction findByCode(String dirCode){
	    for(Direction dir : values()){
	        if( dir.getDirCode().equals(dirCode)){
	            return dir;
	        }
	    }
	    return null;
	}
	
  public Direction turnLeft(Direction currentDirection){
	  switch(currentDirection){
	  case NORTH :
	  	return WEST;
	  case SOUTH :
		return EAST;
	  case EAST :
		return NORTH;
	  case WEST :
		return SOUTH;
	  }
	return currentDirection;
  }
  
  public Direction turnRight(Direction currentDirection){
	  switch(currentDirection){
	  case NORTH :
	  	return EAST;
	  case SOUTH :
		return WEST;
	  case EAST :
		return SOUTH;
	  case WEST :
		return NORTH;
	  }
	return currentDirection;
  }
	
}
