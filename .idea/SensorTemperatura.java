import java.util.concurrent.ThreadLocalRandom;

class SensorTemperatura extends Sensor {
    public SensorTemperatura() {
        super("Temperatura", "°C", 400, 5, 18.0, 30.0);
    }
    @Override
    public double medir() {
        // Genera entre 15.0 y 35.0
        return ThreadLocalRandom.current().nextDouble(15.0, 35.0);
    }
}

class SensorHumedad extends Sensor {
    public SensorHumedad() {
        super("Humedad", "%", 600, 5, 50.0, 80.0);
    }
    @Override
    public double medir() {
        // Genera entre 40.0 y 90.0
        return ThreadLocalRandom.current().nextDouble(40.0, 90.0);
    }
}

class SensorLuz extends Sensor {
    public SensorLuz() {
        super("Luz", "lux", 500, 5, 200.0, 900.0);
    }
    @Override
    public double medir() {
        // Genera entre 0 y 1000
        return ThreadLocalRandom.current().nextDouble(0.0, 1000.0);
    }
}