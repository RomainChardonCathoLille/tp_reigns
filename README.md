# TP Reigns Solid

## Modifications apportées

---

### Premières modifications (Version 1.1)

Les premières modifications que j'ai apportées pour rendre le 
code le plus solid possible étaient de créer les classes suivantes
dans un premier temps :
* Une classe **Effet** qui va servir à appliquer des effets aux différentes
jauges qui lui seront fournies en paramètre en temps voulu, elle
gardera en mémoire à quel jauge elle correspond, ainsi que 
l'effet qu'elle appliquera à cette dernière.
* Une classe **Effets** qui sert à enregistrer plusieurs effets
pour une question. Cette classe fera en sorte que tous les effets
lui étant assignés soient appliqués aux jauges via la classe **Effet**
créée auparavant. Elle permet aussi d'afficher ces différents effets.
* Une classe **Questions** qui, comme la classe **Effets** enregistre
une liste de questions et permettra de retourner des questions lorsque
ce sera voulu. Il est aussi possible d'ajouter des questions.

Après avoir créé ces classes, il a fallu réorganiser le code, en
changeant les méthodes de classe. Cette partie était particulièrement
longue, à cause de toutes les dépendances à supprimer. Le problème
principal était que le code ne respectait pas le principe de "Single 
Responsibility", c'est pour cette raison qu'il a fallu bouger beaucoup
de méthodes et les transférer à d'autres classes.

Le principe de "Dependency Inversion" n'étant pas respecté non plus,
il a fallu changer un peu de code afin de ne plus créer d'objets dans
les différentes classes, mais les donner dans leurs constructeurs.

### Secondes modifications (version 1.2 - Questions avec conditions d'apparition)


## Auteurs

[*Romain Chardon*](https://github.com/RomainChardonCathoLille)