package Pruebas;

import Controllers.AdministradorController;
import Entidades.Administrador;
import Utils.JPAUtils;
import dao.AdministradorDao;

import javax.persistence.EntityManager;
import java.util.List;

public class PruebaAdministrador {
    public static void main(String[] args) {
        AdministradorController administradorController = new AdministradorController();

        if(administradorController.buscarAdministrador(new Administrador("Carlos", "1666"))){
            System.out.println("Encontró el administrador");
        } else {
            System.out.println("No encontro");
        }


    }
}
