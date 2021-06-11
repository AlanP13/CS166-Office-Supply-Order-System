import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
public class OrderManager 
{
	 private ArrayList<Order> orders;
	 private int currentID;
	 public String customerID;
	 public String productID;
	 public Date date1;
	 public int orderAmount1;
	 public int orderAmount2;
	 public Date date2;
	 public long IntervalOfDays;
    public OrderManager() 
    {
        this.orders = new ArrayList<>();
        this.currentID = 0;
    }
    public ArrayList<Order> getOrders() 
    {
        return orders;
    }
    public void addOneTimeOrder(String customerID1, String productID1, Date date11, int orderAmount11) 
    {
        currentID = currentID + 1;
        Order newOrder = new OnetimeOrder(currentID, customerID1, productID1, date11, orderAmount11);
        orders.add(newOrder);
        this.customerID=customerID1;
        this.productID=productID1;
        this.date1=date11;
        this.orderAmount1=orderAmount11;
    }
    public void addRepeatedOrder(String customerID1, String productID1, Date date11, Date date21,int orderAmount11, int orderAmount21,long IntervalOfDays1) 
    {
        currentID = currentID + 1;
        Order newOrder = new RepeatedOrder(currentID, customerID1, productID1, date11, date21,orderAmount11,orderAmount21,IntervalOfDays1);
        orders.add(newOrder);
        this.customerID=customerID1;
        this.productID=productID1;
        this.date1=date11;
        this.orderAmount1=orderAmount11;
        this.date2=date21;
        this.orderAmount2=orderAmount21;
        this.IntervalOfDays=IntervalOfDays1;
    }
    public boolean DeleteOrder(int orderID) 
    {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderID() == orderID) {
                orders.remove(orders.get(i));
                return true;
            }
        }
        return false;
    }
    public ArrayList<Order> getCustomerList(String customerID) {
        ArrayList<Order> cutomerOrders = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCustomerID().equals(customerID)) {
                cutomerOrders.add(orders.get(i));
            }
        }
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order first, Order second) {
                if (first.getDate1().before(second.getDate1())) {
                    return -1;
                } else if (first.getDate1().equals(second.getDate1())) {
                    return 0;
                }
                return 1;
            }
        });
        return cutomerOrders;
    }
}     