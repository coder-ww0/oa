package com.wei.emos.wx.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author www
 * @date 2021/12/3 13:00
 * @description: TODO
 */

@Data
@ApiModel
public class SelectUserPhotoAndNameForm {
    @NotBlank
    private String ids;
}
