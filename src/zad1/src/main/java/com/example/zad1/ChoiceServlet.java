package com.example.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;


@WebServlet("/choice-servlet")
public class ChoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String car_type = req.getParameter("car_type");


        try(FileWriter writer2 = new FileWriter("notes.txt", false))
        {
            writer2.write(car_type);
            writer2.append('\n');

            writer2.flush();
        }


        req.getRequestDispatcher("last-servlet").forward(req, resp);

    }



}
