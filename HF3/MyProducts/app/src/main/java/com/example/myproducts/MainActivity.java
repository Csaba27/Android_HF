package com.example.myproducts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView productCode;
    private TextView productName;
    private TextView productPrice;

    private Button btnShowProducts;
    private Button btnAddProduct;
    private Button btnCancel;
    private static Toast toast;

    ArrayList<Product> products = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView formText = findViewById(R.id.formText);
        formText.setText("New Product Form");

        productCode = findViewById(R.id.edtCode);
        productName = findViewById(R.id.edtName);
        productPrice = findViewById(R.id.edtPrice);

        btnAddProduct = findViewById(R.id.btnAddProduct);
        btnCancel = findViewById(R.id.btnReset);
        btnShowProducts = findViewById(R.id.btnShowProducts);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String code = productCode.getText().toString().trim();
                String name = productName.getText().toString().trim();
                String price = productPrice.getText().toString().trim();

                if (code.isEmpty()) {
                    showToast("Product code is empty!");
                    return;
                } else if (name.isEmpty()) {
                    showToast("Product name is empty!");
                    return;
                } else if (price.isEmpty()) {
                    showToast("Product price is empty!");
                    return;
                }

                if (!price.matches("^\\d+(\\.\\d{1,2})?$")) {
                    showToast("Wrong product price!");
                    return;
                }

                Product product = new Product(code, name, price);
                products.add(product);
                showToast("Product added!");
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productCode.setText("");
                productName.setText("");
                productPrice.setText("");

                showToast("Inputs deleted!");
            }
        });

        btnShowProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductListDialogFragment.newInstance(products).show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    private void showToast(String message) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}