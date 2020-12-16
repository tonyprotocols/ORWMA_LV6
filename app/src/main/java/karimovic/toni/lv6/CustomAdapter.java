package karimovic.toni.lv6;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.NameViewHolder> {

    private List<String> listStudent;
    private NameClickListener nameClickListener;
    public CustomAdapter(List<String> listStudent, NameClickListener nameClickListener) {
        this.listStudent = listStudent;
        this.nameClickListener = nameClickListener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemVew = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new NameViewHolder(listItemVew, nameClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Log.d("onBindViewHolder","Element" + position + "set.");

        holder.setName(listStudent.get(position));
    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView tvList;
        private NameClickListener nameClickListener;
        public NameViewHolder(@NonNull View itemView, NameClickListener listener) {
            super(itemView);
            nameClickListener = listener;

            tvList = (TextView) itemView.findViewById(R.id.tvList);

            itemView.setOnClickListener(this);
        }

        public void setName(String name){
            tvList.setText(name);
        }

        @Override
        public void onClick(View v) {
            nameClickListener.onNameClickListener(getAdapterPosition());
        }
    }
}
