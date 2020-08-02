package com.dhruvdt.rsmonline.adapter;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.dhruvdt.rsmonline.R;
import com.dhruvdt.rsmonline.Util.CheckInternet;
import com.dhruvdt.rsmonline.model.WireModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private ArrayList<WireModel> displayItems;
    Context context;
    private String address;
    public OnInterfaceListener mCallback;

    public ProductsAdapter(Context mActivity, ArrayList<WireModel> ordersModelArrayList) {
        super();
        this.context = mActivity;
        this.displayItems = ordersModelArrayList;

    }

    @NotNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_listings, parent, false);
        return new ProductsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NotNull final ProductsAdapter.ViewHolder holder, final int position) {
        final WireModel wireModel = displayItems.get(position);
        if (!(displayItems.size() >0)){
          //  holder.messages.setVisibility(View.VISIBLE);
        }
        else {

            holder.mItemName.setText(wireModel.getName());
            holder.mItemName.setText(wireModel.getName());
            holder.mQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mCheckInternetWithMultipleClicks()) {
                        holder.mQuantity.setVisibility(View.GONE);
                        holder.elegantNumberButton.setVisibility(View.VISIBLE);
                        holder.elegantNumberButton.setNumber("1");
                     //   mCallback.OnAddProduct(view, position, datum, holder.elegantNumberButton.getNumber(), holder);
                    }
                }
                //  mCallback.onAppliedCoupon(objLineItem.getId(),objLineItem.getCode(),objLineItem.getAmount());
            });
            holder.elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
                @Override
                public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                    if (mCheckInternetWithMultipleClicks()) {
                        holder.elegantNumberButton.setNumber(String.valueOf(newValue));
                      //  mCallback2.OnAddOrRepeat(view, position, datum, holder.elegantNumberButton.getNumber(), holder);
                    }
                    else {
                      //  sessionManager.checkLogin();
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return displayItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {
        TextView mItemName, mItemPrice; /*View cardView;*/
        Button mQuantity,complain_raise;
        ElegantNumberButton elegantNumberButton;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemName=itemView.findViewById(R.id.product_name);
            mQuantity = (Button) itemView.findViewById(R.id.quantity_btn);
            elegantNumberButton = itemView.findViewById(R.id.elegenty_quantity_btn);
            mItemPrice =(TextView)itemView.findViewById(R.id.item_price);
        }

    }

    public interface OnInterfaceListener {
        void onItemsClick(View view, int position);
    }
    private long mLastClickTime = 0;
    /*Classs to handle the net is connected or not oand multiple click*/
    private Boolean mCheckInternetWithMultipleClicks(){
        if (CheckInternet.isNetwork(context)) {
            /* if (sessionManager.isLoggedIn()) {*/
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                return false;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            return true;
            //  }
        }else {
            //do something, net is not connected
            Toast.makeText(context, "Connect to internet", Toast.LENGTH_SHORT).show();

        }

        return false;

    }

}