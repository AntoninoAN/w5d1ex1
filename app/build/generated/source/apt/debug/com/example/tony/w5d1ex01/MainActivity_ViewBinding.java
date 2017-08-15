// Generated code from Butter Knife. Do not modify!
package com.example.tony.w5d1ex01;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131427424;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.et_input_value = Utils.findRequiredViewAsType(source, R.id.et_input, "field 'et_input_value'", EditText.class);
    target.tv_result_value = Utils.findRequiredViewAsType(source, R.id.tv_result, "field 'tv_result_value'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_send_service, "method 'sendWorkToService'");
    view2131427424 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.sendWorkToService();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.et_input_value = null;
    target.tv_result_value = null;

    view2131427424.setOnClickListener(null);
    view2131427424 = null;
  }
}
