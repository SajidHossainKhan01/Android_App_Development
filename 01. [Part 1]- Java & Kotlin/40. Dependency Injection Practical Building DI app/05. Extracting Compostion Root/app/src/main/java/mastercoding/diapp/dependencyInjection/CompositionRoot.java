package mastercoding.diapp.dependencyInjection;

import androidx.annotation.UiThread;

import mastercoding.diapp.common.Constants;
import mastercoding.diapp.networking.StackoverflowApi;
import mastercoding.diapp.questions.FetchQuestionDetailsUseCase;
import mastercoding.diapp.questions.FetchQuestionsListUseCase;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@UiThread
public class CompositionRoot {

    private Retrofit retrofit;
    private StackoverflowApi stackoverflowApi;

    @UiThread
    private Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    @UiThread
    private StackoverflowApi getStackoverflowApi(){
        if (stackoverflowApi == null){
            stackoverflowApi = getRetrofit().create(StackoverflowApi.class);
        }
        return stackoverflowApi;
    }

    @UiThread
    public FetchQuestionDetailsUseCase getfetchQuestionDetailsUseCase(){
        return new FetchQuestionDetailsUseCase(getStackoverflowApi());
    }

    @UiThread
    public FetchQuestionsListUseCase getfetchQuestionsListUseCase(){
        return new FetchQuestionsListUseCase(getStackoverflowApi());
    }
}
