package securitySpringBoot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import securitySpringBoot.demo.FileUploadUtil;
import securitySpringBoot.demo.entities.Category;
import securitySpringBoot.demo.entities.Product;
import securitySpringBoot.demo.repository.ProductRepository;
import securitySpringBoot.demo.service.CategoryService;
import securitySpringBoot.demo.service.ProductService;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService service;
    @GetMapping(path = "")
    public String index(Model model){
        return "index";
    }
    @GetMapping(path = "/products")
    public String product(Model model,
                          @RequestParam(name ="page", defaultValue = "0")int page,
                          @RequestParam(name ="size", defaultValue = "5")int size,
                          @RequestParam(name ="keywork", defaultValue = "")String mc){
        Page<Product> pageProducts = productRepository.findByNameContains(mc, PageRequest.of(page, size));
        model.addAttribute("pageProducts", pageProducts.getContent());
        model.addAttribute("pages", new int[pageProducts.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("keywork", mc);
        return "productVue";
    }
    @GetMapping(path = "/deleteProduct")
    public String delete(Long id, String keywork, int page, int size){
        productRepository.deleteById(id);
        return "redirect:/products?page="+page+"&size="+size+"&keywork="+keywork;
    }
    @GetMapping(path = "/home")
    public String home(){
        return "home";
    }
    @GetMapping(path = "/cosmetique")
    public String cosmetique(){
        return "cosmetique";
    }
    @GetMapping(path = "/alimentaire")
    public String alimentation(){
        return "alimentaire";
    }
    @GetMapping(path = "/therapeutique")
    public String therapeutique(){
        return "therapeutique";
    }
    @GetMapping(path = "/propos")
    public String propos(){
        return "propos";
    }
    @GetMapping(path = "/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping(path = "/ajoutArticle")
    public String ajoutArticle(Model model){
        model.addAttribute("mode", "ajout");
        List<Category> listCategories = service.listCategory();
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("product", new Product());
        return "ajoutArticle";
    }


    @PostMapping(path = "/saveArticle")
    public String saveArticle(Model model,@Valid Product product, BindingResult bindingResult,
                              @RequestParam("fileImage") MultipartFile multipartFile ) throws Exception {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setPhotos(fileName);
        Product saveProduct = productRepository.save(product);
        String uploadDir = "./product-photos/" + saveProduct.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try(InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);
            System.out.println(filePath.toString());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("Could not save uploaded file: "+ fileName);
        }

        if(bindingResult.hasErrors()) return "ajoutArticle";
            productRepository.save(product);
            return "confirmation";
    }
    @GetMapping(path = "/editerArticle")
    public String editerArticle(Model model, Long id){
        Product p = productRepository.findById(id).get();
        model.addAttribute("product", p);
        model.addAttribute("mode", "edit");
        return "ajoutArticle";
    }

    @GetMapping(path = "/403")
    public String denied(){
        return "403";
    }

}
