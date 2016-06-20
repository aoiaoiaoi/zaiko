package servlet;

import java.io.IOException;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.Items;
import model.PMF;
 
public class EditItemsServlet extends HttpServlet {
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
        String itemName = req.getParameter("itemName");
        int price = Integer.parseInt(req.getParameter("price"));
        int num = Integer.parseInt(req.getParameter("num")); 
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        Items data = (Items)manager.getObjectById(Items.class,itemId);
        data.setItemName(itemName);
        data.setPrice(price);
        data.setNum(num);
        manager.close();
        resp.sendRedirect("/index.html");
    }
}