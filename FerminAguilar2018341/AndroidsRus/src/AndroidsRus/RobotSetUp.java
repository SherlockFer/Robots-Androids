package AndroidsRus;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fermin
 */
public class RobotSetUp
{

    //create a random variable
    Random rG = new Random();
    //initialize a serial number variable
    private int serialNumber = 0;

    //set Serial Number
    public void setSerialNumber(int serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public Robot fill(Robot Robot)
    {
        
        //Data for robots name, brian, mobility, vision,arm,mediaventer,powerplant
        String names[] = {"Mk1", "Mk2", "Mk3", "Mk4", "Mk5"};
        String brain[] = {"2.5GHZ", "3.5GHZ", "4.5GHZ"};
        String mobility[] = {"caterpillar tracks", "wheels", "legs"};
        String vision[] = {"heat vision", "full colour", "night vision"};
        String arms[] = {"claws", "grippers", "articulated fingers"};
        String mediaCenter[] = {"sony", "jvc", "meridian"};
        String powerPlant[] = {"lithium", "hydrogen", "plasma"};

        //set by random values to each robot first generation
        Robot.setName(names[rG.nextInt(names.length)]);
        Robot.setBrain(brain[rG.nextInt(brain.length)]);
        Robot.setMobility(mobility[rG.nextInt(mobility.length)]);
        Robot.setVision(vision[rG.nextInt(vision.length)]);
        Robot.setArms(arms[rG.nextInt(arms.length)]);
        Robot.setMediaCenter(mediaCenter[rG.nextInt(mediaCenter.length)]);
        Robot.setPowerPlant(powerPlant[rG.nextInt(powerPlant.length)]);

        //return robot object
        return Robot;

    }
}
