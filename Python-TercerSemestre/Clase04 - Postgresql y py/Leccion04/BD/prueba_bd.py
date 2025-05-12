from logging import exception

import psycopg2 # esto esx para poder conectarnos a Postgre
conexion = psycopg2.connect(user="postgres",password="admin",host='127.0.0.1',port="5432",database='prueba_bd',)
try:
    with conexion:
        with conexion.cursor() as cursor:
            sentencia ='SELECT * FROM persona where id_persona = 1'
            cursor.execute(sentencia) # DE ESTA MANERA EJECUTAMOS LA SETENCIA
            registros = cursor.fetchall() # RECUPERAMOS TODOS LOS REGISTROS QUE SERAN UNA LISTA
            print(registros)

except Exception as e:
    print(f"Ocurrio un error{e}")
finally:
    conexion.close()
#https://www.psycopg.org/docs/usage.html
