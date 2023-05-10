package com.example.interfacesemmasergio.validators

import com.example.interfacesemmasergio.errors.AlumnoError
import com.example.interfacesemmasergio.models.Alumno
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Alumno.validate(): Result<Alumno, AlumnoError> {
    logger.debug { "Validating $this" }
    if (nombre.isEmpty()) return Err(AlumnoError.InvalidName("El nombre no puede estar vacío"))
    if (edad !in 1..120) return Err(AlumnoError.InvalidEdad("La edad debe ser un número válido (entero entre 1 y 120)"))
    if (email.isEmpty()) return Err(AlumnoError.InvalidEmail("El email no puede estar vacío"))
    if (!email.matches("""^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}${'$'}""".toRegex()))
        return Err(AlumnoError.InvalidEmail("La forma del email no es correcta"))
    return Ok(this)
}
