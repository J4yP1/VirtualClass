// Generated by view binder compiler. Do not edit!
package com.example.trabalho_pmeu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.trabalho_pmeu.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final TextView btnRecover;

  @NonNull
  public final TextView btnRegister;

  private FragmentLoginBinding(@NonNull ScrollView rootView, @NonNull Button btnLogin,
      @NonNull TextView btnRecover, @NonNull TextView btnRegister) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.btnRecover = btnRecover;
    this.btnRegister = btnRegister;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLogin;
      Button btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.btnRecover;
      TextView btnRecover = ViewBindings.findChildViewById(rootView, id);
      if (btnRecover == null) {
        break missingId;
      }

      id = R.id.btnRegister;
      TextView btnRegister = ViewBindings.findChildViewById(rootView, id);
      if (btnRegister == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ScrollView) rootView, btnLogin, btnRecover, btnRegister);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
