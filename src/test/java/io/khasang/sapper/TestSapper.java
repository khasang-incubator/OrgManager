package io.khasang.sapper;

import org.junit.Assert;
import org.junit.Test;

public class TestSapper {
	@Test
	public void testSapperInitialization() {
		Sapper sapper = new Sapper();
		Assert.assertNotNull(sapper);
		int[][] field = sapper.getField();
		Assert.assertEquals(field.length, Sapper.FIELD_SIZE);
		Assert.assertEquals(field[0].length, Sapper.FIELD_SIZE);
		int bombsCount = 0;
		for (int row = 0; row < field.length; row++) {
			for (int col = 0; col < field.length; col++) {
				int cellValue = sapper.getValue(row, col);
				if (cellValue == Sapper.VALUE_BOMB) {
					bombsCount++;
				} else if (cellValue != Sapper.VALUE_EMPTY) {
					Assert.fail("Unexpected cell value: " + cellValue);
				}
			}
		}
		Assert.assertEquals("Invalid bombs count", Sapper.BOMBS_COUNT, bombsCount);
	}
}
