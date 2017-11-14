package com.shinil.team_selector.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shinil.team_selector.R;

import java.util.List;

/**
 * Created by Shinil on 11-11-2017
 */

public class ResultListAdapter extends ArrayAdapter<String> {

    private List<String> objects;
    private LayoutInflater inflater;
    private int resource;

    public ResultListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.resource = resource;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            rowView = inflater.inflate(resource, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text =  rowView.findViewById(R.id.name);
            viewHolder.image = rowView.findViewById(R.id.image);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();

        String item = objects.get(position);
        String[] split = item.split(":");
        String name = split[0];
        String team = split[1];
        if(team.startsWith(getContext().getString(R.string.atletico))) {
            Glide.with(getContext()).load(R.drawable.atletico).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.barcelona))) {
            Glide.with(getContext()).load(R.drawable.barca).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.chelsea))) {
            Glide.with(getContext()).load(R.drawable.cheslsea).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.juventus))) {
            Glide.with(getContext()).load(R.drawable.juventus).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.city))) {
            Glide.with(getContext()).load(R.drawable.city).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.liverpool))) {
            Glide.with(getContext()).load(R.drawable.liverpool).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.spurs))) {
            Glide.with(getContext()).load(R.drawable.spurs).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.bayern))) {
            Glide.with(getContext()).load(R.drawable.bayern).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.dortmund))) {
            Glide.with(getContext()).load(R.drawable.bvb).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.psg))) {
            Glide.with(getContext()).load(R.drawable.psg).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.real))) {
            Glide.with(getContext()).load(R.drawable.real).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.united))) {
            Glide.with(getContext()).load(R.drawable.united).into(holder.image);
        } else if(team.startsWith(getContext().getString(R.string.arsenal))) {
            Glide.with(getContext()).load(R.drawable.arsenal).into(holder.image);
        } else {
            Glide.with(getContext()).load(R.mipmap.ic_launcher).into(holder.image);
        }
        holder.text.setText(name);
        return rowView;
    }

    private static class ViewHolder {
        private TextView text;
        private ImageView image;
    }
}
