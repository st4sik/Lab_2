package nc.ryabokon.lab2;

/**
 *
 * @author STAS
 */
public class Orders {
    private int id;
    private int number_orders;
    private String date;
    private int customer_fk;
    private int payment_fk;
    private int product_fk;
    private int summ;
    
    public void setNumber(int Number_Orders)
    {
        this.number_orders=Number_Orders;
    }
    
    public void setId(int id)
    {
	this.id=id;
    }
    
    public void setCustomer(int customer_fk)
    {
        this.customer_fk=customer_fk;
    }
	
    public void setPayment(int payment_fk)
    {
        this.payment_fk=payment_fk;
    }
    
    public void setProduct(int product_fk)
    {
        this.product_fk=product_fk;
    }
    
    public void setDate(String date)
    {
        this.date=date;
    }
	
    public void setSumm (int summ)
    {
	this.summ=summ;
    }
	
    
    public int getNumber()
    {
        return this.number_orders;
    }
    
    public int getId()
    {
	return this.id;
    }
    
    public int getCustomer()
    {
        return this.customer_fk;
    }
	
    public int getPayment()
    {
        return this.payment_fk;
    }
    
    public int getProduct()
    {
        return this.product_fk;
    }
    
    public String getDate()
    {
        return this.date;
    }
	
    public int getSumm ()
    {
	return this.summ;
    }
    
}
