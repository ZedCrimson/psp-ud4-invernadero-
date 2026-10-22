import java.util.concurrent.ThreadLocalRandom;

public abstract class Sensor implements Runnable {
    protected final String nombre;
    protected final String unidad;
    protected final int periodoMS;
    protected final int numLecturas;
    protected final double minUmbral;
    protected final double maxUmbral;

    protected int lecturasRealizadas = 0;
    protected int alertas = 0;
    protected double sumaValores = 0.0;
    protected double minValor = Double.MAX_VALUE;
    protected double maxValor = Double.MIN_VALUE;

    public Sensor(String nombre, String unidad, int periodoMs, int numLecturas, double minUmbral, double maxUmbral) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.periodoMs = periodoMs;
        this.numLecturas = numLecturas;
        this.minUmbral = minUmbral;
        this.maxUmbral = maxUmbral;

}

public abstract douable medir();

@Override
public void run(){
    for (int i =1; i<= numLecturas;i++) {
        String hiloActual = Thread.currentThread().getName();
        double valor = medir();

        lecturasRealizadas++;
        sumaValores +=valor;
        if (valor < minValor) minValor = valor;
        if (valor > maxValor) maxValor = valor;

        boolean fueraDeRango = ( valor < minUmbral || valor > maxUmbral);
        if (fueraDeRango){
            alertas++
        }

        System.out.printf("[%s] %s -> Lectura %d/%d: %.2f %s %s%n",
                hiloActual, nombre, i, numLecturas, valor, unidad,
                (fueraDeRango ? "¡ALERTA!" : ""));

        try {
            Thread.sleep(periodoMS)
        }catch (InterruptedException e){
            System.out.println(hiloActual + " interrumpido.");
            break;
        }
    }

}

public String informe() {
    double media = (lecturasRealizadas > 0) ? (sumaValores / lecturasRealizadas) : 0.0;
    return String.format ("Sensor: %s |Lecturas: %d | Media: %.2f %s | Min: %.2f | Max: %.2f | Alertas: %d",
            nombre, lecturasRealizadas,media,unidad,
            (minValor == Double.MAX_VALUE ? 0 : minValor),
            (maxValor == Double.MIN_VALUE ? 0 : maxValor), alertas;
}

}