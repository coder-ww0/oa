package com.wei.emos.wx.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author www
 * @date 2021/12/2 19:42
 * @description: TODO
 */

@ApiModel
@Data
public class DeleteMeetingByIdForm {
    @NotNull
    @Min(1)
    private Integer id;
}
