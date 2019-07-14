package com.tiringbring.expensesonline.Fragment.Expense;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.tiringbring.expensesonline.Adaptors.ExpenseExpandableListAdaptor;
import com.tiringbring.expensesonline.DataAccess.ExpenseDataService;
import com.tiringbring.expensesonline.Models.DayExpenses;
import com.tiringbring.expensesonline.Models.Expense;
import com.tiringbring.expensesonline.R;
import com.tiringbring.expensesonline.Services.ExpenseDataController;
import com.tiringbring.expensesonline.SharedData.Memory;
import com.tiringbring.expensesonline.SharedData.Preference;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExpandableListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExpandableListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpandableListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ExpandableListView expandableListView;
    ExpenseExpandableListAdaptor expandableListAdapter;
    List<DayExpenses> dayExpensesList;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ExpandableListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpandableListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExpandableListFragment newInstance(String param1, String param2) {
        ExpandableListFragment fragment = new ExpandableListFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expandable_list, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableExpenseList);
        List<Expense> expenses = new ExpenseDataService().GetExpensesofUser(Preference.loadString(getContext(), Memory.USER_ID, "0"));
        dayExpensesList = new ExpenseDataController(expenses).getDailyExpenses();
        expandableListAdapter = new ExpenseExpandableListAdaptor(getContext(), dayExpensesList);
        expandableListView.setAdapter(expandableListAdapter);
        return  view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
        void onFragmentInteraction(Uri uri);
    }
}
