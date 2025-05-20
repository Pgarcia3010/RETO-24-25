package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import Modelo.Cliente;
import Modelo.Empleados;
import Modelo.Producto;

class tests {

	@Test
    public void testCliente() {
        Cliente cliente = new Cliente("juan123", "abc123", "001", "Juan", "Calle Falsa 123", "654321987");

        assertEquals("Juan", cliente.getNombre());
        assertEquals("Calle Falsa 123", cliente.getDireccion());
        assertEquals("654321987", cliente.getTelefono());
        assertEquals("juan123", cliente.getNickname());
        assertEquals("abc123", cliente.getContrasenya());
        assertEquals("001", cliente.getId());
    }
	
    @Test
    public void testProducto() {
        Producto producto = new Producto("P001", "Camiseta", 19.99, 50);

        assertEquals("P001", producto.getIdProducto());
        assertEquals("Camiseta", producto.getNombreProducto());
        assertEquals(19.99, producto.getPrecio(), 0.001);
        assertEquals(50, producto.getStock());
    }
    
    @Test
    public void testToString() {
        Empleados emp = new Empleados("ana02", "clave456", "E002");
        String resultado = emp.toString();

        assertTrue(resultado.contains("ana02"));
        assertTrue(resultado.contains("clave456"));
        assertTrue(resultado.contains("E002"));
    }
}
