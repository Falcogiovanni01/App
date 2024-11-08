package com.example.gym;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class BlankFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage(getString(R.string.PulleyDescription))
                .setPositiveButton(getString(R.string.click_me), (dialog, which) -> {} )
                .create();
    }

    public static String TAG = "PurchaseConfirmationDialog";
}