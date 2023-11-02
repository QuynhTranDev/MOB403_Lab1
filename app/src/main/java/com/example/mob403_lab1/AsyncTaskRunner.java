package com.example.mob403_lab1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AsyncTaskRunner extends AsyncTask<String, String, String> {

    private String resp;
    ProgressDialog progressDialog;
    TextView textView;
    EditText editText;
    Context context;

    public AsyncTaskRunner(TextView textView, EditText editText, Context context) {
        this.textView = textView;
        this.editText = editText;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(
                context, "ProgressDialog",
                "Wait for "+ editText.getText().toString() + " seconds"
        );
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        textView.setText(result);
    }

    @Override
    protected String doInBackground(String... params) {
        publishProgress("Sleeping...");
        try {
            int time = Integer.parseInt(params[0])*1000;
            Thread.sleep(time);
            resp = "Slept for "+ params[0] + " seconds";
        }
        catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        return resp;
    }
}
