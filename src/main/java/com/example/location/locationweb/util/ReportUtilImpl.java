package com.example.location.locationweb.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.jfree.chart.ChartUtils.*;

@Component
public class ReportUtilImpl implements ReportUtil{
    @Override
    public void generatePieChart(String Path, List<Object[]> dataSet) throws IOException {
        var pieDataset= new DefaultPieDataset();
        for (Object[] data : dataSet) {
            pieDataset.setValue(data[0].toString(),new Double(data[1].toString()));
        }
        JFreeChart jFreeChart= ChartFactory.createPieChart3D("Location Type Report", pieDataset,false,false,false);
        saveChartAsJPEG(new File(Path+"/pieChart.jpeg"),jFreeChart,300,300);
        //ChartUtils.saveChartAsPNG();
    }
}
