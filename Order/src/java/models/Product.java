/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author STASСтас
 */
public class Product {
    private int id;
    private String name;
    
    public void setId(int id)
    {
        this.id=id;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
}
