package securitySpringBoot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import securitySpringBoot.demo.repository.ProductRepository;
import securitySpringBoot.demo.service.CategoryService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	private CategoryService service;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		productRepository.save(new Product(null, "Orange", null, "Produit riche en vitamine C", 12, 250.0, "bio.jpg"));
//		productRepository.save(new Product(null, "legume", null, "les legumes locales", 2, 1000.0, "legumes.jpg"));
//		productRepository.save(new Product(null, "mangue", null, "Produit riche en  calcium", 9, 100.0,"fruits.jpg"));
//		productRepository.save(new Product(null, "riz", null, "aliment tres puuisse au Senegal", 20, 25000.0,"panier.jpg"));
//		productRepository.save(new Product(null, "citron", null, "Tres riche en vitamine C", 20, 25000.0,"citron.jpg"));
//		productRepository.findAll().forEach(p->{
//			System.out.println(p.toString());
//		});
	}
}
