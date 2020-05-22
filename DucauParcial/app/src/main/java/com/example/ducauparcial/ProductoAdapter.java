package com.example.ducauparcial;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> implements View.OnClickListener {

    private List<Producto> productos;
    private View.OnClickListener listener;

    public ProductoAdapter(List<Producto> productos)
    {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        ProductoViewHolder vh = new ProductoViewHolder(view);

        view.setOnClickListener(this);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position)
    {
        Producto p = this.productos.get(position);
        TextView tvProducto = holder.view.findViewById(R.id.tvProducto);
        TextView tvCantidad = holder.view.findViewById(R.id.tvCantidad);
        TextView tvPrecio = holder.view.findViewById(R.id.tvPrecio);
        tvProducto.setText(p.getNombre());
        tvCantidad.setText("Cantidad: " + p.getCantidad());
        tvPrecio.setText("Precio Unidad: " + p.getPrecio());

    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View v)
    {
        if(this.listener != null)
        {
            listener.onClick(v);
        }
    }

}
