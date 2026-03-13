import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, Legend } from 'recharts';
import './App.css';

function App() {
  const [horizon, setHorizon] = useState(4);
  const [startTime, setStartTime] = useState("2024-01-01T08:00:00");
  const [endTime, setEndTime] = useState("2024-01-02T08:00:00");
  const [data, setData] = useState([]);

  useEffect(() => {
    // Explanation: React calls this every time horizon, start, or end changes.
    const fetchData = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/wind/forecast?start=${startTime}&end=${endTime}&horizon=${horizon}`
        );
        setData(response.data);
      } catch (err) {
        console.error("API Error:", err);
      }
    };
    fetchData();
  }, [horizon, startTime, endTime]);

  return (
    <div className="container" style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h2>UK Wind Forecast Monitor</h2>
      
      <div style={{ display: 'flex', gap: '20px', marginBottom: '30px', alignItems: 'center' }}>
        <div>
          <label>Start Time: </label><br/>
          <input type="datetime-local" value={startTime} step="1800" onChange={e => setStartTime(e.target.value)} />
        </div>
        <div>
          <label>End Time: </label><br/>
          <input type="datetime-local" value={endTime} step="1800" onChange={e => setEndTime(e.target.value)} />
        </div>
        <div style={{ flex: 1 }}>
          <label>Forecast Horizon: {horizon}h</label><br/>
          <input type="range" min="0" max="48" step="1" value={horizon} onChange={e => setHorizon(e.target.value)} style={{ width: '100%' }} />
        </div>
      </div>

      <div style={{ height: '400px', backgroundColor: '#f9fafb', padding: '20px', borderRadius: '8px' }}>
        <ResponsiveContainer width="100%" height="100%">
          <LineChart data={data}>
            <CartesianGrid strokeDasharray="3 3" vertical={false} />
            <XAxis dataKey="startTime" tickFormatter={(tick) => tick.substring(11, 16)} />
            <YAxis label={{ value: 'Power (MW)', angle: -90, position: 'insideLeft' }} />
            <Tooltip />
            <Legend verticalAlign="top" />
            <Line name="Actual" type="monotone" dataKey="actualGen" stroke="#2563eb" dot={false} strokeWidth={2} />
            <Line name="Forecast" type="monotone" dataKey="forecastGen" stroke="#10b981" dot={false} strokeWidth={2} />
          </LineChart>
        </ResponsiveContainer>
      </div>
    </div>
  );
}

export default App;