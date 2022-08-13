package com.example.ninja.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ninja.CodeforcesService.Contest;
import com.example.ninja.R;
import com.example.ninja.model.Problem;

import java.util.List;

public class ProblemAdapter extends RecyclerView.Adapter<ProblemAdapter.ProblemViewHolder> {
    List<Problem> problemList;
    Context context;
    public ProblemAdapter(Context context, List<Problem> problems){
        this.context=context;
        problemList = problems;
    }


    @NonNull
    @Override
    public ProblemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.problem_list_item,parent,false);
        return new ProblemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProblemViewHolder holder, int position) {
        Problem problem = problemList.get(position);
        holder.problemName.setText(problem.getContestId()+problem.getIndex()+" "+problem.getName());
        List<String>tags;
        tags=problem.getTags();
        holder.problemRating.setText("Rating: "+problem.getRating());
        holder.problemTag.setText(tags.get(0));
    }

    @Override
    public int getItemCount() {
        return problemList.size();
    }

    public class ProblemViewHolder extends RecyclerView.ViewHolder{
        TextView problemName,problemRating;
        com.google.android.material.chip.Chip problemTag;
        public ProblemViewHolder(@NonNull View itemView) {
            super(itemView);
            problemName=itemView.findViewById(R.id.problem_name);
            problemRating=itemView.findViewById(R.id.problem_rating);
            problemTag=itemView.findViewById(R.id.problemTag);
        }
    }


}
