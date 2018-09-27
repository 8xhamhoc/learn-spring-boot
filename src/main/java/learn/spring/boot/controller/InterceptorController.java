package learn.spring.boot.controller;

import learn.spring.boot.model.Product;
import learn.spring.boot.property.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InterceptorController {

    @Autowired
    private Global global;
    @Value("${global.name}")
    private String globalName;
    @Value("${global.age}")
    private int globalAge;

    private static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);
        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        System.out.println("Name: " + globalName);
        System.out.println("Age: " + globalAge);
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

}
