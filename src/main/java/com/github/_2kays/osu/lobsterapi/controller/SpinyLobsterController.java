package com.github._2kays.osu.lobsterapi.controller;

import com.github._2kays.osu.lobsterapi.model.SpinyLobster;
import com.github._2kays.osu.lobsterapi.service.SpinyLobsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lobster/spiny")
public class SpinyLobsterController {

    @Autowired
    private SpinyLobsterService service;

    // Retrieves every stored Spiny Lobster definition.
    //
    // GET /lobster/spiny
    @GetMapping("")
    public List<SpinyLobster> readAllSpinyLobsters() {
        return service.getAllSpinyLobsters();
    }

    // Retrieves a single Spiny Lobster definition by ID.
    // HTTP 404 (Not Found) if no definition found for this ID.
    //
    // GET /lobster/spiny/{id}
    @GetMapping("/{id}")
    public ResponseEntity<SpinyLobster> readSpinyLobster(@PathVariable Long id) {
        SpinyLobster spinyLobster = service.getSpinyLobster(id).orElse(null);
        if (spinyLobster == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(spinyLobster);
        }
    }

    // Creates a new Spiny Lobster definition.
    // Autogenerates the Lobster ID.
    // HTTP 400 (Bad Request) if no "name" field is specified.
    //
    // POST /lobster/spiny
    // Accepts a JSON payload e.g. { "name": "Red Lobster", "spineCount": 3 }
    @PostMapping("")
    public ResponseEntity<String> writeSpinyLobster(@RequestBody Map<String, Object> requestBody) {
        // Ensure "name" is specified
        Object nameObj = requestBody.get("name");
        String name;
        if (nameObj != null && nameObj instanceof String) {
            name = (String) nameObj;
        } else {
            return ResponseEntity.badRequest().build();
        }

        // Pull out "spine_count" if it exists.
        Object spineCountObj = requestBody.get("spineCount");
        Integer spineCount = null;
        if (spineCountObj != null && spineCountObj instanceof Integer) {
            spineCount = (Integer) spineCountObj;
        }

        service.postSpinyLobster(name, spineCount);
        return ResponseEntity.ok("success");
    }

    // Updates an existing Spiny Lobster definition.
    // HTTP 404 (Not Found) if no definition found for this ID.
    // HTTP 400 (Bad Request) if no JSON fields are specified.
    //
    // PUT /lobster/spiny/{id}
    // Accepts a JSON payload e.g. { "name": "Red Lobster" }
    @PutMapping("/{id}")
    public ResponseEntity<SpinyLobster> updateSpinyLobster(@PathVariable Long id,
                                                           @RequestBody Map<String, Object> requestBody) {

        // Pull out the "name" and "spineCount" fields.
        // "name" is mandatory.
        // "spine_count" is optional, defaulting to NULL.

        Object nameObj = requestBody.get("name");
        String name = null;
        if (nameObj != null && nameObj instanceof String) {
            name = (String) nameObj;
        }

        Object spineCountObj = requestBody.get("spineCount");
        Integer spineCount = null;
        if (spineCountObj != null && spineCountObj instanceof Integer) {
            spineCount = (Integer) spineCountObj;
        }

        // If no fields specified, don't service the request.
        if (name == null || spineCount == null) {
            return ResponseEntity.badRequest().build();
        }

        SpinyLobster spinyLobster = service.putSpinyLobster(id, name, spineCount);
        if (spinyLobster == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(spinyLobster);
    }

    // Deletes an existing Spiny Lobster definition.
    // HTTP 404 (Not Found) if no definition found for this ID.
    //
    // DELETE /lobster/spiny/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpinyLobster(@PathVariable Long id) {
        SpinyLobster spinyLobster = service.getSpinyLobster(id).orElse(null);
        if (spinyLobster == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.deleteSpinyLobster(id);
            return ResponseEntity.ok("success");
        }
    }
}
