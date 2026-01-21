package mastercoding.diapp;


import android.app.Application;

import androidx.annotation.UiThread;

import java.util.Stack;

import mastercoding.diapp.common.Constants;
import mastercoding.diapp.dependencyInjection.CompositionRoot;
import mastercoding.diapp.networking.StackoverflowApi;
import mastercoding.diapp.questions.FetchQuestionDetailsUseCase;
import mastercoding.diapp.questions.FetchQuestionsListUseCase;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {


    private CompositionRoot compositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        compositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot(){
        return compositionRoot;
    }
}
