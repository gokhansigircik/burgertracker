package com.gokhan.burgertracker.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokhan.burgertracker.models.Burger;
import com.gokhan.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
    // // adding the book repository as a dependency
    // private final BookRepository bookRepository;
    
    // public BookService(BookRepository bookRepository) {
    //     this.bookRepository = bookRepository;
    // }

    @Autowired
    BurgerRepository burgerRepository;
    
    // returns all the books
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
    // creates a book
    public Burger createBurger(Burger b) {
        return burgerRepository.save(b);
    }
    // retrieves a book
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
	}
	public List<Burger> findAll(){
		return burgerRepository.findAll();
	}
	public Burger updateBurger(Burger b) {
		return burgerRepository.save(b);
	}
	public void deleteBurger(Long id) {
		this.burgerRepository.deleteById(id);
	}
}

