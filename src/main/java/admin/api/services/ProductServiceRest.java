package admin.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

import admin.api.ValidationUtils;
import admin.api.model.Category;
import admin.api.model.Client;
import admin.api.model.Mark;
import admin.api.model.Product;
import admin.api.model.TypeProduct;
import admin.api.repo.CategoryRepository;
import admin.api.repo.MarkRepository;
import admin.api.repo.ProductRepository;
import admin.api.repo.TypeProductRepository;

@Service
public class ProductServiceRest {

	//graba productos
	//graba categoria
	//graba tipo
	//graba marca
	//bajas logicas?
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	MarkRepository markRepository;
	
	@Autowired
	TypeProductRepository	typeProductRepository;
	
	
	MongoClient clientDb;
	
	
	
	public void insertProduct(@Valid Product product) {
		productRepository.insert(product);
		
	}
	
	public void insertMark(@Valid Mark mark) {
		markRepository.insert(mark);
		
	}

	public void insertCategory(@Valid Category category) {
		categoryRepository.insert(category);
		
	}

	public Product findProductById(String id) {
		Optional<Product> findById = productRepository.findById(id);
		Product product = (Product) findById.get();
		return product;
	}

	public Category findCategoryById(String id) {
		Optional<Category> findById = categoryRepository.findById(id);
		Category category = (Category) findById.get();
		return category;
	}

	public Mark findMarkById(String id) {
		Optional<Mark> findById = markRepository.findById(id);
		Mark category = (Mark) findById.get();
		return category;
	}
	
	
	public String updateProduct(Product product) {
		
		
		Product save = productRepository.save(product);
		return save.getId();
		
		
//		  clientDb = new MongoClient("localhost",27017);
//	      MongoDatabase db = clientDb.getDatabase("test");
//	      MongoCollection<Document> collection = db.getCollection("product");
//	      Document query = new Document();
//	      query.append("_id",new ObjectId(product.getId()));
//	      Document setData = new Document();
//	      
//	      if(!ValidationUtils.IsNull(product.getCategory())) {
//	    	  setData.append("category",product.getCategory());
//	      }
//	      
//	      if(!ValidationUtils.IsBlankOrNull(product.getFechaAlta())) {
//	    	  setData.append("fechaAlta",product.getFechaAlta());
//	      }
//	      
//	      
//	      if(!ValidationUtils.IsBlankOrNull(product.getFechaBaja())) {
//	    	  setData.append("fechaBaja",product.getFechaBaja());
//	      }
//	      
//	     
//	      if(!ValidationUtils.IsBlankOrNull(product.getFechaModificacion())) {
//	    	  setData.append("fechaModificacion",product.getFechaModificacion());
//	      }
//	      
//	      
//	      if(!ValidationUtils.IsNull(product.getMarca())) {
//	    	  setData.append("marca",product.getMarca());
//	      }
//	      
//	      
//	      if(!ValidationUtils.IsBlankOrNull(product.getModel())) {
//	    	  setData.append("model",product.getModel());
//	      }
//	      
//	      
//	      if(!!ValidationUtils.IsNull(product.getPrecio())) {
//	    	  setData.append("precio",product.getPrecio());
//	      }
//	      
//	      Document update = new Document();
//	      update.append("$set", setData);
//	      UpdateResult updateOne = collection.updateMany(query, update);
//	      String res = updateOne.toString();
//	      clientDb.close();
//	      return res;
	}
	
	public String updateMark(Mark mark) {
		Optional<Mark> markById = markRepository.findById(mark.getId());
		Mark updateMark = (Mark)markById.get();
		updateMark.setNombre(mark.getNombre());

		Mark upMark = markRepository.save(updateMark);
		
		
		return upMark.getId();
	}


	public String updateCategory(Category category) {
		
		Optional<Category> categoryById = categoryRepository.findById(category.getId());
		Category updateCategory = (Category)categoryById.get();
		updateCategory.setNombre(category.getNombre());
		
		Category upCategory = categoryRepository.save(updateCategory);
			
		return upCategory.getId();
		

	}
	
	
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
		
	}

	public List<Category> findAllCategories() {
		
		return categoryRepository.findAll();
	}
	
	public List<Mark> findAllMarks() {
		return markRepository.findAll();
	}
	
	
	public void deleteProduct(String id) {
		Product product = findProductById(id);
		product.setFechaBaja(new Date());
		updateProduct(product);
		
	}
	

	public void deleteMark(String id) {
		markRepository.deleteById(id);
		
	}
	
	
	public void deleteCategory(String id) {
		categoryRepository.deleteById(id);
		
	}
	
	public Category findCategory(String id) {
		Optional<Category> findById = categoryRepository.findById(id);	
		return findById.get();
	}
	public List<TypeProduct> findAllProductType() {
		return typeProductRepository.findAll();
	}
	public void saveTypeProduct(TypeProduct type) {
		typeProductRepository.save(type);
	}
	public void deleteTypeProduct(String id) {
		typeProductRepository.deleteById(id);
	}
	public void updateTypeProduct(TypeProduct type) {
		Optional<TypeProduct> findById = typeProductRepository.findById(type.getId());
		TypeProduct typeProduct = findById.get();
		typeProduct.setName(type.getName());
		typeProductRepository.save(typeProduct);
	}
	

}
