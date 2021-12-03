package com.wei.emos.wx.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author www
 * @date 2021/12/1 19:51
 * @description: TODO
 */

@Data
@ApiModel
public class SearchMembersForm {
    @NotBlank
    private String members;
}
