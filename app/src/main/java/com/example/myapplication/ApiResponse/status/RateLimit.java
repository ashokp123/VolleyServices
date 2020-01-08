package com.example.myapplication.ApiResponse.status;

public class RateLimit
{
    private String limit;

    private String reset;

    private String remaining;

    public String getLimit ()
    {
        return limit;
    }

    public void setLimit (String limit)
    {
        this.limit = limit;
    }

    public String getReset ()
    {
        return reset;
    }

    public void setReset (String reset)
    {
        this.reset = reset;
    }

    public String getRemaining ()
    {
        return remaining;
    }

    public void setRemaining (String remaining)
    {
        this.remaining = remaining;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [limit = "+limit+", reset = "+reset+", remaining = "+remaining+"]";
    }
}