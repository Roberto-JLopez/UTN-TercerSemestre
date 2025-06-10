
# Guía de Comandos de MongoDB para 

Esta guía está pensada para ayudarte a comenzar a usar MongoDB desde cero, explicando paso a paso los comandos más importantes, desde los más básicos hasta los más avanzados.

---

## 🟢 CONEXIÓN Y ENTORNO

### `mongod`

### `mongosh`
Abre la consola interactiva de MongoDB. Es donde vas a escribir todos los comandos.

```bash
mongosh
```

---

## 📁 BASES DE DATOS

### `show dbs`
Muestra todas las bases de datos disponibles.

### `use nombreDB`
Cambia a la base de datos llamada `nombreDB`. Si no existe, la crea cuando agregues datos.

```bash
use tienda
```

### `db`
Muestra en qué base de datos estás trabajando.

---

## 📦 COLECCIONES (como las "tablas" en SQL)

### `show collections`
Muestra todas las colecciones de la base actual.

### `db.createCollection("nombreColeccion")`
Crea una nueva colección.

```bash
db.createCollection("productos")
```

---

## 📝 INSERTAR DOCUMENTOS

### `db.coleccion.insertOne({})`
Inserta un solo documento.

```bash
db.productos.insertOne({ nombre: "Pan", precio: 100 })
```

### `db.coleccion.insertMany([{}, {}])`
Inserta varios documentos.

```bash
db.productos.insertMany([
  { nombre: "Leche", precio: 200 },
  { nombre: "Queso", precio: 500 }
])
```

---

## 🔍 CONSULTAR DOCUMENTOS

### `db.coleccion.find()`
Muestra todos los documentos.

```bash
db.productos.find()
```

### `db.coleccion.find({ campo: valor })`
Muestra solo los que cumplen una condición.

```bash
db.productos.find({ nombre: "Pan" })
```

### `db.coleccion.find().pretty()`
Muestra los documentos con formato bonito.

---

## ✏️ ACTUALIZAR DOCUMENTOS

### `db.coleccion.updateOne({filtro}, {$set: {cambios}})`
Actualiza el primer documento que cumpla el filtro.

```bash
db.productos.updateOne(
  { nombre: "Pan" },
  { $set: { precio: 120 } }
)
```

### `db.coleccion.updateMany({filtro}, {$set: {cambios}})`
Actualiza todos los que cumplan el filtro.

---

## ❌ ELIMINAR DOCUMENTOS

### `db.coleccion.deleteOne({ campo: valor })`
Elimina el primer documento que cumpla la condición.

### `db.coleccion.deleteMany({ campo: valor })`
Elimina todos los documentos que cumplan la condición.

---

## ❌ remove() (Forma antigua de eliminar documentos)
⚠️ Nota: Este método está en desuso y fue reemplazado por deleteOne() y deleteMany() en versiones más recientes. Sin embargo, aún puede funcionar en algunas versiones de MongoDB.

### `db.coleccion.remove({ campo: valor })`
Elimina todos los documentos que cumplan con la condición.
```bash
db.productos.remove({ nombre: "Pan" })
  
```
### `db.coleccion.remove({ campo: valor }, true)`
Elimina solo el primer documento que cumpla la condición (el segundo parámetro true indica que solo se elimine uno).
```bash
db.productos.remove({ nombre: "Pan" }, true)  

```


## 🔍 FILTRAR CON OPERADORES

- `$gt`: mayor que
- `$lt`: menor que
- `$gte`: mayor o igual
- `$lte`: menor o igual
- `$ne`: distinto

```bash
db.productos.find({ precio: { $gt: 150 } })
```

---

## 📊 AGREGACIONES (más avanzado)

### `db.coleccion.aggregate([ ... ])`
Permite realizar operaciones más complejas, como contar, agrupar o promediar.

```bash
db.productos.aggregate([
  { $group: { _id: null, precioPromedio: { $avg: "$precio" } } }
])
```

---

## 🧠 ÍNDICES (mejora la velocidad de búsqueda)

### `db.coleccion.createIndex({ campo: 1 })`
Crea un índice ascendente en un campo.

```bash
db.productos.createIndex({ nombre: 1 })
```

---

## 🧼 BORRAR COLECCIONES Y BASES

### `db.coleccion.drop()`
Elimina toda la colección.

### `db.dropDatabase()`
Elimina la base de datos actual.

---

## 🧪 COMANDOS ÚTILES EXTRA

### `db.coleccion.countDocuments()`
Cuenta cuántos documentos hay.

### `db.coleccion.findOne()`
Muestra solo un documento.

### `db.coleccion.distinct("campo")`
Muestra los valores únicos de un campo.

---

# 📘 Guía de Comandos Básicos de MongoDB

Esta guía contiene los comandos y métodos de MongoDB utilizados para interactuar con bases de datos y colecciones, incluyendo operaciones de inserción, consulta y eliminación.

---

## 🗂️ **1. Gestión de Bases de Datos y Colecciones**

### 🔹 **1.1. Seleccionar o Crear una Base de Datos**

Para trabajar con una base de datos específica o crear una nueva:

```javascript
use <nombre_de_la_base_de_datos>
```

**Ejemplo:**

```javascript
use mi_nueva_base_de_datos
```

---

### 🔹 **1.2. Eliminar la Base de Datos Actual**

Este comando elimina la base de datos en la que te encuentras actualmente. ¡Úsalo con precaución!

```javascript
db.dropDatabase()
```

**Ejemplo:**

```javascript
// Si estás en mi_nueva_base_de_datos, este comando la eliminará.
```

---

## 📁 **2. Operaciones con Colecciones**

### ✏️ **2.1. Insertar Documentos**

#### a) Insertar Múltiples Documentos (insertMany)

Permite insertar varios documentos en una colección en una sola operación. Si la colección no existe, MongoDB la creará.

```javascript
db.<nombre_de_la_coleccion>.insertMany([
  { <campo1>: <valor1>, <campo2>: <valor2> },
  { <campo1>: <valorA>, <campo2>: <valorB> }
])
```

**Ejemplo:**

```javascript
db.logico_uno.insertMany([
  {"nombre": "registro1", "cantidad": 40},
  {"nombre": "registro2", "cantidad": 10},
  {"nombre": "registro3", "cantidad": 60}
])
```

---

### 🔍 **2.2. Consultar Documentos (find)**

#### a) Mostrar Todos los Documentos

```javascript
db.<nombre_de_la_coleccion>.find({})
```

**Ejemplo:**

```javascript
db.logico_uno.find({})
```

Para una salida más legible (formato JSON prettified):

```javascript
db.<nombre_de_la_coleccion>.find({}).pretty()
```

**Ejemplo:**

```javascript
db.mis_usuarios.find({}).pretty()
```

#### b) Mostrar Solo Un Documento (findOne)

```javascript
db.<nombre_de_la_coleccion>.findOne()
```

**Ejemplo:**

```javascript
db.mis_usuarios.findOne()
```

#### c) Consultar Documentos por Criterio Específico

```javascript
db.<nombre_de_la_coleccion>.find({ <campo>: <valor> })
```

**Ejemplo:**

```javascript
db.mis_usuarios.find({"nombre_usuario": "usuario_c"})
```

---

### ⚙️ **2.3. Operadores Lógicos de Consulta**

#### a) $gte (Greater Than or Equal - Mayor o Igual que)

```javascript
db.<nombre_de_la_coleccion>.find({ <campo>: { "$gte": <valor> }})
```

**Ejemplo:**

```javascript
db.logico_uno.find({"cantidad": {"$gte": 20}})
```

#### b) $gt (Greater Than - Mayor que)

```javascript
db.<nombre_de_la_coleccion>.find({ <campo>: { "$gt": <valor> }})
```

**Ejemplo:**

```javascript
db.logico_dos.find({"edad": {"$gt": 20}})
```

#### c) $lt (Less Than - Menor que)

```javascript
db.<nombre_de_la_coleccion>.find({ <campo>: { "$lt": <valor> }})
```

**Ejemplo:**

```javascript
db.logico_dos.find({"edad": {"$lt": 40}})
```

#### d) $lte (Less Than or Equal - Menor o Igual que)

```javascript
db.<nombre_de_la_coleccion>.find({ <campo>: { "$lte": <valor> }})
```

**Ejemplo:**

```javascript
db.logico_tres.find({"visitas": {"$lte": 4000}})
```

#### e) Combinando Operadores Lógicos (AND implícito)

```javascript
db.<nombre_de_la_coleccion>.find({ <campo>: { "<operador1>": <valor1>, "<operador2>": <valor2> }})
```

**Ejemplo:**

```javascript
db.logico_dos.find({"edad": {"$gt": 20, "$lt": 40}})
```

```javascript
db.logico_tres.find({"visitas": {"$gt": 2000, "$lte": 4000}})
```

---

### 🛠️ **2.4. Comandos Útiles Extra**

#### a) Contar Documentos (countDocuments)

```javascript
db.<nombre_de_la_coleccion>.countDocuments({ <filtro_opcional> })
```

**Ejemplo:**

```javascript
db.mis_usuarios.countDocuments({})
db.registro_clientes.countDocuments({"edad": 30})
```

#### b) Obtener Valores Únicos de un Campo (distinct)

```javascript
db.<nombre_de_la_coleccion>.distinct("<nombre_del_campo>")
```

**Ejemplo:**

```javascript
db.autos.distinct("marca")
```

Descripción: Recupera todas las marcas únicas de vehículos en la colección `autos`.





## 🚀 CONSEJO FINAL

Practicar es la mejor forma de aprender. Probá todos estos comandos en MongoDB Compass o en la terminal con `mongosh`.


