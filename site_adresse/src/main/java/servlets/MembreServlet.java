package servlets;

import entities.Membre;
import managers.MembreLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/membre")
public class MembreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String identifiantUtilisateurConnecte = (String) req.getSession().getAttribute("utilisateurConnecte");
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
        resolver.setPrefix("WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        WebContext context = new WebContext(req, resp, req.getServletContext());
        List<Membre> membrelist = MembreLibrary.getInstance().listMembre();

        context.setVariable("listmembre", membrelist);

        engine.process("membre", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String fonction = req.getParameter("fonction");
        String lien= req.getParameter("lien");

        Membre membre = new Membre (null, nom, prenom, fonction, lien);

        MembreLibrary.getInstance().addMembre(membre);
        resp.sendRedirect("/admin/membre");
    }

}
