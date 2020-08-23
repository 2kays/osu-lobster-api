package com.github._2kays.osu.lobsterapi.service;

import com.github._2kays.osu.lobsterapi.model.ClawedLobster;
import com.github._2kays.osu.lobsterapi.repository.ClawedLobsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClawedLobsterService {
    @Autowired
    private ClawedLobsterRepository clawedLobsterRepository;

    public List<ClawedLobster> getAllClawedLobsters() {
        return clawedLobsterRepository.findAll();
    }

    public Optional<ClawedLobster> getClawedLobster(Long id) {
        return clawedLobsterRepository.findById(id);
    }

    public void postClawedLobster(String name) {
        ClawedLobster clawedLobster = new ClawedLobster();
        clawedLobster.setName(name);
        clawedLobsterRepository.save(clawedLobster);
    }

    public ClawedLobster putClawedLobster(Long id, String name) {
        // Only valid field here is "name", so we update that.
        ClawedLobster clawedLobster = this.getClawedLobster(id).orElse(null);
        if (clawedLobster == null) {
            return null;
        }

        if (name != null) {
            clawedLobster.setName(name);
        }

        clawedLobsterRepository.save(clawedLobster);
        return clawedLobster;
    }

    public boolean deleteClawedLobster(Long id) {
        ClawedLobster clawedLobster = this.getClawedLobster(id).orElse(null);
        if (clawedLobster == null) {
            return false;
        }
        clawedLobsterRepository.delete(clawedLobster);
        return true;
    }
}
