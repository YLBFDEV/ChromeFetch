package io.github.ylbfdev.chromefetch.fetch;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FetchSglsGameActivitys extends BaseFetch {
	private static final Logger Log = Logger.getLogger(FetchSglsGameActivitys.class.getName());

	@Override
	public void startFetch(WebDriver driver) {
		driver.get("http://bbs.open.qq.com/forum-3109-78.html");
		Log.info(driver.getTitle());
		String pageStr = driver.findElement(By.cssSelector("#fd_page_top > div > label > span")).getAttribute("title");
		Log.info(pageStr);
		int totalPage = Integer.parseInt(pageStr.replaceAll("[^0-9]", ""));
		for (int i = 0; i < totalPage; i++) {
			Log.info(driver.getCurrentUrl());
			List<WebElement> driverElements = driver
					.findElements(By.cssSelector("#moderate > table >tbody > tr > th > a"));
			for (WebElement webElement : driverElements) {
				if (webElement.getText().contains("活动"))
					Log.info(webElement.getText());
			}
			if (totalPage - 1 != i) {
				driver.findElement(By.cssSelector("#fd_page_top > div > a.nxt")).click();
			}
		}
	}
}
