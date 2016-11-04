package io.github.ylbfdev.chromefetch.fetch;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.github.ylbfdev.chromefetch.utils.PageUtils;

public abstract class BaseFetch {
	private static final Logger Log = Logger.getLogger(BaseFetch.class.getName());

	/**
	 * 初始化
	 */
	public void init() {
		WebDriver driver = PageUtils.getWebDriver();
		// 开始抓取
		startFetch(driver);
		driver.close();

		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			driver.quit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsatisfiedLinkError e) {
		} finally {
			PageUtils.serviceStop();
		}
	}

	/**
	 * 开始抓取
	 * 
	 * @param driver
	 */
	public abstract void startFetch(WebDriver driver);
}
