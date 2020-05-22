package com.example.ducauparcial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;
    public static List<String> data;
    public static List<Producto> productos;
    public static ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.instance = this;

        ActionBar toolBar = getSupportActionBar();
        toolBar.setDisplayHomeAsUpEnabled(true);

        this.productos = new ArrayList<Producto>();

        productos.add(new Producto("Coca", 20, 45.10));
        productos.add(new Producto("Turron", 45, 70.0));
        productos.add(new Producto("Papa", 19, 20.0));
        productos.add(new Producto("Ajo", 82, 15.75));
        productos.add(new Producto("Sopa", 42, 58.0));
        productos.add(new Producto("Fideos", 74, 70.25));
        productos.add(new Producto("Pure", 96, 30.50));
        productos.add(new Producto("Pepsi", 25, 40.0));
        productos.add(new Producto("Zanahoria", 11, 15.10));
        productos.add(new Producto("Caramelo", 41, 5.50));
        productos.add(new Producto("Chocolate", 7, 25.0));
        productos.add(new Producto("Chupetin", 70, 15.0));

        this.adapter = new ProductoAdapter(productos);

        final RecyclerView rvProducto = super.findViewById(R.id.rvProductos);

        adapter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.getInstance(), ModificarActivity.class);
                intent.putExtra("Producto",productos.get(rvProducto.getChildAdapterPosition(view)).getNombre());
                intent.putExtra("Cantidad",productos.get(rvProducto.getChildAdapterPosition(view)).getCantidad());
                intent.putExtra("Precio", productos.get(rvProducto.getChildAdapterPosition(view)).getPrecio());
                intent.putExtra("Posicion", rvProducto.getChildAdapterPosition(view));
                Log.d("Posicion", rvProducto.getChildAdapterPosition(view) + "");
                startActivityForResult(intent, 1);
            }
        });

        rvProducto.setAdapter(adapter);

        rvProducto.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        this.data = new ArrayList<>();
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == 2) {
                this.data.add(data.getStringExtra("Producto"));
                this.data.add(data.getStringExtra("Cantidad"));
                this.data.add(data.getStringExtra("Precio"));
                this.data.add(data.getStringExtra("Posicion"));

                Log.d("Entra", this.data.get(3));

                Producto p = new Producto(this.data.get(0), Integer.parseInt(this.data.get(1)), Double.parseDouble(this.data.get(2)));
                this.productos.set(Integer.parseInt(this.data.get(3)), p);

                //this.adapter.notifyItemChanged(Integer.parseInt(this.data.get(3)));
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    public static MainActivity getInstance()
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
