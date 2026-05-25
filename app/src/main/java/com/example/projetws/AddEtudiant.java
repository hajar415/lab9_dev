package com.example.projetws;

import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projetws.beans.Etudiant;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AddEtudiant extends AppCompatActivity {

    private EditText    etNom, etPrenom;
    private Spinner     spinVille;
    private RadioButton rbHomme, rbFemme;
    private Button      btnAjouter;
    private RequestQueue rq;

    private static final String URL_AJOUT =
            "http://192.168.1.103/projet/ws/createEtudiant.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);

        etNom      = findViewById(R.id.etNom);
        etPrenom   = findViewById(R.id.etPrenom);
        spinVille  = findViewById(R.id.spinVille);
        rbHomme    = findViewById(R.id.rbHomme);
        rbFemme    = findViewById(R.id.rbFemme);
        btnAjouter = findViewById(R.id.btnAjouter);

        rq = Volley.newRequestQueue(this);

        btnAjouter.setOnClickListener(v -> envoyerDonnees());
    }

    private void envoyerDonnees() {

        StringRequest req = new StringRequest(
                Request.Method.POST,
                URL_AJOUT,
                response -> {
                    Log.d("REPONSE", response);
                    Type type = new TypeToken<Collection<Etudiant>>(){}.getType();
                    Collection<Etudiant> liste = new Gson().fromJson(response, type);
                    for (Etudiant e : liste) {
                        Log.d("ETUDIANT", e.toString());
                    }
                    Toast.makeText(this, "Étudiant ajouté avec succès !", Toast.LENGTH_SHORT).show();
                    etNom.setText("");
                    etPrenom.setText("");
                },
                error -> {
                    Log.e("VOLLEY_ERR", "Erreur : " + error.getMessage());
                    Toast.makeText(this, "Erreur de connexion !", Toast.LENGTH_SHORT).show();
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                String sexeChoisi = rbHomme.isChecked() ? "homme" : "femme";
                Map<String, String> params = new HashMap<>();
                params.put("nom",    etNom.getText().toString().trim());
                params.put("prenom", etPrenom.getText().toString().trim());
                params.put("ville",  spinVille.getSelectedItem().toString());
                params.put("sexe",   sexeChoisi);
                return params;
            }
        };

        rq.add(req);
    }
}