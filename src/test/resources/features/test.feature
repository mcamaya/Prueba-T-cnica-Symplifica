#language: es
Característica: Default

  Escenario: Añadir tarea completada
    Dado el usuario abre la aplicación Task Manager
    Cuando añade a una nueva tarea el siguiente título "Test Titulo"
    Y añade a una nueva tarea la siguiente descripción "Test Descripción111"
    Y confirma el checkbox Completed Task
    Entonces hace clic en el botón Add Task
    Y verifica dentro de la lista de tareas, existe el valor "Completed"

  Escenario: Añadir tarea sin completar
    Dado el usuario abre la aplicación Task Manager
    Cuando añade a una nueva tarea el siguiente título "Test Titulo"
    Y añade a una nueva tarea la siguiente descripción "Test Descripción111"
    Entonces hace clic en el botón Add Task
    Y verifica dentro de la lista de tareas, existe el valor "Test Descripción111"

    Escenario: Eliminar tarea
      Dado el usuario abre la aplicación Task Manager
      Entonces elimina la tarea con el valor "Test Descripción111"