#HandiAdvisor

Pour installer l'application, plusieurs étapes sont nécessaires :
- Télécharger et installer Netbeans EE version 8.2
- Télécharger et installer dans Netbeans, la version 4.1 de Glassfish
- Importer le projet dans Netbeans et créer/charger les dépendances manquantes (library jUnit et PrimeFaces 5.0

Au niveau de la base de données de l'application :
- Si nécéssaire, télécharger et installer MySql
- Créer une base de données appelée "handiadvisor" sur MySql
- Créer un utilisateur Mysql ayant tous les droits sur la base de données "handiadvisor"
  - Nom utilisateur : handi
  - Mot de passe : handi
  
- Modifier le fichier  : handijpa/web/WEB-INF/glassfish-resources.xml en y modifiant, si nécessaire :
  - serverName : ip de votre serveur (par défaut en localhost)
  - portNumber : port d'écoute de votre MySql (par défaut 8889)
  - databaseName : handiadvisor (par défaut handiadvisor)
  - User : handi (par défaut handi)
  - Password : handi (par défaut handi)
  
- Créer une instance de votre serveur GlassFish 4.1, compiler l'application. Ensuite procédez au déploiement de l'application.

L'application fonctionne !
  


