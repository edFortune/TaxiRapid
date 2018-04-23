package com.example.cloryse.taxirapid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class  Sign_UpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        mEmail = findViewById(R.id.editTxt_mail);
        mPassword = findViewById(R.id.editTxt_passwd);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null){
                    // The user has not logged in
                }else{
                    // The user has logged in
                }
            }
        };
    }


    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null){
            //Toast.makeText(this, "You are logged In", Toast.LENGTH_SHORT).show();
        }

    }
        @Override
        public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            updateUI(currentUser);
        }

    public void startSignUp(View view) {
        String email = mEmail.getText().toString();
        String passwd = mPassword.getText().toString();

        if(email.isEmpty() || passwd.isEmpty()){
            mEmail.setError("Enter an email");
            return;
        }

        if(passwd.isEmpty()){
            mPassword.setError("Enter a password");
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Sign_UpActivity.this, RegistrationActivity.class);
                    startActivity(intent);
                    Toast.makeText(Sign_UpActivity.this, "Sign Up", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(Sign_UpActivity.this, "Not Sign Up", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
