package com.C202044088.DepartureDelayCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.C202044088.DepartureDelayCount.AirlinePerformanceParser;
import com.C202044088.DepartureDelayCount.DelayCounters;

import java.io.IOException; 

public class DepartureDelayCountMapper extends Mapper<LongWritable, Text, DateKey, IntWritable>{
	
	private final static IntWritable outputValue = new IntWritable(1);
	private DateKey outputKey = new DateKey();
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		AirlinePerformanceParser parser = new AirlinePerformanceParser(value);
		
		if (parser.isDepartureDelayAvailable()) {
			if (parser.getDepartureDelayTime() > 0) {
				outputKey.setYear("D," + parser.getYear());
				outputKey.setMonth(parser.getMonth());
				
				context.write(outputKey, outputValue);
			} else if {
				//edit start here
			}
		}
		
		if (parser.isArriveDelayAvailable()) {
			if (parser.getArriveDelayTime() > 0) {
				outputKey.setYear("A,"+ parser.getYear());
				outputKey.setMonth(parser.getMonth());
				context.write(outputKey, outputValue);
			}
		}

	}
}
