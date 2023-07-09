package com.example.myalki;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CocktailAdapter  extends RecyclerView.Adapter<CocktailAdapter.MyViewHolder> {

    private ArrayList<CocktailDM> mCocktail;
    private Interface rInterface;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cocktail,parent,false);

        return new MyViewHolder(v,rInterface);

    }

    public CocktailAdapter(ArrayList<CocktailDM> mCocktail, Interface rvinterface) {

        this.mCocktail = mCocktail;
        this.rInterface = rvinterface;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final CocktailDM mPosition = mCocktail.get(position);

        holder.rowNameTV.setText(mPosition.getName());
        //holder.levelBtn.setText(mPosition.getDifficulty());
        //holder.typeBtn.setText(mPosition.getType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println(mPosition.getIngredients());
                System.out.println(mPosition.getInstructions());

                Intent i = new Intent(view.getContext(), CocktailDetailActivity.class);

                i.putExtra("name",mPosition.getName());
                i.putStringArrayListExtra("ingredients", (ArrayList<String>) mPosition.getIngredients());
                i.putExtra("instructions",mPosition.getInstructions());

                view.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mCocktail.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View view, int position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        //private RecyclerViewClickListener mListener;
        public TextView rowNameTV;
        public Button levelBtn;
        public Button typeBtn;

        public MyViewHolder(@NonNull View itemView, Interface rvIn) {
            super(itemView);


            Log.d(TAG, "On Click Working!");
            rowNameTV = itemView.findViewById(R.id.rowNameTV);
            //levelBtn = itemView.findViewById(R.id.levelBtn);
            //typeBtn = itemView.findViewById(R.id.typeBtn);
        }
    }

    public void setData(ArrayList<CocktailDM> data) {
        mCocktail.clear();
        mCocktail.addAll(data);
        //notifyDataSetChanged();
    }
}
