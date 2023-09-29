package dao;

import Entidades.Administrador;
import Entidades.Reserva;

import javax.persistence.EntityManager;
import java.util.List;

public class ReservaDao {
    private EntityManager em;

    public ReservaDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(Reserva reserva) {
        this.em.persist(reserva);
    }


    public void actualizar(Reserva reserva) {
        this.em.merge(reserva);
    }

    public void remover(Reserva reserva) {
        reserva=this.em.merge(reserva);
        this.em.remove(reserva);
    }

    public Reserva consultaPorId(Long id) {
        return em.find(Reserva.class, id);
    }

    public List<Reserva> consultarTodos(){
        String jqpl= "SELECT R FROM Reserva AS R";
        return em.createQuery(jqpl,Reserva.class).getResultList();
    }

    public List<Reserva> consultarReservaPorNombre(String nombre){
        String jqpl= "SELECT R FROM Reserva AS R WHERE R.nombre_de_usuario=:nombre";
        return em.createQuery(jqpl,Reserva.class).setParameter("nombre", nombre).getResultList();
    }

}
