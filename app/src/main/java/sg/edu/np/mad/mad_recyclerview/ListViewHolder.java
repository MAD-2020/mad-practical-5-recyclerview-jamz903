package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    TextView taskText;
    CheckBox taskCheck;
    LinearLayout parentLayout;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        taskText = itemView.findViewById(R.id.taskText);
        taskCheck = itemView.findViewById(R.id.taskCheck);
        parentLayout = itemView.findViewById(R.id.parentLayout);
    }
}
