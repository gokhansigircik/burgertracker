package com.gokhan.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gokhan.burgertracker.models.Burger;
import com.gokhan.burgertracker.services.BurgerService;

@Controller
public class BurgerController {
  @Autowired
  BurgerService burgerService;

  @RequestMapping("/")
  public String createBurger(@ModelAttribute("burger") Burger burger, Model model) {
    List<Burger> burgers = burgerService.allBurgers();
    model.addAttribute("burgers", burgers);
    return "index.jsp";

  }

  @PostMapping("/burgers")
  public String allburgers(@Valid @ModelAttribute("burgers") Burger burger, BindingResult result, Model model) {
  if(result.hasErrors()){
    List<Burger> burgers = burgerService.allBurgers();
    burgerService.createBurger(burger);
    return "index.jsp";

	} else {
			burgerService.createBurger(burger);
			return "redirect:/";
		}
	}
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}
	
	
}
