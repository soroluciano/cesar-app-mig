package admin.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import admin.api.model.Category;
import admin.api.model.Client;
import admin.api.model.Mark;
import admin.api.model.Product;
import admin.api.model.TypeProduct;
import admin.api.services.ProductServiceRest;

//graba productos
//graba categoria
//graba tipo
//graba marca
//bajas logicas?

@RestController
public class ProductController {
	
	@Autowired
	ProductServiceRest productServiceRest;

	
	
	
	public ProductController(ProductServiceRest productServiceRest) {
		this.productServiceRest = productServiceRest;
	}
	
	@CrossOrigin()
	@ResponseBody
	@GetMapping("/findAllProducts")
	private Map<String, List<Product>> findAllProducts(){
		
		List<Product> res = this.productServiceRest.findAllProducts();
		Map<String, List<Product>> map = new HashMap<String, List<Product>>();
		map.put("products", res);
		return map;
		
		 
				
	}
	
	@CrossOrigin()
	@ResponseBody
	@GetMapping("/findAllCategories")
	private Map<String, List<Category>> findAllCategories(){
		
		List<Category> res = productServiceRest.findAllCategories();
		Map<String, List<Category>> map = new HashMap<String, List<Category>>();
		map.put("categories", res);
		return map;
		
	}
	
	@CrossOrigin()
	@ResponseBody
	@GetMapping("/findAllMarks")
	private  Map<String, List<Mark>> findAllMarks(){
		
		List<Mark> res = productServiceRest.findAllMarks();
		Map<String, List<Mark>> map = new HashMap<String, List<Mark>>();
		map.put("marks", res);
		return map;
		
				
	}
	
	@CrossOrigin()
	@ResponseBody
	@GetMapping("/findAllTypeProduct")
	private  Map<String, List<TypeProduct>> findAllTypeProduct(){
		
		List<TypeProduct> res = productServiceRest.findAllProductType();
		Map<String, List<TypeProduct>> map = new HashMap<String, List<TypeProduct>>();
		map.put("typeProducts", res);
		return map;
		
				
	}
	
	@CrossOrigin()
	@ResponseBody
	@GetMapping("/findCategory/{id}")
	private  Category findCategory(@PathVariable("id") String id){		
		Category cat = productServiceRest.findCategory(id);
		return cat;
	}
	
	@CrossOrigin()
	@RequestMapping("/saveProduct")
	@PostMapping
	public void saveProduct(@RequestBody Product product) {
		productServiceRest.insertProduct(product);
	}
	
	@CrossOrigin()
	@RequestMapping("/saveTypeProduct")
	@PostMapping
	public void saveTypeProduct(@RequestBody TypeProduct typeProduct) {
		productServiceRest.saveTypeProduct(typeProduct);
	}
	
	@CrossOrigin()
	@RequestMapping("/saveCategoria")
	@PostMapping
	public void saveCategoria(@Valid @RequestBody Category category) {
		productServiceRest.insertCategory(category);
	}
	
	@CrossOrigin()
	@RequestMapping("/saveMark")
	@PostMapping
	public void saveMark(@Valid @RequestBody Mark mark) {
		productServiceRest.insertMark(mark);
	}
	

	@CrossOrigin()
	@PutMapping(path= {"/updateProduct/{id}"})
	@ResponseBody
	public void updateProduct(@PathVariable("id") String id ,@RequestBody Product product) {
		productServiceRest.updateProduct(product);
	}
	
	@CrossOrigin()
	@PutMapping(path= {"/updateTypeProduct"})
	@ResponseBody
	public void updateTypeProduct(@RequestBody TypeProduct typeProduct) {
		productServiceRest.updateTypeProduct(typeProduct);
	}

	@CrossOrigin()
	@PutMapping(path= {"/updateCategory/{id}"})
	@ResponseBody
	public void updateCategory(@PathVariable("id") String id ,@RequestBody Category category) {
		productServiceRest.updateCategory(category);
	}



	@CrossOrigin()
	@PutMapping(path= {"/updateMark"})
	@ResponseBody
	public void updateMark(@RequestBody Mark mark) {
		productServiceRest.updateMark(mark);
	}

	
	@CrossOrigin()
	@ResponseBody	
	@DeleteMapping(path = { "/deleteMark/{id}" })
	public void deleteMark(@PathVariable("id") String id) {
		productServiceRest.deleteMark(id);
	}

	@CrossOrigin()
	@ResponseBody	
	@DeleteMapping(path = { "/deleteProduct/{id}" })
	public void deleteProduct(@PathVariable("id") String id) {
		productServiceRest.deleteProduct(id);
	}
	
	@CrossOrigin()
	@ResponseBody	
	@DeleteMapping(path = { "/deleteTypeProduct/{id}" })
	public void deleteTypeProduct(@PathVariable("id") String id) {
		productServiceRest.deleteTypeProduct(id);
	}
	
	@CrossOrigin()
	@ResponseBody	
	@DeleteMapping(path = { "/deleteCategoria/{id}" })
	public void deleteCategoria(@PathVariable("id") String id) {
		productServiceRest.deleteProduct(id);
		
	}	
	
}
