const host = "http://localhost:8080/";

const service = {
  async getAllPerson() {
    try {
      const response = await fetch(host.concat("usuarios/v1/list"));
      if (!response.ok) {
        console.log("Tenemos una falla en el servicio invocado");
      }
      return await response.json();
    } catch (error) {
      console.log("Este fue un error llamando el servicio listar", error);
      throw error;
    }
  },

  async getByIdPerson(id) {
    try {
      const response = await fetch(host.concat("usuarios/v1/search".concat(id)));
      if (!response.ok) {
        console.log("Tenemos una falla en el servicio invocado");
      }
      return await response.json();
    } catch (error) {
      console.error(
        "Este fue el error llamando el servicio consultar por id",
        error
      );
    }
  },

  async deleteByIdPerson(id) {
    try {
      const response = await fetch(host.concat("usuarios/v1/delete?id=".concat(id)), { method: "DELETE" });
      if (!response.ok) {
        console.log("Tenemos una falla en el servicio invocado");
      }
      return await response.json();
    } catch (error) {
      console.error(
        "Este fue el error llamando el servicio consultar por id",
        error
      );
    }
  },

  async savePerson(data) {
    try {
      const apiSave = host.concat("usuarios/v1/save");
      const response = await fetch(apiSave, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
      });
      
      if (!response.ok) {
        console.log("La llamada al servicio falló con el estado:", response.status);
        return null; // Retorna null o un objeto específico para indicar fallo
      }
  
      try {
        return await response.json();
      } catch (parseError) {
        console.error("Fallo al analizar la respuesta como JSON:", parseError);
        return null; // Maneja o retorna un objeto vacío
      }
    } catch (error) {
      console.error("Error al llamar al servicio de guardado:", error);
    }
  }
  ,

  async callUpdatePerson(data) {
    try {
      const apiSave = host.concat("usuarios/v1/update");
      const response = await fetch(apiSave, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
      });
      if (!response.ok) {
        console.log("Tenemos una falla en el servicio invocado");
      }
      return await response.json();
    } catch (error) {
      console.error(
        "Este fue el error llamando el servicio consultar por id",
        error
      );
    }
  },
  openModalUpdate(id,nombre,apellido,tipo_documento,documento){
    document.getElementById('modalId').textContent = id;
    document.getElementById('modalNombre').value = nombre;
    document.getElementById('modalApellido').value = apellido;
    document.getElementById('modalTipoDocumento').value = tipo_documento;
    document.getElementById('modalDocumento').value = documento;
  
    const modal = new bootstrap.Modal(document.getElementById('dataModal'));
    modal.show();
  },
  updatePerson(){
    personId = document.getElementById('modalId').value;
    personNombre = document.getElementById('modalNombre').value;
    personApellido = document.getElementById('modalApellido').value ;
    personTipoDocumento = document.getElementById('modalTipoDocumento').value;
    personDocumento = document.getElementById('modalDocumento').value;

    const data = {
      "id" : personId,
      "nombre": personNombre,
      "apellido": personApellido,
      "fk_id_tipo_documento": personTipoDocumento,
      "documento": personDocumento
    }
    this.callUpdatePerson(data);
  }
};



document.addEventListener("DOMContentLoaded", function () {
  var dateble = document.querySelector("#dataTableUsuarios tbody");

  async function cargarDatosTabla() {
    try {
      const data = await service.getAllPerson();
      console.log(data);  // Verifica la estructura de los datos
      renderTabla(data);
    } catch (error) {
      console.error("Ha fallado en la carga de los datos en la lista", error);
    }
  }


  function renderTabla(data) {
    try {
      dateble.innerHTML = "";
      data.forEach((person) => {
    
        const fila = document.createElement("tr");
        fila.innerHTML = `
          <th>${person.usuario_id}</th>
          <td>${person.nombre_usuario}</td>
          <td>${person.apellido_usuario}</td>
          <td>${person.tipo_documento.sigla}</td>
          <td>${person.documento}</td>
          <td>
            <div class="btn-group" role="group" aria-label="Basic outlined example">
              <button type="button" class="btn btn-outline-danger" onClick=service.deleteByIdPerson(${person.usuario_id})>Eliminar Usuario</button> 
            </div>
          </td>`;
        dateble.appendChild(fila);
      });
    } catch (error) {
      console.error("renderizando", error);
    }
  }

  cargarDatosTabla();

 

});

document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("registerForm");

  form.addEventListener("submit", async function (event) {
      event.preventDefault();

      // Obtener los valores del formulario
      const data = {
          nombre_usuario: document.getElementById("nombre").value,
          apellido_usuario: document.getElementById("apellido").value,
          documento: document.getElementById("documento").value,
          email: document.getElementById("email").value,
          empresa: document.getElementById("empresa").value,
          password: document.getElementById("password").value,
          telefono: document.getElementById("telefono").value,
          tipo_documento: document.getElementById("tipo_documento").value, // Agregar tipo_documento
      };

      // Llamar al servicio para guardar el usuario
      const response = await service.savePerson(data);
      form.reset()
      if (response) {
          alert("Usuario registrado con éxito");
          form.reset(); // Limpiar el formulario
      } else {
          alert("Usuario registrado con éxito");
      }
  });
});

