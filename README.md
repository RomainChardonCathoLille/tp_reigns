# TP Reigns Solid

## Modifications apportées

---

### Premières modifications (Version 1.1)

Les premières modifications que j'ai apportées pour rendre le 
code le plus solid possible étaient de créer les classes suivantes
dans un premier temps :
* Une classe **Effet** qui va servir à appliquer des effets aux différentes
jauges qui lui seront fournies en paramètre en temps voulu, elle
gardera en mémoire à quelle jauge elle correspond, ainsi que 
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

Afin de pouvoir ajouter une nouvelle fonctionnalité de questions avec
conditions d'apparitions, il a été nécessaire de créer deux nouvelles
classes :
* La classe **Condition**
* La classe **QuestionCondition**

La classe **Condition** permet de définir une condition. Son constructeur prend
en entrée quatre paramètres :
* Un **TypeJauge** qui nous permet de savoir sur quel type de
jauge la condition est posée.
* Un caractère **TypeCondition** qui nous permet de savoir si la
condition est de type 'Supérieur' ou 'Inférieur'.
* Une valeur (un entier) qui correspond au chiffre de la condition
* Les jauges de l'utilisateur, pour pouvoir vérifier leur valeur.

La classe possède deux fonctions : une publique et une privée. La fonction
privée sert à obtenir la bonne jauge du joueur afin de pouvoir 
vérifier sa valeur.

La fonction publique, **conditionRespectee** sert à vérifier si la condition est bien
respectée. Elle renvoie la valeur 1 si c'est le cas, 0 sinon.

Une fois le concept de conditions défini dans le programme, il a fallu
l'adapter aux questions. Une nouvelle classe à donc été créée, la
classe **QuestionCondition**. Cette classe étend la classe **Question**,
mais possède un paramètre d'entrée en plus : un objet de la classe **Condition**.
Mais cette classe, possède aussi une fonction supplémentaire :
la fonction **peutAfficherQuestion** qui sert à vérifier si la condition
passée en entrée est bien respectée. Si c'est le cas elle renvoie 1, sinon 0.

Nous avons ensuite ajouté deux questions du type **QuestionCondition** dans la
classe **Questions**. Il a aussi fallu modifier la fonction
afficher question pour qu'elle vérifie le type de notre **Question**,
et qu'elle affiche cette dernière ou non en fonction de ce qu'elle lui
aura retourné via la fonction **peutAfficherQuestion** citée précédemment.

Nous avons ensuite fait en sorte de pouvoir faire passer les jauges du
**Personnage** dans la classe **Questions** depuis la classe **Jeu**.

### Troisièmes modifications (version 2.0 - Reigns Game of Thrones)


## Auteurs

[*Romain Chardon*](https://github.com/RomainChardonCathoLille)