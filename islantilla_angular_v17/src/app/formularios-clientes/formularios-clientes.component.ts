
// Spring Boot 3.2 + Angular v17: Paso 4 -> Controlador del componente

import { Component, OnInit } from '@angular/core';
import { Clientes } from '../models/clientes.model';
import { ClientesService } from '../services/clientes.service';

@Component({
  selector: 'app-formularios-clientes',
  // standalone: false,
  templateUrl: './formularios-clientes.component.html',
  styleUrl: './formularios-clientes.component.css'
})

export class FormulariosClientesComponent implements OnInit{

  constructor(private servicioClientes: ClientesService) {}

  clientes: Clientes[] = []
  mensaje = ""

  // Cargamos los clientes de la BBDD usando el endpoint de Spring Boot
  cargarClientes(): void {
    this.servicioClientes.consultarclientes().subscribe(datos => {
      this.clientes = datos;
    })
  }

  // Al arrancar la aplicación se cargan los clientes en el array
  ngOnInit(): void {
      this.cargarClientes();
  }

  // Para el evento onSubmit (envío de formulario)
  // @PostMapping("/insertar/{nif}/{nombre}/{edad}/{sexo}")
  onSubmit(): void {
    let nuevoCliente: Clientes = {
      nif: '',
      nombre: '',
      edad: 0,
      sexo: 0
    }
    

    this.servicioClientes.insertarCliente(nuevoCliente).subscribe(resultado => {
      if(resultado) {
        this.mensaje = "Cliente Insertado";
      }
    });
  }
}
