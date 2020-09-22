package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Corredor {

	public static void main(String[] args) {

		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		for (int idPessoa = 0; idPessoa < 4; idPessoa++) {
			Thread tPessoa = new ThreadPessoa(idPessoa, semaforo);
			tPessoa.start();
		}
	}

}
