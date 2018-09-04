package cn.leafw.zone.ams.web;

import cn.leafw.zone.ams.api.dto.AccountLogQueryDto;
import cn.leafw.zone.ams.api.service.AccountLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmsWebApplicationTests {

    @Autowired
    private AccountLogService accountLogService;
	@Test
	public void contextLoads() {
	}

	@Test
	public void test1(){
        AccountLogQueryDto accountLogQueryDto = new AccountLogQueryDto();
        accountLogService.sumAccountLog(accountLogQueryDto);
    }
}
