package com.C202044088.DepartureDelayCount;

import org.apache.hadoop.io.Text; 

public class AirlinePerformanceParser {
	
	private int year;
	private int month;
	
	private int departureDelayTime = 0;
	private int arriveDelayTime = 0;
	private int distance = 0;
	
	private boolean departureDelayAvailable = true;
	private boolean arriveDelayAvailable = true;
	private boolean distanceAvailable = true;
	
	private String uniqueCarrier;
	
	public AirlinePerformanceParser(Text text) {
		try {
			String[] col = text.toString().split(",");
			
			year = Integer.parseInt(col[0]);
			
			month = Integer.parseInt(col[1]);
			
			uniqueCarrier = col[8];
			
			if(!col[15].equals("NA")) {
				departureDelayTime = Integer.parseInt(col[15]);
			}else {
				departureDelayAvailable = false;
			}
			
			if(!col[14].equals("NA")) {
				arriveDelayTime = Integer.parseInt(col[14]);
			}else {
				arriveDelayAvailable = false;
			}
			
			if(!col[18].equals("NA")) {
				distance = Integer.parseInt(col[18]);
			} else {
				distanceAvailable = false;
			}
			
		}catch (Exception e) {
			System.out.println("Error parsing a record:" + e.getMessage());
		}
	}
	
	public int getYear() {return year;}
	
	public int getMonth() {return month;}
	
	public int getDepartureDelayTime() {return departureDelayTime;}
	
	public int getArriveDelayTime() {return arriveDelayTime;}
	
	public boolean isDepartureDelayAvailable() {return departureDelayAvailable;}
	
	public boolean isArriveDelayAvailable() {return arriveDelayAvailable;}
	
	public String getUniqueCarrier() {return uniqueCarrier;}
	
	public int getDistance() {return distance;}
	
	public boolean isDistanceAvailable() {return distanceAvailable;}
	
}
