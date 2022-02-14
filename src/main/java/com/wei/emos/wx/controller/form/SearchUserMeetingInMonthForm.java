package com.wei.emos.wx.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @author www
 * @date 2021/12/3 18:27
 * @description: TODO
 */

@Data
@ApiModel
public class SearchUserMeetingInMonthForm {
    @Range(min = 2000, max = 9999)
    private Integer year;

    @Range(min = 1, max = 12)
    private Integer month;
}
