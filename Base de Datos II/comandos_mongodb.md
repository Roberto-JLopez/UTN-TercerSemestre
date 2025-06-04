
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

## 🚀 CONSEJO FINAL

Practicar es la mejor forma de aprender. Probá todos estos comandos en MongoDB Compass o en la terminal con `mongosh`.
