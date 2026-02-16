# Repositorio Comisión 06

# Super Mario Bros - TDP Comisión 06 🍄

Un clon del clásico juego **Super Mario Bros** desarrollado en **Java** como proyecto final para la materia **Taller de Programación (TDP)** en la **Universidad Nacional del Sur (UNS)**.

## 📋 Descripción
Este proyecto es una implementación integral del icónico juego de plataformas, desarrollado bajo una arquitectura robusta orientada a objetos utilizando **Java Swing**. El software incluye múltiples niveles, enemigos con inteligencia artificial simple, power-ups y una característica distintiva de tematización dinámica (Modo Original y Modo Barbie).

## ⚙️ Metodología de Desarrollo
El proyecto se llevó a cabo siguiendo una metodología de **Sprints semanales**, reflejando un proceso de ingeniería riguroso:
* **Entregas Semanales:** Cada sprint requería un incremento de software funcional.
* **Documentación Evolutiva:** Con cada avance se entregaba un **diagrama UML** (clases o secuencia) nuevo que documentaba la evolución de la arquitectura.
* **Trabajo Colaborativo:** Desarrollado por un equipo de 5 estudiantes de Ingeniería en Sistemas.

## 🏗️ Arquitectura y Patrones de Diseño
El diseño se centró en la extensibilidad y el bajo acoplamiento mediante la aplicación de diversos patrones:

1. **MVC (Model-View-Controller):** Separación total de la lógica de negocio (Entidades y Estados) de la interfaz gráfica en Swing.
2. **State Pattern:** Manejo dinámico de los estados de Mario (Normal, Super, Fire, Star) y de enemigos como el Koopa Troopa (Normal y Caparazón).
3. **Abstract Factory (Factory Method):** Implementado mediante la clase `ModoDeJuego` para intercambiar skins (Original vs Barbie) sin alterar la lógica de las entidades.
4. **Observer:** Sincronización en tiempo real para actualizar la interfaz gráfica (`ObserverGrafico`) cuando cambian las propiedades lógicas de las entidades.
5. **Double Dispatch:** Gestión de colisiones elegante mediante las interfaces `AfectadorAMario` y `AfectablePorMario`, evitando estructuras condicionales complejas.
6. **Singleton:** Punto único de acceso para `EntidadSonora`, garantizando una gestión eficiente de los recursos de audio.

## 🎮 Características
* **3 Niveles Jugables:** Cargados dinámicamente mediante un parser de archivos de texto (`.txt`).
* **Dual Mode:** Soporte para sprites clásicos y una versión personalizada con temática de Barbie.
* **Enemigos Variados:** Goomba, Koopa Troopa, Buzzy Beetle, Piranha Plant, Lakitu y Spiny.
* **Sistema de Ranking:** Persistencia de puntajes máximos utilizando archivos **JSON** a través de la librería GSON.

## 🚀 Instalación y Ejecución
**Requisitos:** Java 17 o superior y Maven.

```bash
# 1. Clonar el repositorio
git clone [https://github.com/Gonzalo-Ferraro/MarioBros-TDP.git](https://github.com/Gonzalo-Ferraro/MarioBros-TDP.git)

# 2. Compilar el proyecto con Maven
mvn clean package

# 3. Ejecutar el JAR generado
java -jar target/CodigoFuente-1.0-jar-with-dependencies.jar
```
🎯 Controles
Flechas Izquierda/Derecha: Movimiento.

Flecha Arriba / Espacio: Saltar.

Z: Lanzar bolas de fuego (en estado Mario Flor).

🛠️ Tecnologías Utilizadas
Lenguaje: Java 17

GUI: Java Swing

Build Tool: Maven

Persistencia: GSON (JSON)

👥 Autores
Proyecto desarrollado por la Comisión 06 - Taller de Programación (UNS)

## Sprites Mario:
* https://www.spriters-resource.com/nes/supermariobros/
