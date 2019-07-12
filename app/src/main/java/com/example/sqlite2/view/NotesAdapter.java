package com.example.sqlite2.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sqlite2.R;
import com.example.sqlite2.database.model.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {
    private Context context;
    private List<Note> notesList;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView note_text;
        public TextView dot;
        public TextView timestamp;//date
        public TextView wordnumber;
        public TextView weather;
        public TextView state;
        public TextView time;
        public TextView kind;

        // unCode
        public TextView inshort;
//        public TextView updatetime;
        public TextView mood;
        public TextView location;


        public MyViewHolder(View view){
            super(view);
            note_text = view.findViewById(R.id.dialog_input);
            //dot = view.findViewById(R.id.dot);
            timestamp = view.findViewById(R.id.timestamp);
            wordnumber = view.findViewById(R.id.wordnumber);
            weather = view.findViewById(R.id.weather);
            state = view.findViewById(R.id.state);
            time = view.findViewById(R.id.time);
            kind = view.findViewById(R.id.kind);

            //inshort = view.findViewById(R.id.inshort);
            mood = view.findViewById(R.id.mood);
            location = view.findViewById(R.id.location);
        }
    }
    public NotesAdapter(Context context, List<Note> notesList){
        this.context = context;
        this.notesList = notesList;
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_row,parent,false);
        return new MyViewHolder(itemView);
    }
    public void onBindViewHolder(MyViewHolder holder, int position){
        Note note = notesList.get(position);
        if(note.getWordnumber() > 105)
            holder.note_text.setLines(7);
        holder.note_text.setText(note.getNote());
        //holder.dot.setText(Html.fromHtml("&#8226;"));
        holder.timestamp.setText(formatDate(note.getTimestamp()));
        holder.weather.setText(note.getWeather());
        holder.wordnumber.setText(String.valueOf(note.getWordnumber())+"字  ");
        //holder.state.setText(note.getState());
        holder.time.setText(formatTime(note.getTimestamp()));
        holder.kind.setText(note.getKind()+"  ");

//        holder.updatetime.setText(note.getUpdatetime());
//        holder.inshort.setText(note.getInshort());
        holder.mood.setText(note.getMood()+" ");
        holder.location.setText(note.getLocation());
    }
    public int getItemCount(){
        return notesList.size();
    }
    private String formatDate(String dateStr){
        try{
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MM/dd");
            return fmtOut.format(date);
        }catch (ParseException e){

        }
        return "";
    }

    private String formatTime(String dateStr) {
        try{
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("HH:mm");
            return fmtOut.format(date);
        }catch (ParseException e){

        }
        return "";
    }
}
