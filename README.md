## Lobster API

Setup:

`./mvnw spring-boot:run` or `mvnw.cmd sprint-boot:run`

Test:

`curl -X GET /lobster`

### Grouped Retrieval

```GET /lobster```

Lists lobsters of all types (clawed and spiny).

---

```GET /lobster/clawed```

Lists all clawed lobsters.

---

```GET /lobster/spiny```

Lists all spiny lobsters.

---

### Spiny Lobster API

Example `SpinyLobster` JSON payload:

```json
{
  "name": "Green Lobster",
  "spineCount": 6 
}
```

---

```POST /lobster/spiny```

Create a new spiny lobster entry (JSON payload).

---
 
```GET /lobster/spiny/<id>```

Get a spiny lobster entry by ID.

---

```PUT /lobster/spiny/<id>```

Update a spiny lobster entry by ID (JSON payload).

---

```DELETE /lobster/spiny/<id>```

Delete a spiny lobster entry by ID.
 
### Clawed Lobster API

Example `ClawedLobster` JSON payload:

```json
{
  "name": "Green Lobster"
}
```

---

```POST /lobster/clawed```

Create a new clawed lobster (JSON payload).

---

```GET /lobster/clawed/<id>```

Get a clawed lobster entry by ID.

---
 
```PUT /lobster/clawed/<id>```

Update a clawed lobster entry by ID (JSON payload)

---

```DELETE /lobster/clawed/<id>```

Delete a clawed lobster entry by ID.