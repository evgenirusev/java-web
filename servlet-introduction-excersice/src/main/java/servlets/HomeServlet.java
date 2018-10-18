package servlets;

import io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    private static final String PAGE_CONTENT = "assets/html/index.html";
    private static final String PAGE_PATH = "C:\\Users\\Evgeni\\IdeaProjects\\java-web-fundamentals\\servlet-introduction-excersice\\src\\main\\resources\\assets\\html\\index.html";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String responseContent = Reader.readFromFile(PAGE_PATH);
        out.println(responseContent);
        out.close();
    }
}
