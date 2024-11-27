pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    versionCatalogs {
        create("buildsrcLibs") {
            from(files("../gradle/buildsrc.libs.versions.toml"))
        }
    }
}
