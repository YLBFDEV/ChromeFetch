package io.github.ylbfdev.chromefetch;

import org.apache.log4j.Logger;

import io.github.ylbfdev.chromefetch.constants.Constants;
import io.github.ylbfdev.chromefetch.fetch.Fetch520HD;
import io.github.ylbfdev.chromefetch.fetch.FetchSglsGameActivitys;
import io.github.ylbfdev.chromefetch.fetch.FetchXunLeiMi;
import io.github.ylbfdev.chromefetch.utils.ConfUtils;

/**
 * 主页菜单
 *
 */
public class FetchMain {
	private static final Logger Log = Logger.getLogger(FetchMain.class.getName());

	public enum FetchType {
		SGLS, _520HD,XUNLEIMI
	};

	public static void main(String[] args) {
		// 初始化配置参数
		ConfUtils.initializeParams();
		FetchType fetchType = Enum.valueOf(FetchType.class, Constants.TYPE.toUpperCase());
		// 根据type判断爬虫任务类型
		switch (fetchType) {
		case SGLS:
			new FetchSglsGameActivitys().init();
			break;
		case _520HD:
			new Fetch520HD().init();
			break;
		case XUNLEIMI:
			new FetchXunLeiMi().init();
			break;
		default:
			Log.error("Unknown crawl type: " + Constants.TYPE + ".\n Exit...");
			break;
		}
//		if (Constants.TYPE.equals("sgls")) {
//			new FetchSglsGameActivitys().init();
//		} else if (Constants.TYPE.equals("520hd")) {
//			new Fetch520HD().init();
//		} else {
//			Log.error("Unknown crawl type: " + Constants.TYPE + ".\n Exit...");
//		}
		Log.info("程序退出");
	}
}
