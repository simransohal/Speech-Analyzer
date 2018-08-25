# Speech Analyzer Data Visualization using D3

Project by Simran Sohal


## Description

Data Visualization to view the overall connotation of a piece of text.

## Running

D3 needs to be run from a webserver due to how it imports data files.

So, to run this visualization locally, from the Terminal, navigate to the directory you checked it out to

```
cd ~/code/path/to/Speech-Analyzer
```

Then start a webserver locally. If you are on a Linux or Mac, you should be able to use python's built in webserver:

```
python -m SimpleHTTPServer 3000
```

Yay, you just created a local server!

To run the visualization open the browser and run this page:
```
http://localhost:3000
```

## Loading New Data

If you load a speech with too few/much words the size of the bubble can get funky. Consider this my warning :)

1. Find a speech that you want to analyze.
2. Navigate to speechAnalyzer/src/ and locate the "speech.txt" file.
3. Paste the new speech into that file.
4. Open Terminal and navigate to the bubble_chart directory.
5. Type these commands to generate the csv file using "speechAnalyzer.java".
```
cd speechAnalyzer/src
javac speechAnalyzer.java
java speechAnalyzer > speech.csv

```

Woohoo you did it!

## Credit

https://github.com/vlandham/gates_bubbles
