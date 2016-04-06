package io.khasang.sapper;

public class MineField {
	public int FIELD_SIZE;
	public static final int BOMBS_COUNT = 25;
	public static final int VALUE_BOMB = 1;
	public static final int VALUE_EMPTY = 0;
	
	private int[][] field;

	public MineField(int size) {
		this.FIELD_SIZE=size;
		this.field = new int[FIELD_SIZE][FIELD_SIZE];
		createRandomField();
	}

	int getSize() {
		return FIELD_SIZE;
	}

	/**
	 * Sets new field. Only for testing purpose
	 * @param field
	 */
	void setField(int[][] field) {
		this.field = field;
	}

	public int getCellValue(int row, int col) {
		return this.field[row][col];
	}

	private void createRandomField() {
		int bombsCount = 0;
		while (bombsCount < BOMBS_COUNT) {
			int row = (int) (Math.random() * FIELD_SIZE);
			int col = (int) (Math.random() * FIELD_SIZE);
			if (this.field[row][col] == VALUE_EMPTY) {
				this.field[row][col] = VALUE_BOMB;
				bombsCount++;
			}
		}
	}
}
