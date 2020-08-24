package com.xzm.controller;

import com.xzm.bean.Address;
import com.xzm.bean.ServerResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @ApiOperation("本机接口")
    @GetMapping("/local")
    public ServerResponse<Address> local() {
        Address address = new Address(1L, "local.接口修改xxx");
        return ServerResponse.createBySuccess(address);
    }
    @ApiOperation("远程接口")
    @GetMapping("/remote")
    public ServerResponse<Address> remote() {
        Address address = new Address(2L, "remote.接口修改");
        return ServerResponse.createBySuccess(address);
    }


}
