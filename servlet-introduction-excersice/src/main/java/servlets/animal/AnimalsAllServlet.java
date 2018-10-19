package servlets.animal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/animals/all")
public class AnimalsAllServlet extends HttpServlet {
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException, ServletException {
        List<String> names = new ArrayList<String>() {{
            add("Pesho");
            add("Gosho");
            add("Tosho");
            add("Evgeni");
        }};

        this.getServletContext().setAttribute("names", names);

        req.getRequestDispatcher("/WEB-INF/jsp/animals/all.jsp").forward(req, resp);
    }
}