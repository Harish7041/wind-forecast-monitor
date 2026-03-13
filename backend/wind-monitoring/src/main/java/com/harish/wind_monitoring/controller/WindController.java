package com.harish.wind_monitoring.controller;

import com.harish.wind_monitoring.model.WindData;
import org.springframework.web.bind.annotation.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/api/wind")
@CrossOrigin(origins = "*") // Allows React to connect
public class WindController {

    @GetMapping("/forecast")
    public List<WindData> getForecastData(
            @RequestParam String start,
            @RequestParam String end,
            @RequestParam int horizon) {

        List<WindData> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime queryStart = LocalDateTime.parse(start, formatter);
        LocalDateTime queryEnd = LocalDateTime.parse(end, formatter);

        try {
            // Read the CSV we generated in Step 1
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    getClass().getResourceAsStream("/jan_wind_data.csv")));
            String line;
            br.readLine(); // Skip header

            // Explanation: We need to filter rows where the publishTime is BEFORE OR EQUAL TO (startTime - horizon)
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                LocalDateTime targetTime = LocalDateTime.parse(values[0], formatter);
                LocalDateTime publishTime = LocalDateTime.parse(values[1], formatter);

                if (!targetTime.isBefore(queryStart) && !targetTime.isAfter(queryEnd)) {
                    LocalDateTime maxAllowedPublishTime = targetTime.minusHours(horizon);

                    if (!publishTime.isAfter(maxAllowedPublishTime)) {
                        result.add(new WindData(values[0], Double.parseDouble(values[2]), Double.parseDouble(values[3])));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}