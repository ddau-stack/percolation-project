import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	Percolation simulation;
	double[] percolationRates;
	double numTrials;

	public PercolationStats(int n, int trials) {
		if(n <= 0 || trials <= 0) throw new IllegalArgumentException();

		numTrials = trials;
	 	percolationRates = new double[trials];

	 	//runs simulations
		for(int i = 0; i < trials; i++) {
			simulation = new Percolation(n);
			while(!simulation.percolates()) {
				simulation.open(StdRandom.uniform(1,n+1), StdRandom.uniform(1,n+1));
			}
		 percolationRates[i] = (double)(simulation.numberOfOpenSites())/(double)(n * n);
		}
	}

	public double mean() {
		return StdStats.mean(percolationRates);
	}

	public double stddev() {
		return StdStats.stddev(percolationRates);
	}

	public double confidenceLo() {
		double result = 1.96 * (Math.sqrt(stddev())) / Math.sqrt(numTrials);
		result = mean() - result;
		return result;
	}

	public double confidenceHi() {
		double result = 1.96 * (Math.sqrt(stddev())) / Math.sqrt(numTrials);
		result += mean();
		return result;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		PercolationStats main = new PercolationStats(n, trials);

		//output
		System.out.printf("%-19s = %f\n", "mean", main.mean());
		System.out.printf("%-19s = %f\n", "stddev", main.stddev());
		System.out.printf("%-19s = [%f, %f]\n", "confidence interval", main.confidenceLo(), main.confidenceHi());
	}
}
