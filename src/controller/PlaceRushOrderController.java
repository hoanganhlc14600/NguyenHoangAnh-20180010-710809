package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;

public class PlaceRushOrderController extends PlaceOrderController{
    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceRushOrderController.class.getName());
    // Nguyen Hoang Anh 20180010
    
    /**
     * Kiem tra xem cac truong da nhap hop le hay chua
     */
    @Override
    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException {
        if(!validateName(info.get("name"))){
            throw new InterruptedException("Name is invalid");
        }
        if(!validateAddress(info.get("address"))){
            throw new InterruptedException("Address is invalid");
        }
        if(!validatePhoneNumber(info.get("phone"))){
            throw new InterruptedException("Phone number is invalid");
        }
        if(!validateProvince(info.get("province"))) {
            throw new InterruptedException("Province not support rush order");
        }
    }
    
    /**
     * Kiem tra xem dia diem co ho tro giao hang nhanh hay khong, cu the o day chi ho tro Ha Noi
     * @param province : dia diem khach hang yeu cau van chuyen den
     * @return
     */
    public boolean validateProvince(String province){
        if(province == null || province.isEmpty()){
            return false;
        }
        if(!province.equals("Hà Nội")) {
            return false;
        }
        return true;
    }
}