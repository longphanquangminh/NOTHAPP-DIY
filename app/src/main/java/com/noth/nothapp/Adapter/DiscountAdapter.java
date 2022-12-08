package com.noth.nothapp.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.noth.nothapp.databinding.ItemDiscountBinding;
import com.noth.nothapp.Model.Discount;

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.GiamGiaViewHolder>{
    private ISale iSale;

    public DiscountAdapter(ISale iSale) {
        this.iSale = iSale;
    }

    @NonNull
    @Override
    public GiamGiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDiscountBinding binding = ItemDiscountBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new GiamGiaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GiamGiaViewHolder holder, int position) {
        Discount sales = iSale.getListSale(position);
        holder.binding.txtGiamGia.setText("-"+sales.getNumberSale()+"%");
        holder.binding.txtGiaGoc.setText(sales.getInitialPrice()+" VNĐ");
        holder.binding.txtGiaSale.setText(sales.getDiscountPrice()+" VNĐ");
        holder.binding.txtDaBan.setText("Đã bán "+sales.getSold());
        holder.binding.imageItem.setImageResource(sales.getImageSale());
    }

    @Override
    public int getItemCount() {
        return iSale.getCount();
    }

    public interface ISale{
        int getCount();
        Discount getListSale(int position);
    }

    public class GiamGiaViewHolder extends RecyclerView.ViewHolder{
        ItemDiscountBinding binding;
        public GiamGiaViewHolder(@NonNull ItemDiscountBinding binding) {
            super(binding.txtGiamGia.getRootView());
            this.binding = binding;
        }
    }
}
