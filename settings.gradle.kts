pluginManagement {
    repositories {
        maven("https://inexus.samentic.com/repository/samentic-android/") {
            credentials {
                username = "saeid-yousefi"
                password = "Saeid1373##"
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://inexus.samentic.com/repository/samentic-android/") {
            credentials {
                username = "saeid-yousefi"
                password = "Saeid1373##"
            }
        }
    }
}
rootProject.name = "Mocka"
include(":app")
include(":mocha")
