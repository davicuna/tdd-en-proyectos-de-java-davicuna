package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDBStub {
	private DBStub db;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		db=new DBStub();
	}

	@AfterEach
	void tearDown() throws Exception {}

	@Test
	void test() {
		
        ToDo tarea = new ToDo("Tarea DB", null);
        
        db.insertarTarea(tarea);
        
        assertEquals(1, db.obtenerTodas().size());
	}

}
