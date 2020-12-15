/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.daoDepartement;
import DAO.daoEmploye;
import Entities.Departement;
import Entities.Employe;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            daoDepartement dao= new daoDepartement();
            dao.add(new Departement("D5","DEPART 2"));
            Departement d1 = dao.FindByCode("D1");
            daoEmploye empdao= new daoEmploye();
                    Employe E = new Employe();
                    E.setIdEmp("Emp7");
                    E.setNom("HIBA");
                    E.setSalaire(9000d);
                    E.setRefDept(d1);
                    empdao.addEmploye(E);
             List<Employe>  L= d1.getEmployeList();
             System.out.println(d1.getIdDept()+"  "+d1.getNom());
             for(Employe d : L)
                 System.out.println(d.getIdEmp()+"  "+d.getNom());
    }
    
}
