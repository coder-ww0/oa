package com.wei.emos.wx.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.validation.constraints.Pattern;

/**
 * @author www
 * @date 2021/12/1 17:55
 * @description: TODO
 */

@Data
@ApiModel
public class SearchUserGroupByDeptForm {
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{1,15}$")
    private String keyword;
}
