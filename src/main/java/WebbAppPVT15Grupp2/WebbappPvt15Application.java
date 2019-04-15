package WebbAppPVT15Grupp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class WebbappPvt15Application {

	public static void main(String[] args) {
		SpringApplication.run(WebbappPvt15Application.class, args);



	}
	@RequestMapping("/")
	String index() {
		return "index";
	}

}


