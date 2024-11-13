# IFT3913 - TÂCHE #3
## Équipe

Vincent Péloquin - 20105029

Carl Thibault - 0985781

## Changements apportés à la github action

Lien vers la github action: [test.yml](.github/workflows/test.yml)

| Flag ajouté                           | Motivation                                                                                  |
|---------------------------------------|---------------------------------------------------------------------------------------------|
| -XX:+UseSerialGC                      | Spécification explicite de l'utilisation du "serial garbage collector".                     |
| -XX:MaxHeapSize=2G -XX:MinHeapSize=4M | Réduction de la taille du tas (seuils minimum et maximum) pour simuler des environnments plus restrictifs en terme de mémoire disponible. |
| -XX:ActiveProcessorCount=1            | Limitation du nombre de core CPU considéré a un seul pour restreindre le nombre de core disponible pour la JVM lors de la création de threads. |
|                                       |                                                                                             |
|                                       |                                                                                             |
