package com.tiringbring.expensesonline.Fragment.User;

import android.content.Context;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tiringbring.expensesonline.Activities.User.UserActivity;
import com.tiringbring.expensesonline.Fragment.RootFragment;
import com.tiringbring.expensesonline.Models.User;
import com.tiringbring.expensesonline.R;
import com.tiringbring.expensesonline.DataAccess.UserDataService;

public class LoginFragment extends RootFragment {
    private static final String CODE = "code";


    private String mCode;

    private EditText etLEmail, etLPassword;
    private TextView tvLMessage;
    private Button btnLogin, btnGoToRegister;

    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
    }

    public static LoginFragment newInstance(String code) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(CODE, code);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCode = getArguments().getString(CODE);
        }
    }
    View.OnClickListener  onLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(etLEmail.getText().toString().isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(etLEmail.getText().toString()).matches()){
                etLEmail.setError("Enter a valid email");
            }else if (etLPassword.getText().toString().isEmpty()){
                etLPassword.setError("Please enter email");
            }else{
                User newuser = new UserDataService().LoginUser(etLEmail.getText().toString(), etLPassword.getText().toString());
                if(newuser == null){
                    tvLMessage.setText("Login Failed");
                }else{

                    mListener.OnSuccessfulLogin(newuser);
                    tvLMessage.setText("Login successful for : "+newuser.getName()+" "+newuser.getEmail());

                }

            }

        }
    };
    View.OnClickListener onClickGoToRegister = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((UserActivity) getActivity()).GotToRegister();
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        tvLMessage = (TextView) view.findViewById(R.id.tvLMessage);
        etLEmail = (EditText) view.findViewById(R.id.etLEmail);
        etLPassword = (EditText) view.findViewById(R.id.etLPassword);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnGoToRegister = (Button) view.findViewById(R.id.btnGoToRegister);
        btnLogin.setOnClickListener(onLoginClick);
        btnGoToRegister.setOnClickListener(onClickGoToRegister);
        return  view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.OnSignupPressed();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void OnSuccessfulLogin(User user);

        void OnSignupPressed();
    }
}
