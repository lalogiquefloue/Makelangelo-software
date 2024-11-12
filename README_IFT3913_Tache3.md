# IFT3913 - TÂCHE #3
## Équipe

Vincent Péloquin - 20105029

Carl Thibault - 0985781

## Changements apportés à la github action

Lien vers la github action: [test.yml](.github/workflows/test.yml)

| Flag ajouté                           | Motivation                                                                                  |
|---------------------------------------|---------------------------------------------------------------------------------------------|
| -XX:+UseSerialGC                      | Changement de type de Garbage Collector.                                                    |
| -XX:MaxHeapSize=2G -XX:MinHeapSize=4M | Réduction de la taille du tas (seuils minimum et maximum).                                  |
| -XX:ActiveProcessorCount=1            | Limitation du nombre de core CPU a un seul.                                                 |
|                                       |                                                                                             |
|                                       |                                                                                             |
