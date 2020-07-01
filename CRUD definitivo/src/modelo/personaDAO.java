package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class personaDAO {
	PreparedStatement ps;
	ResultSet rs;
	conexion c = new conexion();
	Connection con;
	
	public List<persona> listar() {
		List<persona>lista = new ArrayList<>();
		String sql = "select * from persona";
		try {
			con = c.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				persona p = new persona();
				p.setId(rs.getString(1));
				p.setNombre(rs.getString(2));
				lista.add(p);
			}
			
		} catch (Exception e) {
		}
		return lista;
	}
	
	public int agregar(persona p) {
		int r=0;
		String query = "insert into persona (ID, NOMBRE) values (?,?)";
		try {
			con = c.conectar();
			ps = con.prepareStatement(query);
			ps.setString(1, p.getId());
			ps.setString(2, p.getNombre());
			r=ps.executeUpdate();
			if(r==1) {
				r=1;
			} else {
				r=0;
			}
		} catch (Exception e) {
		}
		return r;
	}
	
	public persona listarId(String id) {
		String sql = "select * from persona where id="+id;
		persona p = new persona();
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				p.setId(rs.getString(1));
				p.setNombre(rs.getString(2));
			}
 		} catch (Exception e) {
		}
		return p;
	}
	
	public int actualizar (persona p) {
		int r=0;
		String sql = "update persona set nombre=? where id=?";
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getId());
			r=ps.executeUpdate();
			if(r==1) {
				r=1;
			} else {
				r=0;
			}
			
		} catch (Exception e) {
		}
		return r;
	}
	
	public void eliminar (String id) {
		String sql = "delete from persona where id="+id;
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
		}
		
		
	}
	
}