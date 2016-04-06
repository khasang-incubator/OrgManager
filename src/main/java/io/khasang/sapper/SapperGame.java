package io.khasang.sapper;

public class SapperGame {
	public int size;
	public SapperGame(int size) {
		this.size=size;
	}

	MineField getMineField() {
		return new MineField(size);
	}
	
	public void start() {
       this.getMineField();
	}

	public static void main(String[] args) {
		new SapperGame(10).start();
	}
}
