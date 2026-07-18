# GameFit

Aplicación Android para la gestión y validación de campañas promocionales mediante escaneo de códigos QR. Permite a los operadores validar premios, consultar estadísticas en tiempo real e inventario de productos.

## Capturas de pantalla

| Login | Dashboard | Scanner | Validación |
|-------|-----------|---------|------------|
| Pantalla de acceso con credenciales de empresa | Panel con métricas de campaña | Lector QR con controles de cámara | Confirmación de premio entregado |

## Tecnologías

- **Lenguaje:** Kotlin
- **UI:** Jetpack Compose + Material 3
- **Navegación:** Navigation Compose
- **Min SDK:** 26 (Android 8.0)
- **Target SDK:** 37
- **Build System:** Gradle con Version Catalog (`libs.versions.toml`)

## Requisitos previos

- Android Studio Meerkat (2024.3.1) o superior
- JDK 11
- Android SDK 37

## Instalación

```bash
git clone https://github.com/NicolasCarrillo/gamefit.git
cd gamefit
```

Abrir el proyecto en Android Studio y esperar a que finalice el Gradle sync.

## Estructura del proyecto

```
app/
└── src/main/
    ├── java/com/biosecure/gamefit/
    │   ├── MainActivity.kt          # Entry point y NavHost
    │   └── ui/
    │       ├── screens/
    │       │   ├── LoginScreen.kt
    │       │   ├── DashboardScreen.kt
    │       │   ├── ScannerScreen.kt
    │       │   ├── SuccessScreen.kt
    │       │   └── SettingsScreen.kt
    │       └── theme/
    │           ├── Color.kt
    │           ├── Theme.kt
    │           └── Type.kt
    └── res/
        ├── drawable/
        └── values/
```

## Flujo de navegación

```
Login → Dashboard → Scanner → SuccessScreen
                 ↘ Settings
```

## Construcción

### Debug

```bash
./gradlew assembleDebug
```

### Release

```bash
./gradlew assembleRelease
```

El APK generado se encuentra en `app/build/outputs/apk/`.

## Ejecutar pruebas

```bash
# Unit tests
./gradlew test

# Instrumented tests (requiere dispositivo o emulador)
./gradlew connectedAndroidTest
```

## Licencia

Proyecto privado — BioSecure © 2026
