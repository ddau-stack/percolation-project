# percolation-project
This project runs a Monte-Carlo simulation to find the percolation threshold to solve the dynamic connectivity problem. Stats of the percolation threshold are provided as well.

## Dependencies
1. University of Princeton online textbook libraries.
```
~> cd /usr/local
/usr/local/> sudo curl -O "https://lift.cs.princeton.edu/java/linux/lift-cli.zip"
/usr/local/> sudo unzip lift-cli.zip
/usr/local/> sudo rm lift-cli.zip
```

## Usage
The program is run by the following command with 2 commandline arguments: a positive integer gridSize which represents a grid of n-by-n size and a positive integer numTrials representing the number of trials to be run.
```
javac-algs4 PercolationStats.java gridSize numTrials
```
