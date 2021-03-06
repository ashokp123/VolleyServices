package com.example.myapplication.ApiResponse.status;

public class Result
{
    private String website;

    private String address;

    private String gender;

    private String phone;

    private _links _links;

    private String dob;

    private String last_name;

    private String id;

    private String first_name;

    private String email;

    private String status;

    public String getWebsite ()
    {
        return website;
    }

    public void setWebsite (String website)
    {
        this.website = website;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public _links get_links ()
    {
        return _links;
    }

    public void set_links (_links _links)
    {
        this._links = _links;
    }

    public String getDob ()
    {
        return dob;
    }

    public void setDob (String dob)
    {
        this.dob = dob;
    }

    public String getLast_name ()
    {
        return last_name;
    }

    public void setLast_name (String last_name)
    {
        this.last_name = last_name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getFirst_name ()
    {
        return first_name;
    }

    public void setFirst_name (String first_name)
    {
        this.first_name = first_name;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [website = "+website+", address = "+address+", gender = "+gender+", phone = "+phone+", _links = "+_links+", dob = "+dob+", last_name = "+last_name+", id = "+id+", first_name = "+first_name+", email = "+email+", status = "+status+"]";
    }
}