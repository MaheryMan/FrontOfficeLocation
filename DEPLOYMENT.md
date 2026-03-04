# Guide de Déploiement sur Render

Ce guide vous aidera à déployer l'application FrontOffice sur Render avec Docker.

## Prérequis

- Un compte Render (https://render.com)
- Le code source de l'application poussé sur un repository Git (GitHub, GitLab, etc.)

## Configuration Automatique avec render.yaml

L'application est configurée pour un déploiement automatique via le fichier `render.yaml`.

**Note**: Cette application n'utilise pas de base de données locale. Elle récupère toutes les données via l'API backend.

### Étapes de Déploiement

1. **Connectez votre repository Git à Render**
   - Connectez-vous à votre compte Render
   - Cliquez sur "New +" → "Blueprint"
   - Sélectionnez votre repository

2. **Render détectera automatiquement le fichier render.yaml**
   - Le service web sera configuré avec les bonnes variables d'environnement

3. **Variables d'environnement configurées automatiquement**
   - `BACKOFFICE_API_URL`: https://backofficelocation.onrender.com/api
   - `JAVA_TOOL_OPTIONS`: Optimisation mémoire pour le plan gratuit

## Déploiement Manuel (alternative)

Si vous préférez configurer manuellement :

### 1. Créer le service web

- Cliquer sur "New +" → "Web Service"
- Connecter votre repository
- Configuration:
  - **Name**: frontoffice-location
  - **Runtime**: Docker
  - **Plan**: Free
  
### 2. Configurer les variables d'environnement

Dans l'onglet "Environment" du service web, ajouter:

```
BACKOFFICE_API_URL=https://backofficelocation.onrender.com/api
JAVA_TOOL_OPTIONS=-Xmx512m -Xms256m
```

### 3. Déployer

- Cliquez sur "Create Web Service"
- Render va automatiquement:
  - Détecter le Dockerfile
  - Builder l'image Docker
  - Déployer l'application

## Vérification du Déploiement

Une fois déployé, votre application sera accessible à l'URL fournie par Render (format: `https://frontoffice-location.onrender.com`)

### Test de l'application

1. Accédez à l'URL de votre application
2. Vérifiez que la page d'accueil se charge
3. Testez les fonctionnalités de réservation

## Notes Importantes

- **Premier démarrage**: Le premier démarrage peut prendre quelques minutes
- **Plan gratuit**: Les services gratuits se mettent en veille après 15 minutes d'inactivité
- **Architecture**: Cette application est stateless - elle récupère toutes les données depuis l'API backend
- **Logs**: Consultez les logs dans le dashboard Render en cas de problème

## Dépannage

### L'application ne démarre pas

1. Vérifiez les logs dans le dashboard Render
2. Vérifiez que l'API backend est accessible à `https://backofficelocation.onrender.com/api`
3. Assurez-vous que les variables d'environnement sont correctement configurées

### Erreurs lors de la récupération des données

1. Testez l'accessibilité de l'API backend directement
2. Vérifiez que l'URL de l'API est correcte dans `BACKOFFICE_API_URL`
3. Consultez les logs pour voir les détails des erreurs de connexion

### Erreurs JSP

1. Assurez-vous que le Dockerfile build correctement l'application
2. Vérifiez que toutes les dépendances sont présentes dans le `pom.xml`

## Support

Pour plus d'informations, consultez la documentation Render: https://render.com/docs
