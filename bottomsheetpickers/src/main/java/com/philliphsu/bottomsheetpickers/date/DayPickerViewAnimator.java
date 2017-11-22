package com.philliphsu.bottomsheetpickers.date;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewAnimator;

import com.philliphsu.bottomsheetpickers.R;

import static com.philliphsu.bottomsheetpickers.date.PagingDayPickerView.DAY_PICKER_INDEX;
import static com.philliphsu.bottomsheetpickers.date.PagingDayPickerView.MONTH_PICKER_INDEX;

/**
 * Parent of {@link PagingDayPickerView} and {@link MonthPickerView}.
 */
public final class DayPickerViewAnimator extends ViewAnimator {

    private final Animation mDayPickerInAnimation;
    private final Animation mDayPickerOutAnimation;
    private final Animation mMonthPickerInAnimation;
    private final Animation mMonthPickerOutAnimation;

    public DayPickerViewAnimator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDayPickerInAnimation = AnimationUtils.loadAnimation(context, R.anim.bsp_face_in);
        mDayPickerOutAnimation = AnimationUtils.loadAnimation(context, R.anim.bsp_fade_out);
        mMonthPickerInAnimation = AnimationUtils.loadAnimation(context, R.anim.bsp_face_in);
        mMonthPickerOutAnimation = AnimationUtils.loadAnimation(context, R.anim.bsp_fade_out);
    }

    @Override
    public void setDisplayedChild(int whichChild) {
        switch (whichChild) {
            case DAY_PICKER_INDEX:
                setInAnimation(mDayPickerInAnimation);
                setOutAnimation(mMonthPickerOutAnimation);
                break;
            case MONTH_PICKER_INDEX:
                setInAnimation(mMonthPickerInAnimation);
                setOutAnimation(mDayPickerOutAnimation);
                break;
        }
        super.setDisplayedChild(whichChild);
    }

    final void setDisplayedChild(int whichChild, boolean animate) {
        animate = false;
        if (animate) {
            setDisplayedChild(whichChild);
        } else {
            setInAnimation(null);
            setOutAnimation(null);
            super.setDisplayedChild(whichChild);
        }
    }
}
