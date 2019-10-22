package com.thamphan.controller;

import com.thamphan.model.Product;
import com.thamphan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public ModelAndView getProducts(){
       List<Product> productList= productService.findAllHaveBusiness();
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("products",productList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("message","Add Product");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(HttpServletRequest httpServletRequest){
        int id=Integer.parseInt(httpServletRequest.getParameter("id"));
        String name=httpServletRequest.getParameter("name");
        double price=Double.parseDouble(httpServletRequest.getParameter("price"));
        String producer=httpServletRequest.getParameter("producer");

        Product product=new Product(id, name, price, producer);
        productService.addHaveBusiness(product);

        ModelAndView modelAndView=new ModelAndView("create");
        return modelAndView;
    }
    @GetMapping("/product/{id}/edit")
    public ModelAndView editForm(@PathVariable("id") int id){
        ModelAndView modelAndView=new ModelAndView("edit");
        modelAndView.addObject("product",productService.findByIdHaveBusiness(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateProduct(@ModelAttribute Product product){
        productService.updateHaveBusiness(product.getId(),product);
        ModelAndView modelAndView=new ModelAndView("create");
        return modelAndView;
    }

    @GetMapping("/product/{id}/delete")
    public ModelAndView deleteForm(@PathVariable("id") int id){
        ModelAndView modelAndView= new ModelAndView("delete");
        modelAndView.addObject("product",productService.findByIdHaveBusiness(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteProduct(@ModelAttribute Product product){
        productService.removeHaveBusiness(product.getId());
        ModelAndView modelAndView=new ModelAndView("create");
        return modelAndView;
    }

    @GetMapping("/product/{id}/view")
    public ModelAndView viewForm(@PathVariable("id") int id){
        ModelAndView modelAndView=new ModelAndView("view");
        modelAndView.addObject("product",productService.findByIdHaveBusiness(id));
        return modelAndView;
    }
}
