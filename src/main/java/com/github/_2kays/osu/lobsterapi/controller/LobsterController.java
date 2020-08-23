package com.github._2kays.osu.lobsterapi.controller;

import com.github._2kays.osu.lobsterapi.service.LobsterService;
import com.github._2kays.osu.lobsterapi.model.Lobster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LobsterController {
    @Autowired
    private LobsterService service;

    @GetMapping("/lobster")
    public List<Lobster> readAllLobsters() {
        return service.getAll();
    }

    @GetMapping("/error")
    public String error() {
        return "Invalid API request.";
    }
}

