package com.example.myproducts;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myproducts.databinding.FragmentItemListDialogListDialogItemBinding;
import com.example.myproducts.databinding.FragmentItemListDialogListDialogBinding;

/*
  <p>A fragment that shows a list of items as a modal bottom sheet.</p>
  <p>You can show this modal bottom sheet from your activity like this:</p>
  <pre>
      ProductListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
  </pre>
*/
import java.util.ArrayList;

public class ProductListDialogFragment extends BottomSheetDialogFragment {

    private static final String ARG_PRODUCT_LIST = "product_list";
    private FragmentItemListDialogListDialogBinding binding;
    private ArrayList<Product> products;

    public static ProductListDialogFragment newInstance(ArrayList<Product> productList) {
        final ProductListDialogFragment fragment = new ProductListDialogFragment();
        final Bundle args = new Bundle();
        args.putSerializable(ARG_PRODUCT_LIST, productList);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentItemListDialogListDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            products = (ArrayList<Product>) getArguments().getSerializable(ARG_PRODUCT_LIST);
        }

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ProductAdapter(products));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView text;

        ViewHolder(FragmentItemListDialogListDialogItemBinding binding) {
            super(binding.getRoot());
            text = binding.text;
        }
    }

    private static class ProductAdapter extends RecyclerView.Adapter<ViewHolder> {

        private final ArrayList<Product> mProducts;

        ProductAdapter(ArrayList<Product> products) {
            mProducts = products;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(FragmentItemListDialogListDialogItemBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Product product = mProducts.get(position);
            holder.text.setText(product.toString()); // Display product name and price
        }

        @Override
        public int getItemCount() {
            return mProducts.size();
        }
    }
}
