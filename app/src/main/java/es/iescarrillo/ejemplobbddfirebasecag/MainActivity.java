package es.iescarrillo.ejemplobbddfirebasecag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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

    SuperheroAdapter adapter;

    List<Superhero> supers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference dbSuperheroes = FirebaseDatabase.getInstance().getReference().child("superheros");
        ListView lvSupers = findViewById(R.id.lvSuperheroes);


        dbSuperheroes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}