const express = require('express');
const app = express();
const port = process.env.PORT || 50005;

let metrics = [];

app.use(express.json());

// Endpoint to collect a metric
app.post('/metrics', (req, res) => {
  const metric = req.body;
  metrics.push({ ...metric, timestamp: new Date() });
  res.status(201).json({ message: 'Metric received' });
});

// Endpoint to get all metrics
app.get('/metrics', (req, res) => {
  res.json(metrics);
});

// Health check
app.get('/', (req, res) => {
  res.send('Metrics service is running');
});

app.listen(port, () => {
  console.log(`Metrics service listening on port ${port}`);
});
