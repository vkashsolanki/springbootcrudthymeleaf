package com.electronic.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.electronic.store.exception.ProductNotFoundException;
import com.electronic.store.model.Product;
import com.electronic.store.service.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	private ProductService service; 
	
	
	@GetMapping(value = "/")
	public String productHomePage()
	{
		
		return "homePage";
	}
	
	@GetMapping(value = "/register")
	public String showRegistration()
	{
		
		return "registerPage";
	}
	
	@PostMapping(value = "/save")
	public String saveProduct(@ModelAttribute Product product, Model model) {
		
		Product saveProduct = service.saveProduct(product);
		long product_Id = service.saveProduct(saveProduct).getProduct_Id();
		String message = "Record with product_Id: is "+ product_Id+"saved successfully !";
		model.addAttribute("message",message);
		System.out.println(saveProduct);
		
		return "registerPage";
	}
	
	@GetMapping(value = "/getAllProducts")
	public String getAllProducts(@RequestParam(value = "message", required = false) String message, Model model) {
			List<Product> list = service.getAllProduct();
			model.addAttribute("list",list);
			model.addAttribute("message", message);
		
		return "allProductPage";
		
	}
	
	@GetMapping(value = "/edit")
	public String editProuct(Model model, RedirectAttributes attributes, @RequestParam long product_Id) {
		String page = null;
		try {
			Product productById = service.getProductById(product_Id);
			model.addAttribute("productById", productById);
			page ="editProductPage";
			
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page="redirect:getAllProducts";
		}	
		
		return page;
	}
	
	@PostMapping(value = "/update")
	public String updateProducts(@ModelAttribute Product product, Model model, RedirectAttributes attributes)
	{
		service.updateProduct(product);
		long product_id=product.getProduct_Id();
		attributes.addAttribute("message", "Product with id "+product_id+ "is updated successfully ");	
		return "redirect:getAllProducts";
		
	}
	
	@GetMapping(value = "/delete")
	public String deleteProduct(@RequestParam long product_Id, RedirectAttributes attributes) {
			try {
				service.deleteProductById(product_Id);
				attributes.addAttribute("message", "Product With id"+product_Id+" Delete Successfully!");
				
			} catch (ProductNotFoundException e) {
				e.printStackTrace();
				attributes.addAttribute("message", e.getMessage());
			}
		
		return "redirect:getAllProducts";
		
	}
	
	
}

