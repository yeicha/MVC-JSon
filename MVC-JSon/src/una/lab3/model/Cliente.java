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
public class Cliente
{

    @JsonProperty("name")
    private Name name;
    @JsonProperty("email")
    private String email;
    private Friends[] friends;
    @JsonProperty("tags")
    private String[] tags;

    public Cliente()
    {
    }

    public Cliente(Name name, String email, Friends[] friends, String[] tags)
    {
        this.name = name;
        this.email = email;
        this.friends = friends;
        this.tags = tags;
    }

    public Name getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public Friends[] getFriends()
    {
        return friends;
    }

    public String[] getTags()
    {
        return tags;
    }

    public void setName(Name name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setFriends(Friends[] friends)
    {
        this.friends = friends;
    }

    public void setTags(String[] tags)
    {
        this.tags = tags;
    }

    @Override
    public String toString()
    {
        return name + email + friends + tags;
    }

}
