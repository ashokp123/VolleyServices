package com.example.myapplication.ApiResponse.status;

public class _links
{
    private Edit edit;

    private Self self;

    private Avatar avatar;

    public Edit getEdit ()
    {
        return edit;
    }

    public void setEdit (Edit edit)
    {
        this.edit = edit;
    }

    public Self getSelf ()
    {
        return self;
    }

    public void setSelf (Self self)
    {
        this.self = self;
    }

    public Avatar getAvatar ()
    {
        return avatar;
    }

    public void setAvatar (Avatar avatar)
    {
        this.avatar = avatar;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [edit = "+edit+", self = "+self+", avatar = "+avatar+"]";
    }
}