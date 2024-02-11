package com.example.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "todoServlet", urlPatterns = "/todo")
public class TodoServlet extends HttpServlet {
    JSONArray todoList;

    public void init() {
        todoList = new JSONArray();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        JSONObject newlyAddedTodo = new JSONObject();
        newlyAddedTodo.put("title",title);
        newlyAddedTodo.put("description",description);
        todoList.add(newlyAddedTodo);
        PrintWriter out = resp.getWriter();

        doGet(req,resp);
        out.close();
        

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("<body><h2>Current Todos</h2>");
        todoList.forEach(todo -> {
            JSONObject jsonObject = (JSONObject) todo; // Cast todo to JSONObject
            jsonObject.keySet().forEach(key -> {
                // Use the key as needed
                out.println(key + " :: " + jsonObject.get(key) +"<br/>");
            });

        }

//            out.println();
        );
        out.close();

    }

    public void destroy() {
    }
}
