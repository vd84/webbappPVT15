package com.pvtgrupp2.webbappPVT15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class WebbappPvt15Application {

	public static void main(String[] args) {
		SpringApplication.run(WebbappPvt15Application.class, args);
	}

}

@Controller
@SpringBootApplication
class DemoApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello man3!";
	}
}
