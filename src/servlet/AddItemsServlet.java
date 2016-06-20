package servlet;

import java.io.IOException;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.Items;
import model.PMF;
 
public class AddItemsServlet extends HttpServlet {
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
        
        String itemName = req.getParameter("itemName");
        int price = Integer.parseInt(req.getParameter("price"));
        int num = Integer.parseInt(req.getParameter("num"));
        Date date = Calendar.getInstance().getTime();
        
        Items data = new Items(itemName,price,num,date);
        
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        resp.sendRedirect("/index.html");
    }
}