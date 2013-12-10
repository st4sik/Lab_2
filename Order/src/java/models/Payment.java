/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class Payment {
    private int id;
    private int summ;
    private int bill;

    public Payment(int summ, int bill, int id) {
        this.id=id;
        this.summ=summ;
        this.bill=bill;
    }
    public Payment()
    {
        
    }
    
    public void setId(int id)
    {
        this.id=id;
    }
    
    public void setSumm(int summ)
    {
        this.summ=summ;
    }
    
    public void setBill(int bill)
    {
        this.bill=bill;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public int getSumm()
    {
        return this.summ;
    }
    
    public int getBill()
    {
        return this.bill;
    }
}

