public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Emergencias Iniciado ===");
        new Operador().start();
        new Despachador().start();
    }
}