package com.br.dslist.services;

import com.br.dslist.dto.GameDTO;
import com.br.dslist.dto.GameMinDTO;
import com.br.dslist.entities.Game;
import com.br.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get(); //Pegando o game pelo ID
        GameDTO dto = new GameDTO(result); // convertendo Game(entity) result para game Game dto
        return dto;
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
