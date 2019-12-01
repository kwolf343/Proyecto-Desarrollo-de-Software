<div class="formularioultimo">
<form action="/Proyecto_Desarrollo_de_Software/Registro" method="post">
        <div class="divisor"><div class="col-4">Nombre de usuario:</div><div class="col-8"><input type="text" name="usuario" placeholder="Nombre de usuario" required></div></div>
        <div class="divisor"><div class="col-4">Nombre:</div><div class="col-8"><input type="text" name="nombre" placeholder="Nombre" required></div></div>
        <div class="divisor"><div class="col-4">Apellido:</div><div class="col-8"><input type="text" name="apellido" placeholder="Apellido"required ></div></div>
        <div class="divisor"><div class="col-4">Targeta:</div><div class="col-8"><input type="text" name="targeta" placeholder="Targeta"required ></div></div>
        <div class="divisor"><div class="col-4">Correo electronico:</div><div class="col-8"><input type="email" name="correo"  placeholder="Correo electronico" required ></div></div>
        <div class="divisor"><div class="col-4">Contraseña:</div><div class="col-8"><input type="password" name="contra" placeholder="Contraseña" required></div> </div>
        <br><br>
        <div class="divisor2">
             <label for="doc">Pais:</label>
            <select name="pais" required>
                <option value="1">El Salvador</option>
                <option value="2">Nicaragua</option>
                <option value="3">Costa Rica</option>
                <option value="4">Guatemala</option>
                <option value="5">Panama</option>
                <option value="6">Honduras</option>
                <option value="7">Belice</option>
            </select>
        </div>
        <br>
    <div class="formulariop2">
        <input type="checkbox" id="check" name="check" required>
        <label for="check">Aceptar los terminso y condiciones</label>
    </div>
        <br>
    <div class="botones">
        <ul>
            <input class="boton" type="submit" value="Registrarme">
        </ul>
    </div>
</form>
    <div class="cancelar">
        <br>
        <a href="Usuario?accion=cancelar">Cancelar</a>
    </div>
</div>