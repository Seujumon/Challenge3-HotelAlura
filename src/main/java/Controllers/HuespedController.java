package Controllers;

import Entidades.Huesped;
import Entidades.Reserva;
import Utils.JPAUtils;
import dao.HuespedDao;
import dao.ReservaDao;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class HuespedController {
    HuespedDao huespedDao;
    EntityManager em;
    public HuespedController(){
        this.em = JPAUtils.getEntityManager();
        this.huespedDao = new HuespedDao(em);
    }



    public void crearHuesped(Huesped huesped){
        em.getTransaction().begin();
        huespedDao.guardar(huesped);
        em.getTransaction().commit();
    }

    public List<Huesped> buscarHuespedes(){
        em.getTransaction().begin();
        List<Huesped> resultado = huespedDao.consultarTodos();
        em.getTransaction().commit();
        return resultado;

    }

    public List<Huesped> buscarPorApellido(String apellido){
        if(apellido != null){
        em.getTransaction().begin();
        List<Huesped> resultado = huespedDao.buscarPorApellido(apellido);
        em.getTransaction().commit();
        return resultado;}
        return new ArrayList<Huesped>();
    }
    public List<Huesped> buscarPorReservaId(Long id){
        if(id != null){
            em.getTransaction().begin();
            List<Huesped> resultado = huespedDao.buscarPorReservaId(id);
            em.getTransaction().commit();
            return resultado;
        }
        return new ArrayList<Huesped>();
    }
    public void actualizarHuesped(Huesped huesped) {
        em.getTransaction().begin();
        huespedDao.actualizar(huesped);
        em.getTransaction().commit();
    }

    public Huesped buscarHuespedPorId(Long id) {
        em.getTransaction().begin();
        Huesped huesped = huespedDao.consultaPorId(id);
        em.getTransaction().commit();
        return huesped;
    }

    public void eliminarHuesped(Huesped huesped) {
        em.getTransaction().begin();
        huespedDao.remover(huesped);
        em.getTransaction().commit();
    }

    public void modificar(Huesped huesped) {
        em.getTransaction().begin();
        huespedDao.actualizar(huesped);
        em.getTransaction().commit();
    }

    public Boolean buscarHuespedEnSistema(Huesped huesped) {
        em.getTransaction().begin();
        Boolean encontrado = huespedDao.buscarHuesped(huesped);
        em.getTransaction().commit();
        return encontrado;
    }

    public Huesped buscarHuesped(Huesped huesped) {
        em.getTransaction().begin();
        Huesped h = huespedDao.buscarHuespedConDatos(huesped);
        em.getTransaction().commit();
        return h;
    }
}
