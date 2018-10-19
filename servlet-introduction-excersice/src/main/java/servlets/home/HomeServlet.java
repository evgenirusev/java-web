package servlets.home;

import data.models.Animal;
import data.repositories.AnimalRepository;
import data.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        this.getServletContext().setAttribute("animals", new AnimalRepository());
        this.getServletContext().setAttribute("users", new UserRepository());
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
    }
}
