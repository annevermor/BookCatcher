pluginManagement {
    plugins{
        id("com.android.application") version "8.0.2" apply false
        id("com.android.library") version "8.0.2" apply false
        id("org.jetbrains.kotlin.android") version "1.9.20" apply false
        id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false

    }
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Book Catcher"
include(":app")
 