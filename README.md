# Spring Bank Project
![alt text](https://fernandofranzini.files.wordpress.com/2018/04/1_gycg7f5bylur4ut_jaes7a.png?raw=true)


   ### Aplicação em API REST usando o Spring Framework utilizando a IDE Visual Studio Code, com o intuito de simular um cadastro de um usuário no banco para realização do teste criado pela Orange Talents.

   ## Dependências

- Web: Projeto API REST.
- JPA: Armazenar dados em um banco de dados.
- Swagger: Fazer a documentação  e utiliza-lo para fazer as requisições.
- Lambok: Biblioteca Java focada em produtividade e redução de código.
- MySQLConnector: Fazer a conexão com o banco de dados.

## Tecnologias

  * [Docker] : Virtualização do MYSQL na máquina.
  * [Dbeaver] : Manipulação do Banco Relacional MYSQL.

![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/mysql.png?raw=true)
  

## Organização de Pastas
![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/allFolders.png?raw=true)
  
  ### Business: Define a regra de negócio da nossa aplicação.
  ![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/business.png?raw=true)
  
 ![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/clientBusiness.png?raw=true)
  
    divida em interface e a implementação.
  

  ### Config: Configuração do Swagger
  ![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/swagger.png?raw=true)

  ### Controller: Métodos de requisição da nossa aplicação 
  ![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/clientController.png?raw=true)
  
![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/clientControllerInside.png?raw=true)
  

    Controla e valida os dados que o usuário inseriu.

  ### DTO (Data Transfer Obejct) : Padrão de projetos para segurança de dados.
![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/dtos.png?raw=true)

![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/dtoClientForm.png?raw=true)

    Exibe apenas para o usuário dados necessários para o preenchimento do formulário, assim fortalecendo a segurança da aplicação. 

### Entity: Entidades do projeto
![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/entidades%20criadas.png?raw=true)

### Enums: Mensagem customizada de duplicação de Cpf e Email
![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/duplicatedDocumentAndEmail.png?raw=true)
### Exception: Tratamento das exceptions da aplicação
![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/exceptions.png?raw=true)

### Mapper: Mapeamento de objeto para um DTO.
![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/mapper.png?raw=true)
### Repository: Armazenamento dos dados enviados pelo usuário.
![alt text](https://github.com/luizfelipebraga/SpringBankProject/blob/testBranch/img/repositories.png?raw=true)

### Visualização mais ampla do projeto: [Spring Bank Repository][luizfelipebraga] no GitHub.


   [luizfelipebraga]: <https://github.com/luizfelipebraga/SpringBankProject>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>
   [Docker]: <http://docker.com>
   [Dbeaver]: <http://Dbeaver.com>

