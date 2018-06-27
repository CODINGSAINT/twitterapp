package hello;

public class Locations
{
    private String woeid;

    private String name;

    public String getWoeid ()
    {
        return woeid;
    }

    public void setWoeid (String woeid)
    {
        this.woeid = woeid;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [woeid = "+woeid+", name = "+name+"]";
    }
}
			
		