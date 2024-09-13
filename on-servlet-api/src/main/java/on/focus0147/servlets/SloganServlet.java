package on.focus0147.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SloganServlet extends HttpServlet {
    public String getSlogan() {
        return "The glass is half full or empty or null :)";
    }

    public String getUrls(HttpServletRequest req){
        StringBuilder urlPrefix = new StringBuilder();
        urlPrefix.append(req.getScheme());
        urlPrefix.append("://");
        urlPrefix.append(req.getServerName());
        urlPrefix.append(":");
        urlPrefix.append(req.getServerPort());
        urlPrefix.append(req.getContextPath());

        StringBuilder builder  = new StringBuilder();
        builder.append("<html>");
        builder.append("<a href=\"");
        builder.append(urlPrefix);
        builder.append("/slogan");
        builder.append("\">slogan</a><br>");
        builder.append("<a href=\"");
        builder.append(urlPrefix);
        builder.append("/throw");
        builder.append("\">throw</a><br>");
        builder.append("<a href=\"");
        builder.append(urlPrefix);
        builder.append("/resource/1");
        builder.append("\">resource/1</a><br>");
        builder.append("<a href=\"");
        builder.append(urlPrefix);
        builder.append("/resource/2");
        builder.append("\">resource/2</a><br>");
        builder.append("<a href=\"");
        builder.append(urlPrefix);
        builder.append("/resource/31");
        builder.append("\">resource/31<br>");
        builder.append("<a href=\"");
        builder.append(urlPrefix);
        builder.append("/resource/32");
        builder.append("\">resource/32</a>");
        builder.append("</html>");

        return builder.toString();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //out.println(this.getSlogan());
        out.print(getUrls(req));
        out.close();
    }
}
