/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndroidsRus;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author fermin
 */
public class Menu
{
    //Initialize choice to use it in the Menu

    String choice = null;
    //Scanner
    Scanner scan = new Scanner(System.in);
    //initialize UserSetUp
    UserSetUp usu = new UserSetUp();
    

    Menu(Map<Integer, Robot> Maphm1, Map<Integer, Robot> Maphm2, Map<Integer, Robot> Maphm3, int robotsFirstGen, int robotsSecondGen, int minFirstGen, int maxFirstGen, int minSecondGen, int maxSecondGen)
    {
        //Menu
        System.out.println("*******************************");
        System.out.println("Welcome to Androids Factory Co. \nMENU\n");
        System.out.println("Select one option:");
        System.out.println("(1) Generate NEW data for \n     1.Generate new First Generation Robots");
        System.out.println("(2) show second generations robot with donated parts from first generation robots");
        System.out.println("(3) Show the robots first generations after donating parts ");
        System.out.println("(4) Show all available models of a particular type");
        System.out.println("(5) Show One model of a particular type ");
        System.out.println("(6) Show Total counts of available types ");
        System.out.println("(7) Show a model that donated a particular part  ");
        System.out.println("(8) Quit");

        do {
            //Read keyboard
            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    //Generating a new data for first generation robot
                    usu.FirstGenRobots(robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                    new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                    break;
                }
                case "2": {
                    System.out.println("Data Second Generation with parts donated");
                    //print robot second generation
                    Maphm3.forEach((k, v) -> System.out.println("Serial Number: " + k + " = " + v));
                    System.out.println("----------------------");
                    System.out.println("|       SUCCESFUL    |");
                    System.out.println("----------------------");
                    //type any keyboard to see the menu
                    System.out.println("To show MENU press any keyword then press enter");
                    scan.nextLine();
                    new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                    break;
                }
                case "3": {
                    System.out.println("Data Robot First Generation after donating");
                    //print data robots first generation after donating parts
                    Maphm2.forEach((k, v) -> System.out.println("Serial Number: " + k + " = " + v));
                    System.out.println("----------------------");
                    System.out.println("|       SUCCESFUL    |");
                    System.out.println("----------------------");
                    //type any keyboard to see the menu
                    System.out.println("To show MENU press any keyword then press enter");
                    scan.nextLine();
                    new Menu(Maphm1, Maphm2, Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                    break;
                }
                case "4": {
                    //Select a model of robot sencond generation
                    System.out.println("Select one model:");
                    System.out.println("(1) Andy the Android");
                    System.out.println("(2) Betty the Busibot");
                    System.out.println("(3) Bobi the racedroid");
                    System.out.println("(4) Fred the Friendlybot");
                    System.out.println("(5) Quit");
                    do {
                        //Read keyboard
                        choice = scan.nextLine();
                        switch (choice) {
                            case "1": {
                                //searching for an specific model 
                                usu.SearchModel(Maphm3, "Andy the Android", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "2": {
                                //searching for an specific model 
                                usu.SearchModel(Maphm3, "Betty the Busibot", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "3": {
                                //searching for an specific model 
                                usu.SearchModel(Maphm3, "Bobi the racedroid", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "4": {
                                //searching for an specific model 
                                usu.SearchModel(Maphm3, "Fred the Friendlybot", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "5": {
                                System.exit(0);
                                break;
                            }
                        }
                    } while (!choice.equals("5"));
                    break;
                }
                case "5": {
                    //Show sub menu
                    System.out.println("Select one model:");
                    System.out.println("(1) Andy the Android");
                    System.out.println("(2) Betty the Busibot");
                    System.out.println("(3) Bobi the racedroid");
                    System.out.println("(4) Fred the Friendlybot");
                    System.out.println("(5) Quit");
                    do {
                        choice = scan.nextLine();
                        switch (choice) {
                            case "1": {
                                //searching for an specific model 
                                usu.SearchSingle(Maphm3, "Andy the Android", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "2": {
                                //searching for an specific model 
                                usu.SearchSingle(Maphm3, "Aetty the Busibot", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "3": {
                                //searching for an specific model 
                                usu.SearchSingle(Maphm3, "Bobi the racedroid", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "4": {
                                //searching for an specific model 
                                usu.SearchSingle(Maphm3, "Fred the Friendlybot", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "5": {
                                System.exit(0);
                                break;
                            }
                        }
                    } while (!choice.equals("5"));

                    break;
                }
                case "6": {
                    //Count how many robots per each model
                    usu.countModel(Maphm3, robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                    break;
                }
                case "7": {
                    System.out.println("Select one model:");
                    System.out.println("(1) Andy the Android");
                    System.out.println("(2) Betty the Busibot");
                    System.out.println("(3) Bobi the racedroid");
                    System.out.println("(4) Fred the Friendlybot");
                    System.out.println("(5) Quit");
                    do {
                        choice = scan.nextLine();
                        switch (choice) {
                            case "1": {
                                //searching for an specific model 
                                usu.partModel(Maphm3, "Andy the Android", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "2": {
                                //searching for an specific model 
                                usu.partModel(Maphm3, "Aetty the Busibot", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "3": {
                                //searching for an specific model 
                                usu.partModel(Maphm3, "Bobi the racedroid", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "4": {
                                //searching for an specific model 
                                usu.partModel(Maphm3, "Fred the Friendlybot", robotsFirstGen, robotsSecondGen, minFirstGen, maxFirstGen, minSecondGen, maxSecondGen);
                                break;
                            }
                            case "5": {
                                System.exit(0);
                                break;
                            }
                        }
                    } while (!choice.equals("5"));

                    break;
                }
                case "8": {
                    System.exit(0);
                }
//
                default: {
                    System.out.println("\nERROR MESSAGE: You chose and invalid option. Please, try again.\n");
//                    new Menu(hm0, hm1, hm2, hm3);
                    break;
                }
//
            } // end of switch . partModel
//
        } while (!choice.equals("7")); // end of loop do-while         

    }

}
