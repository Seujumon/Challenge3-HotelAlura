package Controllers;

import Entidades.Administrador;
import Utils.JPAUtils;
import dao.AdministradorDao;

import javax.persistence.EntityManager;
import java.util.List;

public class AdministradorController {
    AdministradorDao administradorDao;
    EntityManager em;
    public AdministradorController(){
        this.em = JPAUtils.getEntityManager();
        this.administradorDao = new AdministradorDao(em);
    }

    public Boolean buscarAdministrador(Administrador administrador){
        if(administrador==null || administrador.getNombre_de_usuario()==null || administrador.getContrasenia()==null){
            return false;
        }
        em.getTransaction().begin();
        List <Administrador> recibidos = administradorDao.consultarAdministradorPorNombre(administrador.getNombre_de_usuario());
        em.getTransaction().commit();

        for (Administrador admin: recibidos ){
            System.out.println("Encontro un administrador");
            if(admin.getContrasenia().equals(administrador.getContrasenia())){
                return true;
            }
        }
        return false;
    }

    public void crearAdministrador(Administrador administrador){
        em.getTransaction().begin();
        administradorDao.guardar(administrador);
        em.getTransaction().commit();

    }




}
