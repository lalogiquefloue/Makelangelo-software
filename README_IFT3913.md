# IFT3913 - TÂCHE #2
## Équipe

Vincent Péloquin - 20105029

Carl Thibault - 0985781

## Tests ajoutés 

| Package                                          | Nom de la classe   | Nom de la méthode    | Liens | Description |
|------------------------------------------------------|-------------------|-----------------|--------|-------------|
| `com.marginallyclever.makelangelo.turtle`           | `Turtle.java`     | `rotate`        | [TurtleTest.java](src/test/java/com/marginallyclever/makelangelo/turtle/TurtleTest.java) | `TODO` |
| `com.marginallyclever.makelangelo.turtle` | `Turtle.java` | `countLoops` | [TurtleTest.java](src/test/java/com/marginallyclever/makelangelo/turtle/TurtleTest.java) * | `TODO` |
| `com.marginallyclever.makelangelo.makeart.imagefilter` | `FilterCMYK.java` | `filter`     | [FilterCMYKTest.java](src/test/java/com/marginallyclever/makelangelo/makeart/imagefilter/FilterCMYKTest.java) | `TODO` |
| `com.marginallyclever.makelangelo.plotter`         | `Plotter.java`    | `turtleMove`    | [PlotterTest.java](src/test/java/com/marginallyclever/makelangelo/plotter/PlotterTest.java) | `TODO` |
| `com.marginallyclever.convenience.helpers`          | `MathHelper.java` | `equals`        | [MathHelperTest.java](src/test/java/com/marginallyclever/convenience/helpers/MathHelperTest.java) * | `TODO` |
| `TODO` | `TODO` | `TODO` | `TODO` | `TODO` |
| `TODO` | `TODO` | `TODO` | `TODO` | `TODO` |
| `TODO` | `TODO` | `TODO` | `TODO` | `TODO` |
| `TODO` | `TODO` | `TODO` | `TODO` | `TODO` |
| `TODO` | `TODO` | `TODO` | `TODO` | `TODO` |

\* Possible bogue trouvé. Les tests en question ont été désactivé pour ne pas empêcher les github actions de s'exécuter.


## Fonctions potentielles à tester

- com.marginallyclever.convenience > ConvexHull.java -> pointIsInTriangleXY (PAS UNE MÉTHODE PUBLIQUE)
- com.marginallyclever.makelangelo.plotter.plotterrenderer > Polargraph.java -> IK, FK
- com.marginallyclever.makelangelo.donatelloimpl.nodes > PathImageMask.java -> sampleImageUnderStep (PAS UNE MÉTHODE PUBLIQUE)
- com.marginallyclever.convenience > Histogram.java -> possible de tester avec la classe BufferedImage?
- com.marginallyclever.util > MarginallyCleverTranslationXmlFileHelper.java -> possible à tester ?
- com.marginallyclever.convenience.helpers > MathHelper.java -> equals (DONE - Carl)
- com.marginallyclever.makelangelo.makeart.tools > InfillTurtle.java -> possible de tester "run"?
- com.marginallyclever.makelangelo.makeart.io > LoadScratch2.java -> tester load avec fichier sb2 ?
- com.marginallyclever.makelangelo.plotter > Plotter.java -> turtleMove (DONE - CARL)
- ~~com.marginallyclever.convenience > NameThatColor.java -> find (DEPRECATED)~~
- com.marginallyclever.convenience > QuadGraph.java -> split, countPoints, insert, search
- ~~com.marginallyclever.convenience > ColorRGB.java -> toutes les méthodes (DEPRECATED)~~
- ~~com.marginallyclever.convenience > ColorPalette.java -> quantizeIndex (DEPRECATED)~~
- Makelangelo > com.marginallyclever.makelangelo.turtle > Turtle.java -> rotate (DONE - CARL)
- com.marginallyclever.makelangelo.makeart.imagefilter > FilterCMYK.java (DONE - CARL)
- com.marginallyclever.makelangelo.makeart > TransformedImage.java
