public class GestionTransferencias implements Runnable{
    private Banco banco;
    private int cuentaOrigen;
    private double cantidadMax;
    
    public GestionTransferencias(Banco b, int o, double max){
        banco = b;
        cuentaOrigen = o;
        cantidadMax = max;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                int cuentaDestino = (int) (100 * Math.random());
                double cantidad = cantidadMax * Math.random();
                banco.Tranferencia(cuentaOrigen, cuentaDestino, cantidad);
                Thread.sleep(400);
            }
        } 
        catch (InterruptedException ex) {}
    }
}
