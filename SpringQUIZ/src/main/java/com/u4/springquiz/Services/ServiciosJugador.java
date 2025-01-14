package com.u4.springquiz.Services;

import com.u4.springquiz.Entities.Jugador;
import com.u4.springquiz.Repositories.RepositorioJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosJugador {

    @Autowired
    private RepositorioJugador repo;

    public List<Jugador> getAll(){
        return (List<Jugador>) repo.findByPuntuacionGreaterThanEqualOrderByPuntuacionDesc(1000);
    }
    public void save (Jugador j){
        repo.save(j);
    }

    public void delete (Integer id){
        repo.deleteById(id);
    }
}
