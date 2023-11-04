package uz.coder.d2lesson71;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uz.coder.d2lesson71.databinding.ItemStudentBinding;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {
    private List<Student> studentList;

    public MyAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(ItemStudentBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Student student = studentList.get(position);
        holder.binding.txt1.setText(student.getName() + student.getAge() + " " + student.getPhone_number());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        ItemStudentBinding binding;
        public VH(@NonNull ItemStudentBinding binding) {
            super(binding.getRoot());
            this.binding  = binding;
        }
    }
}
