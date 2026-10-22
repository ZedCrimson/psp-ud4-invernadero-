public class ProgramadorRiego extends Thread {
    private int ciclosRealizados = 0;
    private double litrosTotales = 0.0;
    private final int totalCiclos = 5;

    public ProgramadorRiego() {
        super("riego"); // Nombre obligatorio del hilo según pauta
    }

    @Override
    public void run() {
        boolean abierto = false;
        for (int i = 1; i <= totalCiclos; i++) {
            abierto = !abierto; // Alterna entre abre y cierra
            ciclosRealizados++;
            if (abierto) {
                litrosTotales += 2.5;
                System.out.printf("[%s] Ciclo %d -> Válvula ABIERTA (Agregados 2.5L. Total: %.1fL)%n",
                        getName(), i, litrosTotales);
            } else {
                System.out.printf("[%s] Ciclo %d -> Válvula CERRADA%n", getName(), i);
            }

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrumpido.");
                break;
            }
        }
    }

    public String informe() {
        return String.format("Programador Riego | Ciclos: %d | Litros totales dispensados: %.1f L",
                ciclosRealizados, litrosTotales);
    }
}