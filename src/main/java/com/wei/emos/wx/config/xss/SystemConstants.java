package com.wei.emos.wx.config.xss;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author www
 * @date 2021/11/27 11:54
 * @description: 存放签到的各种时间，比如签到开始时间，结束时间等，在程序初始化的时候进行数据的提取
 */

@Data
@Component
public class SystemConstants {
    public String attendanceStartTime;
    public String attendanceTime;
    public String attendanceEndTime;
    public String closingStartTime;
    public String closingTime;
    public String closingEndTime;
}
