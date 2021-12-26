package utils;
import entity.order.Order;
public class NewShippingFeesCalculator implements ShippingFeesCalculator {
    //Nguyen Hoang Anh - 20180010
    @Override
    public int calculateShippingFees(Order order) {
        int fees = 0;
        int amount = order.getAmount();
        float weight = order.getTotalWeight() + order.getTotalAlternativeWeight();

        // order amount > 50000 -> free Ship
        if (amount >= 50000) {
            return fees;
        }

        String province = order.getDeliveryInfo().get("province").toString();
        if (province.equals("Hà Nội") || province.equals("Hồ Chí Minh") || province.equals("Đà Nẵng")) {
            fees = weight <= 2 ? 10000 : (int) (10000 + 1000 * (weight - 2));
        } else {
            fees = weight <= 1.5 ? 20000 : (int) (20000 + 1000 * (weight - 1.5));
        }

        if (order.rushOrder()) {
            fees += 15000 * order.getlstOrderMedia().size();
        }

        return fees;
    }
}
