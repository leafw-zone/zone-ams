package cn.leafw.zone.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"cn.leafw.zone.ams"})
public class AmsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsWebApplication.class, args);
	}
}
