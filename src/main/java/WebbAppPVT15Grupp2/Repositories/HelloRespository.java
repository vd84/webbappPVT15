package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRespository extends JpaRepository<Hello, Integer> {
}
