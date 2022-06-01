/*package com.jasminadmin.rest.controller;

import com.jasminadmin.rest.domain.SnipCart;
import com.jasminadmin.rest.service.SnipCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SnipCartController {
    @Autowired
    private SnipCartService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<SnipCart> listSnipCart = service.listAll();
        model.addAttribute("listSnipCart", listSnipCart);
        return "indexsnipcart";
    }

    @GetMapping("/newSnipCart")
    public String add(Model model) {
        model.addAttribute("snipCart", new SnipCart());
        return "newSnipCart";
    }

    @RequestMapping(value = "/savesc", method = RequestMethod.POST)
    public String saveSnipCart(@ModelAttribute("snipCart") SnipCart prd) {
        service.save(prd);
        return "redirect:/";
    }

    @RequestMapping("/editsc/{id}")
    public ModelAndView showEditSnipCartPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        SnipCart prd = service.get(id);
        mav.addObject("snipCart", prd);
        return mav;
    }
    @RequestMapping("/deletesc/{id}")
    public String deleteSnipCart(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
*/