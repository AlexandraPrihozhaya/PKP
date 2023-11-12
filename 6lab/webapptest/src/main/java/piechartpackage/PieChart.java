package piechartpackage;

import javax.swing.JPanel;

import static mainpackage.JspServlet.toursCatalog;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import tourpackage.Tour;

public class PieChart extends ApplicationFrame {

    public PieChart(String title) {
        super(title);
        setContentPane(createDemoPanel());
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Tour tour : toursCatalog ) {
            dataset.setValue(tour.getTitle(), new Integer(tour.getNumberOfPeople()));
        }
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("Количество человек", dataset, true, true, false);
        return chart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
}