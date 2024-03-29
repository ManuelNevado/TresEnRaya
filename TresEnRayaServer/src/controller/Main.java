package controller;

import model.*;

public class Main {
	public static void main(String args[]) {
		//char[][] c = {{'a','s','w'},{'a','s','a'},{'s','g','t'}};
		//System.out.println(String.valueOf(c[0]));
		System.out.println("Server app started");
		Board board = new Board();
		Server server = new Server(555,board);
		server.accept();
		//Se queda parado hasta que acepta a los dos
		while(!board.end()) {
			server.alive(true);
			//Movimiento jugador 1
			Pair c1 = server.askP1();
			if(board.numberOfX()==3) {
				server.sendDelete("p1",true);
				Pair d1 = server.askP1();
				board.delete(d1);
			}else server.sendDelete("p1",false);
			board.placeX(c1);
			server.sendBoard(); //Enviamos el tablero
			
			//Movimiento jugador 2
			if(!board.end()) {
				Pair c2 = server.askP2();
				if(board.numberOfY()==3) {
					server.sendDelete("p2",true);
					Pair d1 = server.askP2();
					board.delete(d1);
				}else server.sendDelete("p2",false);
				board.placeY(c2);
				server.sendBoard(); //Emviamos el tablero
			}
			server.alive(false);
			
		}
	}
}
