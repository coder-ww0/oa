package com.wei.emos.wx.controller.form;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author www
 * @date 2021/12/1 12:48
 * @description: TODO
 */

@ApiModel
@Data
public class SearchMyMeetingListByPageForm {
    @NotNull
    @Min(1)
    private Integer page;

    @NotNull
    @Range(min = 1, max = 40)
    private Integer length;
}
