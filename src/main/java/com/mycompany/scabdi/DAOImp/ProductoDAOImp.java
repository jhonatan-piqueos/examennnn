/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scabdi.DAOImp;

import com.mycompany.scabdi.model.Producto;
import com.mycompanyscabdi.config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mycompany.scabdi.DAO.ProductoDAO;

/**
 *
 * @author Christian
 */

public class ProductoDAOImp implements ProductoDAO{
private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
   
    
   

    @Override
    public List<Map<String, Object>> findproducto() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String SQL = "select p.nombre,p.precio,p.stock ,p.id_categoria,c.nombre as categoria from producto p, categoria c where p.id_categoria = c.id_categoria";
		try {
			cx = conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery(SQL);
			while (rs.next()) {
                                Map<String, Object> map = new HashMap<>();
                                map.put("id_producto",rs.getInt("id_producto"));
                                map.put("nombre",rs.getString("nombre"));
                                map.put("precio",rs.getInt("precio"));
                                map.put("stock",rs.getInt("stock"));
                                map.put("id_categoria",rs.getInt("id_categoria"));
                                map.put("categoria",rs.getInt("categoria"));
                                lista.add(map);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
                return lista;
    }

    @Override
    public int createproducto(Producto product) {
        int x = 0;
       String SQL = "insert into producto(NOMBRE, PRECIO,STOCK, ID_CATEGORIA) values(?,?,?,?)";
        try {
       cx = conexion.getConexion();
       ps = cx.prepareStatement(SQL);
       ps.setString(1, product.getNombre());
       ps.setInt(2, product.getPrecio());
       ps.setInt(3, product.getStock());
       ps.setInt(4, product.getId_categoria());
        x = ps.executeUpdate();
        } catch (Exception e) {
            
        }
        return x;
    }

    @Override
    public int updateproducto(Producto product) {
        int x = 0;
       String SQL = "update PRODUCTO set NOMBRE = ?,set PRECIO = ?,set STOCK = ?, set ID_CATEGORIA = ? where ID_PRODUCTO = ?;";
        try {
       cx = conexion.getConexion();
       ps = cx.prepareStatement(SQL);
       ps.setString(1, product.getNombre());
       ps.setInt(2, product.getPrecio());
       ps.setInt(3, product.getStock());
       ps.setInt(4, product.getId_categoria());
        x = ps.executeUpdate();
        } catch (Exception e) {
            
        }
        return x;
    }

    @Override
    public int deleteproducto(int id_producto) {
        int x = 0;
       String SQL = "delete from producto where ID_producto = ?;";
        try {
       cx = conexion.getConexion();
       ps = cx.prepareStatement(SQL);
       ps.setInt(1,id_producto);
        x = ps.executeUpdate();
        } catch (Exception e) {
            
        }
        return x;
    }

    @Override
    public Producto readproducto(int id_producto) {
        Producto cp = new Producto();
        String SQL = "select * from Producto where id_producto = ?;";
        try {
             cx = conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id_producto);
			rs = ps.executeQuery();
			while (rs.next()) {
                                cp.setId_producto(rs.getInt("ID_producto"));
				cp.setNombre(rs.getString("Nombre"));
				cp.setPrecio(rs.getInt("Precio"));
                                cp.setStock(rs.getInt("Stock"));
                                cp.setStock(rs.getInt("id_categoria"));
			}
        } catch (Exception e) {
        }
        return cp;
    }
}
