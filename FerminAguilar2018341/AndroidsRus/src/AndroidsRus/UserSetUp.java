/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndroidsRus;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author fermin
 */
public class UserSetUp
{

    //creation of SN random variable
    Random rG = new Random();
    //creation of SN scanner variable
    Scanner scan = new Scanner(System.in);
    //initialize names of robots second generation
    String nameSecGen[] = {"Andy the Android", "Betty the Busibot", "Bobi the racedroid", "Fred the Friendlybot"};
 
    //Create one hashmap to first generation robot and Treemap to second generation robots
    HashMap<Integer, Robot> hm1 = new HashMap<>();
    Map<Integer, Robot> Maphm1 = new TreeMap<>();
    Map<Integer, Robot> Maphm2 = new TreeMap<>();
    Map<Integer, Robot> Maphm3 = new TreeMap<>();
    private int SN;

    public void FirstGenRobots(int robotsFirstGen, int robotsSecondGen, int minFirstGen, int maxFirstGen, int minSecondGen, int maxSecondGen)
    {
            //declare SN Integer Serial Number
    Integer SN;

        //clear Maphm1, Maphm2 ,Maphm3 and hashmap1 
        Maphm1.clear();
        Maphm2.clear();
        Maphm3.clear();
        hm1.clear();
        //String[] serialNumber=new String[nFirstGen];
        Random rG = new Random();

        //Creation of first generation robots
        for (int i = 0; i < robotsFirstGen; i++) {
            Robot Rob = new Robot();

            //create random serial number
            do {
                SN = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
            } //check the serila number generated should not repeat
            while (hm1.containsKey(SN));
            //set this serial number to the robot
            Rob.setSerialNumber(SN);
            RobotSetUp su = new RobotSetUp();
            Rob = su.fill(Rob);
            // create hashmap based on serial number and Robots
            hm1.put(SN, Rob);
        }
        //Copy all elements from hm1 to Maphm1
        Maphm1.putAll(hm1);

        //print data Robot first generation
        System.out.println("Data Robot First Generation");
        Maphm1.forEach((k, v) -> System.out.println("Serial Number: " + k + v));

        System.out.println("----------------------");
        System.out.println("|       SUCCESFUL    |");
        System.out.println("----------------------");

        //Go to generate robot second generation
        FirstGenDonated(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
    }

    public void FirstGenDonated(Map<Integer, Robot> Maphm1, Map<Integer, Robot> Maphm2, Map<Integer, Robot> Maphm3, int robotsFirstGen, int robotsSecondGen, int minFirstGen, int maxFirstGen, int minSecondGen, int maxSecondGen)
    {
        //Copy all elements from MapHm1 to Maphm2
        Maphm2.putAll(Maphm1);

        //declare int to generate random numbers
        int randomRobot2;
        int randomRobot3;
        int randomRobot4;
        int randomRobot5;
        int randomRobot6;
        int randomRobot7;

        //create an array of 6 spot to store 6 serial numbers
        long[] rGRobot = new long[6];

        //Create robot second generation from 0 to "N" robots (Please check Main metodh)
        for (int i = 0; i < robotsSecondGen; i++) {

            //Start Serial Number
            do {
                //Generate SN Serial number
                SN = rG.nextInt(maxSecondGen - minSecondGen) + minSecondGen;
            } 
            //check that Serial number is unique for the new robot second generation
            while (Maphm3.containsKey(SN));
            //End Seria Number

            //Start name
            //select by random SN name for each robot second generation
            String robotName = nameSecGen[rG.nextInt(nameSecGen.length)];
            //Finish name

            //Start Brain
            do {
                //Generate SN serial number to search in robot first generaton
                randomRobot2 = rG.nextInt(maxSecondGen - minSecondGen) + minSecondGen;
                //the new random serial number must be exist in the Mapmh2 (first generation robot)
                //if this false must be select SN new random serial number
                do {
                    //Generate SN serial number to search in robot first generaton
                    randomRobot2 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                    //if the random serial number not exist in the robot first generation
                } while (Maphm2.containsKey(randomRobot2) == false);
            } //code : Maphm2.get(randomRobot2) == null  Means if No exit such SN object with this serial number
            //code : Maphm2.get(randomRobot2).getBrain() == "null" Means if the part is "null" it has to be select SN new random serial number
            while (Maphm2.get(randomRobot2) == null || Maphm2.get(randomRobot2).getBrain() == "null");
            //declare SN String as SN variable which holds
            //code : Maphm2.get(randomRobot2).getBrain() Means part donated by robot first generations
            //code : Maphm2.get(randomRobot2).getName() Means the name of the robot which is the donater
            //code : Maphm2.get(randomRobot2).getSerialNumber() Means the serial number robot first generation
            String robotBrain = Maphm2.get(randomRobot2).getBrain() + " (" + Maphm2.get(randomRobot2).getName() + " serialNum: " + Maphm2.get(randomRobot2).getSerialNumber() + ")";
            //the serial number of the robot first generation is store in the array rGRobot
            rGRobot[0] = Maphm2.get(randomRobot2).getSerialNumber();
            //set the value to "null" as the part was taken to the new robot
            Maphm2.get(randomRobot2).setBrain("null");
            //end Brain

            //start Mobility
            do {
                //Generate SN serial number to search in robot first generaton
                randomRobot3 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                //the new random serial number must be exist in the Mapmh2 (first generation robot)
                //if this false must be select SN new random serial number
                do {
                    randomRobot3 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                    //if the random serial number not exist in the robot first generation
                } while (Maphm2.containsKey(randomRobot3) == false);
                //the serial number of the robot first generation is store in the array rGRobot
                rGRobot[1] = Maphm2.get(randomRobot3).getSerialNumber();
            } //code : Maphm2.get(randomRobot3) == null  Means if No exit such SN object with this serial number
            //code : Maphm2.get(randomRobot3).getBrain() == "null" Means if the part is "null" it has to be select SN new random serial number
            while (Maphm2.get(randomRobot3) == null || Maphm2.get(randomRobot3).getMobility() == "null");
            //declare SN String as SN variable which holds
            //code : Maphm2.get(randomRobot3).getMobility() Means part donated by robot first generations
            //code : Maphm2.get(randomRobot3).getName() Means the name of the robot which is the donater
            //code : Maphm2.get(randomRobot3).getSerialNumber() Means the serial number robot first generation
            String robotMobility = Maphm2.get(randomRobot3).getMobility() + " (" + Maphm2.get(randomRobot3).getName() + " serialNum: " + Maphm2.get(randomRobot3).getSerialNumber() + ")";
            //set the value to "null" as the part was taken to the new robot
            Maphm2.get(randomRobot3).setMobility("null");
            //end mobility

            //start vision
            do {
                //Generate SN serial number to search in robot first generaton
                randomRobot4 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                //the new random serial number must be exist in the Mapmh2 (first generation robot)
                //if this false must be select SN new random serial number
                do {
                    randomRobot4 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                    //if the random serial number not exist in the robot first generation
                } while (Maphm2.containsKey(randomRobot4) == false);
                //the serial number of the robot first generation is store in the array rGRobot
                rGRobot[2] = Maphm2.get(randomRobot4).getSerialNumber();
            } //code : Maphm2.get(randomRobot4) == null  Means if No exit such SN object with this serial number
            //code : checkTwiceRepetion(rGRobot, 2) == true Means check if the part of one robot is NOT more than 2
            //code : Maphm2.get(randomRobot4).getBrain() == "null" Means if the part is "null" it has to be select SN new random serial number
            while (Maphm2.get(randomRobot4) == null || checkTwiceRepetion(rGRobot, 2) == true || Maphm2.get(randomRobot4).getVision() == "null");
            //declare SN String as SN variable which holds
            //code : Maphm2.get(randomRobot4).getVision() Means part donated by robot first generations
            //code : Maphm2.get(randomRobot4).getName() Means the name of the robot which is the donater
            //code : Maphm2.get(randomRobot4).getSerialNumber() Means the serial number robot first generation
            String robotVision = Maphm2.get(randomRobot4).getVision() + " (" + Maphm2.get(randomRobot4).getName() + " serialNum: " + Maphm2.get(randomRobot4).getSerialNumber() + ")";
            //set the value to "null" as the part was taken to the new robot
            Maphm2.get(randomRobot4).setVision("null");
            //end vision

            //start arms
            do {
                //Generate SN serial number to search in robot first generaton
                randomRobot5 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                //the new random serial number must be exist in the Mapmh2 (first generation robot)
                //if this false must be select SN new random serial number
                do {
                    randomRobot5 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                    //if the random serial number not exist in the robot first generation
                } while (Maphm2.containsKey(randomRobot5) == false);
                //the serial number of the robot first generation is store in the array rGRobot
                rGRobot[3] = Maphm2.get(randomRobot5).getSerialNumber();
            } //code : Maphm2.get(randomRobot5) == null  Means if No exit such SN object with this serial number
            //code : checkTwiceRepetion(rGRobot, 2) == true Means check if the part of one robot is NOT more than 2
            //code : Maphm2.get(randomRobot5).getArms() == "null" Means if the part is "null" it has to be select SN new random serial number
            while (Maphm2.get(randomRobot5) == null || checkTwiceRepetion(rGRobot, 3) == true || Maphm2.get(randomRobot5).getArms() == "null");
            //declare SN String as SN variable which holds
            //code : Maphm2.get(randomRobot5).getArms() Means part donated by robot first generations
            //code : Maphm2.get(randomRobot5).getName() Means the name of the robot which is the donater
            //code : Maphm2.get(randomRobot5).getSerialNumber() Means the serial number robot first generation
            String robotArms = Maphm2.get(randomRobot5).getArms() + " (" + Maphm2.get(randomRobot5).getName() + " serialNum: " + Maphm2.get(randomRobot5).getSerialNumber() + ")";
            //set the value to "null" as the part was taken to the new robot
            Maphm2.get(randomRobot5).setArms("null");
            //end arms

            //start Media Center
            do {
                //Generate SN serial number to search in robot first generaton
                randomRobot6 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                //the new random serial number must be exist in the Mapmh2 (first generation robot)
                //if this false must be select SN new random serial number
                do {
                    randomRobot6 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                    //if the random serial number not exist in the robot first generation
                } while (Maphm2.containsKey(randomRobot6) == false);
                //the serial number of the robot first generation is store in the array rGRobot
                rGRobot[4] = Maphm2.get(randomRobot6).getSerialNumber();
            } //code : Maphm2.get(randomRobot6) == null  Means if No exit such SN object with this serial number
            //code : checkTwiceRepetion(rGRobot, 2) == true Means check if the part of one robot is NOT more than 2
            //code : Maphm2.get(randomRobot6).getMediaCenter() == "null" Means if the part is "null" it has to be select SN new random serial number
            while (Maphm2.get(randomRobot6) == null || checkTwiceRepetion(rGRobot, 4) == true || Maphm2.get(randomRobot6).getMediaCenter() == "null");
            //declare SN String as SN variable which holds
            //code : Maphm2.get(randomRobot6).getArms() Means part donated by robot first generations
            //code : Maphm2.get(randomRobot6).getName() Means the name of the robot which is the donater
            //code : Maphm2.get(randomRobot6).getSerialNumber() Means the serial number robot first generation
            String robotMediaCenter = Maphm2.get(randomRobot6).getMediaCenter() + " (" + Maphm2.get(randomRobot6).getName() + " serialNum: " + Maphm2.get(randomRobot6).getSerialNumber() + ")";
            //set the value to "null" as the part was taken to the new robot
            Maphm2.get(randomRobot6).setMediaCenter("null");
            //end Media Center

            //start Power Plant
            do {
                //Generate SN serial number to search in robot first generaton
                randomRobot7 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                //the new random serial number must be exist in the Mapmh2 (first generation robot)
                //if this false must be select SN new random serial number
                do {
                    randomRobot7 = rG.nextInt(maxFirstGen - minFirstGen) + minFirstGen;
                    //if the random serial number not exist in the robot first generation
                } while (Maphm2.containsKey(randomRobot7) == false);
                //the serial number of the robot first generation is store in the array rGRobot
                rGRobot[5] = Maphm2.get(randomRobot7).getSerialNumber();
            } //code : Maphm2.get(randomRobot6) == null  Means if No exit such SN object with this serial number
            //code : checkTwiceRepetion(rGRobot, 2) == true Means check if the part of one robot is NOT more than 2
            //code : Maphm2.get(randomRobot6).getMediaCenter() == "null" Means if the part is "null" it has to be select SN new random serial number
            while (Maphm2.get(randomRobot7) == null || checkTwiceRepetion(rGRobot, 5) == true || Maphm2.get(randomRobot7).getPowerPlant() == "null");
            //declare SN String as SN variable which holds
            //code : Maphm2.get(randomRobot6).getArms() Means part donated by robot first generations
            //code : Maphm2.get(randomRobot6).getName() Means the name of the robot which is the donater
            //code : Maphm2.get(randomRobot6).getSerialNumber() Means the serial number robot first generation
            String robotPowerPlant = Maphm2.get(randomRobot7).getPowerPlant() + " (" + Maphm2.get(randomRobot7).getName() + " serialNum: " + Maphm2.get(randomRobot7).getSerialNumber() + ")";
            //set the value to "null" as the part was taken to the new robot
            Maphm2.get(randomRobot7).setPowerPlant("null");
            //end Power Plant

            //Create SN robot second generation with the constructors and taking parts from the robot first generation
            Robot Rob = new Robot(robotName, robotBrain, robotMobility, robotVision, robotArms, robotMediaCenter, robotPowerPlant);

            //The serial number and the Robot object will be store in SN Map
            Maphm3.put(SN, Rob);
        }
        new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);

    }

    //metodh to sear for SN particular model
    public void partModel(Map<Integer, Robot> Maphm3, String modelAndroid, int robotsFirstGen, int robotsSecondGen, int minFirstGen, int maxFirstGen, int minSecondGen, int maxSecondGen)
    {
        String choice;

        //print Map
        for (Map.Entry<Integer, Robot> entry : Maphm3.entrySet()) {
            Integer key = entry.getKey();
            Robot value = entry.getValue();
            if (value.getName() == modelAndroid) {
                System.out.println("Serial Number: " + key + " " + value.getName());
            }
        }

        System.out.println("Type the serial number you are looking for");
        //Scan keyboard
        int lineNumber2 = scan.nextInt();
        Integer SN = (lineNumber2);

        //show the serial number and robot name 
        System.out.println("Serial Number: " + SN + " Robot Name: " + Maphm3.get(SN).getName());

        //Show SN sub menu
        System.out.println("Select robot part:");
        System.out.println("(1) Brain");
        System.out.println("(2) Vision");
        System.out.println("(3) Arms");
        System.out.println("(4) Media Center");
        System.out.println("(5) PowerPlant");
        do {
            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    System.out.print("Robot with part Brain with Serial Number " + SN + " came from ");
                    System.out.println(Maphm3.get(SN).getBrain());
                    System.out.println("----------------------");
                    System.out.println("|       SUCCESFUL    |");
                    System.out.println("----------------------");
                    System.out.println("To show MENU press any keyword then press enter");
                    scan.nextLine();
                    new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                    break;
                }
                case "2": {
                    System.out.print("Robot with part Vision with Serial Number " + SN + " came from ");
                    System.out.println(Maphm3.get(SN).getVision());
                    System.out.println("----------------------");
                    System.out.println("|       SUCCESFUL    |");
                    System.out.println("----------------------");
                    System.out.println("To show MENU press any keyword then press enter");
                    scan.nextLine();
                    new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                    break;
                }
                case "3": {
                    System.out.print("Robot with part Arms with Serial Number " + SN + " came from ");
                    System.out.println(Maphm3.get(SN).getMediaCenter());
                    System.out.println("----------------------");
                    System.out.println("|       SUCCESFUL    |");
                    System.out.println("----------------------");
                    System.out.println("To show MENU press any keyword then press enter");
                    scan.nextLine();
                    new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                    break;
                }
                case "4": {
                    System.out.print("Robot with part Media Center with Serial Number " + SN + " came from ");
                    System.out.println(Maphm3.get(SN).getArms());
                    System.out.println("----------------------");
                    System.out.println("|       SUCCESFUL    |");
                    System.out.println("----------------------");
                    System.out.println("To show MENU press any keyword then press enter");
                    scan.nextLine();
                    new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                    break;
                }
                case "5": {
                    System.out.print("Robot with part Power Plant with Serial Number " + SN + " came from ");
                    System.out.println(Maphm3.get(SN).getPowerPlant());
                    System.out.println("----------------------");
                    System.out.println("|       SUCCESFUL    |");
                    System.out.println("----------------------");
                    System.out.println("To show MENU press any keyword then press enter");
                    scan.nextLine();
                    new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                    break;
                }
                case "6": {
                    System.exit(0);
                    break;
                }
            }
        } while (!choice.equals("5"));

    }

    public boolean checkTwiceRepetion(long[] rGRobot, int number)
    {
        boolean check = false;
        int count = 0;
        for (int i = 0; i < number; i++) {
            if (rGRobot[i] == rGRobot[number]) {
                //count how many repetitions
                count = count + 1;
                if (count == 2) {
                    //if we find 2 values it will return true
                    check = true;
                }
            }
        }
        return check;
    }

    public void ValidateData(int robotsFirstGen, int robotsSecondGen, int minFirstGen, int maxFirstGen, int minSecondGen, int maxSecondGen)
    {
        if (robotsFirstGen < robotsSecondGen) {
            System.out.println("Check your number of first generation robots: Should be bigger than the number of second generation");
            System.exit(0);
        }
        if (maxFirstGen - minFirstGen < robotsFirstGen) {
            System.out.println("Check your number of first generation robots: You don not have enough Serial numbers");
            System.exit(0);
        }
        if (maxSecondGen - minSecondGen < robotsSecondGen) {
            System.out.println("Check your number of second generation robots: You don not have enough Serial numbers");
            System.exit(0);
        }
        System.out.println("The Robot's set up is:");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("| Number of robots first Generation: " + robotsFirstGen + " and Serial Number from: " + minFirstGen + " to: " + maxFirstGen + "  |");
        System.out.println("| Number of robots second Generation: " + robotsSecondGen + " and Serial Number from: " + minSecondGen + " to: " + maxSecondGen + " |");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Welcome to Androids Factory Co.");
        System.out.println("Generate data \n 1.Generate new First Generation Robots");
        System.out.println("To show MENU press any keyword then press enter");
        scan.nextLine();
    }

    public void SearchModel(Map<Integer, Robot> Maphm3, String model, int robotsFirstGen, int robotsSecondGen, int minFirstGen, int maxFirstGen, int minSecondGen, int maxSecondGen)
    {

        //search all model available by type
        int nModel = 0;
        for (Map.Entry<Integer, Robot> entry : Maphm3.entrySet()) {
            Integer key = entry.getKey();
            Robot value = entry.getValue();
            if (value.getName().equals(model)) {
                System.out.println("Serial Number: " + key + " " + value);
                nModel += 1;
            }
        }
        System.out.println("Numbers of model: " + model + " = " + nModel + " Robots");
        System.out.println("----------------------");
        System.out.println("|       SUCCESFUL    |");
        System.out.println("----------------------");
        System.out.println("To show MENU press any keyword then press enter");
        scan.nextLine();
        new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
    }

    public void SearchSingle(Map<Integer, Robot> Maphm3, String modelAndroid, int robotsFirstGen, int robotsSecondGen, int minFirstGen, int maxFirstGen, int minSecondGen, int maxSecondGen)
    {
        //search a model for a particular type
        for (Map.Entry<Integer, Robot> entry : Maphm3.entrySet()) {
            Integer key = entry.getKey();
            Robot value = entry.getValue();
            if (value.getName() == modelAndroid) {
                System.out.println("Serial Number: " + key + " " + value.getName());
            }
        }

        System.out.println("Type the serial number you are looking for");
        int lineNumber2 = scan.nextInt();
        Integer a = Integer.valueOf(lineNumber2);
        System.out.println(Maphm3.get(a));
        System.out.println("----------------------");
        System.out.println("|       SUCCESFUL    |");
        System.out.println("----------------------");
        System.out.println("To show MENU press any keyword then press enter");
        scan.nextLine();
        new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
    }

    public void countModel(Map<Integer, Robot> Maphm3, int robotsFirstGen, int robotsSecondGen, int minFirstGen, int maxFirstGen, int minSecondGen, int maxSecondGen)
    {

        int Andy = 0;
        int Betty = 0;
        int Bobby = 0;
        int Fred = 0;

        //Count the model for all avaibale robots
        for (Map.Entry<Integer, Robot> entry : Maphm3.entrySet()) {
            long key = entry.getKey();
            Robot value = entry.getValue();
            if (value.getName() == nameSecGen[0]) {
                Andy = Andy + 1;
            }
            if (value.getName() == nameSecGen[1]) {
                Betty = Betty + 1;
            }
            if (value.getName() == nameSecGen[2]) {
                Bobby = Bobby + 1;
            }
            if (value.getName() == nameSecGen[3]) {
                Fred = Fred + 1;
            }
        }

        System.out.println("Total Andy the Android: " + Andy);
        System.out.println("Total Betty the Busibot: " + Betty);
        System.out.println("Total Bobi the racedroid: " + Bobby);
        System.out.println("Total Fred the Friendlybot: " + Fred);
        System.out.println("----------------------");
        System.out.println("|       SUCCESFUL    |");
        System.out.println("----------------------");
        System.out.println("To show MENU press any keyword");
        scan.nextLine();
        new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
    }

    public void Menu(int robotsFirstGen, int robotsSecondGen, int minFirstGen, int maxFirstGen, int minSecondGen, int maxSecondGen)
    {
        new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
    }

}
