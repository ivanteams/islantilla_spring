
// Spring Boot 3.2 + Angular v17: Paso 3 -> Servicio

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Clientes } from '../models/clientes.model';
import { environment } from '../../environments/environment.development';


@Injectable({
  providedIn: 'root'
})

export class ClientesService {

  private baseURL = `${environment.apiURL}/clientes`;

  constructor(private http: HttpClient) { }

  // Agregar clientes
  // @PostMapping("/insertar/{nif}/{nombre}/{edad}/{sexo}")
  // Observable<Clientes> -> 1 solo cliente
  insertarCliente(cliente: Clientes): Observable<Clientes> {
    // Ojo al endpoint: -> ${objeto.atributo}
    const url = 
      `${this.baseURL}/insertar/${cliente.nif}/${cliente.nombre}/${cliente.edad}/${cliente.sexo}`;
    return this.http.post<Clientes>(url, {});     // {} -> para body, por ahora vacio
  }

  // Ver clientes
  // @GetMapping("/consultar")
  // Observable<Clientes[]> -> Array de clientes
  consultarclientes(): Observable<Clientes[]> {
    const url = `${this.baseURL}/consultar`;
    return this.http.get<Clientes[]>(url)         // Aquí no hay body
  }
}










