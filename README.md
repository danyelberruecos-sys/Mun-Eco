# MunEco

> Sistema de gestión de residuos, campañas ambientales y eco-puntos para la Universidad EIA (proyecto **EcoCampus Circular**).

![Java](https://img.shields.io/badge/Java-26-orange)
![JavaFX](https://img.shields.io/badge/JavaFX-21-blue)
![Maven](https://img.shields.io/badge/Maven-3.x-red)
![JUnit](https://img.shields.io/badge/JUnit-5-green)

## Descripción

MunEco es una aplicación de escritorio con interfaz gráfica, desarrollada en **Java** y **JavaFX**, que permite a la universidad gestionar los residuos del campus y motivar la participación ambiental de la comunidad mediante **eco-puntos**.

Con la aplicación se puede registrar a las personas que participan (usuarios, operadores y responsables), administrar los puntos ecológicos del campus, planear rutas de recolección, atender los reportes de la comunidad, registrar lo recolectado y organizar campañas ambientales con sus actividades e inscripciones.

Los eco-puntos se ganan de dos formas: al **cerrar un reporte** que tiene una recolección asociada (según el tipo de material y su peso), y al **participar en una campaña** cuando esta se cierra.

### Módulos

| Módulo | Qué permite |
|---|---|
| **Personas** | Registrar usuarios, operadores y responsables, y consultar el listado |
| **Puntos ecológicos** | Registrar puntos con los materiales que admiten, consultarlos e inactivarlos |
| **Rutas** | Crear rutas de recolección con sus paradas, consultarlas y cerrarlas |
| **Reportes** | Registrar reportes sobre un punto, asignarlos a un operador o a una ruta, y cerrarlos |
| **Recolección** | Registrar lo recolectado (material y peso) asociado a un reporte |
| **Campañas ambientales** | Crear campañas, agregar actividades, inscribir participantes y cerrarlas |
| **Eco-puntos y consultas** | Historial por persona, ranking, materiales recolectados y movimientos manuales |
| **Indicadores generales** | Panel con las cifras del sistema |
| **Notificaciones** | Registro de los avisos que genera el sistema, con un contador en la barra superior |

## Tecnologías

- **Java 26**
- **JavaFX 21** con pantallas en **FXML** (diseñadas con Scene Builder) y estilos en **CSS**
- **Maven** para las dependencias y la ejecución
- **JUnit 5** para las pruebas unitarias

## Requisitos

| Requisito | Detalle |
|---|---|
| **JDK 26** | Debe estar instalado y configurado en Eclipse |
| **Eclipse IDE** | Versión *for Java Developers*, que ya incluye Maven (m2e) |
| **Git** | Opcional: solo para clonar el repositorio |
| **Conexión a Internet** | La primera vez, para que Maven descargue las dependencias (JavaFX, JUnit) |
| **Scene Builder** | Opcional: solo si se van a editar las pantallas `.fxml` |

Para ejecutar desde la terminal también se necesita **Maven** instalado y disponible en el `PATH`.

## Cómo descargar el proyecto

**Opción A: clonar con Git**

```bash
git clone <URL-DEL-REPOSITORIO>
```

**Opción B: descargar el ZIP**

1. En la página del repositorio en GitHub, pulsa el botón verde **Code**.
2. Elige **Download ZIP**.
3. Descomprime el archivo en una carpeta de tu computador.

## Cómo importarlo en Eclipse

1. Abre Eclipse y selecciona **File → Import → Maven → Existing Maven Projects**.
2. En **Root Directory**, pulsa **Browse** y elige la carpeta del proyecto (la que contiene el archivo `pom.xml`).
3. Comprueba que el `pom.xml` aparece marcado y pulsa **Finish**.
4. Espera a que Eclipse termine de descargar las dependencias (se ve el avance abajo a la derecha).
5. Verifica que el proyecto usa **JDK 26**: clic derecho sobre el proyecto → **Properties → Java Build Path → Libraries**. Si no aparece, agrégalo en **Window → Preferences → Java → Installed JREs**.

Si Eclipse marca errores después de importar, haz clic derecho sobre el proyecto → **Maven → Update Project** (o `Alt + F5`) y acepta.

## Cómo ejecutarlo

La aplicación se ejecuta con Maven, a través del plugin de JavaFX.

**Desde Eclipse**

1. Clic derecho sobre el proyecto → **Run As → Maven build...**
2. En el campo **Goals** escribe: `javafx:run`
3. Pulsa **Run**.

Las siguientes veces basta con elegir esa configuración en el menú del botón verde de ejecución (**Run**) de Eclipse.

**Desde la terminal**

```bash
cd MunEco
mvn javafx:run
```

> **Importante:** no ejecutes la clase `AppFx` como *Java Application*. Al necesitar los módulos de JavaFX, mostraría el error *"JavaFX runtime components are missing"*. Usa siempre `javafx:run`.

La clase principal es `co.edu.eia.ecocampus.app.AppFx`.

## Cómo usar la aplicación

1. Al abrirse, aparece una ventana con un **menú lateral** a la izquierda y el área de trabajo a la derecha.
2. Pulsa **Cargar datos de prueba**, en la parte inferior del menú. Se cargan personas, puntos ecológicos, rutas, reportes, recolecciones y campañas de ejemplo, para poder explorar la aplicación sin empezar de cero. Solo se pueden cargar una vez por ejecución.
3. Navega por los módulos desde el menú lateral. Cada pantalla se organiza en pestañas (por ejemplo, *Registrar* y *Ver*).
4. El botón **Notificaciones** de la barra superior muestra cuántos avisos nuevos ha generado el sistema; al abrirlo se ve el historial.

### Flujo de ejemplo

1. En **Personas**, registra un usuario.
2. En **Puntos ecológicos**, registra un punto activo.
3. En **Reportes**, registra un reporte sobre ese punto, a nombre del usuario, y asígnalo a un operador.
4. En **Recolección**, registra lo recolectado para ese reporte (material y peso).
5. En **Reportes**, cierra el reporte: el usuario recibe sus eco-puntos.
6. En **Eco-puntos y consultas**, revisa el historial del usuario y el ranking.

## Pruebas

El proyecto incluye pruebas unitarias con **JUnit 5** sobre las capas de lógica (modelo, servicios, repositorio y patrones). Las pantallas no se prueban automáticamente.

- **Desde Eclipse:** clic derecho sobre `src/test/java` → **Run As → JUnit Test**.
- **Con Maven:** clic derecho sobre el proyecto → **Run As → Maven test**, o en la terminal:

```bash
mvn test
```

Los informes quedan en `target/surefire-reports`.

## Estructura del proyecto

```
MunEco/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/co/edu/eia/ecocampus/
    │   │   ├── app/              Clase principal (AppFx) y composición de la aplicación
    │   │   │   └── controlador/  Controladores de las pantallas JavaFX
    │   │   ├── modelo/           Entidades, clases abstractas e interfaces del dominio
    │   │   ├── servicio/         Casos de uso, reglas de negocio y verificadores
    │   │   ├── repositorio/      Repositorio genérico en memoria
    │   │   ├── patron/           Patrones de diseño
    │   │   ├── excepcion/        Excepciones personalizadas del dominio
    │   │   └── util/             Utilidades generales (alertas, conversión de datos)
    │   └── resources/co/edu/eia/ecocampus/app/
    │       ├── vista/            Pantallas (.fxml)
    │       ├── estilos/          Hoja de estilos (.css)
    │       └── imagenes/         Logo e imágenes
    └── test/java/                Pruebas unitarias (JUnit 5)
```

## Arquitectura

La aplicación se organiza en capas, y cada una solo conoce a la que tiene debajo:

```
Pantallas (FXML) → Controladores → Servicios → Repositorios → Modelo
```

- **Pantallas y controladores:** leen los datos que escribe el usuario y muestran resultados y errores. No contienen reglas de negocio.
- **Servicios:** aplican las reglas del negocio y coordinan varias entidades. Los **verificadores** validan los datos y lanzan excepciones con un mensaje claro.
- **Repositorios:** guardan y buscan las entidades por su identificador.
- **Modelo:** las entidades del dominio (personas, puntos, reportes, rutas, recolecciones, campañas...).

El proyecto usa colecciones (`ArrayList`, `HashMap`) en lugar de arreglos, por lo que nunca es necesario declarar capacidades.

### Patrones de diseño

| Patrón | Dónde se usa | Clases |
|---|---|---|
| **Observer** | Notificaciones del sistema | `NotificadorObservable`, `ObservadorNotificacion`, `HistorialNotificaciones` |
| **Singleton** | Un único notificador para toda la aplicación | `NotificadorObservable.getInstancia()` |
| **Factory** | Creación de los materiales | `FabricaMaterial` |
| **Strategy** | Cálculo de eco-puntos por material | `EstrategiaPuntos`, `PuntosPorPeso`, `PuntosConBono` |

## Estado del proyecto

- Los datos se guardan **en memoria**: se pierden al cerrar la aplicación.
- La persistencia en **base de datos** mediante **JDBC** está en desarrollo; el diseño en capas permite reemplazar los repositorios en memoria sin modificar los servicios ni las pantallas.

## Solución de problemas

| Problema | Solución |
|---|---|
| *JavaFX runtime components are missing* | Ejecuta con `javafx:run` (Maven), no como *Java Application* |
| Eclipse marca errores en todo el proyecto | Clic derecho → **Maven → Update Project** |
| *release version 26 not supported* o similar | El proyecto no está usando el JDK 26: revisa **Window → Preferences → Java → Installed JREs** |
| Maven no encuentra las dependencias | Revisa la conexión a Internet y repite **Maven → Update Project** |
| Un cambio en un `.fxml` o en el CSS no se ve | Selecciona el archivo, pulsa `F5`, haz **Maven → Update Project** y vuelve a ejecutar |

Al ejecutar aparecen en la consola algunos avisos (`WARNING`) sobre acceso nativo y sobre la versión del documento FXML. Son normales y no afectan el funcionamiento.

## Equipo

Proyecto integrador de *Programación Orientada a Objetos en Java*, Universidad EIA.

| Integrante | Rol |
|---|---|
| _Nombre del integrante 1_ | |
| _Nombre del integrante 2_ | |
| _Nombre del integrante 3_ | |
| _Nombre del integrante 4_ | |
