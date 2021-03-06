package spengergasse.at.ultiport.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import spengergasse.at.ultiport.R;
import spengergasse.at.ultiport.entities.User;

//Adapter-Klasse um Request-Objekte in der Recycler-View (Liste) der MainActivity anzuzeigen
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    //Interne User-Liste
    private Context mCtx;
    private List<User> mUsers;
    //private int i = 0;

    public UserAdapter(Context mCtx, List<User> mUsers){
        this.mCtx = mCtx;
        this.mUsers = mUsers;
    }

    //Neuerstellung eines ViewHolders für die Liste

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView vorname;
        public TextView nachname;
        public ImageView gruppe;
        public TextView id;

        public MyViewHolder(View view){
            super(view);
            vorname = (TextView) view.findViewById(R.id.user_vorname);
            nachname = (TextView) view.findViewById(R.id.user_nachname);
            id = (TextView) view.findViewById(R.id.u_id);
            gruppe = (ImageView) view.findViewById(R.id.user_gruppe);
        }
    }

    public UserAdapter(List<User> mUsers){
        this.mUsers = mUsers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        User user = mUsers.get(position);
        holder.vorname.setText(user.getVorname());
        holder.nachname.setText(user.getNachname());

        if(user.getGruppe().equals("1")) {
            holder.gruppe.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.ic_admin));
        }
        if(user.getGruppe().equals("2")){
            holder.gruppe.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.ic_requester));
        }
        if(user.getGruppe().equals("3")){
            holder.gruppe.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.ic_transporteur));
        }

        holder.id.setText(user.getId());
        //holder.gruppe.setText(user.getGruppe());
    }

    @Override
    public int getItemCount(){
        return mUsers.size();
    }




}

