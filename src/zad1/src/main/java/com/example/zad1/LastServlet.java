package com.example.zad1;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/last-servlet")
public class LastServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("text/html");


        String path = "cars.json";  //if it doesn't work - write absolute path to the file here
        String pathToNotes = "notes.txt";
        String content;
        content = Files.lines(Paths.get(path)).reduce("", String::concat);
        String chosenOption;
        chosenOption = Files.lines(Paths.get(pathToNotes)).reduce("", String::concat);

        JSONArray jsonArray1 = new JSONArray(content);

        printWriter.write("<table border=\"1\"><tr>");
        printWriter.write("<th>Model</th>");
        printWriter.write("<th>Year</th>");
        printWriter.write("<th>Fuel consumption</th></tr>");
        for (Object o : jsonArray1)
        {
            JSONObject person = (JSONObject) o;

            String name = (String) person.get("type");
            if(name.equals(chosenOption)) {


                printWriter.write("<tr>");
                String marka = (String) person.get("marka");
                printWriter.write("<td>" +marka + "</td>");

                int rok = (int) person.get("rok_produkcji");
                printWriter.write("<td>" +rok + "</td>");

                int paliwa = (int) person.get("zuzycie_paliwa");
                printWriter.write("<td>" +paliwa + "</td>");
                printWriter.write("</tr>");
            }
        }
        printWriter.write("</table>");
        printWriter.write("<form action=\"choise.jsp\">\n" +
                "    <button>New Search</button>\n" +
                "</form>");

    }
}
