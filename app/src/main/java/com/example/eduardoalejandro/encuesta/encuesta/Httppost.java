package com.example.eduardoalejandro.encuesta.encuesta;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;

/**
 * Created by Saul on 17/01/2018.
 */

public class Httppost {

    public String post(String codigo, String respuesta, String sucursal, String origen, String factura){
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://acerosocotlan.mx/gao/webservice/encuesta/preguntas/guardar");

            //Mandar los datos
            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("codigo",codigo));
            params.add(new BasicNameValuePair("respuesta",respuesta));
            params.add(new BasicNameValuePair("sucursal",sucursal));
            params.add(new BasicNameValuePair("origen",origen));
            params.add(new BasicNameValuePair("factura",factura));
            httppost.setEntity(new UrlEncodedFormEntity(params));

            //Respuesta
            HttpResponse resp = httpclient.execute(httppost);
            HttpEntity ent = resp.getEntity();
            String text = EntityUtils.toString(ent);
            return text;
        }
        catch(Exception e) {
            return "ERROR";
        }
    }
    public String Telefono(String telefono, String sucursal){
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://acerosocotlan.mx/gao/webservice/encuesta/preguntas/enviarcorreo");

            //Mandar los datos
            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("telefono",telefono));
            params.add(new BasicNameValuePair("sucursal",sucursal));
            httppost.setEntity(new UrlEncodedFormEntity(params));

            //Respuesta
            HttpResponse resp = httpclient.execute(httppost);
            HttpEntity ent = resp.getEntity();
            String text = EntityUtils.toString(ent);
            return text;
        }
        catch(Exception e) {
            return "ERROR";
        }
    }
}
