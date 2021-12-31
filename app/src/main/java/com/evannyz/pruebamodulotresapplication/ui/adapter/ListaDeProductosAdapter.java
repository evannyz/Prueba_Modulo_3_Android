package com.evannyz.pruebamodulotresapplication.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.evannyz.pruebamodulotresapplication.MainActivity;
import com.evannyz.pruebamodulotresapplication.R;
import com.evannyz.pruebamodulotresapplication.data.model.Productos;
import com.evannyz.pruebamodulotresapplication.databinding.ElementosListaProductosLayoutBinding;

import java.util.List;

public class ListaDeProductosAdapter extends RecyclerView.Adapter<ListaDeProductosAdapter.ListaProductosViewHolder> {

    private List<Productos> listaDeProductos;
    private OnReciclerViewClickListener listener;


    public ListaDeProductosAdapter(List<Productos> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    @NonNull
    @Override
    public ListaProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos_lista_productos_layout, parent, false);
        return new ListaProductosViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaProductosViewHolder holder, int position) {
        holder.binData(listaDeProductos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDeProductos.size();
    }

    // Se reemplaza la implementacion de Onclick por interface con onRecyclerItemClick
    /*@Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }*/

    class ListaProductosViewHolder extends RecyclerView.ViewHolder {

        private ElementosListaProductosLayoutBinding binding;
        private OnReciclerViewClickListener listener;

        public ListaProductosViewHolder(@NonNull View itemView, OnReciclerViewClickListener listener) {
            super(itemView);
            binding = ElementosListaProductosLayoutBinding.bind(itemView);
            this.listener = listener;
        }

        public void binData(Productos productos) {
            binding.tvNombreProducto.setText(productos.getNombre());
            binding.tvIngredientes.setText(productos.getIngredientes());
            binding.tvPrecioProducto.setText("$"+productos.getPrecio().toString());

            Glide.with(itemView).load(productos.getUrlImagenProducto())
                    .circleCrop()
                    .into(binding.ivProductosComestibles);

            itemView.setOnClickListener(v -> {
                listener.onRecyclerItemClick(itemView,getAdapterPosition(),productos.getPrecio(),productos.isSelected());
                if(itemView.isPressed() && !productos.isSelected()){
                    productos.setSelected(true);
                    notifyItemChanged(getLayoutPosition());
                }else if (itemView.isPressed() && productos.isSelected()){
                    productos.setSelected(false);
                    notifyItemChanged(getLayoutPosition());
                }
            });
            if(!productos.isSelected()){
                binding.ivClickBoton.setVisibility(View.INVISIBLE);
            }else{
                binding.ivClickBoton.setVisibility(View.VISIBLE);
            }
        }
    }

    public interface OnReciclerViewClickListener{
        void onRecyclerItemClick(View view ,int position, int precio, boolean estado);
    }

    public void setListener(OnReciclerViewClickListener listener){
        this.listener = listener;
    }
}
