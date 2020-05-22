package com.example.ducauparcial;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ProductoController implements View.OnClickListener
{
    Activity activity;
    ProductoView productoView;
    Producto producto;
    int posicion;

    public ProductoController(Producto producto, int posicion)
    {
        this.producto = producto;
        this.posicion = posicion;
    }

    public void setView(ProductoView productoView)
    {
        this.productoView = productoView;
        this.productoView.cargarViews();
        this.productoView.pasarDatos();
    }

    @Override
    public void onClick(View v)
    {
        boolean ok = this.productoView.cargarModelo();

        Log.d("click", producto.getNombre() + producto.getCantidad() + producto.getPrecio() + posicion);
        if(ok)
        {
            //Aca iria lo de llevarlo a la otra pagina

            Intent intent = new Intent(ModificarActivity.getInstance(), MainActivity.class);
            intent.putExtra("Producto",this.producto.getNombre());
            intent.putExtra("Cantidad",this.producto.getCantidad() + "");
            intent.putExtra("Precio", this.producto.getPrecio() + "");
            intent.putExtra("Posicion", this.posicion + "");
            ModificarActivity.getInstance().setResult(2, intent);
            ModificarActivity.getInstance().finish();
        }
        else
        {
            Toast toast1 =
                    Toast.makeText(MainActivity.getInstance(),
                            "Uno de los campos esta vacio", Toast.LENGTH_SHORT);

            toast1.show();
        }

    }

}
