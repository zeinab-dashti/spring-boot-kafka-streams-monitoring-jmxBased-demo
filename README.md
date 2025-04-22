# Kafka Streams Monitoring with Spring Boot, JMX, Prometheus & Grafana

This project demonstrates a Kafka Streams application built with Spring Boot, exposing JMX-based metrics using Prometheus JMX Exporter, and visualizing them in Grafana.

---

## Features

- Kafka Streams topology that reads from an input topic, processes data, and writes to an output topic.
- JMX-based metrics exported via Prometheus JMX Exporter.
- Docker Compose setup for Kafka, Zookeeper, Prometheus, Grafana, and the app.
- Auto topic creation and mock data publishing
- Prometheus scraping via JMX Exporter at `/metrics`
- Grafana dashboards for observability

---

## Tech Stack

- Spring Boot 3.2
- Kafka Streams
- Apache Kafka (via Confluent Platform)
- JMX Exporter
- Prometheus
- Grafana
- Docker & Docker Compose

---

## Getting Started

### Prerequisites

- Docker & Docker Compose
- Java 21
- Maven

---

### Run the project

Build and start everything using Docker Compose:

```bash
docker-compose up --build
```

No need to run mvn clean package manually — it is executed as part of the Dockerfile during image build.

This will spin up:
- Kafka + Zookeeper
- Kafka Streams app 
- Prometheus (scraping metrics from the app)
- Grafana (viewing metrics dashboards)


## Endpoints

| Endpoint URL                        | Description                                       |
|-------------------------------------|---------------------------------------------------|
| `http://localhost:9404/metrics`     | Exposes application metrics in Prometheus format  |
| `http://localhost:9090/`            | Prometheus Web UI                                 |
| `http://localhost:3000/`            | Grafana Web UI (login: `admin` / `admin`)         |


## Producing & Consuming Data
On startup, the app:
- Creates input-topic and output-topic
- Sends 10 test messages to input-topic
- Processes them via Kafka Streams
- Writes to output-topic
- Logs consumed results from output-topic
