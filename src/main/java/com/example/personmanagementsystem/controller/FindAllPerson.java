package com.example.personmanagementsystem.controller;

import com.example.personmanagementsystem.sevice.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindAllPerson extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("list", PersonService.getInstance().findAll());
            req.getRequestDispatcher("/person/index.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg",e.getMessage());
            resp.sendError(707);
        }

    }
}
