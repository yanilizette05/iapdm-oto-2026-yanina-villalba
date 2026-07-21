package com.example.registroempleados.ui.theme


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.registroempleados.model.Empleado

@Composable
fun EmployeeItem(
    empleado: Empleado,
    onDelete: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Text(
                text = empleado.nombre,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(
                    listOf(
                        "Cargo: ${empleado.cargo}",
                        "Depto: ${empleado.departamento}",
                        "Salario: ${empleado.salario}",
                        "Fecha: ${empleado.fechaContratacion}"
                    )
                ) { dato ->

                    AssistChip(
                        onClick = {},
                        label = { Text(dato) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = onDelete
            ) {
                Text("Eliminar")
            }
        }
    }
}
