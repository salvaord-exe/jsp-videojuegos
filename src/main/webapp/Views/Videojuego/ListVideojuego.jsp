<%@  include file="../Templates/header.jsp" %> 
<%@ page import="Models.Videojuego" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<main>

	<div class="container">
		<div class="card mt-2">
			<div class="card-header d-flex justify-content-between">
				<h3>Lista de Videojuegos</h3>
				<a href="./CreateVideojuego.jsp" class="btn btn-primary">Agregar Videojuego</a>
			</div>
			<div class="card-body">
				<table class="table table-bordered">
                    <thead>
                        <tr class="table-dark">
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Fabricante</th>
                            <th>Precio</th>
                            <th>Calificacion</th>
                            <th>Acciones</th>
                            
                        </tr>
                    </thead>
                    <%
                    	
                		Videojuego oModel = new Videojuego();	
                    	
                    	ArrayList<Videojuego> lstVids = oModel.Listar();
                    	
                    	for (Videojuego varVid : lstVids){
                    		
                    	
                    %>
                    
                    <tbody>
                        <tr>
                        	<td><%= varVid.getId() %></td>
                        	<td><%= varVid.getNombre() %></td>
                        	<td><%= varVid.getFabricante() %></td>
                        	<td><%= varVid.getCalificacion() %></td>
                        	<td><%= varVid.getPrecio() %></td>
                        	
                        	<td class="d-flex justify-content-around">
                        		<a class="btn btn-warning btn-sm" href="EditVideojuego.jsp?action=edit&id=<%= varVid.getId() %>">Editar</a>
                        		<a class="btn btn-danger btn-sm" href="../../VideojuegoControlador?action=delete&id=<%= varVid.getId() %>"  >Eliminar</a>
                        	</td>                        	
                        </tr>
                    </tbody>
                    <%
                    	}
                    %>
                </table>
			</div>
		</div>	
	</div>
	
</main>
<%@ include file="../Templates/footer.jsp" %>