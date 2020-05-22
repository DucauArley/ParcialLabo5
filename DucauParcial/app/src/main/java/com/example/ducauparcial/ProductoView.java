package com.example.ducauparcial;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class ProductoView
{
    Button btn;
    Activity activity;
    EditText etN;
    EditText etC;
    EditText etP;
    Producto producto;

    public ProductoView(Activity activity, ProductoController mylistener)
    {
        this.activity = activity;
        this.btn = activity.findViewById(R.id.btnG);
        btn.setOnClickListener(mylistener);
        this.producto = mylistener.producto;
    }


    public void cargarViews()
    {
        this.etN = activity.findViewById(R.id.etProducto);
        this.etC = activity.findViewById(R.id.etCantidad);
        this.etP = activity.findViewById(R.id.etPrecio);
    }

    public void pasarDatos()
    {
        this.etN.setText(producto.getNombre() + "");
        this.etC.setText(producto.getCantidad() + "");
        this.etP.setText(producto.getPrecio() + "");
    }

    public boolean cargarModelo()
    {
        boolean retorno = false;

        if(!isEmpty(etN) && !isEmpty(etC) && !isEmpty(etP))
        {
            this.producto.setNombre(etN.getText().toString());
            this.producto.setCantidad(Integer.parseInt(etC.getText().toString()));
            this.producto.setPrecio(Double.parseDouble(etP.getText().toString()));


            retorno =  true;
        }

        return  retorno;
    }

    private boolean isEmpty(EditText etText)
    {
        boolean retorno = true;

        if (etText.getText().toString().trim().length() > 0)
        {
            retorno = false;
        }

        return retorno;
    }

}
