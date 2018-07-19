package cn.leafw.zone.ams.web.controller;

import cn.leafw.zone.ams.api.dto.AccountMainDto;
import cn.leafw.zone.ams.api.dto.AccountMainQueryDto;
import cn.leafw.zone.ams.api.service.AccountMainService;
import cn.leafw.zone.common.dto.PagerResp;
import cn.leafw.zone.common.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/19 11:04
 */
@RestController
@RequestMapping("/accountMain")
public class AccountMainController {

    @Autowired
    private AccountMainService accountMainService;

    @RequestMapping(value = "/queryAccountMainListPage",method = RequestMethod.POST)
    public ResponseDto queryAccountMainListPage(@RequestBody AccountMainQueryDto accountMainQueryDto){
        PagerResp<AccountMainDto> accountMainDtoPagerResp = accountMainService.queryAccountMainListByPage(accountMainQueryDto);
        return ResponseDto.instance(accountMainDtoPagerResp);
    }

    @RequestMapping(value = "/queryAccountMainList",method = RequestMethod.POST)
    public ResponseDto queryAccountMainList(@RequestBody AccountMainQueryDto accountMainQueryDto){
        return ResponseDto.instance(accountMainService.queryAccountMainList(accountMainQueryDto));
    }
}
