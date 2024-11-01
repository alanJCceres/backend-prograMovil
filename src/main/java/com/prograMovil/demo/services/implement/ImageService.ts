// package com.prograMovil.demo.services;

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  // Subir la imagen
  uploadImage(imageData: File): Promise<string> {
    return new Promise((resolve, reject) => {
      // Simula el proceso de subida de imagen
      setTimeout(() => {
        console.log('Imagen subida:', imageData.name);
        resolve('URL_de_la_imagen_subida'); // URL simulada de la imagen subida
      }, 1000);
    });
  }

  // Mostrar la imagen (puedes pasar una URL o base64)
  getImage(url: string): string {
    // Simula la URL de la imagen a mostrar
    return url || 'assets/img/default-image.png';
  }
}
