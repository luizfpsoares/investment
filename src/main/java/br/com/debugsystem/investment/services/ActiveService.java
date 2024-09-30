package br.com.debugsystem.investment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.debugsystem.investment.dtos.ActiveDTO;
import br.com.debugsystem.investment.entities.Active;
import br.com.debugsystem.investment.infra.ActiveRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ActiveService {

    @Autowired
    private ActiveRepository activeRepository;

    public List<ActiveDTO> findAll(){
        List<Active> actives = activeRepository.findAll();
        return actives.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ActiveDTO getById(Long id) {
        Active active = activeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Active not found with id: " + id));
        return convertToDTO(active);
    }

    public void saveActive(Active active) {
        activeRepository.save(active);
    }

    public void updateActive(Active active, Long id) {
        Active exist = activeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Active not found with id: " + id));
        exist.setName(active.getName());
        exist.setCode(active.getCode());
        exist.setAccountType(active.getAccountType());
        activeRepository.save(exist);
    }

    public void deleteById(Long id) {
        activeRepository.deleteById(id);
    }

    private ActiveDTO convertToDTO(Active active) {
        return new ActiveDTO(
            active.getId(),
            active.getName(),
            active.getCode(),
            active.getAccountType().toString()
        );
    }
}
