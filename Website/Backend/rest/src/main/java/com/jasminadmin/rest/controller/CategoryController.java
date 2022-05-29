package com.jasminadmin.rest.controller;

import java.util.List;

import com.jasminadmin.rest.domain.Category;
import com.jasminadmin.rest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Category> listcategory = service.listAll();
        model.addAttribute("listcategory", listcategory);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("category") Category prd) {
        service.save(prd);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Category prd = service.get(id);
        mav.addObject("category", prd);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
