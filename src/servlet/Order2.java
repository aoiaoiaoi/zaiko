package servlet;

import java.io.*;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.http.*;

import model.Items;
import model.PMF;
 
@SuppressWarnings("serial")
public class Order2 extends HttpServlet {
    public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("itemId");
        PrintWriter out = resp.getWriter();
        List<Items> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + Items.class.getName();
            try {
                list = (List<Items>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                Items data = (Items)manager.getObjectById(Items.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(Items data:list){
                res += "{itemId:" + data.getItemId() + ",itemName:'" + data.getItemName() + "',price:'" +
                    data.getPrice() + ",num,:'" + data.getNum()+  "',date:'" + data.getDatetime() + "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
}