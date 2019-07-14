package com.tiringbring.expensesonline.Fragment.User;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tiringbring.expensesonline.Fragment.RootFragment;
import com.tiringbring.expensesonline.MainActivity;
import com.tiringbring.expensesonline.Models.User;
import com.tiringbring.expensesonline.R;
import com.tiringbring.expensesonline.DataAccess.UserDataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivationFragment extends RootFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CODE = "code";
    private static final String ID = "id";
    private Button btnActivate, btnFakeActivate;
    private EditText etCode;


    private String mCode;
    private String mId;


    public ActivationFragment() {
        // Required empty public constructor
    }


    public static ActivationFragment newInstance(String code, String id) {
        ActivationFragment fragment = new ActivationFragment();
        Bundle args = new Bundle();
        args.putString(CODE, code);
        args.putString(ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCode = getArguments().getString(CODE);
            mId = getArguments().getString(ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_activation, container, false);
        etCode = (EditText) view.findViewById(R.id.etCode);
        btnActivate = (Button) view.findViewById(R.id.btnActivate);
        btnFakeActivate = (Button) view.findViewById(R.id.btnFakeActivate);
        btnActivate.setOnClickListener(onClickbtnActivate);
        btnFakeActivate.setOnClickListener(onClickbtnFakeActivate);
        return  view;
    }
    View.OnClickListener onClickbtnActivate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(etCode.getText().toString().equals(mCode)){
                User user = new UserDataService().activateUser(mCode, mId);
                if(user!=null){
                    startActivity(new Intent(getContext(), MainActivity.class));
                }else{
                    Toast.makeText(getContext(),"Error, Try again!", Toast.LENGTH_LONG).show();
                }

            }else{
                Toast.makeText(getContext(),"Wrong Code", Toast.LENGTH_LONG).show();
            }
        }
    };
    View.OnClickListener onClickbtnFakeActivate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getContext(), MainActivity.class));
        }
    };

}
