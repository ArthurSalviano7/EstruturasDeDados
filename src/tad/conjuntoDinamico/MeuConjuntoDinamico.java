package tad.conjuntoDinamico;

import java.util.Arrays;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{

	private Integer[] meusDados = new Integer[4];
	private int posInsercao = 0;
	private int taxaAumento = 25;
	
	@Override
	public void inserir(Integer item) {
		try{
			meusDados[posInsercao] = item;
			posInsercao++;
		}catch(ArrayIndexOutOfBoundsException ex){
			meusDados = aumentarArray();
			meusDados[posInsercao] = item;
			posInsercao++;
		}		
	}
	
	private Integer[] aumentarArray() {
		int tamanho = meusDados.length + (meusDados.length*taxaAumento/100);
		Integer[] novoArray = new Integer[tamanho];

		for(int i = 0; i < meusDados.length; i++){
			novoArray[i] = meusDados[i];
		}
		return novoArray;
	}

	public void mostrarArray() {
		for(Integer x : meusDados){
			System.out.println(x);
		}
	}

	@Override
	public Integer remover(Integer item) {
		Integer removido = null;
		if(posInsercao == 0){
			throw new UnsupportedOperationException("Conjunto Vazio");
		}else{
			for(int i = 0; i < posInsercao; i++){
				if (meusDados[i] == item){
					removido = meusDados[i];
					meusDados[i] = null;
					break;
				}
		}
		}
		
		return removido;
	}

	@Override
	public Integer predecessor(Integer item) {
		Integer predecessor = null;
		Boolean achou = false;
		if(posInsercao == 0){
			throw new UnsupportedOperationException("Conjunto Vazio");
		}

		for(int i = 0; i < posInsercao; i++){
			if(meusDados[i] == item){
				achou = true;
				break;
			}
		}

		if(achou){
			int getIndex = Arrays.asList(meusDados).indexOf(item);
			predecessor = meusDados[getIndex - 1];
		}
		else{
			throw new UnsupportedOperationException(item + " não está no conjunto");
		}

		return predecessor;
	}

	@Override
	public Integer sucessor(Integer item) {
		Integer sucessor = null;
		Boolean achou = false;
		
		if(posInsercao == 0){
			throw new UnsupportedOperationException("Conjunto Vazio");
		}

		for(int i = 0; i < posInsercao; i++){
			if(meusDados[i] == item){
				achou = true;
				break;
			}
		}

		if(achou){
			int getIndex = Arrays.asList(meusDados).indexOf(item);
			
			if(meusDados[getIndex+1] == null){
			throw new UnsupportedOperationException("Não possui sucessor");
			}
			sucessor = meusDados[getIndex + 1];
		}
		else{
			throw new UnsupportedOperationException(item + " não está no conjunto");
		}

		return sucessor;
	}

	@Override
	public int tamanho() {
		return meusDados.length;
	}

	@Override
	public Integer buscar(Integer item) {
		for(int i = 0; i < posInsercao; i++){
			if (meusDados[i] == item){
				return meusDados[i];
			}
		}
		throw new UnsupportedOperationException("Não Encontrado");
	}

	@Override
	public Integer minimum() {
		Integer menor;

		if(posInsercao == 0){
			throw new UnsupportedOperationException("Conjunto Vazio");
		}else{
			menor = meusDados[0];
			for(Integer x : meusDados){
				if(x != null){
					if(x < menor){
						menor = x;
					}
				}
				
			}	
		}
		
		return menor;
	}

	@Override
	public Integer maximum() {
		Integer maior;

		if(posInsercao == 0){
			throw new UnsupportedOperationException("ConjuntoVazio");
		}else{
			maior = meusDados[0];
			for(Integer x : meusDados){
				if(x != null){
					if(x > maior){
						maior = x;
					}
				}
				
			}	
		}
		return maior;
	}

}
