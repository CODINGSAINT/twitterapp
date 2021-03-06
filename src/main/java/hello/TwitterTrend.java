package hello;

public class TwitterTrend
{
    private Trends[] trends;

    private Locations[] locations;

    private String created_at;

    private String as_of;

    public Trends[] getTrends ()
    {
        return trends;
    }

    public void setTrends (Trends[] trends)
    {
        this.trends = trends;
    }

    public Locations[] getLocations ()
    {
        return locations;
    }

    public void setLocations (Locations[] locations)
    {
        this.locations = locations;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getAs_of ()
    {
        return as_of;
    }

    public void setAs_of (String as_of)
    {
        this.as_of = as_of;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [trends = "+trends+", locations = "+locations+", created_at = "+created_at+", as_of = "+as_of+"]";
    }
}
	