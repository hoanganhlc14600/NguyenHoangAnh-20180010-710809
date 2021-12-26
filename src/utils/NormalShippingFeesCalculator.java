package utils;
import entity.order.Order;
import java.util.Random;
public class NormalShippingFeesCalculator implements ShippingFeesCalculator {
    //Nguyen Hoang Anh 20180010
    @Override
    public int calculateShippingFees (Order order) {
        Random rand = new Random();
        if(order.getAmount() >= 1000) {
            return 0;
        }
        int fees = (int)( ( (rand.nextFloat()*10)/100 ) * order.getAmount() );
        return fees;
    }
}
