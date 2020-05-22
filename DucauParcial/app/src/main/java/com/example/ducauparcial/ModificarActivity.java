package com.example.ducauparcial;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ModificarActivity extends AppCompatActivity
{
    private static ModificarActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        this.instance = this;

        ActionBar toolBar = getSupportActionBar();
        toolBar.setDisplayHomeAsUpEnabled(true);

        String nombre = (String)super.getIntent().getExtras().get("Producto");
        int cantidad = (int)super.getIntent().getExtras().get("Cantidad");
        double precio = (double)super.getIntent().getExtras().get("Precio");
        int posicion = (int)super.getIntent().getExtras().get("Posicion");

        Producto producto = new Producto(nombre, cantidad, precio);
        ProductoController controller = new ProductoController(producto, posicion);
        ProductoView view = new ProductoView(this, controller);
        controller.setView(view);
    }

    public static ModificarActivity getInstance()
    {
        return instance;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m)
    {
        super.getMenuInflater().inflate(R.menu.menu, m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            super.finish();
        }

        return false;
    }



}
