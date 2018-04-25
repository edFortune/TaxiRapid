package com.example.cloryse.taxirapid;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cloryse.taxirapid.Models.ChauffeurInfo;
import com.example.cloryse.taxirapid.Models.ClientInfo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.net.URL;
import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {

    ImageView imageView;
    Button buton;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    private Button bouton_client;
    private Button bouton_chauffeur;
    private Button button_Valider;
    private CardView card_plaque;
    private CardView card_matricule;

    private String USER_MODE = "CLIENT";

    private EditText nomEdit;
    private EditText prenomEdit;
    private EditText plaqueEdit;
    private  EditText marqueEdit;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseFirestore mFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        button_Valider=(Button)findViewById(R.id.buttonValider);
        bouton_client = (Button) findViewById(R.id.bouton_client);
        bouton_chauffeur = (Button) findViewById(R.id.bouton_chauffeur);
        card_plaque = (CardView)findViewById(R.id.card_plaque);
        card_matricule = (CardView)findViewById(R.id.card_matricule);


        imageView = (ImageView)findViewById(R.id.img_view);
        buton = (Button)findViewById(R.id.buton);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();

            }
        });

        nomEdit = findViewById(R.id.editTextNom);
        prenomEdit= findViewById(R.id.editTextPrenom);
        plaqueEdit =findViewById(R.id.editTextImma);
        marqueEdit =findViewById(R.id.editTextMArque);


    }
    private void  openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);


    }

    @Override
    protected void onActivityResult(int requestcode, int resultcode , Intent data){
        super.onActivityResult(requestcode,resultcode ,data);
        if(resultcode == RESULT_OK && requestcode == PICK_IMAGE){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);


        }
    }

    public void onClientClick(View view) {
        card_plaque.setVisibility(View.GONE);
        card_matricule.setVisibility(View.GONE);
        //Toast.makeText(this, "Client", Toast.LENGTH_SHORT).show();
        USER_MODE = "CLIENT";
    }

    public void onChauffeurClick(View view) {
        card_plaque.setVisibility(View.VISIBLE);
        card_matricule.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Chauffeur", Toast.LENGTH_SHORT).show();
        USER_MODE = "CHAUFFEUR";
    }


    public void clickvalidation(View view) {
        String nom = nomEdit.getText().toString();
        String prenom = prenomEdit.getText().toString();
        String plaque_immatriculation = plaqueEdit.getText().toString();
        String marque_vehicule = marqueEdit.getText().toString();

        ClientInfo clientInfo = new ClientInfo(nom, prenom);
        ChauffeurInfo chauffeurInfo = new ChauffeurInfo(nom, prenom, plaque_immatriculation, marque_vehicule);

        mFirestore = FirebaseFirestore.getInstance();
        DocumentReference newDataRef = mFirestore.collection(USER_MODE).document();

        if(USER_MODE.equals("CLIENT"))
            newDataRef.set(clientInfo);
        else if(USER_MODE.equals("CHAUFFEUR"))
            newDataRef.set(chauffeurInfo);

        Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();

        nomEdit.setText("");
        prenomEdit.setText("");
        plaqueEdit.setText("");
        marqueEdit.setText("");

        /*startActivity(new Intent(RegistrationActivity.this, MapActivity.class));*/
    }
}
