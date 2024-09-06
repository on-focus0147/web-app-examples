package on.focus0147;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class App  extends HttpServlet {
    public String getSlogan() {
        return "The glass is half full or empty or null :)";
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            PrintWriter out = resp.getWriter();
            out.println(this.getSlogan());
            out.close();
        } catch (IOException e) {
            //nothing
        }

    }
}
