package com.mjc813.band_jpa.service;

import com.mjc813.band_jpa.dto.BandDto;
import com.mjc813.band_jpa.dto.BandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandService {
    @Autowired
    private BandRepository bandRepository;

    public BandEntity insert(BandDto dto){
        BandEntity entity = new BandEntity(null, dto.getName(), dto.getLeader(), dto.getGuitarFirst(), dto.getGuitarSecond(), dto.getDrum(), dto.getBass(), dto.getKeyboard(), dto.getVocal());
        this.bandRepository.save(entity);
        return entity;
    }

    public BandEntity findById(Long id){
        Optional<BandEntity> find = this.bandRepository.findById(id);
        return find.orElse(null);
    }

    public List<BandEntity> findAll() {
        return this.bandRepository.findAll();
    }

    public BandEntity update(Long id, BandDto dto) {
        Optional<BandEntity> find = this.bandRepository.findById(id);
        if (find.isPresent()) {
            BandEntity entity = find.get();
            entity.setName(dto.getName());
            entity.setLeader(dto.getLeader());
            entity.setGuitarFirst(dto.getGuitarFirst());
            entity.setGuitarSecond(dto.getGuitarSecond());
            entity.setDrum(dto.getDrum());
            entity.setBass(dto.getBass());
            entity.setKeyboard(dto.getKeyboard());
            entity.setVocal(dto.getVocal());
            this.bandRepository.save(entity);
            return entity;
        }
        return null;
    }


    public void delete(Long id){
        this.bandRepository.deleteById(id);
    }
}
