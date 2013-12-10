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
public class Print_Orders {
    private int id;
    private int n_o;
    
    private String cus_name;
    private String cus_mobile;
    private String cus_address;
    
    private String date_order;
    private int summ;
    
    private int pay_summ;
    private int pay_bill;
    
    private String pr_name;
    
    public int getID()
    {
        return this.id;
    }
    public void setID(int id)
    {
        this.id=id;
    }
    
    public int getNumber()
    {
        return this.n_o;
    }
    
    public void setNumber(int n_o)
    {
        this.n_o=n_o;
    }
    
    public String getCustomerName()
    {
        return this.cus_name;
    }
    
    public void setCustomerName(String cus_name)
    {
        this.cus_name=cus_name;
    }
    
    public String getCustomerMobile()
    {
        return this.cus_mobile;
    }
    public void setCustomerMobile(String cus_mobile)
    {
        this.cus_mobile=cus_mobile;
    }
    
    public String getCustomerAddress()
    {
        return this.cus_address;
    }
    public void setCustomerAddress(String cus_address)
    {
        this.cus_address=cus_address;
    }
    
    public String getDateOrder()
    {
        return this.date_order;
    }
    public void setDateOrder(String date_order)
    {
        this.date_order=date_order;
    }
    
    public int getSumm()
    {
        return this.summ;
    }
    public void setSumm(int summ)
    {
        this.summ=summ;
    }
    
    public int getPaymentSumm()
    {
        return this.pay_summ;
    }
    public void setPaymentSumm(int pay_summ)
    {
        this.pay_summ=pay_summ;
    }
    
    public int getPaymentBill()
    {
        return this.pay_bill;
    }
    public void setPaymentBill(int pay_bill)
    {
         this.pay_bill=pay_bill;
    }
    
    public String getProductName()
    {
        return this.pr_name;
    }
    public void setProductName(String pr_name)
    {
        this.pr_name=pr_name;
    }
}
