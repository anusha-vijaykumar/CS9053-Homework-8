package edu.nyu.cs9053.homework8;
import java.util.List;
import java.util.ArrayList;
/**
 * User: anusha
 * Date: 4/4/17
 * 
 *
 * Lambda Weighted Job Subset
 */
public class WeightedJob{
	private final List<Job> jobs;
	private final long weightValue;
	WeightedJob(List<Job> jobs, long weightValue){
		this.jobs = new ArrayList<Job>(jobs);
		this.weightValue = weightValue;
	}
	public long getWeightValue(){
		return this.weightValue;
	}
	public List<Job> getJobs(){
		return this.jobs;
	}
}