FiapShop
MicroServiço Usuários do projeto FiapShop Pós-Fiap 5a fase



#### &emsp;&emsp; Cadastro Um novo usuário

```shell
curl -i -X POST "http://localhost:8082/auth/register" \
     -H "Content-Type:application/json" \
     -d '{"login": "usuario_novo",
          "role": "ADMIN",
          "password": "1234"
        }'
```

#### &emsp;&emsp; Faz o Login e gera Token de acesso

```shell
curl -i -X POST "http://localhost:8082/auth/login" \
     -H "Content-Type:application/json" \
     -d '{ "login": "usuario_novo",
           "password": "1234"
        }'
```

#### &emsp;&emsp; Quatro comandos para cadastrar três nós itens

```shell
curl -i -X POST "http://localhost:8081/api/itens" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" \
     -d '{"nome": "brinquedo 1",
          "valor": "10,00",
          "estoque": "10"
        }'
```

```shell
curl -i -X POST "http://localhost:8081/api/itens" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" \
     -d '{"nome": "brinquedo 2",
          "valor": "20,00",
          "estoque": "20"
        }'
```
```shell
curl -i -X POST "http://localhost:8081/api/itens" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" \
     -d '{"nome": "brinquedo 3",
          "valor": "30,00",
          "estoque": "30"
        }'
```
```shell
curl -i -X POST "http://localhost:8081/api/itens" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" \
     -d '{"nome": "brinquedo 4",
          "valor": "40,00",
          "estoque": "40"
        }'
```

#### &emsp;&emsp; Lista todos os itens cadastrados

```shell
curl -i -X GET "http://localhost:8081/api/itens" \
     -H "Content-Type:application/json"
```

#### &emsp;&emsp; Pega Itens por Id

```shell
curl -i -X GET "http://localhost:8081/api/itens/4" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" 
```

#### &emsp;&emsp; Pega Itens por Nome

```shell
curl -i -X GET "http://localhost:8081/api/itens/nome/brinquedo%204" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" 
```

#### &emsp;&emsp; Deleta Itens por Id

```shell
curl -i -X DELETE "http://localhost:8081/api/itens/4" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" 
```

#### &emsp;&emsp; Soma estoque a um item

```shell
curl -i -X PUT "http://localhost:8081/api/itens/3/10" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" 
```

#### &emsp;&emsp; Três comandos que Adicionam itens no carrinho

```shell
curl -i -X POST "http://localhost:8080/api/carrinho" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" \
     -d '{"id_usuario": 2,
          "id_itens": 1,
          "quantidade": "1"
        }'
```
```shell
curl -i -X POST "http://localhost:8080/api/carrinho" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" \
     -d '{"id_usuario": 2,
          "id_itens": 2,
          "quantidade": "2"
        }'
```
```shell
curl -i -X POST "http://localhost:8080/api/carrinho" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" \
     -d '{"id_usuario": 2,
          "id_itens": 3,
          "quantidade": "3"
        }'
```

#### &emsp;&emsp; Lista os itens no carrinho do usuário

```shell
curl -i -X GET "http://localhost:8080/api/carrinho/2" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw"
```

#### &emsp;&emsp; Deleta um item do carrinho do cliente

```shell
curl -i -X DELETE "http://localhost:8080/api/carrinho" \
     -H "Content-Type:application/json" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzdWFyaW9fbm92byIsImV4cCI6MTcxMDk4NDA0Mn0.Da-fNhX8wuEKw2Niz6LQBCLOY8eKe7whNx6JCdWFVsw" \
     -d '{"id_usuario": 2,
          "id_itens": 1
         }'
```