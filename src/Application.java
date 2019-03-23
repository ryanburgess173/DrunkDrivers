import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Application {
    // treat as a static class
    enum SpecificDay{

        // calling constructor
        Sunday(1),
        Monday(2),
        Tuesday(3),
        Wednesday(4),
        Thursday(5),
        Friday(6),
        Saturday(7);

        int day;

        // constructor is all
        SpecificDay(int index){
            day = index;
        }

        public static SpecificDay dayOf(int value){
            switch(value){
                case 1: return Sunday;
                case 2: return Monday;
                case 3: return Tuesday;
                case 4: return Wednesday;
                case 5: return Thursday;
                case 6: return Friday;
                case 7: return Saturday;
            }
            return null;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        /*
        DataGenerator dg = new DataGenerator(300000); // pass however many lines of data you want
        for(int i=0; i < 300000; i++){
            System.out.println();
        }
        */
        // % Statistics
        double[][] percentageOfDrunkAccidents = new double[7][24];

        int[][] accidents = new int[7][24];
        int[][] drunkAccidents = new int[7][24];

        try{
            File file1 = new File("src/accident.txt");
            Scanner sc1 = new Scanner(file1);
            while(sc1.hasNextLine()){
                String line = sc1.nextLine();
                String[] report = line.split("\t");
                if(Integer.parseInt(report[3]) <= 23){

                    int day = Integer.parseInt(report[2]);
                    int hour = Integer.parseInt(report[3]);

                    // increment accidents[day][hour] by 1
                    accidents[day-1][hour]++;

                    boolean isDrunk = Integer.parseInt(report[5]) > 0;
                    if(isDrunk){
                        // increment drunkAccidents[day][hour] by 1
                        drunkAccidents[day-1][hour]++;
                    }
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        double min = Double.MAX_VALUE;
        int minDay=0, minHour=0;
        double max = Double.MIN_VALUE;
        int maxDay=0, maxHour=0;

        for (int day=0; day < 7; day++) {
            for (int hour=0; hour < 24; hour++) {
                // if we won't have division by zero
                if (accidents[day][hour]!=0) {
                    double percentage = (drunkAccidents[day][hour] / (double)accidents[day][hour]);
                    percentageOfDrunkAccidents[day][hour] = percentage;
                    if(percentage < min){
                        min = percentage;
                        minDay = day+1;
                        minHour = hour;
                    }
                    if(percentage > max){
                        max = percentage;
                        maxDay = day+1;
                        maxHour = hour;
                    }
                }
            }
        }
        System.out.println(max);
        System.out.println(maxDay);
        System.out.println(maxHour);
        System.out.println();
        System.out.println(min);
        System.out.println(minDay);
        System.out.println(minHour);
        // program output
        System.out.println("Worst day and hour of the week to be on the roads: ");
        System.out.println(SpecificDay.dayOf(maxDay));
        System.out.println(maxHour+":00");
        System.out.println("Best day and hour of the week to be on the roads: ");
        System.out.println(SpecificDay.dayOf(minDay));
        System.out.println(minHour+":00");
    }
}