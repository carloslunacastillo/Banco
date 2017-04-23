public class Banco {
    private final double[] cuenta;
    
    public Banco(){
        cuenta = new double[100];
        for(int x = 0; x < cuenta.length; x++){
            cuenta[x] = 2000;
        }
    }
    
    public synchronized void Tranferencia(int origen, int destino, double cantidad) {
       try {
            while (cuenta[origen] < cantidad) {
                wait();
            }
            System.out.println(Thread.currentThread());
            cuenta[origen] -= cantidad;
            System.out.printf("%10.2f de %d para %d", cantidad, origen, destino);
            System.out.println();
            cuenta[destino] += cantidad;
            System.out.printf("Saldo Total: $ %10.2f%n", getSaldoTotal());
            System.out.println();
            notifyAll();
        }
        catch (InterruptedException ex) {}
    }
    
    public double getSaldoTotal(){
        double total = 0;
        for(double a: cuenta){
            total += a;
        }
        return total;
    }
}