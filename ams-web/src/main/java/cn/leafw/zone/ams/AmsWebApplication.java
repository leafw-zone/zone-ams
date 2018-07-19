package cn.leafw.zone.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"cn.leafw.zone.ams"})
@RestController
public class AmsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsWebApplication.class, args);
	}

}
