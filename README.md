# Evaluation Java Steven Della rica

# Consignes pour faire fonctionner ce programme

Il suffit de pull le projet, configurer l'accès à votre base de données dans le persistence.xml sur
ces lignes : 

      <property name="jakarta.persistence.jdbc.url" value="jdbc:mariadb://localhost:3307/petstore"/>
      <property name="jakarta.persistence.jdbc.user" value="root"/>
      <property name="jakarta.persistence.jdbc.password" value=""/>

Dans mon cas le lien est un protocole jdbc pour une base de données mariadb, j'ai défini le localhost
sur le port 3307 et le nom de la base de données est petstore.

