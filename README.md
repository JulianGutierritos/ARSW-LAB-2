# ARSW LAB-2

### 2. Review the code and identify how the functionality indicated above was implemented. Given the intention of the game, an invariant should be that the sum of the life points of all players is always the same (of course, in an instant of time in which a time increase / reduction operation is not in process ). For this case, for N players, what should this value be?

Dado un número N de inmortales, el valor de la suma de los puntos de vida debería ser igual a N * DEFAULT_IMMORTAL_HEALTH. En este caso particular sería igual a N * 100.

### 3. Run the application and verify how the ‘pause and check’ option works. Is the invariant fulfilled?

- En este momento, ‘pause and check’ recorre la lista de los inmortales y suma la cantidad de vida que tienen en ese instante.

- No se cumple la invariante, ya que puede que al instante siguiente en el que se toma el valor, este cambia por que hubo una pelea con otro inmortal.

### 5. Check the operation again (click the button many times). Is the invariant fulfilled or not ?.

Después de los cambios realizados en el punto anterior, si se cumplela invariante.

### 6. Identify possible critical regions in regards to the fight of the immortals. Implement a blocking strategy that avoids race conditions. Remember that if you need to use two or more ‘locks’ simultaneously, you can use nested synchronized blocks:

#### Posibles regiones críticas:

- Cuando se establece quién es el siguiente inmortal con el que se tendrá la pelea.

![](https://github.com/JulianGutierritos/ARSW---LAB-2-P1/blob/master/imgs/ars1.png)

- En la pelea cuando se quiere acceder y/o cambiar la el puntaje de vidas del contrincante.

![](https://github.com/JulianGutierritos/ARSW---LAB-2-P1/blob/master/imgs/ars2.png)

- Para cada hilo cuando se quiere cambiar el puntaje de vidas.

![](https://github.com/JulianGutierritos/ARSW---LAB-2-P1/blob/master/imgs/ars4.png)

- Para cada hilo cuando se quiere acceder al puntaje de vidas.

![](https://github.com/JulianGutierritos/ARSW---LAB-2-P1/blob/master/imgs/ars3.png)

### 10. Analyzing the simulation operation scheme.

- Cuando la vida de un inmortal llegaba a cero, otro inmortal ya no podía combatir contra él, pero el hilo continuaba ejecutandose gastanto más recursos innecesariamente y permitiendo que los inmortales "muertos" siguieran combatiendo y bajando vida a otros. Al detener el Inmortal cuando moría, el programa se hacía más rapido a medida que morían más inmortales y ya solo combaten los inmortales que se encuentran "vivos".






