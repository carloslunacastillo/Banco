public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        for(int x = 0; x < 100; x++){
            GestionTransferencias run = new GestionTransferencias(banco, x, 2000);
            Thread hilo = new Thread(run);
            hilo.start();
        }
    }
}
