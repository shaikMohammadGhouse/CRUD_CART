package com.shoppingcart.app.util;

import java.util.List;

import com.shoppingcart.app.enums.StatusEnum;

public final class ApplicationUtil {

	public static List<String> getOPENStatuses(){
		return List.of(StatusEnum.NEW.toString(),StatusEnum.OPEN.toString()); 
	 }
}
