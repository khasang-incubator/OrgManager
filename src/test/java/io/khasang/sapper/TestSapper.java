package io.khasang.sapper;

import org.junit.Assert;
import org.junit.Test;

public class TestSapper {
	@Test
	public void testSapperInitialization() {
		Sapper sapper =  new Sapper();
		Assert.assertNotNull(sapper);
		int[][] field = sapper.getField();
		Assert.assertEquals(field.length,10);
		Assert.assertEquals(field[0].length,10);
		int bombsCount = 0;
		for (int row = 0; row < field.length; row++) {
			for (int col = 0; col < field.length; col++) {
				int cellValue = field[row][col]; 
				if (cellValue == 1) {
					bombsCount++;
				} else if (cellValue != 0) {
					Assert.fail("Unexpectede cell value: " + cellValue);
				}
			}
		}
		Assert.assertEquals("Invalid bombs count", bombsCount, Sapper.BOMBS_COUNT);
	}

}
