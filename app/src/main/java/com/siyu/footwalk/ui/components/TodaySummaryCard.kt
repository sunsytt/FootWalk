package com.siyu.footwalk.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.siyu.footwalk.model.TodaySummary
import com.siyu.footwalk.ui.components.ProgressRing
import com.siyu.footwalk.ui.components.formatKm
import com.siyu.footwalk.ui.components.formatSteps

@Composable
fun TodaySummaryCard(summary: TodaySummary, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
    ) {
        Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("Pasos de hoy", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(formatSteps(summary.steps), style = MaterialTheme.typography.displayLarge)
                Text(
                    "de ${formatSteps(summary.goalSteps)} pasos",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    "${formatKm(summary.distanceKm)} km  ·  ${summary.activeMinutes} min activos",
                    style = MaterialTheme.typography.labelLarge,
                )
            }
            ProgressRing(progress = summary.progress)
        }
    }
}