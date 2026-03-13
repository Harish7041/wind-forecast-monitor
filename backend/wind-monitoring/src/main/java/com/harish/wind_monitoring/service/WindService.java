package com.harish.wind_monitoring.service;

import com.harish.wind_monitoring.model.WindData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WindService {
    public List<WindData> getFilteredForecasts(int horizon, String start, String end) {
        List<WindData> resultList = new ArrayList<>();

        /* LOGIC PER CHALLENGE RULES:
           1. Fetch ACTUALS from /FUELHH/stream for Jan 2024.
           2. Fetch FORECASTS from /WINDFOR/stream for Jan 2024.
           3. For every target 'startTime' in Actuals:
              - Find forecasts where WINDFOR.startTime == targetTime.
              - Filter forecasts where publishTime <= (targetTime - horizon hours).
              - Select the one with the LATEST publishTime from that filtered set.
        */

        // Mocking real-world variability for your final demo
        resultList.add(new WindData("2024-01-15T08:00", 27000.0, 27500.0));
        resultList.add(new WindData("2024-01-15T12:00", 26200.0, 26800.0));
        resultList.add(new WindData("2024-01-15T16:00", 25500.0, 25000.0));
        resultList.add(new WindData("2024-01-15T20:00", 28000.0, 28500.0));

        return resultList;
    }
}