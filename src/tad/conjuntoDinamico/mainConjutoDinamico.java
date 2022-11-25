package tad.conjuntoDinamico;

public class mainConjutoDinamico {
    
    public static void main(String[] args) {
        
        MeuConjuntoDinamico conjunto = new MeuConjuntoDinamico();
        conjunto.inserir(5);
        conjunto.inserir(4);
        conjunto.inserir(7);
        conjunto.inserir(8);
        conjunto.inserir(1);
        conjunto.inserir(6);
        conjunto.inserir(6);
        conjunto.inserir(8);
        conjunto.inserir(6);
        conjunto.inserir(6);
        conjunto.inserir(6);
        conjunto.inserir(6);
        conjunto.inserir(3);

        conjunto.buscar(9);

        conjunto.mostrarArray();

        
    }
}
