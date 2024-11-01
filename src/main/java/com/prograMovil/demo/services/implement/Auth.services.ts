package com.prograMovil.demo.services.implement;

import java.util.HashMap;

@Service
public class AuthService {

    private static final String TOKEN_KEY = "auth_token";
    private HashMap<String, String> storage;

    public AuthService() {
        this.storage = new HashMap<>();
    }

    // Guardar el token en el almacenamiento simulado
    public void saveToken(String token) {
        storage.put(TOKEN_KEY, token);
    }

    // Obtener el token desde el almacenamiento simulado
    public String getToken() {
        return storage.get(TOKEN_KEY);
    }

    // Eliminar el token del almacenamiento simulado
    public void removeToken() {
        storage.remove(TOKEN_KEY);
    }
  }
  
