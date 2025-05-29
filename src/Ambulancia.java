public class Ambulancia extends Thread {
    private final Emergencia emergencia;

    public Ambulancia(Emergencia emergencia) {
        this.emergencia = emergencia;
    }

    @Override
    public void run() {
        try {
            System.out.println("[Ambulancia] En camino a: " + emergencia);
            Thread.sleep(4000);
            System.out.println("[Ambulancia] Emergencia atendida: " + emergencia);
            CentralEmergencias.getInstancia().liberarAmbulancia();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}