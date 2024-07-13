# user API Spek

## Register User

Endpoint : POST /api/users

Request Body :

```json
{
"username" : "aligufron",
"password" : "123456",
"surel" : " Perkenalkan nama saya Ali Gufron, lahir di Bangkalan"
}
```
Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed) :

```json
{
  "errors" : "Username must not blank, ???"
  
}
```
Validasi data :
Nama pengguna (Username) harus unik



Response Body (Failed, 401) :

## Login User

Endpoint : POST /api/auth/login

Request Body :

```json
{
"username" : "aligufron",
"password" : "123456"
}
```
Response Body (Success) :

```json
{
  "data" : "TOKEN",
  "expiredAt" : 234234234423 // milliseconds
}
```

Response Body (Failed, 401) :

```json
{
  "errors" : "Username or password wrong"
  
}
```
## Get User
Endpoint : GET /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandotory)

Response Body (Success) :

```json
{
  "data" : {
    "username" : "aligufron",
    "surel" : "Perkenalkan nama saya Ali Gufron, lahir di Bangkalan"
  }
}
```



```json
{
  "errors" : "Unauthorized"
  
}
```
## Logout

Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN : Token (Mandotory)

Response Body (Success) :

```json
{
  "data" : "OK"
}
```