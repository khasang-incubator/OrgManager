package io.khasang.sapper;

import org.junit.Assert;
import org.junit.Test;

public class TestSapper {

	@Test
	public void testSapperGameInitialization() {
		final int SIZE = 20;
		SapperGame game = new SapperGame(SIZE);
		MineField field = game.getMineField();
		Assert.assertNotNull(field);
		Assert.assertEquals(field.getSize(), SIZE);
		int bombsCount = 0;
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				int cellValue = field.getCellValue(row, col);
				if (cellValue == MineField.VALUE_BOMB) {
					bombsCount++;
				} else if (cellValue != MineField.VALUE_EMPTY) {
					Assert.fail("Unexpected cell value: " + cellValue);
				}
			}
		}
		Assert.assertEquals("Invalid bombs count", MineField.BOMBS_COUNT, bombsCount);
	}
}
