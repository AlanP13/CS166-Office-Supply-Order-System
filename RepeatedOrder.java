import java.util.Date;
public class RepeatedOrder extends Order
{
	private int orderAmount2;
    private Date date2;
    long IntervalOfDays;
    public RepeatedOrder(int orderID, String customerID, String productID, Date firstdate,Date seconddate, int orderAmount1,int orderAmount2,long IntervalOfDays) 
    {
        super(orderID, customerID, productID, firstdate, orderAmount1);
        this.orderAmount2 = orderAmount2;
        this.date2=seconddate;
        this.IntervalOfDays=IntervalOfDays;
    }
    public Date getDate2() {
        return date2;
    }
    public long getIntervalOfDays() {
        return IntervalOfDays;
    }
    public int getOrderAmount2() {
        return orderAmount2;
    }
        public void setOrderAmount2(int secondorderAmount) {
        this.orderAmount2 = secondorderAmount;
    }
    public void setDate2(Date seconddate) {
        this.date2 = seconddate;
    }
    public void setIntervalOfDays(long IntervalOfDays) {
        this.IntervalOfDays = IntervalOfDays;
    }
    @Override
    public String toString() {
        return super.toString() + "\nSecond Order Quantity: "+ orderAmount2+ "\nInterval between orders: " + IntervalOfDays+"\nEnd Date: " + date2;
    }  
}
