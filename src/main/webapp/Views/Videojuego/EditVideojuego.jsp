<%@ include file="../Templates/header.jsp" %>
<%@ page import="Models.Videojuego" %>
<% String id = request.getParameter("id"); %>
<%
	
	Videojuego oModel = new Videojuego();
	
	Videojuego oVid = oModel.buscarPorId(Integer.parseInt(id));

	
%>



<main>

	<div class="container">	
		<form action="../../VideojuegoControlador?action=update&id=<%= id %>" method="POST">
			<div class="card mt-2">
				<div class="card-header d-flex justify-content-between">
					<h3>Videojuego</h3>
					<div class="">
						<input type="submit" name="crear_videojuego" id="crear_videojuego" class="btn btn-success" value="Guardar">
						<a href="ListVideojuego.jsp?action=list" class="btn btn-danger ">Cancelar</a>
					</div>
					
				</div>
				<div class="card-body">
					
					<div class="row">
						<div class="form-group col-md-6 mt-1">
							<label for="nombre" class="form-label"  >Nombre Videojuego:</label>
							<input type="text" id="nombre" name="nombre" class="form-control" value="<%= oVid.getNombre() %>" required>
						</div>
						<div class="form-group col-md-6 mt-1">
							<label for="fabricante" class= "form-label">Fabricante:</label>
							<select class="form-select" id="fabricante" name="fabricante" required>
							  <option>Seleccione uno</option>
							  <%
							  	String isSelectedRockstarGames = "";
							  	String isSelectedNintendo = "";
							  	String isSelectedActivision = "";
							  	
							  	if(oVid.getFabricante().toString().equals("Rockstar Games")){
							  		isSelectedRockstarGames = "selected";
							  	} else {
							  		isSelectedRockstarGames = "";
							  	}
							  	
							  	if(oVid.getFabricante().toString().equals("Nintendo")){
							  		isSelectedNintendo = "selected";
							  	} else {
							  		isSelectedNintendo = "";
							  	}
							  	
							  	if(oVid.getFabricante().toString().equals("Activision")){
							  		isSelectedActivision = "selected";
							  	} else {
							  		isSelectedActivision = "";
							  	}
							  %>
							  
							  <option value="Rockstar Games" <%= isSelectedRockstarGames %>>Rockstar Games</option>
							  <option value="Nintendo" <%= isSelectedNintendo %>>Nintendo</option>
							  <option value="Activision" <%= isSelectedActivision %>>Activision</option>
							</select>
						</div>
						<div class="form-group col-md-6 mt-1">
							<label for="fecha_lanzamiento" class="form-label">Fecha Lanzamiento:</label>
							<input type="date" id="fecha_lanzamiento" name="fecha_lanzamiento" class="form-control" value="<%= oVid.getFecha_lanzamiento().toString() %>" required>
						</div>
						<div class="form-group col-md-6 mt-1">
							<label for="vd_version" class="form-label">Versi�n:</label>
							<input type="text" id="vd_version" name="vd_version" class="form-control" value="<%= oVid.getVd_version().toString() %>" required>
						</div>
						<div class="form-group col-md-6 mt-1">
							<label for="calificacion" class="form-label">Calificacion:</label>
							<input type="number" id="calificacion" min="0" max="5" step=".01" name="calificacion" class="form-control" value="<%= String.valueOf(oVid.getCalificacion()) %>" required>
						</div>
						<div class="form-group col-md-6 mt-1">
							<label for="calificacion" class="form-label">Precio:</label>
							<input type="number" id="precio" min="0" step=".01" name="precio" class="form-control" value="<%= String.valueOf(oVid.getPrecio()) %>" required>
						</div>
					</div>
				</div>
			</div>
		</form>	
	</div>
</main>
<%@ include file="../Templates/footer.jsp" %>