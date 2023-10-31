package com.pizzeria.springdatajpa.service;

import com.pizzeria.springdatajpa.persistence.entity.PizzaEntity;
import com.pizzeria.springdatajpa.persistence.repository.PizzaPagSortRepository;
import com.pizzeria.springdatajpa.persistence.repository.PizzaRepository;
import com.pizzeria.springdatajpa.service.dto.UpdatePizzaPriceDto;
import com.pizzeria.springdatajpa.service.exception.EmailApiException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author edwin
 */
@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaPagSortRepository = pizzaPagSortRepository;
        this.pizzaRepository = pizzaRepository;
    }

//    public List<PizzaEntity> getAll(){
//        return this.pizzaRepository.findAll();
//    }
    
    public Page<PizzaEntity> getAll(int page,int elements){
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.pizzaPagSortRepository.findAll(pageRequest);
    }
    
//    public List<PizzaEntity> getAvailable(){
//        System.out.println(this.pizzaRepository.countByVeganTrue());
//        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
//    }
    
    public Page<PizzaEntity> getAvailable(int page, int elements, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageRequest = PageRequest.of(page, elements, sort);
        return this.pizzaPagSortRepository.findByAvailableTrue(pageRequest);
    }
    
    public PizzaEntity getByName(String name){
        return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(()-> new RuntimeException("Pizza no encontrada"));
    }
    
    public List<PizzaEntity> getWith(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }
    
    public List<PizzaEntity> getWithout(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }
    
    public List<PizzaEntity> getCheapest(double price){
        return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }
    
    public PizzaEntity getById(int pizzaId){
        return this.pizzaRepository.findById(pizzaId).orElse(null);
    }
    
    public PizzaEntity save(PizzaEntity pizza){
        return this.pizzaRepository.save(pizza);
    }
    
    public boolean exists(int pizzaId){
        return this.pizzaRepository.existsById(pizzaId);
    }
    
    public void delete(int pizzaId){
        this.pizzaRepository.deleteById(pizzaId);
    }
    
    @Transactional(noRollbackFor = EmailApiException.class, propagation = Propagation.REQUIRED)
    public void updatePrice(UpdatePizzaPriceDto updatePizzaPriceDto){
        this.pizzaRepository.updatePrice(updatePizzaPriceDto);
        this.sendEmail();
    }
    
    private void sendEmail(){
        throw new EmailApiException();
    }
    
}
