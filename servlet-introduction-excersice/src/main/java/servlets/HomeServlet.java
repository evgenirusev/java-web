package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    private static final String PAGE_CONTENT = "assets/html/index.html";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        File file = new File("C:\\Users\\Evgeni\\IdeaProjects\\java-web-fundamentals\\servlet-introduction-excersice\\src\\main\\resources\\assets\\html\\index.html");
        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String st;
        while ((st = br.readLine()) != null) {
            sb.append(st);
        }

    PrintWriter out = response.getWriter();
        out.println(sb.toString());
        out.close();
    }
}
