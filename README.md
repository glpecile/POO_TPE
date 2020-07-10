# paintPOO
TPE POO (trabajo final)

## Instrucciones de uso
### Interfaz de usuario
En la parte superior tenemos una barra de menúes, los cuales son ``Archivo``, que contiene un botón para salir, y ``Ayuda``, que contiene un botón para abrir información del programa.
En la parte izquierda, se sitúa la barra de botones, los cuales sirven para crear figuras, modificarlas y borrarlas.
Al lado de la barra de botones, se sitúa el espacio de trabajo, donde se muestran las figuras.
Por último, en la parte inferior, se muestra información relevante acerca del espacio de trabajo. Por ejemplo, coordenadas, información de las figuras, y figuras que han sido seleccionadas.
Cuando se desplaza el mouse por la zona de trabajo, se muestran las coordenadas donde está. Si el cursor pasa por encima de una figura, se muestra información sobre ella. Y si se seleccionan figuras, se muestran aquellas que han sido seleccionadas. Esta información se muestra en la barra inferior.

### Creación de figuras
Para crear una figura se debe seleccionar el botón de la figura que se desee crear, en la barra de botones izquierda. Se pueden crear: Rectángulos, Cuadrados, Elipses, Círculos y Líneas. Las figuras se crean con los colores y el grosor definido en la barra de botones izquierda.

#### Rectángulo
Para crear un rectángulo, se debe presionar el botón ``Rectángulo``. Hacer click en el área de dibujo para definir el punto superior izquierdo del mismo, mantener presionado y arrastrarlo hasta el punto inferior derecho. Una vez que se dejó de presionar el mouse, el rectángulo aparecerá en pantalla. 

#### Cuadrado
Para crear un cuadrado, se debe presionar el botón ``Cuadrado``. Hacer click en el área de dibujo para definir el punto superior izquierdo, mantener presionado y arrastrarlo a la derecha hasta el punto en el que se tomará como lado el desplazamiento horizontal. Una vez que se dejó de presionar el mouse, el cuadrado aparecerá en pantalla.

#### Elipse
Para crear una elipse, se debe presionar el botón ``Elipse``. Se debe realizar de la misma manera que un rectángulo, y la elipse que se generará es aquella que está contenida en ese rectángulo.

#### Círculo
Para crear un círculo, se debe presionar el botón ``Círculo``. Hacer click para definir el centro, y luego arrastrar para definir el radio del mismo. El radio se puede definir en cualquier dirección. Una vez que se dejó de presionar el mouse, el círculo aparecerá en pantalla.

#### Línea
Para crear una línea, se debe presionar el botón ``Línea``. Hacer click para definir el punto inicial de la línea y luego arrastrar en cualquier dirección para definir el punto final de la misma. Una vez que se dejó de presionar el mouse, la línea aparecerá en pantalla.

### Selección de figuras
Para seleccionar figuras se debe presionar el botón ``Seleccionar``. Se pueden seleccionar figuras de dos maneras.

#### Selección unitaria
Para seleccionar una sola figura se debe hacer click sobre ésta. Una vez seleccionada, su borde cambiará a rojo. Además, en la barra inferior se mostrará información sobre la misma. Si se hace click sobre un lugar donde no hay figura, se indicará que no se encontró una figura en ese lugar.

#### Selección múltiple
Para seleccionar varias figuras, se debe hacer un rectángulo (Empezando por el punto superior izquierdo y terminando en el punto inferior derecho) para definir el área donde se van a seleccionar las figuras. Para que la figura quede seleccionada, debe estar completamente dentro del rectángulo de selección. Todas las figuras que hayan sido seleccionadas se indicarán cambiando su borde a rojo. Además, se las listará en la barra inferior.

### Mover figuras
Las figuras seleccionadas se pueden mover. Para ello, una vez seleccionadas, se debe mantener presionado click y desplazarlas por las pantalla, una vez que se suelte el click, se dejarán de mover. Cuando se mueven, se actualiza su posición en tiempo real.

### Color de borde y relleno
Las figuras pueden tener colores independientes. Se pueden crear con un color seleccionado anteriormente, o seleccionarlas y cambiarle su color. Lo mismo se puede hacer con el grosor del borde.
Para ello se cuenta con un Slider, con el cual se puede definir el grosor del borde.
Se cuenta con dos ColorPicker. Uno sirve para seleccionar el color del borde, y el otro para el color del relleno. 

### Borrado de figura
Para borrar una figura se la debe seleccionar, y luego hacer click en el botón Borrar. También se pueden borrar varias figuras a la vez, con la selección múltiple.

### Profundidad
Se puede modificar la profundidad de las figuras que se encuentren seleccionadas. Cuando se tienen varias figuras seleccionadas, éstas van a mantener su orden relativo, pasando al fondo o al frente de las demás figuras.

#### Al fondo
Si se presiona el botón ``Al fondo``, las figuras que estén selecciondas se enviarán al fondo del dibujo.

#### Al frente
Se se presiona el botón ``Al frente``, las figuras que estén seleccionadas se enviarán al frente del dibujo.

## Autores:
* Julián Francisco **Arce Doncella** 60509
* Roberto José **Catalán** 59174
* Gian Luca **Pecile** 59235
