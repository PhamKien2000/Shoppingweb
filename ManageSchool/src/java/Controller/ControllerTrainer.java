package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import enity.Topics;
import enity.Trainer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dataprocess;

/**
 *
 * @author kienv
 */
@WebServlet(urlPatterns = {"/ControllerTrainer"})
public class ControllerTrainer extends HttpServlet {

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
       String action=request.getParameter("ac");
        if("add".equals(action))
        {
            String id=request.getParameter("txtID");
            String pass=request.getParameter("txtPass");
            String email=request.getParameter("txtMail");
            String address=request.getParameter("txtAddress");
            String birthday=request.getParameter("txtBithday");
            String profile=request.getParameter("txtProfile");
            String topic[]=request.getParameterValues("cbTopic");
            Dataprocess dt=new Dataprocess();
            if(dt.addTrainer(id, pass, email, address, birthday, profile)&&dt.addStaffInTopic(id, topic))
            {
                ArrayList<Trainer> list=dt.getTrainer();
                request.setAttribute("list", list);
                RequestDispatcher rd=request.getRequestDispatcher("AddTrainer.jsp");
                rd.forward(request, response);
                
            }
            else
            {
                response.sendRedirect("AddTrainer.jsp?code=1");
            }
        }
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
