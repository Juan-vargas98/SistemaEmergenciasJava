import java.util.concurrent.*;

public class CentralEmergencias {
    private static CentralEmergencias instancia;
    private final PriorityBlockingQueue<Emergencia> colaEmergencias;
    private final Semaphore ambulanciasDisponibles;

    private CentralEmergencias(int totalAmbulancias) {
        colaEmergencias = new PriorityBlockingQueue<>();
        ambulanciasDisponibles = new Semaphore(totalAmbulancias);
    }

    public static synchronized CentralEmergencias getInstancia() {
        if (instancia == null) instancia = new CentralEmergencias(5);
        return instancia;
    }

    public void agregarEmergencia(Emergencia e) {
        colaEmergencias.offer(e);
        System.out.println("[Central] Nueva emergencia registrada: " + e);
    }

    public Emergencia obtenerEmergencia() throws InterruptedException {
        return colaEmergencias.take();
    }

    public boolean solicitarAmbulancia() throws InterruptedException {
        return ambulanciasDisponibles.tryAcquire(3, TimeUnit.SECONDS);
    }

    public void liberarAmbulancia() {
        ambulanciasDisponibles.release();
    }
}