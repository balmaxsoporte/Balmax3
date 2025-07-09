# PatioBalmax - Sistema de Gestión de Estacionamiento

## Descripción
PatioBalmax es una aplicación Android diseñada para gestionar puestos de estacionamiento en diferentes patios. Incluye autenticación de usuarios, base de datos local (Room), carga de registros desde archivos `.txt`, y soporte multiusuario con distintos permisos.

## Características Principales

- **Login de Usuarios**: Pantalla de inicio de sesión con tres usuarios predefinidos.
- **Mapa del Estacionamiento**: Vista general de los patios disponibles.
- **Detalles de Patios**: Visualización de cada puesto con estado actual.
- **Edición de Puestos**: Modificación de tipos de vehículos y patentes.
- **Administración de Usuarios**: Creación, edición y carga de archivos `.txt` para arrendatarios y particulares.
- **Base de Datos Local**: Uso de Room para persistencia local de usuarios, patios y puestos.
- **Compatibilidad con API 34 (Android 14)**

## Usuarios por Defecto

| Usuario     | Contraseña | Permisos                          |
|-------------|------------|-----------------------------------|
| admin       | admin      | Administrador                     |
| user1       | 12345      | Editar Patentes de Patios         |
| user2       | 12345      | Validar Patios y Puestos          |

## Estructura del Proyecto

PatioBalmax/
├── app/
│ ├── build.gradle.kts (Module-level)
│ └── src/
│ └── main/
│ ├── java/
│ │ └── com.example.patiobalmax/
│ │ ├── LoginEstacionamiento.kt
│ │ ├── MapaEstacionamiento.kt
│ │ ├── PatioEstacionamiento.kt
│ │ ├── EditarPatioEstacionamiento.kt
│ │ ├── AdministrarUsuarios.kt
│ │ ├── database/
│ │ ├── adapter/
│ │ ├── model/
│ │ ├── util/
│ │ └── ...
│ └── res/
│ ├── drawable/
│ ├── layout/
│ ├── values/
│ ├── mipmap/
│ └── raw/
└── build.gradle.kts (Project-level)
└── settings.gradle.kts


## Requisitos Técnicos

- **Kotlin DSL**
- **AGP Version:** `8.11.0`
- **Kotlin Version:** `2.0.21`
- **compileSdkVersion:** `34`
- **minSdkVersion:** `34`
- **targetSdkVersion:** `34`
- **Java Compatibility:** Java 11
- **ViewBinding + XML Tradicional**
- **Room Persistence Library**

## Notas Importantes

- Las imágenes deben ser incluidas manualmente en `/res/drawable/`.
- Los archivos `arrendatarios.txt` y `particulares.txt` se almacenan en `/res/raw/` como ejemplos iniciales.
- Para subir nuevos archivos `.txt`, el usuario debe tener privilegios de administrador.
- El historial de archivos subidos tiene un máximo de 5 por tipo.

