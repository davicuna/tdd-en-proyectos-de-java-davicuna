package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRepositorio {

	private Repositorio repo;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {}

    @AfterAll
    static void tearDownAfterClass() throws Exception {}

    @BeforeEach
    void setUp() throws Exception {
        
        repo = new Repositorio();
    }

    @AfterEach
    void tearDown() throws Exception {}

    @Test
    void testMarcarComoCompletado() {
        
        ToDo t = new ToDo("Repo Test", null);
        repo.guardarNuevo(t);
        
        repo.marcarCompletado("Repo Test");
        
        assertTrue(repo.buscarPorNombre("Repo Test").isCompletado());
    }

}
