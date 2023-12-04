package es.iescarrillo.ejemplobbddfirebasecag.adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;


import es.iescarrillo.ejemplobbddfirebasecag.R;
import es.iescarrillo.ejemplobbddfirebasecag.models.Superhero;


/**
 * Clase ContactAdapter que usaremos para volcar el contenido de la lista a la ListView
 */
public class SuperheroAdapter extends ArrayAdapter<Superhero> {

    public SuperheroAdapter (Context context, List<Superhero> superList){
        //Como nosotros usamos SortedSet, casteamos para no tener problemas
        super(context, 0, superList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Superhero superhero = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_superhero, parent, false);

        }


        TextView tvNameL = convertView.findViewById(R.id.tvName);



        //En nuestro caso en la pantalla de inicio mostraremos el nombre y el apellido

        tvNameL.setText(superhero.getName());
        Log.i("Name", superhero.getName());

       // if(superhero.isActive()){
         //   sw.setChecked(true);
        //}else {
          //  sw.setChecked(false);
        //}

        return convertView;

    }


}
