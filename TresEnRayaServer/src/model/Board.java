package model;

import java.io.IOException;

public class Board {
	
	private char board[][];
	
	public Board() {
		board = new char[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]=' ';
			}
		}
	}
	
	public char[][] getBoard() {
		return board;
	}
	public void placeX(Pair c) {
		if(board[c.first][c.second] ==' ') board[c.first][c.second]='X';
	}
	public void placeY(Pair c) {
		if(board[c.first][c.second] ==' ') board[c.first][c.second]='Y';
	}
	public void delete(Pair c) {
		board[c.first][c.second]=' ';
	}

	public int numberOfX() {
		int count=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]=='X')count++;
			}
		}
		return count;
	}

	public int numberOfY() {
		int count=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]=='X')count++;
			}
		}
		return count;
	}

	public boolean end() {
		//Filas
		for(int i=0;i<3;i++) {
			
		}
		//Columnas
		for(int i=0;i<3;i++) {
			
		}
		//Diagonales
		for(int i=0;i<3;i++) {
			
		}
		return false;
	}
	
}
