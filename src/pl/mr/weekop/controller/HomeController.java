package pl.mr.weekop.controller;

import pl.mr.weekop.model.Discovery;
import pl.mr.weekop.service.DiscoveryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveDiscoveriesInRequest(request);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

    private void saveDiscoveriesInRequest(HttpServletRequest request) {
        DiscoveryService discoveryService=new DiscoveryService();
        List<Discovery> allDiscoveries=discoveryService.getAllDiscoveries((d1, d2) -> {
            int d1Vote=d1.getUpVote()-d1.getDownVote();
            int d2Vote=d2.getUpVote()-d2.getDownVote();
            if (d1Vote<d2Vote){
                return 1;
            }else if (d1Vote>d2Vote){
                return -1;
            }else
                return 0;
        });
        request.setAttribute("discoveries",allDiscoveries);
    }
}
