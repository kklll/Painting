package com.deep.util;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UploadUtil {
    private static final String url = "http://deepblue.datsec.cn:8003/upload/";
    private static final OkHttpClient client = new OkHttpClient();

    public static int uploadFile(File file) throws Exception {
        RequestBody requestbody = RequestBody.create(MediaType.parse("image/jpeg"), file);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), requestbody)
                .build();
        Request request=new Request.Builder().url(url).post(requestBody).build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            return 0;
        } else return 1;
    }
}
