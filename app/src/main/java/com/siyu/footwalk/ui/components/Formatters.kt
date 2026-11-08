package com.siyu.footwalk.ui.components

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

private val esLocale: Locale = Locale.forLanguageTag("es-MX")

fun formatSteps(steps: Int): String = String.format(Locale.US, "%,d", steps).replace(',', '.')

fun formatKm(km: Double): String = String.format(Locale.US, "%.1f", km).replace('.', ',')

fun formatShortDate(date: LocalDate): String =
    date.format(DateTimeFormatter.ofPattern("d 'de' MMM", esLocale))

fun formatLongDate(date: LocalDate): String =
    date.format(DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM", esLocale))
        .replaceFirstChar { it.uppercase() }