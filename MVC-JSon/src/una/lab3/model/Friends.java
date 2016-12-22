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
public class Friends
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;

    public Friends()
    {
    }

    public Friends(String name, String id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return name + id;
    }

}
