package net.komeo.m223.web.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.komeo.m223.web.model.KomeoMicroService;
import org.gitlab4j.api.models.User;

public class SimpleServlet extends HttpServlet {

    private static final String REST = "https://m223-api.komeo.net";
    private static final long UID = -4751096228274971485L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // set the response message's MIME type
        response.setContentType("text/html;charset=UTF-8");
        // allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();

        List<User> users = new KomeoMicroService().getAllUser();
        Iterator usersIterator = users.iterator();

        // write the response in HTML
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Komeo Users</title>");
            out.println("<style>\n"
                    + "#page-content {\n"
                    + " max-width: 1140px;\n"
                    + " margin: auto;\n"
                    + "}\n"
                    + "\n"
                    + ".thumbnail {\n"
                    + " max-width: 70px;\n"
                    + "}\n"
                    + "\n"
                    + "table {\n"
                    + " font-family: arial, sans-serif;\n"
                    + " border-collapse: collapse;\n"
                    + " width: 100%;\n"
                    + "}\n"
                    + "\n"
                    + "td, th {\n"
                    + " border: 1px solid #dddddd;\n"
                    + " text-align: left;\n"
                    + " padding: 8px;\n"
                    + "}\n"
                    + "\n"
                    + "tr:nth-child(even) {\n"
                    + " background-color: #dddddd;\n"
                    + "}\n"
                    + "</style>");

            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"page-content\">");
            out.println("<h1>Komeo Users</h1>");

            out.println("<h2>REST API: " + REST + "</h2>");
            out.println("<table>"
                    + "<tr>"
                    + "<th>avatarUrl</th>"
                    + "<th>id</th>"
                    + "<th>name</th>"
                    + "<th>username</th>"
                    + "<th>webUrl</th>"
                    + "</tr><tr>");

            while (usersIterator.hasNext()) {
                User user = (User) usersIterator.next();
                //KomeoUser user = (KomeoUser) usersIterator.next();
                String avatarUrl = user.getAvatarUrl();
                String id = "" + user.getId();
                String name = user.getName();
                String userName = user.getUsername();
                String uri = user.getWebUrl();
                out.print("<td><img src=");
                out.print(avatarUrl);
                out.print(" class=\"thumbnail\"></td><td>");
                out.print(id);
                out.print("</td><td>");
                out.print(name);
                out.print("</td><td>");
                out.print(userName);
                out.print("</td><td><a href=");
                out.print(uri);
                out.print(">" + uri + "</a>");
                out.println("</td></tr>");
            }
            out.println("</tr></table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            // always close the output writer
            out.close();
        }
    }
}
