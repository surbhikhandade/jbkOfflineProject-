package com.jbk.Utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.pages.PageBase;

public class commonCode extends PageBase {

	public static void getActualList(List<WebElement> Colm1,List<WebElement> Colm2) {
		ArrayList<String> actualhm = new ArrayList<String>();

		String key = null;
		String value = null;
		for (int i = 0; i < Colm1.size(); i++) {
			value = Utilities.getTextIndex(Colm1, i);
			if (value.contains("Google Chrome")) {
				key = Utilities.getTextIndex(Colm2, i);
				actualhm.add(key+"="+value);
			}
			System.out.println(actualhm);;
		}

	}
}
