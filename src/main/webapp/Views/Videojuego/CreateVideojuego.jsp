<%@ include file="../Templates/header.jsp" %>
<main>

	<div class="container">	
		<form action="../../VideojuegoControlador?action=create" method="POST">
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
							<label for="nombre" class="form-label">Nombre Videojuego:</label>
							<input type="text" id="nombre" name="nombre" class="form-control" required>
						</div>
						<div class="form-group col-md-6 mt-1">
							<label for="fabricante" class= "form-label">Fabricante:</label>
							<select class="form-select" id="fabricante" name="fabricante" required>
							  <option selected>Seleccione uno</option>
							  <option value="Rockstar Games">Rockstar Games</option>
							  <option value="Nintendo">Nintendo</option>
							  <option value="Activision">Activision</option>
							</select>
						</div>
						<div class="form-group col-md-6 mt-1">
							<label for="fecha_lanzamiento" class="form-label">Fecha Lanzamiento:</label>
							<input type="date" id="fecha_lanzamiento" name="fecha_lanzamiento" class="form-control" required>
						</div>
						<div class="form-group col-md-6 mt-1">
							<label for="vd_version" class="form-label">Versión:</label>
							<input type="text" id="vd_version" name="vd_version" class="form-control" required>
						</div>
						<div class="form-group col-md-6 mt-1">
							<label for="calificacion" class="form-label">Calificacion:</label>
							<input type="number" id="calificacion" min="0" max="5" step=".01" name="calificacion" class="form-control" required>
						</div>
						<div class="form-group col-md-6 mt-1">
							<label for="calificacion" class="form-label">Precio:</label>
							<input type="number" id="precio" min="0"  step=".01" name="precio" class="form-control" required>
						</div>
					</div>
				</div>
			</div>
		</form>	
	</div>
</main>
<%@ include file="../Templates/footer.jsp" %>