package com.bmuschko.gradle.docker

import org.ajoberstar.grgit.gradle.GrgitPlugin
import org.ajoberstar.reckon.core.Scope
import org.ajoberstar.reckon.gradle.ReckonExtension
import org.ajoberstar.reckon.gradle.ReckonPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class ReleasePlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = project.run {
        applyReckonPlugin()
        configureReleasePluginExtension()
    }

    private
    fun Project.applyReckonPlugin() {
        apply<ReckonPlugin>()
        apply<GrgitPlugin>()
    }

    private
    fun Project.configureReleasePluginExtension() {
        configure<ReckonExtension> {
            setDefaultInferredScope(Scope.MAJOR)
            snapshots()
            tagMessage.set("Version ${project.version}")
        }
    }
}
