package mainpackage;

import infopackage.Info;
import org.xml.sax.SAXException;
import parsingpackage.DOMParser;
import piechartpackage.PieChart;
import tourpackage.Tour;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "JspServlet", urlPatterns = "/index")
public class JspServlet extends HttpServlet {

    public static ArrayList<Tour> toursCatalog = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DOMParser parser = new DOMParser();
        parser.parse();

        req.setAttribute("tours", toursCatalog);
        req.setAttribute("avDays", Info.findAverageNumberOfDays(toursCatalog));
        req.setAttribute("avPeople", Info.findAverageNumberOfPeople(toursCatalog));
        req.setAttribute("avPrice", Info.findAveragePrice(toursCatalog));
        req.setAttribute("maxDays", Info.findMaxNumberOfDays(toursCatalog));
        req.setAttribute("maxPeople", Info.findMaxNumberOfPeople(toursCatalog));
        req.setAttribute("maxPrice", Info.findMaxPrice(toursCatalog));
        req.setAttribute("minDays", Info.findMinNumberOfDays(toursCatalog));
        req.setAttribute("minPeople", Info.findMinNumberOfPeople(toursCatalog));
        req.setAttribute("minPrice", Info.findMinPrice(toursCatalog));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        showDiagram();
    }

    public void showDiagram() {
        PieChart demo = new PieChart( "Количество человек" );
        demo.setSize( 560 , 367 );
        demo.setVisible( true );
    }
}