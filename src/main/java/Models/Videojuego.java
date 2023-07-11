package Models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.mariadb.jdbc.Connection;

import Config.ConnectionBD;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(
		  name = "VideojuegoServlet", 
		  urlPatterns = "/videojuego-controller")

public class Videojuego {
	private int id;
	private double precio;
	private String fabricante ;
	private String nombre;
	private LocalDate fecha_lanzamiento;
	private String vd_version;
	private double calificacion;
	private Timestamp fecha_creacion;
	private Timestamp fecha_modificacion;
	private Videojuego oVideojuego;
	
	private ConnectionBD con;
	private Connection c;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Videojuego() {
		this.con = new ConnectionBD();
	}
	
	public ArrayList Listar() {
		ArrayList<Videojuego> lstVideojuegos = new ArrayList<>();
		String sql = "select * from videojuego";
		
		
		
		try {
			this.rs = this.con.execQueryWithResult(sql);
			
			while(rs.next()) {
				Videojuego oVid = new Videojuego();
				oVid.setId(rs.getInt("id"));
				oVid.setNombre(rs.getString("nombre"));
				oVid.setFabricante(rs.getString("fabricante"));
				oVid.setFecha_lanzamiento(convertToLocalDateViaSqlDate(rs.getDate("fecha_lanzamiento")));
				oVid.setVd_version(rs.getString("vd_version"));
				oVid.setPrecio(rs.getDouble("precio"));
				oVid.setCalificacion(rs.getDouble("calificacion"));
				
				lstVideojuegos.add(oVid);
			}
		}catch(Exception e) {
			System.out.println("Error en la conexión:" + e.toString() );
		}
		
		return lstVideojuegos;
	}

	public String Crear (Videojuego oVideojuego) {
		String message;
		
		
		String query = "insert into videojuego (nombre,fabricante,fecha_lanzamiento,vd_version,calificacion,precio)"
				+ " values ("
				+ "'"+oVideojuego.getNombre().toString()+"',"
				+ "'"+oVideojuego.getFabricante().toString()+"',"
				+ "'"+oVideojuego.getFecha_lanzamiento().toString()+"',"
				+ "'"+oVideojuego.getVd_version().toString()+"',"
				+ "'"+String.valueOf(oVideojuego.getCalificacion())+"',"
				+ "'"+String.valueOf(oVideojuego.getPrecio())+"'"
				+ ")";
		
		try {
			
			message = this.con.execQueryWithoutResult(query);
			
		}catch(Exception e) {
			message = e.getMessage();
		}
		
		return message;
	}
	
	public Videojuego buscarPorId(Integer id) {
		String query = "select * from videojuego where id like "+String.valueOf(id)+";";
		Videojuego returnVid = new Videojuego();
		
		try {
			this.rs = this.con.execQueryWithResult(query);
			
			while(rs.next()) {
				Videojuego oVid = new Videojuego();
				oVid.setId(rs.getInt("id"));
				oVid.setNombre(rs.getString("nombre"));
				oVid.setFabricante(rs.getString("fabricante"));
				oVid.setPrecio(rs.getDouble("precio"));;
				oVid.setFecha_lanzamiento(convertToLocalDateViaSqlDate(rs.getDate("fecha_lanzamiento")));
				oVid.setVd_version(rs.getString("vd_version"));
				oVid.setCalificacion(rs.getDouble("calificacion"));
				
				returnVid = oVid;
			}
		}catch(Exception e) {
			System.out.println("Error en la conexión:" + e.toString() );
		}
		
		return returnVid;
	}
	
	public String actualizar(Videojuego oVid) {
		String message;
		
		String query = "update videojuego set "
				+ "nombre = '" + oVid.getNombre().toString() + "', " 
				+ "fabricante = '" + oVid.getFabricante().toString() + "', " 
				+ "precio = '" + String.valueOf(oVid.getPrecio()) + "', " 
				+ "calificacion = '" + String.valueOf(oVid.getCalificacion()) + "', " 
				+ "fecha_lanzamiento = '" + oVid.getFecha_lanzamiento().toString() + "', " 
				+ "vd_version = '" + oVid.getVd_version().toString() + "' "
				+ "where id like '" + oVid.getId() +"';";
				
		try {
			this.con.execQueryWithoutResult(query);
			message = "Elemento actualizado correctamente";
			
		}catch(Exception e) {
			message = e.getMessage();
		}
		
		return message;
	}
	
	public String eliminar(Videojuego oVid) {
		String message = null;
		
		String query = "delete from videojuego where id like " + oVid.getId() + ";";
		
		try {
			this.con.execQueryWithoutResult(query);
			message = "Elemento eliminado correctamente";
		}catch(Exception e) {
			message = e.getMessage();
		}
		
		return message;
	}
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public LocalDate getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}

	public void setFecha_lanzamiento(LocalDate fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	public String getVd_version() {
		return vd_version;
	}

	public void setVd_version(String vd_version) {
		this.vd_version = vd_version;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Timestamp timestamp) {
		this.fecha_creacion = timestamp;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Timestamp fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", precio=" + precio + ", fabricante=" + fabricante + ", nombre=" + nombre
				+ ", fecha_lanzamiento=" + fecha_lanzamiento + ", vd_version=" + vd_version + ", calificacion="
				+ calificacion + "]";
	}

	
	
}
