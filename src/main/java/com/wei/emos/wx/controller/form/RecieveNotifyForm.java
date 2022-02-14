package com.wei.emos.wx.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author www
 * @date 2021/12/3 11:53
 * @description: TODO
 */

@Data
@ApiModel
public class RecieveNotifyForm {
    @NotBlank
    private String processId;
    @NotBlank
    private String uuid;
    @NotBlank
    private String result;

}
