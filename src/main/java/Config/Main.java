package Config;



import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import Models.Videojuego;

public class Main {

	public static void main(String[] args) {
		
		Videojuego oModel = new Videojuego();
		
		System.out.println(oModel.buscarPorId(5));
		
		
		
	}
	
	

}
