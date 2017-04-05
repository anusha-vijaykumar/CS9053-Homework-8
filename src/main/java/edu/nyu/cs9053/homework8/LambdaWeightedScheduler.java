package edu.nyu.cs9053.homework8;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LambdaWeightedScheduler {

	 /**
     * @param jobs arraylist of input jobs
     * @param timeInterval  total interval of time for the jobs
     * @return arraylist of subset of jobs selected
     */
	 public WeightedJob getMaximumProfitSubsetOfJobs(List<Job> jobs)
	 {
	 	if(jobs == null)
	 		return null;
	 	else
	 	{
	 		int numberOfJobs = jobs.size();
	 		List<WeightedJob> weightedJobs = new ArrayList<WeightedJob>(numberOfJobs);
	 		List<Job> job = new ArrayList<Job>(numberOfJobs);
	 		Collections.sort(jobs); // sort the input jobs with respect to finish time
	 		job.add(jobs.get(0));
	 		weightedJobs.add(0,new WeightedJob(job, jobs.get(0).getWeight()));
	 		checkJobCompatability(weightedJobs,numberOfJobs,jobs);
			return weightedJobs.get(numberOfJobs-1);
	 	}
	 	
	 }

	 /**
     * @param jobs arraylist of input jobs
     * @param index the pointer to be searched
     * @return mid if value if found else -1
     */
	 private int getNonConflictingJob(List<Job> jobs, int index)
	 {
	 	int low = 0, high = index - 1;
	 	while (low <= high)
	 	{
	 		int mid = (low + high) / 2;
	 		if (jobs.get(mid).getEndTime() <= jobs.get(index).getStartTime())
	 		{
	 			if (jobs.get(mid+1).getEndTime() <= jobs.get(index).getStartTime())
	 				low = mid + 1;
	 			else
	 				return mid;
	 		}
	 		else
	 			high = mid - 1;
	 	}

	 	return -1;
	 }

	 /**
     * @param weightedJobs arraylist of Jobs subset
     * @param numberOfJobs total number of jobs
     */
	 private void checkJobCompatability(List<WeightedJob> weightedJobs, int numberOfJobs, List<Job> jobs)
	 {
	 	for(int i=1; i < numberOfJobs; i++){
	 			long weightIncluded= jobs.get(i).getWeight();
	 			int indexOfnonConflictingJob = getNonConflictingJob(jobs, i);
	 			if (indexOfnonConflictingJob != -1)
	 				weightIncluded += weightedJobs.get(indexOfnonConflictingJob).getWeightValue();

	       // Store maximum of included and excluded values
	 			if (weightIncluded > weightedJobs.get(i-1).getWeightValue())
	 			{
	 				if(weightedJobs.get(indexOfnonConflictingJob).getJobs() != null)
	 				{
	 					List<Job> aJob = new ArrayList<Job>(weightedJobs.get(indexOfnonConflictingJob).getJobs()); 
	 					aJob.add(jobs.get(i));
	 					weightedJobs.add(i,new WeightedJob(aJob, weightIncluded));
	 				}
	 			}
	 			else
	           // remove the current job if its not max value
	 				weightedJobs.add(i,weightedJobs.get(i-1));
	 		}
	 }

	}
