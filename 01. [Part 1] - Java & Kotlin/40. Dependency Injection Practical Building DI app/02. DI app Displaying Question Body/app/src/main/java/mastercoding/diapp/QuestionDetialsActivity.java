package mastercoding.diapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import java.util.Stack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionDetialsActivity extends AppCompatActivity implements Callback<SingleQuestionResponseSchema> {

    public static void start(Context context, String questionId){
        Intent i = new Intent(context, QuestionDetialsActivity.class);
        i.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(i);
    }

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";
    private TextView mTXTQuestionBody;
    private StackoverflowApi stackoverflowApi;
    private String mQuestionId;
    private Call<SingleQuestionResponseSchema> mCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detials);

        mTXTQuestionBody = findViewById(R.id.txt_question_body);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        stackoverflowApi = retrofit.create(StackoverflowApi.class);

        mQuestionId = getIntent().getExtras().getString(EXTRA_QUESTION_ID);

    }


    @Override
    protected void onStart() {
        super.onStart();
        mCall = stackoverflowApi.questionDetails(mQuestionId);
        mCall.enqueue( this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mCall != null){
            mCall.cancel();
        }
    }

    @Override
    public void onResponse(Call<SingleQuestionResponseSchema> call, Response<SingleQuestionResponseSchema> response) {
        SingleQuestionResponseSchema questionResponseSchema;

        if (response.isSuccessful() && (questionResponseSchema = response.body()) != null){

            String questionBody = questionResponseSchema.getQuestions().getmBody();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                mTXTQuestionBody.setText(Html.fromHtml(questionBody,Html.FROM_HTML_MODE_LEGACY));
            }else{
                mTXTQuestionBody.setText(Html.fromHtml(questionBody));
            }
        }
        else{
            onFailure(call, null);
        }
    }

    @Override
    public void onFailure(Call<SingleQuestionResponseSchema> call, Throwable t) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(ServerErrorDialogFragment.newInstance(), null)
                .commitAllowingStateLoss();

    }
}



