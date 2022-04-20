package com.h2.db.controller;

import java.util.List;
import java.util.Optional;

import com.h2.db.model.ProductEntity;
import com.h2.db.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.h2.db.exception.RecordNotFoundException;

@Controller
@RequestMapping("/")
public class ProductController
{
	@Autowired
	ProductService service;

	@RequestMapping
	public String getAllProducts(Model model)
	{	
		System.out.println("getAllProducts");
		
		List<ProductEntity> list = service.getAllProducts();

		model.addAttribute("products", list);
		
		return "list-products";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editProductById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException
	{
		System.out.println("editProductById" + id);
		if (id.isPresent()) {
			ProductEntity entity = service.getProductById(id.get());
			model.addAttribute("product", entity);
		} else {
			model.addAttribute("product", new ProductEntity());
		}
		return "add-edit-product";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteProductById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException
	{
		System.out.println("deleteProductById" + id);
		service.deleteProductById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createProduct", method = RequestMethod.POST)
	public String createOrUpdateProduct(ProductEntity product)
	{
		System.out.println("createOrUpdateProduct ");
		
		service.createOrUpdateProduct(product);
		
		return "redirect:/";
	}
}
