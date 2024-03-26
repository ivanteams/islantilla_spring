// Spring Boot 3.2 + Angular v17: Paso 6 -> Controlador del módulo

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormulariosClientesComponent } from './formularios-clientes/formularios-clientes.component';

// Hay que añadir importaciones adicionales
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    FormulariosClientesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,   // <- Importamos HttpClient
    FormsModule         // <- Importamos Forms
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
