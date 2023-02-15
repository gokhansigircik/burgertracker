package com.gokhan.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
  public String allburgers(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
  if(result.hasErrors()){
    List<Burger> burgers = burgerService.allBurgers();
    model.addAttribute("burgers", burgers);
    return "index.jsp";

	} else {
			burgerService.createBurger(burger);
			return "redirect:/";
		}
	}
	@RequestMapping("burgers/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}
	@PutMapping("edit/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			burgerService.updateBurger(burger);
			return "redirect:/";
		}
	}
	// @RequestMapping(value="/burgers/{id}", method=RequestMethod.DELETE)
	// public String destroy(@PathVariable("id") Long id) {
	// 	burgerService.deleteBurger(id);
	// 	return "redirect:/";
	// }
}
