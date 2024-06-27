# Desafio técnico da Mobiauto - Sistema de Revendas de Veículos

Desafio proposto para a vaga de desenvolvedor backend na empresa Mobiauto. trata-se de um sistema de gerenciamento de revendas de veículos simplificado,com operaçãoes imputadas e automaticas.



## Requisitos técnicos do sistema
os requissitos tecnicos encontram-se descritos em **/resources/descricaoDesafio.txt para maiores detalhes
## Como testar a aplicação:

- Faça o clone do repositório na sua máquina, indicado o uso de SSL no github
- Certifique de ter o docker instalado na maquina
- com o projeto ja aberto na IDE de sua preferencia execute mvn clean install -DskipTests no terminal
- Execute o comando docker-compose up --build para buildar e subir o contêiner logo em seguida.
- 
## Especificações técnicas:

- **Versão do Java:** Java 17
- **Versão do Spring Boot:** 3.2.4
- **Gerenciador de dependências:** Maven
- **Banco de dados:** MySql

## Considerações:

- ** Para autenticar no enpoint utilizar como email : fulano#gmail.com e senha 123456
- ** Acesse o Swagger da aplicação em http://localhost:8080/swagger-ui/index.html
- não será preciso alterar variaveis de ambiente para o funcionamento da aplicação
