# Percolation Project
A java program that runs a Monte-Carlo simulation to find the percolation threshold to solve the dynamic connectivity problem. This program also outputs the mean, the standard deviation and the 95% confidence interval for the simulation.

## Dependencies
1. University of Princeton online textbook libraries.
```
cd /usr/local
sudo curl -O "https://lift.cs.princeton.edu/java/linux/lift-cli.zip"
sudo unzip lift-cli.zip
sudo rm lift-cli.zip
```
further instructions can be found at: https://lift.cs.princeton.edu/java/linux/

## Usage
The program is run by the following command with 2 commandline arguments: a positive integer n which represents a desired grid size of n-by-n and a positive integer numTrials representing the number of trials to be run.
```
javac-algs4 PercolationStats.java gridSize numTrials
```

## APIs Used
WeightedQuickFindUnionUF: https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/QuickFindUF.html  
StdRandom: https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdRandom.html  
StdStats: https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdStats.html

## Credits
Princeton University for providing the specifications and required libraries for the project.
