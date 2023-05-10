package com.example.interfacesemmasergio.controllers

import com.example.interfacesemmasergio.data.state.AlumnoState
import com.example.interfacesemmasergio.routes.RoutesManager
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class AcercaDeController {
    @FXML
    private lateinit var labelNombre: Label

    @FXML
    private lateinit var labelEdad: Label

    @FXML
    private lateinit var labelEmail: Label

    @FXML
    private lateinit var imageViewAboubakar: ImageView

    @FXML
    private fun initialize() {
        labelNombre.text = AlumnoState.nombre
        labelEdad.text = AlumnoState.edad
        labelEmail.text = AlumnoState.email
        imageViewAboubakar.setImage(Image(RoutesManager.app::class.java.getResource("images/aboubakar.jpg").toExternalForm()))
    }
}
