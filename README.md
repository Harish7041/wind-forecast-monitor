# UK Wind Forecast Monitoring System

## 1. Project Overview

A professional full-stack solution designed to monitor and analyze UK wind generation data. This project features a statistical analysis of forecast reliability, a robust Spring Boot backend, and an interactive React dashboard.

## 2. Quick Links

- **Live Demo (Vercel):** https://wind-forecast-monitor-blush.vercel.app/
- **Video Walkthrough (YouTube):** https://youtu.be/9k_e_O86kCs
- **Source Code (Google Drive):** https://drive.google.com/file/d/1LKv_64P-llszbF8TaxPFF71GLblmnzxc/view?usp=sharing

## 3. Data Analysis & Reliability

Using Python/Pandas to analyze January 2024 data, I established the following performance metrics:

- **Mean Error**: 12.03 MW
- **Median Error**: 1.19 MW
- **P95 Reliable Capacity**: **15,737.41 MW**
- **Key Recommendation:** The P95 value (15,737.41 MW) represents the "firm" generation level that the grid can rely on with 95% confidence. This is my recommended baseline for grid stability scheduling.

## 4. Tech Stack

- **Frontend:** React.js, Recharts (SVG-based visualization), Axios
- **Backend:** Java, Spring Boot (REST API), OpenCSV
- **Analysis:** Python, Pandas, Jupyter Notebooks
- **Deployment:** Vercel (Frontend)

## 5. AI Collaboration Disclosure

I utilized **Gemini (Google AI)** as an adaptive pair-programmer to enhance project delivery:

- **Architecture:** Assisted in designing the separation of concerns between the data analysis layer and the API.
- **Logic Optimization:** Helped refine the P95 quantile calculations and the backend horizon-filtering logic.
- **Troubleshooting:** Aided in resolving CORS configuration issues during deployment.

## 6. Setup & Running

### Backend

1. Navigate to `backend/`
2. Run `./mvnw spring-boot:run`
3. API will be available at `http://localhost:8080`

### Frontend

1. Navigate to `frontend/`
2. Run `npm install` (to restore dependencies)
3. Run `npm start`
4. Dashboard will be available at `http://localhost:3000`
