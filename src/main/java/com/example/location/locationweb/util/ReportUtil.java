package com.example.location.locationweb.util;

import java.io.IOException;
import java.util.List;

public interface ReportUtil {
    public void generatePieChart(String Path, List<Object[]> dataSet) throws IOException;
}
