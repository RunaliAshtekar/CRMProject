package com.rsd.crmroject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    TextView allServices;
    Button check;

    private RecyclerView recyclerView;
    private ArrayList<Model> list = new ArrayList<Model>();
    private CheckinAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view;
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        check = view.findViewById(R.id.btn_check);
        check.setTag(1);
        check.setText("CheckIn");
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int status = (Integer) view.getTag();
                if (status == 1) {

                    check.setText("CheckOut");
                    view.setTag(0);


                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("apikey", "164190680561dd8275933cb");
                    jsonObject.addProperty("userid", "1");


                    Call<ResponseBody> call = RetrofitClient.getRetrofitInstance().create(CheckinMethod.class).getList(jsonObject);

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.code() == 200) {
                                if (response.body() != null) {
                                    try {
                                        JSONObject json = new JSONObject(response.body().string());
                                        JSONObject json1 = new JSONObject(json.get("data").toString());
                                        Iterator x = json1.keys();

                                        list.clear();
                                        while (x.hasNext()) {
                                            String key = (String) x.next();

                                            JSONObject json2 = new JSONObject(json1.get(key).toString());
                                            list.add(new Model(json2.get("id") + "",
                                                    json2.get("name") + "", "" + json2.get("description"),
                                                    json2.get("location") + ""));
                                        }
                                        adapter = new CheckinAdapter(getActivity(), list,CheckInActivity.class);
                                        recyclerView.setAdapter(adapter);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });
                } else {

                    check.setText("checkIn");
                    view.setTag(1);
                }
            }
        });





        allServices = view.findViewById(R.id.text_allservices);
        allServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AllServicesFragment allServicesFragment = new AllServicesFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout, allServicesFragment, "findThisFragment")
                        .addToBackStack(null).commit();


            }
        });


        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleBottomSheet();

            }
        });

        return view;
    }



    public void toggleBottomSheet(){
        View view = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet,null);
        TextView addDeals = view.findViewById(R.id.add_deal);
        addDeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Deals", "add deals: ");
            }
        });


        TextView createTasks = view.findViewById(R.id.create_task);
        createTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Task", "Create Tasks ");
            }
        });
        TextView newMeetings = view.findViewById(R.id.new_meeting);
        newMeetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Meetings", "New Meeting: ");
            }
        });

        TextView addContacts = view.findViewById(R.id.add_contacts);
        addContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Contacts", "Add Contacts");
                Toast.makeText(getActivity(),"toast",Toast.LENGTH_LONG).show();

            }
        });


        BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
        dialog.setContentView(view);
        dialog.show();
    }


}
