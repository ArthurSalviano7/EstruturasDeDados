package tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 * @author fabioleite
 *
 */
public class MinhaFila implements FilaIF<Integer> {
	
	private int tamanho = 10;
	
	private int cauda = -1;
	private int cabeca = 0;
	private int qntNum = 0;
	
	private Integer[] meusDados;

	public MinhaFila(int tamanhoInicial) {
		tamanho = tamanhoInicial;
		meusDados = new Integer[tamanho];
	}
	
	public MinhaFila() {
	}

	@Override
	public void enfileirar(Integer item) throws FilaCheiaException{
		if(isFull()){
			throw new FilaCheiaException();
		}
		
		if(cauda == tamanho - 1){
			cauda = 0;
		}else{
			cauda++;
		}
		qntNum++;
		meusDados[cauda] = item;
	}

	@Override
	public Integer desenfileirar() throws FilaVaziaException{
		Integer num = null;
		if(isEmpty()){
			throw new FilaVaziaException();
		}
		if(cabeca == tamanho - 1){
			cabeca = 0;
		}else{
			cabeca++;
		}
		num = meusDados[cabeca];
		qntNum--;
		return num;
	}

	@Override
	public Integer verificarCauda() {
		if(qntNum == 0){
			throw new UnsupportedOperationException("Fila vazia");
		}
		else{
			return meusDados[cauda];
		}
	}

	@Override
	public Integer verificarCabeca() {
		if(qntNum == 0){
			throw new UnsupportedOperationException("Fila vazia");
		}else{
			return meusDados[cabeca];
		}
	}

	@Override
	public boolean isEmpty() {
		return qntNum == 0;
	}

	@Override
	public boolean isFull() {
		return qntNum == tamanho;
	}

}
