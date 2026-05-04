package com.example;

import java.text.NumberFormat.Style;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;



public class App {
    public static void main(String[] args) {

    	/*
    	 * Los objetos LocalDate son inmutables. With es lo más parecido a un setter.
    	 * builder es un método Factory
    	 * LocalDate lo es también
    	 * https://docs.oracle.com/javase/tutorial/datetime/overview/naming.html
    	 * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/temporal/TemporalAdjusters.html
    	 * */
    	
    	LocalDate hoy = LocalDate.now();
    	LocalDate fechaNacimiento = LocalDate.of(1977,Month.OCTOBER,19);
    	System.out.println("Hoy es: " + hoy);
    	System.out.println("Fecha nómina mayo: " + hoy.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2));
    	System.out.println("Hoy es: " + hoy);  // hoy no cambia
    	System.out.println("próximo cumple: " + fechaNacimiento.plusYears(49));
    	
    	Locale local = Locale.getDefault();
    	Locale england = Locale.of("en", "UK");
    	Locale japon = Locale.of("ja", "JP");
    	Locale italia = Locale.ITALY;
    	DayOfWeek diaSemana = fechaNacimiento.getDayOfWeek();
    	System.out.println(diaSemana);
    	System.out.println(diaSemana.getDisplayName(TextStyle.FULL, local).toUpperCase());
    	System.out.println(diaSemana.getDisplayName(TextStyle.FULL, england));
    	
    	// nombre del mes en español:
    	System.out.println(fechaNacimiento.getMonth().getDisplayName(TextStyle.FULL, italia));
    	
    	/*Calcular los años transcurridos entre dos fechas: mi cumple y la fecha actual*/
    	System.out.println(ChronoUnit.YEARS.between(fechaNacimiento, hoy));
    	
    	
    	
    	// https://docs.oracle.com/javase/tutorial/datetime/iso/period.html
    	System.out.println(Period.between(fechaNacimiento, hoy).getDays());
    	
    }
}
