# Some exercises for kcsit

## Installation
### Java version: 11 
work inside kcsit - using maven

```bash
mvn clen install test
```

### 1.    Merge two maps
      Write a method that takes two maps as parameters and merge them. After that, print the output in the console. Both maps have String as key and Long as value.
#####Example:
Map 1 (key=value): A=1, B=1
Map 2 (key=value): A=1, B=1000, C=1000
Output: {A=2, B=1001, C=1000}
#####Implementation:
* kcsit/src/main/java/kcsit/ExerciseOne/MergeTwoMaps.java
#####Unit Test:
* kcsit/src/test/java/kcsit/ExerciseOne/MergeTwoMapsTest.java


### 2.Compute unique chars in a string
      Write a method that receives a string by parameter, then compute the number of unique chars and then return this compute value. The method could be called thousands of times with the same input value.
#####Example:
Input: Aa12
Output: 4

Input: A[}
Output:3

Input: null string
Output: 0

Input: $VmpKVloxbFhOV3RKUnpreFkyZHZTMk16VW5aamJWVm5XVmMxYTB3eU9YbEpSMFpxV1R[KV2VtTjVRbkJpYlZwMlkyMHhhR1JIYkhaaWFVSjJZbWxDYUVsSFVteGtiV3hxV2xOM1oyTXpWbXBoUTBKb1kzbENhbUl5
Output: 48

#####Implementation:
* kcsit/src/main/java/kcsit/ExerciseTwo/ComputeUniqueCharsInString.java
#####Unit Test:
* kcsit/src/test/java/kcsit/ExerciseTwo/ComputeUniqueCharsInStringTest.java


### 3. Implement new requirements in existing code
A given module of the application contains a feature that is responsible for processing a csv file. Basically, this processing reads some columns of each line of the file and then write the data in other files.
Now the business team asked us to perform some filtering in the data that is read from the csv file before outputting it to the final files. Basically, the initial requirement states that, for each row, if the value of the column 3 is found in another file (c:\invalid_data.csv), then the line should be skipped.
Your task is to write a code that implements this requirement. Your solution should follow good coding practices (clean code, SOLID, etc.). Also keep in mind that in the future more requirements could be added to this feature. For example: the business team could ask us to consider multiple columns in the filter, or even add a completely different filter logic that uses a computation based on values from the current line. So, your code should be extensible, should support adding/removing filters, should support evaluation of multiple filter for the same line, etc.
Unit tests are mandatory.

Sample data in the source csv file:
9004A;Lorem ipsum dolor;A85;1000.125547;8524;-1411.1;Lorem ipsum
8014CD;Lorem ipsum dolor;B02;2000.125547;5524;-5551.1;Lorem ipsum
000014A;Lorem ipsum dolor;C001;85250.12555;8524;8914.41;Lorem ipsum
080044Z;Lorem ipsum dolor;B01;8251.155;854;894.47;Lorem ipsum
...

Sample data in the invalid_data.csv file:
B01
B02
B03
A
AHUS58518SDSFWEEA85005

Expected output for the input above:
9004A;Lorem ipsum dolor;A85;1000.125547;8524;-1411.1;Lorem ipsum
000014A;Lorem ipsum dolor;C001;85250.12555;8524;8914.41;Lorem ipsum



4.    Find a performance issue and implement a fix for it:
      Imagine that the code bellow is facing some performance issues in production. You have the task to spot the biggest bottleneck in this code and write a code to fix it. Unit tests are not required for this exercise.
