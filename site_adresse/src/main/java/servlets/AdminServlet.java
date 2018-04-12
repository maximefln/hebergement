package servlets;

import entities.Article;
import entities.Commentaire;
import entities.Recommandation;
import managers.ArticleLibrary;
import managers.CommentaireLibrary;
import managers.RecommandationLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/admin/admin")
@MultipartConfig
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //String identifiantUtilisateurConnecte = (String) req.getSession().getAttribute("utilisateurConnecte");
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
        resolver.setPrefix("WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        WebContext context = new WebContext(req, resp, req.getServletContext());
        List<Recommandation> recommandationList = RecommandationLibrary.getInstance().listRecommandation();
        List<Commentaire> listofcommentaire = CommentaireLibrary.getInstance().listCommentaire();

        context.setVariable("listRecommandation", recommandationList);
        context.setVariable("listCommentaire", listofcommentaire);

        engine.process("admin", context, resp.getWriter());


        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String nom = req.getParameter("nom");
        String nom_personne = req.getParameter("nom_personne");
        int note = Integer.parseInt(req.getParameter("note"));
        String description = req.getParameter("description");
        double coordonnee_x = Double.parseDouble(req.getParameter("coordonnee_x"));
        double coordonne_y = Double.parseDouble(req.getParameter("coordonnee_y"));
        String lien_article = req.getParameter("article");
        String image_accueil = req.getParameter("accueil");


        Article article = new Article(LocalDate.now(), null, nom, type, description, nom_personne, coordonne_y, coordonne_y, lien_article, image_accueil, note, 0, 0);

        ArticleLibrary.getInstance().addArticle(article);
        resp.sendRedirect("/admin/admin");
    }
}


