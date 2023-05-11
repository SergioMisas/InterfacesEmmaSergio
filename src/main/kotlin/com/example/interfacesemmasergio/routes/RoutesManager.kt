package com.example.interfacesemmasergio.routes

import com.example.interfacesemmasergio.AlumnosApplication
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Modality
import javafx.stage.Stage
import java.io.InputStream
import java.net.URL

object RoutesManager {
    private lateinit var mainStage: Stage
    private lateinit var _activeStage: Stage
    val activeStage get() = _activeStage
    lateinit var app: Application

    enum class Vistas(val ruta: String) {
        MAIN("views/main-view.fxml"),
        ACERCA_DE("views/acerca-de-view.fxml")
    }

    fun initMainStage(stage: Stage) {
        val fxmlLoader = FXMLLoader(AlumnosApplication::class.java.getResource(Vistas.MAIN.ruta))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Aplicación Alumnos"
        stage.icons.add(Image(this.getResourceAsStream("images/iesluisvives.png")))
        stage.scene = scene
        stage.isResizable = false

        mainStage = stage
        _activeStage = stage
        mainStage.show()
    }

    fun initAcercaDeStage() {
        val fxmlLoader = FXMLLoader(AlumnosApplication::class.java.getResource(Vistas.ACERCA_DE.ruta))
        val scene = Scene(fxmlLoader.load(), 320.0, 350.0)
        val stage = Stage()
        stage.initModality(Modality.APPLICATION_MODAL)
        stage.title = "Acerca de"
        stage.icons.add(Image(this.getResourceAsStream("images/iesluisvives.png")))
        stage.scene = scene
        stage.isResizable = false

        _activeStage = stage
        activeStage.show()
    }

    fun getResource(resource: String): URL {
        return app::class.java.getResource(resource)
            ?: throw RuntimeException("No se ha encontrado el recurso: $resource")
    }

    fun getResourceAsStream(resource: String): InputStream {
        return app::class.java.getResourceAsStream(resource)
           ?: throw RuntimeException("No se ha encontrado el recurso: $resource")
    }
}
