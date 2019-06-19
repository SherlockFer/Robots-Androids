/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndroidsRus;


/**
 *
 * @author Fermin
 */
public class Factory
{     
           

    public static void main(String[] args) {
       //quantity of robots.
       //quantity of robots first generation
       int robotsFirstGen=500;
       //quantity of robots second generation
       int robotsSecondGen=400;
       
       //Serial numbers for the Robots FIRST generation
       //Min serial number bank for first generation
       int minFirstGen=1000000;
       //Max serial number bank for first generation
       int maxFirstGen=5000000;
       
       //Serial numbers for the Robots SECOND generation
       //Min serial number bank for second generation
       int minSecondGen=maxFirstGen+1;
       //Max serial number bank for second generation
       int maxSecondGen=9999999;
       
       //initialize UserSetUp
       UserSetUp UserSU= new UserSetUp();
       //validation of data
       UserSU.ValidateData(robotsFirstGen,robotsSecondGen,minFirstGen,maxFirstGen,minSecondGen,maxSecondGen);
       //create first Generation robots
       UserSU.FirstGenRobots(robotsFirstGen,robotsSecondGen,minFirstGen,maxFirstGen,minSecondGen,maxSecondGen);

      
       
    }

}


