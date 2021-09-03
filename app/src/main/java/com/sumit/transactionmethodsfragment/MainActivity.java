package com.sumit.transactionmethodsfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAddA, btnRemoveA, btnReplaceAWithBWithoutBackstack, btnReplaceAWithackstack, btnAddB, btnRemoveB, btnReplaceBWithA;
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
    }


    private void initViews() {
        btnAddA = findViewById(R.id.btnAddA);
        btnAddB = findViewById(R.id.btnAddB);
        btnRemoveA = findViewById(R.id.btnRemoveA);
        btnRemoveB = findViewById(R.id.btnRemoveB);
        btnReplaceAWithackstack = findViewById(R.id.btnReplaceAWithackstack);
        btnReplaceBWithA = findViewById(R.id.btnReplaceBWithA);
        btnReplaceAWithBWithoutBackstack = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        btnAddA.setOnClickListener(this);
        btnAddB.setOnClickListener(this);
        btnRemoveA.setOnClickListener(this);
        btnReplaceAWithackstack.setOnClickListener(this);
        btnReplaceAWithBWithoutBackstack.setOnClickListener(this);
        btnRemoveB.setOnClickListener(this);
        btnReplaceBWithA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnAddA:

                addA();
                break;
            case R.id.btnAddB:

                addB();
                break;
            case R.id.btnRemoveA:

                RemoveA();
                break;
            case R.id.btnRemoveB:

                RemoveB();
                break;
            case R.id.btnReplaceAWithackstack:

                replaceAwithBwithbackstack();

                break;
            case R.id.btnReplaceAWithBWithoutBackstack:

                repalceAwithB();
                break;
            case R.id.btnReplaceBWithA:

                repalceBwithA();
                break;
        }
    }
    /**
     * Replace the existing fragment with FragmentA
     */
    private void replaceAwithBwithbackstack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer, fragmentB, "FragmentB").addToBackStack("fragmentB").commit();
    }

    private void repalceBwithA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer, fragmentA, "FragmentA").commit();
    }

    private void repalceAwithB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer, fragmentB, "FragmentB").commit();

    }

    private void RemoveB() {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("FragmentB");
        if(fragmentB!=null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentB).commit();
        }else {
            Toast.makeText(this,"The Fragment is not selected",Toast.LENGTH_SHORT).show();
        }
    }

    private void RemoveA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("FragmentA");
        if(fragmentA!=null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentA).commit();
        }else{
            Toast.makeText(this,"The Fragment is not selected",Toast.LENGTH_SHORT).show();
        }
    }

    private void addB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.flContainer, fragmentB, "FragmentB").commit();
    }

    private void addA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.flContainer, fragmentA, "FragmentA").commit();
    }
}