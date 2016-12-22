/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.lab3.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Jason
 */
public class Name
{

    @JsonProperty("first")
    private String first;
    @JsonProperty("last")
    private String last;

    public Name()
    {
    }

    public Name(String first, String last)
    {
        this.first = first;
        this.last = last;
    }

    public String getFirst()
    {
        return first;
    }

    public String getLast()
    {
        return last;
    }

    public void setFirst(String first)
    {
        this.first = first;
    }

    public void setLast(String last)
    {
        this.last = last;
    }

    @Override
    public String toString()
    {
        return first + last;
    }

}
