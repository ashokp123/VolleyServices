package com.example.myapplication.ApiResponse.status;

public class StatusResponse
{
    private Result[] result;

    private _meta _meta;

    public Result[] getResult ()
    {
        return result;
    }

    public void setResult (Result[] result)
    {
        this.result = result;
    }

    public _meta get_meta ()
    {
        return _meta;
    }

    public void set_meta (_meta _meta)
    {
        this._meta = _meta;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [result = "+result+", _meta = "+_meta+"]";
    }
}