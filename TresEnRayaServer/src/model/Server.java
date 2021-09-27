package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private Socket p1;
	private Socket p2;
	private ServerSocket server;
	private Board board;
	
	public Server(int port, Board board) {
		this.board = board;
		try {
			this.server = new ServerSocket(port);
		} catch (IOException e) {
			print(true,"Error creating the ServerSocket");
			e.printStackTrace();
		}
	}
	
	public void accept() {
		try {
			p1=server.accept();
			print(false,"Player 1 conected");
			p2=server.accept();
			print(false,"Player 2 conected");
		} catch (IOException e) {
			print(true,"Error creating the ServerSocket");
			e.printStackTrace();
		}
	}
	
	public void print(Boolean err,String s) {
		if(err)System.err.println(s);
		else System.out.println(s);
	}
	
	public Socket getP1() {return p1;}
	public Socket getP2() {return p2;}
	
	public void sendString(Boolean p,String s) {
		try {
			OutputStream outstream=null;
			if(p) outstream = p1.getOutputStream();
			else outstream = p2.getOutputStream();
			PrintWriter out = new PrintWriter(outstream);
			out.print(s);
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
	public Pair askP1() {
		try {
			BufferedReader in = new BufferedReader( new InputStreamReader(p1.getInputStream()));
			int x =in.read();
			int y = in.read();
			return new Pair(x,y);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Pair askP2() {
		try {
			BufferedReader in = new BufferedReader( new InputStreamReader(p2.getInputStream()));
			int x =in.read();
			int y = in.read();
			return new Pair(x,y);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void sendBoard() {
		try {
			OutputStream outstream1 = p1.getOutputStream();
			OutputStream outstream2 = p1.getOutputStream();
			
			PrintWriter out1 = new PrintWriter(outstream1);
			PrintWriter out2 = new PrintWriter(outstream2);
			
			char[] sb0 = board.getBoard()[0];
			char[] sb1 = board.getBoard()[1];
			char[] sb2 = board.getBoard()[2];
			String sb = String.valueOf(sb0) + String.valueOf(sb1) + String.valueOf(sb2);
			out1.write(sb);
			out2.write(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
