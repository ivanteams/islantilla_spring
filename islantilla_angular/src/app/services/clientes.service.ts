// Spring + Angular: Paso2 -> Servicio

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Clientes } from '../models/clientes.model';


@Injectable({
  providedIn: 'root'
})

export class ClientesService {

  // Todos tendrán el mismo inicio de endpoint
  private baseURL = 'http://localhost:8100/clientes';

  constructor(private http: HttpClient) { }

  // Método para agregar clientes
  addCliente(cliente: Clientes) {
    const url = `${this.baseURL}/insertar/${cliente.nif}/${cliente.nombre}/${cliente.edad}/${cliente.sexo}`;
    return this.http.post(url, {});
  }
}
