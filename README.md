\# Wind Forecast Monitoring System - Submission



\## 1. Project Overview

A full-stack solution for monitoring UK wind generation, featuring data analysis, a Spring Boot backend, and a React dashboard.



\## 2. Data Analysis Results

Based on January 2024 data, the forecast error metrics are:

\- \*\*Mean Error\*\*: 12.03 MW

\- \*\*Median Error\*\*: 1.19 MW

\- \*\*P99 Error (Extreme misses)\*\*: 1896.51 MW

\- \*\*Recommended Reliable Capacity (P95)\*\*: \*\*15,737.41 MW\*\*



The P95 recommendation represents the "firm" generation level that was met or exceeded 95% of the time during the month.



\## 3. Tech Stack

\- \*\*Backend\*\*: Java / Spring Boot (REST API)

\- \*\*Frontend\*\*: React / Recharts

\- \*\*Analysis\*\*: Python / Pandas / Jupyter Notebook



\## 4. AI Disclosure

I utilized \*\*Gemini (Google AI)\*\* to assist in the development of this project:

\- \*\*Data Acquisition\*\*: AI helped generate a fallback data script when the primary API connection failed.

\- \*\*Backend\*\*: Assisted with Spring Boot project structure and CSV parsing logic.

\- \*\*Frontend\*\*: Helped with the horizon-based filtering logic and UI styling.



\## 5. Setup \& Running

\### Backend:

1\. `cd backend/wind-monitoring`

2\. `./mvnw spring-boot:run`



\### Frontend:

1\. `cd frontend`

2\. `npm install`

3\. `npm start`

