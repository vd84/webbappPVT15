package WebbAppPVT15Grupp2;

import WebbAppPVT15Grupp2.Repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebbappPvt15Application {

	public static void main(String[] args) {
		//SpringApplication.run(WebbappPvt15Application.class, args);

		ApplicationContext c = SpringApplication.run(WebbappPvt15Application.class,args);

		UserRepository repo = c.getBean(UserRepository.class);
		//repo.sproc_add_user("TestUser2", 1);

	}
	@RequestMapping("/")
	String index() {
		return "index";
	}

}