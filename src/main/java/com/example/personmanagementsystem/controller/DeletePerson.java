package com.example.personmanagementsystem.controller;

import com.example.personmanagementsystem.sevice.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nationalCode = req.getParameter("nationalCode");
            PersonService.getInstance().delete(nationalCode);
            resp.sendRedirect("/person/findAll.do");
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("msg",e.getMessage());
            resp.sendError(707);
        }
    }
}
