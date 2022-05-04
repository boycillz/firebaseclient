package com.azismihsan.firebaseclient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends FirebaseRecyclerAdapter<Model, MyAdapter.MyViewHolder> {


    public MyAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Model model) {
        holder.uNameTv.setText(model.getuName());
        holder.pTitleTv.setText(model.getpTitle());
        holder.pDescriptionTv.setText(model.getpDescr());
        holder.pAddressTv.setText(model.getpAddress());
        holder.uNameTv.setText(model.getuName());
        holder.pTimeTv.setText(model.getpTime());
        Glide.with(holder.uPictureIv.getContext()).load(model.getuDp()).into(holder.uPictureIv);
        Glide.with(holder.pImageIv.getContext()).load(model.getpImage()).into(holder.pImageIv);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView uPictureIv, pImageIv;
        TextView uNameTv, pTimeTv, pTitleTv, pDescriptionTv, pAddressTv;
        LinearLayout profileLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //init views
            uPictureIv = itemView.findViewById(R.id.uPictureIv);
            pImageIv = itemView.findViewById(R.id.pImageIvPost);
            uNameTv = itemView.findViewById(R.id.uNameTv);
            pTimeTv = itemView.findViewById(R.id.pTimeTv);
            pTitleTv = itemView.findViewById(R.id.pTitleTv);
            pDescriptionTv = itemView.findViewById(R.id.pDescriptionTv);
            pAddressTv = itemView.findViewById(R.id.pAddressTv);
            profileLayout = itemView.findViewById(R.id.profileLayout);
        }
    }
}
