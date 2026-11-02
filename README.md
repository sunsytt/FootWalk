# FootWalk

FootWalk es una app Android de seguimiento de actividad física orientada al conteo de pasos. Permite registrar caminatas (pasos, distancia y duración), consultar el avance del día frente a una meta diaria y administrar el historial desde el celular.


## ¿Qué hace?

- **Registro de caminatas.** Cada caminata guarda nombre, fecha, pasos, distancia, duración y notas.
- **Resumen de "Pasos de hoy".** Suma las caminatas del día y muestra los pasos, los kilómetros, los minutos activos y el porcentaje frente a una meta diaria fija de 10,000 pasos.
- **CRUD completo.** Crear, consultar, editar y eliminar caminatas; el borrado pide confirmación.
- **Distancia estimada.** Si no se captura la distancia, el servidor la calcula a partir de los pasos con una zancada de 0.72 m.
- **Cuentas de usuario.** Registro e inicio de sesión; cada usuario solo puede ver y modificar sus propias caminatas.

## Tecnologías

**App Android**
- Kotlin
- Jetpack Compose
- Retrofit para consumir la API

**Backend**
- Node.js con Express y TypeScript
- Prisma ORM
- MySQL

## Cómo ejecutar el backend

```bash
npm install
npx prisma migrate dev
npm run dev
```

Antes de iniciar, configura la conexión a MySQL en las variables de entorno del proyecto.

## Cómo ejecutar la app

1. Abre el proyecto en Android Studio.
2. Espera a que Gradle sincronice.
3. Ejecuta la app en un emulador o dispositivo con el backend en marcha.
