package com.mg.app.PharmaSys.service.stock;

import com.mg.app.PharmaSys.model.stock.MvtStock;
import com.mg.app.PharmaSys.repository.stock.MvtStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MvtStockService {
    private final MvtStockRepository mvtStockRepository;

    @Autowired
    public MvtStockService(MvtStockRepository mvtStockRepository) {
        this.mvtStockRepository = mvtStockRepository;
    }

    public MvtStock createMvtStock(MvtStock mvtStock) {
        return mvtStockRepository.save(mvtStock);
    }

    public List<MvtStock> readMvtStock() {
        return mvtStockRepository.findAll();
    }

    public MvtStock updateMvtStock(MvtStock mvtStock) {
        return mvtStockRepository.save(mvtStock);
    }

    public void deleteMvtStock(Integer id) {
        mvtStockRepository.deleteById(id);
    }

    ///
    public MvtStock getMvtStockById(Integer id) {
        return mvtStockRepository.findById(id).orElse(null);
    }
}
