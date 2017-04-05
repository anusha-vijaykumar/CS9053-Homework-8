package edu.nyu.cs9053.homework8;
/**
 * User: anusha
 * Date: 4/4/17
 * 
 *
 * Lambda Job
 */
class Job implements Comparable<Job>{
	private final long startTime;
	private final long endTime;
	private final long weight;
	
	public Job(long startTime, long endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.weight = 0;
	}
	public Job(long startTime, long endTime, long weight)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		this.weight = weight;
	}
	
	public long getStartTime() {
		return startTime;
	}
	
	public long getEndTime() {
		return endTime;
	}
	
	
	public long getWeight() {
		return weight;
	}
	@Override
	public int compareTo(Job o) {
		if(this.endTime <= o.endTime)
			return -1;
		else 
			return 1;
	}
	
}