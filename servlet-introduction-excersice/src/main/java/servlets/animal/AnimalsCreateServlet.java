package servlets.animal;

import entities.Animal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/animals/create")
public class AnimalsCreateServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/jsp/animals/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String color = req.getParameter("name");
        Integer legs = Integer.parseInt(req.getParameter("legs"));

        Animal animal = new Animal(name, breed, color, legs);

        List<Animal> animals = (List<Animal>) this.getServletContext().getAttribute("animals");
        animals.add(animal);

        //resp.sendRedirect("/animals/profile?animalName=" + name);
        resp.sendRedirect("/");
    }
}
