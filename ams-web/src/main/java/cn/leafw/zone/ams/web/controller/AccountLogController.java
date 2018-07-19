package cn.leafw.zone.ams.web.controller;

import cn.leafw.zone.ams.api.dto.AccountLogDto;
import cn.leafw.zone.ams.api.dto.AccountLogQueryDto;
import cn.leafw.zone.ams.api.service.AccountLogService;
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
 * @date 2018/7/19 10:02
 */
@RestController
@RequestMapping("/accountLog")
public class AccountLogController {

    @Autowired
    private AccountLogService accountLogService;

    @RequestMapping(value = "/queryAccountLogList",method = RequestMethod.POST)
    public ResponseDto queryAccountLogList(@RequestBody AccountLogQueryDto accountLogQueryDto){
        PagerResp<AccountLogDto> accountLogDtoPagerResp = accountLogService.queryAccountLogList(accountLogQueryDto);
        return ResponseDto.instance(accountLogDtoPagerResp);
    }

    @RequestMapping(value = "/saveAccountLog",method = RequestMethod.POST)
    public ResponseDto saveAccountLog(@RequestBody AccountLogDto accountLogDto){
        accountLogService.saveAccountLog(accountLogDto);
        return ResponseDto.instance(accountLogDto);
    }
}
