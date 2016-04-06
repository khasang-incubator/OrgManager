package io.khasang.sapper;

public class Sapper {
	
	public static final int SIZE = 10;
	public static final int VALUE_BOMBS = 1;
	public static final int VALUE_EMPTY = 0;
	public static final int BOMBS_COUNT = 25;
	private int[][] field;
	
	public Sapper() {
		this.field = new int[SIZE][SIZE];
        createField();
    }
    public int[][] getField(){
        return this.field;
    }
    private void createField(){
        int bombsCount = 0;
        while( bombsCount<BOMBS_COUNT){
            int row = (int) (Math.random() * SIZE);
            int col = (int) (Math.random() * SIZE);
        if(this.field[row][col] == VALUE_EMPTY){
                this.field[row][col] = VALUE_BOMBS;
                bombsCount++;
         }
        }
    }
    public static void main(String[] args) {
    }
}
