resultado = None


try:
    a = int(input("Introduce el primer numero: "))
    b = int(input("Introduce el segundo numero: "))
    resultado = a / b  #modificamos
except TypeError as e:
    print(f"TypeError - Ocurrio un error {type(e)}")
except ZeroDivisionError as e:
    print(f"ZeroDivisionError - Ocurrio un error: {type(e)}")
except Exception as e:
    print(F"Excepcion - Ocurrio un error : {type(e)}")

print(f"Resultado es: {resultado}")
print("seguimos . . .")