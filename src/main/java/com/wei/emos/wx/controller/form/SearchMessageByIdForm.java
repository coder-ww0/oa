package com.wei.emos.wx.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author www
 * @date 2021/11/30 14:16
 * @description: TODO
 */

@ApiModel
@Data
public class SearchMessageByIdForm {
    @NotBlank
    private String id;
}
