package com.evannyz.pruebamodulotresapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.evannyz.pruebamodulotresapplication.data.model.ListaDeProductos;
import com.evannyz.pruebamodulotresapplication.databinding.ActivityMainBinding;
import com.evannyz.pruebamodulotresapplication.logic.Descuento;
import com.evannyz.pruebamodulotresapplication.logic.ValidadorSegunEstado;
import com.evannyz.pruebamodulotresapplication.ui.adapter.ListaDeProductosAdapter;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int total = 0;
    private Descuento descuento = new Descuento();
    private ValidadorSegunEstado validador= new ValidadorSegunEstado();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initAllTextViews();
        setRecyclerView();
    }

    private void initAllTextViews() {

        binding.tvSubtotal.setText("Sub Total: $0");
        binding.tvTotal.setText("Total: $0.0");
    }

    private void setRecyclerView() {
        RecyclerView.Adapter adapter = new ListaDeProductosAdapter(ListaDeProductos.listaDeProductos());
        ((ListaDeProductosAdapter) adapter).setListener(new ListaDeProductosAdapter.OnReciclerViewClickListener(){
            @Override
            public void onRecyclerItemClick(View view, int position, int precio, boolean estado) {
                total = validador.compruebaEstadoDevuelveTotal(estado,precio,total);
                Double totalFinal = descuento.aplicarDescuentoAlTotal(total);
                binding.tvSubtotal.setText("Sub Total : $"+total);
                binding.tvTotal.setText("Total: $"+totalFinal.toString());
                //Toast.makeText(getApplicationContext(), "La posicion del objeto es"+ position,Toast.LENGTH_SHORT).show();
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
    //Se reemplaza implementacion de OnClick por onRecyclerItemClick, no se borra codigo para mantener la referencia
           /* @Override
            public void onClick(View view) {

                Integer positionItem = binding.rvProductos.getChildAdapterPosition(view);
                Toast.makeText(getApplicationContext(), "La posicion del item es: "+positionItem,Toast.LENGTH_LONG).show();

                Integer valorGuardado = ListaDeProductos.listaDeProductos().get(positionItem).getPrecio();

                total = validarElementoSeleccionado(view,positionItem,valorGuardado,total);

                Double totalConDescuentos = aplicarDescuentoAlTotal(total);
//              Toast.makeText(getApplicationContext(),"Ha seleccionado Producto: "+ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_LONG).show();
                binding.tvSubtotal.setText("Sub Total: $" + valorGuardado.toString());
                binding.tvTotal.setText("Total: $" + totalConDescuentos.toString());
            }*/

        /*    //Este me da problemas
            @NonNull
            private Integer validarElementoSeleccionado(View view, Integer positionItem, Integer valorGuardado, Integer total) {
                boolean estado = ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).isSelected();

               // Productos p1 = new Productos(ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).getNombre(),ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).getIngredientes(),ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)).getPrecio(),true);

                if (estado == false){
               //     p1.setSelected(true);
               //     ListaDeProductos.listaDeProductos().set(binding.rvProductos.getChildAdapterPosition(view),p1);
                    ListaDeProductos.listaDeProductos().get(positionItem).setSelected(true);
                //    ListaDeProductos.listaDeProductos().set(positionItem,);
                    //Toast.makeText(getApplicationContext(),"Valor de nuevo estado es " + ListaDeProductos.listaDeProductos().get(binding.rvProductos.getChildAdapterPosition(view)),Toast.LENGTH_LONG).show();
                    total = total + valorGuardado;
                    estado = true;
                }else{
                    ListaDeProductos.listaDeProductos().get(positionItem).setSelected(false);
                    total = total - valorGuardado;
                    estado = false;
                }
                return total;
            }*/
}