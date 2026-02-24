
Servicio REST simple desarrollado con Spring Boot para el cálculo de facilidades de líneas de crédito.

## Descripción

Este proyecto expone un endpoint REST que recibe información de:
- Facilidad de línea de crédito del cliente
- Perfil de crédito
- Saldo de cuenta
- Factores de crédito

Y retorna un cálculo del margen de facilidad de crédito junto con metadatos de la transacción.

## Requisitos

- Java 11 o superior
- Maven 3.6 o superior

## Instalación

```bash
# Clonar el repositorio
git clone https://github.com/ErikOrtiz98/generador.git
cd generador

# Compilar el proyecto
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## Endpoint

### POST /api/credit-line/calculate

Calcula el margen de facilidad de crédito basado en los parámetros proporcionados.

**Request Example:**

```json
{
  "creditLineFacility": {
    "customerCreditLine": true,
    "minimumSalaryRequired": 12,
    "numberOfMinimumSalary": 23
  },
  "creditProfile": {
    "creditLine": 23123
  },
  "accountBalance": [
    {
      "accountBalance": 123.67,
      "accountBalanceType": "currentBalance"
    }
  ],
  "creditLineFactor": [
    {
      "factorItem": [
        {
          "factor": 12,
          "factorType": "creditLineCapFactor"
        }
      ]
    }
  ]
}
```

**Response Example:**

```json
{
  "meta": {
    "transactionID": "27d00424-85c2-45ba-b2b1-4a5f8e412201",
    "status": "OK",
    "statusCode": 200,
    "timestamp": "2021-08-02T16:53:30.234698200"
  },
  "data": {
    "creditLineFacility": {
      "creditFacilityAvailableAmount": 75600,
      "hasCreditFacility": false
    },
    "creditProfile": {
      "creditLine": 23231
    },
    "accountBalance": [
      {
        "accountBalance": 23123,
        "accountBalanceType": "currentBalance"
      }
    ]
  }
}
```

## Testing con cURL

```bash
curl -X POST http://localhost:8080/api/credit-line/calculate \
  -H "Content-Type: application/json" \
  -d '{
    "creditLineFacility": {
      "customerCreditLine": true,
      "minimumSalaryRequired": 12,
      "numberOfMinimumSalary": 23
    },
    "creditProfile": {
      "creditLine": 23123
    },
    "accountBalance": [
      {
        "accountBalance": 123.67,
        "accountBalanceType": "currentBalance"
      }
    ],
    "creditLineFactor": [
      {
        "factorItem": [
          {
            "factor": 12,
            "factorType": "creditLineCapFactor"
          }
        ]
      }
    ]
  }'
```

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/creditline/
│   │       ├── GeneradorApplication.java
│   │       ├── controller/
│   │       │   └── CreditLineController.java
│   │       ├── service/
│   │       │   └── CreditLineService.java
│   │       ├── model/
│   │       │   ├── CreditLineFacility.java
│   │       │   ├── CreditLineFacilityRequest.java
│   │       │   ├── CreditLineFacilityResponse.java
│   │       │   ├── CreditProfile.java
│   │       │   ├── AccountBalance.java
│   │       │   ├── CreditLineFactor.java
│   │       │   └── FactorItem.java
│   │       └── dto/
│   │           ├── ApiResponse.java
│   │           ├── ResponseMeta.java
│   │           └── ResponseData.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

## Tecnologías Utilizadas

- Spring Boot 2.7.14
- Java 11
- Maven
- Lombok
- Jackson

## Licencia

MIT

## Autor

ErikOrtiz98
