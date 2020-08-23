package com.github._2kays.osu.lobsterapi.service;

import com.github._2kays.osu.lobsterapi.model.Lobster;
import com.github._2kays.osu.lobsterapi.repository.LobsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LobsterService {

    @Autowired
    private LobsterRepository lobsterRepository;

    public List<Lobster> getAll() {
        return lobsterRepository.findAll();
    }

}
