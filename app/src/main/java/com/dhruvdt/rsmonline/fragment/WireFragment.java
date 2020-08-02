package com.dhruvdt.rsmonline.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dhruvdt.rsmonline.R;
import com.dhruvdt.rsmonline.adapter.ProductsAdapter;
import com.dhruvdt.rsmonline.model.WireModel;
import com.dhruvdt.rsmonline.network.ApiClient;
import com.dhruvdt.rsmonline.network.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WireFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WireFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WireFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WireFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WireFragment newInstance(String param1, String param2) {
        WireFragment fragment = new WireFragment();
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
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_wire, container, false);
        ButterKnife.bind(this, view);
        fetchWireList();
        return view;
    }

    ProgressDialog progressDialog;
    private void fetchWireList(){


        progressDialog = new ProgressDialog(getContext());

        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading..");
        progressDialog.setCancelable(false);
        progressDialog.show();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonArray> call = apiService.fetchWireList(1);

        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
                if(response.isSuccessful()){
                    try {
                        JSONArray jsonArray = new JSONArray(String.valueOf(response.body()));
                        if (jsonArray.isNull(0)){
                            //no_orders.setVisibility(View.VISIBLE);

                        }
                        else {
                            genratingList(jsonArray);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.e("onFailure",t.getMessage());
                //  initSnackBar(t.getMessage());
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
                // finish();
            }
        });


    }
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    ProductsAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<WireModel> mFinalList;
    private void genratingList(JSONArray jsonArray){
        mFinalList = new Gson().fromJson(jsonArray.toString(), new TypeToken<List<WireModel>>(){}.getType());
        setAdapter(mFinalList);
    }
    private void setAdapter(ArrayList<WireModel> mFinalList) {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ProductsAdapter(getContext(),mFinalList);

        mRecyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();

    }
}