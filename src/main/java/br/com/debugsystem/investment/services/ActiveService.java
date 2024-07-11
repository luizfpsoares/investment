package br.com.debugsystem.investment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.debugsystem.investment.entities.Active;
import br.com.debugsystem.investment.infra.ActiveRepository;

@Service
public class ActiveService {

    @Autowired
    private ActiveRepository activeRepository;

    public List<Active> findAll(){
        return activeRepository.findAll();
    }

    public Active getById(Long id) {
        return activeRepository.findById(id).orElseThrow();
    }

    public void saveActive(Active active) {
        activeRepository.save(active);
    }

    public void updateActive(Active active, Long id) {
        Active exist = activeRepository.findById(id).orElseThrow();
        exist.setName(active.getName());
        exist.setCode(active.getCode());
        activeRepository.save(exist);
    }

    public void deleteById(Long id) {
        activeRepository.deleteById(id);
    }
}
