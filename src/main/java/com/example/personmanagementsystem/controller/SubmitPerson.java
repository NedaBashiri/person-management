package com.example.personmanagementsystem.controller;

import com.example.personmanagementsystem.entity.Person;
import com.example.personmanagementsystem.sevice.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SubmitPerson extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String firstName = req.getParameter("firstName");
            String nationalCode = req.getParameter("nationalCode");
            String lastName = req.getParameter("lastName");

            Person person = new Person(firstName, lastName, nationalCode);
            PersonService.getInstance().save(person);
            resp.sendRedirect("/person/findAll.do");
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("msg",e.getMessage());
            resp.sendError(707);
        }

    }
}
