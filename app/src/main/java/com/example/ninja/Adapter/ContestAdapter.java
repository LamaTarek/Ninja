package com.example.ninja.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ninja.CodeforcesService.Contest;
import com.example.ninja.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class ContestAdapter extends RecyclerView.Adapter<ContestAdapter.ContestViewHolder> {
    List<Contest> contestList;
    Context context;
    public ContestAdapter(Context context, List<Contest> contests){
        this.context=context;
        contestList = contests;
    }


    @NonNull
    @Override
    public ContestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.contest_list_item,parent,false);
        return new ContestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContestViewHolder holder, int position) {
        Contest contest = contestList.get(position);
        holder.contestName.setText(contest.getName());
        holder.contestLenght.setText("Lenght: "+contest.getDurationSeconds()/3600+" hours "+(contest.getDurationSeconds()%3600)/60+" min");
        holder.contestType.setText(contest.getType());
        holder.contestStartTime.setText(formatContestStartTime( contest.getStartTimeSeconds()));
        holder.moreInfo.setOnClickListener(view -> {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://codeforces.com/contests/" + contest.getId())));
        });

    }
    @NonNull
    public static String formatContestStartTime(Integer startTime) {
//        startTime is in unix
        long time = startTime*1000L;
        SimpleDateFormat dateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        dateFormat.setTimeZone(TimeZone.getTimeZone("EG"));
        dateFormat.applyPattern("dd MMMM yyyy HH:mm:ss");
        return "Start time: " + dateFormat.format(new Date(time));
    }

    @Override
    public int getItemCount() {
        return contestList.size();
    }

    public class ContestViewHolder extends RecyclerView.ViewHolder{
        TextView contestName,contestLenght,contestStartTime;
        com.google.android.material.chip.Chip contestType;
        de.hdodenhof.circleimageview.CircleImageView moreInfo;
        public ContestViewHolder(@NonNull View itemView) {
            super(itemView);
            contestName=itemView.findViewById(R.id.contest_name);
            contestLenght=itemView.findViewById(R.id.contest_length);
            contestStartTime=itemView.findViewById(R.id.contest_start_time);
            contestType=itemView.findViewById(R.id.contest_type);
            moreInfo=itemView.findViewById(R.id.more_info);
        }
    }


}
