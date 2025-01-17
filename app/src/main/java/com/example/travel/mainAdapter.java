package com.example.travel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
//中间界面RecyclerView的适配器
public class mainAdapter extends RecyclerView.Adapter<mainAdapter.ViewHolder>{
    private Context mcontext;
    private List<Card> mcardList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(View view){
            super(view);
            cardView=(CardView) view;
            imageView=(ImageView) view.findViewById(R.id.picture);
            textView=(TextView) view.findViewById(R.id.introduce);
        }
    }
    public mainAdapter(List<Card> cardList){
        this.mcardList=cardList;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){//创建新视图
        if(mcontext==null){
            mcontext=parent.getContext();
        }
        View view= LayoutInflater.from(mcontext).inflate(R.layout.recyclerview,parent,false);
       final ViewHolder holder=new ViewHolder(view);
       holder.cardView.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               int position=holder.getAdapterPosition();
               Card card=mcardList.get(position);
               Intent intent=new Intent(mcontext,SceneryActivity.class);
               intent.putExtra(SceneryActivity.SCENERY_NAME,card.getIntroduce());
               intent.putExtra(SceneryActivity.SCENERY_IMAGE_ID,card.getImageID());
               mcontext.startActivity(intent);
           }
       });
       return holder;
    }
    public void onBindViewHolder(ViewHolder holder,int position){//替换视图内容
        Card card=mcardList.get(position);
        holder.textView.setText(card.getIntroduce());
        Glide.with(mcontext).load(card.getImageID()).into(holder.imageView);
    }
    public int getItemCount(){
        return mcardList.size();
    }
}
