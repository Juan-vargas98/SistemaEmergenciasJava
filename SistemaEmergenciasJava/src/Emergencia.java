public class Emergencia implements Comparable<Emergencia> {
    private static int count = 0;
    private final int id;
    private final String ubicacion;
    private final String gravedad;
    private final long tiempoLlegada;

    public Emergencia(String ubicacion, String gravedad) {
        this.id = ++count;
        this.ubicacion = ubicacion;
        this.gravedad = gravedad;
        this.tiempoLlegada = System.currentTimeMillis();
    }

    public int getPrioridad() {
        return switch (gravedad.toLowerCase()) {
            case "critico" -> 1;
            case "grave" -> 2;
            case "moderado" -> 3;
            case "leve" -> 4;
            default -> 5;
        };
    }

    @Override
    public int compareTo(Emergencia otra) {
        int p1 = this.getPrioridad();
        int p2 = otra.getPrioridad();
        if (p1 != p2) return Integer.compare(p1, p2);
        return Long.compare(this.tiempoLlegada, otra.tiempoLlegada);
    }

    @Override
    public String toString() {
        return "Emergencia [ID=" + id + ", Gravedad=" + gravedad + ", Ubicacion=" + ubicacion + "]";
    }
}