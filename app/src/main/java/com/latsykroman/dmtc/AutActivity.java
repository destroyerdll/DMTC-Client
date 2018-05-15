package com.latsykroman.dmtc;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AutActivity extends AppCompatActivity {
    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;

    EditText editemail;
    EditText editpass;
    Intent intent_sign;
    Button sign;
    Button registr;
    Button sign_student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aut);

        mAuth = FirebaseAuth.getInstance();

        //Views
        editemail = (EditText) findViewById(R.id.editemail);
        editpass = (EditText) findViewById(R.id.editpassword);
        //Buttons
        sign = (Button) findViewById(R.id.sign);
        registr = (Button) findViewById(R.id.registr);
        sign_student = (Button) findViewById(R.id.sign_student);

        sign_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_sign = new Intent(AutActivity.this, MainActivity.class);
                startActivity(intent_sign);

            }
        });

        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.registr) {
                    registrin(editemail.getText().toString(), editpass.getText().toString());
                }
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.sign) {
                    signin(editemail.getText().toString(), editpass.getText().toString());

                }
            }
        });
    }

    public void signin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if(user.isEmailVerified()){
                            updateUI(user);
                        }
                } else
                    Toast.makeText(AutActivity.this, "Автентифікація провалена", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void registrin(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AutActivity.this, "Реєстрація успішна", Toast.LENGTH_SHORT).show();
                    sendEmailVerification();
                } else
                    Toast.makeText(AutActivity.this, "Реєстрація провалена", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendEmailVerification() {
        // Send verification email
        // [START send_email_verification]
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        // [START_EXCLUDE]
                        // Re-enable button

                        if (task.isSuccessful()) {

                            Toast.makeText(AutActivity.this,
                                    "Verification email sent to " + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        else {
                            Log.e(TAG, "sendEmailVerification", task.getException());
                            Toast.makeText(AutActivity.this,
                                    "Failed to send verification email.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // [END_EXCLUDE]
                    }
                });
        // [END send_email_verification]
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(AutActivity.this, "Автентифікація успішна", Toast.LENGTH_SHORT).show();
                finish();
        }
    }

}




