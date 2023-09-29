package dao;

import Entidades.Huesped;
import Entidades.Reserva;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class HuespedDao {

    private EntityManager em;

    public HuespedDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(Huesped huesped) {
        this.em.persist(huesped);
    }


    public void actualizar(Huesped huesped) {
        this.em.merge(huesped);
    }

    public void remover(Huesped huesped) {
        huesped=this.em.merge(huesped);
        this.em.remove(huesped);
    }

    public Huesped consultaPorId(Long id) {
        return em.find(Huesped.class, id);
    }

    public List<Huesped> consultarTodos(){
        String jqpl= "SELECT R FROM Huesped AS R";
        return em.createQuery(jqpl,Huesped.class).getResultList();
    }

    public List<Huesped> consultarReservaPorNombre(String nombre){
        String jqpl= "SELECT H FROM Huesped AS H WHERE H.nombre_de_usuario=:nombre";
        return em.createQuery(jqpl,Huesped.class).setParameter("nombre", nombre).getResultList();
    }


    public List<Huesped> buscarPorApellido(String apellido) {
        String jqpl= "SELECT H FROM Huesped AS H WHERE H.apellido=:apellido";
        return em.createQuery(jqpl,Huesped.class).setParameter("apellido", apellido).getResultList();
    }

    public List<Huesped> buscarPorReservaId(Long id) {
        String jqpl= "SELECT H FROM Huesped AS H JOIN FETCH H.reserva R WHERE R.id=:id";
        System.out.println(jqpl);
        return em.createQuery(jqpl,Huesped.class).setParameter("id", id).getResultList();
    }

    public Boolean buscarHuesped(Huesped huesped) {
        String nombre = huesped.getNombre();
        String apellido = huesped.getApellido();
        LocalDate fecha_de_nacimiento = huesped.getFecha_de_nacimiento();
        String nacionalidad = huesped.getNacionalidad();
        String jqpl= "SELECT H FROM Huesped AS H WHERE H.nombre=:nombre AND H.apellido=:apellido AND H.fecha_de_nacimiento=:fecha_de_nacimiento AND nacionalidad=:nacionalidad";
        return !em.createQuery(jqpl,Huesped.class)
                .setParameter("nombre", nombre)
                .setParameter("apellido", apellido)
                .setParameter("fecha_de_nacimiento", fecha_de_nacimiento)
                .setParameter("nacionalidad", nacionalidad)
                .getResultList().isEmpty();
    }

    public Huesped buscarHuespedConDatos(Huesped huesped) {
        String nombre = huesped.getNombre();
        String apellido = huesped.getApellido();
        LocalDate fecha_de_nacimiento = huesped.getFecha_de_nacimiento();
        String nacionalidad = huesped.getNacionalidad();
        String jqpl= "SELECT H FROM Huesped AS H WHERE H.nombre=:nombre AND H.apellido=:apellido AND H.fecha_de_nacimiento=:fecha_de_nacimiento AND nacionalidad=:nacionalidad";
        return em.createQuery(jqpl,Huesped.class)
                .setParameter("nombre", nombre)
                .setParameter("apellido", apellido)
                .setParameter("fecha_de_nacimiento", fecha_de_nacimiento)
                .setParameter("nacionalidad", nacionalidad)
                .getResultList().get(0);
    }
}
