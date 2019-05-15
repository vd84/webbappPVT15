package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Category;
import WebbAppPVT15Grupp2.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public Iterable<Category> getAllCategories(){
        return repository.findAll();
    }
}
