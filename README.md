# DrunkDrivers
Given a text file with statistical data on car accidents, this program figures out the best hour of the week to be on the roads.

This application is currently being worked on. Check back later! :)

Contributors:
 - Johnathan R. Burgess, President, GTCC IT Club
 - Eric Hall, Vice-President, GTCC IT Club

Problem:

The National Highway Traffic Safety Administration has a database containing information on all of the fatal accidents in the United States, the Fatality Analysis Reporting System (FARS).  You are to write a program that reads a file to determine which hour of the week is most likely to have fatal accidents involving drunken drivers and which hour is the safest.

Input is in the file, accident.txt, where each line contains the following data for the year 2015 in which there were over 30,000 accidents.  The data in each line of the file is:

day	Day of the month
month	month (1 = January, 2 = February, etc.)
DayOfWeek	The day of the week of the accident where 1 = Sunday, 2 = Monday, …, 7 = Saturday
hour	The hour 0 – 23, the accident occurred.  A value of 99 is used when the hour is unknown.
minute	The minute of the hour 0 – 59, the accident occurred.  A value of 99 is used when the time is unknown.
drunkDrv	non-zero if this accident involved a drunken driver and 0 otherwise

Ignore any line of data where the hour or minute is greater than 23.

Your program must display the day of the week and hour of the day that has the largest percentage of drunk driver related accidents and the day of the week and hour of the day with the lowest percentage of accidents involving drunks.  Percentages can be displayed with any accuracy with one or more digits to the right of the decimal point.

Sample input
1	1	5	2	40	1
1	1	5	22	13	0
1	1	5	1	25	1
4	1	1	0	57	1
7	1	4	7	9	0
8	1	5	9	59	0
8	1	5	18	33	0
3	1	7	21	30	0
13	1	3	8	0	0
5	1	2	18	45	0

remaining 32,156 more lines can be found in the sample data input file.

Sample output
Most drunk accidents 68.0% on Saturday at 2:00
Least drunk accidents  2.8% on Tuesday at 9:00
