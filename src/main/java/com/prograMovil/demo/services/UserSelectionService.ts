// package com.prograMovil.demo.services;

import { Component } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-seleccion-usuario',
  template: `
    <ion-header>
      <ion-toolbar>
        <ion-title>Seleccionar Usuario</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content class="ion-padding">
      <h2>Elige tu rol</h2>
      <ion-list>
        <ion-item button (click)="seleccionarRol('Administrador')">
          <ion-label>Administrador</ion-label>
        </ion-item>
        <ion-item button (click)="seleccionarRol('Empleado')">
          <ion-label>Empleado</ion-label>
        </ion-item>
        <ion-item button (click)="seleccionarRol('Cliente')">
          <ion-label>Cliente</ion-label>
        </ion-item>
      </ion-list>
    </ion-content>
  `,
  styleUrls: ['./SeleccionUsuarioPage.scss'],
})
export class SeleccionUsuarioPage {
  constructor(private navCtrl: NavController) {}

  seleccionarRol(rol: string) {
    console.log(`Rol seleccionado: ${rol}`);
    localStorage.setItem('userRole', rol); // Guarda el rol en localStorage
    this.navCtrl.navigateForward('/home'); // Navega a la página de inicio (ejemplo)
  }
}
