package com.xiaoshu.service;

public interface SystemLogService {

	public void saveLog(String content, String ipAddress, String operation,
			String operationType, double costTime, String deviceId);

}
