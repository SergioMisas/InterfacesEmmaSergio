package com.example.interfacesemmasergio.repositories

import com.example.interfacesemmasergio.models.Alumno
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

object AlumnosRepository {
    private val _memory = mutableListOf<Alumno>()
    private val memory get() = _memory.toList()

    fun add(alumno: Alumno): Alumno {
        logger.debug { "add: $alumno" }
        _memory.add(alumno)
        return alumno
    }
}
