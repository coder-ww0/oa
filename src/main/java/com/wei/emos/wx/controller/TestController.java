package com.wei.emos.wx.controller;

import com.wei.emos.wx.common.util.R;
import com.wei.emos.wx.controller.form.TestSayHelloForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author www
 * @date 2021/11/22 19:23
 * @description: 测试方法，测试swagger2的实现
 */

@RestController
@RequestMapping("/test")
@Api("测试web接口")
public class TestController {

    @PostMapping("/sayHello")
    @ApiOperation("测试方法内部")
    public R test(@Valid @RequestBody TestSayHelloForm form) {
        return R.ok().put("message", "数据，你好swagger " + form.getName());
    }

    @PostMapping("/addUser")
    @ApiOperation("添加用户")
    @RequiresPermissions(value = {"A", "USER:ADD"}, logical = Logical.OR)
    public R addUser() {
        return R.ok("用户添加成功");
    }
}
