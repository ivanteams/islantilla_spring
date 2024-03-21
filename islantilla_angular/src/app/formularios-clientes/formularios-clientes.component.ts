// Spring + Angular: Paso3 -> Controlador componente

import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ClientesService } from '../services/clientes.service';


@Component({
  selector: 'app-formularios-clientes',
  templateUrl: './formularios-clientes.component.html',
  styleUrls: ['./formularios-clientes.component.css']
})
export class FormulariosClientesComponent {
  constructor(private clientesService: ClientesService) {}

  // El método puede llamarse como queramos. Por convención on (evento)
  onAddCliente(form: NgForm) {
    if(form.invalid) {
      return;
    }
    this.clientesService.addCliente(form.value).subscribe();

    // Una vez enviado el formulario, lo presento de nuevo vacio
    form.resetForm();
  }
}
