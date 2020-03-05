package com.example.class05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ExampleviewHolder> {

    private Context mContext;
    private ArrayList<PofileModel> pofileModels;

    public ProfileAdapter(Context context, ArrayList<PofileModel> pofileModelArrayList) {
        mContext = context;
        pofileModels = pofileModelArrayList;
    }


    @NonNull
    @Override
    public ProfileAdapter.ExampleviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.profile, parent, false);


        return new ProfileAdapter.ExampleviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ExampleviewHolder holder, int position) {

        PofileModel currentItem = pofileModels.get(position);

        String email = currentItem.getEmail();
        String firstname = currentItem.getFirst_name();
        String lastname = currentItem.getLast_name();
        String avatar = currentItem.getAvater();

        holder.emailText.setText(email);
        holder.nameText.setText(firstname + " " + lastname);

        Picasso.get().load(avatar).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return pofileModels.size();
    }

    public class ExampleviewHolder extends RecyclerView.ViewHolder {

        public CircleImageView avatar;
        public TextView nameText, emailText;

        public ExampleviewHolder(View view) {
            super(view);

            avatar = view.findViewById(R.id.picId);
            nameText = view.findViewById(R.id.nameId);
            emailText = view.findViewById(R.id.emailId);

        }
    }
}
