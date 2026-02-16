# Super Mario Bros - TDP Comisión 06

Un clon del clásico juego Super Mario Bros desarrollado en Java como proyecto para la materia Taller de Programación (TDP).

## 📋 Descripción

Este proyecto es una implementación del icónico juego de plataformas Super Mario Bros, desarrollado utilizando Java Swing para la interfaz gráfica. El juego incluye múltiples niveles, enemigos, power-ups y dos modos de juego diferentes.

## 🎮 Características

- **3 niveles jugables** con diseño basado en archivos de texto
- **2 modos de juego**: Modo Original y Modo Barbie (con sprites personalizados)
- **Enemigos clásicos**: Goomba, Koopa Troopa, Buzzy Beetle, Piranha Plant, Lakitu y Spiny
- **Sistema de ranking** persistente en JSON
- **Efectos de sonido** y música de fondo

### Power-Ups

| Power-Up | Efecto |
|----------|--------|
| **Super Champiñón** | Transforma a Mario en Super Mario |
| **Flor de Fuego** | Permite lanzar bolas de fuego |
| **Estrella** | Otorga invulnerabilidad temporal |
| **Champiñón Verde** | Otorga una vida extra |
| **Monedas** | Otorga 5 puntos al puntaje |

## 🏗️ Arquitectura y Patrones de Diseño

### 1. **Patrón MVC (Model-View-Controller)**
El proyecto está estructurado siguiendo una arquitectura MVC:
- **Model (Logica/)**: Contiene las entidades del juego, estados y lógica de negocio
- **View (Vistas/)**: Maneja toda la interfaz gráfica con Swing
- **Controller**: `ControladorVistas` actúa como intermediario entre la lógica y las vistas

### 2. **Patrón Observer**
Implementado para actualizar la interfaz gráfica cuando cambia el estado de las entidades:
- `Observer`: Interfaz que define los métodos de actualización
- `ObserverGrafico`: Clase abstracta que extiende JLabel e implementa Observer
- Las entidades notifican a sus observers cuando cambian de posición o sprite

### 3. **Patrón State**
Utilizado para manejar los diferentes estados de Mario:
- `EstadoMario`: Clase abstracta base para los estados
- Estados implementados: Mario Normal, Super Mario, Mario Flor de Fuego, Mario Invulnerable (Estrella)
- Permite cambiar el comportamiento de Mario según su estado actual (saltar, recibir daño, lanzar bolas de fuego)

También aplicado para Koopa Troopa:
- `EstadoKoopaTroopa`: Maneja los estados normal y caparazón del enemigo

### 4. **Patrón Factory Method (Abstract Factory)**
Implementado mediante `ModoDeJuego` para crear entidades según el modo seleccionado:
- `ModoOriginal`: Crea entidades con sprites clásicos de Mario Bros
- `ModoBarbie`: Crea entidades con sprites alternativos temáticos
- Cada fábrica define la ruta de sprites y crea todas las entidades del juego (personaje, enemigos, plataformas, power-ups)

### 5. **Patrón Singleton**
Utilizado para gestionar recursos compartidos:
- `EntidadSonora`: Gestiona todos los efectos de sonido y música del juego, garantizando una única instancia

### 6. **Patrón Double Dispatch (Visitor simplificado)**
Implementado para manejar las colisiones entre entidades:
- Interfaces `AfectadorAMario` y `AfectablePorMario`
- Métodos `serAfectadoPor()` y `afectarAMario()` permiten que las entidades interactúen sin conocer tipos concretos

## 📁 Estructura del Proyecto

```
src/main/java/
├── Datos/
│   ├── EntidadSonora.java      # Singleton para manejo de audio
│   ├── GeneradorDeNiveles.java # Parser de archivos de nivel
│   ├── Ranking/                # Sistema de puntuaciones
│   ├── font/                   # Fuentes personalizadas
│   ├── niveles/                # Archivos .txt de diseño de niveles
│   ├── sonidos/                # Archivos de audio
│   └── sprites/                # Imágenes del juego
├── Logica/
│   ├── Entidades/              # Todas las entidades del juego
│   ├── EstadosMario/           # Estados del personaje (State Pattern)
│   ├── Fabricas/               # Fábricas de entidades (Factory Pattern)
│   ├── Juego/                  # Lógica principal del juego
│   └── Launcher/               # Punto de entrada
└── Vistas/
    ├── ControladorVistas.java  # Controlador principal
    ├── PantallaJuego.java      # Vista del juego
    ├── PantallaMenu.java       # Menú principal
    ├── Observer.java           # Interfaz Observer
    └── ...                     # Otras pantallas
```

## 🚀 Cómo Ejecutar

### Requisitos
- Java 17 o superior
- Maven

### Compilación y Ejecución

```bash
# Compilar el proyecto
mvn clean package

# Ejecutar el juego
java -jar target/CodigoFuente-1.0-jar-with-dependencies.jar
```

O directamente con Maven:

```bash
mvn exec:java
```

## 🎯 Controles

| Tecla | Acción |
|-------|--------|
| ← → | Mover a Mario |
| ↑ | Saltar |
| space | Lanzar bola de fuego (requiere Flor de Fuego) |

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Java Swing** para la interfaz gráfica
- **Maven** para gestión de dependencias y build
- **Gson** para persistencia del ranking en JSON

## 👥 Autores

Desarrollado por Comisión 06 - Taller de Programación
