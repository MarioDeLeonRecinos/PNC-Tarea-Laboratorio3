package com.mario.capas.tareaLabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mario.capas.tareaLabo3.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0,"RX-78-2",10));
		productos.add(new Product(1,"MS-06S Zaku II",15));
		productos.add(new Product(2,"MS-06R-2 Johnny",20));
		productos.add(new Product(3,"MSN-04 Sazabi",30));
		productos.add(new Product(4,"RX-0 Full Armor Unicorn",10));
		
		mav.setViewName("productos");
		mav.addObject("product",new Product());
		mav.addObject("producto",productos);
		return mav;
	}
	
	@PostMapping("/validar")
	@ResponseBody
	public ModelAndView validar(Product product) {
		ModelAndView mav =new ModelAndView();
		Product p = productos.get(product.getId());
		mav.addObject("pnombre",p.getNombre());
		
		if(product.getCantidad()<=p.getCantidad()) {
			mav.setViewName("compra");
			
		}
		else {
			mav.setViewName("error");
		}
		return mav;
	}
	
}
