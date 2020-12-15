/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.daoDepartement;
import DAO.daoEmploye;
import Entities.Departement;
import Entities.Employe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
@WebServlet("/")
public class CarrefourServlet extends HttpServlet {

    daoDepartement daodep = new daoDepartement();
    daoEmploye daoemp = new daoEmploye();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String action = request.getServletPath();
            System.out.println(action);
            try{
            switch (action){
                case "/Depart/Add":
                    {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Depart_Insert.jsp");
                    dispatcher.forward(request, response);
                    break;}
                case "/Depart/Insert":
                    {
                    String ID = request.getParameter("IdDep");
                    String Name = request.getParameter("DepName");
                    daodep.add(new Departement(ID,Name));
                    response.sendRedirect("Home");
                    break;}
                case "/Depart/Updateb":
                    {
                    String ID = request.getParameter("idDept");
                    String Name = request.getParameter("DepName");
                    request.setAttribute("idDept", ID);
                    request.setAttribute("DepName", Name);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Depart_Update.jsp");
                    dispatcher.forward(request, response);
                    break;}                    
                case "/Depart/Update":
                    {
                    String ID = request.getParameter("idDept");
                    String Name = request.getParameter("DepName");
                    daodep.update(new Departement(ID,Name));
                    response.sendRedirect("Home");
                    break;}
                case "/Depart/Delete":
                    {
                    String ID=request.getParameter("idDept");
                    daodep.DeleteByCode(ID);
                    response.sendRedirect("Home");
                    break;}                    
                case "/Depart/Home":
                    {
                    List<Departement> L = daodep.findAll();
                    request.setAttribute("Deps", L);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/Depart/Depart_Home.jsp");
                    dispatcher.forward(request, response);
                                       
                    break;}
                case "/Employe/Add":
                    {
                    List<Departement> L = daodep.findAll();
                    request.setAttribute("Deps", L);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Employe_Insert.jsp");
                    dispatcher.forward(request, response);
                    break;}
                case "/Employe/Insert":
                    {
                    String ID = request.getParameter("IdEmp");
                    String Name = request.getParameter("EmpName");
                    double salaire = Double.parseDouble(request.getParameter("salaire"));
                    Departement Dep = daodep.FindByCode(request.getParameter("refDept"));
                    System.out.println(daoemp.addEmploye(new Employe(ID,Name,salaire,Dep)));
                    response.sendRedirect("Home");
                    break;}
                case "/Employe/Updateb":
                    {
                    List<Departement> L = daodep.findAll();
                    request.setAttribute("Deps", L);
                    
                    String ID = request.getParameter("idEmp");
                    String Name = request.getParameter("EmpName");
                    String salaire = request.getParameter("salaire");
                    request.setAttribute("idEmp", ID);
                    request.setAttribute("EmpName", Name);
                    request.setAttribute("salaire", salaire);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Employe_Update.jsp");
                    dispatcher.forward(request, response);
                    break;}                    
                case "/Employe/Update":
                    {
                    String ID = request.getParameter("IdEmp");
                    String Name = request.getParameter("EmpName");
                    double salaire = Double.parseDouble(request.getParameter("salaire"));
                    Departement Dep = daodep.FindByCode(request.getParameter("refDept"));
                    daoemp.updateEmploye(new Employe(ID,Name,salaire,Dep));
                    response.sendRedirect("Home");
                    break;}
                case "/Employe/Delete":
                    {
                    String ID=request.getParameter("idEmp");
                    System.out.println(daoemp.deleteEmploye(daoemp.findByCode(ID)));
                    response.sendRedirect("Home");
                    break;}                    
                case "/Employe/Home":
                    {
                    List<Employe> L = daoemp.findAll();
                    request.setAttribute("Emps", L);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/Employe/Employe_Home.jsp");
                    dispatcher.forward(request, response);
                                       
                    break;}
                case "/HomePage":
                {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/MainPage.jsp");
                dispatcher.forward(request, response);

                break;}
                case "/":
                {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/MainPage.jsp");
                dispatcher.forward(request, response);

                break;}    
                default:{
//                    List<Departement> L = daodep.Tous();
//                    request.setAttribute("Deps", L);
//                    RequestDispatcher dispatcher = request.getRequestDispatcher("Depart_Home.jsp");
//                    dispatcher.forward(request, response);
                    break;}
                
                        }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

               doGet(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
