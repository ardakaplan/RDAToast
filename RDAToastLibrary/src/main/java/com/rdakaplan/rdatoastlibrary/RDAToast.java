package com.rdakaplan.rdatoastlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.StringRes;

/**
 * Created by Arda Kaplan at 09-Apr-20
 * <p>
 * arda.kaplan09@gmail.com
 */

public class RDAToast {

    private RDAToast() {

    }

    /**
     * @param context   application context
     * @param messageID string id from R.string{@link StringRes}
     * @param duration  toast message duration
     */
    public static void info(Context context, @StringRes int messageID, int duration) {

        info(context, context.getString(messageID), duration);
    }

    /**
     * @param context  application context
     * @param message  toast message
     * @param duration toast message duration
     */
    public static void info(Context context, String message, int duration) {

        show(Type.INFO, context, message, duration);
    }

    /**
     * @param context   application context
     * @param messageID string id from R.string{@link StringRes}
     * @param duration  toast message duration
     */
    public static void error(Context context, @StringRes int messageID, int duration) {

        info(context, context.getString(messageID), duration);
    }

    /**
     * @param context  application context
     * @param message  toast message
     * @param duration toast message duration
     */
    public static void error(Context context, String message, int duration) {

        show(Type.ERROR, context, message, duration);
    }

    /**
     * @param type     toast message type
     * @param context  application context
     * @param message  toast message content
     * @param duration toast duration
     */
    private static void show(Type type, Context context, String message, int duration) {

        RDAToastConfig rdaToastConfig = RDAToastConfig.setup();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View toastLayout = inflater.inflate(R.layout.rda_toast_layout, null);

        TextView toastMessage = toastLayout.findViewById(R.id.rdaToastLayout_textView_message);

        //setting background
        toastLayout.findViewById(R.id.rdaToastLayout_linearLayout_root).setBackground(rdaToastConfig.getBackgroundDrawable(context, type));

        //setting icon
        if (rdaToastConfig.showIcons) {

            ((ImageView) toastLayout.findViewById(R.id.rdaToastLayout_imageView_icon)).setImageDrawable(rdaToastConfig.getIconDrawable(context, type));
        }

        toastMessage.setTextColor(rdaToastConfig.getTextColor(context, type));

        //setting text
        toastMessage.setText(message);

        Toast toast = new Toast(context);

        toast.setDuration(duration);

        toast.setView(toastLayout);

        toast.show();
    }

    protected enum Type {

        INFO,
        ERROR,
        SUCCESS,
        WARNING
    }
}
