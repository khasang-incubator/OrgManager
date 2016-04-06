package io.khasang.sapper;

import org.junit.Assert;
import org.junit.Test;

public class TestSapper {
	
	@Test
	public void test() {
		Sapper sapper =  new Sapper();
		Assert.assertNotNull(sapper);
		Assert.assertEquals(sapper.getField()[0].length,10);
		Assert.assertEquals(sapper.getField().length,10);
	}



}
