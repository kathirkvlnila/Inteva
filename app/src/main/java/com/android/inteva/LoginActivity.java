package com.android.inteva;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {


    // UI references.
    private EditText mUsernameView;
    private EditText mPasswordView;
    private Button mLoginBtnView;

    // Supporting variables
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;


        // Set up the login form.
        mUsernameView = (EditText) findViewById(R.id.usernameId);
        mPasswordView = (EditText) findViewById(R.id.passwordId);
        mLoginBtnView = (Button) findViewById(R.id.loginBtnId);

        mLoginBtnView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToDashBoard();
            }
        });

    }

    private boolean validateCredential() {
        boolean status = true;


        return status;
    }

    private void moveToDashBoard() {
        if (validateCredential()) {
            startActivity(new Intent(mContext, DashBoardActivity.class));
        }
    }


}

