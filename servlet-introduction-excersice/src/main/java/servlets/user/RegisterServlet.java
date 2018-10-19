package servlets.user;

import data.models.User;
import data.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/jsp/users/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        UserRepository ur = (UserRepository)this.getServletContext().getAttribute("users");

        if (password == null || !password.equals(confirmPassword)) {
            resp.sendRedirect("/users/register");
            return;
        }

        if (ur.doesUserExist(username)) {
            resp.sendRedirect("/users/register");
            return;
        }

        ((UserRepository) this.getServletContext().getAttribute("users")).addUser(new User(username, password));
        resp.sendRedirect("/users/login");
    }
}