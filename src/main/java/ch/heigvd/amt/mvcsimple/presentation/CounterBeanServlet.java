package ch.heigvd.amt.mvcsimple.presentation;

import ch.heigvd.amt.mvcsimple.services.CounterService;
import ch.heigvd.amt.mvcsimple.services.CounterServiceLocal;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterBeanServlet", urlPatterns = "/part2")
public class CounterBeanServlet extends HttpServlet {

    @EJB
    private CounterServiceLocal counterService;
    @Override
    public void init() throws ServletException {
        super.init();
        try{
            Context ctx = new InitialContext();
            counterService = (CounterServiceLocal) ctx.lookup("java:module/CounterService");

        } catch (Exception e){
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if("reset".equals(command)){
            counterService.resetCounter();
        } else{
            counterService.incCounter();
        }
        response.getWriter().println("(STATELESS) This page has been accessed "+ counterService.getCounter() + " times.");
    }
}
