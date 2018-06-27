package hello;

public class Trends
{
    private String query;

    private String name;

    private String url;

    private String tweet_volume;

    private String promoted_content;

    public String getQuery ()
    {
        return query;
    }

    public void setQuery (String query)
    {
        this.query = query;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getTweet_volume ()
    {
        return tweet_volume;
    }

    public void setTweet_volume (String tweet_volume)
    {
        this.tweet_volume = tweet_volume;
    }

    public String getPromoted_content ()
    {
        return promoted_content;
    }

    public void setPromoted_content (String promoted_content)
    {
        this.promoted_content = promoted_content;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [query = "+query+", name = "+name+", url = "+url+", tweet_volume = "+tweet_volume+", promoted_content = "+promoted_content+"]";
    }
}
			
		