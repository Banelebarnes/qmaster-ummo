package com.heinrichreimersoftware.singleinputform.steps;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;

import com.erz.timepicker_library.TimePicker;
import com.heinrichreimersoftware.singleinputform.R;

import java.util.Date;

/**
 * Created by barnes on 7/21/16.
 */
public class TimePickerStep extends Step
{
    public static final String DATA_CHECKED = "data_checked";
    private int mTextResId;
    private String mText;
    private StepChecker mChecker;
    private int mTextColor;

    private int mMin;
    private int mMax;

    public TimePickerStep(Context context, String dataKey, int min, int max, String title, String error, String details, StepChecker checker) {
        super(context, dataKey, title, error, details);
        mChecker = checker;
        mMin = min;
        mMax = max;
    }

    public TimePickerStep(Context context, String dataKey, int min, int max, int titleResId, int errorResId, int detailsResId, StepChecker checker) {
        super(context, dataKey, titleResId, errorResId, detailsResId);
        mChecker = checker;
        mMin = min;
        mMax = max;
    }

    @Override
    public FrameLayout onCreateView() {
        //loadTheme();
        FrameLayout layout = (FrameLayout) View.inflate(getContext(), R.layout.view_time_picker, null);
        TimePicker timePicker = (TimePicker) layout.findViewById(R.id.timePicker);
        timePicker.setColor(Color.BLUE);

        //Set Dial Color
        timePicker.setDialColor(Color.RED);

        //Set Clock Color
        timePicker.setClockColor(Color.GREEN);

        //Set Text Color
        timePicker.setTextColor(Color.YELLOW);

        //Disable Touch
        timePicker.disableTouch(true);

        //Enable Twenty Four Hour Clock
        timePicker.enableTwentyFourHour(true);

        //Set Time
        timePicker.setTime(new Date());

        //Get Time
        timePicker.getTime();

        //Set OnTimeChangedListener
        timePicker.setTimeChangedListener((TimePicker.OnTimeChangedListener) this);
        return layout;

    }

    //OnTimeChangeListener Interface
    public static interface OnTimeChangedListener {
        public void timeChanged(Date date);
    }

    @Override
    public void updateView(boolean lastStep) {

    }

    @Override
    public boolean check() {
        return false;
    }

    @Override
    protected void onSave() {
    }

    @Override
    protected void onRestore() {
    }

    public interface StepChecker{
        boolean check(int progress);
    }
}
