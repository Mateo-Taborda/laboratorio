/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.student.session.EstudianteCursoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.unipiloto.student.entity.EstudianteCurso;
/**
 *
 * @author mateo
 */
public class RelacionServlet extends HttpServlet {

    @EJB
    private EstudianteCursoFacadeLocal estudianteCursoFacade;

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
        response.setContentType("text/html;charset=UTF-8");
        
        String CodigoCurso = request.getParameter("curso");
        int StudentId = Integer.parseInt(request.getParameter("student"));
        int Nota = Integer.parseInt(request.getParameter("nota")) ;
        
        
       EstudianteCurso estudiantecurso = new EstudianteCurso (StudentId,CodigoCurso, Nota );
        String option = request.getParameter("action");
        
        if (option.equals("Add")) {
            estudianteCursoFacade.create(estudiantecurso);
        }else if (option.equals("Edit")) {
            estudianteCursoFacade.edit(estudiantecurso);//REVISAR AHORITA
        }else if (option.equals("Delete")) {
            estudianteCursoFacade.remove(estudiantecurso);
        }else if (option.equals ("Search")) {
             estudianteCursoFacade.find(estudiantecurso.getEstudianteCursoPK().getIdEstudiante());
        }
        
        response.setContentType("text/html;charset=UTF-8");
       
        request.setAttribute("course", estudiantecurso);
        request.setAttribute("allCourse", estudianteCursoFacade.findAll());
        request.getRequestDispatcher("relacionInfo.jsp").forward (request,response);
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
