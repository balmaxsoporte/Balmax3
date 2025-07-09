# Notas Importantes para el Desarrollo de "PatioBalmax"

## Archivos e Imágenes Necesarias

Debes incluir las siguientes imágenes en la carpeta `/res/drawable/`:

- `estacionamiento_balmax.png`  
  *Imagen superior en pantalla de Login.*
  
- `estacionamiento_mapa.png`  
  *Imagen central del mapa del estacionamiento en la pantalla principal.*

- `icono_auto.png`  
  *Icono para vehículos tipo Auto, Camioneta o Van.*

- `icono_camion.png`  
  *Icono para vehículos tipo Camión o Maquinaria Pesada.*

- `icono_ticket.png`  
  *Icono para validar un puesto como ocupado.*

- `icono_edit.png`  
  *Icono para editar un puesto o usuario.*

- `icono_launcher.png`  
  *Icono principal de la aplicación.*

- `icono_perfil.png`  
  *Icono usado en la administración de usuarios.*

## Configuraciones Clave

- Asegúrate de que la aplicación esté configurada con:
  - Minimum SDK: API 34 (Android 14)
  - AGP: `8.11.0`
  - Kotlin: `2.0.21`
  - JDK: Java 11

## Base de Datos

- La base de datos local utiliza **Room**.
- Se genera automáticamente con datos iniciales (cada patio con 10 puestos).
- Los primeros 3 puestos de cada patio vienen precargados con datos de `arrendatarios.txt`.
- Los siguientes 3 puestos vienen precargados con datos de `particulares.txt`.

## Usuarios Predefinidos

- `admin/admin` - Permiso: Administrador
- `user1/12345` - Permiso: Editar Patentes de Patios
- `user2/12345` - Permiso: Validar Patios y Puestos

## Historial de Archivos Subidos

- Máximo de 5 archivos guardados por tipo (`arrendatarios.txt` y `particulares.txt`)
- Si se excede el límite, se elimina el más antiguo.
- Solo los usuarios con permisos de administrador pueden cargar nuevos archivos.

## Recomendaciones

- Usa ViewBinding para evitar errores de findViewById.
