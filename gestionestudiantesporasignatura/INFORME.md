# INFORME - SISTEMA DE GESTION DE ESTUDIANTES

# INFORME - SISTEMA DE GESTION DE ESTUDIANTES

Materia: Estructura de Datos
Fecha: Febrero 2026
Lenguaje: Java

DESCRIPCION
Sistema para gestionar estudiantes, grupos y calificaciones por asignatura utilizando programacion orientada a objetos.

CLASES PRINCIPALES
Persona (clase base), Estudiante (hereda de Persona), Grupo, Asignatura, SistemaGestion, OperationResult

FUNCIONALIDADES
- Crear asignaturas y grupos
- Agregar estudiantes (presenciales o a distancia)
- Registrar calificaciones (0-100)
- Mostrar listados con promedios
- Calcular porcentaje de aprobados (nota >= 70)
- Todo almacenado en arrays sin base de datos

CONCEPTOS POO APLICADOS
- Herencia: Estudiante extends Persona
- Polimorfismo: metodos sobreescritos con @Override
- Encapsulamiento: atributos privados con getters/setters
- Abstraccion: separacion de responsabilidades por clase

EJECUCION
Sistema interactivo: java gestionestudiantesporasignatura.SistemaGestion
Demostracion: java gestionestudiantesporasignatura.DatosEjemplo
