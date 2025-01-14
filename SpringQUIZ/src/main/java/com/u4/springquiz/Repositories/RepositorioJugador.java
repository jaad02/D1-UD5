package com.u4.springquiz.Repositories;


import com.u4.springquiz.Entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioJugador extends JpaRepository<Jugador,Integer> {
    List<Jugador> findByPuntuacionGreaterThanEqualOrderByPuntuacionDesc(int puntuacion);
}
