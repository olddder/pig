package com.pig4cloud;

import com.pig4cloud.pig.common.feign.annotation.EnablePigFeignClients;
import com.pig4cloud.pig.common.security.annotation.EnablePigResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnablePigFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnablePigResourceServer
public class MyModuleMain9622 {
	public static void main(String[] args) {
		SpringApplication.run(MyModuleMain9622.class, args);
	}
}