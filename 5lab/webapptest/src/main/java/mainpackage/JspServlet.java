package mainpackage;

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
        try {
            parser.parse();
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("tours", toursCatalog);

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        showDiagram();
    }

    public void showDiagram() {
        PieChart demo = new PieChart( "Количество человек" );
        demo.setSize( 560 , 367 );
        demo.setVisible( true );
    }
}