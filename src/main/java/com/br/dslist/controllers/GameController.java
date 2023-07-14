package com.br.dslist.controllers;

import com.br.dslist.dto.GameDTO;
import com.br.dslist.dto.GameMinDTO;
import com.br.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();

        return result;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDTO> findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
