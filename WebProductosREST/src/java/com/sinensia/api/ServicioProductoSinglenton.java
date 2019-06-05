/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.api;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ServicioProductoSinglenton {

    private ArrayList<Producto> listaProductos;

    public void insertar(Producto p) {
        listaProductos.add(p);
    }

    public Producto modificar(Producto p) {
        p.setNombre(p.getNombre() + " - Modificado");
        p.setPrecio(p.getPrecio() + " - Modificado");
        return p;
    }

    public ArrayList<Producto> obtenerTodos() {
        return listaProductos;
    }

    private static ServicioProductoSinglenton instancia;

    //Nadie puede hacer new excepto dentro de esta clase y puede ser protected
    private ServicioProductoSinglenton() {
        this.listaProductos = new ArrayList<>();
    }

    //La primera vez que se llama al método, se crea la instancia a partir de ese momento hasta que la aplicación
    //termine, la instancia seguirá "viva" y es devuelta por el método, venga de donde venga la llamada
    public static ServicioProductoSinglenton getInstancia() {
        if (instancia == null) {
            instancia = new ServicioProductoSinglenton();
        }
        return instancia;
    }

    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
    }

}
