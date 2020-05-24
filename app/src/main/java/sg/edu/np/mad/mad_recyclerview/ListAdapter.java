package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder>{
    Context context;
    ArrayList<String> listItem;
    TextView itemSelected;

    public ListAdapter(ArrayList<String> aListItem, Context context){
        listItem = aListItem;
        this.context = context;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,null);

        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        String info = listItem.get(position);
        holder.taskText.setText(info);
        final String item = holder.taskText.getText().toString();
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater layoutInflater = LayoutInflater.from(v.getContext());
                View AlertView = layoutInflater.inflate(R.layout.layout_alert,null);
                builder.setView(AlertView);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        listItem.remove(position);
                        notifyDataSetChanged();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                itemSelected = (TextView) AlertView.findViewById(R.id.itemSelected);
                itemSelected.setText(item + "?");
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Delete");
                alertDialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
}
