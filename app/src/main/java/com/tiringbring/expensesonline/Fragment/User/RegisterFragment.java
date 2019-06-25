package com.tiringbring.expensesonline.Fragment.User;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
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
import com.tiringbring.expensesonline.Services.UserDataService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegisterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends RootFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText etName, etEmail, etPassword, etConfirmPassword;
    private Button btnRegister, btnGoToLogin;
    private TextView tvMessage;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RegisterFragment() {
    }

    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    View.OnClickListener onClickRegister = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            tvMessage.setText("");
            if(etName.getText().toString().isEmpty()){
                etName.setError("Name is empty");
            }else if(etName.getText().toString().length()<3){
                etName.setError("Minimum 3 characters");
            }else if(etEmail.getText().toString().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()){
                //tvMessage.setText("Invalid Email");
                etEmail.setError("Invalid Email");
            }else if(etPassword.getText().toString().length()<8){
                etPassword.setError("Minimum 8 characters");
            }else if(!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())){
                etConfirmPassword.setError("Password did not match");
            }else {
                User user = new User(etName.getText().toString(),etEmail.getText().toString(), etPassword.getText().toString());
                User newuser = new UserDataService().RegisterUser(user);
                if(newuser == null){
                    tvMessage.setText("Network Error");
                }else{
                    tvMessage.setText("registration successful for : "+newuser.toString());
                    mListener.OnSuccessfulRegister(newuser);
                }
            }
            tvMessage.append("/n "+etName.getText().toString() +"\n"+etEmail.getText().toString() +"\n"+etPassword.getText().toString() +"\n"+etConfirmPassword.getText().toString() +"\n");
        }
    };

    View.OnClickListener onClickGoToLogin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((UserActivity) getActivity()).GotToLogin();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        tvMessage = (TextView) view.findViewById(R.id.tvMessage);
        etName = (EditText) view.findViewById(R.id.etName);
        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etPassword = (EditText) view.findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) view.findViewById(R.id.etConfirmPassword);
        btnRegister = (Button) view.findViewById(R.id.btnRegister);
        btnGoToLogin = (Button) view.findViewById(R.id.btnGoToLogin);
        btnRegister.setOnClickListener(onClickRegister);
        btnGoToLogin.setOnClickListener(onClickGoToLogin);
        return  view;
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
        void OnSuccessfulRegister(User user);
    }
}
