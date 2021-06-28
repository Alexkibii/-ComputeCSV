package com.csv.app;



import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test; 

class ComputeCsvApplicationTest {
	
	  private Path workingDir;

	    @Before
	    public void init() {
	        this.workingDir = Path.of("", "src/test/java/resources");
	    }

	    @Test
	    public void read() throws IOException {
	        Path file = this.workingDir.resolve("data.csv");
	        String content = Files.readString(file);
	        assertThat(content, is("duke"));
	    }

	@Test
	void testRead() {
		fail("Not yet implemented");
	}

	@Test
	void testWriteFile() {
		fail("Not yet implemented");
	}

}
