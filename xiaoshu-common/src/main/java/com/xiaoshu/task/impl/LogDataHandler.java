/**
 * 
 */
package com.xiaoshu.task.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xiaoshu.model.LogInfo;
import com.xiaoshu.task.DataHandler;

/**
 * 
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 *
 * @Description : 
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月13日 下午4:42:37
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
@Component(value="logHandler")
public class LogDataHandler implements DataHandler<LogInfo> {

    @Override
    public void handlerData(List<LogInfo> t) {
        System.out.println("将 Log 数据插入到数据库 , 数据量为： size" + t.size());
        //LogService.batchSaveLog(List<LogInfo> logs);
    }

}
