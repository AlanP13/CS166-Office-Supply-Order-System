import java.util.Date;
public class Order {
    private int orderID;
    private String customerID;
    private String productID;
    private Date date1;
    private int orderAmount1;
    public Order(int orderID, String customerID, String productID, Date firstdate,int orderAmount1) 
    {
        this.orderID = orderID;
        this.customerID = customerID;
        this.productID = productID;
        this.date1 = firstdate;
        this.orderAmount1 = orderAmount1;
    }
    public int getOrderID() 
    {
        return orderID;
    }
    public String getCustomerID() 
    {
        return customerID;
    }
    public String getProductID() 
    {
        return productID;
    }
    public Date getDate1() 
    {
        return date1;
    }
    public int getOrderAmount1() 
    {
        return orderAmount1;
    }
    public void setOrderID(int orderID) 
    {
        this.orderID = orderID;
    }
    public void setCustomerID(String customerID) 
    {
        this.customerID = customerID;
    }
    public void setProductID(String productID) 
    {
        this.productID = productID;
    }
    public void setDate1(Date firstdate) 
    {
        this.date1 = firstdate;
    }
    public void setOrderAmount1(int orderAmount1) 
    {
        this.orderAmount1 = orderAmount1;
    }
    @Override
    public String toString() {
        return "\nOrder Type: " + orderID + "\nCustomer Name: " + customerID + "\nProduct: " + productID + "\nDate: " + date1 + "\nOrder Quantity: " + orderAmount1;
    }
}
