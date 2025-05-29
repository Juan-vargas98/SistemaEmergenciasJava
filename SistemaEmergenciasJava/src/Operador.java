public class Operador extends Thread {
    private final CentralEmergencias central;
    private final String[] ubicaciones = {"Centro", "Norte", "Sur", "Este", "Oeste"};
    private final String[] niveles = {"critico", "grave", "moderado", "leve"};

    public Operador() {
        this.central = CentralEmergencias.getInstancia();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String ubi = ubicaciones[(int) (Math.random() * ubicaciones.length)];
                String niv = niveles[(int) (Math.random() * niveles.length)];
                Emergencia e = new Emergencia(ubi, niv);
                central.agregarEmergencia(e);
                Thread.sleep(1500);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}