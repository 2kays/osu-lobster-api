package com.github._2kays.osu.lobsterapi.service;

import com.github._2kays.osu.lobsterapi.model.SpinyLobster;
import com.github._2kays.osu.lobsterapi.repository.SpinyLobsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpinyLobsterService {
    @Autowired
    private SpinyLobsterRepository spinyLobsterRepository;

    public List<SpinyLobster> getAllSpinyLobsters() {
        return spinyLobsterRepository.findAll();
    }

    public Optional<SpinyLobster> getSpinyLobster(Long id) {
        return spinyLobsterRepository.findById(id);
    }

    public void postSpinyLobster(String name, Integer spineCount) {
        SpinyLobster spinyLobster = new SpinyLobster();
        spinyLobster.setName(name);
        spinyLobster.setSpineCount(spineCount);
        spinyLobsterRepository.save(spinyLobster);
    }

    public SpinyLobster putSpinyLobster(Long id, String name, Integer spineCount) {
        // Pull out the SpinyLobster definition. We're only updating the fields
        // that the user specified in their PUT request.
        SpinyLobster spinyLobster = this.getSpinyLobster(id).orElse(null);
        if (spinyLobster == null) {
            return null;
        }

        if (name != null) {
            spinyLobster.setName(name);
        }
        if (spineCount != null) {
            spinyLobster.setSpineCount(spineCount);
        }

        spinyLobsterRepository.save(spinyLobster);
        return spinyLobster;
    }

    public boolean deleteSpinyLobster(Long id) {
        SpinyLobster spinyLobster = this.getSpinyLobster(id).orElse(null);
        if (spinyLobster == null) {
            return false;
        }
        spinyLobsterRepository.delete(spinyLobster);
        return true;
    }
}
