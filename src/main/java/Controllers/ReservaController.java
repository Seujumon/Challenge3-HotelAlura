package Controllers;

import Entidades.Administrador;
import Entidades.Reserva;
import Utils.JPAUtils;
import dao.ReservaDao;


import javax.persistence.EntityManager;
import java.util.List;

public class ReservaController {
    ReservaDao reservaDao;
    EntityManager em;
    public ReservaController(){
        this.em = JPAUtils.getEntityManager();
        this.reservaDao = new ReservaDao(em);
    }
    public void crearReserva(Reserva reserva){
        em.getTransaction().begin();
        reservaDao.guardar(reserva);
        em.getTransaction().commit();
    }

    public List<Reserva> buscarReservas(){
        em.getTransaction().begin();
        List<Reserva> resultado = reservaDao.consultarTodos();
        em.getTransaction().commit();
        return resultado;

    }


    public void eliminarReserva(Reserva reserva) {
        em.getTransaction().begin();
        reservaDao.remover(reserva);
        em.getTransaction().commit();

    }

    public Reserva buscarReservaPorId(Long id){
        em.getTransaction().begin();
        Reserva reserva = reservaDao.consultaPorId(id);
        em.getTransaction().commit();

        return reserva;
    }

    public void modificar(Reserva reserva) {
        em.getTransaction().begin();
        reservaDao.actualizar(reserva);
        em.getTransaction().commit();
    }
}
