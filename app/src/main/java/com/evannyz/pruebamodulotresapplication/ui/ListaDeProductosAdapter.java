package com.evannyz.pruebamodulotresapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evannyz.pruebamodulotresapplication.R;
import com.evannyz.pruebamodulotresapplication.data.model.Productos;
import com.evannyz.pruebamodulotresapplication.databinding.ElementosListaProductosLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class ListaDeProductosAdapter extends RecyclerView.Adapter<ListaDeProductosAdapter.ListaProductosViewHolder>
        implements View.OnClickListener{

    private List<Productos> listaDeProductos;
    private View.OnClickListener listener;


    public ListaDeProductosAdapter(List<Productos> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    @NonNull
    @Override
    public ListaProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos_lista_productos_layout, parent, false);
        view.setOnClickListener(this::onClick);
        return new ListaProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaProductosViewHolder holder, int position) {
        holder.binData(listaDeProductos.get(position));

    }

    @Override
    public int getItemCount() {
        return listaDeProductos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }

    class ListaProductosViewHolder extends RecyclerView.ViewHolder {

        private ElementosListaProductosLayoutBinding binding;

        public ListaProductosViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ElementosListaProductosLayoutBinding.bind(itemView);
        }

        public void binData(Productos productos) {
            binding.tvNombreProducto.setText(productos.getNombre());
            binding.tvIngredientes.setText(productos.getIngredientes());
            binding.tvPrecioProducto.setText(productos.getPrecio().toString());

            if(productos.isSelected() == false){
                binding.ivClickBoton.setVisibility(View.INVISIBLE);
            }else{
                binding.ivClickBoton.setVisibility(View.VISIBLE);
            }

        }
    }

}
