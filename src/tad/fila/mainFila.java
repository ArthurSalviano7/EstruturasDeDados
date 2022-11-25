package tad.fila;

public class mainFila {
    
    public static void main(String[] args) throws FilaCheiaException, FilaVaziaException {
        
        MinhaFila fila = new MinhaFila(5);

        fila.enfileirar(4);
        fila.desenfileirar();
        fila.enfileirar(3);
        fila.enfileirar(5);
        fila.enfileirar(-1);
        fila.enfileirar(2);

        System.out.println(fila.verificarCabeca());
        System.out.println(fila.verificarCauda());
        System.out.println(fila.isFull());
        
    }
}
