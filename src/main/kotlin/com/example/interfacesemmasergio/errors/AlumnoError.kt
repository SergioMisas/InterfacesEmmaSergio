package com.example.interfacesemmasergio.errors

sealed class AlumnoError(val message: String) {
    class InvalidName(message: String) : AlumnoError("ERROR: Nombre inválido: $message")
    class InvalidEdad(message: String) : AlumnoError("ERROR: Edad inválida: $message")
    class InvalidEmail(message: String) : AlumnoError("ERROR: Email inválido: $message")
}
