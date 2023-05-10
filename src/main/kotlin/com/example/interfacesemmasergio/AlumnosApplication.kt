package com.example.interfacesemmasergio

import com.example.interfacesemmasergio.routes.RoutesManager
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class AlumnosApplication : Application() {
    override fun start(stage: Stage) {
        RoutesManager.apply {
            app = this@AlumnosApplication
        }
        RoutesManager.initMainStage(stage)
    }
}

fun main() {
    Application.launch(AlumnosApplication::class.java)
}
