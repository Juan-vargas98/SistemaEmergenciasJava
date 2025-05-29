public class Despachador extends Thread {
    private final CentralEmergencias central;

    public Despachador() {
        this.central = CentralEmergencias.getInstancia();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Emergencia e = central.obtenerEmergencia();
                if (central.solicitarAmbulancia()) {
                    System.out.println("[Despachador] Ambulancia asignada a: " + e);
                    new Ambulancia(e).start();
                } else {
                    System.out.println("[Despachador] Sin ambulancias disponibles para: " + e);
                    central.agregarEmergencia(e);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}