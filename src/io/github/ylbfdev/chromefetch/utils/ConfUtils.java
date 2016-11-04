package io.github.ylbfdev.chromefetch.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import io.github.ylbfdev.chromefetch.constants.Constants;
import io.github.ylbfdev.chromefetch.constants.DBConn;

public class ConfUtils {
	private static final Logger Log = Logger.getLogger(ConfUtils.class.getName());

	/**
	 * 从配置文件初始化参数
	 */
	public static void initializeParams() {
		Log.info("读取配置文件……");
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream("conf/spider.properties"));
			Properties properties = new Properties();
			properties.load(in);

			// 从配置文件中读Mybatis路径参数
			Constants.CONFIG_PATH = properties.getProperty("DB.CONFIG_PATH");

			// 从配置文件中读取数据库连接参数
			DBConn.CONN_URL = properties.getProperty("DB.connUrl");
			DBConn.USERNAME = properties.getProperty("DB.username");
			DBConn.PASSWORD = properties.getProperty("DB.password");

			// 从配置文件中读取爬虫任务类型
			Constants.TYPE = properties.getProperty("spider.type");

			Constants.WEB_DRIVER = properties.getProperty("spider.webDriver");
			Constants.DRIVER_PATH = properties.getProperty("spider.driverPath");

			// 关闭配置文件读取链接
			in.close();
			Log.info("读取配置完毕！");
		} catch (FileNotFoundException e) {
			Log.error(e);
			Log.debug("配置文件没有找到");
		} catch (IOException e) {
			Log.error(e);
			Log.debug("配置文件读取异常");
		}
	}
}
