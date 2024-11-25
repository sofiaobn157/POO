# Sistema de Gestión de Inventario

Este es un programa que gestiona un inventario de libros. Este codigo lo realicé y lo corrí en Visual Studio Code por lo que para que te funcione debes cumplir con los siguientes requisitos.

Requisitos:

1. Java: Este programa está escrito en Java, por lo que necesitarás tener instalado el JDK (Java Development Kit) en tu sistema.
   
* Puedes descargarlo desde el [sitio oficial de Oracle](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html) o usar OpenJDK.

2. Visual Studio Code (VS Code): Necesitarás Visual Studio Code instalado para abrir y editar el código.
* Si no lo tienes, puedes descargarlo desde [aquí](https://code.visualstudio.com/Download).

3. Extensión de Java para VS Code: Para ejecutar y depurar el código Java, necesitas instalar la extensión de Java para VS Code.
   
   - Abre VS Code y ve a la sección de Extensiones (el icono de cuadrados en la barra lateral).
   - Busca `Java Extension Pack` e instálalo.

A continuación se mostrará el paso a paso para ejecutar el codigo y que funcione. 

1. Abrir el proyecto en Visual Studio Code
	Abre Visual Studio Code.
	Haz clic en Archivo > Abrir carpeta... y selecciona la carpeta del proyecto.

2. Ejecutar el código

	Abre el archivo SistemaGestionInventario.java.
	Haz clic derecho sobre el archivo y selecciona "Ejecutar Java" o usa el atajo F5 (Windows/Linux) o Cmd + F5 (Mac).

	NOTA IMPORTANTE: También puedes hacer clic en el botón Run and Debug (el icono de un triángulo verde con un insecto) en la barra lateral superior de VS 		Code para ejecutar el código. Esto abrirá la consola de depuración, ejecutando el programa y permitiéndote ver los resultados en tiempo real.

3. Guardar y cargar archivos

Guardar inventario:
El programa abre un cuadro de diálogo (JFileChooser) donde el usuario puede seleccionar la carpeta y el nombre del archivo donde desea guardar el inventario.
Si el archivo ya existe, el programa preguntará si deseas sobrescribirlo.

Cargar inventario:
Similar a la opción de guardar, el programa utiliza un cuadro de diálogo para seleccionar un archivo desde el cual cargar el inventario de libros.
El archivo debe estar en formato binario (.dat).

3.1 Instrucciones para cargar y guardar archivos

Guardar archivo: 
En la interfaz gráfica del programa, selecciona Guardar inventario.
Elige la carpeta y el nombre del archivo donde quieres guardar el inventario.
El archivo se guardará en formato binario, y podrá ser cargado en futuras sesiones.

Cargar archivo:
En la interfaz gráfica, selecciona Cargar inventario.
Elige el archivo de inventario guardado previamente en formato .dat.
Los datos del archivo se cargarán en el programa, y podrás ver el inventario de libros.

4. Funcionalidades

Guardar inventario: Permite guardar el inventario en un archivo binario.

Cargar inventario: Permite cargar un archivo binario previamente guardado.

Interfaz gráfica: El programa incluye una interfaz gráfica para la interacción con el usuario, utilizando cuadros de diálogo para cargar y guardar archivos.
Código fuente

El programa tiene las siguientes clases:
FileManager: Encargada de gestionar las operaciones de entrada/salida (leer y escribir archivos).

Métodos:
guardarInventario(List<Libro> libros): Guarda el inventario en un archivo seleccionado por el usuario.
cargarInventario(String archivo): Carga el inventario desde un archivo seleccionado por el usuario.
seleccionarArchivoParaCargar(): Muestra un cuadro de diálogo para seleccionar el archivo a cargar.
Libro: Representa un libro en el inventario, con atributos como nombre, autor, año, etc.
SistemaGestionInventario: Es la clase principal que maneja la lógica del programa y la interfaz gráfica.

5. Posibles errores

El archivo no existe: Si intentas cargar un archivo que no existe o está dañado, el programa mostrará un mensaje de error.
Error al guardar: Si no puedes guardar el archivo, asegúrate de que tienes permisos de escritura en la carpeta seleccionada.
Formato de archivo incorrecto: Asegúrate de que el archivo de inventario tenga el formato correcto (.dat) al intentar cargarlo.