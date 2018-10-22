import org.rusev.catalina.servlet.BaseHttpServlet;
import org.rusev.catalina.servlet.HttpServletRequest;
import org.rusev.catalina.servlet.HttpServletResponse;
import org.softuni.javache.http.HttpStatus;

public class HomeServlet extends BaseHttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setStatusCode(HttpStatus.OK);
        response.addHeader("Content-Type", "text/html");

        response.setContent("Hi, from HomeServlet".getBytes());
    }
}
