package ywt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication  
@RestController 
@MapperScan(basePackages = "ywt.dao")
@EnableCaching
public class Application {


	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);  

	}

}
