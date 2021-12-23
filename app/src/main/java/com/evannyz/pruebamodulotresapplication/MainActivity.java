package com.evannyz.pruebamodulotresapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.evannyz.pruebamodulotresapplication.data.model.ListaDeProductos;
import com.evannyz.pruebamodulotresapplication.data.model.Productos;
import com.evannyz.pruebamodulotresapplication.databinding.ActivityMainBinding;
import com.evannyz.pruebamodulotresapplication.ui.ListaDeProductosAdapter;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Integer total = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setRecyclerView();

    }

    private void setRecyclerView() {

        RecyclerView.Adapter adapter = new ListaDeProductosAdapter(ListaDeProductos.listaDeProductos());
        ((ListaDeProductosAdapter) adapter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer valorGuardado = ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).getPrecio();

                total = validarElementoSeleccionado(view,valorGuardado,total);

                Double totalConDescuentos = aplicarDescuentoAlTotal(total);
//              Toast.makeText(getApplicationContext(),"Ha seleccionado Producto: "+ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_LONG).show();
                binding.tvSubtotal.setText("Sub Total: $" + valorGuardado.toString());
                binding.tvTotal.setText("Total: $" + totalConDescuentos.toString());
            }

            private Double aplicarDescuentoAlTotal(Integer total) {
                Double totalFinal;
                if (total > 5000) {
                    Double totalCambiado = (double) total;
                    totalFinal = totalCambiado * 0.95;
                } else if (total > 10000) {
                    Double totalCambiado = (double) total;
                    totalFinal = totalCambiado * 0.90;
                } else {
                    totalFinal = (double) total;
                }
                return totalFinal;
            }

            //Este me da problemas
            @NonNull
            private Integer validarElementoSeleccionado(View view, Integer valorGuardado, Integer total) {
                boolean estado = ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).isSelected();

               // Productos p1 = new Productos(ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).getNombre(),ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).getIngredientes(),ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).getPrecio(),true);

                if (estado == false){
               //     p1.setSelected(true);
               //     ListaDeProductos.listaDeProductos().set(binding.rvProductos.getChildAdapterPosition(view),p1);
                    ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).setSelected(true);
                    Toast.makeText(getApplicationContext(),"Valor de nuevo estado es " + ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)),Toast.LENGTH_LONG).show();
                    total = total + valorGuardado;
                    adapter.notifyDataSetChanged();

                }else{
                    ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildLayoutPosition(view)).setSelected(false);
                    total = total - valorGuardado;

                }
                return total;
            }


        });
        binding.rvProductos.setAdapter(adapter);
        binding.rvProductos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}