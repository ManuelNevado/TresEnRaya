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
		boolean end=false;
		//Filas
		for(int i=0;i<3;i++) {
			if(board[i][0]=='X') {
				if(board[i][1]==board[i][2] && board[i][2]=='X')end =true;
			}else if(board[i][0]=='Y') {
				if(board[i][1]==board[i][2] && board[i][2]=='Y')end =true;
			}
		}
		//Columnas
		for(int i=0;i<3;i++) {
			if(board[0][i]=='X') {
				if(board[0][i]==board[2][i] && board[2][i]=='X')end =true;
			}else if(board[0][i]=='Y') {
				if(board[1][i]==board[2][i] && board[2][i]=='Y')end =true;
			}
		}
		//Diagonales
		if(board[0][0]!=' ') {
			if(board[0][0] == board[1][1] && board[0][0] == board[2][2]) end=true;
		}
		if(board[2][0] != ' ') {
			if(board[2][0] == board[1][1] && board[0][3] == board[2][2]) end=true;
		}
		
		return end;
	}
	
	
}
