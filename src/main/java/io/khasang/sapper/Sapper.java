package io.khasang.sapper;

public class Sapper {
	
	public static final int SIZE = 10;
	
	public static final int BOMBS_COUNT = 25;

	private int[][] field;
	
	public Sapper() {
		this.field = new int[SIZE][SIZE];
	}

    public int[][] getField(){
        return this.field;
    }
    
    public static void main(String[] args) {

    }
}
