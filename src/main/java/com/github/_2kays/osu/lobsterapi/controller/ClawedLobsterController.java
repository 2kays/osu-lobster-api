package com.github._2kays.osu.lobsterapi.controller;

import com.github._2kays.osu.lobsterapi.service.ClawedLobsterService;
import com.github._2kays.osu.lobsterapi.model.ClawedLobster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lobster/clawed")
public class ClawedLobsterController {

    @Autowired
    private ClawedLobsterService service;

    // Retrieves every stored Clawed Lobster definition.
    //
    // GET /lobster/clawed
    @GetMapping("")
    public List<ClawedLobster> readAllClawedLobsters() {
        return service.getAllClawedLobsters();
    }

    // Retrieves a single Clawed Lobster definition by ID.
    // HTTP 404 (Not Found) if no definition found for this ID.
    //
    // GET /lobster/clawed/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ClawedLobster> readClawedLobster(@PathVariable Long id) {
        ClawedLobster clawedLobster = service.getClawedLobster(id).orElse(null);
        if (clawedLobster == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(clawedLobster);
        }
    }

    // Creates a new Clawed Lobster definition.
    // Autogenerates the Lobster ID.
    // HTTP 400 (Bad Request) if no "name" field is specified.
    //
    // POST /lobster/clawed
    // Accepts a JSON payload e.g. { "name": "Yellow Lobster" }
    @PostMapping("")
    public ResponseEntity<String> writeClawedLobster(@RequestBody Map<String, Object> requestBody) {
        // Ensure "name" is specified
        Object nameObj = requestBody.get("name");
        String name;
        if (nameObj != null && nameObj instanceof String) {
            name = (String) nameObj;
        } else {
            return ResponseEntity.badRequest().build();
        }

        service.postClawedLobster(name);
        return ResponseEntity.ok("success");
    }

    // Updates an existing Clawed Lobster definition.
    // HTTP 404 (Not Found) if no definition found for this ID.
    // HTTP 400 (Bad Request) if no JSON fields are specified.
    //
    // PUT /lobster/clawed/{id}
    // Accepts a JSON payload e.g. { "name": "Green Lobster" }
    @PutMapping("/{id}")
    public ResponseEntity<ClawedLobster> updateClawedLobster(@PathVariable Long id,
                                                             @RequestBody Map<String, Object> requestBody) {
        // Pull out the mandatory "name" field. Error if it is not specified.
        Object nameObj = requestBody.get("name");
        String name = null;
        if (nameObj != null && nameObj instanceof String) {
            name = (String) nameObj;
        } else {
            return ResponseEntity.badRequest().build();
        }

        ClawedLobster clawedLobster = service.putClawedLobster(id, name);
        if (clawedLobster == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clawedLobster);
    }

    // Deletes an existing Clawed Lobster definition.
    // HTTP 404 (Not Found) if no definition found for this ID.
    //
    // DELETE /lobster/clawed/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClawedLobster(@PathVariable Long id) {
        ClawedLobster clawedLobster = service.getClawedLobster(id).orElse(null);
        if (clawedLobster == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.deleteClawedLobster(id);
            return ResponseEntity.ok("success");
        }
    }
}
