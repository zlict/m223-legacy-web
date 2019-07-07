# REST

- URI: [m223-api.komeo.net](https://m223-api.komeo.net)
- MicroService: [m223-api.komeo.net/gitlab/user/gitlab](https://m223-api.komeo.net/gitlab/user/gitlab)

# Project Tree 

```
E:.
|   .gitignore
|   .gitlab-ci.yml
|   pom.xml
|   Procfile
|   README.md
|
+---src
|   +---main
|   |   +---java
|   |   |   \---net
|   |   |       \---komeo
|   |   |           \---m223
|   |   |               \---web
|   |   |                   +---control
|   |   |                   |       SimpleServlet.java
|   |   |                   |
|   |   |                   \---model
|   |   |                           KomeoMicroService.java
|   |   |
|   |   +---resources
|   |   \---webapp
|   |       |   index.jsp
|   |       |
|   |       +---META-INF
|   |       |       context.xml
|   |       |       MANIFEST.MF
|   |       |
|   |       \---WEB-INF
|   |               web.xml
|   |
|   \---test
|       \---java
```