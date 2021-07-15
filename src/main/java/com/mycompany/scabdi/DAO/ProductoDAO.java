/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scabdi.DAO;

import com.mycompany.scabdi.model.Producto;
import java.util.List;
import java.util.Map;


public interface ProductoDAO{
    List<Map<String, Object>> findproducto();
    int createproducto(Producto producto);
    int updateproducto(Producto producto);
    int deleteproducto(int id_producto);
    Producto readproducto(int id_producto);
}
