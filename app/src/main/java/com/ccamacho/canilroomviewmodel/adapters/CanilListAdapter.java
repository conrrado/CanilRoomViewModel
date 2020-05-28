package com.ccamacho.canilroomviewmodel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.ccamacho.canilroomviewmodel.R;
import com.ccamacho.canilroomviewmodel.model.Dog;
import com.ccamacho.canilroomviewmodel.view.CanilListFragmentDirections;

import java.util.List;

public class CanilListAdapter extends RecyclerView.Adapter<CanilListAdapter.CanilListViewHolder> {

    List<Dog> dogList;

    public CanilListAdapter(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @NonNull
    @Override
    public CanilListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.canil_list_item, parent, false);
        return new CanilListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CanilListViewHolder holder, int position) {
        holder.bind(dogList.get(position));
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }

    static class CanilListViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewDescription;

        public CanilListViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView_name);
            textViewDescription = itemView.findViewById(R.id.textView_description);
        }

        void bind(Dog dog) {
            textViewName.setText(dog.getName());
            textViewDescription.setText(dog.getBreedGroup());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavDirections action = CanilListFragmentDirections.actionToCanilDetailFragment(dog.getId());
                    Navigation.findNavController(v).navigate(action);
                }
            });
        }
    }
}
