package com.example.interfacesemmasergio.controllers

import com.example.interfacesemmasergio.data.state.AlumnoState
import com.example.interfacesemmasergio.models.Alumno
import com.example.interfacesemmasergio.repositories.AlumnosRepository
import com.example.interfacesemmasergio.routes.RoutesManager
import com.example.interfacesemmasergio.validators.validate
import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.TextField
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class MainController {
    @FXML
    private lateinit var textFieldNombre: TextField

    @FXML
    private lateinit var textFieldEdad: TextField

    @FXML
    private lateinit var textFieldEmail: TextField

    @FXML
    private lateinit var buttonAcercaDe: Button

    @FXML
    private lateinit var buttonGuardar: Button

    @FXML
    private lateinit var buttonLimpiar: Button

    @FXML
    private fun onGuardarButtonClick() {
        logger.debug { "Click guardar" }
        Alumno(
            textFieldNombre.text.toString(),
            textFieldEdad.text.toString().toIntOrNull() ?: 0,
            textFieldEmail.text.toString()
        ).validate()
            .onSuccess { alumno ->
                AlumnosRepository.add(alumno)
                val alert = Alert(Alert.AlertType.INFORMATION)
                alert.title = "Alumno guardado"
                alert.headerText = "Alumno guardado"
                alert.contentText = "Alumno guardado con éxito"
                alert.showAndWait()
            }
            .onFailure { error ->
                val alert = Alert(Alert.AlertType.ERROR)
                alert.title = "Alumno no guardado"
                alert.headerText = "Error al guardar el alumno"
                alert.contentText = error.message
                alert.showAndWait()
            }
    }

    @FXML
    private fun onLimpiarButtonClick() {
        logger.debug { "Click limpiar" }
        textFieldNombre.text = ""
        textFieldEdad.text = ""
        textFieldEmail.text = ""
    }

    @FXML
    private fun onAcercaDeButtonClick() {
        logger.debug { "Click acerca de" }
        AlumnoState.nombre = textFieldNombre.text
        AlumnoState.edad = textFieldEdad.text
        AlumnoState.email = textFieldEmail.text
        RoutesManager.initAcercaDeStage()
    }


}
