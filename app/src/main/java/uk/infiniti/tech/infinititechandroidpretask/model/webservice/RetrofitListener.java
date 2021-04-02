package uk.infiniti.tech.infinititechandroidpretask.model.webservice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;
import uk.infiniti.tech.infinititechandroidpretask.model.LoginPostBody;
import uk.infiniti.tech.infinititechandroidpretask.model.UserResponse;

public interface RetrofitListener {
    @Headers("Module:JW9tc0ByZWRsdGQl")
    @POST
    Call<UserResponse> postLogin(@Url String url, @Body LoginPostBody loginPostBody);
}
