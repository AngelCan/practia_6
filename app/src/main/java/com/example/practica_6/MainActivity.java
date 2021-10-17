package com.example.practica_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.logging.Level;
import java.util.logging.Logger;



public class MainActivity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos los objetos
        Contador c1 = new Contador("Contador 1", 40);
        Contador c2 = new Contador("Contador 2", 50);
        Contador c3 = new Contador("Contador 3", 20);
        Contador c4 = new Contador("Contador 4", 70);

        //Creamos los hilos
       // Thread t1 = new Thread((Runnable) c1);
       // Thread t2 = new Thread((Runnable) c2);
       // Thread t3 = new Thread((Runnable) c3);
       // Thread t4 = new Thread((Runnable) c4);


        //Iniciamos los hilos
        c1.start();
        c2.start();
        c3.start();
        c4.start();

        //Esperamos a que acaben los hilos
        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Fin
        System.out.println("Fin del programa");


    }
}

class Contador extends Thread{
    private int contador;
    private String nombre;
    private int limite;

    public Contador(String nombre, int limite) {
        this.contador = 0;
        this.nombre = nombre;
        this.limite = limite;
    }
    public void run() {
        //Recorremos los numeros
        while (contador <= limite) {
            System.out.println("Hilo " + nombre + ": " + contador);
            contador++;
        }
    }

}

