package edu.nyu.cs9053.homework8;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LambdaScheduler {

	 /**
     * @param jobs priority queue of input jobs
     * @param timeInterval  total interval of time for the jobs
     * @return arraylist of subset of jobs selected
     */
	 public List<Job> getMaximumSubsetOfJobs(Queue<Job> jobs, int timeInterval) 
	 {
	 	if(jobs == null)
	 		return null;
	 	else
	 	{
	 		List<Job> selectedJobs = new ArrayList<Job>(jobs.size());
	 		Job firstJob = jobs.poll();
	 		long firstJobDuration = firstJob.getEndTime() - firstJob.getStartTime();
	 		if(firstJobDuration <= timeInterval)
	 		{
				selectedJobs.add(firstJob);  // select the first job
				timeInterval -= firstJobDuration;
			}
		for(int i=1;i<=jobs.size();)
		{
			Job nextJob = jobs.poll();
			long nextJobDuration = nextJob.getEndTime() - nextJob.getStartTime();
			if(nextJob.getStartTime() >= firstJob.getEndTime() && nextJobDuration <= timeInterval )
			{
				selectedJobs.add(nextJob); // select next jobs if its compatible with first and within timeInterval
				timeInterval -= nextJobDuration;
				firstJob = nextJob;
			}
		}
		return selectedJobs;
	}
}
}