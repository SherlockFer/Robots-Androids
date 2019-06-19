package CCT;


/**
 *
 * @author
 * @author
 * @author
 */
public class Pilot extends Person
{
    private int rating;      //Values: 1 to 4.

    public Pilot(){}

    
    
    
    public Pilot(String name, int rating)
    {
        super(name);
        this.rating = rating;
    }
    
    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public int getRating()
    {
        return rating;
    }
    @Override
    public String toString()
    {
        return " | Pilot name: " + super.getName() + " | Pilot rating: " + rating;
    }

}
