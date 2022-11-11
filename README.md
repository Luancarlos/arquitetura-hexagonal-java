# API CALCULA JUROS BOLETO

## PROBLEMA:
**ENQUANTO** usuário da API

**QUERO** digitar um código de boleto vencido

**E** quero receber o valor do juros.


## Requisitos Funcionais
- Desenvolver um API
- Incluir um código de boleto válido
- O Boleto deve estar vencido
- Apenas boletos do tipo XPTO podem ser calculados
- Para receber as informações do boleto, consumir a API de Boletos
- Em caso de erro, devolver o motivo do erro
- A definição dos juros de boleto bancário ocorre considerando os dias de atraso, de maneira proporcional.
    - Taxa de juros de 1% ao mes ou 1 / 30 = 0,033% ao dia
- O valor final do boleto deve ser:
  - Valor do boleto +  valor dos juros em atraso
- Salvar em um **banco de dados** todos os cálculos realizados

Request →
```json
{
  "codigo": "string",
  "data_pagamento": "YYY-MM-DD HH:MM:SS"
}
```

Response →
```json
{
  "codigo": "string",
  "data_vencimento": "YYYY-MM-DD",
  "valor": 00.0,
  "tipo": "XPTO|NORMAL"
}
```

<br>
<br>
<br>


# Ferramentas

- Intellij
- Spring boot
- Docker
- Docker-compose
- Swagger
- Spring JPA
- Mysql
- Feign Client
- Map Struct

