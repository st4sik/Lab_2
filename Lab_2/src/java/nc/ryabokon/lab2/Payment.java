package nc.ryabokon.lab2;

/**
 *
 * @author STASСтас
 */
public class Payment {
    private int id;
    private int summ;
    private int bill;
    
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
