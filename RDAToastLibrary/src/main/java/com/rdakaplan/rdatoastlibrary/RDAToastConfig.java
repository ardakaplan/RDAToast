package com.rdakaplan.rdatoastlibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

/**
 * Created by Arda Kaplan at 09-Apr-20
 * <p>
 * arda.kaplan09@gmail.com
 */
public final class RDAToastConfig {

    //BACKGROUND DRAWABLES
    protected @DrawableRes
    Integer infoBackgroundDrawable = R.drawable.rda_toast_background_info;
    protected @DrawableRes
    Integer errorBackgroundDrawable = R.drawable.rda_toast_background_error;
    protected @DrawableRes
    Integer warningBackgroundDrawable = R.drawable.rda_toast_background_warning;
    protected @DrawableRes
    Integer successBackgroundDrawable = R.drawable.rda_toast_background_success;

    protected @ColorInt
    Integer infoTextColor = Color.WHITE;
    protected @ColorInt
    Integer errorTextColor = Color.WHITE;
    protected @ColorInt
    Integer warningTextColor = Color.WHITE;
    protected @ColorInt
    Integer successTextColor = Color.WHITE;

    protected @DrawableRes
    Integer infoIconDrawable = R.drawable.rda_toast_xml_icon_info;
    protected @DrawableRes
    Integer errorIconDrawable = R.drawable.rda_toast_xml_icon_error;
    protected @DrawableRes
    Integer warningIconDrawable = R.drawable.rda_toast_xml_icon_warning;
    protected @DrawableRes
    Integer successIconDrawable = R.drawable.rda_toast_xml_icon_success;

    protected boolean showIcons = true;

    private static RDAToastConfig INSTANCE;

    private RDAToastConfig() {

    }

    public static RDAToastConfig setup() {

        if (INSTANCE == null) {

            INSTANCE = new RDAToastConfig();
        }

        return INSTANCE;
    }


    public RDAToastConfig setInfoBackgroundDrawable(@DrawableRes Integer infoBackgroundDrawable) {

        this.infoBackgroundDrawable = infoBackgroundDrawable;

        return this;
    }

    public RDAToastConfig setErrorBackgroundDrawable(@DrawableRes Integer errorBackgroundDrawable) {

        this.errorBackgroundDrawable = errorBackgroundDrawable;

        return this;
    }

    public RDAToastConfig setWarningBackgroundDrawable(@DrawableRes Integer warningBackgroundDrawable) {

        this.warningBackgroundDrawable = warningBackgroundDrawable;

        return this;
    }

    public RDAToastConfig setSuccessBackgroundDrawable(@DrawableRes Integer successBackgroundDrawable) {

        this.successBackgroundDrawable = successBackgroundDrawable;

        return this;
    }

    public RDAToastConfig setInfoTextColor(@ColorInt Integer infoTextColor) {

        this.infoTextColor = infoTextColor;

        return this;
    }

    public RDAToastConfig setErrorTextColor(@ColorInt Integer errorTextColor) {

        this.errorTextColor = errorTextColor;

        return this;
    }

    public RDAToastConfig setWarningTextColor(@ColorInt Integer warningTextColor) {

        this.warningTextColor = warningTextColor;

        return this;
    }

    public RDAToastConfig setSuccessTextColor(@ColorInt Integer successTextColor) {

        this.successTextColor = successTextColor;

        return this;
    }

    public RDAToastConfig setInfoIconDrawable(Integer infoIconDrawable) {

        this.infoIconDrawable = infoIconDrawable;

        return this;
    }

    public RDAToastConfig setErrorIconDrawable(Integer errorIconDrawable) {

        this.errorIconDrawable = errorIconDrawable;

        return this;
    }

    public RDAToastConfig setWarningIconDrawable(Integer warningIconDrawable) {

        this.warningIconDrawable = warningIconDrawable;

        return this;
    }

    public RDAToastConfig setSuccessIconDrawable(Integer successIconDrawable) {

        this.successIconDrawable = successIconDrawable;

        return this;
    }

    /**
     * @param showIcons enable showing icons, default is true
     */
    public RDAToastConfig setShowIcons(boolean showIcons) {

        this.showIcons = showIcons;

        return this;
    }

    protected Drawable getIconDrawable(Context context, RDAToast.Type type) {

        @DrawableRes Integer drawableId = 0;

        switch (type) {

            case INFO:

                if (infoIconDrawable == null) {

                    drawableId = R.drawable.rda_toast_xml_icon_info;

                } else {

                    drawableId = infoIconDrawable;
                }

                break;

            case ERROR:

                if (errorIconDrawable == null) {

                    drawableId = R.drawable.rda_toast_xml_icon_error;

                } else {

                    drawableId = errorIconDrawable;
                }

                break;

            case SUCCESS:

                if (successIconDrawable == null) {

                    drawableId = R.drawable.rda_toast_xml_icon_success;

                } else {

                    drawableId = successIconDrawable;
                }

                break;

            case WARNING:

                if (warningIconDrawable == null) {

                    drawableId = R.drawable.rda_toast_xml_icon_warning;

                } else {

                    drawableId = warningIconDrawable;
                }

                break;
        }

        return ContextCompat.getDrawable(context, drawableId);
    }

    protected Drawable getBackgroundDrawable(Context context, RDAToast.Type type) {

        @DrawableRes Integer drawableId = 0;

        switch (type) {

            case INFO:

                if (infoBackgroundDrawable == null) {

                    drawableId = R.drawable.rda_toast_background_info;

                } else {

                    drawableId = infoBackgroundDrawable;
                }

                break;

            case ERROR:

                if (infoBackgroundDrawable == null) {

                    drawableId = R.drawable.rda_toast_background_error;

                } else {

                    drawableId = errorBackgroundDrawable;
                }

                break;

            case SUCCESS:

                if (infoBackgroundDrawable == null) {

                    drawableId = R.drawable.rda_toast_background_success;

                } else {

                    drawableId = successBackgroundDrawable;
                }

                break;

            case WARNING:

                if (infoBackgroundDrawable == null) {

                    drawableId = R.drawable.rda_toast_background_warning;

                } else {

                    drawableId = warningBackgroundDrawable;
                }

                break;
        }

        return ContextCompat.getDrawable(context, drawableId);
    }

    protected @ColorInt
    Integer getTextColor(Context context, RDAToast.Type type) {

        @ColorInt Integer color = 0;

        switch (type) {

            case INFO:

                color = infoTextColor;

                break;

            case ERROR:

                color = errorTextColor;

                break;

            case SUCCESS:

                color = successTextColor;

                break;

            case WARNING:

                color = warningTextColor;

                break;

        }

        if (color != null) {

            return color;

        } else {

            return ContextCompat.getColor(context, R.color.rda_toast_default_text_color);
        }
    }
}
