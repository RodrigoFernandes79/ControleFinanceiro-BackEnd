# ControleFinanceiro-BackEnd
Criando API Desafio Alura
##### #alurachallengeback2

# Projeto API JSON RESTfull 

 Desafio de uma aplicação de um cadastro de controle financeiro da Alura challenge back2
 ## Aplicação  em Camadas:

![AlicacaoCamadas](https://user-images.githubusercontent.com/83513696/139479915-43c64049-3370-4e32-8b83-914fa8ee9111.png)
### Usamos o padrão camadas separando a aplicação backend em três camadas: 
- Controladores Rest (Resource)
- Camada de Serviços (Service)
- Camada de Acesso a dados (Repository)
### Todas as três camadas conversam com as Entidades.

## Tecnologias utilizadas no Projeto:
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- PostgreSQL
- Heroku
- Insomnia 


## Aplicações  do Projeto:
- Permitir o cadastro Despesas e Receitas;
- Permitir atualização de dados de Despesas e Receitas;
- Permitir a exclusão de um lançamento de despesas e receitas;
- Exibir a informação de lançamentos de despesas e receitas passando como parâmetro a descrição;
- Exibir informações de lançamentos de receitas e despesas consultando por mês e ano;
- Exibir o total de receitas e despesas consultando o mês e ano;
- Exibir o saldo entre os lançamentos de despesas e receitas consultando o mês e ano;
- Exibir o total de despesas por categoria consultando o mês e ano;
- Exibir o total de despesas por categoria por cada mês;
- Exibir o total de despesas por tipo de despesa por cada mês;
- Exibir o total de receitas e despesas por cada mês;
- Exibir o total de receitas;
- Exibir o total de despesas;
- Exibir o saldo final;

## Endpoints das APIs no Swagger:
### Especificação das Entidades

![swagger5](https://user-images.githubusercontent.com/83513696/165858544-9349012f-f93c-4a21-963e-3fc7d89ae218.jpeg)
```
### Especificação da Entidade Receitas
```
![receitas](https://user-images.githubusercontent.com/83513696/165863404-d4aa781d-44c6-420c-9bea-928ef4b679ce.jpeg)
```
### Especificação da Entidade Despesas

```
![despesas](https://user-images.githubusercontent.com/83513696/165863427-a8ed3d4a-0a4f-484a-b065-81fb1496f66c.jpeg)

```
### Especificação da Entidade ReceitasDTO
```
![receitasDTO](https://user-images.githubusercontent.com/83513696/165863257-77233500-5547-4ee8-ac7d-2f87ad96bc71.jpeg)

```
### Especificação da Entidade DespesasDTO
```
![despesasDTO](https://user-images.githubusercontent.com/83513696/165863269-2653161a-2ca8-4aae-a72c-0152e4ab14fd.jpeg)

```
### Especificação da Entidade GastoCategoriaDTO
```
![gastocategoria](https://user-images.githubusercontent.com/83513696/165863282-a367140c-a6d9-454d-a5f9-58bffa74340d.jpeg)
```
### Especificação da Entidade GastoTipoDTO
```
![gastotipoDTO](https://user-images.githubusercontent.com/83513696/165863290-7946e83e-d9b6-4ca8-bd5f-4c732b3e9247.jpeg)
```
### Especificação da Entidade ResumoMêsDTO
```
![resumomesDTO](https://user-images.githubusercontent.com/83513696/165863294-f8974322-d840-4719-840b-947363b4c99b.jpeg)
```
### Especificação da Classe ReceitasController
```
![swagger 4](https://user-images.githubusercontent.com/83513696/165858537-5c75c2ee-cc59-42fa-84b0-6712ac07a60d.jpeg)
```
### Especificação da Classe DespesasController
```
![despesascontroller](https://user-images.githubusercontent.com/83513696/165865987-e14e70d5-ad04-4505-b490-1f5ce98aa3be.jpeg)
```
### Especificação da Classe ResumoMesDTOController
```
![resumomescontroller](https://user-images.githubusercontent.com/83513696/165866014-cd5a400e-9538-4921-98db-1b93f220d0c8.jpeg)
```
### Persistindo a classe Receitas no banco de dados PostgreSQL com integração com a API na nuvem através do Heroku
```
![Postgresql1jpeg](https://user-images.githubusercontent.com/83513696/165858552-1aed9b1a-7005-4420-ae4e-341211ca17e7.jpeg)
```
### Persistindo a classe Despesas no banco de dados PostgreSQL com integração com a API na nuvem através do Heroku
```
![postgresql2](https://user-images.githubusercontent.com/83513696/165858562-c9af2917-637a-4b12-a792-e9fe717532dc.jpeg)
```


# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```
bash
# clonar repositório
git clone https://github.com/RodrigoFernandes79/ControleFinanceiro-BackEnd

# executar o projeto
./mvnw spring-boot:run
```
# Autor

Rodrigo Holanda Fernandes

