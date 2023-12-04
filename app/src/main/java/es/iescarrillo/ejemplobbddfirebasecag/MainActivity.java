package es.iescarrillo.ejemplobbddfirebasecag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import es.iescarrillo.ejemplobbddfirebasecag.adapters.SuperheroAdapter;
import es.iescarrillo.ejemplobbddfirebasecag.models.Superhero;

public class MainActivity extends AppCompatActivity {

    private SuperheroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseApp.initializeApp(this);

        DatabaseReference dbSuperheros = FirebaseDatabase.getInstance().getReference().child("superheros");

        List<Superhero> superheroList = new ArrayList<>();
        ListView lvSuperheros = findViewById(R.id.lvSuperheroes);

        dbSuperheros.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                superheroList.clear();

                for(DataSnapshot snapshotSuperhero : dataSnapshot.getChildren()) {

                    Superhero superhero = snapshotSuperhero.getValue(Superhero.class);
                    superheroList.add(superhero);

                }

                adapter = new SuperheroAdapter(getApplicationContext(), superheroList);
                lvSuperheros.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("Firebase", "Error en la lectura de la base de datos", error.toException());
            }
        });
    }
}