package servlets;

import managers.RecommandationLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/supprimerRecommandation")
public class SupprimerRecommandationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        RecommandationLibrary.getInstance().DeleteRecommandation(id);
        resp.sendRedirect("/admin/recommander");
    }

}
