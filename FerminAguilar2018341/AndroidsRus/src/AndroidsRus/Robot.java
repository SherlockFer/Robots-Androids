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
public class Robot{
    //atrribuites
    private String name;
    private int serialNumber;
    private String brain;
    private String mobility;
    private String vision;
    private String arms;
    private String mediaCenter;
    private String powerPlant;
    
    //constructor with no arguments
    public Robot(){
        
    }
    
    //consturctores with arguments
    public Robot(String name , String brain, String mobility,String vision, String arms,String mediaCenter, String powerPlant){
        this.name=name;
        this.brain=brain;
        this.mobility=mobility;
        this.vision=vision;
        this.arms=arms;
        this.mediaCenter=mediaCenter;
        this.powerPlant=powerPlant;
    }
    
    //setter and getters
    public void setName (String name)
    {
        this.name=name;
    }
    public String getName ()
    {
        return name;
    }
    public void setSerialNumber (int serialNumber)
    {
        this.serialNumber=serialNumber;
    }
    public int getSerialNumber ()
    {
        return serialNumber;
    }
    public void setBrain (String brain)
    {
        this.brain=brain;
    }
    public String getBrain ()
    {
        return brain;
    }
    public void setMobility (String mobility)
    {
        this.mobility=mobility;
    }
    public String getMobility ()
    {
        return mobility;
    }
    public void setVision (String vision)
    {
        this.vision=vision;
    }
    public String getVision()
    {
        return vision;
    }
    public void setArms (String arms)
    {
        this.arms=arms;
    }
    public String getArms()
    {
        return arms;
    }
    public void setMediaCenter (String mediaCenter)
    {
        this.mediaCenter=mediaCenter;
    }
    public String getMediaCenter()
    {
        return mediaCenter;
    }
    public void setPowerPlant(String powerPlant)
    {
        this.powerPlant=powerPlant;
    }
    public String getPowerPlant()
    {
        return powerPlant;
    }
    
    //override String toString
    @Override
    public String toString(){
       return       "\n     name: "+name + 
                    "\n     brain: "+ brain + 
                    "\n     mobility: "+ mobility + 
                    "\n     vision: "+vision + 
                    "\n     arms: "+ arms + 
                    "\n     mediaCenter: "+ mediaCenter + 
                    "\n     powerPlant: "+ powerPlant;
    }

    

    
}
