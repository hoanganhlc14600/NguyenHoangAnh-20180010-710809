package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateProvinceTest {
	//Nguyen Hoang Anh - 20180010
	private PlaceRushOrderController placeOrderController;
				
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceRushOrderController();
	}

	@ParameterizedTest
	@CsvSource({
		"Hà Nội,true",
		"Ha noi,false",
		"Lào Cai,false",
		"Hà nội,false"
	})
				
	void test(String province, boolean expected) {
		boolean isValid = placeOrderController.validateProvince(province);
		assertEquals(expected, isValid);
	}
}
