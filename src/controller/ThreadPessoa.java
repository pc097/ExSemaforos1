package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {
	private static int posChegada;
	private int idPessoa;
	private Semaphore semaforo;

	public ThreadPessoa(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		pessoaAndando();
		try {
			semaforo.acquire();
			abrindoPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void pessoaAndando() {

		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 3) + 4);
		int tempo = 1000;
		int distanciaTotal = 200;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nomePessoa(idPessoa) + " já andou " + distanciaPercorrida + " metros");
		}
		posChegada++;
		System.out.println(nomePessoa(idPessoa) + " foi a " + posChegada + " .a a chegar.");
	}

	private void abrindoPorta() {
		System.out.println(nomePessoa(idPessoa) + " está abrindo a porta.");
		int tempo = (int) ((Math.random() * 2) + 1);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(nomePessoa(idPessoa) + " cruzou a porta.");
	}

	private static String nomePessoa(int idPessoa) {
		switch (idPessoa) {
		case 0:
			return "Maria";
		case 1:
			return "José";
		case 2:
			return "João";
		case 3:
			return "Ana";
		}
		return null;
	}
}
