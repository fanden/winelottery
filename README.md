# Caseoppgave Experis - Fagsamtale 13. Januar 2025

Dette prosjektet er gjennomført som forarbeid til en fagsamtale hos Experis

## Endepunkter

### Lotteries (/api/v1/lotteries)

/create (GET)
 Oppretter et nytt lotteri
**Eksempel**
 `/api/v1/lotteries/create`

/current (GET)
Returnerer nyeste aktive lotteri
**Eksempel**
`/api/v1/lotteries/current`
### Wines (/ap1/v1/wines)

/add/{lotteryid} (POST)
Legger til en liste viner til et lotteri
**Eksempel**
`/api/v1/wines/add/0`

JSON body:
```json
{
  [
    {
      "id": 1,
      "name": "Château Margaux 2015",
      "price": 300,
      "lotteryId": 0
    },
    {
      "id": 2,
      "name": "Opus One 2018",
      "price": 250,
      "lotteryId": 0
    },
    {
      "id": 3,
      "name": "Penfolds Grange 2017",
      "price": 200,
      "lotteryId": 0
    },
    {
      "id": 4,
      "name": "Sassicaia 2016",
      "price": 150,
      "lotteryId": 0
    },
    {
      "id": 5,
      "name": "Dom Pérignon 2010",
      "price": 100,
      "lotteryId": 0
    }
  ]
}
```

/{lotteryid} (GET)
Returnerer vinlisten for et vilkårelig lotteri
**Eksempel**
`/api/v1/wines/0`

### User (/api/v1/users)

/create (POST)
Oppretter en ny bruker med gitt navn og telefonnmmer
**Eksempel**
`/api/v1/users/create`

JSON body:
```` json
{
    "name": "Johannes",
    "phone": "+180808080"
}
````

