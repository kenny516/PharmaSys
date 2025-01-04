package com.mg.app.PharmaSys.service.stock;

import com.mg.app.PharmaSys.model.stock.TypeMvtStock;
import com.mg.app.PharmaSys.repository.stock.TypeMvtStockRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TypeMvtStockService {
    private final TypeMvtStockRepository typeMvtStockRepository;


    public TypeMvtStock createTypeMvtStock(TypeMvtStock typeMvtStock){
        return typeMvtStockRepository.save(typeMvtStock);
    }
    public List<TypeMvtStock> readTypeMvtStock(){
        return typeMvtStockRepository.findAll();
    }
    public TypeMvtStock updateTypeMvtStock(TypeMvtStock typeMvtStock){
        return typeMvtStockRepository.save(typeMvtStock);
    }
    public void deleteTypeMvtStock(Integer id){
        typeMvtStockRepository.deleteById(id);
    }

    ///
    public TypeMvtStock getTypeMvtStockById(Integer id){
        return typeMvtStockRepository.findById(id).orElse(null);
    }
}
