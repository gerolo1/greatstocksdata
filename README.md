# GreatStocksData

## Resume

API created with Java and Spring framework, and implementations of Spring Data JPA, Hibernate, Spring Security, JWT, and more.

¿Which stocks in the market are more growing? This API could helps

With support of Alphavantage

## Documentation

### Stocks - Bests

#### POST /stocks/bests

Top 10 best growing stocks

HEADERS:
```json
{
  "apiKey": "SJT9SMAZS4I2HWVF",
  "Authentication": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJob2xhIiwiaWF0IjoxNzQyNDAyMzgzLCJleHAiOjE3NDI0MDU5ODN9.BarpUEJDn2tWhxPclPqou_QL5Z1zQllEPbByZ_MQqV4"
}
```

RESPONSE:
```json
{
  [
    {
      "symbol": "",
      "name": "",
      "type": "",
      "description": "",
      "exchange": "",
      "currency": "",
      "country": ""
      "industry": "",
      "changePercentage": "",
      "price": "",
      "dividendPerShare": ""
    } (...)
  ] 
}
```

apiKey (from https://www.alphavantage.co/support/#api-key)

### Stocks - Worsts

#### POST /stocks/bests

Top 10 worst growing stocks

HEADERS:
```json
{
  "apiKey": "SJT9SMAZS4I2HWVF",
  "Authentication": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJob2xhIiwiaWF0IjoxNzQyNDAyMzgzLCJleHAiOjE3NDI0MDU5ODN9.BarpUEJDn2tWhxPclPqou_QL5Z1zQllEPbByZ_MQqV4"
}
```

RESPONSE:
```json
{
  [
    {
      "symbol": "",
      "name": "",
      "type": "",
      "description": "",
      "exchange": "",
      "currency": "",
      "country": ""
      "industry": "",
      "changePercentage": "",
      "price": "",
      "dividendPerShare": ""
    } (...)
  ] 
}
```

### Customer - Login

#### POST /customer/login

PAYLOAD:
```json
{
  "username": "Clara",
  "password": "claraclara123"
}
```

RESPONSE:
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJob2xhIiwiaWF0IjoxNzQyNDAyMzgzLCJleHAiOjE3NDI0MDU5ODN9.BarpUEJDn2tWhxPclPqou_QL5Z1zQllEPbByZ_MQqV4"
}
```

### Customer - Register

#### POST /customer/register

PAYLOAD:
```json
{
  "username": "Clara",
  "password": "claraclara123"
}
```

RESPONSE:
```json
{
    "message": "User created successfully"
}
```
