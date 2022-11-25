package tad.listasEncadeadas;

import tad.util.Conversor;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T>{
	
//	NodoListaEncadeada<T> cabeca = null;
	
	NodoListaEncadeada<T> cabeca = null; // Estratégia usando marcação sentinela
	NodoListaEncadeada<T> cauda = null;// Estratégia usando marcação sentinela
	
	public ListaEncadeadaImpl() {// Estratégia usando marcação sentinela
		cabeca = new NodoListaEncadeada<T>();
		cauda = new NodoListaEncadeada<T>();
		cabeca.setProximo(cauda);
	}
	

	@Override
	public boolean isEmpty() {
		return cabeca == null;
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public NodoListaEncadeada<T> search(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public void insert(T chave) {
		
		//1. Criar o novo registro
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);
		
		//2. Inserir o novo nó na lista
		
		// se a lista estiver vazia**
		if (cabeca.getProximo().equals(cauda)) {
			cabeca = novoNo;
		} else { // lista não está vazia
			novoNo.setProximo(cabeca.getProximo());
			cabeca.setProximo(novoNo);
		}
		
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) throws ListaVaziaException {

		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);

		// se a lista estiver vazia**
		if (cabeca.getProximo().equals(cauda)) {
			throw new ListaVaziaException();
		}else{
			novoNo = novoNo.getProximo();
			return novoNo;
		}		
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		Conversor<T> c = new Conversor<T>();
		T[] meuArray = c.gerarArray(clazz, 10);
		
		return meuArray;
	}

	@Override
	public String imprimeEmOrdem() {
//		throw new UnsupportedOperationException("Precisa implementar!");
		String valores = "";
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		
		while (!corrente.equals(cauda)) {
			valores += corrente.getChave() + ", ";
		}
		
		return valores.substring(0, valores.length()-2);
		
	}

	@Override
	public String imprimeInverso() {
//		throw new UnsupportedOperationException("Precisa implementar!");
		
		String valores = "";
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		NodoListaEncadeada<T> anterior = cabeca;
		
		while (!corrente.equals(cauda)) {
			valores += corrente.getChave() + ", ";
		}
		
		
		return valores.substring(0, valores.length()-2);
		
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public void insert(T chave, int index) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

}
