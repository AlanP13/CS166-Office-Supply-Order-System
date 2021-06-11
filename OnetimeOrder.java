import java.util.Date;

public class OnetimeOrder extends Order
{
    public OnetimeOrder(int orderID, String customerID, String productID, Date date, int orderAmount) 
    {
        super(orderID, customerID, productID, date, orderAmount);
    }  
}
