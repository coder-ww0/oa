package com.wei.emos.wx.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author www
 * @date 2021/12/2 14:41
 * @description: TODO
 */

@ApiModel
@Data
public class SearchMeetingByIdForm {
    @NotNull
    @Min(1)
    private Integer id;
}
