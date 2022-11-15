package com.C202044088.DepartureDelayCount;

import java.io.IOException; 

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class DepartureDelayCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();
	private MultipleOutputs<Text, IntWritable> mos;
	
	@Override
	public void setup(Context context) throws IOException, InterruptedException {
		mos = new MultipleOutputs<Text, IntWritable>(context);
	}
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException{
//		for(IntWritable value : values)
//			sum += value.get();
//		result.set(sum);
//		mos.write("departure", key, result);
		Text outputKey = new Text();
		String[] colums = key.toString().split(",");
		outputKey.set(colums[1] + "," + colums[2]);
		
		if (colums[0].equals("D")) {
			int sum = 0;
			for (IntWritable value : values) {
				sum += value.get();
			}
			result.set(sum);
			mos.write("departure", outputKey, result);
		} else {
			int sum = 0;
			for (IntWritable value : values) {
				sum += value.get();
			}
			result.set(sum);
			mos.write("arrival", outputKey, result);
		}
	}
	
	@Override
	public void cleanup(Context context) throws IOException, InterruptedException {
		mos.close();
	}
}
