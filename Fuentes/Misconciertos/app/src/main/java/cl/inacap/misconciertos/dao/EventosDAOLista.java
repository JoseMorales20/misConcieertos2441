package cl.inacap.misconciertos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.misconciertos.dto.Evento;

public class EventosDAOLista implements EventosDAO {
    private List<Evento> eventos = new ArrayList<>();
    public static EventosDAOLista gestor;



    public static EventosDAOLista getInstance(){
        if(gestor == null){
            gestor = new EventosDAOLista();
        }
        return gestor;
    }
    @Override
    public List<Evento> getAll() {
        return null;
    }

    @Override
    public Evento save(Evento e) {
        eventos.add(e);
        return e;
    }
}
