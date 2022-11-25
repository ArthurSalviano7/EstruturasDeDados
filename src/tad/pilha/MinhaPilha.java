package tad.pilha;

public class MinhaPilha implements PilhaIF<Integer> {
	
	private int tamanho = 10;
	private Integer[] meusDados;
	private int topo;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
		this.topo = -1;
		this.meusDados = new Integer[tamanho];
	}
	
	public MinhaPilha() {
	}

	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		if (this.topo == tamanho - 1) {
			throw new PilhaCheiaException();
		}
		this.topo++;
		this.meusDados[topo] = item;
	}

	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}
		Integer numTopo = meusDados[topo];
		this.topo--;
		return numTopo;
	}

	@Override
	public Integer topo() {
		return this.meusDados[topo];
	}

	@Override
	public PilhaIF<Integer> multitop(int k) {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public boolean isEmpty() {
		if (this.topo == -1){
			return true;
		}
		else{
			return false;
		}
	}

}
