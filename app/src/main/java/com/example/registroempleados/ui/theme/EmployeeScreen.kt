package com.example.registroempleados.ui.theme


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.registroempleados.model.Empleado

@Composable
fun EmployeeScreen() {

    var nombre by remember { mutableStateOf("") }
    var cargo by remember { mutableStateOf("") }
    var departamento by remember { mutableStateOf("") }
    var salario by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }

    val empleados = remember {
        mutableStateListOf<Empleado>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre Completo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = cargo,
            onValueChange = { cargo = it },
            label = { Text("Cargo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = departamento,
            onValueChange = { departamento = it },
            label = { Text("Departamento") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = salario,
            onValueChange = { salario = it },
            label = { Text("Salario") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha de Contratación") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                if(nombre.isNotBlank()) {

                    empleados.add(
                        Empleado(
                            nombre,
                            cargo,
                            departamento,
                            salario,
                            fecha
                        )
                    )

                    nombre = ""
                    cargo = ""
                    departamento = ""
                    salario = ""
                    fecha = ""
                }
            }
        ) {
            Text("Registrar Empleado")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(empleados) { empleado ->

                EmployeeItem(
                    empleado = empleado,
                    onDelete = {
                        empleados.remove(empleado)
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
