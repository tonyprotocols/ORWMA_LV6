package karimovic.toni.lv6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.NameViewHolder> {
    private List<String> List;
    private RemoveClickListener removeListener;

    public RecyclerAdapter(RemoveClickListener listener, List<String> List){
        removeListener=listener;
        this.List=List;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new NameViewHolder(listItem, removeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(List.get(position));
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvItem;
        private ImageButton btRemove;
        private RemoveClickListener removeListener;

        public NameViewHolder(@NonNull View itemView, RemoveClickListener listener) {
            super(itemView);
            removeListener=listener;
            this.tvItem=itemView.findViewById(R.id.tvList);
            this.btRemove=itemView.findViewById(R.id.btRemove);
            btRemove.setOnClickListener(this);
        }

        public void setName(String name){ tvItem.setText(name);}

        @Override
        public void onClick(View v) { removeListener.onRemoveClick(getAdapterPosition()); }
    }

    public void addNewCell(String name, int position){
       if(List.size()>=position) {
           List.add(position, name);
           notifyItemInserted(position);
       }
    }

    public void removeCell(int position){
        if (List.size()>position){
            List.remove(position);
            notifyItemRemoved(position);
        }
    }
}
