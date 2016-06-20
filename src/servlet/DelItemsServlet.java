package servlet;

import java.io.IOException;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.Items;
import model.PMF;
 
public class DelItemsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long itemId = Long.parseLong(req.getParameter("itemId"));
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        Items data = (Items)manager.getObjectById(Items.class,itemId);
        manager.deletePersistent(data);
        manager.close();
        resp.sendRedirect("/index.html");
    }
}