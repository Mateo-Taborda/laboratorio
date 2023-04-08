/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.student.session.CursoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.unipiloto.student.entity.Curso;
/**
 *
 * @author mateo
 */
public class CursoServlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

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
        String CodigoCurso = request.getParameter("codigo_curso");
        String NombreCurso = request.getParameter("nombre_curso");
        int NumeroCreditos = Integer.parseInt(request.getParameter("numero_creditos")) ;
        String Semestre = request.getParameter("semestre");
        int NumeroEstudiantesAdimitidos = Integer.parseInt(request.getParameter("num_estudiantes_admitidos"));
       Curso curso = new Curso (CodigoCurso,NombreCurso,NumeroCreditos, Semestre,NumeroEstudiantesAdimitidos);
        String option = request.getParameter("action");
        
        if (option.equals("Add")) {
            cursoFacade.create(curso);
        }else if (option.equals("Edit")) {
            cursoFacade.edit(curso);//REVISAR AHORITA
        }else if (option.equals("Delete")) {
            cursoFacade.remove(curso);
        }else if (option.equals ("Search")) {
             cursoFacade.find(curso.getCodigoCurso());
        }
        
        response.setContentType("text/html;charset=UTF-8");
       
        request.setAttribute("course", curso);
        request.setAttribute("allCourse", cursoFacade.findAll());
        request.getRequestDispatcher("cursoInfo.jsp").forward (request,response);
        
        
     

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
