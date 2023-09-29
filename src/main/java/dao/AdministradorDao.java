package dao;

import Entidades.Administrador;

import javax.persistence.EntityManager;
import java.util.List;

public class AdministradorDao {
    private EntityManager em;

    public AdministradorDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(Administrador administrador) {
        this.em.persist(administrador);
    }


    public void actualizar(Administrador administrador) {
        this.em.merge(administrador);
    }

    public void remover(Administrador administrador) {
        administrador=this.em.merge(administrador);
        this.em.remove(administrador);
    }

    public Administrador consultaPorId(Long id) {
        return em.find(Administrador.class, id);
    }

    public List<Administrador> consultarTodos(){
        String jqpl= "SELECT A FROM Administrador AS A";
        return em.createQuery(jqpl,Administrador.class).getResultList();
    }

    public List<Administrador> consultarAdministradorPorNombre(String nombre){
        String jqpl= "SELECT A FROM Administrador AS A WHERE A.nombre_de_usuario=:nombre";
        return em.createQuery(jqpl,Administrador.class).setParameter("nombre", nombre).getResultList();
    }

}
