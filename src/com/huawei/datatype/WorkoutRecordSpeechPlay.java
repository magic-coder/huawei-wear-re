package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class WorkoutRecordSpeechPlay {
    private int workout_record_speech_play_report_status;
    private int workout_record_speech_play_request_report;

    public int getWorkout_record_speech_play_request_report() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_speech_play_request_report))).intValue();
    }

    public void setWorkout_record_speech_play_request_report(int i) {
        this.workout_record_speech_play_request_report = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_record_speech_play_report_status() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_speech_play_report_status))).intValue();
    }

    public void setWorkout_record_speech_play_report_status(int i) {
        this.workout_record_speech_play_report_status = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
