# IFT3913 - TÂCHE #3
## Équipe

Vincent Péloquin - 20105029

Carl Thibault - 0985781

## Changements apportés à la github action

Lien vers la github action: [test.yml](.github/workflows/test.yml)

| Flag ajouté                           | Motivation                                                                                  |
|---------------------------------------|---------------------------------------------------------------------------------------------|
| -XX:+UseSerialGC                      | Spécification explicite de l'utilisation du "serial garbage collector". Permet d'évaluer l'impact de la gestion de la mémoire avec un garbage collector utilisant un seul thread CPU.                     |
| -XX:MaxHeapSize=2G -XX:MinHeapSize=4M | Réduction de la taille du tas par défaut (seuils minimum et maximum) pour simuler des environnments plus restrictifs en terme de mémoire disponible. |
| -XX:ActiveProcessorCount=1            | Limitation du nombre de core CPU considéré a un seul pour restreindre le nombre de core disponible pour la JVM lors de la création de threads. Permet de voir comment se comporte l'application dans un environnement où on ne peut pas faire de parallélisme. |
|  -XX:-UseCompressedOops              |  Désactivation des pointeurs d'objets compressés pour voir si l'application fonctionne bien sans cette optimisation.                          |
| -XX: -TieredCompilation              | Force la JVM à utiliser le compilateur C2 qui est plus lent, mais mieux optimisé. Utile pour détecter des problèmes qui pourraient être masqués par l'optimisation de la compilation. |
