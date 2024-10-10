# IFT3913 - TÂCHE #2
## Équipe

Vincent Péloquin - 20105029

Carl Thibault - 0985781

## Tests ajoutés 

| Package                                          | Nom de la classe   | Nom de la méthode    | Liens | Description |
|------------------------------------------------------|-------------------|-----------------|--------|-------------|
| `com.marginallyclever.makelangelo.turtle`           | `Turtle.java`     | `rotate`        | [TurtleTest.java](src/test/java/com/marginallyclever/makelangelo/turtle/TurtleTest.java) | Tests de divers paramètres de la fonction rotate. |
| `com.marginallyclever.makelangelo.turtle` | `Turtle.java` | `countLoops` | [TurtleTest.java](src/test/java/com/marginallyclever/makelangelo/turtle/TurtleTest.java) * | Tests de divers scénarios pour la fonction countLoops. <em>Potentiel bug trouvé, à vérifier avec le mainteneur du projet s'il s'agit d'un comportement attendu.<\em> |
| `com.marginallyclever.makelangelo.makeart.imagefilter` | `FilterCMYK.java` | `filter`     | [FilterCMYKTest.java](src/test/java/com/marginallyclever/makelangelo/makeart/imagefilter/FilterCMYKTest.java) | Tests de diverses combinaisons RGB et de leurs conversion en CMYK. |
| `com.marginallyclever.makelangelo.plotter`         | `Plotter.java`    | `turtleMove`    | [PlotterTest.java](src/test/java/com/marginallyclever/makelangelo/plotter/PlotterTest.java) | Tests de différentes combianisons de mouvements et vérification de la destination attendue.  |
| `com.marginallyclever.convenience.helpers`          | `MathHelper.java` | `equals`        | [MathHelperTest.java](src/test/java/com/marginallyclever/convenience/helpers/MathHelperTest.java) | Maximisation de la couverture des branches de cette fonction - Bug trouvé et corrigé. |


\* Possible bogue trouvé. Le test problématique a été désactivé pour ne pas empêcher les Github actions de s'exécuter.
