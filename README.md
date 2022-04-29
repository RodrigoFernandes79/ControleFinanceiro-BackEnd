# ControleFinanceiro-BackEnd
Criando API Desafio Alura
##### #alurachallengeback2

# Projeto API JSON RESTfull 

 Desafio de uma aplicação de um cadastro de controle financeiro da Alura challenge back2


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

#### Buscar os registros de veículos na base (GET):
```
#### Buscar os registros de veículos na base (GET):
```
http://localhost:8080/veiculos
```
![mostrarVeiculos](https://user-images.githubusercontent.com/83513696/139466908-a8075671-6334-4086-a566-51bb00af5d0d.png)

#### Buscar os registros da quatidade de veículos que não foram vendidos base (GET):
```
http://localhost:8080/veiculos/VeiculosNaoVendidos
```
![veiculosNaoVendidos](https://user-images.githubusercontent.com/83513696/139474141-b5155152-71af-4d89-9753-6e69780ccbd9.png)
#### Buscar informações do veiculo por ID (GET)
```
http://localhost:8080/veiculos/15
```
![mostrarVeiculoId](https://user-images.githubusercontent.com/83513696/139468973-1a6c8eb0-68b6-47d6-9ef2-89844aebc7be.png)
#### Cadastrar veiculo na base (POST)

- JSON da entrada de dados do veiculo
```
{
    "veiculo": "Palio",
    "marca":"Fiat",
    "ano":2004,
    "descricao":"Único Dono!",
    "vendido":true,
    "created":"2019-03-04T14:44:01.544+00:00"
}
```
```
http://localhost:8080/veiculos
```
![criarVeiculo](https://user-images.githubusercontent.com/83513696/139471554-33324eac-cf83-458f-8129-358a11a4c523.png)
#### Atualizar informações de veiculo (PUT)
```
http://localhost:8080/veiculos/1
```
- JSON da entrada de dados do veiculo 
```
{
   "veiculo": "Onix",
    "marca": "Chevrolet",
    "ano": 2016,
    "descricao":"Veículo em perfeito estado!",
    "vendido": false,
    "created": "2021-10-27T23:59:02Z",
    "updated": null
}
```
![criarVeiculo](https://user-images.githubusercontent.com/83513696/139470579-2daa80d9-71c8-42e4-8cfc-1df24722e92f.png)
#### Atualizar apenas se o veiculo foi vendido ou não (PATCH)
```
http://localhost:8080/veiculos/1
```
- JSON da entrada de dados para atualização. Neste endpoint apenas o atributo vendido pode ser alterado.
```
{
    "vendido":true	
}
```
![atualizarRestricoes](https://user-images.githubusercontent.com/83513696/139472252-d446806e-2007-43ad-a896-8218b0ae5a1a.png)
#### Deletar o veiculo registrado na base (DELETE)
```
http://localhost:8080/veiculos/20
```
![deletarPorId](https://user-images.githubusercontent.com/83513696/139472966-a863c66d-30c4-4b25-b3a0-9fb8c62c0965.png)
## Aplicação persistida no Banco de Dados MySql:
![tabelaVeiculo](https://user-images.githubusercontent.com/83513696/139478268-76668486-a02f-49dc-9deb-ae03df574919.png)

## Aplicação  em Camadas:

![AlicacaoCamadas](https://user-images.githubusercontent.com/83513696/139479915-43c64049-3370-4e32-8b83-914fa8ee9111.png)
### Usamos o padrão camadas separando a aplicação backend em três camadas: 
- Controladores Rest (Resource)
- Camada de Serviços (Service)
- Camada de Acesso a dados (Repository)
### Todas as três camadas conversam com a Entidade Veiculo.



# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/RodrigoFernandes79/TinnovaDesafio-Backend.git

# executar o projeto
./mvnw spring-boot:run
```
# Autor

Rodrigo Holanda Fernandes

