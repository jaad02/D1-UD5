package com.u4.springquiz;

import com.u4.springquiz.Entities.Jugador;
import com.u4.springquiz.Services.ServiciosJugador;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuizController {

    //  private final RepositorioPuntuaciones datos = new RepositorioPuntuaciones();
    @Autowired
    private ServiciosJugador db;

    @GetMapping("/")
    String index(HttpSession session) {
        return "index";
    }

    @PostMapping("/Quiz/Jugar")
    String pregunta1(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "opcion") String tablon, HttpSession session, Model model) {
        System.out.println(db.getAll());
        //  datos.guardar();
        if (tablon.equals("tablon")) {
            List<Jugador> jugador = db.getAll();
            model.addAttribute("datos", jugador);

            return "Tablon";
        }
        //por si el nombre esta vacio
        else if (nombre.isBlank()) {
            return "index";
        }
        session.setAttribute("nombre", nombre);
        session.setAttribute("puntuacion", 0);
        session.setAttribute("pregunta", 0);
        return "/Quiz/Jugar/pregunta1";

    }


    @PostMapping("/Quiz/Jugar/pregunta2")
    String pregunta2(@RequestParam(name = "seleccion") String seleccion, HttpSession session) {
        int puntos = CalcularResultados.CalcularResultadoP1(seleccion);
        session.setAttribute("puntuacion", (Integer) session.getAttribute("puntuacion") + puntos);
        session.setAttribute("pregunta", 1);

        return "/Quiz/Jugar/pregunta2";
    }

    @PostMapping("/Quiz/Jugar/pregunta3")
    String pregunta3(@RequestParam(name = "seleccion", required = false, defaultValue = "nada") String[] seleccion, HttpSession session) {
        int puntos = CalcularResultados.CalcularResultadoP2(seleccion);
        session.setAttribute("puntuacion", (Integer) session.getAttribute("puntuacion") + puntos);
        session.setAttribute("pregunta", 2);

        return "/Quiz/Jugar/pregunta3";
    }

    @PostMapping("/Quiz/Jugar/pregunta4")
    String pregunta4(@RequestParam(name = "seleccion") String seleccion, HttpSession session) {
        int puntos = CalcularResultados.CalcularResultadoP3(seleccion);
        session.setAttribute("puntuacion", (Integer) session.getAttribute("puntuacion") + puntos);
        session.setAttribute("pregunta", 3);

        return "/Quiz/Jugar/pregunta4";
    }

    @PostMapping("/Quiz/Jugar/pregunta5")
    String pregunta5(@RequestParam(name = "seleccion") String seleccion, HttpSession session) {
        int puntos = CalcularResultados.CalcularResultadoP4(seleccion);
        session.setAttribute("puntuacion", (Integer) session.getAttribute("puntuacion") + puntos);
        session.setAttribute("pregunta", 4);

        return "/Quiz/Jugar/pregunta5";
    }

    @PostMapping("/Quiz/Jugar/pregunta6")
    String pregunta6(@RequestParam(name = "seleccion") String seleccion, HttpSession session) {
        int puntos = CalcularResultados.CalcularResultadoP5(seleccion);
        session.setAttribute("puntuacion", (Integer) session.getAttribute("puntuacion") + puntos);
        session.setAttribute("pregunta", 5);

        return "/Quiz/Jugar/pregunta6";
    }

    @PostMapping("/Quiz/Jugar/pregunta7")
    String pregunta7(@RequestParam(name = "seleccion") String seleccion, HttpSession session) {
        int puntos = CalcularResultados.CalcularResultadoP6(seleccion);
        session.setAttribute("puntuacion", (Integer) session.getAttribute("puntuacion") + puntos);
        session.setAttribute("pregunta", 6);

        return "/Quiz/Jugar/pregunta7";
    }

    @PostMapping("/Quiz/Jugar/resultado")
    String resultado(@RequestParam(name = "seleccion", required = false, defaultValue = "nada") String[] seleccion, HttpSession session) {
        int puntos = CalcularResultados.CalcularResultadoP7(seleccion);
        session.setAttribute("puntuacion", (Integer) session.getAttribute("puntuacion") + puntos);
        db.save(new Jugador((String) session.getAttribute("nombre"), (Integer) session.getAttribute("puntuacion")));
        //datos.anadir((String) session.getAttribute("nombre"), (Integer) session.getAttribute("puntuacion"));

        session.setAttribute("pregunta", 7);
        session.setAttribute("categoria", CalcularResultados.determinarCategoria((Integer) session.getAttribute("puntuacion")).name());
        return "/Quiz/Jugar/resultado";

    }

    @GetMapping("/modificar")
    String modificar(@RequestParam(name = "seleccion") String seleccion, Model model, HttpSession session) {

        db.delete(Integer.parseInt(seleccion.split("/")[1]));
        model.addAttribute("datos", db.getAll());
        System.out.println("seleccion: " + seleccion);
        return "Tablon";
    }

}
